package com.applaudostudios.quizappchallengeweek2;
//Class used as identity to every option that a question has
public class Option {
    private String mOptionString;
    private boolean mCorrect;

    public Option() {
    }

    public Option(String mOptionString, boolean mCorrect) {
        this.mOptionString = mOptionString;
        this.mCorrect = mCorrect;
    }

    public String getOptionString() {
        return mOptionString;
    }

    public void setOptionString(String mOptionString) {
        this.mOptionString = mOptionString;
    }

    public boolean isCorrect() {
        return mCorrect;
    }

    public void setCorrect(boolean mCorrect) {
        this.mCorrect = mCorrect;
    }
}
