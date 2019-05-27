package com.example.menu;


import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class colorPicker_mom extends Activity {
    public static final String TAG = "YOUR-TAG-NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colorpicker_mom);
        Button submit = findViewById(R.id.submit);

        final EditText simpleEditText = (EditText) findViewById(R.id.editText);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curr_txt = simpleEditText.getText().toString();
                if(curr_txt.equals("8")||curr_txt.equals("9")||curr_txt.equals("10")){
                    Log.d(TAG, "onClick: Correct Answer");
                    Toast.makeText(colorPicker_mom.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                else{
                    Log.d(TAG, "onClick: Incorrect");
                    Toast.makeText(colorPicker_mom.this, "Try Again", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        String editTextValue = simpleEditText.getText().toString();
//        int colourNum = Integer.parseInt(editTextValue);
//        if (colourNum >= 8 && colourNum <= 12)
//            Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();


    }

}
