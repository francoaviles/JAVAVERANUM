/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import javax.swing.JButton;
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
    
    /*
    public void txtRutKeyTyped(java.awt.event.KeyEvent evt) {                                
        if(!((int)evt.getKeyChar() >= 48 && (int)evt.getKeyChar() <= 57))
        {
            evt.consume();
        } 
    }                               

    public void txtEdadKeyTyped(java.awt.event.KeyEvent evt) {                                 
        if(!((int)evt.getKeyChar() >= 48 && (int)evt.getKeyChar() <= 57))
        {
            evt.consume();
        } 
    } 
    */
    
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
    
    /*
    public void leerTodos(){       
        ArrayList cli = DAOCliente.sqlLeerTodos();
        dt =  (DefaultTableModel) grDatos.getModel();        
        for (int i = dt.getRowCount() -1; i >= 0; i--){  
            dt.removeRow(i);
        }        
        for(int x=0; x < cli.size(); x++){
            ClCliente xx = (ClCliente)cli.get(x);
            Object[] fila = new Object[7];
            fila[0]= xx.getRut();
            fila[1] = xx.getDv();
            fila[2] = xx.getNombre();
            fila[3] = xx.getApePaterno();
            fila[4] = xx.getApeMaterno();
            fila[5] = xx.getDireccion();
            fila[6] = xx.getEdad();                            
            dt.addRow(fila);             
         } 
        habilita( grDatos, false);
    }
    * */
}
