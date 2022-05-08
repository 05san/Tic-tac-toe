package com.sanchit.X0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
// State representation:
// X represents 0
// O represents 1
// null represents 2
    int activePlayer = 0;
    int gameState[]= {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int winningPositions[][] = {{0,1,2},{3,4,5},{6,7,8},
                                {0,3,6},{1,4,7},{2,5,8},
                                {0,4,8},{2,4,6}};
    public void onTap(View view){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}