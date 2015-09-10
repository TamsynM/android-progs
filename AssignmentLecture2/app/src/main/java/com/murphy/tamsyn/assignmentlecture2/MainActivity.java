package com.murphy.tamsyn.assignmentlecture2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Model model;

    public MainActivity() { model = new Model();}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addInfo(View view) {
        EditText input1 = (EditText)findViewById(R.id.nametxtfield);
        EditText input2 = (EditText)findViewById(R.id.lastnametxtfield);
        EditText input3 = (EditText)findViewById(R.id.addresstxtfield);
        EditText input4 = (EditText)findViewById(R.id.enterdob);

        TextView output1 = (TextView)findViewById(R.id.output);

        model.addString(input1.getText().toString());
        model.addString(input2.getText().toString());
        model.addString(input3.getText().toString());
        model.addString(input4.getText().toString());

        //get the full list from the model, and display it:
        output1.setText(model.getList());

        input1.setText("");
        input2.setText("");
        input3.setText("");
        input4.setText("");
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
