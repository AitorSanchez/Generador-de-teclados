/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teclado_prop;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Aitor
 */
public class Calculo extends javax.swing.JFrame {

    /**
     * Creates new form Calculo
     */
    private Presentacion p;
    private boolean en_proces;
    
   
    
    public Calculo(Presentacion p) {
        initComponents();
        this.p = p;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing (WindowEvent  e) {
                cerrar_ventana();
            
            }
        });
        
    }
    
    public void cerrar_ventana() {
        this.p.visualizar();
        System.out.print("Holaosdjfos");
        if(en_proces){
            System.out.print("Hola");
            this.p.finalitzar_calcul();
            getToolkit().beep();
            en_proces = false;//-------------------
            JOptionPane.showMessageDialog(null,"Se ha detenido el cálculo","Cancel",JOptionPane.ERROR_MESSAGE);
        }

    }
    public void visualizar() {
        this.setVisible(true);
        this.p.esconder();
        en_proces = true;
    }
    
    public void esconder() {
        this.setVisible(false);
        this.p.visualizar();
    }
    
   
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Calculando solución");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
