package edu.quinnipiac.ser210.triviaapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
/**
 * Kevin Couillard & Hephzibah Rajan
 * SER 210 Assignment 2 TriviaApp
 * 3/18/21
 * MainFragmnetOne handles the answer buttons
 */
public class GameFragmentTwo extends Fragment implements View.OnClickListener {
    Button answerA;
    Button answerB;
    Button answerC;
    Button answerD;
    int buttonPressed;
    String playerName;
    String playerPosition;
    String playerTeam;
    String playerHeight;
    int questionNum = 0;

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
        questionNum = ((int) Math.random()*4);
        Button b1 = answerA;
        Button b2 = answerB;
        Button b3 = answerC;
        Button b4 = answerD;

        switch (v.getId()) {
            case R.id.answerA:
                switch (questionNum) {
                    //For some reason only the position registers if the correct answer is chosen (something to do with the check to see if strings are equal b/c position is char not string)
                    //Have tried b2.getText().toString().equalsIgnoreCase(playerTeam) as well as using .equals and .contentEquals with no luck
                    case 0:
                        if (playerPosition.contentEquals(b1.getText())) {
                            Intent intent = new Intent(this.getActivity(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(this.getActivity(), EndScreen.class);
                            startActivity(intent2);
                        }
                    case 1:
                        if (playerHeight.contentEquals(b1.getText())) {
                            Intent intent = new Intent(this.getActivity(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(this.getActivity(), EndScreen.class);
                            startActivity(intent2);
                        }
                    case 2:
                        if (playerName.contentEquals(b1.getText())) {
                            Intent intent = new Intent(this.getActivity(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(this.getActivity(), EndScreen.class);
                            startActivity(intent2);
                        }
                    case 3:
                        if (playerPosition.contentEquals(b1.getText())) {
                            Intent intent = new Intent(this.getActivity(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(this.getActivity(), EndScreen.class);
                            startActivity(intent2);
                        }
                }
                break;
            case R.id.answerB:
                switch (questionNum) {
                    case 0:
                        if (playerPosition.contentEquals(b2.getText())) {
                            Intent intent = new Intent(this.getActivity(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(this.getActivity(), EndScreen.class);
                            startActivity(intent2);
                        }
                    case 1:
                        if (playerHeight.contentEquals(b2.getText())) {
                            Intent intent = new Intent(this.getActivity(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(this.getActivity(), EndScreen.class);
                            startActivity(intent2);
                        }
                    case 2:
                        if (playerName.contentEquals(b2.getText())) {
                            Intent intent = new Intent(this.getActivity(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(this.getActivity(), EndScreen.class);
                            startActivity(intent2);
                        }
                    case 3:
                        if (playerPosition.contentEquals(b2.getText())) {
                            Intent intent = new Intent(this.getActivity(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(this.getActivity(), EndScreen.class);
                            startActivity(intent2);
                        }
                }
                break;
            case R.id.answerC:
                switch (questionNum) {
                    case 0:
                        if (playerPosition.contentEquals(b3.getText())) {
                            Intent intent = new Intent(this.getActivity(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(this.getActivity(), EndScreen.class);
                            startActivity(intent2);
                        }
                    case 1:
                        if (playerHeight.contentEquals(b3.getText())) {
                            Intent intent = new Intent(this.getActivity(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(this.getActivity(), EndScreen.class);
                            startActivity(intent2);
                        }
                    case 2:
                        if (playerName.contentEquals(b3.getText())) {
                            Intent intent = new Intent(this.getActivity(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(this.getActivity(), EndScreen.class);
                            startActivity(intent2);
                        }
                    case 3:
                        if (playerPosition.contentEquals(b3.getText())) {
                            Intent intent = new Intent(this.getActivity(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(this.getActivity(), EndScreen.class);
                            startActivity(intent2);
                        }
                }
                break;
            case R.id.answerD:
                switch (questionNum) {
                    case 0:
                        if (playerTeam.contentEquals(b4.getText())) {
                            Intent intent = new Intent(this.getActivity(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(this.getActivity(), EndScreen.class);
                            startActivity(intent2);
                        }
                    case 1:
                        if (playerHeight.contentEquals(b4.getText())) {
                            Intent intent = new Intent(this.getActivity(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(this.getActivity(), EndScreen.class);
                            startActivity(intent2);
                        }
                    case 2:
                        if (playerName.contentEquals(b4.getText())) {
                            Intent intent = new Intent(this.getActivity(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(this.getActivity(), EndScreen.class);
                            startActivity(intent2);
                        }
                    case 3:
                        if (playerPosition.contentEquals(b4.getText())) {
                            Intent intent = new Intent(this.getActivity(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(this.getActivity(), EndScreen.class);
                            startActivity(intent2);
                        }
                }
                break;
        }

    }
    public void setValues(String pN,String pP,String pT,String pH) {
        playerName = pN;
        playerHeight = pH;
        playerPosition = pP;
        playerTeam = pT;
    }

    public void setButtonText(String text,int button) {
        switch (button) {
            case 1:
                if (MainFragment.bPressed.getText().equals("Teams")) {
                    answerA.setText("Not yet completed");
                } else {
                    answerA.setText(text);
                }
                break;
            case 2:
                if (MainFragment.bPressed.getText().equals("Teams")) {
                    answerB.setText("Not yet completed");
                } else {
                    answerB.setText(text);
                }
                break;
            case 3:
                if (MainFragment.bPressed.getText().equals("Teams")) {
                    answerC.setText("Not yet completed");
                } else {
                    answerC.setText(text);
                }
                break;
            case 4:
                if (MainFragment.bPressed.getText().equals("Teams")) {
                    answerD.setText("Not yet completed");
                } else {
                    answerD.setText(text);
                }
                break;
        }
    }
}