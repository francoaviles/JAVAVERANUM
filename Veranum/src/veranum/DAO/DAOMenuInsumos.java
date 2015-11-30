/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClMenuInsumos;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOMenuInsumos {
    public static boolean sqlInsert(ClMenuInsumos menuInsumos) throws SQLException{
        String sql="INSERT INTO \"menu_insumos\" (\"id_insumo\", \"id_menu\", \"id_medida\", \"cantidad\" ) VALUES (?,?,?,?)";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setInt(1, menuInsumos.getIdInsumo());
        a.setInt(2, menuInsumos.getIdMenu());
        a.setInt(3, menuInsumos.getIdMedida());
        a.setInt(4, menuInsumos.getCantidad());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();
    }

    public static boolean sqlDelete(ClMenuInsumos menuInsumos){
        String sql="DELETE FROM \"menu_insumos\" WHERE \"id_menu_insumo\" = "+menuInsumos.getIdMenuInsumo()+"";
        
        return OracleConection.getInstance().sqlEjecutar(sql);   
    
    }
    
    public static boolean sqlUpdate(ClMenuInsumos menuInsumos) throws SQLException{
        String sql="UPDATE \"menu_insumos\" SET \"id_insumo\" = ?, \"id_menu\" = ?, \"id_medida\" = ?, \"cantidad\" = ? WHERE \"id_menu_insumo\" = ?";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setInt(1, menuInsumos.getIdInsumo());
        a.setInt(2, menuInsumos.getIdMenu());
        a.setInt(3, menuInsumos.getIdMedida());
        a.setInt(4, menuInsumos.getCantidad());
        a.setInt(5, menuInsumos.getIdMenuInsumo());
          
        return OracleConection.getInstance().sqlEjecutarPreparacion(); 
    }
    
    public static ClMenuInsumos sqlLeer(int id){     
        ClMenuInsumos menuInsumos = new ClMenuInsumos();
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"menu_insumos\" WHERE \"id_menu_insumo\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }
        menuInsumos.setIdMenuInsumo(OracleConection.getInstance().getInt("id_menu_insumo"));
        menuInsumos.setIdInsumo(OracleConection.getInstance().getInt("id_insumo"));
        menuInsumos.setIdMenu(OracleConection.getInstance().getInt("id_menu"));
        menuInsumos.setIdMedida(OracleConection.getInstance().getInt("id_medida"));
        menuInsumos.setCantidad(OracleConection.getInstance().getInt("cantidad"));
        return menuInsumos;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClMenuInsumos> menuInsumos = new ArrayList<>();
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"menu_insumos\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            menuInsumos.add(new ClMenuInsumos(OracleConection.getInstance().getInt("id_menu_insumo")
                                               , OracleConection.getInstance().getInt("id_insumo")
                                               , OracleConection.getInstance().getInt("id_menu")
                                               , OracleConection.getInstance().getInt("id_medida")
                                               , OracleConection.getInstance().getInt("cantidad")
                                ));
            
        }     
        return menuInsumos;
    }
    
    public static ArrayList sqlBuscarByNombre(String cantidad){
        ArrayList<ClMenuInsumos> menuInsumos = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"menu_insumos\" WHERE \"cantidad\" LIKE '%"+cantidad+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            menuInsumos.add(new ClMenuInsumos(OracleConection.getInstance().getInt("id_menu_insumo")
                                               , OracleConection.getInstance().getInt("id_insumo")
                                               , OracleConection.getInstance().getInt("id_menu")
                                               , OracleConection.getInstance().getInt("id_medida")
                                               , OracleConection.getInstance().getInt("cantidad")
                                ));
        }     
        return menuInsumos;
    }
}
