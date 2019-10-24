package com.juaracoding.backnext;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityE extends AppCompatActivity {
    public static int REQUEST_CODE = 333;
    public static int RESULT_CODE = 444;
    Button btnPrev, btnNext;
    TextView txtInfo;

    int flagPass =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flagPass = getIntent().getIntExtra("data",0);

        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        txtInfo = findViewById(R.id.txtInfo);
        txtInfo.setText("Activity E");
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flagPass == 5){
                    finish();
                }else {
                    Intent intent = new Intent();
                    intent.putExtra("data", flagPass+=1);
                    setResult(RESULT_CODE, intent);
                    finish();
                }
            }
        });

    }
}