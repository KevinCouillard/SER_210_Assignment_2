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
        triviaQuestion = (TextView) layout.findViewById(R.id.question);
        //sets category name based on category clicked (was more categories now just one)
        return layout;
    }

    public void setViewText(String text,int view) {
        switch (view) {
            case 1:
                category.setText(text);
                break;
            case 2:
                if (MainFragment.bPressed.getText().equals("Teams")) {
                    triviaQuestion.setText("Not yet completed");
                } else {
                    triviaQuestion.setText(text);
                }
                break;
        }
    }

}