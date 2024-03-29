/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.GUI.insumos;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Zacarias
 */
public class MainInsumos extends javax.swing.JInternalFrame {

    /**
     * Creates new form MainInsumos
     */
    public MainInsumos() {
        initComponents();
        tabContenidoInsumos.addTab("Insumos", new panelInsumos());
        tabContenidoInsumos.addTab("Medida", new panelMedidas());
        tabContenidoInsumos.addTab("Tipo Menú", new panelTipoMenu());
        tabContenidoInsumos.addTab("Menú", new panelMenu());        
        tabContenidoInsumos.addTab("Menú Insumos", new panelMenuInsumos());
        tabContenidoInsumos.addTab("Proveedores", new panelProvee());
        tabContenidoInsumos.addChangeListener(new ChangeListener() { 
            @Override
            public void stateChanged(ChangeEvent e) {
                switch (tabContenidoInsumos.getSelectedIndex()) {
                    case 0:
                        tabContenidoInsumos.setComponentAt(0, new panelInsumos());
                        break;
                    case 1:
                        tabContenidoInsumos.setComponentAt(1, new panelMedidas());
                        break;
                    case 2:
                        tabContenidoInsumos.setComponentAt(2, new panelTipoMenu());
                        break;
                    case 3:
                        tabContenidoInsumos.setComponentAt(3, new panelMenu());
                        break;
                    case 4:
                        tabContenidoInsumos.setComponentAt(4, new panelMenuInsumos());
                        break;
                    case 5:
                        tabContenidoInsumos.setComponentAt(5, new panelProvee());
                        break;
                    default:
                        break;
                }
            }
        });
    }
    
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabContenidoInsumos = new javax.swing.JTabbedPane();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabContenidoInsumos)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabContenidoInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tabContenidoInsumos;
    // End of variables declaration//GEN-END:variables
}
