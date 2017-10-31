/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serversock;

import java.awt.Color;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chack
 */
public class ServerVisual extends javax.swing.JFrame {

    panelServidor ps = null;
    panelConfig pc = null;
    static String puerto;

    /**
     * Creates new form ServerVisual
     */
    public ServerVisual() {
        initComponents();
        panimage();//imagen que aparece cuando se abre el programa.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpan = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemServer = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemconfig = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("servidor");

        javax.swing.GroupLayout jpanLayout = new javax.swing.GroupLayout(jpan);
        jpan.setLayout(jpanLayout);
        jpanLayout.setHorizontalGroup(
            jpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );
        jpanLayout.setVerticalGroup(
            jpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");

        itemServer.setText("Servidor");
        itemServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemServerActionPerformed(evt);
            }
        });
        jMenu1.add(itemServer);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        itemconfig.setText("Configuracion");
        itemconfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemconfigActionPerformed(evt);
            }
        });
        jMenu2.add(itemconfig);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemServerActionPerformed
        // TODO add your handling code here:
        if (pc != null) {//verificando que el objeto panelConfig este instanciado
            //obteniendo la variable puerto de panelConfig y asignandola a la variable puerto de la clase actual.
            this.puerto = pc.getPuerto();
        }
        ps = new panelServidor();//jpanel instancia
        ps.setSize(455, 300);//asignando dimensiones de la ventana
        ps.setLocation(5, 5);//asignando ubicacion
        jpan.removeAll();//limpiando panel
        jpan.add(ps);//agregan jframe al panel
        jpan.revalidate();
        jpan.repaint();
    }//GEN-LAST:event_itemServerActionPerformed

    private void itemconfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemconfigActionPerformed
        // TODO add your handling code here:
        if (ps != null) {//verificando que el objeto panelServidor este instanciado.
            ps.cerrar();//cerrando servidor (serverSockect)
        }
        pc = new panelConfig();
        pc.setSize(455, 300);
        pc.setLocation(5, 5);
        jpan.removeAll();
        jpan.add(pc);
        jpan.revalidate();
        jpan.repaint();
    }//GEN-LAST:event_itemconfigActionPerformed

    public void panimage() {
        panelUser pu = new panelUser();
        pu.setSize(455, 300);
        pu.setLocation(5, 5);
        jpan.removeAll();
        jpan.add(pu);
        jpan.revalidate();
        jpan.repaint();

    }
    
    public String getpuerto(){
        return this.puerto;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerVisual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemServer;
    private javax.swing.JMenuItem itemconfig;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jpan;
    // End of variables declaration//GEN-END:variables
}
