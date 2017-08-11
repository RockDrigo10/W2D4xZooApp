package com.example.admin.zooapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

public class AnimalsActivity extends AppCompatActivity {

    private static final String TAG = "animals";
    List<Animals> animalList;
    RecyclerView rvAnimalList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    AnimalListAdapter animalListAdapter;
    DataBaseHelper dataBaseHelper;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);
        Intent intent = getIntent();
        id = intent.getStringExtra("ID");
        Log.d(TAG, "onCreate: " +id);
        rvAnimalList = (RecyclerView) findViewById(R.id.rvAnimalList);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator =  new DefaultItemAnimator();
        rvAnimalList.setLayoutManager(layoutManager);
        rvAnimalList.setItemAnimator(itemAnimator);
        ////initialize
        initAnimalsList();
        animalListAdapter = new AnimalListAdapter(animalList);
        rvAnimalList.setAdapter(animalListAdapter);
        animalListAdapter.notifyDataSetChanged();
    }
    private void initAnimalsList() {
        Intent intent = getIntent();
        dataBaseHelper = new DataBaseHelper(this);
        Log.d(TAG, "initAnimalsList: " + intent.getStringExtra("ID"));
        animalList = dataBaseHelper.getAnimals(intent.getStringExtra("ID"));


    }
}
