/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.GUI.reservas;

import helper.Formularios;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import veranum.DAO.DAOEstadoHab;
import veranum.DAO.DAOHabitaciones;
import veranum.DAO.DAOHoteles;
import veranum.DAO.DAOReservar;
import veranum.DAO.DAOTipoHab;
import veranum.entities.ClHabitacionEstados;
import veranum.entities.ClHoteles;
import veranum.entities.ClPasajeros;
import veranum.entities.ClTipoHabitacion;
import veranum.entities.ClHabitaciones;
import veranum.entities.ClReservar;

/**
 *
 * @author Duoc
 */
public class PasoDos_Reserva extends javax.swing.JPanel {
    ArrayList<ClHabitaciones> reservas = new ArrayList<>();      
    private final JTabbedPane myTab;
    private final ClPasajeros pasajero;
    private DefaultTableModel dt = new DefaultTableModel();
    private final Date date = new Date();
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private long dias = 0;
    private long total = 0;
    private long totalfinal = 0;

    /**
     * Creates new form PasoDos_Reserva
     * @param t
     * @param pasajero
     */
    public PasoDos_Reserva(JTabbedPane t, ClPasajeros pasajero) {
        initComponents();
        this.setDiasTotal();
        this.cargarHotel();
        this.cargarTipoHab();
        this.myTab = t;
        this.pasajero = pasajero;
        this.btnSiguiente.setVisible(false);
    }

    private void setDiasTotal(){
        lblDias.setText(""+this.dias);
        lblTotalPrecio.setText("$"+this.total);
        this.totalfinal = this.dias*this.total;
        lblTotalFinalPrecio.setText("$"+totalfinal);
        if(this.totalfinal > 0)
            btnSiguiente.setVisible(true);
        else
            btnSiguiente.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAtras = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lbFechaIngreso = new javax.swing.JLabel();
        txtFechaIngreso = new javax.swing.JFormattedTextField(sdf.format(date));
        txtFechaSalida = new javax.swing.JFormattedTextField(sdf.format(date));
        lbFechaSalida = new javax.swing.JLabel();
        lblFechas = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        grHabs = new javax.swing.JTable();
        lblHotel = new javax.swing.JLabel();
        cbHotel = new javax.swing.JComboBox();
        lblTipo = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox();
        lblCantPersonas = new javax.swing.JLabel();
        txtCantPersonas = new javax.swing.JTextField();
        btnBuscarHabitaciones = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        grReservas = new javax.swing.JTable();
        lblReservas = new javax.swing.JLabel();
        lblTotalDias = new javax.swing.JLabel();
        lblDias = new javax.swing.JLabel();
        lblTotalPrecio = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblTotalFinal = new javax.swing.JLabel();
        lblTotalFinalPrecio = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();

        btnAtras.setBackground(new java.awt.Color(255, 255, 255));
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/atras.png"))); // NOI18N
        btnAtras.setText("Atrás");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblTitulo.setText("Reservar Habitación");

        lbFechaIngreso.setText("Fecha Ingreso:");

        txtFechaIngreso.setFormatterFactory(new javax.swing.JFormattedTextField.AbstractFormatterFactory(){
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
        txtFechaIngreso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaIngresoFocusLost(evt);
            }
        });

