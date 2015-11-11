/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.GUI.insumos;

import helper.Formularios;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import veranum.DAO.DAOInsumos;
import veranum.entities.ClInsumos;

/**
 *
 * @author Zacarias
 */
public class panelInsumos extends javax.swing.JPanel {

    private boolean paraGrabar = false;
    private DefaultTableModel dt = new DefaultTableModel();
    private int id = 0;
    
    /**
     * Creates new form panelInsumos
     */
    public panelInsumos() {
        initComponents();
        grInsumos.setEnabled(true);
        Formularios.DesactiveBotonesEliminarEditar(btEditarInsumos, btEditarInsumos);
        btDesactivarEditarInsumos.setVisible(false);
        this.leerTodos(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscarInsumos = new javax.swing.JTextField();
        txtDescripcionInsumos = new javax.swing.JTextField();
        txtNombreInsumos = new javax.swing.JTextField();
        btEditarInsumos = new javax.swing.JButton();
        btGrabarInsumos = new javax.swing.JButton();
        btEliminarInsumos = new javax.swing.JButton();
        lbDescripcionInsumos = new javax.swing.JLabel();
        lbNombreInsumo = new javax.swing.JLabel();
        btBuscarTodosInsumos = new javax.swing.JButton();
        btBuscarInsumos = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        grInsumos = new javax.swing.JTable();
        btDesactivarEditarInsumos = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        btEditarInsumos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/write13.png"))); // NOI18N
        btEditarInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarInsumosActionPerformed(evt);
            }
        });

        btGrabarInsumos.setText("Grabar");
        btGrabarInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGrabarInsumosActionPerformed(evt);
            }
        });

        btEliminarInsumos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/delete96.png"))); // NOI18N
        btEliminarInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarInsumosActionPerformed(evt);
            }
        });

        lbDescripcionInsumos.setText("Descripción:");

        lbNombreInsumo.setText("Nombre Insumo:");

        btBuscarTodosInsumos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/refresh_16.png"))); // NOI18N
        btBuscarTodosInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarTodosInsumosActionPerformed(evt);
            }
        });

        btBuscarInsumos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/magnifier12.png"))); // NOI18N
        btBuscarInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarInsumosActionPerformed(evt);
            }
        });

        grInsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "#", "Nombre Insumo", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grInsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grInsumosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(grInsumos);

        btDesactivarEditarInsumos.setText("Salir Modo Editar");
        btDesactivarEditarInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesactivarEditarInsumosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btGrabarInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btEliminarInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btEditarInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscarInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(btBuscarInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btBuscarTodosInsumos))
                            .addComponent(lbDescripcionInsumos))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDescripcionInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbNombreInsumo)
                                .addGap(27, 27, 27)
                                .addComponent(txtNombreInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btDesactivarEditarInsumos)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btBuscarInsumos)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btEliminarInsumos)
                        .addComponent(btEditarInsumos)
                        .addComponent(txtBuscarInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btBuscarTodosInsumos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombreInsumo)
                    .addComponent(txtNombreInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDesactivarEditarInsumos))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDescripcionInsumos)
                    .addComponent(txtDescripcionInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btGrabarInsumos)
                .addGap(210, 210, 210))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btEditarInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarInsumosActionPerformed
        this.leerInsumos(Formularios.getSelectedRow(grInsumos));
        this.paraGrabar = true;
        this.btnEditarMode();
    }//GEN-LAST:event_btEditarInsumosActionPerformed

    private void btGrabarInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGrabarInsumosActionPerformed
        if(!paraGrabar){
            if(txtNombreInsumos.getText().equals("") || txtDescripcionInsumos.getText().equals("") ){
                JOptionPane.showMessageDialog(this, "Ingrese los Datos");
            }else{
                DAOInsumos.sqlInsert(new ClInsumos(txtNombreInsumos.getText()
                    , txtDescripcionInsumos.getText())
            );
            JOptionPane.showMessageDialog(this, "Agregado");
            Formularios.DesactiveBotonesEliminarEditar(btEditarInsumos, btEliminarInsumos);
            helper.Formularios.limpiar(this);
            this.leerTodos(true);
        }
        }else{
            DAOInsumos.sqlUpdate(     new ClInsumos(this.id, txtNombreInsumos.getText()
                , txtDescripcionInsumos.getText()));
        JOptionPane.showMessageDialog(this, "Modificado");
        Formularios.DesactiveBotonesEliminarEditar(btEditarInsumos, btEliminarInsumos);
        helper.Formularios.limpiar(this);
        this.leerTodos(true);
        }
    }//GEN-LAST:event_btGrabarInsumosActionPerformed

    private void btEliminarInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarInsumosActionPerformed
        this.leerInsumos(Formularios.getSelectedRow(grInsumos));
        if(this.id == 0){
            JOptionPane.showMessageDialog(this, "NO existe para eliminar");
        }else{
            DAOInsumos.sqlDelete(new ClInsumos(this.id));
            JOptionPane.showMessageDialog(this, "Eliminado");
            helper.Formularios.limpiar(this);
            Formularios.DesactiveBotonesEliminarEditar(btEditarInsumos, btEliminarInsumos);
            this.leerTodos(true);
        }
    }//GEN-LAST:event_btEliminarInsumosActionPerformed

    private void btBuscarTodosInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarTodosInsumosActionPerformed
        this.leerTodos(true);
    }//GEN-LAST:event_btBuscarTodosInsumosActionPerformed

    private void btBuscarInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarInsumosActionPerformed
        this.leerTodos(false);
    }//GEN-LAST:event_btBuscarInsumosActionPerformed

    private void grInsumosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grInsumosMouseClicked
        int row_dos = Formularios.getTablaSeleccionada(evt, grInsumos, 2);

        if(row_dos >= 0){
            this.leerInsumos(Integer.parseInt(grInsumos.getValueAt(row_dos, 0).toString()));
            Formularios.ActiveBotonesEliminarEditar(btEditarInsumos, btEliminarInsumos);
            this.paraGrabar = true;
            this.btnEditarMode();
        } else {
            Formularios.ActiveBotonesEliminarEditar(btEditarInsumos, btEliminarInsumos);
        }
    }//GEN-LAST:event_grInsumosMouseClicked

    private void btDesactivarEditarInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesactivarEditarInsumosActionPerformed
        this.paraGrabar = false;
        this.btnEditarMode();
    }//GEN-LAST:event_btDesactivarEditarInsumosActionPerformed

    // Method Custom
    private void leerInsumos(int id){
        this.id = id;
        ClInsumos ins = DAOInsumos.sqlLeer(id);
        txtNombreInsumos.setText(ins.getNombre());
        txtDescripcionInsumos.setText(ins.getDescripcion());
    }
    
    private void leerTodos(boolean todos){
        ArrayList ins = new ArrayList<>();
        if(todos)
            ins = DAOInsumos.sqlLeerTodos();
        else 
            ins = DAOInsumos.sqlBuscarByNombre(txtBuscarInsumos.getText());
        
        dt =  (DefaultTableModel) grInsumos.getModel();        
        for (int i = dt.getRowCount() -1; i >= 0; i--){  
            dt.removeRow(i);
        }        
        for(int x=0; x < ins.size(); x++){
            ClInsumos xx = (ClInsumos)ins.get(x);
            Object[] fila = new Object[7];
            fila[0] = xx.getIdInsumo();
            fila[1] = xx.getNombre();
            fila[2] = xx.getDescripcion(); 
            dt.addRow(fila);
        }
    }
    
    private void btnEditarMode(){
        if(!this.paraGrabar){
            btDesactivarEditarInsumos.setVisible(false);
            helper.Formularios.limpiar(this);
        } else {
            btDesactivarEditarInsumos.setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarInsumos;
    private javax.swing.JButton btBuscarTodosInsumos;
    private javax.swing.JButton btDesactivarEditarInsumos;
    private javax.swing.JButton btEditarInsumos;
    private javax.swing.JButton btEliminarInsumos;
    private javax.swing.JButton btGrabarInsumos;
    private javax.swing.JTable grInsumos;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbDescripcionInsumos;
    private javax.swing.JLabel lbNombreInsumo;
    private javax.swing.JTextField txtBuscarInsumos;
    private javax.swing.JTextField txtDescripcionInsumos;
    private javax.swing.JTextField txtNombreInsumos;
    // End of variables declaration//GEN-END:variables
}