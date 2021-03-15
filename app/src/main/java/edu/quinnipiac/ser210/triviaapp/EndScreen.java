package edu.quinnipiac.ser210.triviaapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class EndScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

    }

    public void buttonPress(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.playAgainButton:
                //go back to screen 2
                Intent intent = new Intent(EndScreen.this,GameScreen.class);
                startActivity(intent);
                break;
            case R.id.changeCategoryButton:
                //go back to screen 1
                Intent intent2 = new Intent(EndScreen.this,MainActivity.class);
                startActivity(intent2);
                break;
        }
    }
}