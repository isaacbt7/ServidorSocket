/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serversock;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
        sonidoThread st;
        ipThread it;
        try {
            while (flagx) {
                System.out.println("Esperando por archivos...");
                sock = servidor.accept();
                it = new ipThread();
                it.setIpex(sock.getRemoteSocketAddress().toString().replace("/", " ").trim());
                it.run();
                st = new sonidoThread();
                st.start();//ejecuntando sonidoThread
                //ips = sock.getRemoteSocketAddress().toString().replace("/", " ").trim();//capturando la ultima ip conectada
                //System.out.println("cliente ip " + sock.getRemoteSocketAddress().toString().replace("/", " ").trim());
                extrayendo();
                cerrarSocket();
                System.out.println("A recibido un archivo");
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
            if (tags.getArtist() != null && tags.getTitle() != null) {//evitando crear un archivo nulo.
                String path = Paths.get(System.getProperty("user.home"), tags.getArtist() + " - " + tags.getTitle() + ".mp3").toString();
                FileOutputStream out = new FileOutputStream(path);
                out.write(tags.getMp3Files());
                out.close();
                in.close();
            }

        } catch (NullPointerException e) {
            System.out.println("Error -->Extrayendo -->" + e.getMessage());
            //cerrarServidor();
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

    public void cerrarSocket() {
        try {
            sock.close();
        } catch (IOException ex) {
            System.out.println("cerrarConeccion --> IOException" + ex.getMessage());
            Logger.getLogger(SocketCodes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cerrarServidor() {
        try {
            servidor.close();
            System.out.println("cerrando servidor " + servidor.isClosed());
        } catch (IOException ex) {
            Logger.getLogger(SocketCodes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
