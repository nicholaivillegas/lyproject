package com.mobileapp.loveyourself;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mobileapp.loveyourself.dialog.BranchDialog;

import org.w3c.dom.Text;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener, GoogleMap.OnInfoWindowCloseListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;
    private Button buttonCenter;
    private Spinner spinner;

    LatLng anglo = new LatLng(14.583544, 121.051299);
    LatLng uni = new LatLng(14.554933, 120.997198);
    LatLng caloocan = new LatLng(14.741942, 121.026043);
    LatLng pasig = new LatLng(14.588958, 121.068702);
    LatLng saintCamillus = new LatLng(14.612105, 121.091826);
    LatLng quezonCityHealth = new LatLng(14.646152, 121.052300);
    LatLng quezonCityKlinika = new LatLng(14.627863, 121.046516);
    LatLng makatiSocial = new LatLng(14.539638, 121.063096);
    LatLng pedroCruz = new LatLng(14.603717, 121.027149);
    LatLng manilaSocial = new LatLng(14.613007, 120.981414);
    LatLng lasPinasSocial = new LatLng(14.434187, 121.012183);
    LatLng navotasCityHealth = new LatLng(14.662376, 120.945714);
    LatLng valenzuelaHealth = new LatLng(14.692201, 120.969021);
    LatLng paranaqueSocial = new LatLng(14.470505, 121.022255);
    LatLng pasayCitySocial = new LatLng(14.543890, 120.995039);
    LatLng mandaluyongCitySocial = new LatLng(14.539638, 121.063096);
    LatLng mandaluyongCityDrop = new LatLng(14.576297, 121.035259);
    LatLng taguigCitySocial = new LatLng(14.529436, 121.070450);
    LatLng taguigCityDrop = new LatLng(14.510827, 121.034148);
    LatLng paterosClinical = new LatLng(14.544830, 121.066628);
    LatLng marikinaSocial = new LatLng(14.636186, 121.097656);
    LatLng aidsSociety = new LatLng(14.636762, 121.033494);
    LatLng sanLazaro = new LatLng(14.613786, 120.980968);
    LatLng philGen = new LatLng(14.577722, 120.985615);
    LatLng makatiMed = new LatLng(14.559060, 121.014970);
    LatLng theResearchAlabang = new LatLng(14.409846, 121.037030);
    LatLng theResearchMalate = new LatLng(14.572888, 120.992933);
    LatLng theResearchManda = new LatLng(14.409846, 121.037030);
    LatLng hiPrecisionDelMonte = new LatLng(14.638366, 121.003000);
    LatLng hiPrecisionRockwell = new LatLng(14.565516, 121.036140);
    LatLng hiPrecisionVluna = new LatLng(14.637288, 121.050060);
    LatLng hiPrecisionPasig = new LatLng(14.637288, 121.050060);
    LatLng hpdTaft = new LatLng(14.572898, 120.990336);
    LatLng hiPrecisionKalaw = new LatLng(14.582200, 120.982060);
    LatLng hiPrecisionLasPinas = new LatLng(14.443396, 120.995333);
    LatLng megaClinic = new LatLng(14.585427, 121.057092);
    LatLng woodWater = new LatLng(14.640359, 121.069509);
    LatLng pasigSocial = new LatLng(14.558102, 121.081993);
    LatLng joseReyes = new LatLng(14.614228, 120.981953);
    LatLng muntinlupaHealth = new LatLng(14.395086, 121.049811);
    LatLng batasanSocial = new LatLng(14.686256, 121.088386);
    LatLng bernardoSocial = new LatLng(14.627913, 121.046640);
    LatLng theShip = new LatLng(14.585644, 121.048210);
    LatLng hiPrecisionSucat = new LatLng(14.465718, 121.018302);
    LatLng hiPrecisionAlabang = new LatLng(14.443396, 120.995333);
    LatLng hiPrecisionEastAve = new LatLng(14.637579, 121.046333);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        buttonCenter = (Button) findViewById(R.id.btn_center);
        spinner = (Spinner) findViewById(R.id.spinner);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        buttonCenter.setOnClickListener(this);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Branch Locator");
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                mMap.clear();
                if (parentView.getSelectedItem().toString().equals("All")) {
                    addMarkerLuzon();
                } else if (parentView.getSelectedItem().toString().equals("Caloocan City")) {
                    caloocanMarker();
                } else if (parentView.getSelectedItem().toString().equals("Las Pinas City")) {
                    lasPinasMarker();
                } else if (parentView.getSelectedItem().toString().equals("Makati City")) {
                    makatiMarker();
                } else if (parentView.getSelectedItem().toString().equals("Mandaluyong City")) {
                    mandaluyongMarker();
                } else if (parentView.getSelectedItem().toString().equals("Manila City")) {
                    manilaMarker();
                } else if (parentView.getSelectedItem().toString().equals("Marikina City")) {
                    marikinaMarker();
                } else if (parentView.getSelectedItem().toString().equals("Muntinlupa City")) {
                    muntinlupaMarker();
                } else if (parentView.getSelectedItem().toString().equals("Navotas City")) {
                    navotasMarker();
                } else if (parentView.getSelectedItem().toString().equals("Paranaque City")) {
                    paranaqueMarker();
                } else if (parentView.getSelectedItem().toString().equals("Pasay City")) {
                    pasayMarker();
                } else if (parentView.getSelectedItem().toString().equals("Pasig City")) {
                    pasigMarker();
                } else if (parentView.getSelectedItem().toString().equals("Quezon City")) {
                    quezonCityMarker();
                } else if (parentView.getSelectedItem().toString().equals("San Juan City")) {
                    sanJuanMarker();
                } else if (parentView.getSelectedItem().toString().equals("Taguig City")) {
                    taguigMarker();
                } else if (parentView.getSelectedItem().toString().equals("Valenzuela City")) {
                    valenzuelaMarker();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
                centerScreen();
            }

        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setOnMarkerClickListener(this);
        mMap.setOnInfoWindowClickListener(this);
        mMap.setOnInfoWindowCloseListener(this);
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);

        addMarkerLuzon();
        mMap.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(14.609054, 121.022257) , 10.7f) );
