package com.applaudostudios.quizappchallengeweek2;

import java.util.ArrayList;
import java.util.List;
//Class used as identity to create questions with it´s fields and methods
public class Question {
    private String mQuestionString;
    private boolean mMultipleOption;
    private List<Option> mOptionList;

    public Question() {
        this.mMultipleOption = false;
        this.mOptionList = new ArrayList<>();
    }

    public Question(String mQuestionString, boolean mMultipleOption, List<Option> mOptionList) {
        this.mQuestionString = mQuestionString;
        this.mMultipleOption = mMultipleOption;
        this.mOptionList = mOptionList;
    }

    public String getQuestionString() {
        return mQuestionString;
    }

    public void setQuestionString(String mQuestionString) {
        this.mQuestionString = mQuestionString;
    }

    public boolean isMultipleOption() {
        return mMultipleOption;
    }

    public void setMultipleOption(boolean mMultipleOption) {
        this.mMultipleOption = mMultipleOption;
    }

    public List<Option> getOptionList() {
        return mOptionList;
    }

    public void setOptionList(List<Option> mOptionList) {
        this.mOptionList = mOptionList;
    }
}
