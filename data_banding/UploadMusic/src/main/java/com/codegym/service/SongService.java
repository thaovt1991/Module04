package com.codegym.service;

import com.codegym.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongService implements ISongService{
    private static List<Song> songs ;

    static {
        songs = new ArrayList<>() ;
        songs.add(new Song(1, "Thay Long", "DIMZ","Nhac Tre", "Thay-Long-DIMZ-TVk-NH4T.mp3"));
        songs.add(new Song(2, "Tieang Goi Noi Anh", "Chi Dan","Nhac Tre","Tieng-Goi-Noi-Anh-Chi-Dan.mp3"));
    }
    @Override
    public List<Song> findAll() {
        return songs;
    }

    @Override
    public void save(Song song) {
        songs.add(song);
    }

    @Override
    public Song findById(int id) {
        return songs.get(id);
    }

    @Override
    public void update(int id, Song song) {
        for (Song p : songs) {
            if (p.getId() == id) {
                p = song;
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getId() == id) {
                songs.remove(i);
                break;
            }
        }
    }

}
