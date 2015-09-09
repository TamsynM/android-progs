package com.murphy.tamsyn.intentexample2;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

/**
 * Created by Tamsyn on 10/09/2015.
 */
public class DetailActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    public void buttonPressed(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        Intent data = getIntent();
        data.putExtra("choice", buttonText);
        this.setResult(Activity.RESULT_OK, data);
        finish();
    }
}
