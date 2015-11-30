/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.GUI.localizador;

import helper.Formularios;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import veranum.DAO.DAOComuna;
import veranum.DAO.DAOProvincia;
import veranum.entities.ClComuna;
import veranum.entities.ClProvincia;

/**
 *
 * @author carlosdlg
 */
public class panelComunas extends javax.swing.JPanel {
    
    private boolean paraGrabar = false;
    private DefaultTableModel dt = new DefaultTableModel();
    private int id = 0;
    
    /**
     * Creates new form panelComunas
     */
    public panelComunas() {
        initComponents();
        this.cargarProvincias();
        grComuna.setEnabled(true);
        Formularios.DesactiveBotonesEliminarEditar(btEditarComuna, btEliminarComuna);
        btDesactivarEditarComuna.setVisible(false);
        this.leerTodosCom(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNombreComuna = new javax.swing.JLabel();
        lbProvinciaComuna = new javax.swing.JLabel();
        txtNombreComuna = new javax.swing.JTextField();
        btGrabarComuna = new javax.swing.JButton();
        btBuscarComuna = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        grComuna = new javax.swing.JTable();
        btBuscarTodosComuna = new javax.swing.JButton();
        btEliminarComuna = new javax.swing.JButton();
        txtBuscarComuna = new javax.swing.JTextField();
        btEditarComuna = new javax.swing.JButton();
        btDesactivarEditarComuna = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        cbProvincia = new javax.swing.JComboBox();

        lbNombreComuna.setText("Nombre Comuna:");

        lbProvinciaComuna.setText("Provincia:");

        txtNombreComuna.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreComunaKeyTyped(evt);
            }
        });

        btGrabarComuna.setText("Grabar");
        btGrabarComuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGrabarComunaActionPerformed(evt);
            }
        });

        btBuscarComuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/magnifier12.png"))); // NOI18N
        btBuscarComuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarComunaActionPerformed(evt);
            }
        });

        grComuna.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "#", "Nombre", "Comuna"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grComuna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grComunaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(grComuna);
        if (grComuna.getColumnModel().getColumnCount() > 0) {
            grComuna.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        btBuscarTodosComuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/refresh_16.png"))); // NOI18N
        btBuscarTodosComuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarTodosComunaActionPerformed(evt);
            }
        });

        btEliminarComuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/delete96.png"))); // NOI18N
        btEliminarComuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarComunaActionPerformed(evt);
            }
        });

        txtBuscarComuna.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarComunaKeyTyped(evt);
            }
        });

        btEditarComuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/write13.png"))); // NOI18N
        btEditarComuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarComunaActionPerformed(evt);
            }
        });

        btDesactivarEditarComuna.setBackground(new java.awt.Color(255, 0, 0));
        btDesactivarEditarComuna.setText("Salir Modo Editar");
        btDesactivarEditarComuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesactivarEditarComunaActionPerformed(evt);
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
                            .addComponent(lbNombreComuna)
                            .addComponent(lbProvinciaComuna))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btDesactivarEditarComuna)
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btEliminarComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btEditarComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(txtBuscarComuna)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscarComuna)
                        .addGap(3, 3, 3)
                        .addComponent(btBuscarTodosComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                    .addComponent(jSeparator4))
                .addContainerGap())
            .addComponent(btGrabarComuna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btEliminarComuna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btBuscarComuna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEditarComuna, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscarComuna, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btBuscarTodosComuna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombreComuna)
                    .addComponent(txtNombreComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDesactivarEditarComuna))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProvinciaComuna)
                    .addComponent(cbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGrabarComuna)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btGrabarComunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGrabarComunaActionPerformed
        int id_provi = ((ClProvincia)cbProvincia.getSelectedItem()).getIdProvincia();
        if(!paraGrabar){
            if(txtNombreComuna.getText().equals("") ){ 
                JOptionPane.showMessageDialog(this, "Ingrese los Datos");
            }else{
                try {
                    DAOComuna.sqlInsert(new ClComuna(txtNombreComuna.getText()
                            , id_provi)
                    );
                    JOptionPane.showMessageDialog(this, "Agregado");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al insertar el dato.");
                }
            Formularios.DesactiveBotonesEliminarEditar(btEditarComuna, btEliminarComuna);
            helper.Formularios.limpiar(this);
            this.leerTodosCom(true);
        }
        }else{
            try {
                DAOComuna.sqlUpdate(new ClComuna(this.id, txtNombreComuna.getText()
                        , id_provi));
                JOptionPane.showMessageDialog(this, "Modificado");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al modificar el dato.");
            }   
            Formularios.DesactiveBotonesEliminarEditar(btEditarComuna, btEliminarComuna);
            helper.Formularios.limpiar(this);
            this.leerTodosCom(true);
        }
    }//GEN-LAST:event_btGrabarComunaActionPerformed

    private void btBuscarComunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarComunaActionPerformed
        if(txtBuscarComuna.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Ingrese datos para buscar");
        }else{
            this.leerTodosCom(false);
        }         
    }//GEN-LAST:event_btBuscarComunaActionPerformed

    private void grComunaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grComunaMouseClicked
        int row_dos = Formularios.getTablaSeleccionada(evt, grComuna, 2);

        if(row_dos >= 0){
            this.leerComuna(Integer.parseInt(grComuna.getValueAt(row_dos, 0).toString()));
            Formularios.ActiveBotonesEliminarEditar(btEditarComuna, btEliminarComuna);
            this.paraGrabar = true;
            this.btnEditarMode();
        } else {
            Formularios.ActiveBotonesEliminarEditar(btEditarComuna, btEliminarComuna);
        }
    }//GEN-LAST:event_grComunaMouseClicked

    private void btBuscarTodosComunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarTodosComunaActionPerformed
        this.leerTodosCom(true);
    }//GEN-LAST:event_btBuscarTodosComunaActionPerformed

    private void btEliminarComunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarComunaActionPerformed
        this.leerComuna(Formularios.getSelectedRow(grComuna));        
        if(this.id == 0){
            JOptionPane.showMessageDialog(this, "NO existe para eliminar");
        }else{
            DAOComuna.sqlDelete(new ClComuna(this.id));
            JOptionPane.showMessageDialog(this, "Eliminado");
            helper.Formularios.limpiar(this);
            Formularios.DesactiveBotonesEliminarEditar(btEditarComuna, btEliminarComuna);
            this.leerTodosCom(true);
        }
    }//GEN-LAST:event_btEliminarComunaActionPerformed

    private void btEditarComunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarComunaActionPerformed
        this.leerComuna(Formularios.getSelectedRow(grComuna));
        this.paraGrabar = true;
        this.btnEditarMode();
    }//GEN-LAST:event_btEditarComunaActionPerformed

    private void btDesactivarEditarComunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesactivarEditarComunaActionPerformed
        this.paraGrabar = false;
        this.btnEditarMode();
    }//GEN-LAST:event_btDesactivarEditarComunaActionPerformed

    private void txtNombreComunaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreComunaKeyTyped
        if (!(txtNombreComuna.getText().length() < 40)) {
            Formularios.limpiarTxt(txtNombreComuna);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtNombreComunaKeyTyped

    private void txtBuscarComunaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarComunaKeyTyped
        if (!(txtBuscarComuna.getText().length() < 15)) {
            Formularios.limpiarTxt(txtBuscarComuna);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtBuscarComunaKeyTyped

    
    private void cargarProvincias(){
        for (Object item : DAOProvincia.sqlLeerTodos()) {
            cbProvincia.addItem(item);
        }
    }
    
    private void leerComuna(int id){
        this.id = id;
        ClComuna xx = DAOComuna.sqlLeer(id);
        txtNombreComuna.setText(xx.getNombre());
        
        ClProvincia item;
        for (int i = 0; i < cbProvincia.getItemCount(); i++)
        {
            item = (ClProvincia)cbProvincia.getItemAt(i);
            if (item.getIdProvincia()== xx.getIdProvincia())
            {
                cbProvincia.setSelectedIndex(i);
                break;
            }
        }
    }

    
    private void leerTodosCom(boolean todos){
        ArrayList com;
        if(todos)
            com = DAOComuna.sqlLeerTodos();
        else 
            com = DAOComuna.sqlBuscarByNombre(txtBuscarComuna.getText());
        
        dt =  (DefaultTableModel) grComuna.getModel();        
        for (int i = dt.getRowCount() -1; i >= 0; i--){  
            dt.removeRow(i);
        }        
        
        for (Object com1 : com) {
            ClComuna xx = (ClComuna) com1;
            Object[] fila = new Object[7];
            fila[0] = xx.getIdComuna();
            fila[1] = xx.getNombre();
            //fila[2] = xx.getIdProvincia(); 
            fila[2] = ((ClProvincia)DAOProvincia.sqlLeer(xx.getIdProvincia())).getNombre();
            dt.addRow(fila);
        }
    }
    
    private void btnEditarMode(){
        if(!this.paraGrabar){
            btDesactivarEditarComuna.setVisible(false);
            helper.Formularios.limpiar(this);
        } else {
            btDesactivarEditarComuna.setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarComuna;
    private javax.swing.JButton btBuscarTodosComuna;
    private javax.swing.JButton btDesactivarEditarComuna;
    private javax.swing.JButton btEditarComuna;
    private javax.swing.JButton btEliminarComuna;
    private javax.swing.JButton btGrabarComuna;
    private javax.swing.JComboBox cbProvincia;
    private javax.swing.JTable grComuna;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbNombreComuna;
    private javax.swing.JLabel lbProvinciaComuna;
    private javax.swing.JTextField txtBuscarComuna;
    private javax.swing.JTextField txtNombreComuna;
    // End of variables declaration//GEN-END:variables
}
