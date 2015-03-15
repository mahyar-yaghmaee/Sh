package com.android.mahyar.shelemsheet;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ShelemSheetActivity extends ActionBarActivity {

    private Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelem_sheet);

        mSubmitButton = (Button)findViewById(R.id.buttonSubmit);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText pointA = (EditText)findViewById(R.id.editTextA);
                EditText pointB = (EditText)findViewById(R.id.editTextB);
                //1 - check if fields are empty
                if (pointA.getText().toString().isEmpty() || pointB.getText().toString().isEmpty())
                    Toast.makeText(ShelemSheetActivity.this,R.string.emptyNumber,Toast.LENGTH_SHORT).show();

                else {
                    int pointA_int = Integer.parseInt(pointA.getText().toString());
                    int pointB_int = Integer.parseInt(pointB.getText().toString());
                    // make sure in range
                    if (pointA_int > 165 || pointA_int < -165 || pointB_int > 165 || pointB_int < -165) {
                        Toast.makeText(ShelemSheetActivity.this, R.string.unvalidNumber, Toast.LENGTH_SHORT).show();
                    } else {
                        TextView finalA = (TextView) findViewById(R.id.textViewAFinal);
                        finalA.setText(pointA.getText().toString());
                        TextView finalB = (TextView) findViewById(R.id.textViewBFinal);
                        finalB.setText(pointB.getText().toString());
                    }
                }
                //clear numbers after submit
                pointA.setText("");
                pointB.setText("");
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shelem_sheet, menu);
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
