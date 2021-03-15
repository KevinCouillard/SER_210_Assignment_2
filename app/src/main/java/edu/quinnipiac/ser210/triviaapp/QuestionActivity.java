package edu.quinnipiac.ser210.triviaapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

public class QuestionActivity extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(toolbar!=null) {
            toolbar.setDisplayHomeAsUpEnabled(true);
        }

    }
}