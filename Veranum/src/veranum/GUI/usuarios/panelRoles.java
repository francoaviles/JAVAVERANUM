/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.GUI.usuarios;

import helper.Formularios;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import veranum.DAO.DAORol;
import veranum.entities.ClRol;

/**
 *
 * @author Zacarias
 */
public class panelRoles extends javax.swing.JPanel {

    private boolean paraGrabar = false;
    private DefaultTableModel dt = new DefaultTableModel();
    private int id = 0;
    
    /**
     * Creates new form panelRoles
     */
    public panelRoles() {
        initComponents();
        grRoles.setEnabled(true);
        Formularios.DesactiveBotonesEliminarEditar(btEditarRoles, btEliminarRoles);
        btDesactivarEditarRoles.setVisible(false);
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

        lbNombreRol = new javax.swing.JLabel();
        txtNombreRol = new javax.swing.JTextField();
        btGrabarRol = new javax.swing.JButton();
        lbDescripcionRol = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcionRol = new javax.swing.JTextArea();
        btEliminarRoles = new javax.swing.JButton();
        btEditarRoles = new javax.swing.JButton();
        txtBuscarRoles = new javax.swing.JTextField();
        btBuscarRoles = new javax.swing.JButton();
        btBuscarTodosRoles = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        grRoles = new javax.swing.JTable();
        btDesactivarEditarRoles = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        lbNombreRol.setText("Nombre Rol:");

        txtNombreRol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreRolKeyTyped(evt);
            }
        });

        btGrabarRol.setText("Grabar");
        btGrabarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGrabarRolActionPerformed(evt);
            }
        });

        lbDescripcionRol.setText("Descripción:");

        txtDescripcionRol.setColumns(20);
        txtDescripcionRol.setRows(5);
        txtDescripcionRol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionRolKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcionRol);

        btEliminarRoles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/delete96.png"))); // NOI18N
        btEliminarRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarRolesActionPerformed(evt);
            }
        });

        btEditarRoles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/write13.png"))); // NOI18N
        btEditarRoles.setToolTipText("");
        btEditarRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarRolesActionPerformed(evt);
            }
        });

        txtBuscarRoles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarRolesKeyTyped(evt);
            }
        });

        btBuscarRoles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/magnifier12.png"))); // NOI18N
        btBuscarRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarRolesActionPerformed(evt);
            }
        });

        btBuscarTodosRoles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/refresh_16.png"))); // NOI18N
        btBuscarTodosRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarTodosRolesActionPerformed(evt);
            }
        });

        grRoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "#", "Nombre Rol", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grRoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grRolesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(grRoles);

        btDesactivarEditarRoles.setText("Salir Modo Editar");
        btDesactivarEditarRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesactivarEditarRolesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btGrabarRol, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lbNombreRol)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombreRol))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lbDescripcionRol)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(73, 73, 73)
                                .addComponent(btDesactivarEditarRoles)))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btEliminarRoles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btEditarRoles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarRoles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscarRoles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscarTodosRoles))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btBuscarRoles, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btBuscarTodosRoles)
                    .addComponent(txtBuscarRoles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btEliminarRoles)
                        .addComponent(btEditarRoles)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombreRol)
                    .addComponent(txtNombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDesactivarEditarRoles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDescripcionRol)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btGrabarRol)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btGrabarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGrabarRolActionPerformed
        if(!paraGrabar){
            if(txtNombreRol.getText().equals("") || txtDescripcionRol.getText().equals("") ){
                JOptionPane.showMessageDialog(this, "Ingrese los Datos");
            }else{
                try {
                    DAORol.sqlInsert(new ClRol(txtNombreRol.getText()
                            , txtDescripcionRol.getText())
                    );  
                    JOptionPane.showMessageDialog(this, "Agregado");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error a insertar el dato.");
                }
            Formularios.DesactiveBotonesEliminarEditar(btEditarRoles, btEliminarRoles);
            helper.Formularios.limpiar(this);
            this.leerTodos(true);
        }
        }else{
            DAORol.sqlUpdate(new ClRol(this.id, txtNombreRol.getText()
                , txtDescripcionRol.getText()));
        JOptionPane.showMessageDialog(this, "Modificado");
        Formularios.DesactiveBotonesEliminarEditar(btEditarRoles, btEliminarRoles);
        helper.Formularios.limpiar(this);
        this.leerTodos(true);
        }
    }//GEN-LAST:event_btGrabarRolActionPerformed

    private void btEliminarRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarRolesActionPerformed
        this.leerRol(Formularios.getSelectedRow(grRoles));
        if(this.id == 0){
            JOptionPane.showMessageDialog(this, "NO existe para eliminar");
        }else{
            DAORol.sqlDelete(new ClRol(this.id));
            JOptionPane.showMessageDialog(this, "Eliminado");
            helper.Formularios.limpiar(this);
            Formularios.DesactiveBotonesEliminarEditar(btEditarRoles, btEliminarRoles);
            this.leerTodos(true);
        }
    }//GEN-LAST:event_btEliminarRolesActionPerformed

    private void btEditarRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarRolesActionPerformed
        this.leerRol(Formularios.getSelectedRow(grRoles));
        this.paraGrabar = true;
        this.btnEditarMode();
    }//GEN-LAST:event_btEditarRolesActionPerformed

    private void btBuscarRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarRolesActionPerformed
        if(txtBuscarRoles.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Ingrese datos para buscar");
        }else{
            this.leerTodos(false);
        } 
    }//GEN-LAST:event_btBuscarRolesActionPerformed

    private void btBuscarTodosRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarTodosRolesActionPerformed
        this.leerTodos(true);
    }//GEN-LAST:event_btBuscarTodosRolesActionPerformed

    private void grRolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grRolesMouseClicked
        int row_dos = Formularios.getTablaSeleccionada(evt, grRoles, 2);

        if(row_dos >= 0){
            this.leerRol(Integer.parseInt(grRoles.getValueAt(row_dos, 0).toString()));
            Formularios.ActiveBotonesEliminarEditar(btEditarRoles, btEliminarRoles);
            this.paraGrabar = true;
            this.btnEditarMode();
        } else {
            Formularios.ActiveBotonesEliminarEditar(btEditarRoles, btEliminarRoles);
        }
    }//GEN-LAST:event_grRolesMouseClicked

    private void btDesactivarEditarRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesactivarEditarRolesActionPerformed
        this.paraGrabar = false;
        this.btnEditarMode();
    }//GEN-LAST:event_btDesactivarEditarRolesActionPerformed

    private void txtNombreRolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreRolKeyTyped
        if (!(txtNombreRol.getText().length() < 25)) {
            Formularios.limpiarTxt(txtNombreRol);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtNombreRolKeyTyped

    private void txtDescripcionRolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionRolKeyTyped
        if (!(txtDescripcionRol.getText().length() < 100)) {
            Formularios.limpiarTxt(txtDescripcionRol);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtDescripcionRolKeyTyped

    private void txtBuscarRolesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarRolesKeyTyped
        if (!(txtBuscarRoles.getText().length() < 15)) {
            Formularios.limpiarTxt(txtBuscarRoles);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtBuscarRolesKeyTyped

    // Method Custom
    private void leerRol(int id){
        this.id = id;
        ClRol rol = DAORol.sqlLeer(id);
        txtNombreRol.setText(rol.getNombre());
        txtDescripcionRol.setText(rol.getDescripcion());
    }
    
    private void leerTodos(boolean todos){
        ArrayList rol = new ArrayList<>();
        if(todos)
            rol = DAORol.sqlLeerTodos();
        else 
            rol = DAORol.sqlBuscarByNombre(txtNombreRol.getText());
        
        dt =  (DefaultTableModel) grRoles.getModel();        
        for (int i = dt.getRowCount() -1; i >= 0; i--){  
            dt.removeRow(i);
        }        
        for(int x=0; x < rol.size(); x++){
            ClRol xx = (ClRol)rol.get(x);
            Object[] fila = new Object[7];
            fila[0] = xx.getIdRol();
            fila[1] = xx.getNombre();
            fila[2] = xx.getDescripcion(); 
            dt.addRow(fila);
        }
    }
    
    private void btnEditarMode(){
        if(!this.paraGrabar){
            btDesactivarEditarRoles.setVisible(false);
            helper.Formularios.limpiar(this);
        } else {
            btDesactivarEditarRoles.setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarRoles;
    private javax.swing.JButton btBuscarTodosRoles;
    private javax.swing.JButton btDesactivarEditarRoles;
    private javax.swing.JButton btEditarRoles;
    private javax.swing.JButton btEliminarRoles;
    private javax.swing.JButton btGrabarRol;
    private javax.swing.JTable grRoles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbDescripcionRol;
    private javax.swing.JLabel lbNombreRol;
    private javax.swing.JTextField txtBuscarRoles;
    private javax.swing.JTextArea txtDescripcionRol;
    private javax.swing.JTextField txtNombreRol;
    // End of variables declaration//GEN-END:variables
}
