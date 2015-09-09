package com.murphy.tamsyn.mvc_example;

/**
 * Created by Luke on 09/09/2015.
 */

import java.util.ArrayList;

public class Model {

    /**
     * A good model hides the implementation of its data.  Here, the list
     * is implemented as an ArrayList.  The controller passes the model a
     * string as input, and expects a string as the output.  The details of
     * how this is done are known only to the model
     */
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
