/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.GUI.habitaciones;

/**
 *
 * @author Zacarias
 */
public class MainHabitaciones extends javax.swing.JInternalFrame {

    /**
     * Creates new form MainHabitaciones
     */
    public MainHabitaciones() {
        initComponents();
        tabContenido.addTab("Habitaciones", new panelHabitaciones());
        tabContenido.addTab("Tipo Habitación", new panelTipoHab());
        tabContenido.addTab("Estado Habitación", new panelEstadoHab());
        tabContenido.addTab("Características Habitación", new panelHabCaract());
        tabContenido.addTab("Historial de precios", new panelHistorial());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabContenido = new javax.swing.JTabbedPane();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabContenido, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabContenido, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tabContenido;
    // End of variables declaration//GEN-END:variables
}
