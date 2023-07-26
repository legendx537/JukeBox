package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.services.SongService;

public class ListSongCommand implements ICommand{
    private final SongService songService;

    public ListSongCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        List<Song> songList= songService.getSongs();
        System.out.println(songList);   
    }
    
}
