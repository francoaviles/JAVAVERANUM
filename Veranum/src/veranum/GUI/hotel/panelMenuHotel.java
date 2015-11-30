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
import veranum.DAO.DAOMenu;
import veranum.DAO.DAOTipoMenu;
import veranum.entities.ClHotelTipoMenu;
import veranum.entities.ClHoteles;
import veranum.entities.ClMenu;
import veranum.entities.ClTipoMenu;

/**
 *
 * @author Zacarias
 */
public class panelMenuHotel extends javax.swing.JPanel {

    private boolean paraGrabar = false;
    private DefaultTableModel dt = new DefaultTableModel();
    private int id_hotel = 0;
    private int id_menu = 0;
    
    /**
     * Creates new form panelMenuHotel
     */
    public panelMenuHotel() {
        initComponents();
        this.cargarHotel();
        this.cargarMenu();
        grDatos.setEnabled(true);
        Formularios.DesactiveBotonesEliminarEditar(btEliminar, btEliminar);
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
        txtBuscar = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        btBuscarTodos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grDatos = new javax.swing.JTable();
        lbHotel = new javax.swing.JLabel();
        lbTipoMenu = new javax.swing.JLabel();
        cbHotel = new javax.swing.JComboBox();
        cbMenu = new javax.swing.JComboBox();
        btGrabar = new javax.swing.JButton();
        btDesactivarEditar = new javax.swing.JButton();

        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/delete96.png"))); // NOI18N
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
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
                "Id Hotel", "Hotel", "Id Menu", "Menú", "Precio"
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
            grDatos.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        lbHotel.setText("Hotel:");

        lbTipoMenu.setText("Menú:");

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btBuscarTodos))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbHotel)
                            .addComponent(lbTipoMenu))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDesactivarEditar))
                    .addComponent(btGrabar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbHotel)
                            .addComponent(cbHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btDesactivarEditar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTipoMenu)
                            .addComponent(cbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(btGrabar)
                        .addContainerGap(233, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btEliminar)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btBuscar)
                            .addComponent(btBuscarTodos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        this.leer(Formularios.getSelectedRow2(grDatos, 0),
                Formularios.getSelectedRow2(grDatos, 2));
        if(this.id_hotel == 0){
            JOptionPane.showMessageDialog(this, "NO existe para eliminar");
        }else{
            DAOHotelTipoMenu.sqlDelete(new ClHotelTipoMenu(this.id_hotel, this.id_menu));
            JOptionPane.showMessageDialog(this, "Eliminado");
            helper.Formularios.limpiar(this);
            Formularios.DesactiveBotonesEliminarEditar(btEliminar, btEliminar);
            this.leerTodos(true);
        }
    }//GEN-LAST:event_btEliminarActionPerformed

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
                Formularios.getSelectedRow2(grDatos, 2));
            Formularios.ActiveBotonesEliminarEditar(btEliminar, btEliminar);
            this.paraGrabar = true;
            this.btnEditarMode();
        } else {
            Formularios.ActiveBotonesEliminarEditar(btEliminar, btEliminar);
        }
    }//GEN-LAST:event_grDatosMouseClicked

    private void btGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGrabarActionPerformed
        id_hotel = ((ClHoteles)cbHotel.getSelectedItem()).getIdHotel();
        id_menu = ((ClMenu)cbMenu.getSelectedItem()).getIdMenu();
        if(!paraGrabar){
                DAOHotelTipoMenu.sqlInsert(new ClHotelTipoMenu(id_hotel
                                                            , id_menu
                ));
                JOptionPane.showMessageDialog(this, "Agregado");
                Formularios.DesactiveBotonesEliminarEditar(btEliminar, btEliminar);
                helper.Formularios.limpiar(this);
                this.leerTodos(true);
        }/*else{
            DAOHotelTipoMenu.sqlUpdate(new ClHotelTipoMenu(id_hotel
                                                        , id_menu
            ));
            JOptionPane.showMessageDialog(this, "Modificado");
            Formularios.DesactiveBotonesEliminarEditar(btEditar, btEliminar);
            helper.Formularios.limpiar(this);
            this.leerTodos(true);
        }*/
    }//GEN-LAST:event_btGrabarActionPerformed

    private void btDesactivarEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesactivarEditarActionPerformed
        this.paraGrabar = false;
        this.btnEditarMode();
    }//GEN-LAST:event_btDesactivarEditarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        if (!(txtBuscar.getText().length() < 15)) {
            Formularios.limpiarTxt(txtBuscar);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    // Method Custom
    private void cargarHotel(){
        for (Object dato : DAOHoteles.sqlLeerTodos()) {
            cbHotel.addItem(dato);
        }
    }
    
    private void cargarMenu(){
        for (Object dato : DAOMenu.sqlLeerTodos()) {
            cbMenu.addItem(dato);
        }
    }
    
    private void leer(int id1, int id2){
        this.id_hotel = id1;
        this.id_menu = id2;
        ClHotelTipoMenu dato = DAOHotelTipoMenu.sqlLeer(id_hotel,id_menu);
        
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
        
        ClMenu item2;
        for (int i = 0; i < cbMenu.getItemCount(); i++)
        {
            item2 = (ClMenu)cbMenu.getItemAt(i);
            if (item2.getIdMenu()== dato.getIdMenu())
            {
                cbMenu.setSelectedIndex(i);
                break;
            }
        }
    }
    
    private void leerTodos(boolean todos){
        ArrayList dato;
        if(todos)
            dato = DAOHotelTipoMenu.sqlLeerTodos();
        else 
            //dato = DAOHotelTipoMenu.sqlBuscarByNombre(txtBuscar.getText());
            dato = DAOHotelTipoMenu.sqlLeerTodos();
        
        dt =  (DefaultTableModel) grDatos.getModel();        
        for (int i = dt.getRowCount() -1; i >= 0; i--){  
            dt.removeRow(i);
        }        
        for(int x=0; x < dato.size(); x++){
            ClHotelTipoMenu xx = (ClHotelTipoMenu)dato.get(x);
            Object[] fila = new Object[6];
            fila[0] = xx.getIdHotel();
            fila[1] = ((ClHoteles)DAOHoteles.sqlLeer(xx.getIdHotel())).getNombre();
            fila[2] = xx.getIdMenu();
            fila[3] = ((ClMenu)DAOMenu.sqlLeer(xx.getIdMenu())).getNombre();
            fila[4] = ((ClMenu)DAOMenu.sqlLeer(xx.getIdMenu())).getPrecio();
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
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btGrabar;
    private javax.swing.JComboBox cbHotel;
    private javax.swing.JComboBox cbMenu;
    private javax.swing.JTable grDatos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbHotel;
    private javax.swing.JLabel lbTipoMenu;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
