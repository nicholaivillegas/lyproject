package com.mobileapp.loveyourself.dialog;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mobileapp.loveyourself.Factors;
import com.mobileapp.loveyourself.R;
import com.mobileapp.loveyourself.Reservation;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by john.villegas on 05/08/2017.
 */

public class FactorDialog extends DialogFragment {

    @BindView(R.id.check_receptive)
    CheckBox checkReceptive;
    @BindView(R.id.check_accidental)
    CheckBox checkAccidental;
    @BindView(R.id.check_shared)
    CheckBox checkShared;
    @BindView(R.id.check_intravenous)
    CheckBox checkIntravenous;
    @BindView(R.id.check_received)
    CheckBox checkReceived;
    @BindView(R.id.check_insertive)
    CheckBox checkInsertive;
    @BindView(R.id.check_oral)
    CheckBox checkOral;
    @BindView(R.id.button_submit)
    Button buttonSubmit;
    Unbinder unbinder;

    private int daysExposure;
    private int year;
    private int month;
    private int day;
    private String description = "";

    private DatabaseReference mDatabase;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_factors, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setDialogWindow();
        year = Integer.parseInt(getArguments().getString("year"));
        month = Integer.parseInt(getArguments().getString("month"));
        day = Integer.parseInt(getArguments().getString("day"));
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    private void setDialogWindow() {
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = LinearLayout.LayoutParams.MATCH_PARENT;
        params.height = View.MeasureSpec.UNSPECIFIED;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.dialog_corner);
        getDialog().getWindow().setDimAmount(0.8f);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogAnimationFromBottom;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @OnClick(R.id.button_submit)
    public void onViewClicked() {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        checkExposure();

                        saveProfile();

                        Calendar beginTime = Calendar.getInstance();
                        beginTime.set(year, month, day, 0, 0);
                        Calendar endTime = Calendar.getInstance();
                        endTime.set(year, month, day + daysExposure, 12, 30);
                        Intent intent = new Intent(Intent.ACTION_INSERT)
                                .setData(CalendarContract.Events.CONTENT_URI)
                                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                                .putExtra(CalendarContract.Events.TITLE, "Love Yourself Appointment")
                                .putExtra(CalendarContract.Events.DESCRIPTION, description)
                                .putExtra(CalendarContract.Events.EVENT_LOCATION, "Love Yourself")
                                .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
                                .putExtra(Intent.EXTRA_EMAIL, "francistancapstone@gmail.com");
                        startActivity(intent);

                        dismiss();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };
        checkExposure();

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Do you want to have another testing within " + String.valueOf(daysExposure) + " days?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }

    //    String id,
//    String dateRecorded,
//    String description,
//    String checkReceptive,
//    String checkAccidental,
//    String checkShared,
//    String checkIntravenous,
//    String checkReceived,
//    String checkInsertive,
//    String checkOral,
//    String other
    private void saveProfile() {
        Long tsLong = System.currentTimeMillis() / 1000;
        String timestamp = tsLong.toString();
        Factors factors = new Factors(FirebaseAuth.getInstance().getCurrentUser().getUid(),
                String.valueOf(year),
                String.valueOf(month),
                String.valueOf(day),
                description,
                String.valueOf(checkReceptive.isChecked()),
                String.valueOf(checkAccidental.isChecked()),
                String.valueOf(checkShared.isChecked()),
                String.valueOf(checkIntravenous.isChecked()),
                String.valueOf(checkReceived.isChecked()),
                String.valueOf(checkInsertive.isChecked()),
                String.valueOf(checkOral.isChecked()),
                "");
        mDatabase.child("factors").child(String.valueOf(timestamp)).setValue(factors);
        Toast.makeText(getActivity(), "Saved", Toast.LENGTH_LONG).show();
    }

    public void checkExposure() {
        daysExposure = 90;
        if (checkReceptive.isChecked()) {
            daysExposure = 10;
            description = description + "Receptive Anal/ Vaginal Sex Without Protectio \n";
        }
        if (checkAccidental.isChecked()) {
            daysExposure = 10;
            description = description + "Accidental Needle Prick \n";
        }
        if (checkShared.isChecked()) {
            daysExposure = 10;
            description = description + "Shared Needle\n";
        }
        if (checkIntravenous.isChecked()) {
            daysExposure = 10;
            description = description + "Intravenous Drug Use\n";
        }
        if (checkReceived.isChecked()) {
            daysExposure = 10;
            description = description + "Received Blood Transfusion\n";
        }
        if (checkInsertive.isChecked()) {
            daysExposure = 60;
            description = description + "Insertive Anal/ Vaginal Sex with Protection\n";
        }
        if (checkOral.isChecked()) {
            daysExposure = 60;
            description = description + "Receptive / Insertive Oral Sex";
        }
    }
}
