package com.example.menu;

import android.app.Activity;
import android.content.ClipData;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class dragDrop_goat extends Activity implements View.OnTouchListener, GestureDetector.OnGestureListener, View.OnDragListener {

    int windowwidth;
    int windowheight;

    private LayoutParams layoutParams;
    private GestureDetector mGestureDetector;
    private static final String TAG = "MainActivity";

    private View checkDrag;
    boolean isGoat = false;
    boolean isHorse = false;
    boolean isHouse = false;
    boolean isGoatVis = false;
    boolean isHorseVis = false;
    boolean isHouseVis = false;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: Working");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_drop_goat);

        windowwidth = getWindowManager().getDefaultDisplay().getWidth();
        windowheight = getWindowManager().getDefaultDisplay().getHeight();

        final TextView goat_txt = findViewById(R.id.goat_txt);
        final TextView house_txt = findViewById(R.id.house_txt);
        final TextView horse_txt = findViewById(R.id.horse_txt);
        final ImageView goat_img_dark = findViewById(R.id.goat_img_dark);
        final ImageView house_img_dark = findViewById(R.id.house_img_dark);
        final ImageView horse_img_dark = findViewById(R.id.horse_img_dark);


        goat_txt.setOnTouchListener(this);
        house_txt.setOnTouchListener(this);
        horse_txt.setOnTouchListener(this);
        goat_img_dark.setOnDragListener(this);
        house_img_dark.setOnDragListener(this);
        horse_img_dark.setOnDragListener(this);
        mGestureDetector = new GestureDetector(this, this);



    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        checkDrag = v;
        int action = event.getAction();

        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                Log.d(TAG, "Action was DOWN");
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data, shadowBuilder, v,  0);
                return true;
            case (MotionEvent.ACTION_MOVE):
                Log.d(TAG, "Action was MOVE");
                Log.d(TAG, "onTouch: " + event.getX() + " , " + event.getY());

                return true;
            case (MotionEvent.ACTION_UP):
                Log.d(TAG, "Action was UP");
                return true;
            case (MotionEvent.ACTION_CANCEL):
                Log.d(TAG, "Action was CANCEL");
                return true;
            case (MotionEvent.ACTION_OUTSIDE):
                Log.d(TAG, "Movement occurred outside bounds " +
                        "of current screen element");
                return true;
            default:
                return super.onTouchEvent(event);
        }


//        mGestureDetector.onTouchEvent(event);
//
//        return true;

    }

    @Override
    public boolean onDown(MotionEvent e) {
        Log.d(TAG, "onTouch: ");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.d(TAG, "onShowPress: ");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.d(TAG, "onSingleTapUp: ");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.d(TAG, "onScroll: ");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.d(TAG, "onLongPress: ");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.d(TAG, "onFling: ");
        return false;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        ImageView goat_img_dark = findViewById(R.id.goat_img_dark);
        ImageView house_img_dark = findViewById(R.id.house_img_dark);
        ImageView horse_img_dark = findViewById(R.id.horse_img_dark);
        TextView goat_txt = findViewById(R.id.goat_txt);
        TextView house_txt = findViewById(R.id.house_txt);
        TextView horse_txt = findViewById(R.id.horse_txt);

        if (v == goat_img_dark) {

            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    if(checkDrag==goat_txt){
                        goat_txt.setVisibility(View.INVISIBLE);
                    }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    if(isGoatVis==false){
                        goat_txt.setVisibility(View.VISIBLE);
                    }

                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //No action
                    break;
                case DragEvent.ACTION_DROP:



                    if (checkDrag == goat_txt) {
                        goat_txt.setVisibility(View.INVISIBLE);
                        goat_img_dark.setImageResource(R.drawable.goat_colour);
                        isGoat=true;
                        isGoatVis=true;
                    }

                case DragEvent.ACTION_DRAG_ENTERED:
                    //No action


                    break;
            }
        }

        else if(v==house_img_dark){
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    if(checkDrag==house_txt) {
                        house_txt.setVisibility(View.INVISIBLE);
                        break;
                    }
                case DragEvent.ACTION_DRAG_ENDED:
                    if(isHouseVis==false){
                        house_txt.setVisibility(View.VISIBLE);
                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //No action
                    break;
                case DragEvent.ACTION_DROP:


                    if (checkDrag == house_txt) {
                        house_txt.setVisibility(View.INVISIBLE);
                        house_img_dark.setImageResource(R.drawable.house_colour);
                        isHouse=true;
                        isHouseVis = true;
                    }
                case DragEvent.ACTION_DRAG_ENTERED:
                    //No action
                    break;
            }
        }

        else if(v==horse_img_dark){
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    if(checkDrag==horse_txt) {
                        horse_txt.setVisibility(View.INVISIBLE);
                        break;
                    }
                case DragEvent.ACTION_DRAG_ENDED:
                    if(isHorseVis==false){
                        horse_txt.setVisibility(View.VISIBLE);
                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //No action
                    break;
                case DragEvent.ACTION_DROP:
                    if (checkDrag == horse_txt) {
                        horse_txt.setVisibility(View.INVISIBLE);
                        horse_img_dark.setImageResource(R.drawable.horse_colour);
                        isHorse=true;
                        isHorseVis = true;
                    }


                case DragEvent.ACTION_DRAG_ENTERED:
                    //No action


                    break;


            }
        }

        if(isGoat==true && isHorse==true && isHouse==true){
            TextView horse_later = findViewById(R.id.horse_later);
            TextView house_later = findViewById(R.id.house_later);
            TextView goat_later = findViewById(R.id.goat_later);

            horse_later.setVisibility(View.VISIBLE);
            house_later.setVisibility(View.VISIBLE);
            goat_later.setVisibility(View.VISIBLE);
        }
        return true;
    }
}