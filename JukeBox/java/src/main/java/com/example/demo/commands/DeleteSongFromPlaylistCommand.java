package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlaylistService;

public class DeleteSongFromPlaylistCommand implements ICommand{
    private final PlaylistService playlistService;

    public DeleteSongFromPlaylistCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }


    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        String output = playlistService.deleteSongFromPlaylist(tokens.get(1), tokens.get(2) );
        System.out.println(output);
    }
    
}
