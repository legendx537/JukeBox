package com.example.demo.repositories;

import java.util.HashMap;
import java.util.Map;
// import java.util.Optional;
import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.PlaylistStatus;
import com.example.demo.entities.Song;

public class PlaylistRepository implements IPlaylistRepository {
    private final Map<Long, Playlist> playlistMap;
    private Long autoIncrement = 1L;

    private Playlist loadedPlaylist;
    private List<Song> loadedplaylistSong;

    public PlaylistRepository() {
        playlistMap = new HashMap<>();

    }

    @Override
    public Playlist save(Playlist playlist) {
        // TODO Auto-generated method stub
        // create a new Playlist with id

        Playlist p = new Playlist(autoIncrement, playlist.getName(), playlist.getSongs());

        // Store the new Playlist
        playlistMap.put(autoIncrement, p);

        // Increase the id for the next Playlist to be stored
        ++autoIncrement;

        // return the created playlist
        return p;
    }

    @Override
    public String addSongToPlaylist(Playlist playlist, Song song) {
        // TODO Auto-generated method stub

        // get the list of songs
        List<Song> songs = playlist.getSongs();
        // add the song to the playlist song list
        songs.add(song);
        // now we have to update the song list of the playlist
        // for this we require some type of setter
        // so we will create one
        playlist.setSongs(songs);

        return "Playlist " + playlist.getName() + " is revised with " + playlist.getSongs();
    }

    @Override
    public Playlist findByName(String name) {
        // Find an user which matches with the required name.
        return playlistMap.values().stream().filter(p -> p.getName().equals(name)).findFirst()
                .orElse(null);
    }

    @Override
    public String deleteSongFromPlaylist(Playlist playlist, Song song) {
        // TODO Auto-generated method stub

        // it is same function as adding a solution
        // just we have a delete a song with the given song
        List<Song> songs = playlist.getSongs();

        // find the song to be deleted
        for (Song x : songs) {
            if (x.equals(song))
                songs.remove(x);
        }

        // set the playlis of songs after deleting the song that is required to be deleted
        playlist.setSongs(songs);

        // return the revised playlist
        return "Playlist " + playlist.getName() + " is revised with " + playlist.getSongs();
    }

    @Override
    public String deletePlaylist(Playlist playlist) {
        // TODO Auto-generated method stub

        // get the playlist id which should be deleted
        Long deletePlaylistId = playlist.getId();

        // now remove the id from the map
        playlistMap.remove(deletePlaylistId);

        return "Playlist " + playlist.getName() + " is deleted!";
    }

    @Override
    public String loadPlaylist(Playlist playlist) {
        // TODO Auto-generated method stub

        // set the loaded playlist to the current playlist
        loadedPlaylist = playlist;
        // get the songs of loaded playlist
        loadedplaylistSong = playlist.getSongs();
        // set the current song
        playlist.setCurrentSong(loadedplaylistSong.get(0));
        // set the status of the loaded playlist
        loadedPlaylist.setPlaylistStatus(PlaylistStatus.STOPPED);
        // return the loaded playlist
        return "Playlist " + playlist.getName() + " is loaded!";
    }

    @Override
    public String playSong() {
        // TODO Auto-generated method stub

        // what we need to do in this playSong think
        // first retrieve the playlist status
        // we need to change the status of the loadedPlaylist
        PlaylistStatus playlistStatus = loadedPlaylist.getPlaylistStatus();

        // get the current song
        Song currentSong = loadedPlaylist.getCurrentSong();

        // check for the status and change correspondingly
        if (playlistStatus == PlaylistStatus.STOPPED || playlistStatus == PlaylistStatus.PAUSED
                || playlistStatus == PlaylistStatus.IDEAL) {
            loadedPlaylist.setPlaylistStatus(PlaylistStatus.PLAYING);
            return currentSong + " is playing!";
        } else if (playlistStatus == PlaylistStatus.PLAYING) {
            loadedPlaylist.setPlaylistStatus(PlaylistStatus.PAUSED);
            return currentSong + " is paused!";
        }

        return null;
    }

    @Override
    public String nextSong() {
        // TODO Auto-generated method stub

        // figure out the index of current song
        // and change the index accordingly
        Song song = loadedPlaylist.getCurrentSong();
        int index = loadedplaylistSong.indexOf(song);

        if (index == loadedplaylistSong.size() - 1) {
            loadedPlaylist.setCurrentSong(loadedplaylistSong.get(0));
            return loadedplaylistSong.get(0) + " is playing";
        }

        loadedPlaylist.setCurrentSong(loadedplaylistSong.get(index + 1));
        return loadedplaylistSong.get(index + 1) + " is playing!";
    }

    @Override
    public String previousSong() {
        // TODO Auto-generated method stub

        // same as next song
        // figure out the index of current song
        // and change the index accordingly

        Song song = loadedPlaylist.getCurrentSong();
        int index = loadedplaylistSong.indexOf(song);

        if (index == 0) {
            loadedPlaylist.setCurrentSong(loadedplaylistSong.get(loadedplaylistSong.size() - 1));
            return loadedplaylistSong.get(loadedplaylistSong.size() - 1) + " is playing!";
        }

        loadedPlaylist.setCurrentSong(loadedplaylistSong.get(index - 1));
        return loadedplaylistSong.get(index - 1) + " is playing!";
    }

    @Override
    public String stopSong() {
        // TODO Auto-generated method stub
        // change the status of the playlist to stopped
        // and return current song is stopped

        Song currentSong = loadedPlaylist.getCurrentSong();

        loadedPlaylist.setPlaylistStatus(PlaylistStatus.STOPPED);

        return currentSong + " is stopped!";
    }

}
