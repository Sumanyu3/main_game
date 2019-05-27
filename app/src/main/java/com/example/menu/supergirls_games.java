package com.example.menu;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class supergirls_games extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supergirls_games);
        Button game1 = findViewById(R.id.game1);
        Button game2 = findViewById(R.id.game2);
        game1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(supergirls_games.this, instructions_word_search_supergirls.class);
                startActivity(intent);
            }
        });
        game2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(supergirls_games.this, instructions_puzzle_supergirls.class);
                startActivity(intent);
            }
        });
    }
}
