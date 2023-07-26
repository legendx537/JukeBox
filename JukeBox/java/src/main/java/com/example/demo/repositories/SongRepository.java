package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.entities.Song;

public class SongRepository implements ISongRepository{
   private final Map< Long , Song > songMap;
   private Long autoIncrrement = 1L;

   public SongRepository() {
      songMap =new HashMap<Long , Song>();
   }
    
   // for adding the song we have to create a song and then add the song
   @Override
   public Song save(Song song) {
      // TODO Auto-generated method stub
      
      // creating a new song  
      Song s=new Song( autoIncrrement , song.getName() , song.getArtist() , song.getalbumName(), song.getGenre());

      // Storing the newly created  song object in song map
      songMap.put( autoIncrrement , s);

      // Increment the value that can be used to create the next song 
      ++autoIncrrement;

      // return the creted song 
      return s;
   }

   @Override
   public List<Song> findAll() {
      // TODO Auto-generated method stub
      return songMap.values().stream().collect(Collectors.toList());
   }

   @Override
   public Optional<Song> findById(String idInput) {
      // TODO Auto-generated method stub
      Long id = Long.parseLong(idInput);
      return Optional.ofNullable(songMap.get(id));
   }

}
