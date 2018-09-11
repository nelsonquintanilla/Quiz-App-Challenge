package com.applaudostudios.quizappchallengeweek2;

import java.util.List;

// Class used as identity to create every question with it´s fields and methods
public class Question {
    private String mQuestionString;
    private boolean mMultipleOption;
    private List<Option> mOptionList;

    Question(String mQuestionString, boolean mMultipleOption, List<Option> mOptionList) {
        this.mQuestionString = mQuestionString;
        this.mMultipleOption = mMultipleOption;
        this.mOptionList = mOptionList;
    }

    public String getQuestionString() {
        return mQuestionString;
    }

    public boolean isMultipleOption() {
        return mMultipleOption;
    }

    public List<Option> getOptionList() {
        return mOptionList;
    }
}
