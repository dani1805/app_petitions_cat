package com.example.catapi.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Vote implements Parcelable {

    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @SerializedName("image_id")
    private String idImage;
    @SerializedName("sub_id")
    private String subId;
    private int value;

    public Vote(String idImage, String subId, int value) {
        this.idImage = idImage;
        this.subId = subId;
        this.value = value;
    }

    protected Vote(Parcel in) {

        idImage = in.readString();
        subId = in.readString();
        value = in.readInt();
    }

    public static final Creator<Vote> CREATOR = new Creator<Vote>() {
        @Override
        public Vote createFromParcel(Parcel in) {
            return new Vote(in);
        }

        @Override
        public Vote[] newArray(int size) {
            return new Vote[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(idImage);
        dest.writeString(subId);
        dest.writeInt(value);
    }
}
