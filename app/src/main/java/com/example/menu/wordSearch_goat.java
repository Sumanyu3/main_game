package com.example.menu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//If correct answer already given then remove from list
//Reset button



public class wordSearch_goat extends Activity implements View.OnClickListener {

    private Button[][] buttons = new Button[4][4];
    private String word;
    private int btnCounter=0;
    public static final String TAG = "MainActivity";
    private View prev;
    public String soln[];
    private ArrayList<Button> clicked_btns = new ArrayList<>();
    private int horizontal_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_search_goat);
        soln = new String[3];
        soln[0] = "हसीना";
        soln[1] = "पक्षीराज";
        soln[2] = "बकरी";
        for(int i=1;i<=4;i++){
            for(int j=1;j<=4;j++){
                String buttonID = "btn" + "_" + i+"X"+j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i-1][j-1] = findViewById(resID);
                buttons[i-1][j-1].setOnClickListener(this);
            }
        }

        Button reset_btn = findViewById(R.id.btn_reset);
        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCounter = 0;
                while(clicked_btns.size()!=0) {
                    clicked_btns.get(0).setBackgroundResource(R.drawable.default_button);
                    clicked_btns.remove(0);
                }
            }
        });
    }



    @Override
    public void onClick(View v) {

        if(btnCounter==0){
            word = ((Button) v).getText().toString();
            btnCounter = 1;
            prev = v;
            Log.d(TAG, "onClick: " + word);
            //Toast.makeText(this, word, Toast.LENGTH_SHORT).show();
            clicked_btns.add((Button)v);
            v.setBackgroundResource(R.drawable.pressed);
        }
        else {
            btnCounter=btnCounter+1;

            if(Math.abs(prev.getId()-v.getId())==1) {
                Log.d(TAG, "onClick: prev id" + prev.getId());
                Log.d(TAG, "onClick: curr id" + v.getId());
                Log.d(TAG, "onClick: entered 1");
                if(btnCounter==2){
                    if(Math.abs(prev.getId()-v.getId())==1){
                        horizontal_check=1;
                    }
                    else if(Math.abs(prev.getId()-v.getId())==8){
                        horizontal_check=0;
                    }
                }
                if(horizontal_check==1) {
                    prev = v;
                    //btnCounter = btnCounter + 1;
                    word = word + ((Button) v).getText().toString();
                    v.setBackgroundResource(R.drawable.pressed);
                    clicked_btns.add((Button) v);
                    TextView girl = findViewById(R.id.girl);
                    TextView horse = findViewById(R.id.horse);
                    TextView goat = findViewById(R.id.goat);
                    for (int i = 0; i < soln.length; i++) {
                        if (soln[i].equals(word)) {
                            Log.d(TAG, "onClick: CORRECT ANSWER");
                            //Toast.makeText(this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                            btnCounter = 0;
                            if(word.equals("हसीना")){
                                girl.setPaintFlags(girl.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            }
                            if(word.equals("पक्षीराज")){
                                horse.setPaintFlags(horse.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            }
                            if(word.equals("बकरी")){
                                goat.setPaintFlags(goat.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            }
                            while (clicked_btns.size() != 0) {
                                clicked_btns.get(0).setBackgroundResource(R.drawable.correct);
                                clicked_btns.get(0).setEnabled(false);
                                clicked_btns.remove(0);
                            }

                        }
                    }
                    Log.d(TAG, "onClick: " + word);
                    //Toast.makeText(this, word, Toast.LENGTH_SHORT).show();
                }

                else{
                    while(clicked_btns.size()!=0){
                        clicked_btns.get(0).setBackgroundResource(R.drawable.default_button);
                        clicked_btns.remove(0);

                    }
                    prev = v;
                    btnCounter = 1;
                    word = ((Button) v).getText().toString();
                    Log.d(TAG, "onClick: " + word);
                    //Toast.makeText(this, word, Toast.LENGTH_SHORT).show();
                    clicked_btns.add((Button)v);
                    v.setBackgroundResource(R.drawable.pressed);
                }



            }

            else if (Math.abs(prev.getId()-v.getId())==8){
                Log.d(TAG, "onClick: prev id" + prev.getId());
                Log.d(TAG, "onClick: curr id" + v.getId());
                Log.d(TAG, "onClick: entered 4");
                //btnCounter=btnCounter+1;
                if(btnCounter==2){
                    if(Math.abs(prev.getId()-v.getId())==1){
                        horizontal_check=1;
                    }
                    else if(Math.abs(prev.getId()-v.getId())==8){
                        horizontal_check=0;
                    }
                }
                if(horizontal_check==0) {
                    prev = v;
                    //btnCounter = btnCounter + 1;
                    word = word + ((Button) v).getText().toString();
                    clicked_btns.add((Button) v);
                    v.setBackgroundResource(R.drawable.pressed);
                    TextView girl = findViewById(R.id.girl);
                    TextView horse = findViewById(R.id.horse);
                    TextView goat = findViewById(R.id.goat);
                    if(word.equals("हसीना")){
                        girl.setPaintFlags(girl.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    }
                    if(word.equals("पक्षीराज")){
                        horse.setPaintFlags(horse.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    }
                    if(word.equals("बकरी")){
                        goat.setPaintFlags(goat.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    }
                    for (int i = 0; i < soln.length; i++) {
                        if (soln[i].equals(word)) {
                            Log.d(TAG, "onClick: CORRECT ANSWER");
                            //Toast.makeText(this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                            btnCounter = 0;
                            while (clicked_btns.size() != 0) {
                                clicked_btns.get(0).setBackgroundResource(R.drawable.correct);
                                clicked_btns.get(0).setEnabled(false);
                                clicked_btns.remove(0);
                            }

                        }
                    }
                    Log.d(TAG, "onClick: " + word);
                    //Toast.makeText(this, word, Toast.LENGTH_SHORT).show();
                }

                else{
                    while(clicked_btns.size()!=0){
                        clicked_btns.get(0).setBackgroundResource(R.drawable.default_button);
                        clicked_btns.remove(0);

                    }
                    prev = v;
                    btnCounter = 1;
                    word = ((Button) v).getText().toString();
                    Log.d(TAG, "onClick: " + word);
                    //Toast.makeText(this, word, Toast.LENGTH_SHORT).show();
                    clicked_btns.add((Button)v);
                    v.setBackgroundResource(R.drawable.pressed);
                }


            }

            else{
                Log.d(TAG, "onClick: prev id" + prev.getId());
                Log.d(TAG, "onClick: curr id" + v.getId());
                Log.d(TAG, "onClick: entered rest");
                while(clicked_btns.size()!=0){
                    clicked_btns.get(0).setBackgroundResource(R.drawable.default_button);
                    clicked_btns.remove(0);

                }
                prev = v;
                btnCounter = 1;
                word = ((Button) v).getText().toString();
                Log.d(TAG, "onClick: " + word);
                //Toast.makeText(this, word, Toast.LENGTH_SHORT).show();
                clicked_btns.add((Button)v);
                v.setBackgroundResource(R.drawable.pressed);
            }
        }


    }


}