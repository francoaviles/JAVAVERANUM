/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClRol;
import veranum.utilidades.OracleConection;

/**
 *
 * @author carlosdlg
 */
public class DAORol {
    private static final OracleConection bd = new OracleConection().Conectar();
    
    public static boolean sqlInsert(ClRol rol){
        String sql="INSERT INTO \"roles\" (\"nombre\", \"descripcion\") VALUES ('"+rol.getNombre()+"','"+rol.getDescripcion()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClRol rol){
        String sql="DELETE FROM \"roles\" WHERE \"nombre\" = '"+rol.getNombre()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    
    }
    
    public static boolean sqlUpdate(ClRol rol){
        String sql="UPDATE \"roles\" SET \"nombre\" = '"+rol.getNombre()+"', \"descripcion\" = '"+rol.getDescripcion()+"' WHERE \"nombre\" = '"+rol.getNombre()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static ClRol sqlLeer(int id){     
        ClRol rol = new ClRol();
        if(!bd.sqlSelect("SELECT * FROM \"roles\" WHERE \"id_rol\" ='"+id+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }
        rol.setIdRol(bd.getInt("id_rol"));
        rol.setNombre(bd.getString("nombre"));
        rol.setDescripcion(bd.getString("descripcion"));
        return rol;
    }
    
    public static ClRol sqlLeer(String name){     
        ClRol rol = new ClRol();
        if(!bd.sqlSelect("SELECT * FROM \"roles\" WHERE \"nombre\" ='"+name+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }
        rol.setIdRol(bd.getInt("id_rol"));
        rol.setNombre(bd.getString("nombre"));
        rol.setDescripcion(bd.getString("descripcion"));
        return rol;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClRol> rol = new ArrayList<>();
        if(!bd.sqlSelect("SELECT * FROM \"roles\"")){
            return null;
        }
        while(bd.sqlFetch()){
            rol.add(new ClRol(bd.getInt("id_rol")
                                    , bd.getString("nombre")
                                    , bd.getString("descripcion")
                                ));
            
        }     
        return rol;
    }
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClRol> rol = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"roles\" WHERE \"nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(bd.sqlFetch()){
            rol.add(new ClRol(bd.getInt("id_rol")
                                    , bd.getString("nombre")
                                    , bd.getString("descripcion")
                                ));
            
        }     
        return rol;
    }  
}
