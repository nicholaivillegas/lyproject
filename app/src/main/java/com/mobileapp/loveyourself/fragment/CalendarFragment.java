package com.mobileapp.loveyourself.fragment;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.orangegangsters.lollipin.lib.managers.AppLock;
import com.github.orangegangsters.lollipin.lib.managers.LockManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mobileapp.loveyourself.CustomPinActivity;
import com.mobileapp.loveyourself.Factors;
import com.mobileapp.loveyourself.MainActivity;
import com.mobileapp.loveyourself.R;
import com.mobileapp.loveyourself.Reservation;
import com.mobileapp.loveyourself.dialog.FactorDialog;
import com.mobileapp.loveyourself.dialog.FactorViewDialog;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

public class CalendarFragment extends Fragment {


    @BindView(R.id.circleImageView)
    CircleImageView circleImageView;
    @BindView(R.id.text_reservation)
    TextView textReservation;
    @BindView(R.id.text_reservation1)
    TextView textReservation1;
    @BindView(R.id.card_reservation)
    CardView cardReservation;
    @BindView(R.id.circleImageView_factor)
    CircleImageView circleImageViewFactor;
    @BindView(R.id.text_factor)
    TextView textFactor;
    @BindView(R.id.text_factor1)
    TextView textFactor1;
    @BindView(R.id.card_factor)
    CardView cardFactor;
    Unbinder unbinder;
    @BindView(R.id.calendarView)
    MaterialCalendarView calendarView;
    @BindView(R.id.button_call)
    Button buttonCall;
    @BindView(R.id.button_directions)
    Button buttonDirections;
    private Date dateSelected;
    private DatabaseReference mDatabase;
    private DatabaseReference myRef;
    private ChildEventListener ref;
    private Reservation model;

    private DatabaseReference mDatabaseFactors;
    private DatabaseReference myRefFactors;
    private ChildEventListener refFactors;
    private Factors modelFactors;

