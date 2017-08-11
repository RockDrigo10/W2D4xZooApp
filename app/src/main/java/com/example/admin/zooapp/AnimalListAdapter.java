package com.example.admin.zooapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 8/11/2017.
 */

public class AnimalListAdapter extends RecyclerView.Adapter<AnimalListAdapter.ViewHolder> {

    private static final String TAG = "Adapter";
    List<Animals> animals =  new ArrayList<>();
    Context context;
    String idCategory;
    Bitmap bitmap;
    public AnimalListAdapter(List<Animals> animals) {
        this.animals = animals;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAnimal;
        TextView tvAnimalName;
        TextView tvAnimalDescription;
        TextView tvRange;
        public ViewHolder(View itemView) {
            super(itemView);
            ivAnimal = (ImageView) itemView.findViewById(R.id.ivAnimal);
            tvAnimalName = (TextView) itemView.findViewById(R.id.tvAnimalName);
            tvAnimalDescription = (TextView) itemView.findViewById(R.id.tvAnimalDescription);
            tvRange = (TextView) itemView.findViewById(R.id.tvRange);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animallist_item,parent, false);
        Log.d(TAG, "onCreateViewHolder: " );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Animals animal = animals.get(position);
        holder.tvAnimalName.setText(animal.getName());
        holder.tvAnimalDescription.setText(animal.getDescription());
        holder.tvRange.setText(animal.getRange());
        byte[] b = animal.getPhoto();
        bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
        holder.ivAnimal.setImageBitmap(bitmap);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),DetailsActivity.class);
                intent.putExtra("animal",animal);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+animals.size());
        return animals.size();
    }


}
