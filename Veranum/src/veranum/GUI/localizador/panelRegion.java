/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.GUI.localizador;

import helper.Formularios;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import veranum.DAO.DAORegiones;
import veranum.entities.ClRegion;

/**
 *
 * @author carlosdlg
 */
public class panelRegion extends javax.swing.JPanel {
    private boolean paraGrabar = false;
    private DefaultTableModel dt = new DefaultTableModel();
    private int id = 0;
    /**
     * Creates new form panelRegion
     */
    public panelRegion() {
        initComponents();
        grRegion.setEnabled(true);
        Formularios.DesactiveBotonesEliminarEditar(btEditarRegion, btEliminar);
        btDesactivarEditarRegion.setVisible(false);
        this.leerTodosReg(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btEliminar = new javax.swing.JButton();
        btEditarRegion = new javax.swing.JButton();
        txtBuscarRegion = new javax.swing.JTextField();
        btBuscarRegion = new javax.swing.JButton();
        btBuscarTodosRegion = new javax.swing.JButton();
        txtNombreRegion = new javax.swing.JTextField();
        txtRegionOrdinal = new javax.swing.JTextField();
        btGrabarRegion = new javax.swing.JButton();
        btDesactivarEditarRegion = new javax.swing.JButton();
        lbRegionOrdinal = new javax.swing.JLabel();
        lbNombreRegion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        grRegion = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/delete96.png"))); // NOI18N
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });

