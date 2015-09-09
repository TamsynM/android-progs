package com.murphy.tamsyn.intentexample1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Luke on 09/09/2015.
 */
public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detail);
    }

    @Override
    protected void onResume() {
        //set the text view using the intent extras
        super.onResume();
        TextView tv = (TextView) findViewById(R.id.textView);
        String intentData = getIntent().getStringExtra("data");
        tv.setText(intentData);
    }
}
