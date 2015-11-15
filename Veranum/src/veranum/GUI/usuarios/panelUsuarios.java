/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.GUI.usuarios;

import helper.Formularios;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import veranum.DAO.DAORol;
import veranum.DAO.DAOUsuarios;
import veranum.entities.ClPasajeros;
import veranum.entities.ClRol;

/**
 *
 * @author Zacarias
 */
public class panelUsuarios extends javax.swing.JPanel {

    private boolean paraGrabar = false;
    private DefaultTableModel dt = new DefaultTableModel();
    private int id = 0;
    Date f_nac ;
    
    /**
     * Creates new form panelUsuarios
     */
    public panelUsuarios() {
        initComponents();
        this.cargarRol();
        grUsuario.setEnabled(true);
        Formularios.DesactiveBotonesEliminarEditar(btEditarUsuario, btEliminarUsuario);
        btDesactivarEditarUsuarios.setVisible(false);
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
        lbRol = new javax.swing.JLabel();
        cbRol = new javax.swing.JComboBox();
        txtRutUsuario = new javax.swing.JTextField();
        txtNombreUsuario = new javax.swing.JTextField();
        txtConstrasenaUsuario = new javax.swing.JTextField();
        txtApePaterno = new javax.swing.JTextField();
        txtApeMaterno = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtMailUsuario = new javax.swing.JTextField();
        txtDireccionUsuario = new javax.swing.JTextField();
        btGrabarUsuarios = new javax.swing.JButton();
        btEliminarUsuario = new javax.swing.JButton();
        btEditarUsuario = new javax.swing.JButton();
        txtBuscarUsuario = new javax.swing.JTextField();
        btBuscarUsuario = new javax.swing.JButton();
        btBuscarTodosUsuario = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        grUsuario = new javax.swing.JTable();
        btDesactivarEditarUsuarios = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtFechaNacUsu = new javax.swing.JFormattedTextField();

        lbRut.setText("Rut:");

        lbNombreUsuario.setText("Nombre:");

        lbContrasena.setText("Contraseña:");

        lbApePaterno.setText("Apellido Paterno:");

        lbApeMaterno.setText("Apellido Materno:");

        lbTelefono.setText("Telefono:");

        lbMail.setText("E-mail:");

        lbDireccion.setText("Direccion:");

        lbFechaNacimiento.setText("Fecha de Nacimiento:");

        lbRol.setText("Rol:");

        btGrabarUsuarios.setText("Grabar");
        btGrabarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGrabarUsuariosActionPerformed(evt);
            }
        });

        btEliminarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/delete96.png"))); // NOI18N
        btEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarUsuarioActionPerformed(evt);
            }
        });

        btEditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/write13.png"))); // NOI18N
        btEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarUsuarioActionPerformed(evt);
            }
        });

        btBuscarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/magnifier12.png"))); // NOI18N
        btBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarUsuarioActionPerformed(evt);
            }
        });

        btBuscarTodosUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/refresh_16.png"))); // NOI18N
        btBuscarTodosUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarTodosUsuarioActionPerformed(evt);
            }
        });

        grUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Rut", "Nombre", "Contraseña", "Apellido Paterno", "Apellido Materno", "Teléfono", "E-Mail", "Dirección", "Fecha Nacimiento", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grUsuarioMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(grUsuario);

        btDesactivarEditarUsuarios.setBackground(new java.awt.Color(255, 0, 0));
        btDesactivarEditarUsuarios.setText("Salir Modo Editar");
        btDesactivarEditarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesactivarEditarUsuariosActionPerformed(evt);
            }
        });

        txtFechaNacUsu.setFormatterFactory(new javax.swing.JFormattedTextField.AbstractFormatterFactory(){
            public javax.swing.JFormattedTextField.AbstractFormatter
            getFormatter(javax.swing.JFormattedTextField tf) {

                try {
                    javax.swing.text.MaskFormatter mf = new javax.swing.text.MaskFormatter("##/##/####");
                    mf.setPlaceholderCharacter('_');
                    return mf;
                } catch(java.text.ParseException pe){
                    pe.printStackTrace();
                }
                return null;
            }
        });
        txtFechaNacUsu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaNacUsuFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBuscarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBuscarTodosUsuario))
            .addComponent(jScrollPane3)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btGrabarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbRut)
                                    .addComponent(lbNombreUsuario)
                                    .addComponent(lbApePaterno)
                                    .addComponent(lbContrasena))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtRutUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtConstrasenaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtApePaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(131, 131, 131)
                                .addComponent(btDesactivarEditarUsuarios))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbApeMaterno)
                                    .addComponent(lbTelefono)
                                    .addComponent(lbMail)
                                    .addComponent(lbDireccion))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDireccionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApeMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbFechaNacimiento)
                                    .addComponent(lbRol))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaNacUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarUsuario)
                    .addComponent(btBuscarTodosUsuario)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btEliminarUsuario)
                        .addComponent(btEditarUsuario)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRut)
                    .addComponent(txtRutUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDesactivarEditarUsuarios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNombreUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbContrasena)
                    .addComponent(txtConstrasenaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDireccion)
                    .addComponent(txtDireccionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFechaNacimiento)
                    .addComponent(txtFechaNacUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRol)
                    .addComponent(cbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btGrabarUsuarios)
                .addGap(0, 36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btGrabarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGrabarUsuariosActionPerformed
        int id_rol = ((ClRol)cbRol.getSelectedItem()).getIdRol();
        if(!paraGrabar){
            if(txtRutUsuario.getText().equals("") || txtNombreUsuario.getText().equals("") ){
                JOptionPane.showMessageDialog(this, "Ingrese los Datos");
            }else{
                DAOUsuarios.sqlInsert(new ClPasajeros(txtRutUsuario.getText()
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
            Formularios.DesactiveBotonesEliminarEditar(btEditarUsuario, btEliminarUsuario);
            helper.Formularios.limpiar(this);
            this.leerTodos(true);
        }
        }else{
            DAOUsuarios.sqlUpdate(new ClPasajeros(  this.id
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
        Formularios.DesactiveBotonesEliminarEditar(btEditarUsuario, btEliminarUsuario);
        helper.Formularios.limpiar(this);
        this.leerTodos(true);
        }
    }//GEN-LAST:event_btGrabarUsuariosActionPerformed

    private void btEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarUsuarioActionPerformed
        this.leerUsuarios(Formularios.getSelectedRow(grUsuario));
        if(this.id == 0){
            JOptionPane.showMessageDialog(this, "NO existe para eliminar");
        }else{
            DAOUsuarios.sqlDelete(new ClPasajeros(this.id));
            JOptionPane.showMessageDialog(this, "Eliminado");
            helper.Formularios.limpiar(this);
            Formularios.DesactiveBotonesEliminarEditar(btEditarUsuario, btEliminarUsuario);
            this.leerTodos(true);
        }
    }//GEN-LAST:event_btEliminarUsuarioActionPerformed

    private void btBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarUsuarioActionPerformed
        this.leerTodos(false);
    }//GEN-LAST:event_btBuscarUsuarioActionPerformed

    private void btBuscarTodosUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarTodosUsuarioActionPerformed
        this.leerTodos(true);
    }//GEN-LAST:event_btBuscarTodosUsuarioActionPerformed

    private void grUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grUsuarioMouseClicked
        int row_dos = Formularios.getTablaSeleccionada(evt, grUsuario, 2);
        if(row_dos >= 0){
            this.leerUsuarios(Integer.parseInt(grUsuario.getValueAt(row_dos, 0).toString()));
            Formularios.ActiveBotonesEliminarEditar(btEditarUsuario, btEliminarUsuario);
            this.paraGrabar = true;
            this.btnEditarMode();
        } else {
            Formularios.ActiveBotonesEliminarEditar(btEditarUsuario, btEliminarUsuario);
        }
    }//GEN-LAST:event_grUsuarioMouseClicked

    private void btDesactivarEditarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesactivarEditarUsuariosActionPerformed
        this.paraGrabar = false;
        this.btnEditarMode();
    }//GEN-LAST:event_btDesactivarEditarUsuariosActionPerformed

    private void btEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarUsuarioActionPerformed
        this.leerUsuarios(Formularios.getSelectedRow(grUsuario));
        this.paraGrabar = true;
        this.btnEditarMode();
    }//GEN-LAST:event_btEditarUsuarioActionPerformed

    private void txtFechaNacUsuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaNacUsuFocusLost
        Formularios.deStringAFecha(txtFechaNacUsu.getText());
    }//GEN-LAST:event_txtFechaNacUsuFocusLost

    // Method Custom
    private void cargarRol(){
        for (Object rol : DAORol.sqlLeerTodos()) {
            cbRol.addItem(rol);
        }
    }
    
    private void leerUsuarios(int id){
        this.id = id;
        ClPasajeros usu = DAOUsuarios.sqlLeer(id);
        txtRutUsuario.setText(usu.getRut());
        txtNombreUsuario.setText(usu.getNombre());
        txtConstrasenaUsuario.setText(usu.getContrasena());
        txtApePaterno.setText(usu.getApellido_pa());
        txtApeMaterno.setText(usu.getApellido_ma());
        txtTelefono.setText(usu.getTelefono());
        txtMailUsuario.setText(usu.getEmail());
        txtDireccionUsuario.setText(usu.getDireccion());
        txtTelefono.setText(usu.getTelefono());
        txtFechaNacUsu.setValue(usu.getStringFechaNac());
        
        ClRol item;
        for (int i = 0; i < cbRol.getItemCount(); i++)
        {
            item = (ClRol)cbRol.getItemAt(i);
            if (item.getIdRol()== usu.getIdRol())
            {
                cbRol.setSelectedIndex(i);
                break;
            }
        }
    }
    
    private void leerTodos(boolean todos){
        ArrayList usu;
        if(todos)
            usu = DAOUsuarios.sqlLeerTodos();
        else 
            usu = DAOUsuarios.sqlBuscarByNombre(txtRutUsuario.getText());
        
        dt =  (DefaultTableModel) grUsuario.getModel();        
        for (int i = dt.getRowCount() -1; i >= 0; i--){  
            dt.removeRow(i);
        }        
        for(int x=0; x < usu.size(); x++){
            ClPasajeros xx = (ClPasajeros)usu.get(x);
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
            fila[9] = xx.getStringFechaNac();
            fila[10] = ((ClRol)DAORol.sqlLeer(xx.getIdRol())).getNombre();
            dt.addRow(fila);
        }
    }
    
    private void btnEditarMode(){
        if(!this.paraGrabar){
            btDesactivarEditarUsuarios.setVisible(false);
            helper.Formularios.limpiar(this);
        } else {
            btDesactivarEditarUsuarios.setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarTodosUsuario;
    private javax.swing.JButton btBuscarUsuario;
    private javax.swing.JButton btDesactivarEditarUsuarios;
    private javax.swing.JButton btEditarUsuario;
    private javax.swing.JButton btEliminarUsuario;
    private javax.swing.JButton btGrabarUsuarios;
    private javax.swing.JComboBox cbRol;
    private javax.swing.JTable grUsuario;
    private javax.swing.JScrollPane jScrollPane3;
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
    private javax.swing.JTextField txtBuscarUsuario;
    private javax.swing.JTextField txtConstrasenaUsuario;
    private javax.swing.JTextField txtDireccionUsuario;
    private javax.swing.JFormattedTextField txtFechaNacUsu;
    private javax.swing.JTextField txtMailUsuario;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtRutUsuario;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
