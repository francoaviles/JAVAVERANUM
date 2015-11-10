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
    private static final OracleConection bd = new OracleConection().Conectar();
    
    public static boolean sqlInsert(ClCaracteristicas carac){
        String sql="INSERT INTO \"caracteristica\" (\"id_tipo_carac\", \"cantidad\", \"tipo\") VALUES ('"+carac.getIdTipoCaract()+"', '"+carac.getCantidad()+"', '"+carac.getTipo()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClCaracteristicas carac){
        String sql="DELETE FROM \"caracteristica\" WHERE \"id_caracteristica\" = "+carac.getIdCaracteristica()+"";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClCaracteristicas carac){
        String sql="UPDATE \"caracteristica\" SET \"id_tipo_carac\" = '"+carac.getIdTipoCaract()+"', \"cantidad\" = '"+carac.getCantidad()+"' , \"tipo\" = '"+carac.getTipo()+"' WHERE \"id_caracteristica\" = "+carac.getIdCaracteristica()+"";
        bd.sqlEjecutar(sql);   
        return true;
    }
      
    public static ClCaracteristicas sqlLeer(int id){     
        ClCaracteristicas carac = new ClCaracteristicas();        
        if(!bd.sqlSelect("SELECT * FROM \"caracteristica\" WHERE \"id_caracteristica\" ='"+id+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        carac.setIdCaracteristica(bd.getInt("id_caracteristica"));
        carac.setIdTipoCaract(bd.getInt("id_tipo_caract"));
        carac.setCantidad(bd.getInt("cantidad"));
        carac.setTipo(bd.getString("tipo"));
        return carac;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClCaracteristicas> carac = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"caracteristica\"")){
            return null;
        }
        while(bd.sqlFetch()){
            carac.add(new ClCaracteristicas(bd.getInt("id_caracteristicao")
                                    , bd.getInt("id_tipo_caract")
                                    , bd.getInt("cantidad")
                                    , bd.getString("tipo")
                                ));
            
        }     
        return carac;
    }    
    /*
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClCaracteristicas> carac = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"caracteristica\" WHERE \"carac\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(bd.sqlFetch()){
            carac.add(new ClCaracteristicas(bd.getInt("id_caracteristicao")
                                    , bd.getInt("id_tipo_caract")
                                    , bd.getInt("cantidad")
                                    , bd.getString("tipo")
                                ));
            
        }     
        return carac;
    }*/
}
