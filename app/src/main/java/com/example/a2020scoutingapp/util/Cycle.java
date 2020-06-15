package com.example.a2020scoutingapp.util;

public class Cycle {

    int lowBallsScored;
    int outerPortBallsScored;
    int innerPortBallsScored;

    public enum pickupLocation {HUMANLOADING, OPPOSITEHUMANLOADING, OPENFIELD}

    public pickupLocation pickup;

    public enum scoreLocation {FRONT_TRENCH, BACK_TRENCH, INIT_LINE, TRIANGLE}

    public scoreLocation score;

    public Cycle(int low, int outer, int inner, pickupLocation pickupIn, scoreLocation scoreIn) {
        this.lowBallsScored = low;
        this.outerPortBallsScored = outer;
        this.innerPortBallsScored = inner;
        this.pickup = pickupIn;
        this.score = scoreIn;

        /**
        switch (pickUpLocationInput) {
            case 0:
                pickup = pickupLocation.HUMANLOADING;
                break;
            case 1:
                pickup = pickupLocation.OPPOSITEHUMANLOADING;
                break;
            case 2:
                pickup = pickupLocation.OPENFIELD;
                break;
        }

        switch (scoreLocationLocation) {
            case 0:
                score = scoreLocation.TRIANGLE;
                break;
            case 1:
                score = scoreLocation.INIT_LINE;
                break;
            case 2:
                score = scoreLocation.FRONT_TRENCH;
                break;
            case 3:
                score = scoreLocation.BACK_TRENCH;
                break;
        }
         */
    }

    public int getLowBallsScored() {
        return lowBallsScored;
    }

    public int getInnerPortBallsScored() {
        return innerPortBallsScored;
    }

    public int getOuterPortBallsScored() {
        return outerPortBallsScored;
    }
}
