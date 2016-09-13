package com.sharingan.sharathbhargav.maps2;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Sharath Bhargav on 9/12/2016.
 */
public class TwoFragment extends android.support.v4.app.Fragment {


    public TwoFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        Button mapButton = (Button) view.findViewById(R.id.mapButton);
    mapButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

                    Intent in=new Intent(view.getContext(),MapsActivity.class);
                    startActivity(in);

        }
    });
        return view;
    }


}
