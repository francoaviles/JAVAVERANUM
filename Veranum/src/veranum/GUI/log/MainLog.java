/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.GUI.log;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import veranum.DAO.Log;
import veranum.entities.ClLog;

/**
 *
 * @author carlosdlg
 */
public class MainLog extends javax.swing.JInternalFrame {
    private DefaultTableModel dt = new DefaultTableModel();
    /**
     * Creates new form MainLog
     */
    public MainLog() {
        initComponents();
        ArrayList ser = Log.all();
        dt =  (DefaultTableModel) grDatos.getModel();        
        for (int i = dt.getRowCount() -1; i >= 0; i--){  
            dt.removeRow(i);
        }        
        for(int x=0; x < ser.size(); x++){
            ClLog xx = (ClLog)ser.get(x);
            Object[] fila = new Object[7];
            fila[0] = xx.getIdLog();
            fila[1] = xx.getNombre();
            fila[2] = xx.getFecha();
            fila[3] = xx.getTipo();
            fila[4] = xx.getConsulta();
            fila[5] = xx.getRol();
            dt.addRow(fila);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        grDatos = new javax.swing.JTable();

        grDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Usuario", "Fecha", "Proceso", "Data", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(grDatos);
        if (grDatos.getColumnModel().getColumnCount() > 0) {
            grDatos.getColumnModel().getColumn(0).setMaxWidth(50);
            grDatos.getColumnModel().getColumn(1).setMaxWidth(100);
            grDatos.getColumnModel().getColumn(2).setMaxWidth(300);
            grDatos.getColumnModel().getColumn(3).setMaxWidth(100);
            grDatos.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable grDatos;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
