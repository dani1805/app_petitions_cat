package com.example.catapi.models;

import com.google.gson.annotations.SerializedName;

public class ResponseVote {
    @SerializedName("country_code")
    private String countryCode;
    @SerializedName("created_at")
    private String createdAt;
    private int id;
    @SerializedName("image_id")
    private String imageId;
    @SerializedName("sub_id")
    private String subId;
    private int value;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
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
}
