package com.example.catapi.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

public class ListBreeds implements Parcelable {

    protected ListBreeds(Parcel in) {
    }

    public static final Creator<ListBreeds> CREATOR = new Creator<ListBreeds>() {
        @Override
        public ListBreeds createFromParcel(Parcel in) {
            return new ListBreeds(in);
        }

        @Override
        public ListBreeds[] newArray(int size) {
            return new ListBreeds[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public class Example {

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
        private String lifeSpan;
        private String name;
        private int natural;
        private String origin;
        private int rare;
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
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
}





