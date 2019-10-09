package com.mfrancetic.basicphrases;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AudioManager audioManager;

    private MediaPlayer mediaPlayer;

    private Uri audioUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume, 0);
    }

    public void playAudioPhrase(View view) {
        Button button = (Button) view;
        int tag = Integer.parseInt(button.getTag().toString());
        String audioUriString = "android.resource://" + getPackageName() +
                "/";
        switch (tag) {
            case 0:
                audioUri = Uri.parse(audioUriString + R.raw.hello_german);
                break;
            case 1:
                audioUri = Uri.parse(audioUriString + R.raw.goodbye_german);
                break;
            case 2:
                audioUri = Uri.parse(audioUriString + R.raw.please_german);
                break;
            case 3:
                audioUri = Uri.parse(audioUriString + R.raw.thank_you_german);
                break;
            case 4:
                audioUri = Uri.parse(audioUriString + R.raw.what_is_your_name_german);
                break;
            case 5:
                audioUri = Uri.parse(audioUriString + R.raw.where_are_you_from_german);
                break;
            case 6:
                audioUri = Uri.parse(audioUriString + R.raw.how_are_you_german);
                break;
            case 7:
                audioUri = Uri.parse(audioUriString + R.raw.nice_to_meet_you_german);
                break;

        }
        mediaPlayer = MediaPlayer.create(this, audioUri);
        mediaPlayer.start();
    }
}