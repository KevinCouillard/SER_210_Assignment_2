package edu.quinnipiac.ser210.triviaapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class GameFragmentTwo extends Fragment implements View.OnClickListener {
    Button answerA;
    Button answerB;
    Button answerC;
    Button answerD;
    int buttonPressed;

    public GameFragmentTwo() {
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
        View layout = inflater.inflate(R.layout.fragment_game_two, container, false);
        answerA = (Button) layout.findViewById(R.id.answerA);
        answerB = (Button) layout.findViewById(R.id.answerB);
        answerC = (Button) layout.findViewById(R.id.answerC);
        answerD = (Button) layout.findViewById(R.id.answerD);
        answerA.setOnClickListener(this);
        answerB.setOnClickListener(this);
        answerC.setOnClickListener(this);
        answerD.setOnClickListener(this);
        return layout;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.answerA:
                buttonPressed = 1;
            case R.id.answerB:
                buttonPressed = 2;
            case R.id.answerC:
                buttonPressed = 3;
            case R.id.answerD:
                buttonPressed = 4;
        }
    }
    public int getButtonPressed() {
        View bPressed = null;
        switch (buttonPressed) {
            case 1:
                Log.v("button pressed","hello");
                bPressed = answerA;
                break;
            case 2:
                bPressed = answerB;
                break;
            case 3:
                bPressed = answerC;
                break;
            case 4:
                bPressed = answerD;
                break;
        }
        return bPressed.getId();
    }

    public void setButtonText(String text,int button) {
        switch (button) {
            case 1:
                answerA.setText(text);
                break;
            case 2:
                answerB.setText(text);
                break;
            case 3:
                answerC.setText(text);
                break;
            case 4:
                answerD.setText(text);
                break;
        }
    }
}