package com.ryanandvinicius.bomsomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ryanandvinicius.bomsomapp.fakeDatabase.ProjectRepo;

public class listaprojeto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewproject);
        ListView listViewObj = (ListView) findViewById(R.id.list_project);
        listViewObj.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ProjectRepo.getAllNames()));
    }
}