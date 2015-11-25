/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.GUI.cliente;

import helper.Formularios;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import veranum.DAO.DAOCliente;
import veranum.DAO.DAORol;
import veranum.entities.ClPasajeros;
import veranum.entities.ClRol;

/**
 *
 * @author Zacarias
 */
public class panelCliente extends javax.swing.JPanel {

    private boolean paraGrabar = false;
    private DefaultTableModel dt = new DefaultTableModel();
    private int id = 0;
    Date f_nac ;
    
    /**
     * Creates new form panelCliente
     */
    public panelCliente() {
        initComponents();
        this.cargarRol();
        grCliente.setEnabled(true);
        Formularios.DesactiveBotonesEliminarEditar(btEditarCliente, btEliminarCliente);
        btDesactivarEditarCliente.setVisible(false);
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

        lbRut = new javax.swing.JLabel();
        lbNombreUsuario = new javax.swing.JLabel();
        lbContrasena = new javax.swing.JLabel();
        lbApePaterno = new javax.swing.JLabel();
        lbApeMaterno = new javax.swing.JLabel();
        lbTelefono = new javax.swing.JLabel();
        lbMail = new javax.swing.JLabel();
        lbDireccion = new javax.swing.JLabel();
        lbFechaNacimiento = new javax.swing.JLabel();
        txtRutUsuario = new javax.swing.JTextField();
        txtNombreUsuario = new javax.swing.JTextField();
        txtConstrasenaUsuario = new javax.swing.JTextField();
        txtApePaterno = new javax.swing.JTextField();
        txtApeMaterno = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtMailUsuario = new javax.swing.JTextField();
        txtDireccionUsuario = new javax.swing.JTextField();
        txtFechaNacUsu = new javax.swing.JTextField();
        btGrabarUsuarios = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        grCliente = new javax.swing.JTable();
        btEliminarCliente = new javax.swing.JButton();
        btEditarCliente = new javax.swing.JButton();
        txtBuscarCliente = new javax.swing.JTextField();
        btBuscarCliente = new javax.swing.JButton();
        btDesactivarEditarCliente = new javax.swing.JButton();
        btBuscarTodosCliente = new javax.swing.JButton();
        lbRol = new javax.swing.JLabel();
        cbRol = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();

        lbRut.setText("Rut:");

        lbNombreUsuario.setText("Nombre:");

        lbContrasena.setText("Contraseña:");

        lbApePaterno.setText("Apellido Paterno:");

        lbApeMaterno.setText("Apellido Materno:");

        lbTelefono.setText("Telefono:");

        lbMail.setText("E-mail:");

        lbDireccion.setText("Direccion:");

        lbFechaNacimiento.setText("Fecha de Nacimiento:");

        txtRutUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRutUsuarioKeyTyped(evt);
            }
        });

        txtNombreUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreUsuarioKeyTyped(evt);
            }
        });

        txtConstrasenaUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConstrasenaUsuarioKeyTyped(evt);
            }
        });

        txtApePaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApePaternoKeyTyped(evt);
            }
        });

        txtApeMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApeMaternoKeyTyped(evt);
            }
        });

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtMailUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMailUsuarioKeyTyped(evt);
            }
        });

        txtDireccionUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionUsuarioKeyTyped(evt);
            }
        });

        txtFechaNacUsu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaNacUsuFocusLost(evt);
            }
        });

        btGrabarUsuarios.setText("Grabar");
        btGrabarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGrabarUsuariosActionPerformed(evt);
            }
        });

        grCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Rut", "Nombre", "Contrasena", "Apellido Paterno", "Apellido materno", "Teleéono", "E-mail", "Direccion", "Fecha Nacimiento", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(grCliente);
        if (grCliente.getColumnModel().getColumnCount() > 0) {
            grCliente.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        btEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/delete96.png"))); // NOI18N
        btEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarClienteActionPerformed(evt);
            }
        });

        btEditarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/write13.png"))); // NOI18N
        btEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarClienteActionPerformed(evt);
            }
        });

        txtBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarClienteKeyTyped(evt);
            }
        });

        btBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/magnifier12.png"))); // NOI18N
        btBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarClienteActionPerformed(evt);
            }
        });

        btDesactivarEditarCliente.setBackground(new java.awt.Color(255, 0, 0));
        btDesactivarEditarCliente.setText("Salir del Modo editar");
        btDesactivarEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesactivarEditarClienteActionPerformed(evt);
            }
        });

        btBuscarTodosCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/refresh_16.png"))); // NOI18N
        btBuscarTodosCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarTodosClienteActionPerformed(evt);
            }
        });

        lbRol.setText("Rol:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btBuscarTodosCliente))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbRut)
                                    .addComponent(lbNombreUsuario)
                                    .addComponent(lbContrasena))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtConstrasenaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtRutUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btDesactivarEditarCliente))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbDireccion)
                                        .addGap(74, 74, 74)
                                        .addComponent(txtDireccionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbMail)
                                        .addGap(89, 89, 89)
                                        .addComponent(txtMailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbTelefono)
                                            .addComponent(lbApeMaterno)
                                            .addComponent(lbApePaterno))
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtApePaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtApeMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btGrabarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbFechaNacimiento)
                                            .addComponent(lbRol))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFechaNacUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btBuscarCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btBuscarTodosCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btEliminarCliente)
                        .addComponent(btEditarCliente)
                        .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRut)
                    .addComponent(txtRutUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDesactivarEditarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombreUsuario)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbContrasena)
                    .addComponent(txtConstrasenaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbApePaterno)
                    .addComponent(txtApePaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbApeMaterno)
                    .addComponent(txtApeMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMail)
                    .addComponent(txtMailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDireccion)
                    .addComponent(txtDireccionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFechaNacimiento)
                    .addComponent(txtFechaNacUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRol)
                    .addComponent(cbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(btGrabarUsuarios)
                .addGap(251, 251, 251))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarClienteActionPerformed
        this.leerCliente(Formularios.getSelectedRow(grCliente));
        if(this.id == 0){
            JOptionPane.showMessageDialog(this, "NO existe para eliminar");
        }else{
            DAOCliente.sqlDelete(new ClPasajeros(this.id));
            JOptionPane.showMessageDialog(this, "Eliminado");
            helper.Formularios.limpiar(this);
            Formularios.DesactiveBotonesEliminarEditar(btEditarCliente, btEliminarCliente);
            this.leerTodos(true);
        }
    }//GEN-LAST:event_btEliminarClienteActionPerformed

    private void btEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarClienteActionPerformed
        this.leerCliente(Formularios.getSelectedRow(grCliente));
        this.paraGrabar = true;
        this.btnEditarMode();
    }//GEN-LAST:event_btEditarClienteActionPerformed

    private void btBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarClienteActionPerformed
        this.leerTodos(false);
    }//GEN-LAST:event_btBuscarClienteActionPerformed

    private void btBuscarTodosClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarTodosClienteActionPerformed
        this.leerTodos(true);
    }//GEN-LAST:event_btBuscarTodosClienteActionPerformed

    private void btDesactivarEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesactivarEditarClienteActionPerformed
        this.paraGrabar = false;
        this.btnEditarMode();
    }//GEN-LAST:event_btDesactivarEditarClienteActionPerformed

    private void btGrabarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGrabarUsuariosActionPerformed
        int id_rol = ((ClRol)cbRol.getSelectedItem()).getIdRol();
        if(!paraGrabar){
            if(txtRutUsuario.getText().equals("") 
               || txtNombreUsuario.getText().equals("")
               || txtConstrasenaUsuario.getText().equals("")
               || txtApePaterno.getText().equals("")
               || txtApeMaterno.getText().equals("")
               || txtTelefono.getText().equals("")
               || txtMailUsuario.getText().equals("")     
               || txtDireccionUsuario.getText().equals("")
               || txtFechaNacUsu.getText().equals("")
               ){
                JOptionPane.showMessageDialog(this, "Ingrese los Datos");
            }else{
                try {
                    DAOCliente.sqlInsert(new ClPasajeros(txtRutUsuario.getText()
                            , txtNombreUsuario.getText()
                            , txtConstrasenaUsuario.getText()
                            , txtApePaterno.getText()
                            , txtApeMaterno.getText()
                            , txtTelefono.getText()
                            , txtMailUsuario.getText()
                            , txtDireccionUsuario.getText()
                            , Formularios.deStringAFecha(txtFechaNacUsu.getText())
                            , id_rol)
                    );
                    JOptionPane.showMessageDialog(this, "Agregado");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al insertar el dato.");
                }
            
            Formularios.DesactiveBotonesEliminarEditar(btEditarCliente, btEliminarCliente);
            helper.Formularios.limpiar(this);
            this.leerTodos(true);
        }
        }else{
            try {
                DAOCliente.sqlUpdate(new ClPasajeros(  this.id
                        , txtRutUsuario.getText()
                        , txtNombreUsuario.getText()
                        , txtConstrasenaUsuario.getText()
                        , txtApePaterno.getText()
                        , txtApeMaterno.getText()
                        , txtTelefono.getText()
                        , txtMailUsuario.getText()
                        , txtDireccionUsuario.getText()
                        , Formularios.deStringAFecha(txtFechaNacUsu.getText())
                        , id_rol
                ));
                JOptionPane.showMessageDialog(this, "Modificado");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al modificar el dato.");
            }
        
        Formularios.DesactiveBotonesEliminarEditar(btEditarCliente, btEliminarCliente);
        helper.Formularios.limpiar(this);
        this.leerTodos(true);
        }
    }//GEN-LAST:event_btGrabarUsuariosActionPerformed

    private void grClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grClienteMouseClicked
        int row_dos = Formularios.getTablaSeleccionada(evt, grCliente, 2);
        if(row_dos >= 0){
            this.leerCliente(Integer.parseInt(grCliente.getValueAt(row_dos, 0).toString()));
            Formularios.ActiveBotonesEliminarEditar(btEditarCliente, btEliminarCliente);
            this.paraGrabar = true;
            this.btnEditarMode();
        } else {
            Formularios.ActiveBotonesEliminarEditar(btEditarCliente, btEliminarCliente);
        }
    }//GEN-LAST:event_grClienteMouseClicked

    private void txtRutUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRutUsuarioKeyTyped
        Formularios.validarRut(evt);
        if (!(txtRutUsuario.getText().length() < 9)) {
            Formularios.limpiarTxt(txtRutUsuario);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        } 
    }//GEN-LAST:event_txtRutUsuarioKeyTyped

    private void txtNombreUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreUsuarioKeyTyped
        if (!(txtNombreUsuario.getText().length() < 15)) {
            Formularios.limpiarTxt(txtNombreUsuario);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtNombreUsuarioKeyTyped

    private void txtConstrasenaUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConstrasenaUsuarioKeyTyped
        if (!(txtConstrasenaUsuario.getText().length() < 30)) {
            Formularios.limpiarTxt(txtConstrasenaUsuario);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtConstrasenaUsuarioKeyTyped

    private void txtApePaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApePaternoKeyTyped
        if (!(txtApePaterno.getText().length() < 20)) {
            Formularios.limpiarTxt(txtApePaterno);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtApePaternoKeyTyped

    private void txtApeMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApeMaternoKeyTyped
        if (!(txtApeMaterno.getText().length() < 20)) {
            Formularios.limpiarTxt(txtApeMaterno);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtApeMaternoKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        if (!(txtTelefono.getText().length() < 20)) {
            Formularios.limpiarTxt(txtTelefono);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtMailUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailUsuarioKeyTyped
        if (!(txtMailUsuario.getText().length() < 20)) {
            Formularios.limpiarTxt(txtMailUsuario);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtMailUsuarioKeyTyped

    private void txtDireccionUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionUsuarioKeyTyped
        if (!(txtDireccionUsuario.getText().length() < 50)) {
            Formularios.limpiarTxt(txtDireccionUsuario);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtDireccionUsuarioKeyTyped

    private void txtBuscarClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarClienteKeyTyped
        if (!(txtBuscarCliente.getText().length() < 15)) {
            Formularios.limpiarTxt(txtBuscarCliente);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtBuscarClienteKeyTyped

    private void txtFechaNacUsuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaNacUsuFocusLost
        Formularios.deStringAFecha(txtFechaNacUsu.getText());
    }//GEN-LAST:event_txtFechaNacUsuFocusLost

    // Method Custom
    private void cargarRol(){
        for (Object rol : DAORol.sqlLeerTodos()) {
            cbRol.addItem(rol);
        }
    }
    
    private void leerCliente(int id){
        this.id = id;
        ClPasajeros cli = DAOCliente.sqlLeer(id);
        txtRutUsuario.setText(cli.getRut());
        txtNombreUsuario.setText(cli.getNombre());
        txtConstrasenaUsuario.setText(cli.getContrasena());
        txtApePaterno.setText(cli.getApellido_pa());
        txtApeMaterno.setText(cli.getApellido_ma());
        txtTelefono.setText(cli.getTelefono());
        txtMailUsuario.setText(cli.getEmail());
        txtDireccionUsuario.setText(cli.getDireccion());
        txtTelefono.setText(cli.getTelefono());
        txtFechaNacUsu.setText(cli.getFechaNacimiento().toString());
    }
    
    private void leerTodos(boolean todos){
        ArrayList cli = new ArrayList<>();
        if(todos)
            cli = DAOCliente.sqlLeerTodos();
        else 
            cli = DAOCliente.sqlBuscarByNombre(txtBuscarCliente.getText());
        
        dt =  (DefaultTableModel) grCliente.getModel();        
        for (int i = dt.getRowCount() -1; i >= 0; i--){  
            dt.removeRow(i);
        }        
        for(int x=0; x < cli.size(); x++){
            ClPasajeros xx = (ClPasajeros)cli.get(x);
            Object[] fila = new Object[11];
            fila[0] = xx.getIdPasajero();
            fila[1] = xx.getRut();
            fila[2] = xx.getNombre();
            fila[3] = xx.getContrasena();
            fila[4] = xx.getApellido_pa();
            fila[5] = xx.getApellido_ma();
            fila[6] = xx.getTelefono();
            fila[7] = xx.getEmail();
            fila[8] = xx.getDireccion();
            fila[9] = xx.getFechaNacimiento();
            fila[10] = ((ClRol)DAORol.sqlLeer(xx.getIdRol())).getNombre();
            dt.addRow(fila);
        }
    }
    
    private void btnEditarMode(){
        if(!this.paraGrabar){
            btDesactivarEditarCliente.setVisible(false);
            helper.Formularios.limpiar(this);
        } else {
            btDesactivarEditarCliente.setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarCliente;
    private javax.swing.JButton btBuscarTodosCliente;
    private javax.swing.JButton btDesactivarEditarCliente;
    private javax.swing.JButton btEditarCliente;
    private javax.swing.JButton btEliminarCliente;
    private javax.swing.JButton btGrabarUsuarios;
    private javax.swing.JComboBox cbRol;
    private javax.swing.JTable grCliente;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbApeMaterno;
    private javax.swing.JLabel lbApePaterno;
    private javax.swing.JLabel lbContrasena;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbFechaNacimiento;
    private javax.swing.JLabel lbMail;
    private javax.swing.JLabel lbNombreUsuario;
    private javax.swing.JLabel lbRol;
    private javax.swing.JLabel lbRut;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JTextField txtApeMaterno;
    private javax.swing.JTextField txtApePaterno;
    private javax.swing.JTextField txtBuscarCliente;
    private javax.swing.JTextField txtConstrasenaUsuario;
    private javax.swing.JTextField txtDireccionUsuario;
    private javax.swing.JTextField txtFechaNacUsu;
    private javax.swing.JTextField txtMailUsuario;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtRutUsuario;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
