/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playlist;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Salvador
 */
public class Album {
    private String title;
    private String artist;
    private ArrayList<Song> songs;
    //Constructor
    public Album(String title, String artist) 
    {
        this.songs = new ArrayList();
        this.title = title;
        this.artist= artist;
    }
    //Methods
    public boolean addSong(String title, double duration) //Adds a song to the list
    {
        if(findSong(title)==null) //Uses findsong to find dupes
        {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) 
    {
        int index = trackNumber - 1;
        if((index <=0 ) && (index <= this.songs.size()))
        {
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track"+trackNumber);
        return false;
    }
    public boolean addToPlayList(String title, LinkedList<Song> playList)
    {
        Song tmpSong = findSong(title);
        if(tmpSong!=null)
        {
            playList.add(tmpSong);
            return true;
        }
        System.out.println("This album does not have the track: "+title);
        return false;
    }
    
    private Song findSong(String title) //Finds a song with a designated title, then returns an instance of that song.
    {
        for(Song tmpSong : this.songs)
        {
            if(tmpSong.getTitle().equals(title))
            {
                return tmpSong;
            }
        }
        return null;
    }
}
