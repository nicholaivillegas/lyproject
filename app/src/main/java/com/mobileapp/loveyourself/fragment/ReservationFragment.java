package com.mobileapp.loveyourself.fragment;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.mobileapp.loveyourself.R;
import com.mobileapp.loveyourself.dialog.ReservationDialog;

public class ReservationFragment extends Fragment implements View.OnClickListener {

    private EditText editFname, editLname, editCityResidence, editCityWork, editCommunicationMobile, editCommunicationEmail, editLanguageOther, editHindranceOther;
    private RadioGroup radioGroupHowDidYouLearn, radioGroupLanguage, radioGroupBranch;
    private RadioButton radioBlogs, radioReferral, radioSearchEngine, radioSmartApp, radioSocialNetworking1, getRadioSocialNetworking2, radioOther1;
    private RadioButton radioLanguageTagalog, radionLanguageEnglish, radioLanguageTagLish, radioLanguageOther;
    private RadioButton radioBranchAnglo, radioBranchUni;
    private CheckBox checkCommunicationMobile, checkCommunicationEmail;
    private CheckBox checkHindranceA, checkHindranceB, checkHindranceC, checkHindranceD, checkHindranceE, checkHindranceF, checkHindranceG, checkHindranceOther;
    private DatePicker datepicker;
    private Button buttonSubmit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reservation, container, false);
        buttonSubmit = (Button) view.findViewById(R.id.button_submit);

        buttonSubmit.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_submit:
                ReservationDialog reservationDialog = new ReservationDialog();
                reservationDialog.show(getActivity().getFragmentManager(), "Reservation Dialog");
                break;
        }
    }
}