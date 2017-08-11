package com.example.admin.zooapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    private static final String TAG = "Category";
    ListView list;
    DataBaseHelper dataBaseHelper;
    String[] item;
    String[] ids;
    List<Categories> categories;
    Categories category;
    ArrayAdapter<String> adapter;
    Button buttonAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        String prueba;
        dataBaseHelper = new DataBaseHelper(this);
        Intent intent = getIntent();
        prueba =  intent.getStringExtra("person");
        Log.d(TAG, "onCreate: " + prueba);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        list = (ListView) findViewById(R.id.list);
        //initFoodList();
        ArrayList<Categories> categories = dataBaseHelper.getCategories();
        item = new String[categories.size()];
        ids = new String[categories.size()];
        for (int i = 0; i < categories.size(); i++) {
            item[i] = "Category: " + categories.get(i).getName() + "\n" +
                    "Description: " +categories.get(i).getDescription() + "\n";
            ids[i] = String.valueOf(categories.get(i).getId());
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
        buttonAdd.setOnClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getBaseContext(),ids[position], Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, AnimalsActivity.class);
        intent.putExtra("ID",ids[position]);
        startActivity(intent);
        Log.d(TAG, "onItemClick: " + ids[position]);
    }
    @Override
    public void onClick(View v) {
        DummyAnimals dummy = new DummyAnimals();
        ArrayList<Animals> animals = dummy.dataAnimals(this);

        for(int i=0;i<animals.size();i++){
            dataBaseHelper.saveNewAnimal(animals.get(i));
        }
        Toast.makeText(this, " Elements created, there's no need to create them again...", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "saveAnimals: "+ animals);

    }
}
