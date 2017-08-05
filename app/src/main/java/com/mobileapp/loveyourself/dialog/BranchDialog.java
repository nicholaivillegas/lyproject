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
        } else if (getArguments().getString("title").equals("caloocanCitySocialHygienicClinic")) {
            textTitle.setText("Caloocan City Social Hygiene Clinic");
            textLocation.setText("A Mabini St., Caloocan City Hall");
            textPhone.setText("(02)288-8811");
            textClinicHours.setText("Monday to Friday\n" +
                    "8:00 am to 5:00 pm");
            textDescription.setText("Test Result: 15-20 minutes");
        } else if (getArguments().getString("title").equals("pasigCityHealthDevelopment")) {
            textTitle.setText("Pasig City Health Development");
            textLocation.setText("5th Floor, Room 5, Pasig City Hall");
            textPhone.setText("(02) 640-0111");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result: Within an hour");
        } else if (getArguments().getString("title").equals("saintCamillusMedicalCenter")) {
            textTitle.setText("Saint Camillus Medical Center");
            textLocation.setText("116 Amang Rodriguez Ave., Santolan");
            textPhone.setText("(02) 645-3741");
            textClinicHours.setText("Monday to Saturday" + "\n" + "7:00 am to 6:00 pm");
            textDescription.setText("Test Result: 15-20 minutes");
        } else if (getArguments().getString("title").equals("quezonCityHealthDepartment")) {
            textTitle.setText("Quezon City Health Department");
            textLocation.setText("Manuel L, Corner Kalaayan Avenue, Barangay Central");
            textPhone.setText("(02) 929-8902");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 1 day" + "\n"
                    + "Confirmatory: 3 weeks");
        } else if (getArguments().getString("title").equals("quezonCityKlinikaBernardo")) {
            textTitle.setText("Quezon City Klinika Bernardo");
            textLocation.setText("Ermin Garcia Street, Edsa Cubao, Quezon City");
            textPhone.setText("0917-581-1178");
            textClinicHours.setText("Monday to Friday" + "\n" + "3:00 pm to 11:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 1 hour" + "\n"
                    + "Confirmatory: 2-3 weeks");
        } else if (getArguments().getString("title").equals("makatiSocialHygieneClinic")) {
            textTitle.setText("Makati Social Hygiene Clinic");
            textLocation.setText("Edsa Cubao, Across Nepa Q-mart, besides Ramon Magsaysay High School, Ermin Garcia Street, Barangay Pinagkaisahan");
            textPhone.setText("(02) 899-8927");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 20 minutes" + "\n"
                    + "Confirmatory: 2 weeks");
        } else if (getArguments().getString("title").equals("pedroCruzHealthCenter")) {
            textTitle.setText("Pedro Cruz Health Center");
            textLocation.setText("F. Sevilla Street, Barangay Pedro Cruz");
            textPhone.setText("(02) 799-5069");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 30 days" + "\n"
                    + "Confirmatory: 10 days");
        } else if (getArguments().getString("title").equals("manilaSocialHygieneClinic")) {
            textTitle.setText("Manila Social Hygiene Clinic");
            textLocation.setText("Quiricada Street, Sta. Cruz");
            textPhone.setText("(02) 711-6942");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 3:00 pm");
            textDescription.setText("Test Result: 10-15 minutes");
        } else if (getArguments().getString("title").equals("lasPinasDanielFajardoSocialHygieneClinic")) {
            textTitle.setText("Las Pinas (Daniel Fajardo) Social Hygiene Clinic");
            textLocation.setText("Barrio Hall, Alabang Zapate Road, Almansa");
            textPhone.setText("(02) 800-6406");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result: 3 hours");
        } else if (getArguments().getString("title").equals("navotasCityHealthOffice")) {
            textTitle.setText("Navotas City Health Office");
            textLocation.setText("Los Martires Street, Bagong Lipunan Health Center, San Jose");
            textPhone.setText("(02) 281-8728");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 10-20 minutes" + "\n"
                    + "Confirmatory: 1 month");
        } else if (getArguments().getString("title").equals("valenzuelaHealthOffice")) {
            textTitle.setText("Valenzuela Health Office");
            textLocation.setText("Cecilio J. Santos Street, Poblacion II, Malinta");
            textPhone.setText("(02) 352-1000 ext. 1116");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result: N/");
        } else if (getArguments().getString("title").equals("paranaqueSocialHygieneClinicandWellnessCenter")) {
            textTitle.setText("Paranaque Social Hygiene Clinicand Wellness Center");
            textLocation.setText("3rd Floor of Paranaque City Hall, Barangay San Antonio, Valley I, Sucat");
            textPhone.setText("(02) 826-8195");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 8:00 pm");
            textDescription.setText("Test Result: 30 minutes to 1 hour");
        } else if (getArguments().getString("title").equals("pasayCitySocialHygieneClinic")) {
            textTitle.setText("Pasay City Social Hygiene Clinic");
            textLocation.setText("Room 106 Ground Floor, pasay City Hall, F.B. Harrison Street");
            textPhone.setText("(02) 551-4180");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result: 30-45 minutes");
        } else if (getArguments().getString("title").equals("mandaluyongCitySocialHygieneClinic")) {
            textTitle.setText("Mandaluyong City Social Hygiene Clinic");
            textLocation.setText("SHC 2 floor Zaniga HC, Lerma St corner vicentio, MC");
            textPhone.setText("(02) 546-7799");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result: 30 minutes to 1 hour");
        } else if (getArguments().getString("title").equals("mandaluyongCityDropinCenter")) {
            textTitle.setText("Mandaluyong City Drop-in Center");
            textLocation.setText("SHC 2 floor Zaniga HC, Lerma St corner vicentio, MC");
            textPhone.setText("(02) 211-5336");
            textClinicHours.setText("Monday to Friday" + "\n" + "3:00 pm to 11:00 pm");
            textDescription.setText("Test Result: 2 hours");
        } else if (getArguments().getString("title").equals("taguigCitySocialHygieneClinic")) {
            textTitle.setText("Taguig City Social Hygiene Clinic");
            textLocation.setText("3rd Floor LC Building, Gen. Luna St., Tuktukan");
            textPhone.setText("0926-754-2917");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result: 2 hours");
        } else if (getArguments().getString("title").equals("taguigCityDropinCenter")) {
            textTitle.setText("Taguig City Drop-in Center");
            textLocation.setText("Pateros District Hospital, East Service Road, Western Bicutan");
            textPhone.setText("0975-265-7466");
            textClinicHours.setText("Monday to Saturday" + "\n" + "10:00 am to 6:00 pm");
            textDescription.setText("Test Result: 30 minutes");
        } else if (getArguments().getString("title").equals("paterosClinicalLaboratory")) {
            textTitle.setText("Pateros Clinical Laboratory");
            textLocation.setText("P. Herrera Street, Barangay San Pedro, Pateros");
            textPhone.setText("(02) 643-3486");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result: 30 minutes");
        } else if (getArguments().getString("title").equals("marikinaSocialHygieneClinic")) {
            textTitle.setText("Marikina Social Hygiene Clinic");
            textLocation.setText("Ground Floor, Marikina CHO");
            textPhone.setText("(02) 997-1108");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result: 20 minutes");
        } else if (getArguments().getString("title").equals("aIDSSocietyofthePhilippines")) {
            textTitle.setText("AIDS Society of the Philippines");
            textLocation.setText("Ground Floor, OTM Building, #71, Sct. Tuazon Steet, Barangay South Triangle");
            textPhone.setText("(02) 376-2541");
            textClinicHours.setText("Monday to Friday" + "\n" + "Saturday:walk - in " + "\n"
                    + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 20 minutes" + "\n" + "Confirmatory: 2 weeks");
        } else if (getArguments().getString("title").equals("sanLazaroHospital")) {
            textTitle.setText("San Lazaro Hospital");
            textLocation.setText("Building 17, San Lazaro Hospital, Quiricada Street, Sta Cruz");
            textPhone.setText("(02) 732-3776 ext. 207");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 4:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 3 days" + "\n" + "Confirmatory: 10 working days");
        } else if (getArguments().getString("title").equals("philippineGeneralHospital")) {
            textTitle.setText("Philippine General Hospital");
            textLocation.setText("Sagip unit, 2nd fl, ER complex, UPPGH, Taft avenue");
            textPhone.setText("(02) 554-8400 ext. 3249");
            textClinicHours.setText("Monday, Wednesday, Friday" + "\n" + "8:30 am to 11:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 3 days" + "\n" + "Confirmatory: 10 working days");
        } else if (getArguments().getString("title").equals("makatiMedicalCenter")) {
            textTitle.setText("Makati Medical Center");
            textLocation.setText("#2 Amorsolo St., Legaspi Village");
            textPhone.setText("(02) 888-8999 ext. 2336");
            textClinicHours.setText("Tuesday to Saturday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 1 day" + "\n" + "Confirmatory: 2-3 weeks");
        } else if (getArguments().getString("title").equals("theResearchInstituteforTropicalMedicineAlabang")) {
            textTitle.setText("The Research Institute for Tropical Medicine (Alabang)");
            textLocation.setText("Corporate Avenue, Filinvest Corporate City, Alabang, Muntinlupa City");
            textPhone.setText("(02) 807-2628 to 30 ext. 248");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result: N/A ");
        } else if (getArguments().getString("title").equals("theResearchInstituteforTropicalMedicineMalate")) {
            textTitle.setText("The Research Institute for Tropical Medicine (Malate)");
            textLocation.setText("1936-B San Marcelino Street, near corner Quirino Ave., Malate, Manila");
            textPhone.setText("(02) 256-3472");
            textClinicHours.setText("Monday, Thursday to Saturday: 11:00 am to 7:00 pm" + "\n" + "Sunday:9:00 am to 4:00 pm ");
            textDescription.setText("Test Result: N/A ");
        } else if (getArguments().getString("title").equals("theResearchInstituteforTropicalMedicineMandaluyong")) {
            textTitle.setText("The Research Institute for Tropical Medicine (Mandaluyong)");
            textLocation.setText("Units 5, 3/F 715-A Shaw Boulevard, Mandaluyong City");
            textPhone.setText("0915-366-5683");
            textClinicHours.setText("Wednesday to Saturday: 12:00 nn to 9:00 pm" + "\n" + "Sunday: 9:00am to 4:00 pm ");
            textDescription.setText("Test Result: N/A ");
        } else if (getArguments().getString("title").equals("hiPrecisionDiagnosticsDelMonte")) {
            textTitle.setText("Hi-Precision Diagnostics, Del Monte");
            textLocation.setText("440-442 W. Long Building, Del monte Avenue, Corner Biyak na Bato");
            textPhone.setText("(02) 863-9999 ext. 122");
            textClinicHours.setText("Monday to Saturday" + "\n" + "6:00 am to 10:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 3 hours" + "\n" + "Confirmatory: 3-4 weeks");
        } else if (getArguments().getString("title").equals("hiPrecisionDiagnosticsRockwell")) {
            textTitle.setText("Hi-Precision Diagnostics, Rockwell");
            textLocation.setText("020 B. Concourse Level, The Poer Plant Mall, Rockwell, Makati City");
            textPhone.setText("(02) 899-8820");
            textClinicHours.setText("Monday to Saturday" + "\n" + "7:00 am to 8:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 6 hours" + "\n" + "Confirmatory: 3-4 weeks");
        } else if (getArguments().getString("title").equals("hiPrecisionDiagnosticsVLuna")) {
            textTitle.setText("Hi-Precision Diagnostics, V.Luna");
            textLocation.setText("31 B. Jarpas Tower, Ground Floor, B. Luna Road, Quezon City");
            textPhone.setText("(02) 433-8637");
            textClinicHours.setText("Monday to Saturday" + "\n" + "6:00 am to 4:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 1 day" + "\n" + "Confirmatory: 3 weeks");
        } else if (getArguments().getString("title").equals("hiPrecisionDiagnosticsPasig")) {
            textTitle.setText("Hi-Precision Diagnostics, Pasig");
            textLocation.setText("Unit 102, Armal Building, Corner C. Reymundo, May Bunga, Pasig City");
            textPhone.setText("(02) 628-3277");
            textClinicHours.setText("Monday to Saturday" + "\n" + "7:00 am to 4:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 1 day" + "\n" + "Confirmatory: 3 weeks");
        } else if (getArguments().getString("title").equals("hPDInternationalTaft")) {
            textTitle.setText("HPD International, Taft");
            textLocation.setText("1852 Taft Avenue, Malate, Manila");
            textPhone.setText("(02) 405-0039");
            textClinicHours.setText("Monday to Saturday" + "\n" + "6:00 am to 4:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 4 hours" + "\n" + "Confirmatory: 3 weeks");
        } else if (getArguments().getString("title").equals("hiPrecisionDiagnosticsKalaw")) {
            textTitle.setText("Hi-Precision Diagnostics, Kalaw");
            textLocation.setText("Room 102, San Louise Tereses Building, #638 TM Kalaw Street, Ermita, Manila");
            textPhone.setText("(02) 526-2329");
            textClinicHours.setText("Monday to Saturday" + "\n" + "6:00 am to 5:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 1 day" + "\n" + "Confirmatory: 1 month");
        } else if (getArguments().getString("title").equals("hiPrecisionDiagnosticsLasPinas")) {
            textTitle.setText("Hi-Precision Diagnostics, Las Pinas");
            textLocation.setText("Unit 21 to 24, Las Pinas Commercial Complex, Alabang Sapute Road, Las Pinas City");
            textPhone.setText("(02) 623-2783");
            textClinicHours.setText("Monday to Saturday" + "\n" + "6:00 am to 5:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: Within the day" + "\n" + "Confirmatory: 1 month");
        } else if (getArguments().getString("title").equals("megaclinicALS")) {
            textTitle.setText("Megaclinic-ALS");
            textLocation.setText("5th Level Megamall Building A Ortigas Center, Mandaluyong City");
            textPhone.setText("(02) 633-5907");
            textClinicHours.setText("Monday to Sunday" + "\n" + "7:00 am to 8:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 6 hours" + "\n" + "Confirmatory: 1 month");
        } else if (getArguments().getString("title").equals("woodwaterCenterforHealing")) {
            textTitle.setText("Megaclinic-ALS");
            textLocation.setText("18 Nicanor Reyes St., Varsity Hills, Loyola Hts., Quezon City");
            textPhone.setText("(02) 926-3147 ext. 11");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 2 weeks" + "\n" + "Confirmatory: 3 weeks");
        } else if (getArguments().getString("title").equals("pasigSocialHygieneClinic")) {
            textTitle.setText("Pasig Social Hygiene Clinic");
            textLocation.setText("Social Hygiene Clinic, Caruncho Avenue, Barangay San Nicolas, Pasig, 1600 Metro Manila");
            textPhone.setText("(02) 640-0111");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 1 day" + "\n" + "Confirmatory: 4 weeks");
        } else if (getArguments().getString("title").equals("joseReyesMemorialMedicalCenter")) {
            textTitle.setText("Jose Reyes Memorial Medical Center");
            textLocation.setText("San Lazaro Street. Sta. Cruz, Manila");
            textPhone.setText("(02) 732-1071 to 76 ext. 323");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result: N/A ");
        } else if (getArguments().getString("title").equals("muntinlupaHealthCenter")) {
            textTitle.setText("Muntinlupa Health Center");
            textLocation.setText("2nd Floor, Putatan Health Center, National Road, Putatan, Muntinlupa City");
            textPhone.setText("(02) 831-5123");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 1 hour" + "\n" + "Confirmatory: 5-6 weeks");
        } else if (getArguments().getString("title").equals("batasanSocialHygieneClinic")) {
            textTitle.setText("Batasan Social Hygiene Clinic");
            textLocation.setText("#1 IBP road Ground Floor Batasan Hills Super Health Center Bldg. Brgy Batasan Hills, Quezon City");
            textPhone.setText("0922-831-6044");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 30 minutes" + "\n" + "Confirmatory: 3-4 weeks");
        } else if (getArguments().getString("title").equals("quezonCityBernardoSocialHygieneClinic")) {
            textTitle.setText("Quezon City, Bernardo Social Hygiene Clinic");
            textLocation.setText("Edsa Cubao, Across Nepa Q-mart, besides Ramon Magsaysay High School, Ermin Garcia Street, Barangay Pinagkaisahan");
            textPhone.setText("0922-831-6044");
            textClinicHours.setText("Monday to Friday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result:" + "\n" + "Rapid: 20 minutes" + "\n" + "Confirmatory: 2 weeks");
        } else if (getArguments().getString("title").equals("theShipFoundation")) {
            textTitle.setText("The Ship Foundation");
            textLocation.setText("566 Shaw Boulevard, Mandaluyong, Metro Manila");
            textPhone.setText("(02) 209-4971");
            textClinicHours.setText("Everyday except Thursday" + "\n" + "2:00 pm to 7:00 pm");
            textDescription.setText("Test Result: N/A");
        } else if (getArguments().getString("title").equals("hiPrecisionDiangnosticsSucat")) {
            textTitle.setText("Hi-Precision Diangnostics, Sucat");
            textLocation.setText("A- 4B JAKA Plaza Mall 8288 Dr. A. Santos Avenue Sucat, Paranaque City");
            textPhone.setText("(02) 836-3431");
            textClinicHours.setText("Monday to Saturday" + "\n" + "8:00 am to 5:00 pm");
            textDescription.setText("Test Result: N/A");
        } else if (getArguments().getString("title").equals("hiPrecisionDiangnosticsAlabang")) {
            textTitle.setText("Hi-Precision Diangnostics, Alabang");
            textLocation.setText("2301 Civic Place, Unit 106 Civic Drive Filinvest, Alabang 1780");
            textPhone.setText("(02) 659-2673");
            textClinicHours.setText("Monday to Saturday" + "\n" + " 6:00 am to 4:30 pm");
            textDescription.setText("Test Result: N/A");
        } else if (getArguments().getString("title").equals("hiPrecisionDiangnosticsEastAvenue")) {
            textTitle.setText("Hi-Precision Diangnostics, East Avenue");
            textLocation.setText("18 East Avenue, Corner V. Luna, Diliman, Quezon City");
            textPhone.setText("(02) 435-8228");
            textClinicHours.setText("Monday to Sunday" + "\n" + " 6:00 am to 6:00 pm");
            textDescription.setText("Test Result: N/A");
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
