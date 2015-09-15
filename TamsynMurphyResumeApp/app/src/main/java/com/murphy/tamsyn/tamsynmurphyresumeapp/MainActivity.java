package com.murphy.tamsyn.tamsynmurphyresumeapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.murphy.tamsyn.tamsynmurphyresumeapp.adapters.ViewPagerAdapter;
import com.murphy.tamsyn.tamsynmurphyresumeapp.utilities.SlidingTabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private SlidingTabLayout tabs;
    private ViewPagerAdapter adapter;

    private android.support.v7.widget.Toolbar myToolbar;


    private CharSequence Titles[] = {"Summary", "Education", "Employment"};
    private int numberOfTabs = 3;
    private TypedValue mTypedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        setupViewPager();
    }

    private void setupViewPager() {
        //Creating the ViewPagerAdapter and passing fragment manager, titles for the tabs
        //and the number of tabs
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), Titles, numberOfTabs);

        //Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        //Assigning the sliding tab layout view
        tabs = (SlidingTabLayout) findViewById(R.id.tab);
        tabs.setDistributeEvenly(true); //To make the tabs fixed set this true

        //Setting custom colour for the scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                //return getResources().getColor(R.color.mybiographybox, AppTheme);
                //return ContextCompat.getColor(this, R.color.mybiographybox);
                //ContextCompat.getColor();
                return getResources().getColor(R.color.mybiographybox);
                //return context.getColor(R.color.mybiographybox);
            }
        });

        //Setting the ViewPager for the slidingtabslayout
        tabs.setViewPager(pager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_email:
                //send email
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "tamsyn.murphy@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "RE: Resume");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(emailIntent, "Send email"));
                break;
            case R.id.action_phone:
                //show phone dialer with phone number
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + Uri.encode("+447809132582")));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(callIntent);
                break;
            case R.id.action_linkedin:
                //go to linkedin
                Intent linkedinIntent = new Intent(Intent.ACTION_VIEW);
                linkedinIntent.setData(Uri.parse("https://uk.linkedin.com/in/tamsynmurphy"));
                startActivity(Intent.createChooser(linkedinIntent, "View LinkedIn Profile"));
                //startActivity(linkedinIntent);
                break;
            case R.id.action_tweet:
                //go to twitter
                Intent twitterIntent = new Intent(Intent.ACTION_VIEW);
                twitterIntent.setData(Uri.parse("https://twitter.com/TamsynMMurphy"));
                startActivity(Intent.createChooser(twitterIntent, "View Twitter Page"));
                //startActivity(twitterIntent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
