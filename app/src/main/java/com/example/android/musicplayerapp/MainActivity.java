package com.example.android.musicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * create mediaplayer object
         */
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.mitwa);

        //Button for playing audio files
        Button play = (Button)findViewById(R.id.play);

        //Set the click listener on play button
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });


        //Button for pausing audio files
        Button pause = (Button)findViewById(R.id.pause);

        //Set the click listener on pause button
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });


    }
}