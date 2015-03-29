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
    int MAX_ROW_NUM = 26;



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

                TextView[] leftCol = new TextView[MAX_ROW_NUM];
                TextView[] rightCol = new TextView[MAX_ROW_NUM];
                //1 - check if fields are empty
                if (pointA.getText().toString().isEmpty() || pointB.getText().toString().isEmpty())
                    Toast.makeText(ShelemSheetActivity.this,
                            R.string.emptyNumber,Toast.LENGTH_SHORT).show();

                else {
                    int pointA_int = Integer.parseInt(pointA.getText().toString());
                    int pointB_int = Integer.parseInt(pointB.getText().toString());
                    // make sure in range
                    //TODO: config this
                    if (pointA_int > 330 || pointA_int < -330 || pointB_int > 330 ||
                            pointB_int < -330 || pointA_int%5 != 0 || pointB_int%5 !=0) {
                        Toast.makeText(ShelemSheetActivity.this, R.string.invalidNumber,
                                Toast.LENGTH_SHORT).show();
                    } else {
                        TextView finalA = (TextView)findViewById(R.id.textViewAFinal);
                        TextView finalB = (TextView) findViewById(R.id.textViewBFinal);
                        //set results line by line
                        leftCol[colNumber] = getIdLeft(colNumber);
                        leftCol[colNumber].setText(pointA.getText());
                        rightCol[colNumber] = getIdRight(colNumber);
                        rightCol[colNumber].setText(pointB.getText());
                        colNumber = colNumber + 1;
                        //set final points
                        finalA.setText(calcLeftPoints());
                        finalB.setText(calcRightPoints());
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
            case 19: return (TextView)findViewById(R.id.textViewL19);
            case 20: return (TextView)findViewById(R.id.textViewL20);
            case 21: return (TextView)findViewById(R.id.textViewL21);
            case 22: return (TextView)findViewById(R.id.textViewL22);
            case 23: return (TextView)findViewById(R.id.textViewL23);
            case 24: return (TextView)findViewById(R.id.textViewL24);
            case 25: return (TextView)findViewById(R.id.textViewL25);
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
            case 19: return (TextView)findViewById(R.id.textViewR19);
            case 20: return (TextView)findViewById(R.id.textViewR20);
            case 21: return (TextView)findViewById(R.id.textViewR21);
            case 22: return (TextView)findViewById(R.id.textViewR22);
            case 23: return (TextView)findViewById(R.id.textViewR23);
            case 24: return (TextView)findViewById(R.id.textViewR24);
            case 25: return (TextView)findViewById(R.id.textViewR25);
        }
        return null;

    }

    //cal total results for left side
    public String calcLeftPoints(){
        //TODO: Note this should not be hardcoded!
        int result = 0;
        int[] leftPoints = new int[MAX_ROW_NUM];
        for (int i=0 ; i<MAX_ROW_NUM ; i++)
            leftPoints[i]=0;
        TextView[] leftCol = new TextView[MAX_ROW_NUM];

        for (int i=0 ; i<MAX_ROW_NUM ; i++) {
            leftCol[i] = getIdLeft(i);
            //TODO: this is just for empty text, note if we hae text in "smallText"(in strings.xml) it crashes!
            if (!leftCol[i].getText().toString().isEmpty())
                leftPoints[i] = Integer.parseInt(leftCol[i].getText().toString());
            result = result + leftPoints[i];
        }
        return String.valueOf(result);
    }

    //cal total results for right side
    public String calcRightPoints(){
        //TODO: Note this should not be hardcoded!
        int result = 0;
        int[] rightPoints = new int[MAX_ROW_NUM];
        for (int i=0 ; i<MAX_ROW_NUM ; i++)
            rightPoints[i]=0;
        TextView[] rightCol = new TextView[MAX_ROW_NUM];

        for (int i=0 ; i<MAX_ROW_NUM ; i++) {
            rightCol[i] = getIdRight(i);
            //TODO: this is just for empty text, note if we hae text in "smallText"(in strings.xml) it crashes!
            if (!rightCol[i].getText().toString().isEmpty())
                rightPoints[i] = Integer.parseInt(rightCol[i].getText().toString());
            result = result + rightPoints[i];
        }
        return String.valueOf(result);
    }

}
