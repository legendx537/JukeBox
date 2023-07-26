package com.example.demo.entities;

import java.util.List;
import java.util.LinkedList;

public class Playlist {
    // Remember one more point that use final modifier only 
    // when the u have to set the values of the variables once 
    
    private final Long id;
    private final String name;
    private List<Song> songList;
    
    private Song currentSong;
    private PlaylistStatus playlistStatus; 
    
    public Playlist(Long id,String name,List<Song> songList) {
      this.id=id;
      this.name=name;
      this.songList= songList;
      this.playlistStatus = PlaylistStatus.IDEAL;
      this.currentSong = songList.get(0);
    } 

    public Playlist(String name,List<Song> songList) {
        this( null , name, songList);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Song> getSongs() {
        return songList;
    }
    
    public void setSongs(List<Song> songs)
    {
        this.songList = songs;
    }
     
    public PlaylistStatus getPlaylistStatus() {
        return playlistStatus;
    }


    public void setPlaylistStatus(PlaylistStatus playlistStatus) {
           this.playlistStatus = playlistStatus;
    }


    public Song getCurrentSong() {
        return currentSong;
    }

    public void setCurrentSong(Song song) {
        this.currentSong = song;
    }

    @Override 
    public int hashCode() {
       final int prime =31;
       int result =1;
       result = prime * result + ( (id == null ) ? 0: id.hashCode() );
       return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
         return true;
        if( obj == null )
        return false;
        if( this.getClass() != obj.getClass() )
         return false;
         
        Playlist playlist= (Playlist) obj;
        
        if( id == null) {
            if( playlist.id != null)
             return false;
        }else if(!id.equals(playlist.id))
           return false;
         
           return true;
    }

    @Override
    public String toString() {
        return "Playlist [id=" + id + "]";
    }


}
