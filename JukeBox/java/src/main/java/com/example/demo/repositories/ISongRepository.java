package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Song;


public interface ISongRepository {
    Song save(Song song);
    List<Song> findAll();
    Optional<Song> findById(String id);
}
