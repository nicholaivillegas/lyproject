package com.mobileapp.loveyourself;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private static final String TAG = "SIGN UP";
    private EditText inputFirstName, inputLastName, inputEmail, inputLocation, inputContactNumber, inputPassword, inputRetypePassword, inputQuestion, inputAnswer;
    private Button btnSignIn, btnSignUp, btnResetPassword;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    private DatabaseReference mDatabase;
    private RadioButton radioMale, radioFemale;
    private RadioGroup radioGroupGender;
    private DatePicker mDatepicker;
    private String gender;
    private CheckBox checkDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        btnSignIn = (Button) findViewById(R.id.sign_in_button);
        btnSignUp = (Button) findViewById(R.id.sign_up_button);
        inputFirstName = (EditText) findViewById(R.id.edit_first_name);
        inputLastName = (EditText) findViewById(R.id.edit_last_name);
        inputEmail = (EditText) findViewById(R.id.edit_email);
        inputLocation = (EditText) findViewById(R.id.edit_location);
        inputContactNumber = (EditText) findViewById(R.id.edit_contact_number);
        inputPassword = (EditText) findViewById(R.id.edit_password);
        inputRetypePassword = (EditText) findViewById(R.id.edit_retype_password);
        inputQuestion = (EditText) findViewById(R.id.edit_security_question);
        inputAnswer = (EditText) findViewById(R.id.edit_answer);
        radioGroupGender = (RadioGroup) findViewById(R.id.radiogroup_gender);
        radioMale = (RadioButton) findViewById(R.id.radio_male);
        radioFemale = (RadioButton) findViewById(R.id.radio_female);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnResetPassword = (Button) findViewById(R.id.btn_reset_password);
        mDatepicker = (DatePicker) findViewById(R.id.datepicker);
        checkDate = (CheckBox) findViewById(R.id.check_date);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -18);
        long legalAge = calendar.getTime().getTime();

        mDatepicker.setMinDate(legalAge);
        checkDate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mDatepicker.setEnabled(true);
                    mDatepicker.setVisibility(View.VISIBLE);
                } else {
                    mDatepicker.setEnabled(false);
                    mDatepicker.setVisibility(View.GONE);
                }
            }
        });
        radioGroupGender.setOnCheckedChangeListener(this);
        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, ResetPasswordActivity.class));
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String firstName = inputFirstName.getText().toString().trim();
                final String lastName = inputLastName.getText().toString().trim();
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                String number = inputContactNumber.getText().toString().trim();

                if (TextUtils.isEmpty(firstName)) {
                    createDialog("Enter First Name!");
                    return;
                }

                if (TextUtils.isEmpty(lastName)) {
                    createDialog("Enter Last Name!");
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    createDialog("Enter email address!");
                    return;
                }

                if (!isValidAge()) {
                    createDialog("You should be 18 years old and above");
                    return;
                }

                if (!emailValidator(email)) {
                    createDialog("Incorrect Email format");

                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    createDialog("Enter password!");

                    return;
                }

                if (number.length() != 11) {
                    createDialog("Enter 11 digit number");
                    return;
                }

                if (password.length() < 6) {
                    createDialog("Password too short, enter minimum 6 characters!");
                    return;
                }

                if (!checkDate.isChecked()) {
                    createDialog("Please Confirm your Age.");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                //create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                createDialog("Logged In!");
                                progressBar.setVisibility(View.GONE);

                                if (!task.isSuccessful()) {
                                    createDialog("Login Failed!");

                                } else {
                                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                            .setDisplayName(firstName + " " + lastName)
//                                            .setPhotoUri(Uri.parse("https://example.com/jane-q-user/profile.jpg"))
                                            .build();

                                    if (user != null) {
                                        user.updateProfile(profileUpdates)
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            Log.d(TAG, "User profile updated.");
                                                            saveProfile();
                                                            finish();
                                                        }
                                                    }
                                                });
                                    }
                                }
                            }
                        });

            }
        });
    }

    private void saveProfile() {
        UserInfo user = new UserInfo(
                FirebaseAuth.getInstance().getCurrentUser().getUid(),
                inputFirstName.getText().toString(),
                inputLastName.getText().toString(),
                inputEmail.getText().toString(),
                gender,
                inputLocation.getText().toString(),
                inputContactNumber.getText().toString(),
                makeDate(),
                "active",
                "",
                inputQuestion.getText().toString(),
                inputAnswer.getText().toString());
        mDatabase.child("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user);
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        if (checkedId == R.id.radio_male) {
            gender = "Male";
        } else if (checkedId == R.id.radio_female) {
            gender = "Female";
        }
    }

    public boolean emailValidator(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidAge() {
        Date currentDate = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(currentDate);

        int age = calendar.get(Calendar.YEAR) - mDatepicker.getYear();
        return age > 17;
    }

    public String makeDate() {
        return String.valueOf(mDatepicker.getMonth()) + "-" + String.valueOf(mDatepicker.getDayOfMonth()) + "-" + String.valueOf(mDatepicker.getYear());
    }

    public void createDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
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
}
