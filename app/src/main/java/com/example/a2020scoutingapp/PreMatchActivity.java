package com.example.a2020scoutingapp;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.a2020scoutingapp.util.Match;


public class PreMatchActivity extends AppCompatActivity {


    private TextInputLayout mScouterNameLayout;
    private TextInputEditText mScouterNameInput;
    private TextInputLayout mMatchNumberLayout;
    private TextInputEditText mMatchNumberInput;
    private TextInputLayout mRobotNameLayout;
    private TextInputEditText mRobotNameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_match);

        //link EditText and Layout objects to activity_pre_match.xml file
        mScouterNameLayout  = findViewById(R.id.editNameLayout);
        mScouterNameInput = findViewById(R.id.editName);
        mMatchNumberLayout = findViewById(R.id.editMatchLayout);
        mMatchNumberInput = findViewById(R.id.editMatch);
        mRobotNameLayout = findViewById(R.id.editRobotLayout);
        mRobotNameInput = findViewById(R.id.editRobot);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //TODO: add shared preferences code
    }

    @Override
    protected void onResume() {
        super.onResume();
        //TODO: add code to pull from shared prefs
    }

    //method is run when Submit button is pressed/
    //method is linked to button through onClick attribute in .xml
    public void submitInfo(View view) {
        Match match = new Match();
        populateMatchData(match);

        Bundle preMatchBundle = new Bundle();
        //TODO: find way to put Match object in Bundle

    }

    private Match populateMatchData (Match in) {
        int team = Integer.parseInt(((TextView) mRobotNameInput).getText().toString());
        int match = Integer.parseInt(((TextView) mMatchNumberInput).getText().toString());
        String name = ((TextView) mScouterNameInput).getText().toString();

        in.robotNumber = team;
        in.matchNumber  = match;
        in.scouterName = name;
        return in;
    }
}
