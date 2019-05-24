package com.example.menu;


import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class colorPicker_mom extends Activity {
    public static final String TAG = "YOUR-TAG-NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colorpicker_mom);

        final EditText simpleEditText = (EditText) findViewById(R.id.editText);
        simpleEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "onTextChanged: Before Text Changed");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: Text Changed");

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(simpleEditText.getText().toString()==""){
                    //
                }
                else if((Integer.parseInt(simpleEditText.getText().toString())<=10 && (Integer.parseInt(simpleEditText.getText().toString())>=8))){
                    Log.d(TAG, "onTextChanged: Correct Answer");
                    Toast.makeText(colorPicker_mom.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                Log.d(TAG, "onTextChanged: After Text Changed");
            }
        });
//        String editTextValue = simpleEditText.getText().toString();
//        int colourNum = Integer.parseInt(editTextValue);
//        if (colourNum >= 8 && colourNum <= 12)
//            Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();


    }

}
