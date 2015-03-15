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

import org.w3c.dom.Text;


public class ShelemSheetActivity extends ActionBarActivity {

    private Button mSubmitButton;
    int colNumber = 0;



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

                TextView[] leftCol = new TextView[19];
                TextView[] rightCol = new TextView[19];
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
                        TextView finalA = (TextView)findViewById(R.id.textViewAFinal);
                  //      finalA.setText(pointA.getText().toString());



                        TextView finalB = (TextView) findViewById(R.id.textViewBFinal);
                        finalB.setText(pointB.getText().toString());

                        //set results line by line
                        leftCol[colNumber] = getIdLeft(colNumber);
                        leftCol[colNumber].setText(pointA.getText());
                        rightCol[colNumber] = getIdRight(colNumber);
                        rightCol[colNumber].setText(pointB.getText());
                        colNumber = colNumber + 1;
                        //set final points
                        finalA.setText(calcLeftPoints());
                        //clear numbers after submit
                        pointA.setText("");
                        pointB.setText("");
                    }
                }

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


    //probably need to map ids for loop
    //TODO: remove hardcodig!!
    public TextView getIdLeft(int colNumber){
        switch (colNumber){
            case 0: return (TextView)findViewById(R.id.textViewL0);
            case 1: return (TextView)findViewById(R.id.textViewL1);
            case 2: return (TextView)findViewById(R.id.textViewL2);
            case 3: return (TextView)findViewById(R.id.textViewL3);
            case 4: return (TextView)findViewById(R.id.textViewL4);
            case 5: return (TextView)findViewById(R.id.textViewL5);
            case 6: return (TextView)findViewById(R.id.textViewL6);
            case 7: return (TextView)findViewById(R.id.textViewL7);
            case 8: return (TextView)findViewById(R.id.textViewL8);
            case 9: return (TextView)findViewById(R.id.textViewL9);
            case 10: return (TextView)findViewById(R.id.textViewL10);
            case 11: return (TextView)findViewById(R.id.textViewL11);
            case 12: return (TextView)findViewById(R.id.textViewL12);
            case 13: return (TextView)findViewById(R.id.textViewL13);
            case 14: return (TextView)findViewById(R.id.textViewL14);
            case 15: return (TextView)findViewById(R.id.textViewL15);
            case 16: return (TextView)findViewById(R.id.textViewL16);
            case 17: return (TextView)findViewById(R.id.textViewL17);
            case 18: return (TextView)findViewById(R.id.textViewL18);
        }
    return null;

    }
    //probably need to map ids for loop
    public TextView getIdRight(int colNumber){
        switch (colNumber){
            case 0: return (TextView)findViewById(R.id.textViewR0);
            case 1: return (TextView)findViewById(R.id.textViewR1);
            case 2: return (TextView)findViewById(R.id.textViewR2);
            case 3: return (TextView)findViewById(R.id.textViewR3);
            case 4: return (TextView)findViewById(R.id.textViewR4);
            case 5: return (TextView)findViewById(R.id.textViewR5);
            case 6: return (TextView)findViewById(R.id.textViewR6);
            case 7: return (TextView)findViewById(R.id.textViewR7);
            case 8: return (TextView)findViewById(R.id.textViewR8);
            case 9: return (TextView)findViewById(R.id.textViewR9);
            case 10: return (TextView)findViewById(R.id.textViewR10);
            case 11: return (TextView)findViewById(R.id.textViewR11);
            case 12: return (TextView)findViewById(R.id.textViewR12);
            case 13: return (TextView)findViewById(R.id.textViewR13);
            case 14: return (TextView)findViewById(R.id.textViewR14);
            case 15: return (TextView)findViewById(R.id.textViewR15);
            case 16: return (TextView)findViewById(R.id.textViewR16);
            case 17: return (TextView)findViewById(R.id.textViewR17);
            case 18: return (TextView)findViewById(R.id.textViewR18);
        }
        return null;

    }

    public String calcLeftPoints(){
        //TODO: Note this should not be hardcoded!
        int[] leftPoints = new int[18];
        for (int i=0;i<18;i++)
            leftPoints[i]=0;

        TextView L0 = getIdLeft(0);
        //TODO: this is just for empty text, note if we hae text in "smallText"(in strings.xml) it crashes!
        if (!L0.getText().toString().isEmpty())
            leftPoints[0] = Integer.parseInt(L0.getText().toString());


        TextView L1 = getIdLeft(1);
        if (!L1.getText().toString().isEmpty())
            leftPoints[1] = Integer.parseInt(L1.getText().toString());

        return String.valueOf(leftPoints[0]+leftPoints[1]);

    }

}
