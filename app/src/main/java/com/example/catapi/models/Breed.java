package com.example.catapi.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Breed implements Parcelable {

        private int adaptability;
        private int affectionLevel;
        private String altNames;
        private String cfaUrl;
        private int childFriendly;
        private String countryCode;
        private String countryCodes;
        private String description;
        private int dogFriendly;
        private int energyLevel;
        private int experimental;
        private int grooming;
        private int hairless;
        private int healthIssues;
        private int hypoallergenic;
        private String id;
        private Image image;
        private int indoor;
        private int intelligence;
        private int lap;
        @SerializedName("life_span")
        private String lifeSpan;
        private String name;
        private int natural;
        private String origin;
        private int rare;
        @SerializedName("reference_image_id")
        private String referenceImageId;
        private int rex;
        private int sheddingLevel;
        private int shortLegs;
        private int socialNeeds;
        private int strangerFriendly;
        private int suppressedTail;
        private String temperament;
        private String vcahospitalsUrl;
        private String vetstreetUrl;
        private int vocalisation;
        private Weight weight;
        private String wikipediaUrl;


    protected Breed(Parcel in) {
        adaptability = in.readInt();
        affectionLevel = in.readInt();
        altNames = in.readString();
        cfaUrl = in.readString();
        childFriendly = in.readInt();
        countryCode = in.readString();
        countryCodes = in.readString();
        description = in.readString();
        dogFriendly = in.readInt();
        energyLevel = in.readInt();
        experimental = in.readInt();
        grooming = in.readInt();
        hairless = in.readInt();
        healthIssues = in.readInt();
        hypoallergenic = in.readInt();
        id = in.readString();
        image = in.readParcelable(Image.class.getClassLoader());
        indoor = in.readInt();
        intelligence = in.readInt();
        lap = in.readInt();
        lifeSpan = in.readString();
        name = in.readString();
        natural = in.readInt();
        origin = in.readString();
        rare = in.readInt();
        referenceImageId = in.readString();
        rex = in.readInt();
        sheddingLevel = in.readInt();
        shortLegs = in.readInt();
        socialNeeds = in.readInt();
        strangerFriendly = in.readInt();
        suppressedTail = in.readInt();
        temperament = in.readString();
        vcahospitalsUrl = in.readString();
        vetstreetUrl = in.readString();
        vocalisation = in.readInt();
        weight = in.readParcelable(Weight.class.getClassLoader());
        wikipediaUrl = in.readString();
    }

    public static final Creator<Breed> CREATOR = new Creator<Breed>() {
        @Override
        public Breed createFromParcel(Parcel in) {
            return new Breed(in);
        }

        @Override
        public Breed[] newArray(int size) {
            return new Breed[size];
        }
    };


    public int getAdaptability() {
            return adaptability;
        }

        public void setAdaptability(int adaptability) {
            this.adaptability = adaptability;
        }

        public int getAffectionLevel() {
            return affectionLevel;
        }

        public void setAffectionLevel(int affectionLevel) {
            this.affectionLevel = affectionLevel;
        }

        public String getAltNames() {
            return altNames;
        }

        public void setAltNames(String altNames) {
            this.altNames = altNames;
        }

        public String getCfaUrl() {
            return cfaUrl;
        }

        public void setCfaUrl(String cfaUrl) {
            this.cfaUrl = cfaUrl;
        }

        public int getChildFriendly() {
            return childFriendly;
        }

        public void setChildFriendly(int childFriendly) {
            this.childFriendly = childFriendly;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getCountryCodes() {
            return countryCodes;
        }

        public void setCountryCodes(String countryCodes) {
            this.countryCodes = countryCodes;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getDogFriendly() {
            return dogFriendly;
        }

        public void setDogFriendly(int dogFriendly) {
            this.dogFriendly = dogFriendly;
        }

        public int getEnergyLevel() {
            return energyLevel;
        }

        public void setEnergyLevel(int energyLevel) {
            this.energyLevel = energyLevel;
        }

        public int getExperimental() {
            return experimental;
        }

        public void setExperimental(int experimental) {
            this.experimental = experimental;
        }

        public int getGrooming() {
            return grooming;
        }

        public void setGrooming(int grooming) {
            this.grooming = grooming;
        }

        public int getHairless() {
            return hairless;
        }

        public void setHairless(int hairless) {
            this.hairless = hairless;
        }

        public int getHealthIssues() {
            return healthIssues;
        }

        public void setHealthIssues(int healthIssues) {
            this.healthIssues = healthIssues;
        }

        public int getHypoallergenic() {
            return hypoallergenic;
        }

        public void setHypoallergenic(int hypoallergenic) {
            this.hypoallergenic = hypoallergenic;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Image getImage() {
            return image;
        }

        public void setImage(Image image) {
            this.image = image;
        }

        public int getIndoor() {
            return indoor;
        }

        public void setIndoor(int indoor) {
            this.indoor = indoor;
        }

        public int getIntelligence() {
            return intelligence;
        }

        public void setIntelligence(int intelligence) {
            this.intelligence = intelligence;
        }

        public int getLap() {
            return lap;
        }

        public void setLap(int lap) {
            this.lap = lap;
        }

        public String getLifeSpan() {
            return lifeSpan;
        }

        public void setLifeSpan(String lifeSpan) {
            this.lifeSpan = lifeSpan;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNatural() {
            return natural;
        }

        public void setNatural(int natural) {
            this.natural = natural;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public int getRare() {
            return rare;
        }

        public void setRare(int rare) {
            this.rare = rare;
        }

        public String getReferenceImageId() {
            return referenceImageId;
        }

        public void setReferenceImageId(String referenceImageId) {
            this.referenceImageId = referenceImageId;
        }

        public int getRex() {
            return rex;
        }

        public void setRex(int rex) {
            this.rex = rex;
        }

        public int getSheddingLevel() {
            return sheddingLevel;
        }

        public void setSheddingLevel(int sheddingLevel) {
            this.sheddingLevel = sheddingLevel;
        }

        public int getShortLegs() {
            return shortLegs;
        }

        public void setShortLegs(int shortLegs) {
            this.shortLegs = shortLegs;
        }

        public int getSocialNeeds() {
            return socialNeeds;
        }

        public void setSocialNeeds(int socialNeeds) {
            this.socialNeeds = socialNeeds;
        }

        public int getStrangerFriendly() {
            return strangerFriendly;
        }

        public void setStrangerFriendly(int strangerFriendly) {
            this.strangerFriendly = strangerFriendly;
        }

        public int getSuppressedTail() {
            return suppressedTail;
        }

        public void setSuppressedTail(int suppressedTail) {
            this.suppressedTail = suppressedTail;
        }

        public String getTemperament() {
            return temperament;
        }

        public void setTemperament(String temperament) {
            this.temperament = temperament;
        }

        public String getVcahospitalsUrl() {
            return vcahospitalsUrl;
        }

        public void setVcahospitalsUrl(String vcahospitalsUrl) {
            this.vcahospitalsUrl = vcahospitalsUrl;
        }

        public String getVetstreetUrl() {
            return vetstreetUrl;
        }

        public void setVetstreetUrl(String vetstreetUrl) {
            this.vetstreetUrl = vetstreetUrl;
        }

        public int getVocalisation() {
            return vocalisation;
        }

        public void setVocalisation(int vocalisation) {
            this.vocalisation = vocalisation;
        }

        public Weight getWeight() {
            return weight;
        }

        public void setWeight(Weight weight) {
            this.weight = weight;
        }

        public String getWikipediaUrl() {
            return wikipediaUrl;
        }

        public void setWikipediaUrl(String wikipediaUrl) {
            this.wikipediaUrl = wikipediaUrl;
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(adaptability);
        dest.writeInt(affectionLevel);
        dest.writeString(altNames);
        dest.writeString(cfaUrl);
        dest.writeInt(childFriendly);
        dest.writeString(countryCode);
        dest.writeString(countryCodes);
        dest.writeString(description);
        dest.writeInt(dogFriendly);
        dest.writeInt(energyLevel);
        dest.writeInt(experimental);
        dest.writeInt(grooming);
        dest.writeInt(hairless);
        dest.writeInt(healthIssues);
        dest.writeInt(hypoallergenic);
        dest.writeString(id);
        dest.writeParcelable(image,flags);
        dest.writeInt(indoor);
        dest.writeInt(intelligence);
        dest.writeInt(lap);
        dest.writeString(lifeSpan);
        dest.writeString(name);
        dest.writeInt(natural);
        dest.writeString(origin);
        dest.writeInt(rare);
        dest.writeString(referenceImageId);
        dest.writeInt(rex);
        dest.writeInt(sheddingLevel);
        dest.writeInt(shortLegs);
        dest.writeInt(socialNeeds);
        dest.writeInt(strangerFriendly);
        dest.writeInt(suppressedTail);
        dest.writeString(temperament);
        dest.writeString(vcahospitalsUrl);
        dest.writeString(vetstreetUrl);
        dest.writeInt(vocalisation);
        dest.writeParcelable(weight,flags);
        dest.writeString(wikipediaUrl);
    }
}






