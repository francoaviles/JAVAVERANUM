/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.GUI.reportes;

import helper.Formularios;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import veranum.DAO.DAOReportes;
import veranum.DAO.DAOTipoRep;
import veranum.entities.ClReportes;
import veranum.entities.ClTipoReportes;

/**
 *
 * @author Zacarias
 */
public class panelReportes extends javax.swing.JPanel {

    private boolean paraGrabar = false;
    private DefaultTableModel dt = new DefaultTableModel();
    private int id = 0;
    
    /**
     * Creates new form panelReportes
     */
    public panelReportes() {
        initComponents();
        this.cargarTipoRep();
        grDatos.setEnabled(true);
        grDatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        grDatos.getTableHeader().setReorderingAllowed(false);
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

        lbFechaCreacion = new javax.swing.JLabel();
        lbArchivo = new javax.swing.JLabel();
        lbTipo = new javax.swing.JLabel();
        lbComentario = new javax.swing.JLabel();
        btGrabar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextArea();
        cbTipoRepor = new javax.swing.JComboBox();
        txtArchivo = new javax.swing.JTextField();
        btEliminar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        btBuscarTodos = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        grDatos = new javax.swing.JTable();
        btDesactivarEditar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtFechaCreacion = new javax.swing.JFormattedTextField();

        lbFechaCreacion.setText("Fecha Creación:");

        lbArchivo.setText("Archivo:");

        lbTipo.setText("Tipo:");

        lbComentario.setText("Comentario:");

        btGrabar.setText("Grabar");
        btGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGrabarActionPerformed(evt);
            }
        });

        txtComentario.setColumns(20);
        txtComentario.setRows(5);
        txtComentario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtComentarioKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtComentario);

        txtArchivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtArchivoKeyTyped(evt);
            }
        });

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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "#", "Fecha Cración", "Archivo", "Tipo", "Comentario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
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
        jScrollPane3.setViewportView(grDatos);
        if (grDatos.getColumnModel().getColumnCount() > 0) {
            grDatos.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        btDesactivarEditar.setBackground(new java.awt.Color(255, 0, 0));
        btDesactivarEditar.setText("Salir Modo Editar");
        btDesactivarEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesactivarEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btBuscar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btBuscarTodos))
                                    .addComponent(lbArchivo)
                                    .addComponent(lbTipo)
                                    .addComponent(lbComentario))
                                .addGap(0, 31, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbFechaCreacion)
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFechaCreacion)
                                    .addComponent(cbTipoRepor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtArchivo)
                                    .addComponent(jScrollPane1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btDesactivarEditar)))
                        .addContainerGap())))
            .addComponent(btGrabar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEliminar)
                    .addComponent(btEditar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar)
                    .addComponent(btBuscarTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFechaCreacion)
                    .addComponent(btDesactivarEditar)
                    .addComponent(txtFechaCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbArchivo)
                    .addComponent(txtArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTipo)
                    .addComponent(cbTipoRepor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbComentario)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGrabar)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        txtFechaCreacion.setFormatterFactory(new javax.swing.JFormattedTextField.AbstractFormatterFactory(){
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
    }// </editor-fold>//GEN-END:initComponents

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        this.leer(Formularios.getSelectedRow(grDatos));
        if(this.id == 0){
            JOptionPane.showMessageDialog(this, "NO existe para eliminar");
        }else{
            try {
                DAOReportes.sqlDelete(new ClReportes(this.id));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "No se ha podido eliminar.");
            }
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
        int id_tipo = ((ClTipoReportes)cbTipoRepor.getSelectedItem()).getIdTipoReporte();
        if(!paraGrabar){
            if(txtFechaCreacion.getText().equals("")
               || txtArchivo.getText().equals("")
               || txtComentario.getText().equals("")
              ){
                JOptionPane.showMessageDialog(this, "Ingrese los Datos");
            }else{
                try {
                    DAOReportes.sqlInsert(new ClReportes( Formularios.deStringAFecha(txtFechaCreacion.getText())
                            , id_tipo
                            , txtArchivo.getText()
                            , txtComentario.getText()
                    ));
                    JOptionPane.showMessageDialog(this, "Agregado");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al insertar el dato.");
                }
            Formularios.DesactiveBotonesEliminarEditar(btEditar, btEliminar);
            helper.Formularios.limpiar(this);
            this.leerTodos(true);
        }
        }else{
            try {
                DAOReportes.sqlUpdate(new ClReportes( this.id
                        , Formularios.deStringAFecha(txtFechaCreacion.getText())
                        , id_tipo
                        , txtArchivo.getText()
                        , txtComentario.getText()
                ));
                JOptionPane.showMessageDialog(this, "Modificado");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al modificar el dato.");
            }  
            Formularios.DesactiveBotonesEliminarEditar(btEditar, btEliminar);
            helper.Formularios.limpiar(this);
            this.leerTodos(true);
            this.paraGrabar = false;
            this.btnEditarMode();
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

    private void txtComentarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComentarioKeyTyped
        if (!(txtComentario.getText().length() < 200)) {
            Formularios.limpiarTxt(txtComentario);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtComentarioKeyTyped

    private void txtArchivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArchivoKeyTyped
        if (!(txtArchivo.getText().length() < 50)) {
            Formularios.limpiarTxt(txtArchivo);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtArchivoKeyTyped

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        if (!(txtBuscar.getText().length() < 15)) {
            Formularios.limpiarTxt(txtBuscar);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    // Method Custom    
    private void cargarTipoRep(){
        for (Object dato : DAOTipoRep.sqlLeerTodos()) {
            cbTipoRepor.addItem(dato);
        }
    }
    
    private void leer(int id){
        this.id = id;
        ClReportes dato = DAOReportes.sqlLeer(id);
        txtFechaCreacion.setValue(dato.getStringFecha());
        txtArchivo.setText(dato.getArchivo());
        txtComentario.setText(dato.getComentario());
        
        ClTipoReportes item;
        for (int i = 0; i < cbTipoRepor.getItemCount(); i++)
        {
            item = (ClTipoReportes)cbTipoRepor.getItemAt(i);
            if (item.getIdTipoReporte()== dato.getIdTipoReporte())
            {
                cbTipoRepor.setSelectedIndex(i);
                break;
            }
        }
    }
    
    private void leerTodos(boolean todos){
        ArrayList dato;
        if(todos)
            dato = DAOReportes.sqlLeerTodos();
        else 
            dato = DAOReportes.sqlBuscarByNombre(txtBuscar.getText());
            //dato = DAOReportes.sqlLeerTodos();
        
        dt =  (DefaultTableModel) grDatos.getModel();        
        for (int i = dt.getRowCount() -1; i >= 0; i--){  
            dt.removeRow(i);
        }        
        for(int x=0; x < dato.size(); x++){
            ClReportes xx = (ClReportes)dato.get(x);
            Object[] fila = new Object[7];
            fila[0] = xx.getIdReporte();
            fila[1] = xx.getFechaCreacion();
            fila[2] = xx.getArchivo();
            fila[3] = ((ClTipoReportes)DAOTipoRep.sqlLeer(xx.getIdTipoReporte())).getNombre();
            fila[4] = xx.getComentario();
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
    private javax.swing.JComboBox cbTipoRepor;
    private javax.swing.JTable grDatos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbArchivo;
    private javax.swing.JLabel lbComentario;
    private javax.swing.JLabel lbFechaCreacion;
    private javax.swing.JLabel lbTipo;
    private javax.swing.JTextField txtArchivo;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtComentario;
    private javax.swing.JFormattedTextField txtFechaCreacion;
    // End of variables declaration//GEN-END:variables
}
