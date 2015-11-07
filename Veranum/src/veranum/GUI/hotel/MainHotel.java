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
import veranum.DAO.DAOCadenas;
import veranum.DAO.DAORegiones;
import veranum.DAO.DAOProvincia;
import veranum.DAO.DAOComuna;
import veranum.DAO.DAOHoteles;
import veranum.entities.ClCadenas;
import veranum.entities.ClComuna;
import veranum.entities.ClHoteles;
import veranum.entities.ClProvincia;
import veranum.entities.ClRegion;

/**
 *
 * @author Duoc
 */
public class MainHotel extends javax.swing.JInternalFrame {

    private boolean paraGrabar = false;
    private DefaultTableModel dt = new DefaultTableModel();
    private int id_hotel = 0;
    /**
     * Creates new form MainHotel
     */
    public MainHotel() {
        initComponents();
        //cbRegion.setModel(new DefaultComboBoxModel());
        for (Object item : DAORegiones.sqlLeerTodos()) {
            cbRegion.addItem(item);
        }
        for (Object item : DAOCadenas.sqlLeerTodos()) {
            cbCadena.addItem(item);
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

        tabContenido = new javax.swing.JTabbedPane();
        panelHoteles = new javax.swing.JPanel();
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
        panelHabitaciones = new javax.swing.JPanel();
        lbUbicacion = new javax.swing.JLabel();
        txtUbicacion = new javax.swing.JTextField();
        lbCantPersonas = new javax.swing.JLabel();
        txtCantPersonas = new javax.swing.JTextField();
        lbPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        lbTipo = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox();
        lbCaracteristicas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCaracteristicas = new javax.swing.JTextArea();
        btGrabarHabitaciones = new javax.swing.JButton();
        panelMuebles = new javax.swing.JPanel();
        lbNombreMueble = new javax.swing.JLabel();
        txtNombreMueble = new javax.swing.JTextField();
        cbEstadoMueble = new javax.swing.JComboBox();
        lbEstadoMueble = new javax.swing.JLabel();
        btGrabarMuebles = new javax.swing.JButton();
        panelBuscarHab = new javax.swing.JPanel();
        lbBuscarHab = new javax.swing.JLabel();
        txtBuscarHab = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBuscarHabitacion = new javax.swing.JTable();
        lbTipoBuscar = new javax.swing.JLabel();
        cbTipoBuscar = new javax.swing.JComboBox();
        btBuscarHabitacion = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Panel Hoteles"));
        setForeground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(557, 391));

        lbNombreHotel.setText("Nombre Hotel:");

        lbDireccion.setText("Dirección:");

        cbRegion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRegionItemStateChanged(evt);
            }
        });

        lbRegion.setText("Region:");

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
                "#", "Cadena", "Nombre", "Region", "Direccion"
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

        btDesactivarEditarHotel.setBackground(new java.awt.Color(255, 0, 0));
        btDesactivarEditarHotel.setText("Salir Modo Editar");
        btDesactivarEditarHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesactivarEditarHotelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHotelesLayout = new javax.swing.GroupLayout(panelHoteles);
        panelHoteles.setLayout(panelHotelesLayout);
        panelHotelesLayout.setHorizontalGroup(
            panelHotelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHotelesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHotelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbProvincia)
                    .addComponent(lbCadena)
                    .addGroup(panelHotelesLayout.createSequentialGroup()
                        .addComponent(lbDireccion)
                        .addGap(32, 32, 32)
                        .addGroup(panelHotelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCadena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelHotelesLayout.createSequentialGroup()
                        .addGroup(panelHotelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRegion)
                            .addComponent(lbNombreHotel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelHotelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelHotelesLayout.createSequentialGroup()
                                .addComponent(cbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbComuna)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNombreHotel)))
                    .addComponent(btGrabarHoteles, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(201, Short.MAX_VALUE))
            .addGroup(panelHotelesLayout.createSequentialGroup()
                .addComponent(btEliminarHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btEditarHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(txtBuscarHotel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBuscarHotel)
                .addGap(3, 3, 3)
                .addComponent(btBuscarTodosHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHotelesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btDesactivarEditarHotel))
        );
        panelHotelesLayout.setVerticalGroup(
            panelHotelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHotelesLayout.createSequentialGroup()
                .addGroup(panelHotelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btEliminarHotel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btBuscarHotel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEditarHotel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscarHotel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btBuscarTodosHotel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btDesactivarEditarHotel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHotelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombreHotel)
                    .addComponent(txtNombreHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelHotelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRegion)
                    .addComponent(cbRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelHotelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProvincia)
                    .addComponent(cbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbComuna)
                    .addComponent(cbComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHotelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHotelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCadena)
                    .addComponent(cbCadena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btGrabarHoteles)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        tabContenido.addTab("Hoteles", panelHoteles);

        lbUbicacion.setText("Ubicación:");

        lbCantPersonas.setText("Cantidad de Personas:");

        lbPrecio.setText("Precio:");

        lbTipo.setText("Tipo:");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbCaracteristicas.setText("Caracteristicas:");

        txtCaracteristicas.setColumns(20);
        txtCaracteristicas.setRows(5);
        jScrollPane1.setViewportView(txtCaracteristicas);

        btGrabarHabitaciones.setText("Grabar");

        javax.swing.GroupLayout panelHabitacionesLayout = new javax.swing.GroupLayout(panelHabitaciones);
        panelHabitaciones.setLayout(panelHabitacionesLayout);
        panelHabitacionesLayout.setHorizontalGroup(
            panelHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHabitacionesLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(panelHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelHabitacionesLayout.createSequentialGroup()
                        .addComponent(lbUbicacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelHabitacionesLayout.createSequentialGroup()
                        .addGroup(panelHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPrecio)
                            .addComponent(lbTipo)
                            .addComponent(lbCaracteristicas)
                            .addComponent(lbCantPersonas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(panelHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(63, 63, 63))
            .addGroup(panelHabitacionesLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(btGrabarHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHabitacionesLayout.setVerticalGroup(
            panelHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHabitacionesLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(panelHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUbicacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCantPersonas))
                .addGap(18, 18, 18)
                .addGroup(panelHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCaracteristicas)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btGrabarHabitaciones)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        tabContenido.addTab("Habitaciones", panelHabitaciones);

        lbNombreMueble.setText("Nombre Mueble:");

        cbEstadoMueble.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbEstadoMueble.setText("Estado Mueble:");

        btGrabarMuebles.setText("Grabar");

        javax.swing.GroupLayout panelMueblesLayout = new javax.swing.GroupLayout(panelMuebles);
        panelMuebles.setLayout(panelMueblesLayout);
        panelMueblesLayout.setHorizontalGroup(
            panelMueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMueblesLayout.createSequentialGroup()
                .addGroup(panelMueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMueblesLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(panelMueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNombreMueble)
                            .addComponent(lbEstadoMueble))
                        .addGap(62, 62, 62)
                        .addGroup(panelMueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbEstadoMueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreMueble, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelMueblesLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btGrabarMuebles, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        panelMueblesLayout.setVerticalGroup(
            panelMueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMueblesLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(panelMueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNombreMueble)
                    .addComponent(txtNombreMueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelMueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEstadoMueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEstadoMueble))
                .addGap(35, 35, 35)
                .addComponent(btGrabarMuebles)
                .addContainerGap(244, Short.MAX_VALUE))
        );

        tabContenido.addTab("Muebles", panelMuebles);

        lbBuscarHab.setText("Habitación:");

        tableBuscarHabitacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableBuscarHabitacion);

        lbTipoBuscar.setText("Tipo:");

        cbTipoBuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btBuscarHabitacion.setText("Buscar");

        javax.swing.GroupLayout panelBuscarHabLayout = new javax.swing.GroupLayout(panelBuscarHab);
        panelBuscarHab.setLayout(panelBuscarHabLayout);
        panelBuscarHabLayout.setHorizontalGroup(
            panelBuscarHabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarHabLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panelBuscarHabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBuscarHabLayout.createSequentialGroup()
                        .addGroup(panelBuscarHabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbBuscarHab)
                            .addComponent(lbTipoBuscar))
                        .addGap(49, 49, 49)
                        .addGroup(panelBuscarHabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTipoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscarHab, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscarHabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btBuscarHabitacion)
                .addGap(126, 126, 126))
        );
        panelBuscarHabLayout.setVerticalGroup(
            panelBuscarHabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarHabLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panelBuscarHabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBuscarHab)
                    .addComponent(txtBuscarHab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(btBuscarHabitacion)
                .addGap(1, 1, 1)
                .addGroup(panelBuscarHabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTipoBuscar)
                    .addComponent(cbTipoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );

        tabContenido.addTab("Buscar habitación", panelBuscarHab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabContenido, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabContenido)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDesactivarEditarHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesactivarEditarHotelActionPerformed
        this.paraGrabar = false;
        this.btnEditarMode();
    }//GEN-LAST:event_btDesactivarEditarHotelActionPerformed

    private void btEditarHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarHotelActionPerformed
        this.leerServicio(Formularios.getSelectedRow(grHotel));
        this.paraGrabar = true;
        this.btnEditarMode();
    }//GEN-LAST:event_btEditarHotelActionPerformed

    private void btEliminarHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarHotelActionPerformed
        this.leerServicio(Formularios.getSelectedRow(grHotel));
        if(this.id_hotel == 0){
            JOptionPane.showMessageDialog(this, "NO existe para eliminar");
        }else{
            DAOHoteles.sqlDelete(new ClHoteles(this.id_hotel));
            JOptionPane.showMessageDialog(this, "Eliminado");
            helper.Formularios.limpiar(panelHoteles);
            Formularios.DesactiveBotonesEliminarEditar(btEditarHotel, btEliminarHotel);
            this.leerTodos(true);
        }
    }//GEN-LAST:event_btEliminarHotelActionPerformed

    private void btBuscarTodosHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarTodosHotelActionPerformed
        this.leerTodos(true);
    }//GEN-LAST:event_btBuscarTodosHotelActionPerformed

    private void btBuscarHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarHotelActionPerformed
        this.leerTodos(false);
    }//GEN-LAST:event_btBuscarHotelActionPerformed

    private void grHotelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grHotelMouseClicked
        int row_dos = Formularios.getTablaSeleccionada(evt, grHotel, 2);

        if(row_dos >= 0){
            this.leerServicio(Integer.parseInt(grHotel.getValueAt(row_dos, 0).toString()));
            Formularios.ActiveBotonesEliminarEditar(btEditarHotel, btEliminarHotel);
            this.paraGrabar = true;
            this.btnEditarMode();
        } else {
            Formularios.ActiveBotonesEliminarEditar(btEditarHotel, btEliminarHotel);
        }
    }//GEN-LAST:event_grHotelMouseClicked

    private void btGrabarHotelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGrabarHotelesActionPerformed
        int id_cadena = ((ClCadenas)cbCadena.getSelectedItem()).getIdCadena();
        int id_region = ((ClRegion)cbRegion.getSelectedItem()).getIdRegion();
        int id_provi = ((ClProvincia)cbProvincia.getSelectedItem()).getIdProvincia();
        int id_comu = ((ClComuna)cbComuna.getSelectedItem()).getIdComuna();
        System.out.println(id_region);
        if(!paraGrabar){
            if(false ){ // validacion
            JOptionPane.showMessageDialog(this, "Ingrese los Datos");
            }else{
                DAOHoteles.sqlInsert(new ClHoteles( id_cadena, 
                                                    id_region, 
                                                    id_provi, 
                                                    id_comu, 
                                                    txtNombreHotel.getText(), 
                                                    txtDireccion.getText())
                                    );
                JOptionPane.showMessageDialog(this, "Agregado");
                Formularios.DesactiveBotonesEliminarEditar(btEditarHotel, btEliminarHotel);
                helper.Formularios.limpiar(panelHoteles);
                this.leerTodos(true);
            }  
        }else{
            DAOHoteles.sqlUpdate(new ClHoteles( this.id_hotel,
                                                id_cadena, 
                                                id_region, 
                                                id_provi, 
                                                id_comu, 
                                                txtNombreHotel.getText(), 
                                                txtDireccion.getText()));
            
            JOptionPane.showMessageDialog(this, "Modificado");
            Formularios.DesactiveBotonesEliminarEditar(btEditarHotel, btEliminarHotel);
            helper.Formularios.limpiar(panelHoteles);
            this.leerTodos(true);
            this.paraGrabar = false;
        }      
    }//GEN-LAST:event_btGrabarHotelesActionPerformed

    private void cbProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProvinciaItemStateChanged
        // TODO add your handling code here:
        cbComuna.removeAllItems();
        this.cargarComunas();
    }//GEN-LAST:event_cbProvinciaItemStateChanged

    private void cbRegionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRegionItemStateChanged
        // TODO add your handling code here:
        cbProvincia.removeAllItems();
        this.cargarProvincias();
        this.cargarComunas();
    }//GEN-LAST:event_cbRegionItemStateChanged

    private void cargarProvincias(){
        int id_region = ((ClRegion)cbRegion.getSelectedItem()).getIdRegion();
        for (Object item : DAOProvincia.sqlPorRegion(id_region)) {
            cbProvincia.addItem(item);
        }
    }
    
    private void cargarComunas(){
        if(cbProvincia.getSelectedItem() != null) {
            int id_provincia = ((ClProvincia)cbProvincia.getSelectedItem()).getIdProvincia();
            for (Object item : DAOComuna.sqlPorProvincia(id_provincia)) {
                cbComuna.addItem(item);
            }
        }
    }
    // Method Custom
    private void leerServicio(int id){
        this.id_hotel = id;
        ClHoteles hotel = DAOHoteles.sqlLeer(id);
        txtNombreHotel.setText(hotel.getNombre());
        txtDireccion.setText(hotel.getDireccion());
    }
    
    private void leerTodos(boolean todos){
        ArrayList ser = new ArrayList<>();
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
            helper.Formularios.limpiar(panelHoteles);
        } else {
            btDesactivarEditarHotel.setVisible(true);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarHabitacion;
    private javax.swing.JButton btBuscarHotel;
    private javax.swing.JButton btBuscarTodosHotel;
    private javax.swing.JButton btDesactivarEditarHotel;
    private javax.swing.JButton btEditarHotel;
    private javax.swing.JButton btEliminarHotel;
    private javax.swing.JButton btGrabarHabitaciones;
    private javax.swing.JButton btGrabarHoteles;
    private javax.swing.JButton btGrabarMuebles;
    private javax.swing.JComboBox cbCadena;
    private javax.swing.JComboBox cbComuna;
    private javax.swing.JComboBox cbEstadoMueble;
    private javax.swing.JComboBox cbProvincia;
    private javax.swing.JComboBox cbRegion;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JComboBox cbTipoBuscar;
    private javax.swing.JTable grHotel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbBuscarHab;
    private javax.swing.JLabel lbCadena;
    private javax.swing.JLabel lbCantPersonas;
    private javax.swing.JLabel lbCaracteristicas;
    private javax.swing.JLabel lbComuna;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbEstadoMueble;
    private javax.swing.JLabel lbNombreHotel;
    private javax.swing.JLabel lbNombreMueble;
    private javax.swing.JLabel lbPrecio;
    private javax.swing.JLabel lbProvincia;
    private javax.swing.JLabel lbRegion;
    private javax.swing.JLabel lbTipo;
    private javax.swing.JLabel lbTipoBuscar;
    private javax.swing.JLabel lbUbicacion;
    private javax.swing.JPanel panelBuscarHab;
    private javax.swing.JPanel panelHabitaciones;
    private javax.swing.JPanel panelHoteles;
    private javax.swing.JPanel panelMuebles;
    private javax.swing.JTabbedPane tabContenido;
    private javax.swing.JTable tableBuscarHabitacion;
    private javax.swing.JTextField txtBuscarHab;
    private javax.swing.JTextField txtBuscarHotel;
    private javax.swing.JTextField txtCantPersonas;
    private javax.swing.JTextArea txtCaracteristicas;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombreHotel;
    private javax.swing.JTextField txtNombreMueble;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtUbicacion;
    // End of variables declaration//GEN-END:variables
}
