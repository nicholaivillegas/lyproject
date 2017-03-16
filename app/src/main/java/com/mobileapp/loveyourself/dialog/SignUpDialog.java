package com.mobileapp.loveyourself.dialog;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mobileapp.loveyourself.LoginActivity;
import com.mobileapp.loveyourself.R;
import com.mobileapp.loveyourself.UserInfo;

/**
 * Created by Nico on 3/16/2017.
 */

public class SignUpDialog extends DialogFragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    DatePicker datePicker;
    RadioGroup radioGroup;
    RadioButton radioMale, radioFemale;
    EditText editNumber;
    Button buttonSave;
    private String radioValue;
    private DatabaseReference mDatabase;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_signup, container, false);
        datePicker = (DatePicker) view.findViewById(R.id.datepicker);
        radioGroup = (RadioGroup) view.findViewById(R.id.radiogroup_gender);
        radioMale = (RadioButton) view.findViewById(R.id.radio_male);
        radioFemale = (RadioButton) view.findViewById(R.id.radio_female);
        editNumber = (EditText) view.findViewById(R.id.edit_contact_number);
        buttonSave = (Button) view.findViewById(R.id.button_save);

        radioGroup.setOnCheckedChangeListener(this);
        buttonSave.setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setDialogWindow();
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_save:
                UserInfo userInfo = new UserInfo(FirebaseAuth.getInstance().getCurrentUser().getUid(),
                        FirebaseAuth.getInstance().getCurrentUser().getEmail(),
                        editNumber.getText().toString(),
                        convertDate(),
                        radioValue,
                        "user");
                mDatabase.child("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(userInfo);
                dismiss();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        if (checkedId == R.id.radio_male) {
            radioValue = "Male";
        } else if (checkedId == R.id.radio_female) {
            radioValue = "Female";
        }
    }

    public String convertDate() {
        return String.valueOf(datePicker.getMonth())
                + "/"
                + String.valueOf(datePicker.getDayOfMonth())
                + "/" + String.valueOf(datePicker.getYear());
    }
}
