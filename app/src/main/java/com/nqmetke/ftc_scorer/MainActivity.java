package com.nqmetke.ftc_scorer;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ImageButton reset;
    private String timerState = "0";
    private ToggleButton beacon1;
    private ToggleButton beacon2;
    private ToggleButton beacon3;
    private TextView scoreText;
    private int scoreTotal = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        setTitle(timerState);

        FloatingActionButton timerFab = (FloatingActionButton) findViewById(R.id.timerFab);
        reset = (ImageButton)findViewById(R.id.resetBtn);
        beacon1 = (ToggleButton)findViewById(R.id.beacon_1);
        beacon2 = (ToggleButton)findViewById(R.id.beacon_2);
        beacon3 = (ToggleButton)findViewById(R.id.beacon_3);
        scoreText=(TextView)findViewById(R.id.scoreText);

        beacon1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    beacon2.setChecked(false);
                    beacon3.setChecked(false);
                    scoreTotal += 10;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 10;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });
        beacon2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    beacon1.setChecked(false);
                    beacon3.setChecked(false);
                    scoreTotal += 20;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 20;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });
        beacon3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    beacon1.setChecked(false);
                    beacon2.setChecked(false);
                    scoreTotal += 30;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 30;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });

        timerFab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startTimer(150000);
            }
        });
    }
    void startTimer(int time){
        System.out.println("Test");
        new CountDownTimer(time, 1000) {

            public void onTick(long millisUntilFinished) {
                if(millisUntilFinished <= 150000 && millisUntilFinished >120000) {
                    timerState = "Autonomous: " + millisUntilFinished / 1000;
                }
                else{
                    timerState = "Tele-op: " + millisUntilFinished / 1000;
                }
                setTitle(timerState);

            }

            public void onFinish() {
                timerState = "Done!";
                setTitle(timerState);
            }
        }.start();
    }



}
