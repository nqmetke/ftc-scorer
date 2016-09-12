package com.nqmetke.ftc_scorer;

import android.content.Intent;
import android.media.Image;
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
    private int particleNumberAutoCenter;
    private int particleNumberAutoVortex;
    private int particleNumberTeleCenter;
    private int particleNumberTeleVortex;
    private TextView textCenterVal;
    private TextView textSideVal;
    private TextView textCenterValTele;
    private TextView textSideValTele;

    private ToggleButton beacon1;
    private ToggleButton beacon2;
    private ToggleButton beacon3;
    private ToggleButton parkNoneAutoBase;
    private ToggleButton parkPartialAutoBase;
    private ToggleButton parkFullAutoBase;
    private ToggleButton parkNoneAutoSide;
    private ToggleButton parkPartialAutoSide;
    private ToggleButton parkFullAutoSide;
    private ToggleButton teleBeacon1;
    private ToggleButton teleBeacon2;
    private ToggleButton teleBeacon3;
    private ToggleButton teleBeacon4;
    private ToggleButton teleBeacon5;
    private ToggleButton endNone;
    private ToggleButton endLow;
    private ToggleButton endHigh;
    private ToggleButton endCap;

    private TextView scoreText;
    private ImageButton aboutBtn;
    private ToggleButton capBallBtn;

    private int scoreTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageButton addParticleCenterAuto;
        ImageButton addParticleVortexAuto;
        ImageButton subParticleCenterAuto;
        ImageButton subParticleVortexAuto;
        ImageButton addParticleCenterTele;
        ImageButton addParticleVortexTele;
        ImageButton subParticleCenterTele;
        ImageButton subParticleVortexTele;

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
        aboutBtn = (ImageButton)findViewById(R.id.aboutBtn);
        capBallBtn =(ToggleButton)findViewById(R.id.cap_ball);
        parkNoneAutoBase =(ToggleButton)findViewById(R.id.parkNoneAutoBase);
        parkPartialAutoBase =(ToggleButton)findViewById(R.id.parkPartialAutoBase);
        parkFullAutoBase =(ToggleButton)findViewById(R.id.parkFullAutoBase);
        parkNoneAutoSide =(ToggleButton)findViewById(R.id.parkNoneAutoSide);
        parkPartialAutoSide =(ToggleButton)findViewById(R.id.parkPartialAutoSide);
        parkFullAutoSide =(ToggleButton)findViewById(R.id.parkFullAutoSide);
        subParticleCenterAuto = (ImageButton)findViewById(R.id.subParticleAutoCenter);
        subParticleVortexAuto = (ImageButton)findViewById(R.id.subParticleAutoVortex);
        addParticleCenterAuto = (ImageButton)findViewById(R.id.addSubAutoCenter);
        addParticleVortexAuto = (ImageButton)findViewById(R.id.addSubAutoVortex);
        textCenterVal = (TextView)findViewById(R.id.textCenterVal);
        textSideVal = (TextView)findViewById(R.id.textSideVal);
        textCenterValTele = (TextView)findViewById(R.id.textCenterValTele);
        textSideValTele = (TextView)findViewById(R.id.textSideValTele);
        addParticleCenterTele = (ImageButton)findViewById(R.id.addParticleTeleCenter);
        addParticleVortexTele = (ImageButton)findViewById(R.id.addSubTeleVortex);
        subParticleCenterTele = (ImageButton)findViewById(R.id.subParticleTeleCenter);
        subParticleVortexTele = (ImageButton)findViewById(R.id.subParticleTeleVortex);
        teleBeacon1 = (ToggleButton)findViewById(R.id.teleBeacon1);
        teleBeacon2 = (ToggleButton)findViewById(R.id.teleBeacon2);
        teleBeacon3 = (ToggleButton)findViewById(R.id.teleBeacon3);
        teleBeacon4 = (ToggleButton)findViewById(R.id.teleBeacon4);
        teleBeacon5 = (ToggleButton)findViewById(R.id.teleBeacon5);
        endNone = (ToggleButton)findViewById(R.id.endNone);
        endLow = (ToggleButton)findViewById(R.id.endLow);
        endHigh = (ToggleButton)findViewById(R.id.endHigh);
        endCap = (ToggleButton)findViewById(R.id.endCap);





        reset.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                endLow.setChecked(false);
                endHigh.setChecked(false);
                endCap.setChecked(false);
                endNone.setChecked(false);
                teleBeacon1.setChecked(false);
                teleBeacon2.setChecked(false);
                teleBeacon3.setChecked(false);
                teleBeacon4.setChecked(false);
                teleBeacon5.setChecked(false);
                capBallBtn.setChecked(false);
                parkNoneAutoBase.setChecked(false);
                parkPartialAutoBase.setChecked(false);
                parkFullAutoBase.setChecked(false);
                parkNoneAutoSide.setChecked(false);
                parkPartialAutoSide.setChecked(false);
                parkFullAutoSide.setChecked(false);
                beacon1.setChecked(false);
                beacon2.setChecked(false);
                beacon3.setChecked(false);
                particleNumberAutoCenter = 0;
                particleNumberAutoVortex = 0;
                particleNumberTeleCenter = 0;
                particleNumberTeleVortex = 0;
                scoreTotal = 0;

                textSideVal.setText(""+particleNumberAutoVortex);
                textCenterVal.setText(""+particleNumberAutoCenter);
                textSideValTele.setText(""+particleNumberTeleVortex);
                textCenterValTele.setText(""+particleNumberTeleCenter);
                scoreText.setText(""+scoreTotal);

            }
        });
        aboutBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AboutActivity.class));
            }
        });
        subParticleVortexAuto.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
               particleNumberAutoVortex -= 1;
                scoreTotal -= 5;
                textSideVal.setText(""+particleNumberAutoVortex);
                scoreText.setText(""+scoreTotal);

            }
        });
        addParticleCenterAuto.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                particleNumberAutoCenter += 1;
                scoreTotal += 15;
                textCenterVal.setText(""+particleNumberAutoCenter);
                scoreText.setText(""+scoreTotal);
            }
        });
        addParticleVortexAuto.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                particleNumberAutoVortex += 1;
                scoreTotal += 5;
                textSideVal.setText(""+particleNumberAutoVortex);
                scoreText.setText(""+scoreTotal);
            }
        });
        subParticleCenterAuto.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                scoreTotal -= 15;
                particleNumberAutoCenter -= 1;
                textCenterVal.setText(""+particleNumberAutoCenter);
                scoreText.setText(""+scoreTotal);
            }
        });




        subParticleVortexTele.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                particleNumberTeleVortex -= 1;
                scoreTotal -= 1;
                textSideValTele.setText(""+particleNumberTeleVortex);
                scoreText.setText(""+scoreTotal);

            }
        });
        addParticleCenterTele.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                particleNumberTeleCenter += 1;
                scoreTotal += 5;
                textCenterValTele.setText(""+particleNumberTeleCenter);
                scoreText.setText(""+scoreTotal);
            }
        });
        addParticleVortexTele.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                particleNumberTeleVortex += 1;
                scoreTotal += 1;
                textSideValTele.setText(""+particleNumberTeleVortex);
                scoreText.setText(""+scoreTotal);
            }
        });
        subParticleCenterTele.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                scoreTotal -= 5;
                particleNumberTeleCenter -= 1;
                textCenterValTele.setText(""+particleNumberTeleCenter);
                scoreText.setText(""+scoreTotal);
            }
        });









        endNone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    endLow.setChecked(false);
                    endHigh.setChecked(false);
                    endCap.setChecked(false);

                    scoreTotal += 0;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 0;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });

        endLow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    endNone.setChecked(false);
                    endHigh.setChecked(false);
                    endCap.setChecked(false);
                    scoreTotal += 10;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 10;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });

        endHigh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    endNone.setChecked(false);
                    endLow.setChecked(false);
                    endCap.setChecked(false);

                    scoreTotal += 20;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 20;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });

        endCap.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    endNone.setChecked(false);
                    endLow.setChecked(false);
                    endHigh.setChecked(false);

                    scoreTotal += 40;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 40;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });






        teleBeacon1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    teleBeacon2.setChecked(false);
                    teleBeacon3.setChecked(false);
                    teleBeacon4.setChecked(false);
                    teleBeacon5.setChecked(false);
                    scoreTotal += 0;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 0;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });

        teleBeacon2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    teleBeacon1.setChecked(false);
                    teleBeacon3.setChecked(false);
                    teleBeacon4.setChecked(false);
                    teleBeacon5.setChecked(false);
                    scoreTotal += 10;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 10;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });

        teleBeacon3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    teleBeacon2.setChecked(false);
                    teleBeacon1.setChecked(false);
                    teleBeacon4.setChecked(false);
                    teleBeacon5.setChecked(false);
                    scoreTotal += 20;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 20;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });

        teleBeacon4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    teleBeacon2.setChecked(false);
                    teleBeacon3.setChecked(false);
                    teleBeacon1.setChecked(false);
                    teleBeacon5.setChecked(false);
                    scoreTotal += 30;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 30;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });

        teleBeacon5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    teleBeacon2.setChecked(false);
                    teleBeacon3.setChecked(false);
                    teleBeacon4.setChecked(false);
                    teleBeacon1.setChecked(false);
                    scoreTotal += 40;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 40;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });





        parkNoneAutoBase.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    parkFullAutoBase.setChecked(false);
                    parkPartialAutoBase.setChecked(false);
                    scoreTotal += 0;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 0;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });
        parkPartialAutoBase.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    parkFullAutoBase.setChecked(false);
                    parkNoneAutoBase.setChecked(false);
                    scoreTotal += 5;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 5;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });
        parkFullAutoBase.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    parkPartialAutoBase.setChecked(false);
                    parkNoneAutoBase.setChecked(false);
                    scoreTotal += 10;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 10;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });
        parkNoneAutoSide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    parkFullAutoSide.setChecked(false);
                    parkPartialAutoSide.setChecked(false);
                    scoreTotal += 0;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 0;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });
        parkPartialAutoSide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    parkFullAutoSide.setChecked(false);
                    parkNoneAutoSide.setChecked(false);
                    scoreTotal += 5;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 5;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });
        parkFullAutoSide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    parkPartialAutoSide.setChecked(false);
                    parkNoneAutoSide.setChecked(false);
                    scoreTotal += 10;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 10;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });
        beacon1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    beacon2.setChecked(false);
                    beacon3.setChecked(false);
                    scoreTotal += 0;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 0;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });
        beacon2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    beacon1.setChecked(false);
                    beacon3.setChecked(false);
                    scoreTotal += 30;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 30;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });
        beacon3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    beacon1.setChecked(false);
                    beacon2.setChecked(false);
                    scoreTotal += 60;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 60;
                    scoreText.setText(""+scoreTotal);
                }
            }
        });


        capBallBtn.setOnCheckedChangeListener((new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    scoreTotal += 5;
                    scoreText.setText(""+scoreTotal);
                }
                else{
                    scoreTotal -= 5;
                    scoreText.setText(""+scoreTotal);
                }
            }
        }));




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
