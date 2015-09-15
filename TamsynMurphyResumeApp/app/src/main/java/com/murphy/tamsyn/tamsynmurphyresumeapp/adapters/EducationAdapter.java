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
import com.murphy.tamsyn.tamsynmurphyresumeapp.models.Education;

import java.util.List;

/**
 * Created by Tamsyn on 13/09/2015.
 */
public class EducationAdapter extends ArrayAdapter<Education> {

    private List<Education> myEducation;
    private Context myContext;
    LayoutInflater myInflater;

    public EducationAdapter(Context context, List<Education> colleges) {
        super(context, R.layout.education_custom_row, colleges);

        this.myContext = context;
        //myEducation = colleges;
        //myContext = context;
        this.myEducation = colleges;

        //myInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public Education getItem(int position) {
        if (position < myEducation.size()) {
            return myEducation.get(position);
        }
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        Holder viewHolder;

        final Education selectedCollege = getItem(position);

        if (view == null) {
            viewHolder = new Holder();
            LayoutInflater inflater = (LayoutInflater)  myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = (LinearLayout) inflater.inflate(R.layout.education_custom_row, null);

            viewHolder.myCollegeName = (TextView)view.findViewById(R.id.college_name);
            viewHolder.myDegreeName = (TextView)view.findViewById(R.id.degree_name);
            viewHolder.mySubjects = (TextView)view.findViewById(R.id.college_subjects);
            viewHolder.myGraduationYear = (TextView)view.findViewById(R.id.graduation_year);

            view.setTag(viewHolder);
        }
        else {
            viewHolder = (Holder)view.getTag();
        }
        viewHolder.myCollegeName.setText(selectedCollege.getCollegeName());
        viewHolder.myDegreeName.setText(selectedCollege.getDegreeName());
        viewHolder.mySubjects.setText(selectedCollege.getSubjects());
        viewHolder.myGraduationYear.setText(selectedCollege.getGraduationYear());

        view.setTag(viewHolder);
        return view;
    }

    private class Holder{
        TextView myCollegeName;
        TextView myDegreeName;
        TextView mySubjects;
        TextView myGraduationYear;
    }
}
