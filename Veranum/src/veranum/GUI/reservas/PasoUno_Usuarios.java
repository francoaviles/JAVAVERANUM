/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.GUI.reservas;

import helper.Formularios;
import veranum.DAO.DAOUsuarios;
import veranum.entities.ClPasajeros;

/**
 *
 * @author carlosdlg
 */
public class PasoUno_Usuarios extends javax.swing.JPanel {
    private ClPasajeros user = null;
    /**
     * Creates new form PasoUno_Usuarios
     */
    public PasoUno_Usuarios() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtApePaterno = new javax.swing.JTextField();
        lbRut = new javax.swing.JLabel();
        lbNombreUsuario = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        txtConstrasenaUsuario = new javax.swing.JTextField();
        lbContrasena = new javax.swing.JLabel();
        lbApePaterno = new javax.swing.JLabel();
        txtRutUsuario = new javax.swing.JTextField();
        txtApeMaterno = new javax.swing.JTextField();
        lbApeMaterno = new javax.swing.JLabel();
        lbTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtMailUsuario = new javax.swing.JTextField();
        lbMail = new javax.swing.JLabel();
        lbDireccion = new javax.swing.JLabel();
        txtDireccionUsuario = new javax.swing.JTextField();
        txtFechaNacUsu = new javax.swing.JFormattedTextField();
        lbFechaNacimiento = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblDescripcion1 = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        lblMensajeExists = new javax.swing.JLabel();

        txtApePaterno.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtApePaterno.setNextFocusableComponent(txtNombreUsuario);

        lbRut.setText("Rut:");

        lbNombreUsuario.setText("Nombre:");

        lbContrasena.setText("Contraseña:");

        lbApePaterno.setText("Apellido Paterno:");

        txtRutUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRutUsuarioFocusLost(evt);
            }
        });
        txtRutUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRutUsuarioKeyTyped(evt);
            }
        });

        lbApeMaterno.setText("Apellido Materno:");

        lbTelefono.setText("Telefono:");

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        lbMail.setText("E-mail:");

        lbDireccion.setText("Direccion:");

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

        lbFechaNacimiento.setText("Fecha de Nacimiento:");

        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblTitulo.setText("Registro de Cliente");

        lblDescripcion.setFont(new java.awt.Font("Verdana", 2, 10)); // NOI18N
        lblDescripcion.setText("Introduzca el RUT del cliente, si existe automáticamente se cargará la información.");

        lblDescripcion1.setFont(new java.awt.Font("Verdana", 2, 10)); // NOI18N
        lblDescripcion1.setText("En caso contrario, debe intruducir los datos del cliente. ");

        btnSiguiente.setBackground(new java.awt.Color(153, 255, 153));
        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbNombreUsuario)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSiguiente))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbRut)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRutUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblDescripcion)
                            .addComponent(lblDescripcion1)
                            .addComponent(lblTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMensajeExists, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(154, 154, 154)))
                        .addContainerGap(122, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbApePaterno)
                            .addComponent(lbApeMaterno)
                            .addComponent(lbTelefono)
                            .addComponent(lbMail)
                            .addComponent(lbDireccion)
                            .addComponent(lbFechaNacimiento)
                            .addComponent(lbContrasena))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtMailUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApeMaterno, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApePaterno, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtConstrasenaUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreUsuario)
                                    .addComponent(txtDireccionUsuario, javax.swing.GroupLayout.Alignment.LEADING))
                                .addContainerGap())
                            .addComponent(txtFechaNacUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRut)
                    .addComponent(txtRutUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescripcion1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensajeExists, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNombreUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDireccion)
                    .addComponent(txtDireccionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFechaNacimiento)
                    .addComponent(txtFechaNacUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(btnSiguiente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaNacUsuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaNacUsuFocusLost
        Formularios.deStringAFecha(txtFechaNacUsu.getText());
    }//GEN-LAST:event_txtFechaNacUsuFocusLost

    private void txtRutUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRutUsuarioFocusLost
        if(!"".equals(txtRutUsuario.getText())){
            user = leerUsuarios(txtRutUsuario.getText().toUpperCase());
            if(user != null){
                lblMensajeExists.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/check_si.png")));
                lblMensajeExists.setText("Cliente Existe");
            } else {
                lblMensajeExists.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/error.png")));
                lblMensajeExists.setText("Cliente NO existe. Llenar los datos.");
            }
        }
    }//GEN-LAST:event_txtRutUsuarioFocusLost

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        if(user == null){
            int id_rol = 3; //Cliente
            if(true){
                user = new ClPasajeros(txtRutUsuario.getText()
                                                        , txtNombreUsuario.getText()
                                                        , txtConstrasenaUsuario.getText()
                                                        , txtApePaterno.getText()
                                                        , txtApeMaterno.getText()
                                                        , txtTelefono.getText()
                                                        , txtMailUsuario.getText()
                                                        , txtDireccionUsuario.getText()
                                                        , Formularios.deStringAFecha(txtFechaNacUsu.getText())
                                                        , id_rol);
                 DAOUsuarios.sqlInsert(user);
                 user.setIdPasajero(DAOUsuarios.sqlLastID());
            }
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void txtRutUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRutUsuarioKeyTyped
        Formularios.validarRut(evt);
    }//GEN-LAST:event_txtRutUsuarioKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        Formularios.soloNumeros(evt);
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private ClPasajeros leerUsuarios(String rut){
        ClPasajeros usu = DAOUsuarios.sqlLeer(rut.toUpperCase());
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
        return usu;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel lbApeMaterno;
    private javax.swing.JLabel lbApePaterno;
    private javax.swing.JLabel lbContrasena;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbFechaNacimiento;
    private javax.swing.JLabel lbMail;
    private javax.swing.JLabel lbNombreUsuario;
    private javax.swing.JLabel lbRut;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDescripcion1;
    private javax.swing.JLabel lblMensajeExists;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtApeMaterno;
    private javax.swing.JTextField txtApePaterno;
    private javax.swing.JTextField txtConstrasenaUsuario;
    private javax.swing.JTextField txtDireccionUsuario;
    private javax.swing.JFormattedTextField txtFechaNacUsu;
    private javax.swing.JTextField txtMailUsuario;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtRutUsuario;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
