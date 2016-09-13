package com.sharingan.sharathbhargav.maps2;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

/**
 * Created by Sharath Bhargav on 9/12/2016.
 */
public class Profile_selection extends AppCompatActivity implements OnMapReadyCallback {
    RadioButton general, silent, meet, home, custom;
    Button select;
    RadioGroup r1;
    int selectid;
    Intent gen;
    LocationManager locationManager;
    double longitude, latitude;
    String keyName,value;
    // Intent temp;
    PendingIntent pIntent;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_selection);
        r1 = (RadioGroup) findViewById(R.id.radioGroup);
        general = (RadioButton) findViewById(R.id.general);
        silent = (RadioButton) findViewById(R.id.silent);
        meet = (RadioButton) findViewById(R.id.work);
        home = (RadioButton) findViewById(R.id.home);
        select = (Button) findViewById(R.id.select);
        custom = (RadioButton) findViewById(R.id.customProfile);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Intent temp=getIntent();
        latitude = temp.getDoubleExtra("latitude", 0);
        longitude = temp.getDoubleExtra("longitude", 0);
        String s=latitude+" "+longitude;
        keyName=temp.getStringExtra("name1");
        keyName="name1";
        Toast.makeText(getApplicationContext(),keyName, Toast.LENGTH_SHORT).show();
        gen = new Intent(getApplicationContext(), myService.class);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                value = ((RadioButton)findViewById(r1.getCheckedRadioButtonId() )).getText().toString();
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
                if (value.compareTo("General")==0) {
                    gen.putExtra(keyName, "general");
                    pIntent = PendingIntent.getService(getApplicationContext(), 1, gen, PendingIntent.FLAG_CANCEL_CURRENT);


                }
                else if (value.compareTo("Silent")==0) {
                    gen.putExtra(keyName, "silent");
                    pIntent = PendingIntent.getService(getApplicationContext(), 1, gen, PendingIntent.FLAG_CANCEL_CURRENT);

                }
                else if (value.compareTo("Work")==0) {
                    gen.putExtra(keyName, "meet");
                    pIntent = PendingIntent.getService(getApplicationContext(), 1, gen, PendingIntent.FLAG_CANCEL_CURRENT);

                }
                else if (value.compareTo("Home")==0) {
                    gen.putExtra(keyName, "home");
                    pIntent = PendingIntent.getService(getApplicationContext(), 1, gen, PendingIntent.FLAG_CANCEL_CURRENT);

                }
                else if (value.compareTo("Custom")==0) {
                    pIntent = PendingIntent.getService(getApplicationContext(), 1, gen, PendingIntent.FLAG_CANCEL_CURRENT);
                    gen.putExtra(keyName, "custom");
                }


                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                }
               // pIntent = PendingIntent.getService(getApplicationContext(), 1, gen, PendingIntent.FLAG_ONE_SHOT);
                locationManager.addProximityAlert(latitude, longitude, 50, -1, pIntent);


            }

        });

    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}



