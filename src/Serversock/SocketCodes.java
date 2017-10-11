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
import java.net.SocketException;
import java.net.SocketTimeoutException;
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
    private Boolean flag = true;

    public SocketCodes() {
    }
    
    public void run() {//creando Servidor. Puerto 5000.
    try {
            servidor = new ServerSocket(getPort());
            //servidor.setSoTimeout(5000);
            while (flag) {            
              sock = servidor.accept();
              extrayendo();
              cerrarConeccion();
            }
        } catch (SocketException ex) {
             System.out.println("(Run): "+ex.getMessage());
            //Logger.getLogger(SocketCodes.class.getName()).log(Level.SEVERE, null, ex);
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

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }
    
    
    
    public void cerrarConeccion(){
        try {
            servidor.close();
            sock.close();
        } catch (IOException ex) {
            System.out.println("B "+ex.getMessage());
            Logger.getLogger(SocketCodes.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
    
    
    
}
