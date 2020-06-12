package com.example.a2020scoutingapp.util;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Match implements Parcelable {

    //fields to be updated in prematch activity
    private int robotNumber;
    private int matchNumber;
    private String scouterName;

    //fields to be updates after tele-op
    public boolean hasClimbed;
    public boolean hasBroken;
    public boolean hasJammed;
    public boolean hasTranslated;

    private ArrayList<Cycle> autoCycleList = new ArrayList<Cycle>();

    //TODO: add additional fields for match info


    public Match() {

    }


    protected Match(Parcel in) {
        robotNumber = in.readInt();
        matchNumber = in.readInt();
        scouterName = in.readString();
        autoCycleList = in.readArrayList(Cycle.class.getClassLoader()); //Not sure if this is correct but we'll see
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(robotNumber);
        dest.writeInt(matchNumber);
        dest.writeString(scouterName);
        //dest.writeArray TODO: figure out how to wrote the arrayList
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Match> CREATOR = new Creator<Match>() {
        @Override
        public Match createFromParcel(Parcel in) {
            return new Match(in);
        }

        @Override
        public Match[] newArray(int size) {
            return new Match[size];
        }
    };


    public void setRobotNumber (int in) {
        robotNumber = in;
    }

    public void setMatchNumber (int in) {
        matchNumber = in;
    }

    public void setScouterName (String in) {
        scouterName = in;
    }

    public void addToAutoCycleArray (Cycle in) {
        autoCycleList.add(in);
    }
}
