/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Duoc
 */
public class Formularios {
    public static void limpiar(JComponent obj)
    {
        Object[] arrObj = obj.getComponents();
        for(int x = 0; x< arrObj.length ; x++){
            if(arrObj[x] instanceof JTextField)
            {
                JTextField ii = (JTextField)arrObj[x];
                ii.setText("");                
            }else
                if(arrObj[x] instanceof JTextField)
                {
                    ((JButton)arrObj[x]).setText("");
                }
        }
        
    }
    
    public static void soloNumeros(java.awt.event.KeyEvent evt)
    {
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') ||  (c == KeyEvent.VK_BACK_SPACE) ||   (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        } 
    }
    
    public static int getTablaSeleccionada(java.awt.event.MouseEvent evt,javax.swing.JTable tabla, int cantClicks){
        int index = -1;
        if(evt.getClickCount() == cantClicks ) {
            if (tabla.getRowCount() > 0) {
                if (tabla.getSelectedRowCount() > 0) {
                    index = tabla.getSelectedRow();
                }
            }
        }
        return index;
    }
    
    public static int getSelectedRow(javax.swing.JTable tabla){
        return Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
    }
    
    public static void ActiveBotonesEliminarEditar(javax.swing.JButton edit, javax.swing.JButton delete){
        edit.setEnabled(true);
        delete.setEnabled(true);
    } 
    
    public static void DesactiveBotonesEliminarEditar(javax.swing.JButton edit, javax.swing.JButton delete){
        edit.setEnabled(false);
        delete.setEnabled(false);
    } 
    
    public static void triggerBotonesEliminarEditar(javax.swing.JButton edit, javax.swing.JButton delete){
        if(edit.isEnabled() && delete.isEnabled()){
            edit.setEnabled(false);
            delete.setEnabled(false);
        } else  {
            edit.setEnabled(true);
            delete.setEnabled(true);
        }
    } 

    
    public static void habilita(JComponent obj, boolean sw)
    {
        Object[] arrObj = obj.getComponents();
        for(int x = 0; x< arrObj.length ; x++){
            if(arrObj[x] instanceof JTextField)
            {
                
                ((JTextField)arrObj[x]).setEnabled(sw);
                              
            }else
                if(arrObj[x] instanceof JTextField)
                {
                    ((JButton)arrObj[x]).setEnabled(sw);
                }
        }
        
    } 
}
