package edu.quinnipiac.ser210.triviaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.AsyncTask;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    /*
    String playerTeam;
    String playerHeight;
    String playerPosition;
     */
    Button bPressed;
    PlayerHandler pHandler = new PlayerHandler();
    private String url1 = "https://free-nba.p.rapidapi.com/players/";
    private String LOG_TAG = MainActivity.class.getSimpleName();
    private ShareActionProvider provider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
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
                Intent intent = new Intent(MainActivity.this, AboutPage.class);
                startActivity(intent);
                //information about the developer
                break;
            case R.id.action_share:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_TEXT,"(EditText)findViewById(R.id.score).getText().toString");
                provider.setShareIntent(sharingIntent);
                break;
            default:
                return super.onOptionsItemSelected(item);

        }
        return super.onOptionsItemSelected(item);
    }

    public void startGame(View view) {
        bPressed = (Button) view;
        new FetchPlayer().execute(this.getPlayer());
        /*
        Intent intent = new Intent(MainActivity.this,GameScreen.class);
        startActivity(intent);
         */
    }

    public String getPlayer() {
       int playerNum = (int) (Math.random() * 450 + 1);
       String playerId = String.valueOf(playerNum);
       return playerId;
    }


    class FetchPlayer extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            String player;
            String playerTeam;

            try {
                URL url = new URL(url1 + strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("X-RapidAPI-Key","b1f8396a9emsh5ba48decef16568p1e9b05jsn04b9cde32e60");
                urlConnection.connect();


                InputStream in = urlConnection.getInputStream();

                if (in == null) {
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(in));
                player = getStringFromBuffer(reader);

                Log.v("Player Name", player);

            } catch (Exception e) {
                Log.e(LOG_TAG, "Error" + e.getMessage());
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        Log.e(LOG_TAG, "Error" + e.getMessage());
                        return null;
                    }
                }

            }
            return player;
        }
        protected void onPostExecute(String result) {
            if (result != null)
                Log.d(LOG_TAG,"Result is null");
/*
            String[] s = result.split(" ");
            for (String a : s) {
                Log.v("TeamSplit", a);
                playerTeam = a;
            }
            result = result.replaceAll(playerTeam, "");

 */

            //result = result.replaceAll("\\s+$", "");
            //Log.v("Result", result);
            Intent intent = new Intent(MainActivity.this, GameScreen.class);
            intent.putExtra("player",result);
            intent.putExtra("player team",PlayerHandler.playerTeam);
            intent.putExtra("player height",PlayerHandler.playerHeight);
            intent.putExtra("player position",PlayerHandler.playerPosition);
            intent.putExtra("category", bPressed.getText());
            startActivity(intent);
        }
    }

    private String getStringFromBuffer(BufferedReader bufferedReader) {
        StringBuffer buffer = new StringBuffer();
        String line;

        if (bufferedReader != null) {
            try {
                while((line = bufferedReader.readLine()) != null) {
                    buffer.append(line + '\n');
                }
                bufferedReader.close();
                return pHandler.getPlayer(buffer.toString());

              //  return pHandler.getPlayerName(buffer.toString());
            } catch (Exception e) {
                Log.e("MainActivity","Error" + e.getMessage());
                return null;
            }
        }
        return null;
    }
}