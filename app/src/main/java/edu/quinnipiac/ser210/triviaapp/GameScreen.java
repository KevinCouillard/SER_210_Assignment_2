package edu.quinnipiac.ser210.triviaapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class GameScreen extends AppCompatActivity {
    int questionNum = 0;
    String player;
    String playerTeam;
    String playerHeight;
    String playerPosition;
    int score;
    String playerScore = "Current Score: " + score;
    private ShareActionProvider provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_game_screen);

        playerScore = (String) getIntent().getExtras().get("score");

        TextView currentScore = findViewById(R.id.Score);
        currentScore.setText(playerScore);

        questionNum = ((int) (Math.random()*4));
        String questionString = " " + questionNum;

        int ranB = ((int) (Math.random()*20));
        int ranC = ((int) (Math.random()*20));
        int ranD = ((int) (Math.random()*20));

        HashMap<Integer, Players> hMap = new HashMap<Integer, Players>();
        hMap.put(0, new Players("Antonio Blakeney","Bulls", "G","6'4''"));
        hMap.put(1, new Players("Jonah Bolden","Suns", "F","6'10''"));
        hMap.put(2, new Players("Patrick Beverley","Clippers", "G","6'1''"));
        hMap.put(3, new Players("Jahil Okafor","Pistons", "C","6'11''"));
        hMap.put(4, new Players("Michael Porter Jr.","Nuggets", "F","6'10''"));
        hMap.put(5, new Players("Edmond Sumner","Pacers", "G","6'6''"));
        hMap.put(6, new Players("Angel Delgado","Clippers", "C","6'10''"));
        hMap.put(7, new Players("Joel Embiid","76ers", "F","7'0''"));
        hMap.put(8, new Players("Wenyen Gabriel","Pelicans", "F","6'9''"));
        hMap.put(9, new Players("Jeff Green","Nets", "F","6'9''"));
        hMap.put(10, new Players("Maurice Harkless","Heat", "F","6'9''"));
        hMap.put(11, new Players("Michael Kidd-Gilchrist","Mavericks", "F","6'7''"));
        hMap.put(12, new Players("CJ McCollum","Trail Blazers", "G","6'3''"));
        hMap.put(13, new Players("Justin Patton","Rockets", "C","7'0''"));
        hMap.put(14, new Players("Giannis Antetokounmpo","Bucks", "F","6'11''"));
        hMap.put(15, new Players("Seth Curry","76ers", "G","6'2''"));
        hMap.put(16, new Players("Thomas Bryant","Wizards", "C","6'11''"));
        hMap.put(17, new Players("Isaiah Briscoe","Magic", "G","6'3''"));
        hMap.put(18, new Players("Bogdan Bogdanovic","Hawks", "G","6'6''"));
        hMap.put(19, new Players("Damian Jones","Lakers", "C","7'0''"));


        player = (String) getIntent().getExtras().get("player");
        playerTeam = (String) getIntent().getExtras().get("player team");
        String category = (String) getIntent().getExtras().get("category");
        playerHeight = (String) getIntent().getExtras().get("player height");
        playerPosition = (String) getIntent().getExtras().get("player position");

        //Log.v("Height",playerHeight);
        //Log.v("Position",playerPosition);

        ArrayList<String> triviaQuestions = new ArrayList<String>();
        triviaQuestions.add("What team does " + player + " play for?");
        triviaQuestions.add("What height is " + player + "?");
        triviaQuestions.add("What player plays on the " + playerTeam + "?");
        triviaQuestions.add("What position does " + player + " play?");
        Log.v("Question",triviaQuestions.get(questionNum));

        TextView question = (TextView) findViewById(R.id.question);
        question.setText(triviaQuestions.get(questionNum));

        Button answerA = (Button) findViewById(R.id.answerA);
        Button answerB = (Button) findViewById(R.id.answerB);
        Button answerC = (Button) findViewById(R.id.answerC);
        Button answerD = (Button) findViewById(R.id.answerD);

        switch (questionNum) {
            case 0:
                //set button text to teams
                int ranCorrect = ((int) (Math.random()*4));
                if (ranCorrect == 0) {
                    answerA.setText(playerTeam);
                    if (playerTeam.contentEquals(hMap.get(ranB).team)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    answerB.setText(hMap.get(ranB).team);

                    if (playerTeam.contentEquals(hMap.get(ranC).team)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    answerC.setText(hMap.get(ranC).team);

                    if (playerTeam.contentEquals(hMap.get(ranD).team)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    answerD.setText(hMap.get(ranD).team);
                } else if (ranCorrect == 1) {
                    answerB.setText(playerTeam);
                    if (playerTeam.contentEquals(hMap.get(ranB).team)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    answerA.setText(hMap.get(ranB).team);

                    if (playerTeam.contentEquals(hMap.get(ranC).team)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    answerC.setText(hMap.get(ranC).team);

                    if (playerTeam.contentEquals(hMap.get(ranD).team)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    answerD.setText(hMap.get(ranD).team);
                } else if (ranCorrect == 2) {
                    answerC.setText(playerTeam);
                    if (playerTeam.contentEquals(hMap.get(ranB).team)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    answerA.setText(hMap.get(ranB).team);

                    if (playerTeam.contentEquals(hMap.get(ranC).team)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    answerB.setText(hMap.get(ranC).team);

                    if (playerTeam.contentEquals(hMap.get(ranD).team)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    answerD.setText(hMap.get(ranD).team);
                } else if (ranCorrect == 3) {
                    answerD.setText(playerTeam);
                    if (playerTeam.contentEquals(hMap.get(ranB).team)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    answerA.setText(hMap.get(ranB).team);

                    if (playerTeam.contentEquals(hMap.get(ranC).team)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    answerC.setText(hMap.get(ranC).team);

                    if (playerTeam.contentEquals(hMap.get(ranD).team)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    answerB.setText(hMap.get(ranD).team);
                }
                break;
            case 1:
                //set button text to heights
                ranCorrect = ((int) (Math.random()*4));
                if (ranCorrect == 0) {
                    answerA.setText(playerHeight);
                    if (playerHeight.contentEquals(hMap.get(ranB).height)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    answerB.setText(hMap.get(ranB).height);

                    if (playerHeight.contentEquals(hMap.get(ranC).height)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    answerC.setText(hMap.get(ranC).height);

                    if (playerHeight.contentEquals(hMap.get(ranD).height)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    answerD.setText(hMap.get(ranD).height);
                } else if (ranCorrect == 1) {
                    answerB.setText(playerHeight);
                    if (playerHeight.contentEquals(hMap.get(ranB).height)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    answerA.setText(hMap.get(ranB).height);

                    if (playerHeight.contentEquals(hMap.get(ranC).height)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    answerC.setText(hMap.get(ranC).height);

                    if (playerHeight.contentEquals(hMap.get(ranD).height)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    answerD.setText(hMap.get(ranD).height);
                } else if (ranCorrect == 2) {
                    answerC.setText(playerHeight);
                    if (playerHeight.contentEquals(hMap.get(ranB).height)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    answerA.setText(hMap.get(ranB).height);

                    if (playerHeight.contentEquals(hMap.get(ranC).height)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    answerB.setText(hMap.get(ranC).height);

                    if (playerHeight.contentEquals(hMap.get(ranD).height)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    answerD.setText(hMap.get(ranD).height);
                } else if (ranCorrect == 3) {
                    answerD.setText(playerHeight);
                    if (playerHeight.contentEquals(hMap.get(ranB).height)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    answerA.setText(hMap.get(ranB).height);

                    if (playerHeight.contentEquals(hMap.get(ranC).height)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    answerC.setText(hMap.get(ranC).height);

                    if (playerHeight.contentEquals(hMap.get(ranD).height)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    answerB.setText(hMap.get(ranD).height);
                }
                break;
            case 2:
                //set button text to players
                ranCorrect = ((int) (Math.random()*4));
                if (ranCorrect == 0) {
                    answerA.setText(player);
                    if (player.contentEquals(hMap.get(ranB).player)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    answerB.setText(hMap.get(ranB).player);

                    if (player.contentEquals(hMap.get(ranC).player)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    answerC.setText(hMap.get(ranC).player);

                    if (player.contentEquals(hMap.get(ranD).player)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    answerD.setText(hMap.get(ranD).player);
                } else if (ranCorrect == 1) {
                    answerB.setText(player);
                    if (player.contentEquals(hMap.get(ranB).player)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    answerA.setText(hMap.get(ranB).player);

                    if (player.contentEquals(hMap.get(ranC).player)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    answerC.setText(hMap.get(ranC).player);

                    if (player.contentEquals(hMap.get(ranD).player)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    answerD.setText(hMap.get(ranD).player);
                } else if (ranCorrect == 2) {
                    answerC.setText(player);
                    if (player.contentEquals(hMap.get(ranB).player)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    answerA.setText(hMap.get(ranB).player);

                    if (player.contentEquals(hMap.get(ranC).player)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    answerB.setText(hMap.get(ranC).player);

                    if (player.contentEquals(hMap.get(ranD).player)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    answerD.setText(hMap.get(ranD).player);
                } else if (ranCorrect == 3) {
                    answerD.setText(player);
                    if (player.contentEquals(hMap.get(ranB).player)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    answerA.setText(hMap.get(ranB).player);

                    if (player.contentEquals(hMap.get(ranC).player)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    answerC.setText(hMap.get(ranC).player);

                    if (player.contentEquals(hMap.get(ranD).player)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    answerB.setText(hMap.get(ranD).player);
                }
                break;
            case 3:
                //set button text to position
                ranCorrect = ((int) (Math.random()*4));
                Log.v("question Correct", " " + ranCorrect);
                Log.v("question Position", " " + playerPosition);
                if (ranCorrect == 0) {
                    answerA.setText(playerPosition);
                    if (playerPosition.contentEquals(hMap.get(ranB).position)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    answerB.setText(hMap.get(ranB).position);

                    if (playerPosition.contentEquals(hMap.get(ranC).position)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    answerC.setText(hMap.get(ranC).position);

                    if (playerPosition.contentEquals(hMap.get(ranD).position)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    answerD.setText(hMap.get(ranD).position);
                } else if (ranCorrect == 1) {
                    answerB.setText(playerPosition);
                    if (playerPosition.contentEquals(hMap.get(ranB).position)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    answerA.setText(hMap.get(ranB).position);

                    if (playerPosition.contentEquals(hMap.get(ranC).position)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    answerC.setText(hMap.get(ranC).position);

                    if (playerPosition.contentEquals(hMap.get(ranD).position)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    answerD.setText(hMap.get(ranD).position);
                } else if (ranCorrect == 2) {
                    answerC.setText(playerPosition);
                    if (playerPosition.contentEquals(hMap.get(ranB).position)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    answerA.setText(hMap.get(ranB).position);

                    if (playerPosition.contentEquals(hMap.get(ranC).position)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    answerB.setText(hMap.get(ranC).position);

                    if (playerPosition.contentEquals(hMap.get(ranD).position)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    answerD.setText(hMap.get(ranD).position);
                } else if (ranCorrect == 3) {
                    answerD.setText(playerPosition);
                    if (playerPosition.contentEquals(hMap.get(ranB).position)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    answerA.setText(hMap.get(ranB).position);

                    if (playerPosition.contentEquals(hMap.get(ranC).position)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    answerC.setText(hMap.get(ranC).position);

                    if (playerPosition.contentEquals(hMap.get(ranD).position)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    answerB.setText(hMap.get(ranD).position);
                }
                break;
        }

        Log.v("question number", questionString);
        Log.v("question playerTeam", playerTeam);

        TextView categoryName = (TextView) findViewById(R.id.categoryName);
        categoryName.setText(category);


        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.question_options,menu);
        provider = (ShareActionProvider) MenuItemCompat.getActionProvider((MenuItem) menu.findItem(R.id.action_share));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.change_color:
                //changes color
                Utils.changeToTheme(this, (int)(Math.random()*6));
                break;
            case R.id.info:
                //information about the developer
                Intent intent = new Intent(GameScreen.this, AboutPage.class);
                startActivity(intent);
                break;
            case R.id.action_share:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_TEXT,"(EditText)findViewById(R.id.score).getText().toString");
                provider.setShareIntent(sharingIntent);
                break;
            default: return super.onOptionsItemSelected(item);

        }
        return super.onOptionsItemSelected(item);

    }

    public void chooseAnswer(View view) {
        int id = view.getId();
        questionNum = ((int) Math.random()*4);
        Button b1 = findViewById(R.id.answerA);
        Button b2 = findViewById(R.id.answerB);
        Button b3 = findViewById(R.id.answerC);
        Button b4 = findViewById(R.id.answerD);
        //int score = 0;
        TextView score = (TextView) findViewById(R.id.Score);
        switch (id) {
            case R.id.answerA:
                switch (questionNum) {
                    case 0:
                        if (playerTeam.contentEquals(b1.getText())) {
                            Intent intent = new Intent(GameScreen.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(GameScreen.this, EndScreen.class);
                            startActivity(intent2);
                        }
                    case 1:
                        if (playerHeight.contentEquals(b1.getText())) {
                            Intent intent = new Intent(GameScreen.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(GameScreen.this, EndScreen.class);
                            startActivity(intent2);
                        }
                    case 2:
                        if (player.contentEquals(b1.getText())) {
                            Intent intent = new Intent(GameScreen.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(GameScreen.this, EndScreen.class);
                            startActivity(intent2);
                        }
                    case 3:
                        if (playerPosition.contentEquals(b1.getText())) {
                            Intent intent = new Intent(GameScreen.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(GameScreen.this, EndScreen.class);
                            startActivity(intent2);
                        }
                }
                break;
            case R.id.answerB:
                switch (questionNum) {
                    case 0:
                        if (playerTeam.contentEquals(b2.getText())) {
                            Intent intent = new Intent(GameScreen.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(GameScreen.this, EndScreen.class);
                            startActivity(intent2);
                        }
                    case 1:
                        if (playerHeight.contentEquals(b2.getText())) {
                            Intent intent = new Intent(GameScreen.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(GameScreen.this, EndScreen.class);
                            startActivity(intent2);
                        }
                    case 2:
                        if (player.contentEquals(b2.getText())) {
                            Intent intent = new Intent(GameScreen.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(GameScreen.this, EndScreen.class);
                            startActivity(intent2);
                        }
                    case 3:
                        if (playerPosition.contentEquals(b2.getText())) {
                            Intent intent = new Intent(GameScreen.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(GameScreen.this, EndScreen.class);
                            startActivity(intent2);
                        }
                }
                break;
            case R.id.answerC:
                switch (questionNum) {
                    case 0:
                        if (playerTeam.contentEquals(b3.getText())) {
                            Intent intent = new Intent(GameScreen.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(GameScreen.this, EndScreen.class);
                            startActivity(intent2);
                        }
                    case 1:
                        if (playerHeight.contentEquals(b3.getText())) {
                            Intent intent = new Intent(GameScreen.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(GameScreen.this, EndScreen.class);
                            startActivity(intent2);
                        }
                    case 2:
                        if (player.contentEquals(b3.getText())) {
                            Intent intent = new Intent(GameScreen.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(GameScreen.this, EndScreen.class);
                            startActivity(intent2);
                        }
                    case 3:
                        if (playerPosition.contentEquals(b3.getText())) {
                            Intent intent = new Intent(GameScreen.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(GameScreen.this, EndScreen.class);
                            startActivity(intent2);
                        }
                }
                break;
            case R.id.answerD:
                switch (questionNum) {
                    case 0:
                        if (playerTeam.contentEquals(b4.getText())) {
                            Intent intent = new Intent(GameScreen.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(GameScreen.this, EndScreen.class);
                            startActivity(intent2);
                        }
                    case 1:
                        if (playerHeight.contentEquals(b4.getText())) {
                            Intent intent = new Intent(GameScreen.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(GameScreen.this, EndScreen.class);
                            startActivity(intent2);
                        }
                    case 2:
                        if (player.contentEquals(b4.getText())) {
                            Intent intent = new Intent(GameScreen.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(GameScreen.this, EndScreen.class);
                            startActivity(intent2);
                        }
                    case 3:
                        if (playerPosition.contentEquals(b4.getText())) {
                            Intent intent = new Intent(GameScreen.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent2 = new Intent(GameScreen.this, EndScreen.class);
                            startActivity(intent2);
                        }
                }
                break;
        }
    }
    public class Players {
        String player;
        String team;
        String position;
        String height;

        Players(String player, String team, String position, String height) {
            this.height = height;
            this.position = position;
            this.team = team;
            this.player = player;
        }
    }

}