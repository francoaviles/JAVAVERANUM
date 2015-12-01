/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.GUI.hotel;

import helper.Formularios;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import veranum.DAO.DAOCadenas;
import veranum.DAO.DAOComuna;
import veranum.DAO.DAOHoteles;
import veranum.DAO.DAOProvincia;
import veranum.DAO.DAORegiones;
import veranum.entities.ClCadenas;
import veranum.entities.ClComuna;
import veranum.entities.ClHoteles;
import veranum.entities.ClProvincia;
import veranum.entities.ClRegion;

/**
 *
 * @author Duoc
 */
public class panelHotel extends javax.swing.JPanel {
    private boolean paraGrabar = false;
    private DefaultTableModel dt = new DefaultTableModel();
    private int id_hotel = 0;
    
    /**
     * Creates new form panelHotel
     */
    public panelHotel() {
        initComponents();
        grHotel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        grHotel.getTableHeader().setReorderingAllowed(false);
        for (Object dato : DAORegiones.sqlLeerTodos()) {
            cbRegion.addItem(dato);
        }
        for (Object dato : DAOCadenas.sqlLeerTodos()) {
            cbCadena.addItem(dato);
        }
        
        grHotel.setEnabled(true);
        Formularios.DesactiveBotonesEliminarEditar(btEditarHotel, btEliminarHotel);
        btDesactivarEditarHotel.setVisible(false);
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

        lbNombreHotel = new javax.swing.JLabel();
        lbDireccion = new javax.swing.JLabel();
        cbRegion = new javax.swing.JComboBox();
        txtNombreHotel = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        lbRegion = new javax.swing.JLabel();
        lbProvincia = new javax.swing.JLabel();
        lbComuna = new javax.swing.JLabel();
        cbProvincia = new javax.swing.JComboBox();
        cbComuna = new javax.swing.JComboBox();
        btGrabarHoteles = new javax.swing.JButton();
        lbCadena = new javax.swing.JLabel();
        cbCadena = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        grHotel = new javax.swing.JTable();
        btBuscarHotel = new javax.swing.JButton();
        btBuscarTodosHotel = new javax.swing.JButton();
        btEliminarHotel = new javax.swing.JButton();
        btEditarHotel = new javax.swing.JButton();
        txtBuscarHotel = new javax.swing.JTextField();
        btDesactivarEditarHotel = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        lbNombreHotel.setText("Nombre Hotel:");

        lbDireccion.setText("Dirección:");

        cbRegion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRegionItemStateChanged(evt);
            }
        });

        txtNombreHotel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreHotelKeyTyped(evt);
            }
        });

        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        lbRegion.setText("Región:");

        lbProvincia.setText("Provincia:");

        lbComuna.setText("Comuna:");

        cbProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProvinciaItemStateChanged(evt);
            }
        });

        btGrabarHoteles.setText("Grabar");
        btGrabarHoteles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGrabarHotelesActionPerformed(evt);
            }
        });

        lbCadena.setText("Cadena:");

        grHotel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "#", "Cadena", "Nombre", "Región", "Dirección"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grHotel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grHotelMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(grHotel);
        if (grHotel.getColumnModel().getColumnCount() > 0) {
            grHotel.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        btBuscarHotel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/magnifier12.png"))); // NOI18N
        btBuscarHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarHotelActionPerformed(evt);
            }
        });

        btBuscarTodosHotel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/refresh_16.png"))); // NOI18N
        btBuscarTodosHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarTodosHotelActionPerformed(evt);
            }
        });

        btEliminarHotel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/delete96.png"))); // NOI18N
        btEliminarHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarHotelActionPerformed(evt);
            }
        });

        btEditarHotel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/write13.png"))); // NOI18N
        btEditarHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarHotelActionPerformed(evt);
            }
        });

        txtBuscarHotel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarHotelKeyTyped(evt);
            }
        });

        btDesactivarEditarHotel.setBackground(new java.awt.Color(255, 0, 0));
        btDesactivarEditarHotel.setText("Salir Modo Editar");
        btDesactivarEditarHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesactivarEditarHotelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btEliminarHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btEditarHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(txtBuscarHotel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBuscarHotel)
                .addGap(3, 3, 3)
                .addComponent(btBuscarTodosHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNombreHotel)
                            .addComponent(lbRegion)
                            .addComponent(lbProvincia)
                            .addComponent(lbCadena))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreHotel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbCadena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btDesactivarEditarHotel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbComuna)
                            .addComponent(lbDireccion))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(btGrabarHoteles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btEliminarHotel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btBuscarHotel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEditarHotel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscarHotel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btBuscarTodosHotel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNombreHotel)
                            .addComponent(txtNombreHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btDesactivarEditarHotel)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbRegion)
                    .addComponent(cbRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProvincia)
                    .addComponent(cbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbComuna)
                    .addComponent(cbComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCadena)
                    .addComponent(cbCadena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGrabarHoteles, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbRegionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRegionItemStateChanged
        cbProvincia.removeAllItems();
        this.cargarProvincias();
        this.cargarComunas();
    }//GEN-LAST:event_cbRegionItemStateChanged

    private void cbProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProvinciaItemStateChanged
        cbComuna.removeAllItems();
        this.cargarComunas();
    }//GEN-LAST:event_cbProvinciaItemStateChanged

    private void btGrabarHotelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGrabarHotelesActionPerformed
        int id_cadena = ((ClCadenas)cbCadena.getSelectedItem()).getIdCadena();
        int id_region = ((ClRegion)cbRegion.getSelectedItem()).getIdRegion();
        int id_provi = ((ClProvincia)cbProvincia.getSelectedItem()).getIdProvincia();
        int id_comu = ((ClComuna)cbComuna.getSelectedItem()).getIdComuna();
        System.out.println(id_region);
        if(!paraGrabar){
            if(txtNombreHotel.getText().equals("")
               || txtDireccion.getText().equals("")
               ){ 
                JOptionPane.showMessageDialog(this, "Ingrese los Datos");
            }else{
                try {
                    DAOHoteles.sqlInsert(new ClHoteles( id_cadena,
                            id_region,
                            id_provi,
                            id_comu,
                            txtNombreHotel.getText(),
                            txtDireccion.getText())
                    );
                    JOptionPane.showMessageDialog(this, "Agregado");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al insertar el dato.");
                }
            Formularios.DesactiveBotonesEliminarEditar(btEditarHotel, btEliminarHotel);
            helper.Formularios.limpiar(this);
            this.leerTodos(true);
        }
        }else{
            try {
                DAOHoteles.sqlUpdate(new ClHoteles( this.id_hotel,
                        id_cadena,
                        id_region,
                        id_provi,
                        id_comu,
                        txtNombreHotel.getText(),
                        txtDireccion.getText())
                );
                JOptionPane.showMessageDialog(this, "Modificado");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al modificar el dato.");
            } 
        Formularios.DesactiveBotonesEliminarEditar(btEditarHotel, btEliminarHotel);
        helper.Formularios.limpiar(this);
        this.leerTodos(true);
        this.paraGrabar = false;
        this.btnEditarMode();
        }
    }//GEN-LAST:event_btGrabarHotelesActionPerformed

    private void grHotelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grHotelMouseClicked
        int row_dos = Formularios.getTablaSeleccionada(evt, grHotel, 2);

        if(row_dos >= 0){
            this.leerHotel(Integer.parseInt(grHotel.getValueAt(row_dos, 0).toString()));
            Formularios.ActiveBotonesEliminarEditar(btEditarHotel, btEliminarHotel);
            this.paraGrabar = true;
            this.btnEditarMode();
        } else {
            Formularios.ActiveBotonesEliminarEditar(btEditarHotel, btEliminarHotel);
        }
    }//GEN-LAST:event_grHotelMouseClicked

    private void btBuscarHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarHotelActionPerformed
        if(txtBuscarHotel.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Ingrese datos para buscar");
        }else{
            this.leerTodos(false);
        } 
    }//GEN-LAST:event_btBuscarHotelActionPerformed

    private void btBuscarTodosHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarTodosHotelActionPerformed
        this.leerTodos(true);
    }//GEN-LAST:event_btBuscarTodosHotelActionPerformed

    private void btEliminarHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarHotelActionPerformed
        this.leerHotel(Formularios.getSelectedRow(grHotel));
        if(this.id_hotel == 0){
            JOptionPane.showMessageDialog(this, "NO existe para eliminar");
        }else{
            DAOHoteles.sqlDelete(new ClHoteles(this.id_hotel));
            JOptionPane.showMessageDialog(this, "Eliminado");
            helper.Formularios.limpiar(this);
            Formularios.DesactiveBotonesEliminarEditar(btEditarHotel, btEliminarHotel);
            this.leerTodos(true);
        }
    }//GEN-LAST:event_btEliminarHotelActionPerformed

    private void btEditarHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarHotelActionPerformed
        this.leerHotel(Formularios.getSelectedRow(grHotel));
        this.paraGrabar = true;
        this.btnEditarMode();
    }//GEN-LAST:event_btEditarHotelActionPerformed

    private void btDesactivarEditarHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesactivarEditarHotelActionPerformed
        this.paraGrabar = false;
        this.btnEditarMode();
    }//GEN-LAST:event_btDesactivarEditarHotelActionPerformed

    private void txtNombreHotelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreHotelKeyTyped
        if (!(txtNombreHotel.getText().length() < 30)) {
            Formularios.limpiarTxt(txtNombreHotel);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtNombreHotelKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        if (!(txtDireccion.getText().length() < 50)) {
            Formularios.limpiarTxt(txtDireccion);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtBuscarHotelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarHotelKeyTyped
        if (!(txtBuscarHotel.getText().length() < 15)) {
            Formularios.limpiarTxt(txtBuscarHotel);
            JOptionPane.showMessageDialog(this, "Máximo de caracteres alcanzado");
        }
    }//GEN-LAST:event_txtBuscarHotelKeyTyped

    private void cargarProvincias(){
        int id_region = ((ClRegion)cbRegion.getSelectedItem()).getIdRegion();
        for (Object dato : DAOProvincia.sqlPorRegion(id_region)) {
            cbProvincia.addItem(dato);
        }
    }
    
    private void cargarComunas(){
        if(cbProvincia.getSelectedItem() != null) {
            int id_provincia = ((ClProvincia)cbProvincia.getSelectedItem()).getIdProvincia();
            for (Object dato : DAOComuna.sqlPorProvincia(id_provincia)) {
                cbComuna.addItem(dato);
            }
        }
    }
    // Method Custom
    private void leerHotel(int id){
        this.id_hotel = id;
        ClHoteles hotel = DAOHoteles.sqlLeer(id);
        txtNombreHotel.setText(hotel.getNombre());
        txtDireccion.setText(hotel.getDireccion());
        
        ClRegion reg;
        ClProvincia pro;
        ClComuna com;
        
        for (int i = 0; i < cbRegion.getItemCount(); i++)
        {
            reg = (ClRegion)cbRegion.getItemAt(i);
            if (reg.getIdRegion()== hotel.getIdRegion())
            {
                cbRegion.setSelectedIndex(i);
                break;
            }
        }
        
        for (int i = 0; i < cbProvincia.getItemCount(); i++)
        {
            pro = (ClProvincia)cbProvincia.getItemAt(i);
            if (pro.getIdProvincia()== hotel.getIdProvincia())
            {
                cbProvincia.setSelectedIndex(i);
                break;
            }
        }
        
        for (int i = 0; i < cbComuna.getItemCount(); i++)
        {
            com = (ClComuna)cbComuna.getItemAt(i);
            if (com.getIdComuna()== hotel.getIdComuna())
            {
                cbComuna.setSelectedIndex(i);
                break;
            }
        }
        
    }
    
    private void leerTodos(boolean todos){
        ArrayList ser;
        if(todos)
            ser = DAOHoteles.sqlLeerTodos();
        else 
            ser = DAOHoteles.sqlBuscarByNombre(txtBuscarHotel.getText());
        
        dt =  (DefaultTableModel) grHotel.getModel();        
        for (int i = dt.getRowCount() -1; i >= 0; i--){  
            dt.removeRow(i);
        }        
        for(int x=0; x < ser.size(); x++){
            ClHoteles xx = (ClHoteles)ser.get(x);
            Object[] fila = new Object[7];
            fila[0] = xx.getIdHotel();
            fila[1] = ((ClCadenas)DAOCadenas.sqlLeer(xx.getIdCadena())).getNombre();
            fila[2] = xx.getNombre(); 
            fila[3] = ((ClRegion)DAORegiones.sqlLeer(xx.getIdRegion())).getNombre();
            fila[4] = xx.getDireccion(); 
            dt.addRow(fila);
        }
    }
    
    private void btnEditarMode(){
        if(!this.paraGrabar){
            btDesactivarEditarHotel.setVisible(false);
            helper.Formularios.limpiar(this);
        } else {
            btDesactivarEditarHotel.setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarHotel;
    private javax.swing.JButton btBuscarTodosHotel;
    private javax.swing.JButton btDesactivarEditarHotel;
    private javax.swing.JButton btEditarHotel;
    private javax.swing.JButton btEliminarHotel;
    private javax.swing.JButton btGrabarHoteles;
    private javax.swing.JComboBox cbCadena;
    private javax.swing.JComboBox cbComuna;
    private javax.swing.JComboBox cbProvincia;
    private javax.swing.JComboBox cbRegion;
    private javax.swing.JTable grHotel;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbCadena;
    private javax.swing.JLabel lbComuna;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbNombreHotel;
    private javax.swing.JLabel lbProvincia;
    private javax.swing.JLabel lbRegion;
    private javax.swing.JTextField txtBuscarHotel;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombreHotel;
    // End of variables declaration//GEN-END:variables
}