//        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(14.6091, 121.0223),15));

    }

    public void centerScreen() {
        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(14.609054, 121.022257));
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(10.7f);

        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
    }


    @Override
    public void onInfoWindowClose(Marker marker) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 18));
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_center:
                centerScreen();
                break;
        }
    }

    public void addMarkerLuzon() {
        createMarker(anglo, "Love Yourself Anglo");
        createMarker(uni, "Love Yourself Uni");
        createMarkerDoh(caloocan, "Caloocan City Social Hygiene Clinic");
        createMarkerDoh(pasig, "Pasig City Health Development");
        createMarkerDoh(saintCamillus, "Saint Camillus Medical Center");
        createMarkerDoh(quezonCityHealth, "Quezon City Health Department");
        createMarkerDoh(quezonCityKlinika, "Quezon City, Klinika Bernardo");
        createMarkerDoh(makatiSocial, "Makati Social Hygiene Clinic");
        createMarkerDoh(pedroCruz, "Pedro Cruz Health Center");
        createMarkerDoh(manilaSocial, "Manila Social Hygiene Clinic");
        createMarkerDoh(lasPinasSocial, "Las Piñas Social Hygiene Clinic");
        createMarkerDoh(navotasCityHealth, "Navotas City Health Office");
        createMarkerDoh(valenzuelaHealth, "Valenzuela Health Office");
        createMarkerDoh(paranaqueSocial, "Parañaque Social Hygiene Clinic and Wellness Center");
        createMarkerDoh(pasayCitySocial, "Pasay City Social Hygiene Clinic");
        createMarkerDoh(mandaluyongCitySocial, "Mandaluyong City Social Hygiene Clinic");
        createMarkerDoh(mandaluyongCityDrop, "Mandaluyong City -Drop-in Center");
        createMarkerDoh(taguigCitySocial, "Taguig City Social Hygiene Clinic");
        createMarkerDoh(taguigCityDrop, "Taguig City Drop-in Centeer");
        createMarkerDoh(paterosClinical, "Pateros Clinical Laboratory");
        createMarkerDoh(marikinaSocial, "Marikina Social Hygiene Clinic");
        createMarkerDoh(aidsSociety, "AIDS Society of the Philippines");
        createMarkerDoh(sanLazaro, "San Lazaro Hospital");
        createMarkerDoh(philGen, "Philippine General Hospital");
        createMarkerDoh(makatiMed, "Makati Medical Center");
        createMarkerDoh(theResearchAlabang, "The Research Institute for Tropical Medicine (Alabang)");
        createMarkerDoh(theResearchMalate, "The Research Institute for Tropical Medicine (Malate)");
        createMarkerDoh(theResearchManda, "The Research Institute for Tropical Medicine (Mandaluyong)");
        createMarkerDoh(hiPrecisionDelMonte, "Hi-Precision Diagnostics, Del Monte");
        createMarkerDoh(hiPrecisionRockwell, "Hi-Precision Diagnostics, Rockwell");
        createMarkerDoh(hiPrecisionVluna, "Hi-Precision Diagnostics, V.Luna");
        createMarkerDoh(hiPrecisionPasig, "Hi-Precision Diagnostics, Pasig");
        createMarkerDoh(hpdTaft, "HPD International, Taft");
        createMarkerDoh(hiPrecisionKalaw, "Hi-Precision Diagnostics, Kalaw");
        createMarkerDoh(hiPrecisionLasPinas, "Hi-Precision Diagnostics, Las Piñas");
        createMarkerDoh(megaClinic, "Megaclinic-ALS");
        createMarkerDoh(woodWater, "Woodwater Center for Healing (Camillians)");
        createMarkerDoh(pasigSocial, "Pasig Social Hygiene Clinic");
        createMarkerDoh(joseReyes, "Jose Reyes Memorial Medical Center");
        createMarkerDoh(muntinlupaHealth, "Muntinlupa Health Center");
        createMarkerDoh(batasanSocial, "Batasan Social Hygiene Clinic");
        createMarkerDoh(bernardoSocial, "Bernardo Social Hygiene Clinic");
        createMarkerDoh(theShip, "The Ship Foundation");
        createMarkerDoh(hiPrecisionSucat, "Hi-Precision Diangnostics, Sucat");
        createMarkerDoh(hiPrecisionAlabang, "Hi-Precision Diagnostics Alabang");
        createMarkerDoh(hiPrecisionEastAve, "Hi-Precision Diagnostics, East Avenue");
    }

    public void createMarker(LatLng latLng, String title) {
        mMap.addMarker(new MarkerOptions().position(latLng)
                .title(title)
                .snippet("(Tap here to view branch)"));
//                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
    }

    public void createMarkerDoh(LatLng latLng, String title) {
        mMap.addMarker(new MarkerOptions().position(latLng)
                .title(title)
                .snippet("(Tap here to view branch)")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
    }

    public void caloocanMarker() {
        createMarkerDoh(caloocan, "Caloocan City Social Hygiene Clinic");
    }

    public void pasigMarker() {
        createMarkerDoh(pasig, "Pasig City Health Development");
        createMarkerDoh(hiPrecisionPasig, "Hi-Precision Diagnostics, Pasig");
        createMarkerDoh(pasigSocial, "Pasig Social Hygiene Clinic");

    }

    public void quezonCityMarker() {
        createMarkerDoh(saintCamillus, "Saint Camillus Medical Center");
        createMarkerDoh(quezonCityHealth, "Quezon City Health Department");
        createMarkerDoh(quezonCityKlinika, "Quezon City, Klinika Bernardo");
        createMarkerDoh(aidsSociety, "AIDS Society of the Philippines");
        createMarkerDoh(hiPrecisionVluna, "Hi-Precision Diagnostics, V.Luna");
        createMarkerDoh(woodWater, "Woodwater Center for Healing (Camillians)");
        createMarkerDoh(batasanSocial, "Batasan Social Hygiene Clinic");
        createMarkerDoh(bernardoSocial, "Bernardo Social Hygiene Clinic");
        createMarkerDoh(hiPrecisionEastAve, "Hi-Precision Diagnostics, East Avenue");
        createMarkerDoh(hiPrecisionDelMonte, "Hi-Precision Diagnostics, Del Monte");
    }

    public void makatiMarker() {
        createMarkerDoh(makatiSocial, "Makati Social Hygiene Clinic");
        createMarkerDoh(makatiMed, "Makati Medical Center");
        createMarkerDoh(hiPrecisionRockwell, "Hi-Precision Diagnostics, Rockwell");

    }

    public void sanJuanMarker() {
        createMarkerDoh(pedroCruz, "Pedro Cruz Health Center");
    }

    public void manilaMarker() {
        createMarkerDoh(manilaSocial, "Manila Social Hygiene Clinic");
        createMarkerDoh(sanLazaro, "San Lazaro Hospital");
        createMarkerDoh(philGen, "Philippine General Hospital");
        createMarkerDoh(theResearchMalate, "The Research Institute for Tropical Medicine (Malate)");
        createMarkerDoh(hpdTaft, "HPD International, Taft");
        createMarkerDoh(hiPrecisionKalaw, "Hi-Precision Diagnostics, Kalaw");
        createMarkerDoh(megaClinic, "Megaclinic-ALS");
        createMarkerDoh(joseReyes, "Jose Reyes Memorial Medical Center");
        createMarkerDoh(theShip, "The Ship Foundation");
        createMarkerDoh(paterosClinical, "Pateros Clinical Laboratory");
        createMarker(uni, "Love Yourself Uni");
    }

    public void lasPinasMarker() {
        createMarkerDoh(lasPinasSocial, "Las Piñas Social Hygiene Clinic");
        createMarkerDoh(hiPrecisionLasPinas, "Hi-Precision Diagnostics, Las Piñas");
    }

    public void navotasMarker() {
        createMarkerDoh(navotasCityHealth, "Navotas City Health Office");
    }

    public void valenzuelaMarker() {
        createMarkerDoh(valenzuelaHealth, "Valenzuela Health Office");
    }

    public void paranaqueMarker() {
        createMarkerDoh(paranaqueSocial, "Parañaque Social Hygiene Clinic and Wellness Center");
        createMarkerDoh(hiPrecisionSucat, "Hi-Precision Diangnostics, Sucat");
    }

    public void pasayMarker() {
        createMarkerDoh(pasayCitySocial, "Pasay City Social Hygiene Clinic");
    }

    public void mandaluyongMarker() {
        createMarker(anglo, "Love Yourself Anglo");
        createMarkerDoh(mandaluyongCitySocial, "Mandaluyong City Social Hygiene Clinic");
        createMarkerDoh(mandaluyongCityDrop, "Mandaluyong City -Drop-in Center");
        createMarkerDoh(theResearchManda, "The Research Institute for Tropical Medicine (Mandaluyong)");
    }

    public void taguigMarker() {
        createMarkerDoh(taguigCitySocial, "Taguig City Social Hygiene Clinic");
        createMarkerDoh(taguigCityDrop, "Taguig City Drop-in Centeer");
    }

    public void marikinaMarker() {
        createMarkerDoh(marikinaSocial, "Marikina Social Hygiene Clinic");
    }

    public void muntinlupaMarker() {
        createMarkerDoh(theResearchAlabang, "The Research Institute for Tropical Medicine (Alabang)");
        createMarkerDoh(muntinlupaHealth, "Muntinlupa Health Center");
        createMarkerDoh(hiPrecisionAlabang, "Hi-Precision Diagnostics Alabang");
    }


    @Override
    public void onInfoWindowClick(Marker marker) {
        BranchDialog branchDialog = new BranchDialog();
        Bundle bundle = new Bundle();
        switch (marker.getTitle()) {
            case "Love Yourself Anglo":
                bundle.putString("title", "anglo");
                break;
            case "Love Yourself Uni":
                bundle.putString("title", "uni");
                break;
            case "Caloocan City Social Hygiene Clinic":
                bundle.putString("title", "caloocanCitySocialHygienicClinic");
                break;
            case "Pasig City Health Development":
                bundle.putString("title", "pasigCityHealthDevelopment");
                break;
            case "Saint Camillus Medical Center":
                bundle.putString("title", "saintCamillusMedicalCenter");
                break;
            case "Quezon City Health Department":
                bundle.putString("title", "quezonCityHealthDepartment");
                break;
            case "Quezon City, Klinika Bernardo":
                bundle.putString("title", "quezonCityKlinikaBernardo");
                break;
            case "Makati Social Hygiene Clinic":
                bundle.putString("title", "makatiSocialHygieneClinic");
                break;
            case "Pedro Cruz Health Center":
                bundle.putString("title", "pedroCruzHealthCenter");
                break;
            case "Manila Social Hygiene Clinic":
                bundle.putString("title", "manilaSocialHygieneClinic");
                break;
            case "Las Piñas Social Hygiene Clinic":
                bundle.putString("title", "lasPinasDanielFajardoSocialHygieneClinic");
                break;
            case "Navotas City Health Office":
                bundle.putString("title", "navotasCityHealthOffice");
                break;
            case "Valenzuela Health Office":
                bundle.putString("title", "valenzuelaHealthOffice");
                break;
            case "Parañaque Social Hygiene Clinic and Wellness Center":
                bundle.putString("title", "paranaqueSocialHygieneClinicandWellnessCenter");
                break;
            case "Pasay City Social Hygiene Clinic":
                bundle.putString("title", "pasayCitySocialHygieneClinic");
                break;
            case "Mandaluyong City Social Hygiene Clinic":
                bundle.putString("title", "mandaluyongCitySocialHygieneClinic");
                break;
            case "Mandaluyong City -Drop-in Center":
                bundle.putString("title", "mandaluyongCityDropinCenter");
                break;
            case "Taguig City Social Hygiene Clinic":
                bundle.putString("title", "taguigCitySocialHygieneClinic");
                break;
            case "Taguig City Drop-in Centeer":
                bundle.putString("title", "taguigCityDropinCenter");
                break;
            case "Pateros Clinical Laboratory":
                bundle.putString("title", "paterosClinicalLaboratory");
                break;
            case "Marikina Social Hygiene Clinic":
                bundle.putString("title", "marikinaSocialHygieneClinic");
                break;
            case "AIDS Society of the Philippines":
                bundle.putString("title", "aIDSSocietyofthePhilippines");
                break;
            case "San Lazaro Hospital":
                bundle.putString("title", "sanLazaroHospital");
                break;
            case "Philippine General Hospital":
                bundle.putString("title", "philippineGeneralHospital");
                break;
            case "Makati Medical Center":
                bundle.putString("title", "makatiMedicalCenter");
                break;
            case "The Research Institute for Tropical Medicine (Alabang)":
                bundle.putString("title", "theResearchInstituteforTropicalMedicineAlabang");
                break;
            case "The Research Institute for Tropical Medicine (Malate)":
                bundle.putString("title", "theResearchInstituteforTropicalMedicineMalate");
                break;
            case "The Research Institute for Tropical Medicine (Mandaluyong)":
                bundle.putString("title", "theResearchInstituteforTropicalMedicineMandaluyong");
                break;
            case "Hi-Precision Diagnostics, Del Monte":
                bundle.putString("title", "hiPrecisionDiagnosticsDelMonte");
                break;
            case "Hi-Precision Diagnostics, Rockwell":
                bundle.putString("title", "hiPrecisionDiagnosticsRockwell");
                break;
            case "Hi-Precision Diagnostics, V.Luna":
                bundle.putString("title", "hiPrecisionDiagnosticsVLuna");
                break;
            case "Hi-Precision Diagnostics, Pasig":
                bundle.putString("title", "hiPrecisionDiagnosticsPasig");
                break;
            case "HPD International, Taft":
                bundle.putString("title", "hPDInternationalTaft");
                break;
            case "Hi-Precision Diagnostics, Kalaw":
                bundle.putString("title", "hiPrecisionDiagnosticsKalaw");
                break;
            case "Hi-Precision Diagnostics, Las Piñas":
                bundle.putString("title", "hiPrecisionDiagnosticsLasPinas");
                break;
            case "Megaclinic-ALS":
                bundle.putString("title", "megaclinicALS");
                break;
            case "Woodwater Center for Healing (Camillians)":
                bundle.putString("title", "woodwaterCenterforHealing");
                break;
            case "Pasig Social Hygiene Clinic":
                bundle.putString("title", "pasigSocialHygieneClinic");
                break;
            case "Jose Reyes Memorial Medical Center":
                bundle.putString("title", "joseReyesMemorialMedicalCenter");
                break;
            case "Muntinlupa Health Center":
                bundle.putString("title", "muntinlupaHealthCenter");
                break;
            case "Batasan Social Hygiene Clinic":
                bundle.putString("title", "batasanSocialHygieneClinic");
                break;
            case "Bernardo Social Hygiene Clinic":
                bundle.putString("title", "quezonCityBernardoSocialHygieneClinic");
                break;
            case "The Ship Foundation":
                bundle.putString("title", "theShipFoundation");
                break;
            case "Hi-Precision Diangnostics, Sucat":
                bundle.putString("title", "hiPrecisionDiangnosticsSucat");
                break;
            case "Hi-Precision Diagnostics Alabang":
                bundle.putString("title", "hiPrecisionDiangnosticsAlabang");
                break;
            case "Hi-Precision Diagnostics, East Avenue":
                bundle.putString("title", "hiPrecisionDiangnosticsEastAvenue");
                break;
        }

        branchDialog.setArguments(bundle);
        branchDialog.show(getFragmentManager(), "Branches Dialog");
    }
}



