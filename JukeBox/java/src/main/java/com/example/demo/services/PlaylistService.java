package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
// import javax.management.RuntimeErrorException;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.repositories.IPlaylistRepository;
import com.example.demo.repositories.ISongRepository;

public class PlaylistService {
   private IPlaylistRepository playlistRepository;
   private ISongRepository songRepository;

   public PlaylistService(IPlaylistRepository playlistRepository, ISongRepository songRepository) {
      this.playlistRepository = playlistRepository;
      this.songRepository = songRepository;

   }

   public Playlist createPlaylist(String playlistName, List<String> songIds) {

      // check if all the songs that is asked to add to the playlist
      // exist or not
      // and convert song ids to song and add it to the songList
      // so that we can create a PlayList with that Song
      List<Song> songList = new ArrayList<>();
      for (String x : songIds) {
         Song song = songRepository.findById(x).orElseThrow(() -> new RuntimeException(
               "Song with id=" + x + "does not exist therefore playlist can not be created"));
         songList.add(song);
      }

      // just for checking
      // for (Song x : songList ) {
      // System.out.println( x );
      // }

      Playlist playlist = new Playlist(playlistName, songList);


         // return null;
      return playlistRepository.save(playlist);
   }

   public String addSongToPlaylist(String playlistName, String songId) {
      // TODO Auto-generated method stub

      if (playlistRepository.findByName(playlistName) == null)
         throw new RuntimeException(
               "Playlist with playlistName " + playlistName + " does not exist");


      Playlist playlist = playlistRepository.findByName(playlistName);

      // if( playlist == null ) {
      // throw new RuntimeException(" Playlist with playlistName=" + playlistName + " does not
      // exist");
      // }

      Song song = songRepository.findById(songId).orElseThrow(() -> new RuntimeException(
            "Song with id=" + songId + "does not exist therefore playlist can not be modified"));

      return playlistRepository.addSongToPlaylist(playlist, song);
   }


   public String deleteSongFromPlaylist(String playlistName, String songId) {
      // TODO Auto-generated method stub

      if (playlistRepository.findByName(playlistName) == null)
         throw new RuntimeException(
               "Playlist with playlistName " + playlistName + " does not exist");

      Playlist playlist = playlistRepository.findByName(playlistName);

      // if( playlist == null ) {
      // throw new RuntimeException(" Playlist with playlistName=" + playlistName + " does not
      // exist");
      // }

      Song song = songRepository.findById(songId).orElseThrow(() -> new RuntimeException(
            "Song with id=" + songId + "does not exist therefore playlist can not be modified"));

      return playlistRepository.deleteSongFromPlaylist(playlist, song);
   }

   public String deletePlaylist(String playlistName) {

      // find whether the playlist exist or not
      // then send it to the repository to be deleted

      if (playlistRepository.findByName(playlistName) == null)
         throw new RuntimeException(
               "Playlist with playlistName " + playlistName + " does not exist");

      Playlist playlist = playlistRepository.findByName(playlistName);

      // if( playlist == null )
      // throw new RuntimeException("Playlist with playlistName " + playlistName +" does not
      // exist");

      return playlistRepository.deletePlaylist(playlist);
   }


   public String loadPlaylist(String playlistName) {

      if (playlistRepository.findByName(playlistName) == null)
         throw new RuntimeException(
               "Playlist with playlistName " + playlistName + " does not exist");

      Playlist playlist = playlistRepository.findByName(playlistName);



      return playlistRepository.loadPlaylist(playlist);
   }

   public String playSong() {
      return playlistRepository.playSong();
   }

   public String nextSong() {
      return playlistRepository.nextSong();
   }

   public String previousSong() {
      return playlistRepository.previousSong();
   }

   public String stopSong() {
      return playlistRepository.stopSong();
   }

}
