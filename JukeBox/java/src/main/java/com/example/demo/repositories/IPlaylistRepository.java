package com.example.demo.repositories;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;

public interface IPlaylistRepository {
    Playlist save(Playlist playlist); 
    public String  loadPlaylist(Playlist playlist);
    public String addSongToPlaylist(Playlist playlist,Song song); 
    public Playlist findByName(String name);
    public String deleteSongFromPlaylist(Playlist playlist,Song song);
    public String deletePlaylist(Playlist playlist);
    public String playSong();
    public String nextSong();
    public String previousSong();
    public String stopSong();

}
