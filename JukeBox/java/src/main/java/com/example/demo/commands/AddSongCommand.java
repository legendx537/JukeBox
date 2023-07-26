package com.example.demo.commands;

import java.util.List;

import com.example.demo.entities.Song;
import com.example.demo.services.SongService;

public class AddSongCommand implements ICommand{
     private final SongService songService;
    
    public AddSongCommand(SongService songService) { 
        this.songService = songService;
    }
    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        Song song=songService.addSong(tokens.get(1), tokens.get(2), tokens.get(3) , tokens.get(4) );
        System.out.println(song);
    }
    
}
