package edu.quinnipiac.ser210.triviaapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.View;

public class GameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.question_options,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void chooseAnswer(View view) {
        //If the right answer is selected then refresh page with new question and answers
        //If the wrong answer is selected then send to the EndGame screen
        //Going to need to figure out a way to have the right answer known to have it as a case (instead of R.id.answerD)
        int id = view.getId();
        switch (id) {
            case R.id.answerD:
                //refresh screen
                Intent intent = new Intent(GameScreen.this, GameScreen.class);
                startActivity(intent);
                break;
            case R.id.answerA:
                //go to endScreen
                Intent intent2 = new Intent(GameScreen.this, EndScreen.class);
                startActivity(intent2);
                break;


        }
    }
}