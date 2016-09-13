package com.sharingan.sharathbhargav.maps2;


import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, com.google.android.gms.location.LocationListener {


    private GoogleMap mMap;
    Button test;
    Marker che;
    boolean isGPSEnabled = false;
    boolean isNetworkEnabled = false;

    Location location;
    LocationManager locationManager;
    double longitude, latitude;

    // Stores the current instantiation of the location client in this object


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            mMap.getUiSettings().setMyLocationButtonEnabled(true);
            mMap.setMyLocationEnabled(true);

        }
        Location loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (loc == null) {
            loc = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if (loc == null) {
                loc = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
            }
            if (loc != null) {
                latitude = loc.getLatitude();
                longitude = loc.getLongitude();

            }
        }

        test = (Button) findViewById(R.id.button2);


        if (isGPSEnabled || isNetworkEnabled) {


        }

        // if (isNetworkEnabled) {
        //     locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1, 5, (LocationListener) this);
////
        //     if (locationManager != null) {
        //         location = locationManager
        //                 .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        //         if (location != null) {
        //             latitude = location.getLatitude();
        //             longitude = location.getLongitude();
        //         }
        //     }
        // }
//
//
       // if (isGPSEnabled) {
       //     if (location == null) {
       //         locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 10, (LocationListener) this);
       //         if (locationManager != null) {
       //             if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
       //                 location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
       //                 return;
       //             }
//
       //                 if (location != null) {
       //                     latitude = location.getLatitude();
       //                     longitude = location.getLongitude();
       //                 }
       //             }
       //         }
       //     }


    }

    @Override
    public void onConnected(Bundle connectionHint) {
    }

    @Override
    public void onConnectionSuspended(int i) {
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
        LatLng current=new LatLng(latitude,longitude);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.addMarker(new MarkerOptions().position(current).title("Marker at current location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(current));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 17f));
        drawCircle(new LatLng(latitude,longitude));


        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mMap.clear();
                che = mMap.addMarker(new MarkerOptions().position(latLng));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(18f));
                drawCircle(latLng);
                latitude=latLng.latitude;
                longitude=latLng.longitude;
            }
        });
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent temp = new Intent(getApplicationContext(), Profile_selection.class);

               temp.putExtra("latitude",latitude);
                temp.putExtra("longitude",longitude);
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    //stopService(temp);
                //    Toast.makeText(getApplicationContext(),"s",Toast.LENGTH_SHORT).show();

                }

                String s=latitude+" "+longitude;

                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
                startActivity(temp);
            }
        });
    }


    private void drawCircle(LatLng point){

        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(point);
        circleOptions.radius(20);
        circleOptions.strokeColor(Color.BLACK);
        circleOptions.fillColor(Color.rgb(148,214,245));
        circleOptions.strokeWidth(2);
        mMap.addCircle(circleOptions);

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {

    }
}
