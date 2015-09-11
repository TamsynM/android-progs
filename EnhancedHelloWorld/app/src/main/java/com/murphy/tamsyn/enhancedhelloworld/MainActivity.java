package com.murphy.tamsyn.enhancedhelloworld;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.murphy.tamsyn.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private EditText enterYourName;
    private Button submitButton;
    private Activity myActivity;
    private String name, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterYourName = (EditText)findViewById(R.id.enter_name);
        submitButton = (Button)findViewById(R.id.submit_btn);
        myActivity = this;

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (enterYourName.getText().toString().isEmpty()) {
                    Toast.makeText(myActivity, "Enter your name dummy!!", Toast.LENGTH_SHORT).show();
                } else {
                    name = enterYourName.getText().toString();

                    //We need to now parcel the name and gender into a bundle
                    //to send it to the next Activity
                    Intent intent = new Intent(MainActivity.this, Hello.class);
                    intent.putExtra("gender", gender);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
            }
        });
    }

    public void onRadioBtnClick(View view) {
        //is the radio button checked?
        boolean checked = ((RadioButton)view).isChecked();

        //find out which button is checked
        switch (view.getId()) {
            case R.id.checkbox_male:
                if (checked) {
                    gender = "M";
                }
                break;
            case R.id.checkbox_female:
                if (checked) {
                    gender = "F";
                }
                break;
        }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
