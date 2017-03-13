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

        LatLng anglo = new LatLng(14.583544, 121.051299);
        mMap.addMarker(new MarkerOptions().position(anglo)
                .title("Love Yourself Anglo")
                .snippet("(Tap here to view branch)"));
//                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(anglo));

        LatLng uni = new LatLng(14.554933, 120.997198);
        mMap.addMarker(new MarkerOptions().position(uni)
                .title("Love Yourself Uni")
                .snippet("(Tap here to view branch)"));
//                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(uni));
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
        switch (marker.getTitle())
        {
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
}



