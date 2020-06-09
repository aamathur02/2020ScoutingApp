package com.example.a2020scoutingapp.util;

public class Cycle {

    int lowBallsScored;
    int outerPortBallsScored;
    int innerPortBallsScored;

    public enum pickupLocation {HUMANLOADING, OPPOSITEHUMANLOADING, OPENFIELD;}

    public enum scoreLocation {FRONT_TRENCH, BACK_TRENCH, INIT_LINE, TRIANGLE;}

    public Cycle(int low, int outer, int inner) {
        this.lowBallsScored = low;
        this.outerPortBallsScored = outer;
        this.innerPortBallsScored = inner;

    }
}
