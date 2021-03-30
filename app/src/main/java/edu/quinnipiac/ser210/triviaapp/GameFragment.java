package edu.quinnipiac.ser210.triviaapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class GameFragment extends Fragment implements View.OnClickListener {

    public GameFragment() {
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
        View layout = inflater.inflate(R.layout.fragment_main, container, false);
        Button answerA = (Button) layout.findViewById(R.id.answerA);
        Button answerB = (Button) layout.findViewById(R.id.answerB);
        Button answerC = (Button) layout.findViewById(R.id.answerC);
        Button answerD = (Button) layout.findViewById(R.id.answerD);
        return layout;
    }

    @Override
    public void onClick(View v) {

    }
}