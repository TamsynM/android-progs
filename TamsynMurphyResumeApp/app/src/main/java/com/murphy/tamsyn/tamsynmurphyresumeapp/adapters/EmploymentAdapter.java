package com.murphy.tamsyn.tamsynmurphyresumeapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    LayoutInflater myInflater;

    public EmploymentAdapter(Context context, List<Employment> employment) {
        super(context, R.layout.employment_custom_row, employment);

        this.myCompanies = employment;
        this.myContext = context;
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

            viewHolder = new Holder();
            LayoutInflater inflater = (LayoutInflater)  myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = (LinearLayout) inflater.inflate(R.layout.employment_custom_row, null);

            viewHolder.myPosition = (TextView)view.findViewById(R.id.employment_position);
            viewHolder.myEmployer = (TextView)view.findViewById(R.id.employer_name);
            viewHolder.myDuties = (TextView)view.findViewById(R.id.employment__duties);
            viewHolder.myDuration = (TextView)view.findViewById(R.id.employment_duration);

            view.setTag(viewHolder);

        }else {
            viewHolder = (Holder)view.getTag();
        }

        viewHolder.myPosition.setText(selectedCompany.getPositionName());
        viewHolder.myEmployer.setText(selectedCompany.getWorkName());
        viewHolder.myDuties.setText(selectedCompany.getWorkDuties());
        viewHolder.myDuration.setText(selectedCompany.getDurationEmployed());

        return view;
    }

    private class Holder{
        TextView myPosition;
        TextView myEmployer;
        TextView myDuties;
        TextView myDuration;


    }
}
