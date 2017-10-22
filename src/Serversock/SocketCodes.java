/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serversock;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
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
    private static int port;
    private ServerSocket servidor = null;
    private Socket sock = null;
    static boolean flagx = true;

    public SocketCodes(int port) {
        this.port = port;
        try {
            servidor = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(SocketCodes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {//creando Servidor. Puerto 5000.
        try {
            while (flagx) {
                System.out.println("Esperando por archivos...");
                sock = servidor.accept();
                System.out.println("cliente ip " + sock.getRemoteSocketAddress().toString().replace("/", " ").trim());
                extrayendo();
                cerrarConeccion();
            }
        } catch (SocketException ex) {//este error se produce por que envio un objeto vacio para poder detener el servidor.
            System.out.println("run --> Socket Exception " + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(SocketCodes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void extrayendo() {
        tags = new Mp3Object();
        try {
            in = sock.getInputStream();
            obis = new ObjectInputStream(in);
            tags = (Mp3Object) obis.readObject();
            InputStream in = new FileInputStream(tags.getMp3Files());
            FileOutputStream out;
                out = new FileOutputStream(System.getProperty("user.home")+"\\" + tags.getArtist() + " - " + tags.getTitle() + ".mp3");
                byte[] buffer = new byte[256];//(int) tags.getMp3Files().length()
                int contar = 0;
                while ((contar = in.read(buffer)) > 0) {
                    out.write(buffer, 0, contar);
                }
                out.close();
                in.close();
        } catch (NullPointerException e) {
            System.out.println("Error -->Extrayendo -->" + e.getMessage());
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
    public static void setPort(int port) {
        SocketCodes.port = port;
    }

    public void cerrarConeccion() {
        try {
            sock.close();
        } catch (IOException ex) {
            System.out.println("cerrarConeccion --> IOException" + ex.getMessage());
            Logger.getLogger(SocketCodes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
