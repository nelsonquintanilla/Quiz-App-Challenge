package com.applaudostudios.quizappchallengeweek2;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    // This List is passed as an argument to the QuestionsAdapter constructor when is
    // called in the MainActivity class
    private List<Question> mQuestionsSet;

    // Declaring and initializing constant variables that are used later on
    private final static int FIRST_ELEMENT = 0;
    private final static int SECOND_ELEMENT = 1;
    private final static int THIRD_ELEMENT = 2;
    private final static int FOURTH_ELEMENT = 3;
    private final static int CHECKBOXES_QUESTION = 0;
    private final static int RADIO_BUTTONS_QUESTION = 1;

    // QuestionsAdapter constructor
    QuestionsAdapter(List<Question> questionsSet) {
        mQuestionsSet = new ArrayList<>();
        mQuestionsSet = questionsSet;
    }

    /**
     * Used to identify the type of view needed for each question
     *
     * @param position to be able to take each question on the List
     * @return integer value identifying the type of the view needed to represent the item at position
     */
    @Override
    public int getItemViewType(int position) {
        Question question = this.mQuestionsSet.get(position);
        if (question.isMultipleOption()) {
            return CHECKBOXES_QUESTION;
        } else {
            return RADIO_BUTTONS_QUESTION;
        }
    }

    // Creates new views depending of the viewType that is passed in
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v;
        if (viewType == CHECKBOXES_QUESTION) {
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.checkbox_questions, viewGroup, false);
            return new CheckBoxQuestionsViewHolder(v);
        } else {
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.radiobuttons_questions, viewGroup, false);
            return new RadioButtonQuestionsViewHolder(v);
        }
    }
    
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof CheckBoxQuestionsViewHolder) {
            CheckBoxQuestionsViewHolder checkBoxQuestionsViewHolder = (CheckBoxQuestionsViewHolder) viewHolder;
            checkBoxQuestionsViewHolder.bindData(mQuestionsSet.get(position));
        } else {
            RadioButtonQuestionsViewHolder radioButtonQuestionsViewHolder = (RadioButtonQuestionsViewHolder) viewHolder;
            radioButtonQuestionsViewHolder.bindData(mQuestionsSet.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mQuestionsSet.size();
    }

    // This is a ViewHolder class that is in charge of the logic to create the views when we have
    // a question of type multiple options (checkboxes)
    public static class CheckBoxQuestionsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Declaring each view needed
        TextView textViewQuestion;
        CheckBox checkBoxOption1;
        CheckBox checkBoxOption2;
        CheckBox checkBoxOption3;
        CheckBox checkBoxOption4;
        Button submitButton;
        List<Boolean> comparator = new ArrayList<>();
        List<Option> options = new ArrayList<>();

        private CheckBoxQuestionsViewHolder(View itemView) {
            super(itemView);
            // Initializing each view
            textViewQuestion = itemView.findViewById(R.id.question_1);
            checkBoxOption1 = itemView.findViewById(R.id.option_1);
            checkBoxOption2 = itemView.findViewById(R.id.option_2);
            checkBoxOption3 = itemView.findViewById(R.id.option_3);
            checkBoxOption4 = itemView.findViewById(R.id.option_4);
            submitButton = itemView.findViewById(R.id.submit_button);

            submitButton.setOnClickListener(this);
        }

        private void bindData(Question question) {
            // Setting the questions and their options (text) to their views
            textViewQuestion.setText(question.getQuestionString());
            checkBoxOption1.setText(question.getOptionList().get(FIRST_ELEMENT).getOptionString());
            checkBoxOption2.setText(question.getOptionList().get(SECOND_ELEMENT).getOptionString());
            checkBoxOption3.setText(question.getOptionList().get(THIRD_ELEMENT).getOptionString());
            checkBoxOption4.setText(question.getOptionList().get(FOURTH_ELEMENT).getOptionString());

            // It gets the boolean of each option (that indicates if the option is correct or
            // incorrect) and adds it to the options List
            options = question.getOptionList();
        }

        /**
         * First it adds for false booleans to the comparator List, then checks the state of each
         * checkbox and if it is checked it changes the boolean in the comparator List to true.
         *
         * Then we compare each boolean of each option (options List) with each value of the
         * comparator List to know if the user selected the correct answer.
         *
         * @return a boolean that is used in onCLick method
         */
        private boolean checker() {
            comparator.add(false);
            comparator.add(false);
            comparator.add(false);
            comparator.add(false);

            if (checkBoxOption1.isChecked()) {
                comparator.set(FIRST_ELEMENT, true);
            }
            if (checkBoxOption2.isChecked()) {
                comparator.set(SECOND_ELEMENT, true);
            }
            if (checkBoxOption3.isChecked()) {
                comparator.set(THIRD_ELEMENT, true);
            }
            if (checkBoxOption4.isChecked()) {
                comparator.set(FOURTH_ELEMENT, true);
            }

            boolean val = false;
            for (int i = 0; i < options.size(); i++) {
                if (options.get(i).isCorrect() == comparator.get(i)) {
                    val = true;
                } else {
                    val = false;
                    break;
                }
            }
            return val;
        }

        /**
         * It changes the color of the question indicating if the user selected the correct or
         * incorrect option and then disables that question so the user can't change their
         * answer
         *
         * @param v each view that is passed as an argument (in this case just the submit)
         */
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.submit_button:
                    if (checker()) {
                        textViewQuestion.setTextColor(Color.GREEN);
                    } else {
                        textViewQuestion.setTextColor(Color.RED);
                    }
                    submitButton.setEnabled(false);
                    checkBoxOption1.setEnabled(false);
                    checkBoxOption2.setEnabled(false);
                    checkBoxOption3.setEnabled(false);
                    checkBoxOption4.setEnabled(false);
                    break;
            }
        }

    }

    // This is a ViewHolder class that is in charge of the logic to create the views when we have
    // a question of type single option (radio buttons)
    public static class RadioButtonQuestionsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Declaring each view needed
        TextView textViewQuestion;
        RadioButton radioButtonOption1;
        RadioButton radioButtonOption2;
        RadioButton radioButtonOption3;
        RadioButton radioButtonOption4;
        Button submitButton;
        List<Boolean> comparator = new ArrayList<>();
        List<Option> options = new ArrayList<>();

        private RadioButtonQuestionsViewHolder(View itemView) {
            super(itemView);
            // Initializing each view
            textViewQuestion = itemView.findViewById(R.id.question_1);
            radioButtonOption1 = itemView.findViewById(R.id.radio_button_1);
            radioButtonOption2 = itemView.findViewById(R.id.radio_button_2);
            radioButtonOption3 = itemView.findViewById(R.id.radio_button_3);
            radioButtonOption4 = itemView.findViewById(R.id.radio_button_4);
            submitButton = itemView.findViewById(R.id.submit_button);

            submitButton.setOnClickListener(this);
        }

        private void bindData(Question question) {
            // Setting the questions and their options (text) to their views
            textViewQuestion.setText(question.getQuestionString());
            radioButtonOption1.setText(question.getOptionList().get(FIRST_ELEMENT).getOptionString());
            radioButtonOption2.setText(question.getOptionList().get(SECOND_ELEMENT).getOptionString());
            radioButtonOption3.setText(question.getOptionList().get(THIRD_ELEMENT).getOptionString());
            radioButtonOption4.setText(question.getOptionList().get(FOURTH_ELEMENT).getOptionString());

            // It gets the boolean of each option (that indicates if the option is correct or
            // incorrect) and adds it to the options List
            options = question.getOptionList();
        }

        /**
         * First it adds for false booleans to the comparator List, then checks the state of each
         * checkbox and if it is checked it changes the boolean in the comparator List to true.
         *
         * Then we compare each boolean of each option (options List) with each value of the
         * comparator List to know if the user selected the correct answer.
         *
         * @return a boolean that is used in onCLick method
         */
        private boolean checker() {
            comparator.add(false);
            comparator.add(false);
            comparator.add(false);
            comparator.add(false);

            if (radioButtonOption1.isChecked()) {
                comparator.set(FIRST_ELEMENT, true);
            } else if (radioButtonOption2.isChecked()) {
                comparator.set(SECOND_ELEMENT, true);
            } else if (radioButtonOption3.isChecked()) {
                comparator.set(THIRD_ELEMENT, true);
            } else if (radioButtonOption4.isChecked()) {
                comparator.set(FOURTH_ELEMENT, true);
            }

            boolean val = false;
            for (int i = 0; i < options.size(); i++) {
                if (options.get(i).isCorrect() == comparator.get(i)) {
                    val = true;
                } else {
                    val = false;
                    break;
                }
            }
            return val;
        }

        /**
         * It changes the color of the question indicating if the user selected the correct or
         * incorrect option and then disables that question so the user can't change their
         * answer
         *
         * @param v each view that is passed as an argument (in this case just the submit)
         */
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.submit_button:
                    if (checker()) {
                        textViewQuestion.setTextColor(Color.GREEN);
                    } else {
                        textViewQuestion.setTextColor(Color.RED);
                    }
                    submitButton.setEnabled(false);
                    radioButtonOption1.setEnabled(false);
                    radioButtonOption2.setEnabled(false);
                    radioButtonOption3.setEnabled(false);
                    radioButtonOption4.setEnabled(false);
                    break;
            }
        }

    }

}
