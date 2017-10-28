/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serversock;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Chack
 */
public class Mp3Object implements Serializable{
    private String Artist;
    private String Title;
    private String Anime;
    private byte[] Mp3Files = null;

    /**
     * @return the Artist
     */
    public String getArtist() {
        return Artist;
    }

    /**
     * @param Artist the Artist to set
     */
    public void setArtist(String Artist) {
        this.Artist = Artist;
    }

    /**
     * @return the Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * @param Title the Title to set
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     * @return the Anime
     */
    public String getAnime() {
        return Anime;
    }

    /**
     * @param Anime the Anime to set
     */
    public void setAnime(String Anime) {
        this.Anime = Anime;
    }

    /**
     * @return the Mp3Files
     */
    public byte[] getMp3Files() {
        return Mp3Files;
    }

    /**
     * @param Mp3Files the Mp3Files to set
     */
    public void setMp3Files(byte[] Mp3Files) {
        this.Mp3Files = Mp3Files;
    }

}