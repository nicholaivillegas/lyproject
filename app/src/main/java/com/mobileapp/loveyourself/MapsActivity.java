package com.mobileapp.loveyourself;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

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

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener, GoogleMap.OnInfoWindowCloseListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;
    private Button buttonCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        buttonCenter = (Button) findViewById(R.id.btn_center);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        buttonCenter.setOnClickListener(this);
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

        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);

        addMarkerLuzon();

        centerScreen();
        mMap.setOnMarkerClickListener(this);
        mMap.setOnInfoWindowClickListener(this);
        mMap.setOnInfoWindowCloseListener(this);
    }

    public void centerScreen() {
        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(14.6091, 121.0223));
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(11);

        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
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

        }

        branchDialog.setArguments(bundle);
        branchDialog.show(getFragmentManager(), "Branch Dialog");

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
}



