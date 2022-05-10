package com.sanchit.X0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.CollationElementIterator;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
// State representation:
// O represents 0
// x represents 1
// null represents 2
    int activePlayer = 0;
    int [] gameState= {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int [][]winningPositions = {{0,1,2},{3,4,5},{6,7,8},
                                {0,3,6},{1,4,7},{2,5,8},
                                {0,4,8},{2,4,6}};

    public void onTap(View view){
        ImageView image = (ImageView) view;
        int activeImage= Integer.parseInt(image.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }
        if(gameState[activeImage] == 2 && gameActive){
            gameState[activeImage] = activePlayer;
            image.setTranslationY(-1000f);
            if(activePlayer == 0){
                image.setImageResource(R.drawable.o);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("X's turn");
            }else{
                image.setImageResource(R.drawable.x);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("O's turn");
            }
            image.animate().translationYBy(1000f).setDuration(300);
        }
//checking if player is won
        for(int[] winningPosition: winningPositions){
            if(gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                gameState[winningPosition[0]]!=2){
//finding who won
                String winnerStr;
                gameActive = false;
                if(gameState[winningPosition[0]] == 0){
                    winnerStr = " O has won... KUDOS!!! ";
                }else{
                    winnerStr = " X has won... KUDOS!!!";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
            }
        }
    }

    public void gameReset(View view){
        gameActive = true;
        activePlayer = 0;
        for(int i=0; i<gameState.length; i++){
            gameState[i] = 2;
        }
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        TextView status = findViewById(R.id.status);
        status.setText("O's turn- Tap to start");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}