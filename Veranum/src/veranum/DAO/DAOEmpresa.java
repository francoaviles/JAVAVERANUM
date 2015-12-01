/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import com.google.gson.Gson;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClEmpresa;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOEmpresa {
    public static boolean sqlInsert(ClEmpresa empresa) throws SQLException{
        String sql="INSERT INTO \"empresas\" (\"nombre\", \"descuento\") VALUES (?,?)";
        Log.create("INSERT",new Gson().toJson(empresa));
        
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, empresa.getNombre());
        a.setInt(2, empresa.getDescuento());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();
    }
    
    public static boolean sqlDelete(ClEmpresa empresa) throws SQLException{
        String sql="DELETE FROM \"empresas\" WHERE \"id_empresa\" = "+empresa.getIdEmpresa()+"";
          Log.create("DELETE",new Gson().toJson(empresa));
        return OracleConection.getInstance().sqlEjecutar(sql); 
    
    }
    
    public static boolean sqlUpdate(ClEmpresa empresa) throws SQLException{
        String sql="UPDATE \"empresas\" SET \"nombre\" = ?, \"descuento\" = ? WHERE \"id_empresa\" = ?";
        Log.create("UPDATE",new Gson().toJson(empresa));
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, empresa.getNombre());
        a.setInt(2, empresa.getDescuento());
        a.setInt(3, empresa.getIdEmpresa());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion(); 
    }
    
    public static ClEmpresa sqlLeer(int id){     
        ClEmpresa empresa = new ClEmpresa(); 
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"empresas\" WHERE \"id_empresa\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }
        empresa.setIdEmpresa(OracleConection.getInstance().getInt("id_empresa"));
        empresa.setNombre(OracleConection.getInstance().getString("nombre"));
        empresa.setDescuento(OracleConection.getInstance().getInt("descuento"));
        return empresa;
    }
    
    public static ClEmpresa sqlLeer(String name){     
        ClEmpresa empresa = new ClEmpresa(); 
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"empresas\" WHERE \"nombre\" ='"+name+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }
        empresa.setIdEmpresa(OracleConection.getInstance().getInt("id_empresa"));
        empresa.setNombre(OracleConection.getInstance().getString("nombre"));
        empresa.setDescuento(OracleConection.getInstance().getInt("descuento"));
        return empresa;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClEmpresa> empresa = new ArrayList<>();
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"empresas\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            empresa.add(new ClEmpresa(OracleConection.getInstance().getInt("id_empresa")
                                    , OracleConection.getInstance().getString("nombre")
                                    , OracleConection.getInstance().getInt("descuento")
                                ));
            
        }     
        return empresa;
    }
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClEmpresa> empresa = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"empresas\" WHERE \"nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            empresa.add(new ClEmpresa(OracleConection.getInstance().getInt("id_empresa")
                                    , OracleConection.getInstance().getString("nombre")
                                    , OracleConection.getInstance().getInt("descuento")
                                ));
            
        }     
        return empresa;
    }  
}
