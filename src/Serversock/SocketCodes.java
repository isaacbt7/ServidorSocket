/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serversock;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chack
 */
public class SocketCodes {
    private InputStream in = null;
    private ObjectInputStream obis = null;
    private Mp3Object tags;
    private int port = 0;
    private ServerSocket servidor = null;
    private Socket sock=null;
    
    public void CrearServer(){
        try {
            servidor = new ServerSocket(5000);
        while (true) {            
          sock = servidor.accept();
        }
        } catch (IOException ex) {
            Logger.getLogger(SocketCodes.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
