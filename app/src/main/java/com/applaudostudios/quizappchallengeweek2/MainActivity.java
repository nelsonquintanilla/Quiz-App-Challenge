package com.applaudostudios.quizappchallengeweek2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Question> mQuestionsSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Calling the setData method
        setData();

        RecyclerView mRecyclerView = findViewById(R.id.my_recycler_view);

        // To improve performance
        mRecyclerView.setHasFixedSize(true);

        // Using a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Specifying an adapter
        RecyclerView.Adapter mAdapter = new QuestionsAdapter(mQuestionsSet);
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * Creates the questions and their options
     */
    private void setData() {
        mQuestionsSet = new ArrayList<>();
        Option option;
        Question question;

        // Each option is stored in this List and then this List is passed as a field to the
        // question object
        List<Option> optionList1 = new ArrayList<>();

        option = new Option(getString(R.string.o1_q1), true);
        optionList1.add(option);
        option = new Option(getString(R.string.o2_q1), false);
        optionList1.add(option);
        option = new Option(getString(R.string.o3_q1), false);
        optionList1.add(option);
        option = new Option(getString(R.string.o4_q1), false);
        optionList1.add(option);
        question = new Question(getString(R.string.q1), false, optionList1);
        mQuestionsSet.add(question);


        List<Option> optionList2 = new ArrayList<>();
        option = new Option(getString(R.string.o1_q2), false);
        optionList2.add(option);
        option = new Option(getString(R.string.o2_q2), false);
        optionList2.add(option);
        option = new Option(getString(R.string.o3_q2), false);
        optionList2.add(option);
        option = new Option(getString(R.string.o4_q2), true);
        optionList2.add(option);
        question = new Question(getString(R.string.q2), false, optionList2);
        mQuestionsSet.add(question);

        List<Option> optionList3 = new ArrayList<>();
        option = new Option(getString(R.string.o1_q3), false);
        optionList3.add(option);
        option = new Option(getString(R.string.o2_q3), false);
        optionList3.add(option);
        option = new Option(getString(R.string.o3_q3), true);
        optionList3.add(option);
        option = new Option(getString(R.string.o4_q3), false);
        optionList3.add(option);
        question = new Question(getString(R.string.q3), false, optionList3);
        mQuestionsSet.add(question);

        List<Option> optionList4 = new ArrayList<>();
        option = new Option(getString(R.string.o1_q4), true);
        optionList4.add(option);
        option = new Option(getString(R.string.o2_q4), false);
        optionList4.add(option);
        option = new Option(getString(R.string.o3_q4), false);
        optionList4.add(option);
        option = new Option(getString(R.string.o4_q4), false);
        optionList4.add(option);
        question = new Question(getString(R.string.q4), false, optionList4);
        mQuestionsSet.add(question);

        List<Option> optionList5 = new ArrayList<>();
        option = new Option(getString(R.string.o1_q5), true);
        optionList5.add(option);
        option = new Option(getString(R.string.o2_q5), false);
        optionList5.add(option);
        option = new Option(getString(R.string.o3_q5), true);
        optionList5.add(option);
        option = new Option(getString(R.string.o4_q5), false);
        optionList5.add(option);
        question = new Question(getString(R.string.q5), true, optionList5);
        mQuestionsSet.add(question);

        List<Option> optionList6 = new ArrayList<>();
        option = new Option(getString(R.string.o1_q6), false);
        optionList6.add(option);
        option = new Option(getString(R.string.o2_q6), true);
        optionList6.add(option);
        option = new Option(getString(R.string.o3_q6), false);
        optionList6.add(option);
        option = new Option(getString(R.string.o4_q6), true);
        optionList6.add(option);
        question = new Question(getString(R.string.q6), true, optionList6);
        mQuestionsSet.add(question);

        List<Option> optionList7 = new ArrayList<>();
        option = new Option(getString(R.string.o1_q7), true);
        optionList7.add(option);
        option = new Option(getString(R.string.o2_q7), false);
        optionList7.add(option);
        option = new Option(getString(R.string.o3_q7), true);
        optionList7.add(option);
        option = new Option(getString(R.string.o4_q7), false);
        optionList7.add(option);
        question = new Question(getString(R.string.q7), true, optionList7);
        mQuestionsSet.add(question);

        List<Option> optionList8 = new ArrayList<>();
        option = new Option(getString(R.string.o1_q8), true);
        optionList8.add(option);
        option = new Option(getString(R.string.o2_q8), false);
        optionList8.add(option);
        option = new Option(getString(R.string.o3_q8), true);
        optionList8.add(option);
        option = new Option(getString(R.string.o4_q8), false);
        optionList8.add(option);
        question = new Question(getString(R.string.q8), true, optionList8);
        mQuestionsSet.add(question);

    }

}
