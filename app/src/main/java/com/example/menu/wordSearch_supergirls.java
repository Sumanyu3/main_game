package com.example.menu;

import android.app.Activity;
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



public class wordSearch_supergirls extends Activity implements View.OnClickListener {

    private Button[][] buttons = new Button[6][8];
    private String word;
    private int btnCounter=0;
    public static final String TAG = "MainActivity  ";
    private View prev;
    public String[] soln;
    private ArrayList<Button> clicked_btns = new ArrayList<>();
    private int horizontal_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_search_supergirls);
        soln = new String[9];
        soln[0] = "निरोग";
        soln[1] = "नहाना";
        soln[2] = "कुल्लाकरना";
        soln[3] = "अच्छीसेहत";
        soln[4] = "साबुन";
        soln[5] = "मुँहढकना";
        soln[6] = "हाथधोना";
        soln[7] = "रगड़ना";
        soln[8] = "सफाई";

        for(int i=1;i<=6;i++){
            for(int j=1;j<=8;j++){
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
           // Toast.makeText(this, word, Toast.LENGTH_SHORT).show();
            clicked_btns.add((Button)v);
            v.setBackgroundResource(R.drawable.pressed);
        }
        else {
            btnCounter=btnCounter+1;

            if(Math.abs(prev.getId()-v.getId())==1) {
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
                    TextView healthy = findViewById(R.id.healthy);
                    TextView bath = findViewById(R.id.bath);
                    TextView mouthwash = findViewById(R.id.mouthwash);
                    TextView goodhealth = findViewById(R.id.goodhealth);
                    TextView soap = findViewById(R.id.soap);
                    TextView cover = findViewById(R.id.cover);
                    TextView washhands = findViewById(R.id.washhands);
                    TextView wash = findViewById(R.id.wash);
                    TextView clean = findViewById(R.id.clean);

                    for (int i = 0; i < soln.length; i++) {
                        if (soln[i].equals(word)) {
                            Log.d(TAG, "onClick: CORRECT ANSWER");
                            //Toast.makeText(this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                            btnCounter = 0;
                            if(word.equals("निरोग")){
                                healthy.setPaintFlags(healthy.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            }
                            if(word.equals("नहाना")){
                                bath.setPaintFlags(bath.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            }
                            if(word.equals("कुल्लाकरना")){
                                mouthwash.setPaintFlags(mouthwash.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            }
                            if(word.equals("अच्छीसेहत")){
                                goodhealth.setPaintFlags(goodhealth.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            }
                            if(word.equals("साबुन")){
                                soap.setPaintFlags(soap.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            }
                            if(word.equals("मुँहढकना")){
                                cover.setPaintFlags(cover.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            }
                            if(word.equals("हाथधोना")){
                                washhands.setPaintFlags(washhands.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            }
                            if(word.equals("रगड़ना")){
                                wash.setPaintFlags(wash.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            }
                            if(word.equals("सफाई")){
                                clean.setPaintFlags(clean.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
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

            else if(Math.abs(prev.getId()-v.getId())==8){
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
                    TextView healthy = findViewById(R.id.healthy);
                    TextView bath = findViewById(R.id.bath);
                    TextView mouthwash = findViewById(R.id.mouthwash);
                    TextView goodhealth = findViewById(R.id.goodhealth);
                    TextView soap = findViewById(R.id.soap);
                    TextView cover = findViewById(R.id.cover);
                    TextView washhands = findViewById(R.id.washhands);
                    TextView wash = findViewById(R.id.wash);
                    TextView clean = findViewById(R.id.clean);
                    for (int i = 0; i < soln.length; i++) {
                        if (soln[i].equals(word)) {
                            Log.d(TAG, "onClick: CORRECT ANSWER");
                            //Toast.makeText(this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                            btnCounter = 0;
                            if(word.equals("निरोग")){
                                healthy.setPaintFlags(healthy.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            }
                            if(word.equals("नहाना")){
                                bath.setPaintFlags(bath.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            }
                            if(word.equals("कुल्लाकरना")){
                                mouthwash.setPaintFlags(mouthwash.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            }
                            if(word.equals("अच्छीसेहत")){
                                goodhealth.setPaintFlags(goodhealth.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            }
                            if(word.equals("साबुन")){
                                soap.setPaintFlags(soap.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            }
                            if(word.equals("मुँहढकना")){
                                cover.setPaintFlags(cover.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            }
                            if(word.equals("हाथधोना")){
                                washhands.setPaintFlags(washhands.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            }
                            if(word.equals("रगड़ना")){
                                wash.setPaintFlags(wash.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            }
                            if(word.equals("सफाई")){
                                clean.setPaintFlags(clean.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
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


    }
}
