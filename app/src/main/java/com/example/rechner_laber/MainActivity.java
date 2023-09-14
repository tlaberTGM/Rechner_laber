package com.example.rechner_laber;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView anzeige = findViewById(R.id.textView);
        anzeige.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                anzeige.setText(0);
                return true;
            }
        });
    }

    public void calc(View v) {
        EditText input1 = findViewById(R.id.editTextNumber2);
        EditText input2 = findViewById(R.id.editTextNumber3);
        RadioGroup rg = findViewById(R.id.radioGroup);
        int zahl1 = Integer.parseInt(input1.getText().toString());
        int zahl2 = Integer.parseInt(input2.getText().toString());
        int ergebnis = 0;
        if(rg.getCheckedRadioButtonId() == R.id.radioButton) {
            ergebnis = zahl1 + zahl2;
        } else if(rg.getCheckedRadioButtonId() == R.id.radioButton2){
            ergebnis = zahl1 - zahl2;
        } else if(rg.getCheckedRadioButtonId() == R.id.radioButton3) {
            ergebnis = zahl1 * zahl2;
        } else if(rg.getCheckedRadioButtonId() == R.id.radioButton4) {
            ergebnis = zahl1 / zahl2;
        } else {
            ergebnis = 0;
        }
        TextView anzeige = findViewById(R.id.textView);
        anzeige.setText(String.valueOf(ergebnis));
    }


}