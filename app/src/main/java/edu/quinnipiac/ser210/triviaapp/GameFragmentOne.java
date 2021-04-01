package edu.quinnipiac.ser210.triviaapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class GameFragmentOne extends Fragment {
    TextView category;
    TextView triviaQuestion;
    String categoryName;
    String questionText;

    public GameFragmentOne() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_game_one, container, false);
        category = (TextView) layout.findViewById(R.id.categoryName);
        category.setText("Category: " + MainFragment.bPressed.getText());
        triviaQuestion = (TextView) layout.findViewById(R.id.question);
        if (MainFragment.bPressed.getText().equals("Teams")) {
            triviaQuestion.setText("Not yet completed");
        } else {
            triviaQuestion.setText(MainActivity.triviaQuestions.get(MainActivity.ranNum));
        }
        return layout;
    }

    public void setViewText(String text,int view) {
        switch (view) {
            case 1:

                break;
            case 2:
                if (MainFragment.bPressed.getText().equals("Teams")) {
                    //triviaQuestion.setText("Not yet completed");
                    questionText = "Not yet completed";
                } else {
                    questionText = text;
                    //triviaQuestion.setText(text);
                }
                break;
        }
    }

}