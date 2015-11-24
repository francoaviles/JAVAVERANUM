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
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public static SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void limpiar(JComponent obj, String excepto){
        Object[] arrObj = obj.getComponents();
        for(int x = 0; x< arrObj.length ; x++){
            if(arrObj[x] instanceof JTextField)
            {
                JTextField ii = (JTextField)arrObj[x];
                if(!"rut".equals(ii.getName()))
                    ii.setText("");                
            } 
            
            if(arrObj[x] instanceof JTextArea){
                JTextArea xx = (JTextArea)arrObj[x];
                 if(!"rut".equals(xx.getName()))
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
                             if(!"rut".equals(xx.getName()))
                            xx.setText("");
                        }
                    }      
                }
            } 
        }
        
    }
    
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
    
    public static void limpiarTxt(Component component) {
        if (component instanceof JTextField) {
            JTextField text = (JTextField) component;
            text.setText("");
        }
    }
    
    public static boolean validarRut(String rut) 
    {
        boolean validacion = false;
        try {
            rut =  rut.toUpperCase();

            rut = rut.replace(".", "");
            rut = rut.replace("-", "");

            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {} 
        catch (Exception e) {}
        
        return validacion;
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
        return formatedDate;    
    }
    
    public static long diasBetweenFechas(String fecha1, String fecha2){
        try {
            Date date1 = myFormat.parse(fecha1);
            Date date2 = myFormat.parse(fecha2);
            long diff = date2.getTime() - date1.getTime();
            long dias =  TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            return dias;
        } catch (ParseException ex) {
            Logger.getLogger(Formularios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
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
