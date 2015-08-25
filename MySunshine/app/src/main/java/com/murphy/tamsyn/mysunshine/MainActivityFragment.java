package com.murphy.tamsyn.mysunshine;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ArrayAdapter<String> mForecastAdapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container);

        String[] detailsArray = {
                "Name: Tamsyn Murphy",
                "Blog: https://tamsynmurphy.wordpress.com/",
                "https://about.me/TamsynMurphy",
                "@TamsynMMurphy"
        };

        //List<String> allData = new ArrayList<String>(
                //Arrays.asList(detailsArray));

        List<String> weekForecast = new ArrayList<String>(
                Arrays.asList(detailsArray));

        mForecastAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list_item_forecast,
                R.id.list_item_forecast_textview,
                weekForecast);

        ListView listView = (ListView) rootView.findViewById(
                R.id.listview_forecast);

        listView.setAdapter(mForecastAdapter);

       return rootView;
        //return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
