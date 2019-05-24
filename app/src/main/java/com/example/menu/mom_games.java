package com.example.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mom_games extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mom_games);
        Button game1 = findViewById(R.id.game1);
        Button game2 = findViewById(R.id.game2);
        Button game3 = findViewById(R.id.game3);

        game1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mom_games.this, wordSearch_mom.class);
                startActivity(intent);
            }
        });
        game2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mom_games.this, colorPicker_mom.class);
                startActivity(intent);
            }
        });
        game3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mom_games.this, dragDrop_mom.class);
                startActivity(intent);
            }
        });
    }
}
