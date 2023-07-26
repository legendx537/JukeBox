package com.example.demo.entities;



public class Song {
    private final Long id;
    private final String name;
    private final String genre;
    private final String albumName;
    private final String artist;

    public Song(Long id,String name,String artist,String albumName,String genre){
        this.id=id;
        this.name=name;
        this.genre=genre;
        this.albumName =albumName;
        this.artist=artist;   
    }

    public Song(String name,String artist,String albumName,String genre){
      this(null, name, artist ,albumName, genre);
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getGenre(){
        return genre;
    }

    public String  getArtist(){
        return artist;
    }

    public String  getalbumName(){
        return albumName;
    }

    @Override
    public int hashCode(){
        final int prime=31;
        int result=1;
        result = prime *result +((id == null)? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
         return true;
        if( obj == null)
         return false;
        if(this.getClass() != obj.getClass() )
         return false;
       
        Song song= (Song) obj;
    
         if( id == null ) {
            if( song.id != null)
             return false;
         }else if( !id.equals(song.id) )
             return false;
         return true;     
    }


    @Override 
    public String toString() {
        return "Song [id=" + id + "]";
    }
}
