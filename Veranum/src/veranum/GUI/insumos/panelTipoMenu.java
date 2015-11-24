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
import veranum.DAO.DAOTipoMenu;
import veranum.entities.ClTipoMenu;

/**
 *
 * @author Zacarias
 */
public class panelTipoMenu extends javax.swing.JPanel {

    private boolean paraGrabar = false;
    private DefaultTableModel dt = new DefaultTableModel();
    private int id = 0;
    
    /**
     * Creates new form panelTipoMenu
     */
    public panelTipoMenu() {
        initComponents();
        grDatos.setEnabled(true);
        Formularios.DesactiveBotonesEliminarEditar(btEditar, btEliminar);
        btDesactivarEditar.setVisible(false);
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

        panelTipoMenu = new javax.swing.JPanel();
        btEliminar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        btBuscarTodos = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        grDatos = new javax.swing.JTable();
        lbNombreTipoMenu = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        txtNombreTipoMenu = new javax.swing.JTextField();
        btGrabar = new javax.swing.JButton();
        btDesactivarEditar = new javax.swing.JButton();

        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/delete96.png"))); // NOI18N
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/write13.png"))); // NOI18N
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/magnifier12.png"))); // NOI18N
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        btBuscarTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/refresh_16.png"))); // NOI18N
        btBuscarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarTodosActionPerformed(evt);
            }
        });

        grDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "#", "Nombre Tipo Menú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grDatosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(grDatos);

        lbNombreTipoMenu.setText("Nombre Tipo Menú:");

        txtNombreTipoMenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreTipoMenuKeyTyped(evt);
            }
        });

        btGrabar.setText("Grabar");
        btGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGrabarActionPerformed(evt);
            }
        });

        btDesactivarEditar.setBackground(new java.awt.Color(255, 0, 0));
        btDesactivarEditar.setText("Salir Modo Editar");
        btDesactivarEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesactivarEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTipoMenuLayout = new javax.swing.GroupLayout(panelTipoMenu);
        panelTipoMenu.setLayout(panelTipoMenuLayout);
        panelTipoMenuLayout.setHorizontalGroup(
            panelTipoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTipoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTipoMenuLayout.createSequentialGroup()
                        .addGroup(panelTipoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator7)
                            .addGroup(panelTipoMenuLayout.createSequentialGroup()
                                .addComponent(btEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btEditar)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(btBuscarTodos)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(panelTipoMenuLayout.createSequentialGroup()
                        .addGroup(panelTipoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btGrabar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTipoMenuLayout.createSequentialGroup()
                                .addComponent(lbNombreTipoMenu)
                                .addGap(26, 26, 26)
                                .addComponent(txtNombreTipoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(btDesactivarEditar)
                        .addGap(80, 80, 80))))
            .addComponent(jScrollPane4)
        );
        panelTipoMenuLayout.setVerticalGroup(
            panelTipoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTipoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btEliminar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelTipoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btEditar)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btBuscar)
                        .addComponent(btBuscarTodos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelTipoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreTipoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNombreTipoMenu)
                    .addComponent(btDesactivarEditar))
                .addGap(37, 37, 37)
                .addComponent(btGrabar)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelTipoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelTipoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        this.leer(Formularios.getSelectedRow(grDatos));
        if(this.id == 0){
            JOptionPane.showMessageDialog(this, "NO existe para eliminar");
        }else{
            DAOTipoMenu.sqlDelete(new ClTipoMenu(this.id));
            JOptionPane.showMessageDialog(this, "Eliminado");
            helper.Formularios.limpiar(this);
            Formularios.DesactiveBotonesEliminarEditar(btEditar, btEliminar);
            this.leerTodos(true);
        }
    }//GEN-LAST:event_btEliminarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        this.leer(Formularios.getSelectedRow(grDatos));
        this.paraGrabar = true;
        this.btnEditarMode();
    }//GEN-LAST:event_btEditarActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        if(txtBuscar.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Ingrese datos para buscar");
        }else{
            this.leerTodos(false);
        } 
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btBuscarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarTodosActionPerformed
        this.leerTodos(true);
    }//GEN-LAST:event_btBuscarTodosActionPerformed

    private void btDesactivarEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesactivarEditarActionPerformed
        this.paraGrabar = false;
        this.btnEditarMode();
    }//GEN-LAST:event_btDesactivarEditarActionPerformed

    private void btGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGrabarActionPerformed
        if(!paraGrabar){
            if(txtNombreTipoMenu.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Ingrese los Datos");
            }else{
                DAOTipoMenu.sqlInsert(new ClTipoMenu( txtNombreTipoMenu.getText()
                                            ));
            JOptionPane.showMessageDialog(this, "Agregado");
            Formularios.DesactiveBotonesEliminarEditar(btEditar, btEliminar);
            helper.Formularios.limpiar(this);
            this.leerTodos(true);
        }
        }else{
                DAOTipoMenu.sqlUpdate(new ClTipoMenu( this.id
                                                ,txtNombreTipoMenu.getText()
                                            ));
        JOptionPane.showMessageDialog(this, "Modificado");
        Formularios.DesactiveBotonesEliminarEditar(btEditar, btEliminar);
        helper.Formularios.limpiar(this);
        this.leerTodos(true);
        }
    }//GEN-LAST:event_btGrabarActionPerformed

    private void grDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grDatosMouseClicked
        int row_dos = Formularios.getTablaSeleccionada(evt, grDatos, 2);
        if(row_dos >= 0){
            this.leer(Integer.parseInt(grDatos.getValueAt(row_dos, 0).toString()));
            Formularios.ActiveBotonesEliminarEditar(btEditar, btEliminar);
            this.paraGrabar = true;
            this.btnEditarMode();
        } else {
            Formularios.ActiveBotonesEliminarEditar(btEditar, btEliminar);
        }
    }//GEN-LAST:event_grDatosMouseClicked

    private void txtNombreTipoMenuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreTipoMenuKeyTyped
        if (!(txtNombreTipoMenu.getText().length() < 30)) {
            Formularios.limpiarTxt(txtNombreTipoMenu);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtNombreTipoMenuKeyTyped

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        if (!(txtBuscar.getText().length() < 15)) {
            Formularios.limpiarTxt(txtBuscar);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    // Method Custom    
    private void leer(int id){
        this.id = id;
        ClTipoMenu dato = DAOTipoMenu.sqlLeer(id);
        txtNombreTipoMenu.setText(dato.getNombre());
    }
    
    private void leerTodos(boolean todos){
        ArrayList dato;
        if(todos)
            dato = DAOTipoMenu.sqlLeerTodos();
        else 
            dato = DAOTipoMenu.sqlBuscarByNombre(txtNombreTipoMenu.getText());
        
        dt =  (DefaultTableModel) grDatos.getModel();        
        for (int i = dt.getRowCount() -1; i >= 0; i--){  
            dt.removeRow(i);
        }        
        for(int x=0; x < dato.size(); x++){
            ClTipoMenu xx = (ClTipoMenu)dato.get(x);
            Object[] fila = new Object[7];
            fila[0] = xx.getIdTipoMenu();
            fila[1] = xx.getNombre();
            dt.addRow(fila);
        }
    }
    
    private void btnEditarMode(){
        if(!this.paraGrabar){
            btDesactivarEditar.setVisible(false);
            helper.Formularios.limpiar(this);
        } else {
            btDesactivarEditar.setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btBuscarTodos;
    private javax.swing.JButton btDesactivarEditar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btGrabar;
    private javax.swing.JTable grDatos;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lbNombreTipoMenu;
    private javax.swing.JPanel panelTipoMenu;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtNombreTipoMenu;
    // End of variables declaration//GEN-END:variables
}
