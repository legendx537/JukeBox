package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlaylistService;

public class AddSongToPlaylistCommand implements ICommand{
    private final PlaylistService playlistService;

    public AddSongToPlaylistCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }
    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        String output=playlistService.addSongToPlaylist(tokens.get(1), tokens.get(2));
        System.out.println( output );
    }
    
}
