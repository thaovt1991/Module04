package com.codegym.model;

public class Song {
    private int id ;
    private String nameSong ;
    private String singer ;
    private String category ;
    private String sound ;

    public Song() {
    }

    public Song(int id, String nameSong, String singer, String category, String sound) {
        this.id = id;
        this.nameSong = nameSong;
        this.singer = singer;
        this.category = category;
        this.sound = sound;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
