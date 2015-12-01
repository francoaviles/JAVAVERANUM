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
import veranum.entities.ClMedidas;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOMedidas {
    public static boolean sqlInsert(ClMedidas medida) throws SQLException{
        String sql="INSERT INTO \"medidas\" (\"medida\") VALUES (?)";
        Log.create("INSERT",new Gson().toJson(medida));
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, medida.getMedida());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();
    }
    
    public static boolean sqlDelete(ClMedidas medida) throws SQLException{
        String sql="DELETE FROM \"medidas\" WHERE \"id_medida\" = "+medida.getIdMedida()+"";
        Log.create("DELETE",new Gson().toJson(medida)); 
        return OracleConection.getInstance().sqlEjecutar(sql);  
    }
    
    public static boolean sqlUpdate(ClMedidas medida) throws SQLException{
        String sql="UPDATE \"medidas\" SET \"medida\" = ? WHERE \"id_medida\" = ?";
        Log.create("UPDATE",new Gson().toJson(medida)); 
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, medida.getMedida());
        a.setInt(2, medida.getIdMedida());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();  
    }
    
    public static ClMedidas sqlLeer(String name){     
        ClMedidas medida = new ClMedidas();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"medidas\" WHERE \"medida\" ='"+name+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        medida.setIdMedida(OracleConection.getInstance().getInt("id_medida"));
        medida.setMedida(OracleConection.getInstance().getString("medida"));
        return medida;
    }
    
    public static ClMedidas sqlLeer(int id){     
        ClMedidas medida = new ClMedidas();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"medidas\" WHERE \"id_medida\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        medida.setIdMedida(OracleConection.getInstance().getInt("id_medida"));
        medida.setMedida(OracleConection.getInstance().getString("medida"));
        return medida;
    }
    
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClMedidas> medida = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"medidas\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            medida.add(new ClMedidas(OracleConection.getInstance().getInt("id_medida")
                                    , OracleConection.getInstance().getString("medida")
                                ));
            
        }     
        return medida;
    }    
    
    public static ArrayList sqlBuscarByNombre(String name){
        ArrayList<ClMedidas> medida = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"medidas\" WHERE \"medida\" LIKE '%"+name+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            medida.add(new ClMedidas(OracleConection.getInstance().getInt("id_medidao")
                                    , OracleConection.getInstance().getString("medida")
                                ));
            
        }     
        return medida;
    }
}
