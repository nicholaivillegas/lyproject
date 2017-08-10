package com.mobileapp.loveyourself.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobileapp.loveyourself.R;
import com.mobileapp.loveyourself.Reservation;
import com.mobileapp.loveyourself.UserInfo;
import com.mobileapp.loveyourself.dialog.ReservationDialog;

public class ReservationFragment extends Fragment implements View.OnClickListener {

    private EditText editFname, editLname, editCityResidence, editCityWork, editCommunicationMobile, editCommunicationEmail, editLanguageOther, editHindranceOther, editOther1;
    private RadioGroup radioGroupHowDidYouLearn, radioGroupLanguage, radioGroupBranch;
    private RadioButton radioBlogs, radioReferral, radioSearchEngine, radioSmartApp, radioSocialNetworking1, radioSocialNetworking2, radioOther1;
    private RadioButton radioLanguageTagalog, radionLanguageEnglish, radioLanguageTagLish, radioLanguageOther;
    private RadioButton radioBranchAnglo, radioBranchUni;
    private CheckBox checkCommunicationMobile, checkCommunicationEmail;
    private CheckBox checkHindranceA, checkHindranceB, checkHindranceC, checkHindranceD, checkHindranceE, checkHindranceF, checkHindranceG, checkHindranceOther;
    private DatePicker datepicker;
    private Button buttonSubmit;

    public String id;
    public String timestamp;
    public String firstName;
    public String lastName;
    public String cityOfResidence;
    public String howDidYouLearn;
    public String mobile;
    public String email;
    public String language;
    public String hindrance1;
    public String hindrance2;
    public String hindrance3;
    public String hindrance4;
    public String hindrance5;
    public String hindrance6;
    public String hindrance7;
    public String hindrance8;
    public String testingLocation;
    public String testingDate;
    public String other;
    public String extra;

    private int ctr = 0;
    private DatabaseReference mDatabase;
    private DatabaseReference myRef;
    private ChildEventListener ref;

