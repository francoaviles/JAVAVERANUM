    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;

/**
 *
 * @author Duoc
 */
public class Formularios {
    public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    
    public static void limpiar(JComponent obj){
        Object[] arrObj = obj.getComponents();
        for(int x = 0; x< arrObj.length ; x++){
            if(arrObj[x] instanceof JTextField)
            {
                JTextField ii = (JTextField)arrObj[x];
                ii.setText("");                
            } 
            
            if(arrObj[x] instanceof JTextArea){
                JTextArea xx = (JTextArea)arrObj[x];
                xx.setText("");
            }
            

            if(arrObj[x] instanceof JScrollPane)
            {
                Object[] sad = ((JScrollPane)arrObj[x]).getComponents();
                for(int i = 0; i< sad.length ; i++){
                    if(sad[i] instanceof JViewport) {
                        Component o = ((JViewport)sad[i]).getView();
                        if(o instanceof JTextArea){
                            JTextArea xx = (JTextArea)o;
                            xx.setText("");
                        }
                    }      
                }
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
    
    public static void validarRut(java.awt.event.KeyEvent evt)
    {
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') ||  (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == 'k') )) {
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
    
    public static int getSelectedRow2(javax.swing.JTable tabla, int columna){
        return Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), columna).toString());
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

    public static Date deStringAFecha(String fecha){
        Date d = new Date();
        try {
           d = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
        }
        catch (ParseException pe) {
            System.out.println("fecha invalida");
        }
        return d;
    }
    
    public static String deFechaToString(Date fecha){
        String dia_ = "";
        String mes_ = "";
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        int dia = cal.get(Calendar.DATE);
        int mes = (cal.get(Calendar.MONTH) + 1);
        int ano = cal.get(Calendar.YEAR);
        
        if(dia <= 9)
            dia_ = "0" + dia;
        else 
            dia_ = "" + dia;
            
        if(mes <= 9)
            mes_ = "0" + mes;
        else 
            mes_ = "" + mes;
        
        String formatedDate = dia_ + "/" + mes_ + "/" + ano;
        System.out.println(formatedDate);
        return formatedDate;    
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
