package com.example.pokemon;

public class Pokemon {
    private String id;
    private String name;
    private String power;
    private String imageUrl;

    public Pokemon(String id, String name, String power, String imageUrl) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