    UserInfo model;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reservation, container, false);
        buttonSubmit = (Button) view.findViewById(R.id.button_submit);
        editFname = (EditText) view.findViewById(R.id.edit_first_name);
        editLname = (EditText) view.findViewById(R.id.edit_last_name);
        editCityResidence = (EditText) view.findViewById(R.id.edit_city_residence);
        editCommunicationEmail = (EditText) view.findViewById(R.id.edit_communication_email);
        editCommunicationMobile = (EditText) view.findViewById(R.id.edit_communication_mobile);
        editHindranceOther = (EditText) view.findViewById(R.id.edit_hindrance_other);
        editOther1 = (EditText) view.findViewById(R.id.edit_other1);
        editLanguageOther = (EditText) view.findViewById(R.id.edit_language_other);

        radioGroupHowDidYouLearn = (RadioGroup) view.findViewById(R.id.radio_group_how_did_u_learn);
        radioGroupLanguage = (RadioGroup) view.findViewById(R.id.radio_group_language);
        radioGroupBranch = (RadioGroup) view.findViewById(R.id.radio_group_branch);

        radioBlogs = (RadioButton) view.findViewById(R.id.radio_blogs);
        radioReferral = (RadioButton) view.findViewById(R.id.radio_referral);
        radioSearchEngine = (RadioButton) view.findViewById(R.id.radio_search_engine);
        radioSmartApp = (RadioButton) view.findViewById(R.id.radio_smart_app);
        radioSocialNetworking1 = (RadioButton) view.findViewById(R.id.radio_social_network1);
        radioSocialNetworking2 = (RadioButton) view.findViewById(R.id.radio_social_network2);
        radioOther1 = (RadioButton) view.findViewById(R.id.radio_other1);
        radioLanguageTagalog = (RadioButton) view.findViewById(R.id.radio_language_tagalog);
        radionLanguageEnglish = (RadioButton) view.findViewById(R.id.radio_language_english);
        radioLanguageTagLish = (RadioButton) view.findViewById(R.id.radio_language_taglish);
        radioLanguageOther = (RadioButton) view.findViewById(R.id.radio_language_other);
        radioBranchAnglo = (RadioButton) view.findViewById(R.id.radio_branch_anglo);
        radioBranchUni = (RadioButton) view.findViewById(R.id.radio_branch_uni);

        checkCommunicationMobile = (CheckBox) view.findViewById(R.id.check_communication_mobile);
        checkCommunicationEmail = (CheckBox) view.findViewById(R.id.check_communication_email);
        checkHindranceA = (CheckBox) view.findViewById(R.id.check_hindrance_a);
        checkHindranceB = (CheckBox) view.findViewById(R.id.check_hindrance_b);
        checkHindranceC = (CheckBox) view.findViewById(R.id.check_hindrance_c);
        checkHindranceD = (CheckBox) view.findViewById(R.id.check_hindrance_d);
        checkHindranceE = (CheckBox) view.findViewById(R.id.check_hindrance_e);
        checkHindranceF = (CheckBox) view.findViewById(R.id.check_hindrance_f);
        checkHindranceG = (CheckBox) view.findViewById(R.id.check_hindrance_g);
        checkHindranceOther = (CheckBox) view.findViewById(R.id.check_hindrance_other);
        datepicker = (DatePicker) view.findViewById(R.id.datepicker);

        buttonSubmit.setOnClickListener(this);
        radioBlogs.setOnClickListener(this);
        radioReferral.setOnClickListener(this);
        radioSearchEngine.setOnClickListener(this);
        radioSmartApp.setOnClickListener(this);
        radioSocialNetworking1.setOnClickListener(this);
        radioSocialNetworking2.setOnClickListener(this);
        radioOther1.setOnClickListener(this);

        checkCommunicationEmail.setOnClickListener(this);
        checkCommunicationMobile.setOnClickListener(this);

        radioLanguageTagalog.setOnClickListener(this);
        radionLanguageEnglish.setOnClickListener(this);
        radioLanguageTagLish.setOnClickListener(this);
        radioLanguageOther.setOnClickListener(this);

        checkHindranceOther.setOnClickListener(this);

        radioBranchAnglo.setOnClickListener(this);
        radioBranchUni.setOnClickListener(this);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadFields();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_submit:
                if (ctr == 0) {
                    buttonSubmit.setText("READ REMINDERS");
                    ReservationDialog reservationDialog = new ReservationDialog();
                    reservationDialog.show(getActivity().getFragmentManager(), "Reservation Dialog");
                    ctr = 1;
                } else {
                    //Do saving
                    buttonSubmit.setText("SUBMIT");
                    getFieldsInformation();
                    saveProfile();
                    buttonSubmit.setEnabled(false);
                }

                break;
