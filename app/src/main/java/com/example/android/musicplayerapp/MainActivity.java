package com.example.android.musicplayerapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int startTime ;
    private int finalTime ;
    private final int forwardTime = 5000;
    private final int backwardTime = 5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //create mediaplayer object
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.mitwa);


         // Button for playing audio files
        Button play = (Button)findViewById(R.id.play);

        //Set the click listener on play button
        play.setOnClickListener(view -> mediaPlayer.start());

        //Button for pausing audio files
        Button pause = (Button)findViewById(R.id.pause);

        //Set the click listener on pause button
        pause.setOnClickListener(view -> mediaPlayer.pause());

        startTime = mediaPlayer.getCurrentPosition();
        finalTime = mediaPlayer.getDuration();


         // Button for increasing the song by 5 seconds
        Button forward = (Button)findViewById(R.id.forward);

        //Set the click listener on increase volume button
        forward.setOnClickListener((View.OnClickListener) view -> {
            int temp = (int) startTime;

            if((temp + forwardTime) <= finalTime){
                startTime += forwardTime;
                mediaPlayer.seekTo(startTime);
                Toast.makeText(getApplicationContext(), "You've jumped 5 seconds forward.", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "You cannot jump 5 seconds forward", Toast.LENGTH_SHORT).show();
            }
        });


        //Button for decreasing the song by 5 seconds
        Button decrease = (Button)findViewById(R.id.backward);

        //Set the click listener on decrease volume button
        decrease.setOnClickListener((View.OnClickListener) view -> {
            int temp = (int)startTime;

            if((temp - backwardTime) > 0){
                startTime -= backwardTime;
                mediaPlayer.seekTo(startTime);
                Toast.makeText(getApplicationContext(), "You've jumped 5 seconds backward.", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "You cannot jump 5 seconds backward", Toast.LENGTH_SHORT).show();
            }
        });

    }
}