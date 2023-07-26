package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlaylistService;

public class LoadPlaylistCommand implements ICommand{
     
    private final PlaylistService playlistService;

    public LoadPlaylistCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        String result = playlistService.loadPlaylist( tokens.get(1) );
        System.out.println(result);    
    } 
    
}
