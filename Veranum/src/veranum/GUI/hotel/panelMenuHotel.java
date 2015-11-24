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
import veranum.DAO.DAOHotelTipoMenu;
import veranum.DAO.DAOHoteles;
import veranum.DAO.DAOTipoMenu;
import veranum.entities.ClHotelTipoMenu;
import veranum.entities.ClHoteles;
import veranum.entities.ClTipoMenu;

/**
 *
 * @author Zacarias
 */
public class panelMenuHotel extends javax.swing.JPanel {

    private boolean paraGrabar = false;
    private DefaultTableModel dt = new DefaultTableModel();
    private int id_hotel = 0;
    private int id_tipo_menu = 0;
    
    /**
     * Creates new form panelMenuHotel
     */
    public panelMenuHotel() {
        initComponents();
        this.cargarHotel();
        this.cargarTipoMenu();
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
        lbHotel = new javax.swing.JLabel();
        lbTipoMenu = new javax.swing.JLabel();
        cbHotel = new javax.swing.JComboBox();
        cbTipoMenu = new javax.swing.JComboBox();
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Hotel", "Hotel", "Tipo menú", "Id Tipo menú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        lbHotel.setText("Hotel:");

        lbTipoMenu.setText("Tipo Menú");

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
                        .addContainerGap(66, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btGrabar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbHotel)
                                    .addComponent(lbTipoMenu))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbTipoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btDesactivarEditar)
                        .addGap(45, 45, 45))))
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
                    .addComponent(lbHotel)
                    .addComponent(cbHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDesactivarEditar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTipoMenu)
                    .addComponent(cbTipoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(btGrabar)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        this.leer(Formularios.getSelectedRow2(grDatos, 0),
                Formularios.getSelectedRow2(grDatos, 3));
        if(this.id_hotel == 0){
            JOptionPane.showMessageDialog(this, "NO existe para eliminar");
        }else{
            DAOHotelTipoMenu.sqlDelete(new ClHotelTipoMenu(this.id_hotel, this.id_tipo_menu));
            JOptionPane.showMessageDialog(this, "Eliminado");
            helper.Formularios.limpiar(this);
            Formularios.DesactiveBotonesEliminarEditar(btEditar, btEliminar);
            this.leerTodos(true);
        }
    }//GEN-LAST:event_btEliminarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        this.leer(Formularios.getSelectedRow2(grDatos, 0),
                Formularios.getSelectedRow2(grDatos, 3));
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
            this.leer(Formularios.getSelectedRow2(grDatos, 0),
                Formularios.getSelectedRow2(grDatos, 3));
            Formularios.ActiveBotonesEliminarEditar(btEditar, btEliminar);
            this.paraGrabar = true;
            this.btnEditarMode();
        } else {
            Formularios.ActiveBotonesEliminarEditar(btEditar, btEliminar);
        }
    }//GEN-LAST:event_grDatosMouseClicked

    private void btGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGrabarActionPerformed
        id_hotel = ((ClHoteles)cbHotel.getSelectedItem()).getIdHotel();
        id_tipo_menu = ((ClTipoMenu)cbTipoMenu.getSelectedItem()).getIdTipoMenu();
        if(!paraGrabar){
            if(cbHotel.getSelectedItem() == null || cbTipoMenu.getSelectedItem()== null){
                JOptionPane.showMessageDialog(this, "Ingrese los Datos");
            }else{
                DAOHotelTipoMenu.sqlInsert(new ClHotelTipoMenu(id_hotel
                                                            , id_tipo_menu
                ));
                JOptionPane.showMessageDialog(this, "Agregado");
                Formularios.DesactiveBotonesEliminarEditar(btEditar, btEliminar);
                helper.Formularios.limpiar(this);
                this.leerTodos(true);
            }
        }else{
            DAOHotelTipoMenu.sqlUpdate(new ClHotelTipoMenu(id_hotel
                                                        , id_tipo_menu
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

    // Method Custom
    private void cargarHotel(){
        for (Object dato : DAOHoteles.sqlLeerTodos()) {
            cbHotel.addItem(dato);
        }
    }
    
    private void cargarTipoMenu(){
        for (Object dato : DAOTipoMenu.sqlLeerTodos()) {
            cbTipoMenu.addItem(dato);
        }
    }
    
    private void leer(int id1, int id2){
        this.id_hotel = id1;
        this.id_tipo_menu = id2;
        ClHotelTipoMenu dato = DAOHotelTipoMenu.sqlLeer(id_hotel,id_tipo_menu);
        
        ClHoteles item;
        for (int i = 0; i < cbHotel.getItemCount(); i++)
        {
            item = (ClHoteles)cbHotel.getItemAt(i);
            if (item.getIdHotel()== dato.getIdHotel())
            {
                cbHotel.setSelectedIndex(i);
                break;
            }
        }
        
        ClTipoMenu item2;
        for (int i = 0; i < cbTipoMenu.getItemCount(); i++)
        {
            item2 = (ClTipoMenu)cbTipoMenu.getItemAt(i);
            if (item2.getIdTipoMenu()== dato.getIdTipoMenu())
            {
                cbTipoMenu.setSelectedIndex(i);
                break;
            }
        }
    }
    
    private void leerTodos(boolean todos){
        ArrayList dato;
        if(todos)
            dato = DAOHotelTipoMenu.sqlLeerTodos();
        else 
            //dato = DAOHabitaciones.sqlBuscarByNombre(txtBuscar.getText());
            dato = DAOHotelTipoMenu.sqlLeerTodos();
        
        dt =  (DefaultTableModel) grDatos.getModel();        
        for (int i = dt.getRowCount() -1; i >= 0; i--){  
            dt.removeRow(i);
        }        //id caract?
        for(int x=0; x < dato.size(); x++){
            ClHotelTipoMenu xx = (ClHotelTipoMenu)dato.get(x);
            Object[] fila = new Object[6];
            fila[0] = xx.getIdHotel();
            fila[1] = ((ClHoteles)DAOHoteles.sqlLeer(xx.getIdHotel())).getNombre();
            fila[2] = ((ClTipoMenu)DAOTipoMenu.sqlLeer(xx.getIdTipoMenu())).getNombre();
            fila[3] = xx.getIdTipoMenu();
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
    private javax.swing.JComboBox cbTipoMenu;
    private javax.swing.JTable grDatos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbHotel;
    private javax.swing.JLabel lbTipoMenu;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
