/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.GUI.hotel;

import helper.Formularios;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import veranum.DAO.DAOHotelInsumos;
import veranum.DAO.DAOHoteles;
import veranum.DAO.DAOInsumos;
import veranum.DAO.DAOMedidas;
import veranum.entities.ClHotelInsumos;
import veranum.entities.ClHoteles;
import veranum.entities.ClInsumos;
import veranum.entities.ClMedidas;

/**
 *
 * @author Zacarias
 */
public class panelHotelInsumos extends javax.swing.JPanel {

    private boolean paraGrabar = false;
    private DefaultTableModel dt = new DefaultTableModel();
    private int id = 0;
    
    /**
     * Creates new form panelHotelInsumos
     */
    public panelHotelInsumos() {
        initComponents();
        this.cargarHotel();
        this.cargarInsumo();
        this.cargarMedidas();
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

        btEliminar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        btBuscarTodos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grDatos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        lbInsumo = new javax.swing.JLabel();
        lbHotel = new javax.swing.JLabel();
        cbInsumo = new javax.swing.JComboBox();
        cbHotel = new javax.swing.JComboBox();
        btGrabar = new javax.swing.JButton();
        btDesactivarEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbMedida = new javax.swing.JComboBox();
        lbStock = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();

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
                "#", "Insumo", "Hotel", "Medida", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        jScrollPane1.setViewportView(grDatos);
        if (grDatos.getColumnModel().getColumnCount() > 0) {
            grDatos.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        lbInsumo.setText("Insumo:");

        lbHotel.setText("Hotel:");

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

        jLabel1.setText("Medida:");

        lbStock.setText("Stock:");

        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btBuscarTodos)
                        .addContainerGap(105, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbInsumo)
                            .addComponent(lbHotel))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                        .addComponent(btDesactivarEditar)
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbStock)
                                .addGap(57, 57, 57)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btGrabar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbInsumo)
                    .addComponent(cbInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDesactivarEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHotel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbStock)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btGrabar)
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        this.leer(Formularios.getSelectedRow(grDatos));
        if(this.id == 0){
            JOptionPane.showMessageDialog(this, "NO existe para eliminar");
        }else{
            DAOHotelInsumos.sqlDelete(new ClHotelInsumos(this.id));
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

    private void btGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGrabarActionPerformed
        int id_insumo = ((ClInsumos)cbInsumo.getSelectedItem()).getIdInsumo();
        int id_hotel = ((ClHoteles)cbHotel.getSelectedItem()).getIdHotel();
        int id_medida = ((ClMedidas)cbMedida.getSelectedItem()).getIdMedida();
        if(!paraGrabar){
            if(txtStock.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Ingrese los Datos");
            }else{
                DAOHotelInsumos.sqlInsert(new ClHotelInsumos(id_insumo
                                                            , id_hotel
                                                            , id_medida
                                                            , Integer.parseInt(txtStock.getText()) 
                ));
                JOptionPane.showMessageDialog(this, "Agregado");
                Formularios.DesactiveBotonesEliminarEditar(btEditar, btEliminar);
                helper.Formularios.limpiar(this);
                this.leerTodos(true);
            }
        }else{
            DAOHotelInsumos.sqlUpdate(new ClHotelInsumos( this.id
                                                            , id_insumo
                                                            , id_hotel
                                                            , id_medida
                                                            , Integer.parseInt(txtStock.getText()) 
                ));
            JOptionPane.showMessageDialog(this, "Modificado");
            Formularios.DesactiveBotonesEliminarEditar(btEditar, btEliminar);
            helper.Formularios.limpiar(this);
            this.leerTodos(true);
        }
    }//GEN-LAST:event_btGrabarActionPerformed

    private void btDesactivarEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesactivarEditarActionPerformed
        this.paraGrabar = false;
        this.btnEditarMode();
    }//GEN-LAST:event_btDesactivarEditarActionPerformed

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        Formularios.soloNumeros(evt);
    }//GEN-LAST:event_txtStockKeyTyped

    // Method Custom
    private void cargarInsumo(){
        for (Object dato : DAOInsumos.sqlLeerTodos()) {
            cbInsumo.addItem(dato);
        }
    }
    
    private void cargarHotel(){
        for (Object dato : DAOHoteles.sqlLeerTodos()) {
            cbHotel.addItem(dato);
        }
    }
    
    private void cargarMedidas(){
        for (Object dato : DAOMedidas.sqlLeerTodos()) {
            cbMedida.addItem(dato);
        }
    }
       
    
    private void leer(int id){
        this.id = id;
        ClHotelInsumos dato = DAOHotelInsumos.sqlLeer(id);
        txtStock.setText(String.valueOf(dato.getStock()));
        
        ClInsumos item;
        for (int i = 0; i < cbInsumo.getItemCount(); i++)
        {
            item = (ClInsumos)cbInsumo.getItemAt(i);
            if (item.getIdInsumo()== dato.getIdInsumo())
            {
                cbInsumo.setSelectedIndex(i);
                break;
            }
        }
        
        ClHoteles item2;
        for (int i = 0; i < cbHotel.getItemCount(); i++)
        {
            item2 = (ClHoteles)cbHotel.getItemAt(i);
            if (item2.getIdHotel()== dato.getIdHotel())
            {
                cbHotel.setSelectedIndex(i);
                break;
            }
        }
        
        ClMedidas item3;
        for (int i = 0; i < cbMedida.getItemCount(); i++)
        {
            item3 = (ClMedidas)cbMedida.getItemAt(i);
            if (item3.getIdMedida()== dato.getIdMedida())
            {
                cbMedida.setSelectedIndex(i);
                break;
            }
        }
    }
    
    private void leerTodos(boolean todos){
        ArrayList dato;
        if(todos)
            dato = DAOHotelInsumos.sqlLeerTodos();
        else 
            //dato = DAOHabitaciones.sqlBuscarByNombre(txtBuscar.getText());
            dato = DAOHotelInsumos.sqlLeerTodos();
        
        dt =  (DefaultTableModel) grDatos.getModel();        
        for (int i = dt.getRowCount() -1; i >= 0; i--){  
            dt.removeRow(i);
        }     
        for(int x=0; x < dato.size(); x++){
            ClHotelInsumos xx = (ClHotelInsumos)dato.get(x);
            Object[] fila = new Object[7];
            fila[0] = ((ClHotelInsumos)DAOHotelInsumos.sqlLeer(xx.getIdInsumoHotel())).getIdInsumoHotel();
            fila[1] = ((ClInsumos)DAOInsumos.sqlLeer(xx.getIdInsumoHotel())).getNombre();
            fila[2] = ((ClHoteles)DAOHoteles.sqlLeer(xx.getIdHotel())).getNombre();
            fila[3] = ((ClMedidas)DAOMedidas.sqlLeer(xx.getIdMedida())).getMedida();
            fila[4] = xx.getStock();
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
    private javax.swing.JComboBox cbHotel;
    private javax.swing.JComboBox cbInsumo;
    private javax.swing.JComboBox cbMedida;
    private javax.swing.JTable grDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbHotel;
    private javax.swing.JLabel lbInsumo;
    private javax.swing.JLabel lbStock;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
