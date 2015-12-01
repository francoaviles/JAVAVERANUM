/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.GUI.servicios;

import helper.Formularios;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import veranum.DAO.DAOServicios;
import veranum.entities.ClServicios;

/**
 *
 * @author Zacarias
 */
public class panelServicios extends javax.swing.JPanel {

    private boolean paraGrabar = false;
    private DefaultTableModel dt = new DefaultTableModel();
    private int id = 0;
    
    /**
     * Creates new form panelServicios
     */
    public panelServicios() {
        initComponents();
        grServicio.setEnabled(true);
        grServicio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        grServicio.getTableHeader().setReorderingAllowed(false);
        Formularios.DesactiveBotonesEliminarEditar(btEditarServicio, btEliminar);
        btDesactivarEditarServicio.setVisible(false);
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

        lbNombreServicio = new javax.swing.JLabel();
        lbPrecioServicio = new javax.swing.JLabel();
        txtNombreServicio = new javax.swing.JTextField();
        txtPrecioServicio = new javax.swing.JTextField();
        btGrabarServicio = new javax.swing.JButton();
        btBuscarServicio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grServicio = new javax.swing.JTable();
        btBuscarTodosSer = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        txtBuscarServicio = new javax.swing.JTextField();
        btEditarServicio = new javax.swing.JButton();
        btDesactivarEditarServicio = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        lbNombreServicio.setText("Nombre Servicio:");

        lbPrecioServicio.setText("Precio:");

        txtNombreServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreServicioKeyTyped(evt);
            }
        });

        txtPrecioServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioServicioKeyTyped(evt);
            }
        });

        btGrabarServicio.setText("Grabar");
        btGrabarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGrabarServicioActionPerformed(evt);
            }
        });

        btBuscarServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/magnifier12.png"))); // NOI18N
        btBuscarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarServicioActionPerformed(evt);
            }
        });

        grServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "#", "Nombre", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grServicioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(grServicio);

        btBuscarTodosSer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/refresh_16.png"))); // NOI18N
        btBuscarTodosSer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarTodosSerActionPerformed(evt);
            }
        });

        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/delete96.png"))); // NOI18N
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });

        txtBuscarServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarServicioKeyTyped(evt);
            }
        });

        btEditarServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/write13.png"))); // NOI18N
        btEditarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarServicioActionPerformed(evt);
            }
        });

        btDesactivarEditarServicio.setBackground(new java.awt.Color(255, 0, 0));
        btDesactivarEditarServicio.setText("Salir Modo Editar");
        btDesactivarEditarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesactivarEditarServicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNombreServicio)
                            .addComponent(lbPrecioServicio))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreServicio)
                            .addComponent(txtPrecioServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btDesactivarEditarServicio)
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btEditarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarServicio)
                        .addGap(18, 18, 18)
                        .addComponent(btBuscarServicio)
                        .addGap(3, 3, 3)
                        .addComponent(btBuscarTodosSer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap())
            .addComponent(btGrabarServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btBuscarServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEditarServicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscarServicio, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btBuscarTodosSer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombreServicio)
                    .addComponent(txtNombreServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDesactivarEditarServicio))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPrecioServicio)
                    .addComponent(txtPrecioServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGrabarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecioServicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioServicioKeyTyped
        Formularios.soloNumeros(evt);
        if (!(txtPrecioServicio.getText().length() < 9)) {
            Formularios.limpiarTxt(txtPrecioServicio);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtPrecioServicioKeyTyped

    private void btGrabarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGrabarServicioActionPerformed
        if(!paraGrabar){
            if(txtNombreServicio.getText().equals("") || txtPrecioServicio.getText().equals("") ){
                JOptionPane.showMessageDialog(this, "Ingrese los Datos");
            }else{
                try {
                    DAOServicios.sqlInsert(new ClServicios(txtNombreServicio.getText()
                            , Integer.parseInt(txtPrecioServicio.getText()))
                    );
                    JOptionPane.showMessageDialog(this, "Agregado");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al insertar el dato.");
                }
            Formularios.DesactiveBotonesEliminarEditar(btEditarServicio, btEliminar);
            helper.Formularios.limpiar(this);
            this.leerTodos(true);
        }
        }else{
            try {
                DAOServicios.sqlUpdate(     new ClServicios(this.id, txtNombreServicio.getText()
                        , Integer.parseInt(txtPrecioServicio.getText())));
                JOptionPane.showMessageDialog(this, "Modificado");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al modificar el dato.");
            }    
            Formularios.DesactiveBotonesEliminarEditar(btEditarServicio, btEliminar);
            helper.Formularios.limpiar(this);
            this.leerTodos(true);
            this.paraGrabar = false;
            this.btnEditarMode();
        }
    }//GEN-LAST:event_btGrabarServicioActionPerformed

    private void btBuscarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarServicioActionPerformed
        if(txtBuscarServicio.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Ingrese datos para buscar");
        }else{
            this.leerTodos(false);
        } 
    }//GEN-LAST:event_btBuscarServicioActionPerformed

    private void grServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grServicioMouseClicked
        int row_dos = Formularios.getTablaSeleccionada(evt, grServicio, 2);

        if(row_dos >= 0){
            this.leerServicio(Integer.parseInt(grServicio.getValueAt(row_dos, 0).toString()));
            Formularios.ActiveBotonesEliminarEditar(btEditarServicio, btEliminar);
            this.paraGrabar = true;
            this.btnEditarMode();
        } else {
            Formularios.ActiveBotonesEliminarEditar(btEditarServicio, btEliminar);
        }
    }//GEN-LAST:event_grServicioMouseClicked

    private void btBuscarTodosSerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarTodosSerActionPerformed
        this.leerTodos(true);
    }//GEN-LAST:event_btBuscarTodosSerActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        this.leerServicio(Formularios.getSelectedRow(grServicio));
        if(this.id == 0){
            JOptionPane.showMessageDialog(this, "NO existe para eliminar");
        }else{
            try {
                DAOServicios.sqlDelete(new ClServicios(this.id));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "No se ha podido eliminar.");
            }
            JOptionPane.showMessageDialog(this, "Eliminado");
            helper.Formularios.limpiar(this);
            Formularios.DesactiveBotonesEliminarEditar(btEditarServicio, btEliminar);
            this.leerTodos(true);
        }
    }//GEN-LAST:event_btEliminarActionPerformed

    private void btEditarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarServicioActionPerformed
        this.leerServicio(Formularios.getSelectedRow(grServicio));
        this.paraGrabar = true;
        this.btnEditarMode();
    }//GEN-LAST:event_btEditarServicioActionPerformed

    private void btDesactivarEditarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesactivarEditarServicioActionPerformed
        this.paraGrabar = false;
        this.btnEditarMode();
    }//GEN-LAST:event_btDesactivarEditarServicioActionPerformed

    private void txtNombreServicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreServicioKeyTyped
        if (!(txtNombreServicio.getText().length() < 30)) {
            Formularios.limpiarTxt(txtNombreServicio);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtNombreServicioKeyTyped

    private void txtBuscarServicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarServicioKeyTyped
        if (!(txtBuscarServicio.getText().length() < 15)) {
            Formularios.limpiarTxt(txtBuscarServicio);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtBuscarServicioKeyTyped

    // Method Custom
    private void leerServicio(int id){
        this.id = id;
        ClServicios servicio = DAOServicios.sqlLeer(id);
        txtNombreServicio.setText(servicio.getNombre());
        txtPrecioServicio.setText(String.valueOf(servicio.getPrecio()));
    }
    
    private void leerTodos(boolean todos){
        ArrayList ser = new ArrayList<>();
        if(todos)
            ser = DAOServicios.sqlLeerTodos();
        else 
            ser = DAOServicios.sqlBuscarByNombre(txtBuscarServicio.getText());
        
        dt =  (DefaultTableModel) grServicio.getModel();        
        for (int i = dt.getRowCount() -1; i >= 0; i--){  
            dt.removeRow(i);
        }        
        for(int x=0; x < ser.size(); x++){
            ClServicios xx = (ClServicios)ser.get(x);
            Object[] fila = new Object[7];
            fila[0] = xx.getIdServicio();
            fila[1] = xx.getNombre();
            fila[2] = xx.getPrecio(); 
            dt.addRow(fila);
        }
    }
    
    private void btnEditarMode(){
        if(!this.paraGrabar){
            btDesactivarEditarServicio.setVisible(false);
            helper.Formularios.limpiar(this);
        } else {
            btDesactivarEditarServicio.setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarServicio;
    private javax.swing.JButton btBuscarTodosSer;
    private javax.swing.JButton btDesactivarEditarServicio;
    private javax.swing.JButton btEditarServicio;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btGrabarServicio;
    private javax.swing.JTable grServicio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbNombreServicio;
    private javax.swing.JLabel lbPrecioServicio;
    private javax.swing.JTextField txtBuscarServicio;
    private javax.swing.JTextField txtNombreServicio;
    private javax.swing.JTextField txtPrecioServicio;
    // End of variables declaration//GEN-END:variables
}
