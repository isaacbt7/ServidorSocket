/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serversock;

/**
 *
 * @author Chack
 */
public class ipThread extends Thread {
    private String ipex;
    public ipThread() {
    }
    
    public void setIpex(String ipex){
        this.ipex = ipex;
    }

    @Override
    public void run() {
        panelServidor.setTremote(ipex);
    }
    
    
    
}
