/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClCadenas;
import veranum.utilidades.OracleConection;

/**
 *
 * @author carlosdlg
 */
public class DAOCadenas {
    public static boolean sqlInsert(ClCadenas cadenas) throws SQLException{
        String sql="INSERT INTO \"cadenas\" (\"nombre\") VALUES (?)";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, cadenas.getNombre());
        OracleConection.getInstance().sqlEjecutarPreparacion();
        return true;
    }
    
    public static boolean sqlDelete(ClCadenas cadenas){
        String sql="DELETE FROM \"cadenas\" WHERE \"nombre\" = '"+cadenas.getNombre()+"'";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClCadenas cadenas) throws SQLException{
        String sql="UPDATE \"cadenas\" SET \"nombre\" = ? WHERE \"id_cadena\" = ?";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, cadenas.getNombre());
        a.setInt(2, cadenas.getIdCadena());
        OracleConection.getInstance().sqlEjecutarPreparacion();   
        return true;
    }
    
    public static ClCadenas sqlLeer(String name){     
        ClCadenas servicio = new ClCadenas();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"cadenas\" WHERE \"nombre\" ='"+name+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        servicio.setIdCadena(OracleConection.getInstance().getInt("id_cadena"));
        servicio.setNombre(OracleConection.getInstance().getString("nombre"));
        return servicio;
    }
    
    public static ClCadenas sqlLeer(int id){     
        ClCadenas servicio = new ClCadenas();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"cadenas\" WHERE \"id_cadena\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        servicio.setIdCadena(OracleConection.getInstance().getInt("id_cadena"));
        servicio.setNombre(OracleConection.getInstance().getString("nombre"));
        return servicio;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClCadenas> cadena = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"cadenas\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            cadena.add(new ClCadenas(OracleConection.getInstance().getInt("id_cadena")
                                    , OracleConection.getInstance().getString("nombre")
                                ));
            
        }     
        return cadena;
    }    
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClCadenas> cadena = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"cadenas\" WHERE \"nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            cadena.add(new ClCadenas(OracleConection.getInstance().getInt("id_servicio")
                                    , OracleConection.getInstance().getString("nombre")
                                ));
            
        }     
        return cadena;
    }  
}
