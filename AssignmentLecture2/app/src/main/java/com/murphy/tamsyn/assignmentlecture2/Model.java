package com.murphy.tamsyn.assignmentlecture2;

/**
 * Created by Tamsyn Murphy on 10/09/2015.
 */

import java.util.ArrayList;

public class Model {
    private ArrayList<String> stringList;

    {
        stringList = new ArrayList<String>();
    }

    public void addString(String str){
        //accept a string an add it to the list:
        stringList.add(str);
    }

    public String getList() {
        //return a string representation of the list:
        String retVal = new String();
        for (String str : stringList)
            retVal = String.format("%s %s", retVal, str);

        return retVal;
    }
}
