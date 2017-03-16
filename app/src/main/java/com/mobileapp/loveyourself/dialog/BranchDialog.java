package com.mobileapp.loveyourself.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobileapp.loveyourself.R;

public class BranchDialog extends DialogFragment {

    private TextView textTitle, textLocation, textPhone, textClinicHours, textDescription;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_branch, container, false);

        textTitle = (TextView) view.findViewById(R.id.text_title);
        textLocation = (TextView) view.findViewById(R.id.text_location);
        textPhone = (TextView) view.findViewById(R.id.text_phone);
        textClinicHours = (TextView) view.findViewById(R.id.text_clinic);
        textDescription = (TextView) view.findViewById(R.id.text_description);
        setDialogWindow();
        if (getArguments().getString("title").equals("anglo")) {
            textTitle.setText("Love Yourself Anglo");
            textLocation.setText("3/F, Anglo Building, #715-A Shaw Boulevard, Mandaluyong City");
            textPhone.setText("09153665683");
            textClinicHours.setText("Wednesdays to Saturdays\n" +
                    "12 NN TO 7PM\n" + "Sundays\n" +
                    "9 AM TO 2 PM\n" + "Monday and Tuesday\n" + "Closed");
            textDescription.setText("It is a 3-minute walk from Shaw MRT Station, and is situated just behind Star Mall EDSA). It is at the 3rd floor of a yellow building with Anglo Hardware at the ground floor.");

        } else if (getArguments().getString("title").equals("uni")) {
            textTitle.setText("Love Yourself Uni ");
            textLocation.setText("2028 Taft Avenue Extension, Pasay City");
            textPhone.setText("(02)2569384");
            textClinicHours.setText("Wednesdays to Saturdays\n" +
                    "12 NN TO 7PM\n" + "Sundays\n" +
                    "9 AM TO 2 PM\n" + "Monday and Tuesday\n" + "Closed");
            textDescription.setText("The clinic is located conveniently close to LRT-1 Gil Puyat or Buendia station on the northbound lane of Taft Avenue.");
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
}