        txtFechaSalida.setFormatterFactory(new javax.swing.JFormattedTextField.AbstractFormatterFactory(){
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
        txtFechaSalida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaSalidaFocusLost(evt);
            }
        });

        lbFechaSalida.setText("Fecha Salida:");

        lblFechas.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblFechas.setText("Fechas de reserva: ");

        grHabs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Ubicación", "Cant. Personas", "Precio", "Tipo", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grHabs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grHabsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(grHabs);

        lblHotel.setText("Hotel: ");

        lblTipo.setText("Tipo:");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas" }));

        lblCantPersonas.setText("Cant. Personas:");

        btnBuscarHabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veranum/imagenes/magnifier12.png"))); // NOI18N
        btnBuscarHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHabitacionesActionPerformed(evt);
            }
        });

        grReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ubicación", "Precio", "Tipo", "#"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grReservasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(grReservas);

        lblReservas.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblReservas.setText("Reservas:");

        lblTotalDias.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblTotalDias.setText("Total Días: ");

        lblDias.setFont(new java.awt.Font("Simplified Arabic", 1, 24)); // NOI18N
        lblDias.setForeground(new java.awt.Color(51, 0, 0));

        lblTotalPrecio.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblTotalPrecio.setForeground(new java.awt.Color(51, 0, 0));

        lblTotal.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblTotal.setText("Total x noche: ");

        lblTotalFinal.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblTotalFinal.setText("Total:");

        lblTotalFinalPrecio.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblTotalFinalPrecio.setForeground(new java.awt.Color(51, 0, 0));

        btnSiguiente.setBackground(new java.awt.Color(51, 255, 51));
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lbFechaIngreso)
                                        .addGap(43, 43, 43)
                                        .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbFechaSalida)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(lblFechas))
                            .addComponent(lblTitulo)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTotalDias)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDias)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAtras)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblHotel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTipo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCantPersonas)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscarHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblReservas)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTotal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTotalPrecio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTotalFinal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(198, 198, 198)
                                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(lblTotalFinalPrecio)
                                .addGap(29, 29, 29)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(18, 18, 18)
                        .addComponent(lblFechas)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbFechaIngreso)
                            .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbFechaSalida)
                            .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCantPersonas, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblHotel)
                                        .addComponent(cbHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblTipo)
                                        .addComponent(lblCantPersonas))
                                    .addComponent(cbTipo, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblReservas))))
                    .addComponent(btnBuscarHabitaciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalDias)
                    .addComponent(lblDias))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(lblTotalPrecio)
                    .addComponent(lblTotalFinal)
                    .addComponent(lblTotalFinalPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnAtras)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        myTab.setEnabledAt(1, false);
        myTab.setSelectedIndex(0);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void txtFechaIngresoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaIngresoFocusLost
        Formularios.deStringAFecha(txtFechaIngreso.getText());
    }//GEN-LAST:event_txtFechaIngresoFocusLost

    private void txtFechaSalidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaSalidaFocusLost
        Formularios.deStringAFecha(txtFechaSalida.getText());
        this.calcularDias();
    }//GEN-LAST:event_txtFechaSalidaFocusLost

    private void btnBuscarHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHabitacionesActionPerformed
        this.leerBuscar();
    }//GEN-LAST:event_btnBuscarHabitacionesActionPerformed

    private void grHabsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grHabsMouseClicked
        int row_dos = Formularios.getTablaSeleccionada(evt, grHabs, 2);

        if(row_dos >= 0){
            this.reservas.add(this.leer(Integer.parseInt(grHabs.getValueAt(row_dos, 0).toString())));
            this.cargarReservas();
        } 
    }//GEN-LAST:event_grHabsMouseClicked

    private void grReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grReservasMouseClicked
        int row_dos = Formularios.getTablaSeleccionada(evt, grReservas, 2);

        if(row_dos >= 0){
            this.reservas.remove(Integer.parseInt(grReservas.getValueAt(row_dos, 3).toString()));
            this.cargarReservas();
        }
    }//GEN-LAST:event_grReservasMouseClicked

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        ClReservar reserva = new ClReservar(pasajero, 
                                        reservas, 
                                        Formularios.deStringAFecha(txtFechaIngreso.getText()), 
                                        Formularios.deStringAFecha(txtFechaSalida.getText()), 
                                        this.dias, 
                                        this.total, 
                                        this.totalfinal);
        
        myTab.setEnabledAt(2, true);
        myTab.setComponentAt(2, new PasoTres_Servicios(myTab, reserva));
        myTab.setSelectedIndex(2);
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private ClHabitaciones leer(int id){
        return DAOHabitaciones.sqlLeer(id);
    }
    
    private void calcularDias()
    {
        this.dias = Formularios.diasBetweenFechas(txtFechaIngreso.getText(), txtFechaSalida.getText());
        if(this.dias <= 0){
            JOptionPane.showMessageDialog(this, "La fecha de salida tiene que ser superior a la de entrada. ");
        }
        this.setDiasTotal();
    }
    private void leerBuscar()
    {
        ArrayList rol = new ArrayList<>();
        int cant = 0;
        int tipo = 0;
        
        if(!txtCantPersonas.getText().equals("")){
            cant = Integer.parseInt(txtCantPersonas.getText());
        }
        
        if(cbTipo.getSelectedItem() != "Todas")
            tipo = ((ClTipoHabitacion)cbTipo.getSelectedItem()).getIdTipoHabit();
        
        try {
            rol = DAOReservar.sqlBuscarHabitacion(
                    ((ClHoteles)cbHotel.getSelectedItem()).getIdHotel(),
                    tipo,
                    cant
            );
        } catch (SQLException ex) {
            Logger.getLogger(PasoDos_Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dt =  (DefaultTableModel) grHabs.getModel();        
        for (int i = dt.getRowCount() -1; i >= 0; i--){  
            dt.removeRow(i);
        }        
        for(int x=0; x < rol.size(); x++){
            ClHabitaciones xx = (ClHabitaciones)rol.get(x);
            Object[] fila = new Object[7];
            fila[0] = xx.getIdHabitacion();
            fila[1] = xx.getUbicacion();
            fila[2] = xx.getCantPersonas();
            fila[3] = xx.getPrecio();
            fila[4] = ((ClTipoHabitacion)DAOTipoHab.sqlLeer(xx.getIdHabitacionTipo())).getNombre();
            fila[5] = ((ClHabitacionEstados)DAOEstadoHab.sqlLeer(xx.getIdHabitacionEstado())).getEstado();
            dt.addRow(fila);
        }
    }
    
    private void cargarReservas(){
        dt =  (DefaultTableModel) grReservas.getModel();        
        for (int i = dt.getRowCount() -1; i >= 0; i--){  
            dt.removeRow(i);
        }  
        this.total = 0;
        for(int x=0; x < this.reservas.size(); x++){
            ClHabitaciones xx = (ClHabitaciones)this.reservas.get(x);
            this.total += xx.getPrecio();
            Object[] fila = new Object[4];
            fila[0] = xx.getUbicacion();
            fila[1] = xx.getPrecio();
            fila[2] = ((ClTipoHabitacion)DAOTipoHab.sqlLeer(xx.getIdHabitacionTipo())).getNombre();
            fila[3] = x;
            dt.addRow(fila);
        }    
        this.setDiasTotal();
    }
    private void cargarHotel(){
        for (Object dato : DAOHoteles.sqlLeerTodos()) {
            cbHotel.addItem(dato);
        }
    }
    
    private void cargarTipoHab(){
        for (Object dato : DAOTipoHab.sqlLeerTodos()) {
            cbTipo.addItem(dato);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscarHabitaciones;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox cbHotel;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JTable grHabs;
    private javax.swing.JTable grReservas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbFechaIngreso;
    private javax.swing.JLabel lbFechaSalida;
    private javax.swing.JLabel lblCantPersonas;
    private javax.swing.JLabel lblDias;
    private javax.swing.JLabel lblFechas;
    private javax.swing.JLabel lblHotel;
    private javax.swing.JLabel lblReservas;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalDias;
    private javax.swing.JLabel lblTotalFinal;
    private javax.swing.JLabel lblTotalFinalPrecio;
    private javax.swing.JLabel lblTotalPrecio;
    private javax.swing.JTextField txtCantPersonas;
    private javax.swing.JFormattedTextField txtFechaIngreso;
    private javax.swing.JFormattedTextField txtFechaSalida;
    // End of variables declaration//GEN-END:variables
}
