/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClTipoReportes;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOTipoRep {
    public static boolean sqlInsert(ClTipoReportes rep) throws SQLException{
        String sql="INSERT INTO \"tipo_reportes\" (\"nombre\", \"descripcion\") VALUES (?,?)";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, rep.getNombre());
        a.setString(2, rep.getDescripcion());
        OracleConection.getInstance().sqlEjecutarPreparacion();
        return true;
    }
    
    public static boolean sqlDelete(ClTipoReportes rep){
        String sql="DELETE FROM \"tipo_reportes\" WHERE \"id_tipo_reporte\" = "+rep.getIdTipoReporte()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClTipoReportes rep) throws SQLException{
        String sql="UPDATE \"tipo_reportes\" SET \"nombre\" = ?, \"descripcion\" = ? WHERE \"id_tipo_reporte\" = ?";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, rep.getNombre());
        a.setString(2, rep.getDescripcion());
        a.setInt(3, rep.getIdTipoReporte());
        OracleConection.getInstance().sqlEjecutarPreparacion();   
        return true;
    }
    
    public static ClTipoReportes sqlLeer(String name){     
        ClTipoReportes rep = new ClTipoReportes();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"tipo_reportes\" WHERE \"nombre\" ='"+name+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        rep.setIdTipoReporte(OracleConection.getInstance().getInt("id_tipo_reporte"));
        rep.setNombre(OracleConection.getInstance().getString("nombre"));
        rep.setDescripcion(OracleConection.getInstance().getString("descripcion"));
        return rep;
    }
    
    public static ClTipoReportes sqlLeer(int id){     
        ClTipoReportes rep = new ClTipoReportes();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"tipo_reportes\" WHERE \"id_tipo_reporte\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        rep.setIdTipoReporte(OracleConection.getInstance().getInt("id_tipo_reporte"));
        rep.setNombre(OracleConection.getInstance().getString("nombre"));
        rep.setDescripcion(OracleConection.getInstance().getString("descripcion"));
        return rep;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClTipoReportes> rep = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"tipo_reportes\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            rep.add(new ClTipoReportes(OracleConection.getInstance().getInt("id_tipo_reporte")
                                    , OracleConection.getInstance().getString("nombre")
                                    , OracleConection.getInstance().getString("descripcion")
                                ));
            
        }     
        return rep;
    }    
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClTipoReportes> rep = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"tipo_reportes\" WHERE \"nombre\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            rep.add(new ClTipoReportes(OracleConection.getInstance().getInt("id_tipo_reporte")
                                    , OracleConection.getInstance().getString("nombre")
                                    , OracleConection.getInstance().getString("descripcion")
                                ));
            
        }     
        return rep;
    }
}
