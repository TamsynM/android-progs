package com.murphy.tamsyn.tamsynmurphyresumeapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.murphy.tamsyn.tamsynmurphyresumeapp.R;
import com.murphy.tamsyn.tamsynmurphyresumeapp.models.Employment;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Tamsyn on 13/09/2015.
 */
public class EmploymentAdapter extends ArrayAdapter<Employment> {

    private List<Employment> myCompanies;
    private Context myContext;

    public EmploymentAdapter(Context context, List<Employment> employment) {
        super(context, R.layout.employment_custom_row, employment);

        myCompanies = employment;
        myContext = context;
    }

    @Override
    public Employment getItem(int position) {
        if (position < myCompanies.size()){
            return myCompanies.get(position);
        }

        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        Holder viewHolder;

        final Employment selectedCompany = getItem(position);

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.employment_custom_row, null);

            viewHolder = new Holder();
            viewHolder.myEmployer = (TextView)view.findViewById(R.id.employer_name);
            viewHolder.myPosition = (TextView)view.findViewById(R.id.employment_position);
            viewHolder.myDuties = (TextView)view.findViewById(R.id.employment__duties);
            viewHolder.myDuration = (TextView)view.findViewById(R.id.employment_duration);

            viewHolder.myEmployer.setText(selectedCompany.getWorkName());
            viewHolder.myPosition.setText(selectedCompany.getPositionName());
            viewHolder.myDuties.setText(selectedCompany.getWorkDuties());
            viewHolder.myDuration.setText(selectedCompany.getDurationEmployed());
        }else {
            viewHolder = (Holder)view.getTag();
        }

        return view;
    }

    private class Holder{
        TextView myEmployer;
        TextView myPosition;
        TextView myDuties;
        TextView myDuration;


    }
}
