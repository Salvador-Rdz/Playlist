/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playlist;

import java.util.*;

/**
 *
 * @author Salvador
 */
public class Playlist {
    private static ArrayList<Album> albums = new ArrayList<Album>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { //For testing purposes
        //Initializes an album object and adds songs to it
        Album album = new Album("Night in the woods OST - At the end of everything","Alec Holowka");
        album.addSong("test1",23);
        album.addSong("test2",21);
        albums.add(album); //Then adds the album to the album collection previously defined
        //Reuses the previous object and changes its properties
        album = new Album("Night in the woods OST - Hold on to anything","Alec Holowka");
        album.addSong("test3",12);
        album.addSong("test4",1);
        album.addSong("test5",5);
        albums.add(album); //Then adds it to the list
        //Uses a linkedlist to get rid of the need to use indexing.
        LinkedList<Song> playList = new LinkedList <Song>();
        //Adds some songs to the playlists, 2 of them that should display an error
        albums.get(0).addToPlayList("test1", playList);
        albums.get(0).addToPlayList("should send error",playList);
        albums.get(0).addToPlayList(1, playList);
        albums.get(0).addToPlayList(44, playList);
        play(playList); 
    }
    private static void play(LinkedList <Song> playList) //Keeps the program running in a cycle (playing songs as long as the user desires)
    {
        Scanner in = new Scanner(System.in);
        boolean quit = false; //Initializes to boolean flags used to determine the direction 
        boolean forward= true; //and if the playlist should keep playing.
        ListIterator<Song> ls = playList.listIterator(); //Initializes a listiterator, to move throughout the list
        if(playList.size() == 0) //If there are no elements, instantly closes out
        {
            System.out.println("No songs in playlist");
            return;
        }
        else
        {
            System.out.println("Now playing: "+ls.next().toString());
            printMenu();
        }
        while(!quit)
        {
            int action = in.nextInt();
            in.nextLine();
            switch(action) //Uses a switch to parse the options
            {
                case 0:
                    System.out.println("Playlist complete");
                    quit=true;
                    break;
                case 1: //Utilizes the flag to control the list iterator
                    if(!forward) 
                    {
                        if(ls.hasNext())
                        {
                            ls.next();
                        }
                        forward = true;
                    }
                    if(ls.hasNext()) //Checks for items next in the list
                    {
                        System.out.println("Now playing "+ls.next().toString()); //Prints them 
                    }
                    else
                    {
                        System.out.println("End of playlist");
                        forward = false;
                    }
                    break;
                case 2: //Utilizes the flag to control the list iterator
                    if(forward) 
                    {
                        if(ls.hasPrevious()) //Checks for previous in the list
                        {
                            ls.previous(); //Then goes back.
                        }
                        forward = false;
                    }
                    if(ls.hasPrevious())
                    {
                        System.out.println("Now playing"+ls.previous().toString());
                    }
                    else
                    {
                        System.out.println("Start of playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward)
                    {
                        if(ls.hasPrevious())
                        {
                            System.out.println("Now replaying"+ls.previous());
                            forward=false;
                        }
                        else
                        {
                            System.out.println("Start of playlist");
                        }
                    }
                    else
                    {
                        if(ls.hasNext())
                        {
                            System.out.println("Now replaying"+ls.next().toString());
                            forward = true;
                        }
                        else
                        {
                            System.out.println("End of playlist");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() > 0)
                    {
                        ls.remove();
                        if(ls.hasNext())
                        {
                            System.out.println("Now Playing"+ls.next());
                        }
                    }
                }   
            }
        }
    private static void printMenu() //Prints the menu options
    {
        System.out.println("Options: ");
        System.out.println("0. Quit");
        System.out.println("1. Forward");
        System.out.println("2. Backwards");
        System.out.println("3. Replay current song");
        System.out.println("4. List Songs");
        System.out.println("5. Print menu");
        System.out.println("6. Delete current song");
    }
    private static void printList(LinkedList<Song> playlist) //Prints all of the elements in the list
    {
        Iterator<Song> it = playlist.iterator();
        System.out.println("===================");
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
        System.out.println("===================");
    }
}
