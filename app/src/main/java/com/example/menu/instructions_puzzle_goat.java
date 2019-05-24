package com.example.menu;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class instructions_puzzle_goat extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions_word_search_goat);
        final VideoView instr = findViewById(R.id.instr);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.instructions_puzzle_edited_trim;
        Uri uri = Uri.parse(videoPath);
        instr.setVideoURI(uri);
        instr.start();
        instr.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                instr.start();
            }
        });
        Button next_btn = findViewById(R.id.next_btn);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(instructions_puzzle_goat.this, puzzle_goat.class);
                startActivity(intent);
            }
        });
    }
}
