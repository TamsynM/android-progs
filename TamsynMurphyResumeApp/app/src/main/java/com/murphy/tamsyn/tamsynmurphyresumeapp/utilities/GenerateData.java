package com.murphy.tamsyn.tamsynmurphyresumeapp.utilities;

import com.murphy.tamsyn.tamsynmurphyresumeapp.R;
import com.murphy.tamsyn.tamsynmurphyresumeapp.models.Education;
import com.murphy.tamsyn.tamsynmurphyresumeapp.models.Employment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tamsyn on 13/09/2015.
 */
public class GenerateData {

    public static List<Education> getListOfSchool()
    {
        List<Education> colleges = new ArrayList<Education>();

        Education HWU = new Education();
        HWU.setCollegeName("Heriot-Watt University");
        HWU.setDegreeName("BSc in Computer Systems");
        HWU.setGraduationYear("2015");
        HWU.setSubjects("Software Engineering\n" +
                "Operations Management\n" +
                "Computer Graphics\n" +
                "Emerging Technologies\n" +
                "Interaction Design\n" +
                "Knowledge Management\n" +
                "Professional Development");
        colleges.add(HWU);

        Education CTI = new Education();
        CTI.setCollegeName("CTI Education Group");
        CTI.setDegreeName("HND in Information Systems (Software Development)");
        CTI.setSubjects("Computer Literacy\n" +
                "Processing & Logic Concepts\n" +
                "Program Design\n" +
                "Software Engineering\n" +
                "Database Design Concepts\n" +
                "Database Management\n" +
                "Creating Web Pages\n" +
                "C# (Full Language)\n" +
                "Linux OS\n" +
                "Hardware Essentials\n" +
                "Perl\n" +
                "PHP (Half Language)\n" +
                "Project Management");
        CTI.setGraduationYear("2013");
        colleges.add(CTI);

        Education NH1 = new Education();
        NH1.setCollegeName("New Horizons Computer Learning Centre");
        NH1.setDegreeName("Pastel Partner 2007");
        NH1.setGraduationYear("2008");
        colleges.add(NH1);

        Education NH2 = new Education();
        NH2.setCollegeName("New Horizons Computer Learning Centre");
        NH2.setDegreeName("Adobe Photoshop Level 1");
        NH2.setGraduationYear("2008");
        colleges.add(NH2);

        Education VC1 = new Education();
        VC1.setCollegeName("Varsity College");
        VC1.setDegreeName("Pastel Accounting");
        VC1.setGraduationYear("2007");
        colleges.add(VC1);

        Education VC2 = new Education();
        VC2.setCollegeName("Varsity College");
        VC2.setDegreeName("Financial Accounting");
        VC2.setGraduationYear("2007");
        colleges.add(VC2);

        Education MB = new Education();
        MB.setCollegeName("Montrose Business College");
        MB.setDegreeName("Secretarial Course");
        MB.setSubjects("Litigation\n" +
                "Practical Bookkeeping\n" +
                "Typing\n" +
                "Office Procedures");
        MB.setGraduationYear("2005");
        colleges.add(MB);

        Education NH3 = new Education();
        NH3.setCollegeName("New Horizons Computer Learning Centre");
        NH3.setDegreeName("MCSE Bundle");
        NH3.setSubjects("A+, Network+, Microsoft Office");
        NH3.setGraduationYear("2003");
        colleges.add(NH3);

        return colleges;
    }

    public static List<Employment> getListOfCompanies(){
        List<Employment> companies = new ArrayList<>();

        Employment WPW1 = new Employment();
        WPW1.setWorkName("Warwick Private Wealth");
        WPW1.setPositionName("Xplan/Database Administrator");
        WPW1.setDurationEmployed("September 2011 - November 2014");
        WPW1.setWorkDuties("Manage and administer data on our online client database program (xPlan)\n" +
                "Help manage and maintain the online database system and correct information as I go along if I see it is incorrect\n" +
                "Help all staff with anything they might need where I can (on our online database system and with other issues they might have including computer-related issues)\n" +
                "Pull reports off of the database on a monthly basis\n" +
                "Train staff on how to use our online database system (both current staff and new staff)  and am always on call if they have questions \n" +
                "Focus on our online database system when not busy with other work to properly clean up the database so that it is auditable\n" +
                "Help regions when they phone in with queries including helping them when they struggle pulling their reports\n" +
                "Pull reports on a monthly bases\n" +
                "Maintain and add/remove Users from the online database system\n" +
                "Edit the interface of the online database system when needed\n" +
                "Create/maintain templates for tasks and other functions for Users when needed");
        companies.add(WPW1);

        Employment WPW2 = new Employment();
        WPW2.setWorkName("Warwick Private Wealth");
        WPW2.setPositionName("Client Relationship Manager");
        WPW2.setDurationEmployed("September 2009 - August 2011");
        WPW2.setWorkDuties("Make appointments\n" +
                "Liaise with clients on a monthly basis\n" +
                "Put deal pack together\n" +
                "Do all admin work relating to client requests\n" +
                "Capture data onto our client database management system");
        companies.add(WPW2);

        Employment MC = new Employment();
        MC.setWorkName("Montis Consulting Services");
        MC.setPositionName("Personal Assistant");
        MC.setDurationEmployed("March 2008 - August 2009");
        MC.setWorkDuties("Help with the day-to-day duties\n" +
                "Phoning clients\n" +
                "Reception\n" +
                "Typing\n" +
                "Managing Directors diary\n" +
                "Making appointments\n" +
                "Managing cash flow statement");
        companies.add(MC);

        Employment DPB = new Employment();
        DPB.setWorkName("Divaris Property Brokers");
        DPB.setPositionName("Receptionist");
        DPB.setDurationEmployed("November 2005 - September 2007");
        DPB.setWorkDuties("Answer telephone\n" +
                "Take messages\n" +
                "Prepare and print tax invoices\n" +
                "Stock Lists\n" +
                "Typing \n" +
                "Preparing and placing adverts");
        companies.add(DPB);

        Employment UC = new Employment();
        UC.setWorkName("Urban Connection");
        UC.setPositionName("Computer Technician");
        UC.setDurationEmployed("January 2005");
        UC.setWorkDuties("Fixing Hardware and Software problems for customers");
        companies.add(UC);

        Employment IC1 = new Employment();
        IC1.setWorkName("Incredible Connection");
        IC1.setPositionName("Casual Sales Person");
        IC1.setDurationEmployed("December 2004");
        IC1.setWorkDuties("Check the stock\n" +
                "Sell computer-related goods to customers\n" +
                "Help customers with their computer-related queries");
        companies.add(IC1);

        Employment IC2 = new Employment();
        IC2.setWorkName("Incredible Connection");
        IC2.setPositionName("Computer Technician");
        IC2.setDurationEmployed("July 2004 - September 2004");
        IC2.setWorkDuties("Help customers with their computer-related problem over the phone or in store\n" +
                "Send computers and printers back to suppliers when needed");
        companies.add(IC2);

        Employment IC3 = new Employment();
        IC3.setWorkName("Incredible Connection");
        IC3.setPositionName("Casual Sales Person");
        IC3.setDurationEmployed("May 2004 - June 2004");
        IC3.setWorkDuties("Check the stock\n" +
                "Sell computer-related goods to customers\n" +
                "Help customers with their computer-related queries");
        companies.add(IC3);

        return companies;
    }
}
