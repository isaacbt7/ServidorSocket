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
public class SocketCodes extends Thread {
    private InputStream in = null;
    private ObjectInputStream obis = null;
    private Mp3Object tags;
    private int port = 0;
    private ServerSocket servidor = null;
    private Socket sock=null;

    public SocketCodes() {
    }
    
    public void run() {//creando Servidor. Puerto 5000.
    try {
            servidor = new ServerSocket(5000);
            while (true) {            
              sock = servidor.accept();
              extrayendo();
            }
        } catch (IOException ex) {
            Logger.getLogger(SocketCodes.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    public void extrayendo(){
            tags = new Mp3Object();
        try {
            in = sock.getInputStream();
            obis = new ObjectInputStream(in);
            tags = (Mp3Object) obis.readObject();
            System.out.println("datos: "+ tags.getArtist()+" "+tags.getTitle());
        } catch (IOException ex) {
            Logger.getLogger(SocketCodes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SocketCodes.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
    }
    
}