    private int selectedYear;
    private int selectedMonth;
    private int selectedDay;
    FactorViewDialog factorViewDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        calendarView = (MaterialCalendarView) view.findViewById(R.id.calendarView);
        loadFields();
        loadFactors();
        calendarView.setSelectionMode(MaterialCalendarView.SELECTION_MODE_MULTIPLE);
        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull final CalendarDay date, boolean selected) {
                if (!selected) {
                    calendarView.setSelectedDate(date);
                    factorViewDialog = new FactorViewDialog();
                    Bundle args = new Bundle();
                    args.putString("year", String.valueOf(date.getYear()));
                    args.putString("month", String.valueOf(date.getMonth()));
                    args.putString("day", String.valueOf(date.getDay()));
                    factorViewDialog.setArguments(args);
                    factorViewDialog.show(getActivity().getFragmentManager(), "Factor View Dialog");
                } else {
                    calendarView.setDateSelected(date, false);
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case DialogInterface.BUTTON_POSITIVE:
                                    FactorDialog factorDialog = new FactorDialog();
                                    Bundle args = new Bundle();
                                    args.putString("year", String.valueOf(date.getYear()));
                                    args.putString("month", String.valueOf(date.getMonth()));
                                    args.putString("day", String.valueOf(date.getDay()));
                                    factorDialog.setArguments(args);
                                    factorDialog.show(getActivity().getFragmentManager(), "Factor Dialog");
                                    dialog.dismiss();
                                    break;

                                case DialogInterface.BUTTON_NEGATIVE:
                                    //No button clicked
                                    break;
                            }
                        }
                    };
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("Do you want to add an activity?").setPositiveButton("Yes", dialogClickListener)
                            .setNegativeButton("No", dialogClickListener).show();
                }
                loadFields();
                loadFactors();
            }
        });
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private void loadFields() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("reservations");
        mDatabase = FirebaseDatabase.getInstance().getReference();
        ref = myRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                if (dataSnapshot != null && dataSnapshot.getValue() != null) {
                    try {
                        model = dataSnapshot.getValue(Reservation.class);
                        if (model.getId().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
                            cardReservation.setVisibility(View.VISIBLE);
                            textReservation.setText("Reservation @ " + model.getTestingLocation());
                            textReservation1.setText("Date: " + model.getTestingDateYear() + "/" + model.getTestingDateMonth() + "/" + model.getTestingDateDay());
                            final int year = Integer.parseInt(model.getTestingDateYear());
                            final int month = Integer.parseInt(model.getTestingDateMonth());
                            final int day = Integer.parseInt(model.getTestingDateDay());

                            selectedYear = year;
                            selectedMonth = month;
                            selectedDay = day;
//                            Date date = new Date(year - 1900, month, day);
//                            calendarView.setDateSelected(date, true);

                        }
                    } catch (Exception ex) {
                        Log.e("RAWR", ex.getMessage());
                    }
                }
            }

            // This function is called each time a child item is removed.
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG:", "Failed to read value.", error.toException());
            }
        });
    }

    private void loadFactors() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRefFactors = database.getReference("factors");
        mDatabaseFactors = FirebaseDatabase.getInstance().getReference();
        refFactors = myRefFactors.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                if (dataSnapshot != null && dataSnapshot.getValue() != null) {
                    try {
                        modelFactors = dataSnapshot.getValue(Factors.class);
                        Date date = new Date();
                        if (modelFactors.getId().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
//                            cardFactor.setVisibility(View.VISIBLE);
//                            textFactor.setText("Activity");
//                            textFactor1.setText("Click here for more...");
                            final int year = Integer.parseInt(modelFactors.getDateRecordedYear());
                            final int month = Integer.parseInt(modelFactors.getDateRecordedMonth());
                            final int day = Integer.parseInt(modelFactors.getDateRecordedDate());
                            selectedYear = year;
                            selectedMonth = month;
                            selectedDay = day;
                            date = new Date(year - 1900, month, day);
                            calendarView.setDateSelected(date, true);
                            calendarView.setSelectionColor(R.color.colorPrimary);
                        } else
                            calendarView.setDateSelected(date, false);
                    } catch (Exception ex) {
                        Log.e("RAWR", ex.getMessage());
                    }
                }
            }

            // This function is called each time a child item is removed.
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG:", "Failed to read value.", error.toException());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.card_reservation, R.id.card_factor, R.id.button_call, R.id.button_directions})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.card_reservation:
                //LOAD DETAILS
                break;
            case R.id.card_factor:
                FactorViewDialog factorDialog = new FactorViewDialog();
//                Bundle args = new Bundle();
//                args.putString("year", String.valueOf(date.getYear()));
//                factorDialog.setArguments(args);
                factorDialog.show(getActivity().getFragmentManager(), "Factor View Dialog");
                break;
            case R.id.button_call:
                if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            0);
                } else {
                    if (textReservation.getText().toString().contains("Anglo")) {
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "09153665683"));
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "022569384"));
                        startActivity(intent);
                    }
                }

                break;
            case R.id.button_directions:
                if (textReservation.getText().toString().contains("Anglo")) {
                    try {
                        // Launch Waze to look for Hawaii:
                        String url = "https://waze.com/ul?q=Anglo love yourself";
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                    } catch (ActivityNotFoundException ex) {
                        // If Waze is not installed, open it in Google Play:
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.waze"));
                        startActivity(intent);
                    }
                } else {
                    try {
                        // Launch Waze to look for Hawaii:
                        String url = "https://waze.com/ul?q=Uni love yourself";
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                    } catch (ActivityNotFoundException ex) {
                        // If Waze is not installed, open it in Google Play:
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.waze"));
                        startActivity(intent);
                    }
                }
                break;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        PowerManager pm = (PowerManager) getActivity().getSystemService(Context.POWER_SERVICE);

        boolean screenOn;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            screenOn = pm.isInteractive();
        } else {
            screenOn = pm.isScreenOn();
        }

        if (screenOn) {
            LockManager<CustomPinActivity> lockManager = LockManager.getInstance();
            lockManager.disableAppLock();
        } else {
            Intent intent = new Intent(getContext(), CustomPinActivity.class);
            intent.putExtra(AppLock.EXTRA_TYPE, AppLock.UNLOCK_PIN);
            startActivity(intent);
        }
    }

}
