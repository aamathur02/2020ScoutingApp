package com.example.a2020scoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.a2020scoutingapp.util.Cycle;
import com.example.a2020scoutingapp.util.Match;
import com.example.a2020scoutingapp.widget.Counter;

public class TeleopActivity extends AppCompatActivity {

    private RadioGroup pickupInput;
    private RadioGroup scoreInput;

    private Counter lowerPortInput;
    private Counter outerPortInput;
    private Counter innerPortInput;

    private boolean cycleActive = false;

    private Match match;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop);

        pickupInput = findViewById(R.id.pickupRadioGroupTele);
        scoreInput = findViewById(R.id.shootLocationInputTele);

        lowerPortInput = findViewById(R.id.lowerPortInputTele);
        outerPortInput = findViewById(R.id.outerPortInputTele);
        innerPortInput = findViewById(R.id.innterPortInputTele);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            match = bundle.getParcelable("autoObject");
        }

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

    //linked to Start Tele Cycle Button
    public void startTeleCycle(View view) {
        cycleActive = true;
        resetScreen();
    }

    //linked to end Te;e Cycle Button
    public void endTeleCycle(View view) {
        if (cycleActive) {

            int low = lowerPortInput.getValue();
            int out = outerPortInput.getValue();
            int in = innerPortInput.getValue();

            Cycle.pickupLocation pickup;

            int pickupInt = pickupInput.getCheckedRadioButtonId();
            switch (pickupInt) {
                case 0:
                    pickup = Cycle.pickupLocation.HUMANLOADING;
                    break;
                case 1:
                    pickup = Cycle.pickupLocation.OPPOSITEHUMANLOADING;
                    break;
                case 2:
                    pickup = Cycle.pickupLocation.OPENFIELD;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + pickupInt);
            }

            Cycle.scoreLocation score;
            int scoreInt = scoreInput.getCheckedRadioButtonId();
            switch (scoreInt) {
                case 0:
                    score = Cycle.scoreLocation.TRIANGLE;
                    break;
                case 1:
                    score = Cycle.scoreLocation.INIT_LINE;
                    break;
                case 2:
                    score = Cycle.scoreLocation.BACK_TRENCH;
                    break;
                case 3:
                    score = Cycle.scoreLocation.FRONT_TRENCH;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + scoreInt);
            }


            Cycle cycle = new Cycle(low, out, in, pickup, score);
            populateData(match, cycle);
            resetScreen();
        }
        cycleActive = false;

    }

    public void moveToEndgame(View view) {
        Intent intentEndgame = new Intent(TeleopActivity.this, PostMatchActivity.class);
        intentEndgame.putExtra("teleopObject", match);
        startActivity(intentEndgame);
    }
    private void resetScreen() {
        pickupInput.clearCheck();
        scoreInput.clearCheck();
        lowerPortInput.setValue(0);
        outerPortInput.setValue(0);
        innerPortInput.setValue(0);
    }

    private Match populateData(Match in, Cycle cycle) {
        in.addToTeleopCycleArray(cycle);
        return in;
    }
}