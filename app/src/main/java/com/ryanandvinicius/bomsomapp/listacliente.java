package com.ryanandvinicius.bomsomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ryanandvinicius.bomsomapp.fakeDatabase.ClientRepo;

public class listacliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewclient);
        Intent intent = getIntent();
        String name = intent.getStringExtra("my_name");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ListView listViewObj = (ListView) findViewById(R.id.list_client);
        listViewObj.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ClientRepo.getAllNames()));

    }
}