//
            case R.id.radio_blogs:
                howDidYouLearn = "Blogs";
                editOther1.setVisibility(View.GONE);
                break;
            case R.id.radio_referral:
                howDidYouLearn = "Referral from a friend";
                editOther1.setVisibility(View.GONE);
                break;
            case R.id.radio_search_engine:
                howDidYouLearn = "Search Engine";
                editOther1.setVisibility(View.GONE);
                break;
            case R.id.radio_smart_app:
                Toast.makeText(getContext(), "Smart Phone App", Toast.LENGTH_SHORT).show();
                editOther1.setVisibility(View.GONE);
                break;
            case R.id.radio_social_network1:
                howDidYouLearn = "Social Network 1";
                editOther1.setVisibility(View.GONE);
                break;
            case R.id.radio_social_network2:
                howDidYouLearn = "Social Networking 2";
                editOther1.setVisibility(View.GONE);
                break;
            case R.id.radio_other1:
                editOther1.setText("");
                editOther1.setVisibility(View.VISIBLE);
                break;

            case R.id.check_communication_email:
                if (checkCommunicationEmail.isChecked()) {
                    editCommunicationEmail.setVisibility(View.VISIBLE);
                } else {
                    editCommunicationEmail.setText("");
                    editCommunicationEmail.setVisibility(View.GONE);
                }
                break;
            case R.id.check_communication_mobile:
                if (checkCommunicationMobile.isChecked()) {
                    editCommunicationMobile.setVisibility(View.VISIBLE);
                } else {
                    editCommunicationMobile.setText("");
                    editCommunicationMobile.setVisibility(View.GONE);
                }
                break;

            case R.id.radio_language_tagalog:
                language = "Tagalog";
                editLanguageOther.setText("");
                editLanguageOther.setVisibility(View.GONE);
                break;
            case R.id.radio_language_english:
                language = "English";
                editLanguageOther.setText("");
                editLanguageOther.setVisibility(View.GONE);
                break;
            case R.id.radio_language_taglish:
                language = "Taglish";
                editLanguageOther.setText("");
                editLanguageOther.setVisibility(View.GONE);
                break;
            case R.id.radio_language_other:
                editLanguageOther.setVisibility(View.VISIBLE);
                break;

            case R.id.check_hindrance_other:
                if (checkHindranceOther.isChecked()) {
                    editHindranceOther.setVisibility(View.VISIBLE);
                } else {
                    editHindranceOther.setVisibility(View.GONE);
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
        firstName = editFname.getText().toString();
        lastName = editLname.getText().toString();
        cityOfResidence = editCityResidence.getText().toString();
        if (radioOther1.isChecked()) {
            howDidYouLearn = editOther1.getText().toString();
        }
        if (checkCommunicationEmail.isChecked()) {
            email = editCommunicationEmail.getText().toString();
        } else {
            email = "n/a";
        }
        if (checkCommunicationMobile.isChecked()) {
            mobile = editCommunicationMobile.getText().toString();
        } else {
            mobile = "n/a";
        }
        if (radioLanguageOther.isChecked()) {
            language = editLanguageOther.getText().toString();
        }
        if (checkHindranceA.isChecked()) {
            hindrance1 = "Yes";
        } else {
            hindrance1 = "No";
        }
        if (checkHindranceB.isChecked()) {
            hindrance2 = "Yes";
        } else {
            hindrance2 = "No";
        }
        if (checkHindranceC.isChecked()) {
            hindrance3 = "Yes";
        } else {
            hindrance3 = "No";
        }
        if (checkHindranceD.isChecked()) {
            hindrance4 = "Yes";
        } else {
            hindrance4 = "No";
        }
        if (checkHindranceE.isChecked()) {
            hindrance5 = "Yes";
        } else {
            hindrance5 = "No";
        }
        if (checkHindranceF.isChecked()) {
            hindrance6 = "Yes";
        } else {
            hindrance6 = "No";
        }
        if (checkHindranceG.isChecked()) {
            hindrance7 = "Yes";
        } else {
            hindrance7 = "No";
        }
        if (checkHindranceOther.isChecked()) {
            hindrance8 = editHindranceOther.getText().toString();
        } else {
            hindrance8 = "No";
        }
        testingDate = String.valueOf(datepicker.getYear()) + "," + String.valueOf(datepicker.getMonth()) + "," + String.valueOf(datepicker.getDayOfMonth());
    }

    private void saveProfile() {
//        id, timestamp, firstName, lastName, cityOfResidence, howDidYouLearn, mobile, email, language, hindrance1, hindrance2, hindrance3, hindrance4, hindrance5, hindrance6, hindrance7, hindrance8, testingLocation, testingDate, other, extra
        Reservation user = new Reservation(FirebaseAuth.getInstance().getCurrentUser().getUid(),
                timestamp,
                model.getFirstName(),
                model.getLastName(),
                model.getLocation(),
                howDidYouLearn,
                model.getNumber(),
                model.getEmail(),
                language,
                hindrance1,
                hindrance2,
                hindrance3,
                hindrance4,
                hindrance5,
                hindrance6,
                hindrance7,
                hindrance8,
                testingLocation,
                String.valueOf(datepicker.getYear()), String.valueOf(datepicker.getMonth()), String.valueOf(datepicker.getDayOfMonth()),
                other,
                extra);
        mDatabase.child("reservations").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user);
        Toast.makeText(getContext(), "Reservation Successful", Toast.LENGTH_LONG).show();
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
                            Toast.makeText(getContext(), model.getFirstName(), Toast.LENGTH_LONG).show();

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

}