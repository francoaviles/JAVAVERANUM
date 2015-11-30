/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import veranum.entities.ClPasajeros;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOProveedores {
     
    public static boolean sqlInsert(ClPasajeros proveedores) throws SQLException{
        String sql="INSERT INTO \"pasajeros\" (\"rut\", \"nombre\", \"telefono\", \"email\", \"direccion\",\"id_rol\" ) VALUES (?,?,?,?,?,?)";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, proveedores.getRut());
        a.setString(2, proveedores.getNombre());
        a.setString(3, proveedores.getTelefono());
        a.setString(4, proveedores.getEmail());
        a.setString(5, proveedores.getDireccion());
        a.setInt(6, proveedores.getIdRol());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();
    }
    
    public static int sqlLastID(){
        return OracleConection.getInstance().sqlLastID("pasajeros_seq");
    }
    
    public static boolean sqlDelete(ClPasajeros proveedores){
        String sql="DELETE FROM \"pasajeros\" WHERE \"id_pasajero\" = "+proveedores.getIdPasajero()+"";
          
        return OracleConection.getInstance().sqlEjecutar(sql); 
    }
    
    public static boolean sqlUpdate(ClPasajeros proveedores) throws SQLException{
        String sql="UPDATE \"pasajeros\" SET \"rut\" = ?, \"nombre\" = ?, \"telefono\" = ?, \"email\" = ?, \"direccion\" = ?, \"id_rol\" = ? WHERE \"id_pasajero\" = ?";
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, proveedores.getRut());
        a.setString(2, proveedores.getNombre());
        a.setString(6, proveedores.getTelefono());
        a.setString(7, proveedores.getEmail());
        a.setString(8, proveedores.getDireccion());
        a.setInt(10, proveedores.getIdRol());
        a.setInt(11, proveedores.getIdPasajero());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();  
    }
    
    public static ClPasajeros sqlLeer(int id){     
        ClPasajeros proveedores = new ClPasajeros();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"id_pasajero\" ="+id+"")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        proveedores.setIdPasajero(OracleConection.getInstance().getInt("id_pasajero"));
        proveedores.setRut(OracleConection.getInstance().getString("rut").toUpperCase());
        proveedores.setNombre(OracleConection.getInstance().getString("nombre"));
        proveedores.setTelefono(OracleConection.getInstance().getString("telefono"));
        proveedores.setEmail(OracleConection.getInstance().getString("email"));
        proveedores.setDireccion(OracleConection.getInstance().getString("direccion"));
        proveedores.setIdRol(OracleConection.getInstance().getInt("id_rol"));
        return proveedores;
    }
    
    public static ClPasajeros sqlLeer(String rut){     
        ClPasajeros proveedores;       
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"rut\" ='"+rut+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }      
        proveedores = new ClPasajeros();
        proveedores.setIdPasajero(OracleConection.getInstance().getInt("id_pasajero"));
        proveedores.setRut(OracleConection.getInstance().getString("rut"));
        proveedores.setNombre(OracleConection.getInstance().getString("nombre"));
        proveedores.setTelefono(OracleConection.getInstance().getString("telefono"));
        proveedores.setEmail(OracleConection.getInstance().getString("email"));
        proveedores.setDireccion(OracleConection.getInstance().getString("direccion"));
        proveedores.setIdRol(OracleConection.getInstance().getInt("id_rol"));
        return proveedores;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClPasajeros> proveedores = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"id_rol\" = 4")){ //proveedores
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            proveedores.add(new ClPasajeros( OracleConection.getInstance().getInt("id_pasajero")
                                    , OracleConection.getInstance().getString("rut")
                                    , OracleConection.getInstance().getString("nombre")
                                    , OracleConection.getInstance().getString("telefono")
                                    , OracleConection.getInstance().getString("email")
                                    , OracleConection.getInstance().getString("direccion")
                                    , OracleConection.getInstance().getInt("id_rol")
                                ));
            
        }     
        return proveedores;
    } 
    
    public static ArrayList sqlBuscarByNombre(String rut){
        ArrayList<ClPasajeros> proveedores = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"rut\" LIKE '%"+rut+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            proveedores.add(new ClPasajeros( OracleConection.getInstance().getInt("id_pasajero")
                                    , OracleConection.getInstance().getString("rut")
                                    , OracleConection.getInstance().getString("nombre")
                                    , OracleConection.getInstance().getString("telefono")
                                    , OracleConection.getInstance().getString("email")
                                    , OracleConection.getInstance().getString("direccion")
                                    , OracleConection.getInstance().getInt("id_rol")
                                ));
            
        }     
        return proveedores;
    }
    
}
