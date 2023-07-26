package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.services.PlaylistService;

public class CreatePlaylistCommand implements ICommand {
    private final PlaylistService playlistService;

    public CreatePlaylistCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub

        // tommorow wake up and finish the work bro
        List<String> songIds = tokens.subList(2, tokens.size());
        // for(String x:songIds){
        // System.out.println(x);
        // }

        Playlist playlist = playlistService.createPlaylist(tokens.get(1), songIds);
         System.out.println(playlist);
    }

}
