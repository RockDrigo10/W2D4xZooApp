package com.example.admin.zooapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView tvAnimalName,tvAnimalDescription,tvRange;
    ImageView ivAnimal;
    Bitmap bitmap;
    private static final String TAG = "Details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tvAnimalName = (TextView) findViewById(R.id.tvAnimalName);
        tvAnimalDescription = (TextView) findViewById(R.id.tvAnimalDescription);
        tvRange = (TextView) findViewById(R.id.tvRange);
        ivAnimal = (ImageView) findViewById(R.id.ivAnimal);
        Intent intent = getIntent();
        Animals animal = (Animals) intent.getParcelableExtra("animal");
        byte[] b = animal.getPhoto();
        bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
        tvAnimalName.setText(animal.getName());
        tvAnimalDescription.setText(animal.getDescription());
        tvRange.setText(animal.getRange());
        ivAnimal.setImageBitmap(bitmap);

    }
}
