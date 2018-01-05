package com.mobileapp.loveyourself.dialog;

import android.app.DialogFragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mobileapp.loveyourself.Factors;
import com.mobileapp.loveyourself.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by john.villegas on 05/08/2017.
 */

public class FactorViewDialog extends DialogFragment {

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
    @BindView(R.id.check_oral)
    CheckBox checkOral;
    @BindView(R.id.button_submit)
    Button buttonSubmit;
    Unbinder unbinder;
    @BindView(R.id.text_label)
    TextView textLabel;
    @BindView(R.id.check_oral_low)
    CheckBox checkOralLow;
    @BindView(R.id.check_receptive_low)
    CheckBox checkReceptiveLow;

    private String id;
    Factors model;

    private int year;
    private int month;
    private int day;

    FirebaseDatabase database;
    private DatabaseReference myRef1;
    private DatabaseReference mDatabase1;
    private ChildEventListener ref1;

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
        checkReceptive.setClickable(false);
        checkAccidental.setClickable(false);
        checkShared.setClickable(false);
        checkIntravenous.setClickable(false);
        checkReceived.setClickable(false);
        checkOral.setClickable(false);
        checkOralLow.setClickable(false);
        checkReceptiveLow.setClickable(false);
        buttonSubmit.setVisibility(View.GONE);
        id = FirebaseAuth.getInstance().getCurrentUser().getUid();
        database = FirebaseDatabase.getInstance();
        myRef1 = database.getReference("factors");
        mDatabase1 = FirebaseDatabase.getInstance().getReference();
        textLabel.setText("List of Recorded Activities");

        ref1 = myRef1.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                if (dataSnapshot != null && dataSnapshot.getValue() != null) {
                    try {
                        model = dataSnapshot.getValue(Factors.class);
                        if (model.getId().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
                            if (model.getDateRecordedMonth().equals(String.valueOf(month)) && model.getDateRecordedDate().equals(String.valueOf(day)) && model.getDateRecordedYear().equals(String.valueOf(year))) {
                                if (model.getCheckReceptive().equals("true")) {
                                    checkReceptive.setChecked(true);
                                }
                                if (model.getCheckAccidental().equals("true")) {
                                    checkAccidental.setChecked(true);
                                }
                                if (model.getCheckShared().equals("true")) {
                                    checkShared.setChecked(true);
                                }
                                if (model.getCheckIntravenous().equals("true")) {
                                    checkIntravenous.setChecked(true);
                                }
                                if (model.getCheckReceived().equals("true")) {
                                    checkReceived.setChecked(true);
                                }
                                if (model.getCheckOral().equals("true")) {
                                    checkOral.setChecked(true);
                                }
                                if (model.getCheckOral().equals("true")) {
                                    checkOralLow.setChecked(true);
                                }
                                if (model.getCheckOral().equals("true")) {
                                    checkReceptiveLow.setChecked(true);
                                }
                            }
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
    }

//    public void checkExposure() {
//        daysExposure = 90;
//        if (checkReceptive.isChecked()) {
//            daysExposure = 10;
//            description = description + "Receptive Anal/ Vaginal Sex Without Protectio \n";
//        }
//        if (checkAccidental.isChecked()) {
//            daysExposure = 10;
//            description = description + "Accidental Needle Prick \n";
//        }
//        if (checkShared.isChecked()) {
//            daysExposure = 10;
//            description = description + "Shared Needle\n";
//        }
//        if (checkIntravenous.isChecked()) {
//            daysExposure = 10;
//            description = description + "Intravenous Drug Use\n";
//        }
//        if (checkReceived.isChecked()) {
//            daysExposure = 10;
//            description = description + "Received Blood Transfusion\n";
//        }
//        if (checkInsertive.isChecked()) {
//            daysExposure = 60;
//            description = description + "Insertive Anal/ Vaginal Sex with Protection\n";
//        }
//        if (checkOral.isChecked()) {
//            daysExposure = 60;
//            description = description + "Receptive / Insertive Oral Sex";
//        }
//    }
}
