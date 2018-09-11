package com.applaudostudios.quizappchallengeweek2;

// Class used as identity to every option that a question has
public class Option {
    private String mOptionString;
    private boolean mCorrect;

    Option(String mOptionString, boolean mCorrect) {
        this.mOptionString = mOptionString;
        this.mCorrect = mCorrect;
    }

    public String getOptionString() {
        return mOptionString;
    }

    public boolean isCorrect() {
        return mCorrect;
    }
}
