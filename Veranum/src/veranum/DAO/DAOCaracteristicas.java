/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClCaracteristicas;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOCaracteristicas {
    public static boolean sqlInsert(ClCaracteristicas carac){
        String sql="INSERT INTO \"caracteristicas\" (\"id_tipo_caract\", \"cantidad\", \"tipo\") VALUES ('"+carac.getIdTipoCaract()+"', '"+carac.getCantidad()+"', '"+carac.getTipo()+"')";
        OracleConection.getInstance().sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClCaracteristicas carac){
        String sql="DELETE FROM \"caracteristicas\" WHERE \"id_caracteristica\" = "+carac.getIdCaracteristica()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClCaracteristicas carac){
        String sql="UPDATE \"caracteristicas\" SET \"id_tipo_caract\" = '"+carac.getIdTipoCaract()+"', \"cantidad\" = '"+carac.getCantidad()+"' , \"tipo\" = '"+carac.getTipo()+"' WHERE \"id_caracteristica\" = "+carac.getIdCaracteristica()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
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
    /*
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClCaracteristicas> carac = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"caracteristica\" WHERE \"carac\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            carac.add(new ClCaracteristicas(OracleConection.getInstance().getInt("id_caracteristicao")
                                    , OracleConection.getInstance().getInt("id_tipo_caract")
                                    , OracleConection.getInstance().getInt("cantidad")
                                    , OracleConection.getInstance().getString("tipo")
                                ));
            
        }     
        return carac;
    }*/
}
