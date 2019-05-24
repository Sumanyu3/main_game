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

public class dragDrop_mom extends Activity implements View.OnTouchListener, GestureDetector.OnGestureListener, View.OnDragListener {

    int windowwidth;
    int windowheight;

    private LayoutParams layoutParams;
    private GestureDetector mGestureDetector;
    private static final String TAG = "MainActivity";
    boolean isChalna = false;
    boolean isPadna = false;
    boolean isKhelna = false;


    private View checkDrag;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: Working");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_drop_mom);

        windowwidth = getWindowManager().getDefaultDisplay().getWidth();
        windowheight = getWindowManager().getDefaultDisplay().getHeight();

        final TextView chalna = findViewById(R.id.chalna);
        final TextView padna = findViewById(R.id.padna);
        final TextView khelna = findViewById(R.id.khelna);
        final TextView chalna_part = findViewById(R.id.chalna_part);
        final TextView khelna_part = findViewById(R.id.khelna_part);
        final TextView padna_part = findViewById(R.id.padna_part);


        chalna_part.setOnTouchListener(this);
        khelna_part.setOnTouchListener(this);
        padna_part.setOnTouchListener(this);
        chalna.setOnDragListener(this);
        padna.setOnDragListener(this);
        khelna.setOnDragListener(this);
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
        TextView chalna_part = findViewById(R.id.chalna_part);
        TextView khelna_part = findViewById(R.id.khelna_part);
        TextView padna_part = findViewById(R.id.padna_part);
        TextView chalna = findViewById(R.id.chalna);
        TextView padna = findViewById(R.id.padna);
        TextView khelna = findViewById(R.id.khelna);


        if(v==chalna){

            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.d(TAG, "onDrag: action started");
                    if(checkDrag==chalna_part){
                        chalna_part.setVisibility(View.INVISIBLE);
                    }
                    //No action
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    Log.d(TAG, "onDrag: action ended");
                    //No action
                    if(isChalna==false) {
                        if (checkDrag == chalna_part) {
                            chalna_part.setVisibility(View.VISIBLE);
                        }
                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.d(TAG, "onDrag: action exited");
                    //No action
                    break;
                case DragEvent.ACTION_DROP:
                    Log.d(TAG, "onDrag: action drop");
                    if (checkDrag == chalna_part) {
                        chalna_part.setVisibility(View.INVISIBLE);
                        chalna.setText("चलना");
                        isChalna = true;
                    }


                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.d(TAG, "onDrag: action entered");
                    //No action


                    break;


            }
            return true;
        }

        else if(v==padna){
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    if(checkDrag==padna_part){
                        padna_part.setVisibility(View.INVISIBLE);
                    }

                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    if(isPadna==false){
                        padna_part.setVisibility(View.VISIBLE);
                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //No action
                    break;
                case DragEvent.ACTION_DROP:


                    if (checkDrag == padna_part) {
                        padna_part.setVisibility(View.INVISIBLE);
                        padna.setText("पढ़ना");
                        isPadna = true;
                    }


                case DragEvent.ACTION_DRAG_ENTERED:
                    //No action


                    break;


            }
            return true;
        }

        else if(v==khelna){
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    if(checkDrag==khelna_part){
                        khelna_part.setVisibility(View.INVISIBLE);
                    }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    if(isKhelna==false){
                        khelna_part.setVisibility(View.VISIBLE);
                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //No action
                    break;
                case DragEvent.ACTION_DROP:

                    if (checkDrag == khelna_part) {
                        khelna_part.setVisibility(View.INVISIBLE);
                        khelna.setText("खेलना");
                        isKhelna = true;
                    }


                case DragEvent.ACTION_DRAG_ENTERED:
                    //No action


                    break;


            }
            return true;
        }

        return true;


    }
}