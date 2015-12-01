/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClCaracteristicas;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOCaracteristicas {
    public static boolean sqlInsert(ClCaracteristicas carac) throws SQLException{
        String sql="INSERT INTO \"caracteristicas\" (\"id_tipo_caract\", \"cantidad\", \"tipo\") VALUES (?,?,?)";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setInt(1, carac.getIdTipoCaract());
        a.setInt(2, carac.getCantidad());
        a.setString(3, carac.getTipo());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();
    }
    
    public static boolean sqlDelete(ClCaracteristicas carac){
        String sql="DELETE FROM \"caracteristicas\" WHERE \"id_caracteristica\" = "+carac.getIdCaracteristica()+"";   
        return OracleConection.getInstance().sqlEjecutar(sql);
    }
    
    public static boolean sqlUpdate(ClCaracteristicas carac) throws SQLException{
        String sql="UPDATE \"caracteristicas\" SET \"id_tipo_caract\" = ?, \"cantidad\" = ?, \"tipo\" = ? WHERE \"id_caracteristica\" = ?";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setInt(1, carac.getIdTipoCaract());
        a.setInt(2, carac.getCantidad());
        a.setString(3, carac.getTipo());
        a.setInt(4, carac.getIdCaracteristica());
         
        return OracleConection.getInstance().sqlEjecutarPreparacion();
    }
      
    public static ClCaracteristicas sqlLeer(int id){     
        ClCaracteristicas carac = new ClCaracteristicas();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"caracteristicas\" WHERE \"id_caracteristica\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        carac.setIdCaracteristica(OracleConection.getInstance().getInt("id_caracteristica"));
        carac.setIdTipoCaract(OracleConection.getInstance().getInt("id_tipo_caract"));
        carac.setCantidad(OracleConection.getInstance().getInt("cantidad"));
        carac.setTipo(OracleConection.getInstance().getString("tipo"));
        return carac;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClCaracteristicas> carac = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"caracteristicas\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            carac.add(new ClCaracteristicas(OracleConection.getInstance().getInt("id_caracteristica")
                                    , OracleConection.getInstance().getInt("id_tipo_caract")
                                    , OracleConection.getInstance().getInt("cantidad")
                                    , OracleConection.getInstance().getString("tipo")
                                ));
            
        }     
        return carac;
    }    
    
    public static ArrayList sqlLeerTodosByTipo(String tipo){
        ArrayList<ClCaracteristicas> carac = new ArrayList<>();      
        String sql = "";
        if("hotel".equals(tipo))
            sql = "SELECT * \n" +
                "FROM \"caracteristicas\"\n" +
                "LEFT JOIN \"tipo_caracteristicas\" ON  \"tipo_caracteristicas\".\"id_tipo_caract\" = \"caracteristicas\".\"id_tipo_caract\"\n" +
                "WHERE \"caracteristicas\".\"tipo\" = 'Hotel'";
        else 
            sql = "SELECT * \n" +
                "FROM \"caracteristicas\"\n" +
                "LEFT JOIN \"tipo_caracteristicas\" ON  \"tipo_caracteristicas\".\"id_tipo_caract\" = \"caracteristicas\".\"id_tipo_caract\"\n" +
                "WHERE \"caracteristicas\".\"tipo\" = 'Habitación'";
        
        if(!OracleConection.getInstance().sqlSelect(sql)){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            carac.add(new ClCaracteristicas(OracleConection.getInstance().getInt("id_caracteristica")
                                    , OracleConection.getInstance().getInt("id_tipo_caract")
                                    , OracleConection.getInstance().getInt("cantidad")
                                    , OracleConection.getInstance().getString("tipo")
                                    , OracleConection.getInstance().getString("nombre")
                                    , OracleConection.getInstance().getString("descripcion")
                                ));
            
        }     
        return carac;
    } 
    
    public static ArrayList sqlBuscarByNombre(String tipo){
        ArrayList<ClCaracteristicas> carac = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"caracteristicas\" WHERE \"tipo\" LIKE '%"+tipo+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            carac.add(new ClCaracteristicas(OracleConection.getInstance().getInt("id_caracteristica")
                                    , OracleConection.getInstance().getInt("id_tipo_caract")
                                    , OracleConection.getInstance().getInt("cantidad")
                                    , OracleConection.getInstance().getString("tipo")
                                ));
            
        }     
        return carac;
    }
}
