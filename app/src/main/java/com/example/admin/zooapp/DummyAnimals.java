package com.example.admin.zooapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Admin on 8/10/2017.
 */

public class DummyAnimals {
    int immages;
    int did[] = {
            R.drawable.frog,
            R.drawable.salamander,
            R.drawable.hellbender,
            R.drawable.eagle,
            R.drawable.cardenal,
            R.drawable.falcon,
            R.drawable.vulture,
            R.drawable.lion,
            R.drawable.tiger,
            R.drawable.elephant,
            R.drawable.dolphin,
            R.drawable.giraffe,
            R.drawable.crocodile,
            R.drawable.anaconda,
            R.drawable.dinosaur,
            R.drawable.lizzard,
            R.drawable.turtle

    };

    int ridanimal[] = {
            R.raw.frog,
            R.raw.hellbender,
            R.raw.eagle,
            R.raw.cardenal,
            R.raw.falcon,
            R.raw.vulture,
            R.raw.lion,
            R.raw.tiger,
            R.raw.elephant,
            R.raw.dolphin,
            R.raw.crocodile,
            R.raw.anaconda,
            R.raw.dinosaur,
            R.raw.turtle
    };
    public DummyAnimals(){

    }
    public ArrayList<Animals> dataAnimals (Context context){
        ArrayList<Animals> animals = new ArrayList<>();

        animals.add(new Animals(-1,"Vulture","A vulture is a scavenging bird of pre.",2,"Strays may wander north of breeding range at any season, especially late summer.",drawable_to_byte_array(context,did[6]),song_to_byte_array(context,ridanimal[5])));
        animals.add(new Animals(-1,"Turtle","Ninja Turtules.",4,"New York City.",drawable_to_byte_array(context,did[16]),song_to_byte_array(context,ridanimal[13])));
        animals.add(new Animals(-1,"Lizzard","There is a lizzard",4,"Texas.",drawable_to_byte_array(context,did[15]),song_to_byte_array(context,ridanimal[5])));
        animals.add(new Animals(-1,"Dinosaur","They are gone, they were awosome",4,"Everywhere long time ago",drawable_to_byte_array(context,did[14]),song_to_byte_array(context,ridanimal[12])));
        animals.add(new Animals(-1,"Anaconda","The largest snake ever",4,"Brazil.",drawable_to_byte_array(context,did[13]),song_to_byte_array(context,ridanimal[11])));
        animals.add(new Animals(-1,"Crocodile","Kind of dinosaurs",4,"Swamp",drawable_to_byte_array(context,did[12]),song_to_byte_array(context,ridanimal[10])));
        animals.add(new Animals(-1,"Giraffe","Very long neck",3,"En la selva",drawable_to_byte_array(context,did[11]),song_to_byte_array(context,ridanimal[5])));
        animals.add(new Animals(-1,"Dolphin","The most inteligent animals, I think",3,"In the sea, oceans etc.",drawable_to_byte_array(context,did[10]),song_to_byte_array(context,ridanimal[9])));
        animals.add(new Animals(-1,"Elephant","The biggest mammal",3,"In the sabana closed to the lions",drawable_to_byte_array(context,did[9]),song_to_byte_array(context,ridanimal[8])));
        animals.add(new Animals(-1,"Tiger","The biggest feline in the jungle",3,"The book jungle",drawable_to_byte_array(context,did[8]),song_to_byte_array(context,ridanimal[7])));
        animals.add(new Animals(-1,"Lion","The biggest feline ever",3,"In Africa",drawable_to_byte_array(context,did[7]),song_to_byte_array(context,ridanimal[6])));
        animals.add(new Animals(-1,"Cardinal","Red bird",2,"Arizona",drawable_to_byte_array(context,did[4]),song_to_byte_array(context,ridanimal[3])));
        animals.add(new Animals(-1,"Falcon","Kind of an eagle but smaller",2,"Atlanta or Georgia",drawable_to_byte_array(context,did[5]),song_to_byte_array(context,ridanimal[4])));
        animals.add(new Animals(-1,"Eagle","Beautiful bird",2,"America",drawable_to_byte_array(context,did[3]),song_to_byte_array(context,ridanimal[2])));
        animals.add(new Animals(-1,"Frog","Small and yellow",1,"Strays may wander north of breeding range at any season, especially late summer.",drawable_to_byte_array(context,did[0]),song_to_byte_array(context,ridanimal[0])));
        animals.add(new Animals(-1,"Salamander","Amphibian Lizzard",1,"I dont know",drawable_to_byte_array(context,did[1]),song_to_byte_array(context,ridanimal[1])));
        animals.add(new Animals(-1,"Eastern Hellbender","No description",1,"I dont know",drawable_to_byte_array(context,did[2]),song_to_byte_array(context,ridanimal[2])));



        return animals;
    }

    public byte[] drawable_to_byte_array(Context context, int did){
        Drawable d = context.getResources().getDrawable(did);
        Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] bitmapdata = stream.toByteArray();
        return bitmapdata;
    }
    public byte[] song_to_byte_array(Context context, int sid){
        InputStream inStream = context.getResources().openRawResource(sid);
        byte[] music = null;
        try {
            music = new byte[inStream.available()];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return music;
    }
}
