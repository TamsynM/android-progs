package com.murphy.tamsyn.tamsynmurphyresumeapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.murphy.tamsyn.tamsynmurphyresumeapp.R;
import com.murphy.tamsyn.tamsynmurphyresumeapp.models.Education;

import java.util.List;

/**
 * Created by Tamsyn on 13/09/2015.
 */
public class EducationAdapter extends ArrayAdapter<Education> {

    private List<Education> myEducation;
    private Context myContext;

    public EducationAdapter(Context context, List<Education> colleges) {
        super(context, R.layout.education_custom_row, colleges);

        myEducation = colleges;
        myContext = context;
    }

    public Education getItem(int position) {
        if (position < myEducation.size()) {
            return myEducation.get(position);
        }
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        View view = convertView;
        Holder viewHolder;

        final Education selectedCollege = getItem(position);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.education_custom_row, null);

            viewHolder = new Holder();
            viewHolder.myCollegeName = (TextView)view.findViewById(R.id.college_name);
            viewHolder.myGraduationYear = (TextView)view.findViewById(R.id.graduation_year);
            viewHolder.myDegreeName = (TextView)view.findViewById(R.id.degree_name);
            viewHolder.mySubjects = (TextView)view.findViewById(R.id.college_subjects);

            viewHolder.myCollegeName.setText(selectedCollege.getCollegeName());
            viewHolder.myDegreeName.setText(selectedCollege.getDegreeName());
            viewHolder.myGraduationYear.setText(selectedCollege.getGraduationYear());
            viewHolder.mySubjects.setText(selectedCollege.getSubjects());
        }
        else {
            viewHolder = (Holder)view.getTag();
        }

        return view;
    }

    private class Holder{
        TextView myCollegeName;
        TextView myGraduationYear;
        TextView myDegreeName;
        TextView mySubjects;
    }
}
