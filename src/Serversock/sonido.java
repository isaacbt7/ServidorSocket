/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serversock;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioDataStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Chack
 */
public class sonido extends Thread {

    public sonido() {

    }

    @Override
    public void run() {
        String path = Paths.get(System.getProperty("user.dir"),"\\src\\Serversock\\audios\\levelup.wav").toString();
        System.out.println("ruta del audio "+path);
        try {
            InputStream file = new FileInputStream(new File(path));
            AudioStream as = new AudioStream(file);
            AudioPlayer.player.start(as);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(sonido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(sonido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
