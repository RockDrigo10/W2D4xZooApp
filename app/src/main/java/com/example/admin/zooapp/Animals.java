package com.example.admin.zooapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 8/10/2017.
 */

public class Animals implements Parcelable{
    int id;
    String name;
    String description;
    int categoryId;
    String range;
    byte[] photo;
    byte[] sound;

    public Animals(int id, String name, String description, int categoryId, String range, byte[] photo, byte[] sound) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.range = range;
        this.photo = photo;
        this.sound = sound;
    }

    protected Animals(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
        categoryId = in.readInt();
        range = in.readString();
        photo = in.createByteArray();
        sound = in.createByteArray();
    }

    public static final Creator<Animals> CREATOR = new Creator<Animals>() {
        @Override
        public Animals createFromParcel(Parcel in) {
            return new Animals(in);
        }

        @Override
        public Animals[] newArray(int size) {
            return new Animals[size];
        }
    };

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public void setSound(byte[] sound) {
        this.sound = sound;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getRange() {
        return range;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public byte[] getSound() {
        return sound;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(categoryId);
        dest.writeString(range);
        dest.writeByteArray(photo);
        dest.writeByteArray(sound);
    }
}

