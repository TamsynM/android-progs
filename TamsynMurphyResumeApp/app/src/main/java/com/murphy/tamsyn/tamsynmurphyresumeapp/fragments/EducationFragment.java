package com.murphy.tamsyn.tamsynmurphyresumeapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.murphy.tamsyn.tamsynmurphyresumeapp.R;
import com.murphy.tamsyn.tamsynmurphyresumeapp.adapters.EducationAdapter;
import com.murphy.tamsyn.tamsynmurphyresumeapp.models.Education;
import com.murphy.tamsyn.tamsynmurphyresumeapp.utilities.GenerateData;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EducationFragment extends Fragment {

    private EducationAdapter myEduAdapter;
    private List<Education> myEducation;
    private ListView myListView;
    private View myRootView;


    public EducationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myRootView = inflater.inflate(R.layout.fragment_education, container, false);

        //Get the list of education you want to include
        myEducation = GenerateData.getListOfSchool();
        myListView = (ListView)myRootView.findViewById(R.id.education_list);
        myEduAdapter = new EducationAdapter(getActivity(), myEducation);
        myListView.setAdapter(myEduAdapter);

        return myRootView;
    }


}
