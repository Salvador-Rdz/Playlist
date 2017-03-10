/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playlist;

/**
 *
 * @author Salvador
 */
public class Song {
    private String title;
    private double duration;
    //Constructor
    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }
    //Getter
    public String getTitle() {
        return title;
    }
    //Methods
    @Override
    public String toString()
    {
        return this.title+": "+this.duration;
    }
}
