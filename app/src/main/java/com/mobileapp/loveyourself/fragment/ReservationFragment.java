package com.mobileapp.loveyourself.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.github.orangegangsters.lollipin.lib.managers.LockManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobileapp.loveyourself.CustomPinActivity;
import com.mobileapp.loveyourself.LoginActivity;
import com.mobileapp.loveyourself.MainActivity;
import com.mobileapp.loveyourself.R;
import com.mobileapp.loveyourself.Reservation;
import com.mobileapp.loveyourself.UserInfo;
import com.mobileapp.loveyourself.dialog.ReservationDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ReservationFragment extends Fragment implements View.OnClickListener {

    private RadioGroup radioGroupBranch;
    private RadioButton radioBranchAnglo, radioBranchUni;
    private DatePicker datepicker;
    private Button buttonSubmit;
    private CheckBox checkReminder;

    public String id;
    public String timestamp;
    public String testingLocation;
    public String testingDate;
    public String other;
    public String extra;

    private DatabaseReference mDatabase;
    private DatabaseReference myRef;
    private ChildEventListener ref;

    private DatabaseReference mDatabase2;
    private DatabaseReference myRef2;
    private ChildEventListener ref2;
    private int count = 0;

    private String firstName, lastName, location, number, email, age, gender;

    UserInfo model;
    Reservation model2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reservation, container, false);
        buttonSubmit = (Button) view.findViewById(R.id.button_submit);
        radioGroupBranch = (RadioGroup) view.findViewById(R.id.radio_group_branch);
        radioBranchAnglo = (RadioButton) view.findViewById(R.id.radio_branch_anglo);
        radioBranchUni = (RadioButton) view.findViewById(R.id.radio_branch_uni);
        datepicker = (DatePicker) view.findViewById(R.id.datepicker);
        checkReminder = (CheckBox) view.findViewById(R.id.check_reminder);
        buttonSubmit.setOnClickListener(this);
        radioBranchAnglo.setOnClickListener(this);
        radioBranchUni.setOnClickListener(this);

        datepicker.setMinDate(System.currentTimeMillis() - 1000);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadFields();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_submit:
                if (buttonSubmit.getText().equals("BACK")) {
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                if (testingLocation != null && checkReminder.isChecked()) {
                    if (count < 35) {
                        buttonSubmit.setText("BACK");
                        getFieldsInformation();
                        try {
                            saveProfile();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        countEntries();
//                    createCalendar();
                        buttonSubmit.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        buttonSubmit.setTextColor(getResources().getColor(R.color.colorAccent));
                        createDialog("Reservation Successful!");
                    } else {
                        Toast.makeText(getContext(), "Too many reservations. Please contact Love Yourself Administrator", Toast.LENGTH_SHORT).show();
                    }
                } else if (testingLocation == null) {
                    createDialog("Select Testing Location!");
                    return;
                } else {
                    createDialog("Please Read Reminders!");
                    return;
                }
                break;

            case R.id.radio_branch_anglo:
                testingLocation = "Anglo";
                break;
            case R.id.radio_branch_uni:
                testingLocation = "Uni";
                break;
        }

    }

    private void getFieldsInformation() {
        Long tsLong = System.currentTimeMillis() / 1000;
        timestamp = tsLong.toString();
        testingDate = String.valueOf(datepicker.getYear()) + "," + String.valueOf(datepicker.getMonth() + 1) + "," + String.valueOf(datepicker.getDayOfMonth());
    }

    private void saveProfile() throws ParseException {
        Calendar mydate = new GregorianCalendar();
        Date thedate = new SimpleDateFormat("M-dd-yyyy", Locale.ENGLISH).parse(age);

        mydate.setTime(thedate);

        Calendar datenow = new GregorianCalendar();
        datenow.getTime();

        String ageNow = String.valueOf(datenow.get(java.util.Calendar.YEAR) - mydate.get(java.util.Calendar.YEAR));
        Reservation reservation = new Reservation(
                FirebaseAuth.getInstance().getCurrentUser().getUid(),
                timestamp,
                firstName,
                lastName,
                location,
                number,
                email,
                testingLocation,
                String.valueOf(datepicker.getYear()), String.valueOf(datepicker.getMonth() + 1), String.valueOf(datepicker.getDayOfMonth()),
                other,
                extra,
                ageNow,
                gender);
        mDatabase.child("reservations").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(reservation);
    }

    public void createCalendar() {
        Calendar beginTime = Calendar.getInstance();
        beginTime.set(datepicker.getYear(), datepicker.getMonth(), datepicker.getDayOfMonth(), 0, 0);
        Calendar endTime = Calendar.getInstance();
        endTime.set(datepicker.getYear(), datepicker.getMonth(), datepicker.getDayOfMonth(), 12, 30);
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                .putExtra(CalendarContract.Events.TITLE, "Love Yourself Appointment")
                .putExtra(CalendarContract.Events.DESCRIPTION, "Love Yourself Appointment at " + testingLocation)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "Love Yourself")
                .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
                .putExtra(Intent.EXTRA_EMAIL, "francistancapstone@gmail.com");
        startActivity(intent);
    }

    private void loadFields() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("users");
        mDatabase = FirebaseDatabase.getInstance().getReference();
        ref = myRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                if (dataSnapshot != null && dataSnapshot.getValue() != null) {
                    try {
                        model = dataSnapshot.getValue(UserInfo.class);
                        if (model.getId().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
//                            Toast.makeText(getContext(), model.getFirstName(), Toast.LENGTH_LONG).show();
                            firstName = model.getFirstName();
                            lastName = model.getLastName();
                            location = model.getLocation();
                            number = model.getNumber();
                            email = model.getEmail();
                            age = model.getBirthdate();


                            gender = model.getGender();
//                            editFname.setText(model.getFirstName());
//                            editLname.setText(model.getLastName());
//                            editCityResidence.setText(model.getLocation());

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

    public void createDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void countEntries() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef2 = database.getReference("reservations");
        mDatabase2 = FirebaseDatabase.getInstance().getReference();

        myRef2.addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                // TODO: show the count in the UI
                count = 0;
                if (dataSnapshot != null && dataSnapshot.getValue() != null) {
                    try {
                        model2 = dataSnapshot.getValue(Reservation.class);
                        if (model2.getId().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
                            count = count + 1;
                        }
                    } catch (Exception ex) {
                        Log.e("RAWR", ex.getMessage());
                    }
                }
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

}