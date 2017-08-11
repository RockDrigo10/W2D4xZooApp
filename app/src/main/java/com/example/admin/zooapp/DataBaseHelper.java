package com.example.admin.zooapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Admin on 8/10/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Zoo";

    public static final String TABLE_ANIMAL_NAME ="Animals";
    public static final String CONTACT_ANIMAL_ID ="ID";
    public static final String CONTACT_ANIMAL_NAME ="Name";
    public static final String CONTACT_ANIMAL_DESCRIPTION ="Description";
    public static final String CONTACT_ANIMAL_CATEGORY_ID ="Category_ID";
    public static final String CONTACT_ANIMAL_RANGE ="Range";
    public static final String CONTACT_ANIMAL_PHOTO ="Photo";
    public static final String CONTACT_ANIMAL_SOUND ="Sound";

    public static final String TABLE_CATEGORY_NAME ="Category";
    public static final String CONTACT_CATEGORY_ID ="Category_ID";
    public static final String CONTACT_CATEGORY_NAME ="Name";
    public static final String CONTACT_CATEGORY_DESCRIPTION ="Description";

    private static final String TAG = "DataBaseHelper";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_A = "CREATE TABLE " + TABLE_ANIMAL_NAME + " ( " +
                CONTACT_ANIMAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CONTACT_ANIMAL_NAME + " TEXT, " +
                CONTACT_ANIMAL_DESCRIPTION + " TEXT, " +
                CONTACT_ANIMAL_CATEGORY_ID + " INTEGER, " +
                CONTACT_ANIMAL_RANGE + " TEXT, "+
                CONTACT_ANIMAL_PHOTO + " BLOB, "+
                CONTACT_ANIMAL_SOUND + " BLOB " +
                ")";
        Log.d(TAG, "onCreate: "+CREATE_TABLE_A);
        sqLiteDatabase.execSQL(CREATE_TABLE_A);
        String CREATE_TABLE_C = "CREATE TABLE " + TABLE_CATEGORY_NAME + " ( " +
                CONTACT_CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CONTACT_CATEGORY_NAME + " TEXT, " +
                CONTACT_CATEGORY_DESCRIPTION + " TEXT " +
                ")";
        Log.d(TAG, "onCreate: "+CREATE_TABLE_C);
        sqLiteDatabase.execSQL(CREATE_TABLE_C);
        ///////inserting Categories******************
        //sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CONTACT_CATEGORY_NAME, "Amphibians");
        contentValues.put(CONTACT_CATEGORY_DESCRIPTION, "Comprises the frogs, toads, newts, and salamanders.");
        Log.d(TAG, "onCreate: "  + contentValues);
        sqLiteDatabase.insert(TABLE_CATEGORY_NAME,null,contentValues);

        contentValues.put(CONTACT_CATEGORY_NAME, "Birds");
        contentValues.put(CONTACT_CATEGORY_DESCRIPTION, "Any warm-blooded vertebrate of the class Aves, having a body covered with feathers," );
        sqLiteDatabase.insert(TABLE_CATEGORY_NAME,null,contentValues);
        Log.d(TAG, "onCreate: "  + contentValues);

        contentValues.put(CONTACT_CATEGORY_NAME, "Mammals");
        contentValues.put(CONTACT_CATEGORY_DESCRIPTION, "Any vertebrate of the class Mammalia, having the body more or less covered with hair, "+
                "nourishing the young with milk from the mammary glands");
        sqLiteDatabase.insert(TABLE_CATEGORY_NAME,null,contentValues);
        Log.d(TAG, "onCreate: "  + contentValues);

        contentValues.put(CONTACT_CATEGORY_NAME, "Reptiles");
        contentValues.put(CONTACT_CATEGORY_DESCRIPTION, "Any cold-blooded vertebrate of the class Reptilia, comprising the turtles, snakes, " +
                "lizards, crocodilians, amphisbaenians, tuatara, and various extinct members including the dinosaurs.");
        sqLiteDatabase.insert(TABLE_CATEGORY_NAME,null,contentValues);
        Log.d(TAG, "onCreate: "  + contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_ANIMAL_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_CATEGORY_NAME);
        onCreate(sqLiteDatabase);
    }

    public void saveNewAnimal(Animals animals){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CONTACT_ANIMAL_NAME, animals.getName());
        contentValues.put(CONTACT_ANIMAL_DESCRIPTION, animals.getDescription());
        contentValues.put(CONTACT_ANIMAL_CATEGORY_ID, animals.getCategoryId());
        contentValues.put(CONTACT_ANIMAL_RANGE, animals.getRange());
        contentValues.put(CONTACT_ANIMAL_PHOTO, animals.getPhoto());
        contentValues.put(CONTACT_ANIMAL_SOUND, animals.getSound());

        Log.d(TAG, "saveNewAnimal: "+animals.getName());
        database.insert(TABLE_ANIMAL_NAME,null,contentValues);
    }

    public ArrayList<Categories> getCategories(){
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "";
        Cursor cursor;
        query = "SELECT * FROM " + TABLE_CATEGORY_NAME;
        Log.d(TAG, "getCategories: "+query );
        cursor = database.rawQuery(query, null);
        ArrayList<Categories> categories = new ArrayList();
        if(cursor.moveToFirst()){
            do{
                Log.d(TAG, "getCategories: Name:" + cursor.getString(1));
                    categories.add(new Categories(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
            }while(cursor.moveToNext());
        }
        else{
            Log.d(TAG, "getCategories: empty");
        }
        Log.d(TAG, "getCategories: " + categories);
        return categories;
    }

    public ArrayList<Animals> getAnimals(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "";
        Cursor cursor;
        query = "SELECT * FROM " + TABLE_ANIMAL_NAME + " WHERE " + CONTACT_ANIMAL_CATEGORY_ID + " = ?";
        //Log.d(TAG, "getAnimals: "+query + " " + id);
        String parameters[] = {id};
        cursor = database.rawQuery(query, parameters);
        ArrayList<Animals> animals = new ArrayList();
        if(cursor.moveToFirst()){
            do{
                Log.d(TAG, "getAnimals: Name:" + cursor.getString(1));
                animals.add(new Animals(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getString(4),cursor.getBlob(5),cursor.getBlob(6)));
            }while(cursor.moveToNext());
        }
        else{
            Log.d(TAG, "getAnimals: empty");
        }
        Log.d(TAG, "getAnimals: " + animals);
        return animals;

    }
}
