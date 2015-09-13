package com.murphy.tamsyn.tamsynmurphyresumeapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.murphy.tamsyn.tamsynmurphyresumeapp.R;
import com.murphy.tamsyn.tamsynmurphyresumeapp.adapters.EmploymentAdapter;
import com.murphy.tamsyn.tamsynmurphyresumeapp.models.Employment;
import com.murphy.tamsyn.tamsynmurphyresumeapp.utilities.GenerateData;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmploymentFragment extends Fragment {

    private EmploymentAdapter myEmployAdapter;
    private List<Employment> myEmployment;
    private ListView myEmploymentListView;
    private View myEmploymentRootView;


    public EmploymentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myEmploymentRootView = inflater.inflate(R.layout.fragment_employment, container, false);

        //Get the list of employment you want to include
        myEmployment = GenerateData.getListOfCompanies();
        myEmploymentListView = (ListView)myEmploymentRootView.findViewById(R.id.listview_employment);
        myEmployAdapter = new EmploymentAdapter(getActivity(), myEmployment);
        myEmploymentListView.setAdapter(myEmployAdapter);

        return myEmploymentRootView;
    }


}
