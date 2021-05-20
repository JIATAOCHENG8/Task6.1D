package com.example.foodrescuemobileapp4;

public class Food {
    private int id, image;
    String title,description;

    public Food(int id, int image, String title, String description) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public Food(int id,int image, String title) {
        this.id = id;
        this.image = image;
        this.title = title;
    }

    public Food(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public Food(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
