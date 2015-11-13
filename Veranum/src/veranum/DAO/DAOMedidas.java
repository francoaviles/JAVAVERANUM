/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClMedidas;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOMedidas {
    public static boolean sqlInsert(ClMedidas medida){
        String sql="INSERT INTO \"medidas\" (\"medida\") VALUES ('"+medida.getMedida()+"')";
        OracleConection.getInstance().sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClMedidas medida){
        String sql="DELETE FROM \"medidas\" WHERE \"id_medida\" = "+medida.getIdMedida()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClMedidas medida){
        String sql="UPDATE \"medidas\" SET \"medida\" = '"+medida.getMedida()+"' WHERE \"id_medida\" = "+medida.getIdMedida()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
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
