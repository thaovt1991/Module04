package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private int id ;
    private String nameSong ;
    private String singer ;
    private String category ;
    private MultipartFile sound ;

    public SongForm(int id,String nameSong ,String singer, String category, MultipartFile sound) {
        this.id = id;
        this.nameSong = nameSong ;
        this.singer = singer;
        this.category = category;
        this.sound = sound;
    }

    public SongForm() {
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public MultipartFile getSound() {
        return sound;
    }

    public void setSound(MultipartFile sound) {
        this.sound = sound;
    }
}
