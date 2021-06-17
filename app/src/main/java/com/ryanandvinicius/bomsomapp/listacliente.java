package com.ryanandvinicius.bomsomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class listacliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewclient);
        Intent intent = getIntent();
        String name = intent.getStringExtra("my_name");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}