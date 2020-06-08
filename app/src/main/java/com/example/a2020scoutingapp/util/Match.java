package com.example.a2020scoutingapp.util;

import android.os.Parcel;
import android.os.Parcelable;

public class Match implements Parcelable {

    public int robotNumber;
    public int matchNumber;
    public String scouterName;

    //TODO: add additional fields for match info


    public Match() {

    }


    protected Match(Parcel in) {
        robotNumber = in.readInt();
        matchNumber = in.readInt();
        scouterName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(robotNumber);
        dest.writeInt(matchNumber);
        dest.writeString(scouterName);
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
}
