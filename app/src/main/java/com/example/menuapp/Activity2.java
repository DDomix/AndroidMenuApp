package com.example.menuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    private TextView textViewResult;
    private Button buttonResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        init();
        String seged=getSharedPreferenceData();
        textViewResult.setText(seged);
        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Activity2.this, "Viszlát", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Activity2.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private String getSharedPreferenceData() {
        SharedPreferences sharedPreferences=getSharedPreferences("Data", Context.MODE_PRIVATE);
        String result=sharedPreferences.getString("editTextErteke","nincs ilyen érték");
        return result;
    }

    private void init(){
        textViewResult=findViewById(R.id.textViewResult);
        buttonResult=findViewById(R.id.buttonBack);
    }
}