package com.example.sharedpreferences;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import android.os.Parcel;
import android.os.Parcelable;
public class Food implements Parcelable {
    private String name;
    private int imageResId;
    private String description;
    private double price;
    public Food (String name, int imageResId, String description, double price){
        this.name=name;
        this.imageResId=imageResId;
        this.description=description;
        this.price=price;
    }
    protected Food(Parcel in){
        name= in.readString();
        imageResId=in.readInt();
        description=in.readString();
        price=in.readDouble();

    }
    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }

        public int describeContents(){
            return 0;
        }

    };
    public String getName(){
        return name;
    }
    public int getImageResId(){
        return imageResId;
    }
    public String getDescription(){
        return description;
    }
    public double getPrice(){
        return price;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    public void writeToParcel (Parcel parcel, int i){
        parcel.writeString(name);
        parcel.writeInt(imageResId);
        parcel.writeString(description);
        parcel.writeDouble(price);
    }
}