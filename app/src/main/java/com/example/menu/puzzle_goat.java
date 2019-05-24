package com.example.menu;


import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class puzzle_goat extends Activity {

    private static int COLUMNS = 3;
    private static int DIMENSIONS = COLUMNS*COLUMNS;
    private static String titleList[];
    private static GestureDetectGridView mGridView;
    private static int mColumnWidth, mColumnHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_goat);
        init();
        scramble();
        setDimensions();

    }

    private void setDimensions() {
        ViewTreeObserver vto = mGridView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mGridView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int displayWidth = mGridView.getMeasuredWidth();
                int displayHeight = mGridView.getMeasuredHeight();
                int statusbarHeight = getStatusbarHeight(getApplicationContext());
                int requiredHeight = displayHeight - statusbarHeight;
                mColumnWidth = displayWidth/COLUMNS;
                mColumnHeight = displayHeight/COLUMNS;

                display(getApplicationContext());
            }
        });
    }

    private int getStatusbarHeight(Context context){
        int result=0;
        int resourceID = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if(resourceID>0){
            result = context.getResources().getDimensionPixelSize(resourceID);

        }
        return result;
    }

    private static void display(Context context) {
        ArrayList<Button> buttons = new ArrayList<>();
        Button button;
        for (int i=0;i<titleList.length;i++){
            button = new Button(context);
            if(titleList[i].equals("0")){
                button.setBackgroundResource(R.drawable.crop11);
            }
            else if(titleList[i].equals("1")){
                button.setBackgroundResource(R.drawable.crop12);
            }
            else if(titleList[i].equals("2")){
                button.setBackgroundResource(R.drawable.crop13);
            }
            else if(titleList[i].equals("3")){
                button.setBackgroundResource(R.drawable.crop21);
            }
            else if(titleList[i].equals("4")){
                button.setBackgroundResource(R.drawable.crop22);
            }
            else if(titleList[i].equals("5")){
                button.setBackgroundResource(R.drawable.crop23);
            }
            else if(titleList[i].equals("6")){
                button.setBackgroundResource(R.drawable.crop31);
            }
            else if(titleList[i].equals("7")){
                button.setBackgroundResource(R.drawable.crop32);
            }
            else if(titleList[i].equals("8")){
                button.setBackgroundResource(R.drawable.crop33);
            }

            buttons.add(button);
        }

        mGridView.setAdapter(new CustomAdapter(buttons, mColumnWidth, mColumnHeight));

    }

    private void scramble() {
        int index;
        String temp;
        Random random = new Random();
        for(int i = titleList.length-1;i>0;i--){
            index = random.nextInt(i+1);
            temp = titleList[index];
            titleList[index] = titleList[i];
            titleList[i] = temp;
        }

    }

    private void init(){
        mGridView = (GestureDetectGridView)findViewById(R.id.grid);
        mGridView.setNumColumns(COLUMNS);
        titleList = new String[DIMENSIONS];
        for(int i=0;i<DIMENSIONS;i++){
            titleList[i] = String.valueOf(i);

        }
    }

    private static void swap(Context context, int position, int swap) {
        String newPosition = titleList[position + swap];
        titleList[position + swap] = titleList[position];
        titleList[position] = newPosition;
        display(context);
        if (isSolved() == true) {
            Toast.makeText(context, "YOU WIN!", Toast.LENGTH_SHORT).show();
        }
    }

    private static boolean isSolved() {
        boolean solved=false;
        for(int i=0;i<titleList.length;i++){
            if(titleList[i].equals(String.valueOf(i))){
                solved = true;
            }
            else{
                solved=false;
                break;
            }
        }
        return solved;
    }

    public static void moveTiles(Context context,String direction, int position){
        //Upper left corner
        if(position==0){
            if(direction.equals("right")){
                swap(context ,position, 1);

            }
            else if(direction.equals(("down"))){
                swap(context, position,COLUMNS);
            }

        }

        //Upper center
        else if(position>0 && position<COLUMNS-1){
            if((direction.equals("right"))){
                swap(context, position,1);
            }
            else if((direction.equals("down"))){
                swap(context, position,COLUMNS);
            }
            else if(direction.equals("left")){
                swap(context, position,-1);
            }

        }

        //Upper right corner
        else if(position==COLUMNS-1){
            if((direction.equals("down"))){
                swap(context, position,COLUMNS);
            }
            else if(direction.equals("left")){
                swap(context, position,-1);
            }
        }

        //Left Side
        else if(position>COLUMNS-1 && position<DIMENSIONS-COLUMNS && position%COLUMNS==0){
            if((direction.equals("up"))){
                swap(context, position,-COLUMNS);
            }
            else if((direction.equals("down"))){
                swap(context, position,COLUMNS);
            }
            else if(direction.equals("right")){
                swap(context, position,1);
            }
        }

        //Right and bottom right
        else if(position==(2*COLUMNS)-1 || position==(3*COLUMNS)-1){
            if((direction.equals("up"))){
                swap(context, position,-COLUMNS);
            }
            else if(direction.equals("left")){
                swap(context, position,-1);
            }
            else if(direction.equals("down")){
                if(position<=DIMENSIONS-COLUMNS-1){
                    swap(context,position,COLUMNS);
                }

            }
        }
        //Bottom Left Corner
        else if(position==DIMENSIONS-COLUMNS){
            if((direction.equals("up"))){
                swap(context, position,-COLUMNS);
            }
            else if(direction.equals("right")){
                swap(context, position,1);
            }
        }

        //Bottom Centre
        else if(position<DIMENSIONS-1 && position>DIMENSIONS-COLUMNS){
            if((direction.equals("up"))){
                swap(context, position,-COLUMNS);
            }
            else if(direction.equals("right")){
                swap(context, position,1);
            }
            else if(direction.equals("left")){
                swap(context, position,-1);
            }
        }

        // Centre
        else{
            if((direction.equals("up"))){
                swap(context, position,-COLUMNS);
            }
            else if(direction.equals("right")){
                swap(context, position,1);
            }
            else if(direction.equals("left")){
                swap(context, position,-1);
            }
            else{
                swap(context, position,COLUMNS);
            }
        }


    }
}
