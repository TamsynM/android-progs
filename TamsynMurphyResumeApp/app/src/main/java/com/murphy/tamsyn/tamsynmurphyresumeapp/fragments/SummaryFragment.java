package com.murphy.tamsyn.tamsynmurphyresumeapp.fragments;


import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.murphy.tamsyn.tamsynmurphyresumeapp.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class SummaryFragment extends Fragment {

    private ImageView myProfilePicture;
    private View myRootView;


    public SummaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_summary, container, false);
        myRootView = inflater.inflate(R.layout.fragment_summary, container, false);

        myProfilePicture = (ImageView)myRootView.findViewById(R.id.myFace);

        Picasso.with(getActivity()).load(R.drawable.my_face).fit().into(myProfilePicture);

        return myRootView;
    }


}
