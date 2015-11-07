/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClCadenas;
import veranum.utilidades.OracleConection;

/**
 *
 * @author carlosdlg
 */
public class DAOCadenas {
    private static final OracleConection bd = new OracleConection().Conectar();
    
    public static boolean sqlInsert(ClCadenas cadenas){
        String sql="INSERT INTO \"cadenas\" (\"nombre\") VALUES ('"+cadenas.getNombre()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClCadenas cadenas){
        String sql="DELETE FROM \"cadenas\" WHERE \"nombre\" = '"+cadenas.getNombre()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClCadenas cadenas)
    {
        String sql="UPDATE \"cadenas\" SET \"nombre\" = '"+cadenas.getNombre()+"' WHERE \"id_cadena\" = '"+cadenas.getIdCadena()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static ClCadenas sqlLeer(String name){     
        ClCadenas servicio = new ClCadenas();        
        if(!bd.sqlSelect("SELECT * FROM \"cadenas\" WHERE \"nombre\" ='"+name+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        servicio.setIdCadena(bd.getInt("id_cadena"));
        servicio.setNombre(bd.getString("nombre"));
        return servicio;
    }
    
    public static ClCadenas sqlLeer(int id){     
        ClCadenas servicio = new ClCadenas();        
        if(!bd.sqlSelect("SELECT * FROM \"cadenas\" WHERE \"id_cadena\" ='"+id+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        servicio.setIdCadena(bd.getInt("id_cadena"));
        servicio.setNombre(bd.getString("nombre"));
        return servicio;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClCadenas> cadena = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"cadenas\"")){
            return null;
        }
        while(bd.sqlFetch()){
            cadena.add(new ClCadenas(bd.getInt("id_cadena")
                                    , bd.getString("nombre")
                                ));
            
        }     
        return cadena;
    }    
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClCadenas> cadena = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"cadenas\" WHERE \"nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(bd.sqlFetch()){
            cadena.add(new ClCadenas(bd.getInt("id_servicio")
                                    , bd.getString("nombre")
                                ));
            
        }     
        return cadena;
    }  
}
