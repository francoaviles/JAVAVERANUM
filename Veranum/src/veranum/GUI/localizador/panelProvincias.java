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
import veranum.DAO.DAOProvincia;
import veranum.DAO.DAORegiones;
import veranum.entities.ClProvincia;
import veranum.entities.ClRegion;

/**
 *
 * @author carlosdlg
 */
public class panelProvincias extends javax.swing.JPanel {
    private boolean paraGrabar = false;
    private DefaultTableModel dt = new DefaultTableModel();
    private int id = 0;
    /**
     * Creates new form panelProvincias
     */
    public panelProvincias() {
        initComponents();
        this.cargarRegiones();
        grProvincia.setEnabled(true);
        Formularios.DesactiveBotonesEliminarEditar(btEditarProvincia, btEliminarProvincia);
        btDesactivarEditarProvincia.setVisible(false);
        this.leerTodosPro(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNombreProvincia = new javax.swing.JLabel();
        txtNombreProvincia = new javax.swing.JTextField();
        lbRegionProvincia = new javax.swing.JLabel();
        btGrabarProvincia = new javax.swing.JButton();
        btBuscarProvincia = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        grProvincia = new javax.swing.JTable();
        btBuscarTodosProvincia = new javax.swing.JButton();
        btEliminarProvincia = new javax.swing.JButton();
        txtBuscarProvincia = new javax.swing.JTextField();
        btEditarProvincia = new javax.swing.JButton();
        btDesactivarEditarProvincia = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        cbRegion = new javax.swing.JComboBox();

        lbNombreProvincia.setText("Nombre Provincia:");

        txtNombreProvincia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProvinciaKeyTyped(evt);
            }
        });

        lbRegionProvincia.setText("Región:");

        btGrabarProvincia.setText("Grabar");
        btGrabarProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGrabarProvinciaActionPerformed(evt);
            }
        });

        btBuscarProvincia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/magnifier12.png"))); // NOI18N
        btBuscarProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarProvinciaActionPerformed(evt);
            }
        });

        grProvincia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "#", "Nombre", "Id Región"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grProvincia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grProvinciaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(grProvincia);

        btBuscarTodosProvincia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/refresh_16.png"))); // NOI18N
        btBuscarTodosProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarTodosProvinciaActionPerformed(evt);
            }
        });

        btEliminarProvincia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/delete96.png"))); // NOI18N
        btEliminarProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarProvinciaActionPerformed(evt);
            }
        });

        txtBuscarProvincia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarProvinciaKeyTyped(evt);
            }
        });

        btEditarProvincia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/write13.png"))); // NOI18N
        btEditarProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarProvinciaActionPerformed(evt);
            }
        });

        btDesactivarEditarProvincia.setBackground(new java.awt.Color(255, 0, 0));
        btDesactivarEditarProvincia.setText("Salir Modo Editar");
        btDesactivarEditarProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesactivarEditarProvinciaActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btGrabarProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNombreProvincia)
                                    .addComponent(lbRegionProvincia))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btDesactivarEditarProvincia)
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btEliminarProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btEditarProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(txtBuscarProvincia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscarProvincia)
                        .addGap(3, 3, 3)
                        .addComponent(btBuscarTodosProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                    .addComponent(jSeparator3))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btEliminarProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btBuscarProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEditarProvincia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscarProvincia, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btBuscarTodosProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombreProvincia)
                    .addComponent(txtNombreProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDesactivarEditarProvincia))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRegionProvincia)
                    .addComponent(cbRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btGrabarProvincia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btGrabarProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGrabarProvinciaActionPerformed
        int id_region = ((ClRegion)cbRegion.getSelectedItem()).getIdRegion();
        if(!paraGrabar){
            if(txtNombreProvincia.getText().equals("") ){ 
                JOptionPane.showMessageDialog(this, "Ingrese los Datos");
            }else{
                DAOProvincia.sqlInsert(new ClProvincia(txtNombreProvincia.getText()
                    , id_region)
            );
            JOptionPane.showMessageDialog(this, "Agregado");
            Formularios.DesactiveBotonesEliminarEditar(btEditarProvincia, btEliminarProvincia);
            helper.Formularios.limpiar(this);
            this.leerTodosPro(true);
        }
        }else{
            DAOProvincia.sqlUpdate(new ClProvincia(this.id, txtNombreProvincia.getText()
                                    , id_region));
            JOptionPane.showMessageDialog(this, "Modificado");
            Formularios.DesactiveBotonesEliminarEditar(btEditarProvincia, btEliminarProvincia);
            helper.Formularios.limpiar(this);
            this.leerTodosPro(true);
        }
    }//GEN-LAST:event_btGrabarProvinciaActionPerformed

    private void btBuscarProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarProvinciaActionPerformed
        if(txtBuscarProvincia.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Ingrese datos para buscar");
        }else{
            this.leerTodosPro(false);
        }         
    }//GEN-LAST:event_btBuscarProvinciaActionPerformed

    private void grProvinciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grProvinciaMouseClicked
        int row_dos = Formularios.getTablaSeleccionada(evt, grProvincia, 2);

        if(row_dos >= 0){
            this.leerProvincia(Integer.parseInt(grProvincia.getValueAt(row_dos, 0).toString()));
            Formularios.ActiveBotonesEliminarEditar(btEditarProvincia, btEliminarProvincia);
            this.paraGrabar = true;
            this.btnEditarMode();
        } else {
            Formularios.ActiveBotonesEliminarEditar(btEditarProvincia, btEliminarProvincia);
        }
    }//GEN-LAST:event_grProvinciaMouseClicked

    private void btBuscarTodosProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarTodosProvinciaActionPerformed
        this.leerTodosPro(true);
    }//GEN-LAST:event_btBuscarTodosProvinciaActionPerformed

    private void btEliminarProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarProvinciaActionPerformed
        this.leerProvincia(Formularios.getSelectedRow(grProvincia));
        if(this.id == 0){
            JOptionPane.showMessageDialog(this, "NO existe para eliminar");
        }else{
            DAOProvincia.sqlDelete(new ClProvincia(this.id));
            JOptionPane.showMessageDialog(this, "Eliminado");
            helper.Formularios.limpiar(this);
            Formularios.DesactiveBotonesEliminarEditar(btEditarProvincia, btEliminarProvincia);
            this.leerTodosPro(true);
        }
    }//GEN-LAST:event_btEliminarProvinciaActionPerformed

    private void btEditarProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarProvinciaActionPerformed
        this.leerProvincia(Formularios.getSelectedRow(grProvincia));
        this.paraGrabar = true;
        this.btnEditarMode();
    }//GEN-LAST:event_btEditarProvinciaActionPerformed

    private void btDesactivarEditarProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesactivarEditarProvinciaActionPerformed
        this.paraGrabar = false;
        this.btnEditarMode();
    }//GEN-LAST:event_btDesactivarEditarProvinciaActionPerformed

    private void txtNombreProvinciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProvinciaKeyTyped
        if (!(txtNombreProvincia.getText().length() < 40)) {
            Formularios.limpiarTxt(txtNombreProvincia);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtNombreProvinciaKeyTyped

    private void txtBuscarProvinciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProvinciaKeyTyped
        if (!(txtBuscarProvincia.getText().length() < 15)) {
            Formularios.limpiarTxt(txtBuscarProvincia);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtBuscarProvinciaKeyTyped


    private void cargarRegiones(){
        for (Object region : DAORegiones.sqlLeerTodos()) {
            cbRegion.addItem(region);
        }
    }

    
    private void leerProvincia(int id){
        this.id = id;
        System.out.println(id);
        ClProvincia xx = DAOProvincia.sqlLeer(id);
        txtNombreProvincia.setText(xx.getNombre());

        ClRegion item;
        for (int i = 0; i < cbRegion.getItemCount(); i++)
        {
            item = (ClRegion)cbRegion.getItemAt(i);
            if (item.getIdRegion()== xx.getIdRegion())
            {
                cbRegion.setSelectedIndex(i);
                break;
            }
        }

    }
    
    
    private void leerTodosPro(boolean todos){
        ArrayList pro = new ArrayList<>();
        if(todos)
            pro = DAOProvincia.sqlLeerTodos();
        else 
            pro = DAOProvincia.sqlBuscarByNombre(txtBuscarProvincia.getText());
        
        dt =  (DefaultTableModel) grProvincia.getModel();        
        for (int i = dt.getRowCount() -1; i >= 0; i--){  
            dt.removeRow(i);
        }        
        for(int x=0; x < pro.size(); x++){
            ClProvincia xx = (ClProvincia)pro.get(x);
            Object[] fila = new Object[7];
            fila[0] = xx.getIdProvincia();
            fila[1] = xx.getNombre();
            fila[2] = xx.getIdRegion(); 
            dt.addRow(fila);
        }
    }

    
    private void btnEditarMode(){
        if(!this.paraGrabar){
            btDesactivarEditarProvincia.setVisible(false);
            helper.Formularios.limpiar(this);
        } else {
            btDesactivarEditarProvincia.setVisible(true);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarProvincia;
    private javax.swing.JButton btBuscarTodosProvincia;
    private javax.swing.JButton btDesactivarEditarProvincia;
    private javax.swing.JButton btEditarProvincia;
    private javax.swing.JButton btEliminarProvincia;
    private javax.swing.JButton btGrabarProvincia;
    private javax.swing.JComboBox cbRegion;
    private javax.swing.JTable grProvincia;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbNombreProvincia;
    private javax.swing.JLabel lbRegionProvincia;
    private javax.swing.JTextField txtBuscarProvincia;
    private javax.swing.JTextField txtNombreProvincia;
    // End of variables declaration//GEN-END:variables
}
