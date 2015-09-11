package com.murphy.tamsyn.enhancedhelloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.murphy.tamsyn.myapplication.R;

import java.util.Calendar;

public class Hello extends AppCompatActivity {

    private String gender, name, greeting, prefix, personalisedGreeting;

    private TextView myTextGreeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        myTextGreeting = (TextView)findViewById(R.id.hello_greeting);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            if (bundle.containsKey("gender")) {
                gender = bundle.getString("gender", "");
            }

            if (bundle.containsKey("name")) {
                name = bundle.getString("name", "");
            }
        }

        greeting = getGreeting();

        prefix = gender.equals("M") ? "Mr" : "Ms";

        personalisedGreeting = getGreeting() + ", " + prefix + " " + name;
        myTextGreeting.setText(personalisedGreeting);
    }

    private String getGreeting() {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        String greeting = "?";
        if (hour > 0 && hour <= 12)
            greeting = "Good Morning";
        else
            if (hour > 12 && hour <= 17)
                greeting = "Good Afternoon";
        else
            if (hour > 17 && hour <= 24)
                greeting = "Good Evening";

        return greeting;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hello, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
