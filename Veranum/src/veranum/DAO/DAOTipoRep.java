/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClTipoReportes;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOTipoRep {
    private static final OracleConection bd = new OracleConection().Conectar();
    
    public static boolean sqlInsert(ClTipoReportes rep){
        String sql="INSERT INTO \"tipo_reportes\" (\"nombre\", \"descripcion\") VALUES ('"+rep.getNombre()+"', '"+rep.getDescripcion()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClTipoReportes rep){
        String sql="DELETE FROM \"tipo_reportes\" WHERE \"id_tipo_reporte\" = "+rep.getIdTipoReporte()+"";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClTipoReportes rep){
        String sql="UPDATE \"tipo_reportes\" SET \"nombre\" = '"+rep.getNombre()+"', \"descripcion\" = '"+rep.getDescripcion()+"' WHERE \"id_tipo_reporte\" = "+rep.getIdTipoReporte()+"";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static ClTipoReportes sqlLeer(String name){     
        ClTipoReportes rep = new ClTipoReportes();        
        if(!bd.sqlSelect("SELECT * FROM \"tipo_reportes\" WHERE \"nombre\" ='"+name+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        rep.setIdTipoReporte(bd.getInt("id_tipo_reporte"));
        rep.setNombre(bd.getString("nombre"));
        rep.setDescripcion(bd.getString("descripcion"));
        return rep;
    }
    
    public static ClTipoReportes sqlLeer(int id){     
        ClTipoReportes rep = new ClTipoReportes();        
        if(!bd.sqlSelect("SELECT * FROM \"tipo_reportes\" WHERE \"ud_tipo_reporte\" ='"+id+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        rep.setIdTipoReporte(bd.getInt("id_tipo_reporte"));
        rep.setNombre(bd.getString("nombre"));
        rep.setDescripcion(bd.getString("descripcion"));
        return rep;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClTipoReportes> rep = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"tipo_reportes\"")){
            return null;
        }
        while(bd.sqlFetch()){
            rep.add(new ClTipoReportes(bd.getInt("id_tipo_reporte")
                                    , bd.getString("nombre")
                                    , bd.getString("descripcion")
                                ));
            
        }     
        return rep;
    }    
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClTipoReportes> rep = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"tipo_reportes\" WHERE \"nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(bd.sqlFetch()){
            rep.add(new ClTipoReportes(bd.getInt("id_tipo_reporte")
                                    , bd.getString("nombre")
                                    , bd.getString("descripcion")
                                ));
            
        }     
        return rep;
    }
}
