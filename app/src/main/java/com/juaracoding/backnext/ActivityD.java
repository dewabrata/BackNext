package com.juaracoding.backnext;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityD extends AppCompatActivity {

    public static int REQUEST_CODE = 111;
    public static int RESULT_CODE = 222;
    int flagPass =0;


    Button btnPrev, btnNext;
    TextView txtInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flagPass = getIntent().getIntExtra("data",0);
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        txtInfo = findViewById(R.id.txtInfo);
        txtInfo.setText("Activity D");

        if(flagPass ==4 ){
            Intent intent = new Intent(ActivityD.this,ActivityE.class);
            intent.putExtra("data",flagPass+=1);
            startActivityForResult(intent,REQUEST_CODE);
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityD.this,ActivityE.class);
                intent.putExtra("data",flagPass+=1);
                startActivityForResult(intent,REQUEST_CODE);
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
        if(requestCode == ActivityD.REQUEST_CODE && resultCode == ActivityE.RESULT_CODE){
            flagPass = data.getIntExtra("data",0);

            Intent intent = new Intent();

            if(flagPass == 2){
                intent.putExtra("data",flagPass+=1);
                setResult(RESULT_CODE,intent);
                finish();
            }

        }
    }
}