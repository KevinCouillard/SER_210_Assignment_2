package edu.quinnipiac.ser210.triviaapp;
/**
 * Kevin Couillard & Hephzibah Rajan
 * SER 210 Assignment 2 TriviaApp
 * 3/18/21
 * GameScreen handles trivia questions and answers
 */
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;

public class GameScreen extends AppCompatActivity {
    static int questionNum = 0;
    String player;
    String playerTeam;
    String playerHeight;
    String playerPosition;
    ShareActionProvider provider;
    static GameFragmentOne frag_one_obj;
    static GameFragmentTwo frag_two_obj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_game_screen);

        questionNum = ((int) (Math.random()*4));

        //View textFragContainer = findViewById(R.id.text_container);
        GameFragmentOne game_one_frag = new GameFragmentOne();
        FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
        //ft1.replace(R.id.text_container, game_one_frag);
        ft1.addToBackStack(null);
        ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft1.commit();

        //View buttonFragContainer = findViewById(R.id.button_container);
        GameFragmentTwo game_two_frag = new GameFragmentTwo();
        FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
        //ft2.replace(R.id.button_container, game_two_frag);
        ft2.addToBackStack(null);
        ft2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft2.commit();

        //random numbers used to fill false answers from HashMap values
        int ranB = ((int) (Math.random()*20));
        int ranC = ((int) (Math.random()*20));
        int ranD = ((int) (Math.random()*20));

        //HashMap that manually stores 20 players and their values to use as false answers
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

        //Intent values (api values) passed from MainActivity
        player = (String) getIntent().getExtras().get("player");
        playerTeam = (String) getIntent().getExtras().get("player team");
        String category = (String) getIntent().getExtras().get("category");
        playerHeight = (String) getIntent().getExtras().get("player height");
        playerPosition = (String) getIntent().getExtras().get("player position");

        //ArrayList used to hold the questions asked
        ArrayList<String> triviaQuestions = new ArrayList<String>();
        triviaQuestions.add("What team does " + player + " play for?");
        triviaQuestions.add("What height is " + player + "?");
        triviaQuestions.add("What player plays on the " + playerTeam + "?");
        triviaQuestions.add("What position does " + player + " play?");

        frag_one_obj = (GameFragmentOne) getSupportFragmentManager().findFragmentById(R.id.game_frag_one);
        frag_two_obj = (GameFragmentTwo) getSupportFragmentManager().findFragmentById(R.id.game_frag_two);

        //sets category name based on category clicked (was more categories now just one)
        frag_one_obj.setViewText(category,1);

        //Sets the textView displaying the question text to a random question
        frag_one_obj.setViewText(triviaQuestions.get(questionNum),2);


        frag_two_obj.setValues(player,playerPosition,playerTeam,playerHeight);


        Button answerA = (Button) findViewById(R.id.answerA);
        Button answerB = (Button) findViewById(R.id.answerB);
        Button answerC = (Button) findViewById(R.id.answerC);
        Button answerD = (Button) findViewById(R.id.answerD);

        //Sets the button text for each question case randomly
        switch (questionNum) {
            case 0:
                //set button text to teams
                int ranCorrect = ((int) (Math.random()*4));
                if (ranCorrect == 0) {
                    frag_two_obj.setButtonText(playerTeam, 1);
                    if (playerTeam.contentEquals(hMap.get(ranB).team)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranB).team, 2);

                    if (playerTeam.contentEquals(hMap.get(ranC).team)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranC).team, 3);

                    if (playerTeam.contentEquals(hMap.get(ranD).team)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranD).team, 4);
                } else if (ranCorrect == 1) {
                    frag_two_obj.setButtonText(playerTeam, 2);
                    if (playerTeam.contentEquals(hMap.get(ranB).team)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranB).team, 1);

                    if (playerTeam.contentEquals(hMap.get(ranC).team)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranC).team, 3);

                    if (playerTeam.contentEquals(hMap.get(ranD).team)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranD).team, 4);
                } else if (ranCorrect == 2) {
                    frag_two_obj.setButtonText(playerTeam, 3);
                    if (playerTeam.contentEquals(hMap.get(ranB).team)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranB).team, 1);

                    if (playerTeam.contentEquals(hMap.get(ranC).team)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranC).team, 2);

                    if (playerTeam.contentEquals(hMap.get(ranD).team)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranD).team, 4);
                } else if (ranCorrect == 3) {
                    frag_two_obj.setButtonText(playerTeam, 4);
                    if (playerTeam.contentEquals(hMap.get(ranB).team)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranB).team, 1);

                    if (playerTeam.contentEquals(hMap.get(ranC).team)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranC).team, 3);

                    if (playerTeam.contentEquals(hMap.get(ranD).team)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranD).team, 2);
                }
                break;
            case 1:
                //set button text to heights
                ranCorrect = ((int) (Math.random()*4));
                if (ranCorrect == 0) {
                    frag_two_obj.setButtonText(playerHeight, 1);
                    if (playerHeight.contentEquals(hMap.get(ranB).height)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranB).height, 2);

                    if (playerHeight.contentEquals(hMap.get(ranC).height)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranC).height, 3);

                    if (playerHeight.contentEquals(hMap.get(ranD).height)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranD).height, 4);
                } else if (ranCorrect == 1) {
                    frag_two_obj.setButtonText(playerHeight, 2);
                    if (playerHeight.contentEquals(hMap.get(ranB).height)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranB).height, 1);

                    if (playerHeight.contentEquals(hMap.get(ranC).height)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranC).height, 3);

                    if (playerHeight.contentEquals(hMap.get(ranD).height)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranD).height, 4);
                } else if (ranCorrect == 2) {
                    frag_two_obj.setButtonText(playerHeight, 3);
                    if (playerHeight.contentEquals(hMap.get(ranB).height)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranB).height, 1);

                    if (playerHeight.contentEquals(hMap.get(ranC).height)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranC).height, 2);

                    if (playerHeight.contentEquals(hMap.get(ranD).height)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranD).height, 4);
                } else if (ranCorrect == 3) {
                    frag_two_obj.setButtonText(playerHeight, 4);
                    if (playerHeight.contentEquals(hMap.get(ranB).height)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranB).height, 1);

                    if (playerHeight.contentEquals(hMap.get(ranC).height)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranC).height, 3);

                    if (playerHeight.contentEquals(hMap.get(ranD).height)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranD).height, 2);
                }
                break;
            case 2:
                //set button text to players
                ranCorrect = ((int) (Math.random()*4));
                if (ranCorrect == 0) {
                    frag_two_obj.setButtonText(player, 1);
                    if (player.contentEquals(hMap.get(ranB).player)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranB).player, 2);

                    if (player.contentEquals(hMap.get(ranC).player)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranC).player, 3);

                    if (player.contentEquals(hMap.get(ranD).player)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranD).player, 4);
                } else if (ranCorrect == 1) {
                    frag_two_obj.setButtonText(player, 2);
                    if (player.contentEquals(hMap.get(ranB).player)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranB).player, 1);

                    if (player.contentEquals(hMap.get(ranC).player)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranC).player, 3);

                    if (player.contentEquals(hMap.get(ranD).player)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranD).player, 4);
                } else if (ranCorrect == 2) {
                    frag_two_obj.setButtonText(player, 3);
                    if (player.contentEquals(hMap.get(ranB).player)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranB).player, 1);

                    if (player.contentEquals(hMap.get(ranC).player)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranC).player, 2);

                    if (player.contentEquals(hMap.get(ranD).player)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranD).player, 4);
                } else if (ranCorrect == 3) {
                    frag_two_obj.setButtonText(player, 4);
                    if (player.contentEquals(hMap.get(ranB).player)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranB).player, 1);

                    if (player.contentEquals(hMap.get(ranC).player)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranC).player, 3);

                    if (player.contentEquals(hMap.get(ranD).player)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranD).player, 2);
                }
                break;
            case 3:
                //set button text to position
                ranCorrect = ((int) (Math.random()*4));
                if (ranCorrect == 0) {
                    frag_two_obj.setButtonText(playerPosition, 1);
                    if (playerPosition.contentEquals(hMap.get(ranB).position)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranB).position, 2);

                    if (playerPosition.contentEquals(hMap.get(ranC).position)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranC).position, 3);

                    if (playerPosition.contentEquals(hMap.get(ranD).position)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranD).position, 4);
                } else if (ranCorrect == 1) {
                    frag_two_obj.setButtonText(playerPosition, 2);
                    if (playerPosition.contentEquals(hMap.get(ranB).position)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranB).position, 1);

                    if (playerPosition.contentEquals(hMap.get(ranC).position)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranC).position, 3);

                    if (playerPosition.contentEquals(hMap.get(ranD).position)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranD).position, 4);
                } else if (ranCorrect == 2) {
                    frag_two_obj.setButtonText(playerPosition, 3);
                    if (playerPosition.contentEquals(hMap.get(ranB).position)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranB).position, 1);

                    if (playerPosition.contentEquals(hMap.get(ranC).position)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranC).position, 2);

                    if (playerPosition.contentEquals(hMap.get(ranD).position)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranD).position, 4);
                } else if (ranCorrect == 3) {
                    frag_two_obj.setButtonText(playerPosition, 4);
                    if (playerPosition.contentEquals(hMap.get(ranB).position)) {
                        ranB = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranB).position, 1);

                    if (playerPosition.contentEquals(hMap.get(ranC).position)) {
                        ranC = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranC).position, 3);

                    if (playerPosition.contentEquals(hMap.get(ranD).position)) {
                        ranD = ((int) (Math.random() * 20));
                    }
                    frag_two_obj.setButtonText(hMap.get(ranD).position, 2);
                }
                break;
        }


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


    public void chooseAnswer() {
        //int id = view.getId();
        questionNum = ((int) Math.random()*4);
        Button b1 = findViewById(R.id.answerA);
        Button b2 = findViewById(R.id.answerB);
        Button b3 = findViewById(R.id.answerC);
        Button b4 = findViewById(R.id.answerD);

        switch (frag_two_obj.buttonPressed) {
            case R.id.answerA:
                switch (questionNum) {
                    //For some reason only the position registers if the correct answer is chosen (something to do with the check to see if strings are equal b/c position is char not string)
                    //Have tried b2.getText().toString().equalsIgnoreCase(playerTeam) as well as using .equals and .contentEquals with no luck
                    case 0:
                        if (playerPosition.contentEquals(b1.getText())) {
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
                        if (playerPosition.contentEquals(b2.getText())) {
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
                        if (playerPosition.contentEquals(b3.getText())) {
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

    //class that stores the values of the manually added players from HashMap (passed into HashMap)
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