package com.example.menuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityViewCommand;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonSubmit;
    private EditText editTextInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1. lépés az adatmentés
                adatmentes();
            }
        });
    }
    private void  adatmentes(){
        SharedPreferences sharedPreferences=getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        String seged=editTextInput.getText().toString();
        if (seged.equals(null)){
            editTextInput.setError("Muszáj kitölteni");
        }else{
            editor.putString("editTextErteke",seged);
            editor.apply();
            //2. lépés atmegyunk a masik activity lapra
            //honnan->hova
            Intent intent=new Intent(MainActivity.this, Activity2.class);
            startActivity(intent);
            //backStack meggátolása
            finish();
        }
    }
    private void init(){
        buttonSubmit=findViewById(R.id.buttonSubmit);
        editTextInput=findViewById(R.id.editTextInput);
    }
}