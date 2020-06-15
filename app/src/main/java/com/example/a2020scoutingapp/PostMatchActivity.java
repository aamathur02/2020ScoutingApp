package com.example.a2020scoutingapp;

import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.view.View;


import com.example.a2020scoutingapp.util.Cycle;
import com.example.a2020scoutingapp.util.Match;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PostMatchActivity extends AppCompatActivity {

    private CheckBox hasClimbed;
    private CheckBox hasTranslated;
    private CheckBox hasBroken;
    private CheckBox hasJammed;

    Match match;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_match);

        hasClimbed = findViewById(R.id.climbedInput);
        hasTranslated = findViewById(R.id.translateInput);
        hasBroken = findViewById(R.id.brokenInput);
        hasJammed = findViewById(R.id.jammedInput);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            match = bundle.getParcelable("teleopObject");
        }

    }

    public void submitMatch (View view) {
        match.setHasBroken(hasBroken.isChecked());
        match.setHasClimbed(hasClimbed.isChecked());
        match.setHasJammed(hasJammed.isChecked());
        match.setHasTranslated(hasTranslated.isChecked());

        createCSV(match);

        Intent intent = new Intent(PostMatchActivity.this, PreMatchActivity.class);
        startActivity(intent);
    }

    private void createCSV (Match in) {
        String fileName = "2020_scouting_file.csv";
        String entry =
                in.getScouterName() + ","
                + in.getMatchNumber() + ","
                + in.getRobotNumber() + ","
                + readArrayList(in.getAutoCycleList()) + ","
                + readArrayList(in.getTeleopCycleList()) + ","
                + in.getBroken() + ","
                + in.getJammed() + ","
                + in.getClimbed() + ","
                + in.getTranslated();


        try {
            File file = new File(Environment.getExternalStorageDirectory(), "Infinite Recharge");
            file.mkdirs();

            File matchData = new File(file, fileName);
            if (!matchData.exists()) {
                matchData.createNewFile();
            }

            FileOutputStream os = new FileOutputStream(matchData, true);
            os.write(entry.getBytes());
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readArrayList (ArrayList<Cycle> in) {
        String output = "";
        for (int i = 1; i <= in.size(); i ++) {
            output += i;
            output+= in.get(i).getLowBallsScored();
            output += in.get(i).getOuterPortBallsScored();
            output += in.get(i).getInnerPortBallsScored();
            output += in.get(i).pickup.toString();
            output += in.get(i).score.toString();
        }

        return output;
    }




}