package com.example.a2020scoutingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.a2020scoutingapp.util.Cycle;
import com.example.a2020scoutingapp.widget.Counter;

public class AutoActivity extends AppCompatActivity {

    private RadioGroup pickupInput;
    private RadioGroup scoreInput;

    private Counter lowerPortInput;
    private Counter outerPortInput;
    private Counter innerPortInput;

    boolean cycleActive = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);

        pickupInput = findViewById(R.id.pickupRadioGroup);
        scoreInput = findViewById(R.id.shootLocationInput);

        lowerPortInput = findViewById(R.id.lowerPortInput);
        outerPortInput = findViewById(R.id.outerPortInput);
        innerPortInput = findViewById(R.id.innerPortInput);

    }

    @Override
    protected void onPause() {
        super.onPause();

        //TODO: shared prefs stuff
    }

    @Override
    protected void onResume() {
        super.onResume();

        //TODO: shared prefs stuff
    }

    //linked to Start Auto Cycle Button
    public void startAutoCycle(View view) {
        cycleActive = true;
        resetScreen();

    }

    //linked to end Auto Cycle Button
    public void endAutoCycle(View view) {
        int low  = lowerPortInput.getValue();
        int out = outerPortInput.getValue();
        int in = innerPortInput.getValue();

        //TODO: find what radio button is pressed and send that into Cycle contuctor

        Cycle cycle = new Cycle(low, out, in, 0,0);
        resetScreen();

    }

    private void resetScreen() {
        pickupInput.clearCheck();
        scoreInput.clearCheck();
        lowerPortInput.setValue(0);
        outerPortInput.setValue(0);
        innerPortInput.setValue(0);
    }

}