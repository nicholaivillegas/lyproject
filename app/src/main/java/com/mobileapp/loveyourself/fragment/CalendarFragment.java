package com.mobileapp.loveyourself.fragment;

import android.content.DialogInterface;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mobileapp.loveyourself.R;
import com.mobileapp.loveyourself.Reservation;
import com.mobileapp.loveyourself.UserInfo;
import com.mobileapp.loveyourself.dialog.FactorDialog;
import com.mobileapp.loveyourself.dialog.ReservationDialog;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Date;

public class CalendarFragment extends Fragment {

    MaterialCalendarView calendarView;
    private DatabaseReference mDatabase;
    private DatabaseReference myRef;
    private ChildEventListener ref;
    private Reservation model;
    private Date dateSelected;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        calendarView = (MaterialCalendarView) view.findViewById(R.id.calendarView);
        loadFields();


        calendarView.setSelectionMode(MaterialCalendarView.SELECTION_MODE_MULTIPLE);

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
                            final int year = Integer.parseInt(model.getTestingDateYear());
                            final int month = Integer.parseInt(model.getTestingDateMonth());
                            final int day = Integer.parseInt(model.getTestingDateDay());
                            Date date = new Date(year - 1900, month, day);
                            calendarView.setDateSelected(date, true);
                            calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
                                @Override
                                public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull final CalendarDay date, boolean selected) {
                                    if ((date.getYear() == year) && (date.getMonth() == month) && (date.getDay() == day)) {
                                        Toast.makeText(getContext(), "SAKTO", Toast.LENGTH_SHORT).show();
                                        calendarView.setSelectedDate(date);
                                    } else {
                                        calendarView.setDateSelected(date, false);
                                    }
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
                            });
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

}
