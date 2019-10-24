package com.juaracoding.backnext;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityC extends AppCompatActivity {
    public static int REQUEST_CODE = 555;
    public static int RESULT_CODE = 666;
    int flagPass =0;
    Button btnPrev, btnNext;
    TextView txtInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        txtInfo = findViewById(R.id.txtInfo);
        txtInfo.setText("Activity C");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flagPass == 3 ){
                    Intent intent = new Intent(ActivityC.this,ActivityD.class);
                    intent.putExtra("data",flagPass+=1);
                    startActivityForResult(intent,REQUEST_CODE);
                }else {
                    Intent intent = new Intent(ActivityC.this, ActivityD.class);
                    intent.putExtra("data",flagPass);
                startActivityForResult(intent, REQUEST_CODE);
            }
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finish();
            }
        });

    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == ActivityD.RESULT_CODE){
            flagPass = data.getIntExtra("data",0);
        }
    }
}