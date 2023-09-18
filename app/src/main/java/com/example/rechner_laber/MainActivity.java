package com.example.rechner_laber;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * MainActivity
 * @author Thomas Laber
 * @version 2023-09-14
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Wird ausgeführt beim Starten der App
     * @param savedInstanceState der letzte Zustand in dem die App verlassen wurde
     */
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView anzeige = findViewById(R.id.textView);
        anzeige.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                anzeige.setText("0");
                return true;
            }
        });
    }

    /**
     * The background colour of the "Calculate" button is to be set to a green colour in the onResume method to signal readiness for use.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Button b = findViewById(R.id.button);
        b.setBackgroundColor(Color.GREEN);
    }

    /**
     * A click on the "Berechnen"/"Calculate" button shall perform the selected calculation with the two entered values and output the result in the lower output field.
     * @param v The view object of the calculator
     */
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
        }
        TextView anzeige = findViewById(R.id.textView);
        if(ergebnis < 0) {
            anzeige.setTextColor(Color.RED);
        } else{
            anzeige.setTextColor(Color.BLACK);
        }

        anzeige.setText(String.valueOf(ergebnis));

    }

    /**
     * The "MS" button (Memory Store) is used for persistent storage (Shared Preferences) of the current result
     * @param v The view object of the calculator
     */
    public void speichern(View v) {
        SharedPreferences sharedPref = this.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        TextView t = findViewById(R.id.textView);
        int i = Integer.parseInt(t.getText().toString());
        editor.putInt("Ergebnis",i);
        editor.commit();
        Toast.makeText(this, "Erfolgreich gespeichert!", Toast.LENGTH_SHORT).show();
    }

    /**
     * The "MR" button (Memory Recall) restores the respective stored value.
     * @param v The view object of the calculator
     */
    public void laden(View v) {
        SharedPreferences sharedPref = this.getPreferences(MODE_PRIVATE);
        int ergebnis = sharedPref.getInt("Ergebnis", 0);
        TextView t = findViewById(R.id.textView);
        t.setText(String.valueOf(ergebnis));
    }


}