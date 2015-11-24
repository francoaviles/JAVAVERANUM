/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClRol;
import veranum.utilidades.OracleConection;

/**
 *
 * @author carlosdlg
 */
public class DAORol {
    public static boolean sqlInsert(ClRol rol) throws SQLException{
        String sql="INSERT INTO \"roles\" (\"nombre\", \"descripcion\") VALUES (?,?)";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, rol.getNombre());
        a.setString(2, rol.getDescripcion());
        OracleConection.getInstance().sqlEjecutarPreparacion();
        return true;
    }
    
    public static boolean sqlDelete(ClRol rol){
        String sql="DELETE FROM \"roles\" WHERE \"id_rol\" = "+rol.getIdRol()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    
    }
    
    public static boolean sqlUpdate(ClRol rol){
        String sql="UPDATE \"roles\" SET \"nombre\" = '"+rol.getNombre()+"', \"descripcion\" = '"+rol.getDescripcion()+"' WHERE \"id_rol\" = "+rol.getIdRol()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static ClRol sqlLeer(int id){     
        ClRol rol = new ClRol();
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"roles\" WHERE \"id_rol\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }
        rol.setIdRol(OracleConection.getInstance().getInt("id_rol"));
        rol.setNombre(OracleConection.getInstance().getString("nombre"));
        rol.setDescripcion(OracleConection.getInstance().getString("descripcion"));
        return rol;
    }
    
    public static ClRol sqlLeer(String name){     
        ClRol rol = new ClRol();
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"roles\" WHERE \"nombre\" ='"+name+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }
        rol.setIdRol(OracleConection.getInstance().getInt("id_rol"));
        rol.setNombre(OracleConection.getInstance().getString("nombre"));
        rol.setDescripcion(OracleConection.getInstance().getString("descripcion"));
        return rol;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClRol> rol = new ArrayList<>();
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"roles\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            rol.add(new ClRol(OracleConection.getInstance().getInt("id_rol")
                                    , OracleConection.getInstance().getString("nombre")
                                    , OracleConection.getInstance().getString("descripcion")
                                ));
            
        }     
        return rol;
    }
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClRol> rol = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"roles\" WHERE \"nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            rol.add(new ClRol(OracleConection.getInstance().getInt("id_rol")
                                    , OracleConection.getInstance().getString("nombre")
                                    , OracleConection.getInstance().getString("descripcion")
                                ));
            
        }     
        return rol;
    }
}
