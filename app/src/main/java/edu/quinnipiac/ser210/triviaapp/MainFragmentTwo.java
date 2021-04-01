package edu.quinnipiac.ser210.triviaapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
/**
 * Kevin Couillard & Hephzibah Rajan
 * SER 210 Assignment 2 TriviaApp
 * 3/18/21
 * MainFragmnetTwo handles the team category Button
 */
public class MainFragmentTwo extends Fragment implements View.OnClickListener {
    private MainActivity mActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_main_two, container, false);
        Button teamButton = (Button) layout.findViewById(R.id.Teams);
        teamButton.setOnClickListener(this);
        return layout;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = (MainActivity) context;
    }

    @Override
    public void onClick(View v) {
        MainFragment.bPressed = (Button) v;
        mActivity.itemClicked();
    }
}