        btEditarRegion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/write13.png"))); // NOI18N
        btEditarRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarRegionActionPerformed(evt);
            }
        });

        btBuscarRegion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/magnifier12.png"))); // NOI18N
        btBuscarRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarRegionActionPerformed(evt);
            }
        });

        btBuscarTodosRegion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/refresh_16.png"))); // NOI18N
        btBuscarTodosRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarTodosRegionActionPerformed(evt);
            }
        });

        txtNombreRegion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreRegionKeyTyped(evt);
            }
        });

        txtRegionOrdinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRegionOrdinalKeyTyped(evt);
            }
        });

        btGrabarRegion.setText("Grabar");
        btGrabarRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGrabarRegionActionPerformed(evt);
            }
        });

        btDesactivarEditarRegion.setBackground(new java.awt.Color(255, 0, 0));
        btDesactivarEditarRegion.setText("Salir Modo Editar");
        btDesactivarEditarRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesactivarEditarRegionActionPerformed(evt);
            }
        });

        lbRegionOrdinal.setText("Región Ordinal:");

        lbNombreRegion.setText("Nombre Región:");

        grRegion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "#", "Nombre", "Ordinal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grRegion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grRegionMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(grRegion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btGrabarRegion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNombreRegion)
                                    .addComponent(lbRegionOrdinal))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombreRegion)
                                    .addComponent(txtRegionOrdinal, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btDesactivarEditarRegion)
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btEditarRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(txtBuscarRegion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscarRegion)
                        .addGap(3, 3, 3)
                        .addComponent(btBuscarTodosRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btBuscarRegion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEditarRegion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscarRegion, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btBuscarTodosRegion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombreRegion)
                    .addComponent(txtNombreRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDesactivarEditarRegion))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRegionOrdinal)
                    .addComponent(txtRegionOrdinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btGrabarRegion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        this.leerRegion(Formularios.getSelectedRow(grRegion));
        if(this.id == 0){
            JOptionPane.showMessageDialog(this, "NO existe para eliminar");
        }else{
            DAORegiones.sqlDelete(new ClRegion(this.id));
            JOptionPane.showMessageDialog(this, "Eliminado");
            helper.Formularios.limpiar(this);
            Formularios.DesactiveBotonesEliminarEditar(btEditarRegion, btEliminar);
            this.leerTodosReg(true);
        }
    }//GEN-LAST:event_btEliminarActionPerformed

    private void btEditarRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarRegionActionPerformed
        this.leerRegion(Formularios.getSelectedRow(grRegion));
        this.paraGrabar = true;
        this.btnEditarMode();
    }//GEN-LAST:event_btEditarRegionActionPerformed

    private void btBuscarRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarRegionActionPerformed
        if(txtBuscarRegion.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Ingrese datos para buscar");
        }else{
            this.leerTodosReg(false);
        }         
    }//GEN-LAST:event_btBuscarRegionActionPerformed

    private void btBuscarTodosRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarTodosRegionActionPerformed
        this.leerTodosReg(true);
    }//GEN-LAST:event_btBuscarTodosRegionActionPerformed

    private void btGrabarRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGrabarRegionActionPerformed
        if(!paraGrabar){
            if(txtNombreRegion.getText().equals("") || txtRegionOrdinal.getText().equals("") ){
                JOptionPane.showMessageDialog(this, "Ingrese los Datos");
            }else{
                DAORegiones.sqlInsert(new ClRegion(txtNombreRegion.getText()
                    , txtRegionOrdinal.getText())
            );
            JOptionPane.showMessageDialog(this, "Agregado");
            Formularios.DesactiveBotonesEliminarEditar(btEditarRegion, btEliminar);
            helper.Formularios.limpiar(this);
            this.leerTodosReg(true);
        }
        }else{
            DAORegiones.sqlUpdate(     new ClRegion(this.id, txtNombreRegion.getText()
                , txtRegionOrdinal.getText()));
        JOptionPane.showMessageDialog(this, "Modificado");
        Formularios.DesactiveBotonesEliminarEditar(btEditarRegion, btEliminar);
        helper.Formularios.limpiar(this);
        this.leerTodosReg(true);
        }
    }//GEN-LAST:event_btGrabarRegionActionPerformed

    private void btDesactivarEditarRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesactivarEditarRegionActionPerformed
        this.paraGrabar = false;
        this.btnEditarMode();
    }//GEN-LAST:event_btDesactivarEditarRegionActionPerformed

    private void grRegionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grRegionMouseClicked
        int row_dos = Formularios.getTablaSeleccionada(evt, grRegion, 2);

        if(row_dos >= 0){
            this.leerRegion(Integer.parseInt(grRegion.getValueAt(row_dos, 0).toString()));
            Formularios.ActiveBotonesEliminarEditar(btEditarRegion, btEliminar);
            this.paraGrabar = true;
            this.btnEditarMode();
        } else {
            Formularios.ActiveBotonesEliminarEditar(btEditarRegion, btEliminar);
        }
    }//GEN-LAST:event_grRegionMouseClicked

    private void txtNombreRegionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreRegionKeyTyped
        if (!(txtNombreRegion.getText().length() < 40)) {
            Formularios.limpiarTxt(txtNombreRegion);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtNombreRegionKeyTyped

    private void txtRegionOrdinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRegionOrdinalKeyTyped
        if (!(txtNombreRegion.getText().length() < 4)) {
            Formularios.limpiarTxt(txtNombreRegion);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtRegionOrdinalKeyTyped
    
    private void leerRegion(int id){
        this.id = id;
        ClRegion regiones = DAORegiones.sqlLeer(id);
        txtNombreRegion.setText(regiones.getNombre());
        txtRegionOrdinal.setText(regiones.getOrdinal());
    }
    
    private void leerTodosReg(boolean todos){
        ArrayList ser = new ArrayList<>();
        if(todos)
            ser = DAORegiones.sqlLeerTodos();
        else 
            ser = DAORegiones.sqlBuscarByNombre(txtBuscarRegion.getText());
        
        dt =  (DefaultTableModel) grRegion.getModel();        
        for (int i = dt.getRowCount() -1; i >= 0; i--){  
            dt.removeRow(i);
        }        
        for(int x=0; x < ser.size(); x++){
            ClRegion xx = (ClRegion)ser.get(x);
            Object[] fila = new Object[7];
            fila[0] = xx.getIdRegion();
            fila[1] = xx.getNombre();
            fila[2] = xx.getOrdinal(); 
            dt.addRow(fila);
        }
    }
    
    
    private void btnEditarMode(){
        if(!this.paraGrabar){
            btDesactivarEditarRegion.setVisible(false);
            helper.Formularios.limpiar(this);
        } else {
            btDesactivarEditarRegion.setVisible(true);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarRegion;
    private javax.swing.JButton btBuscarTodosRegion;
    private javax.swing.JButton btDesactivarEditarRegion;
    private javax.swing.JButton btEditarRegion;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btGrabarRegion;
    private javax.swing.JTable grRegion;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbNombreRegion;
    private javax.swing.JLabel lbRegionOrdinal;
    private javax.swing.JTextField txtBuscarRegion;
    private javax.swing.JTextField txtNombreRegion;
    private javax.swing.JTextField txtRegionOrdinal;
    // End of variables declaration//GEN-END:variables
}
