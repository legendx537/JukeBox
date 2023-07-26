package com.example.demo.services;


import java.util.List;


import com.example.demo.repositories.ISongRepository;
import com.example.demo.entities.Song;


public class SongService {
  
    private final ISongRepository songRepository;

    public SongService(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }

   // add a Song 
   // for Adding a song we need to create a song
   // then add that song 
   public Song addSong(String songName,String artistName,String albumName,String genre) {  
  
     // Creting a song with the given parameters
     Song song=new Song( songName , artistName , albumName ,genre);
     
     // Storing the song with help of ISongrepository
     return songRepository.save(song);
   }

   public List<Song> getSongs() { 
      return songRepository.findAll();
   }
}
