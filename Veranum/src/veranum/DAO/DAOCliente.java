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
import veranum.entities.ClPasajeros;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Duoc
 */
public class DAOCliente {
    public static boolean sqlInsert(ClPasajeros clientes) throws SQLException{
        String sql="INSERT INTO \"pasajeros\" (\"rut\", \"nombre\", \"contrasena\", \"apellido_pa\", \"apellido_ma\", \"telefono\", \"email\", \"direccion\", \"fecha_nac\", \"id_rol\" ) VALUES (?,?,?,?,?,?,?,?,?,?)";
        Log.create("INSERT",new Gson().toJson(clientes));
        
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, clientes.getRut());
        a.setString(2, clientes.getNombre());
        a.setString(3, clientes.getContrasena());
        a.setString(4, clientes.getApellido_pa());
        a.setString(5, clientes.getApellido_ma());
        a.setString(6, clientes.getTelefono());
        a.setString(7, clientes.getEmail());
        a.setString(8, clientes.getDireccion());
        a.setDate(9, (new java.sql.Date(clientes.getFechaNacimiento().getTime())));
        a.setInt(10, clientes.getIdRol());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();
    }
    
    public static boolean sqlDelete(ClPasajeros clientes) throws SQLException{
        String sql="DELETE FROM \"pasajeros\" WHERE \"id_pasajero\" = "+clientes.getIdPasajero()+"";
        Log.create("DELETE",new Gson().toJson(clientes));
        
        return OracleConection.getInstance().sqlEjecutar(sql);   
    }
    
    public static boolean sqlUpdate(ClPasajeros clientes) throws SQLException{
        String sql="UPDATE \"pasajeros\" SET \"rut\" = ?, \"nombre\" = ?, \"contrasena\" = ?, \"apellido_pa\" = ?, \"apellido_ma\" = ?, \"telefono\" = ?, \"email\" = ?, \"direccion\" = ?, \"fecha_nac\" = ?, \"id_rol\" = ?  WHERE \"id_pasajero\" = ?";
        Log.create("UPDATE",new Gson().toJson(clientes));
        
        PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
        a.setString(1, clientes.getRut());
        a.setString(2, clientes.getNombre());
        a.setString(3, clientes.getContrasena());
        a.setString(4, clientes.getApellido_pa());
        a.setString(5, clientes.getApellido_ma());
        a.setString(6, clientes.getTelefono());
        a.setString(7, clientes.getEmail());
        a.setString(8, clientes.getDireccion());
        a.setDate(9, (new java.sql.Date(clientes.getFechaNacimiento().getTime())));
        a.setInt(10, clientes.getIdRol());
        a.setInt(11, clientes.getIdPasajero());
        
        return OracleConection.getInstance().sqlEjecutarPreparacion();  
    }
    
    public static ClPasajeros sqlLeer(int id){     
        ClPasajeros clientes = new ClPasajeros();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"id_pasajero\" ='"+id+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }
        clientes.setIdPasajero(OracleConection.getInstance().getInt("id_pasajero"));
        clientes.setRut(OracleConection.getInstance().getString("rut"));
        clientes.setNombre(OracleConection.getInstance().getString("nombre"));
        clientes.setContrasena(OracleConection.getInstance().getString("contrasena"));
        clientes.setApellido_pa(OracleConection.getInstance().getString("apellido_pa"));
        clientes.setApellido_ma(OracleConection.getInstance().getString("apellido_ma"));
        clientes.setTelefono(OracleConection.getInstance().getString("telefono"));
        clientes.setEmail(OracleConection.getInstance().getString("email"));
        clientes.setDireccion(OracleConection.getInstance().getString("direccion"));
        clientes.setFechaNacimiento(OracleConection.getInstance().getDate("fecha_nac"));
        clientes.setIdPasajero(OracleConection.getInstance().getInt("id_rol"));        
        return clientes;
    }
    
    public static ClPasajeros sqlLeer(String name){     
        ClPasajeros clientes = new ClPasajeros();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"rut\" ='"+name+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        clientes.setIdPasajero(OracleConection.getInstance().getInt("id_pasajero"));
        clientes.setRut(OracleConection.getInstance().getString("rut"));
        clientes.setNombre(OracleConection.getInstance().getString("nombre"));
        clientes.setContrasena(OracleConection.getInstance().getString("contrasena"));
        clientes.setApellido_pa(OracleConection.getInstance().getString("apellido_pa"));
        clientes.setApellido_ma(OracleConection.getInstance().getString("apellido_ma"));
        clientes.setTelefono(OracleConection.getInstance().getString("telefono"));
        clientes.setEmail(OracleConection.getInstance().getString("email"));
        clientes.setDireccion(OracleConection.getInstance().getString("direccion"));
        clientes.setFechaNacimiento(OracleConection.getInstance().getDate("fecha_nac"));
        clientes.setIdPasajero(OracleConection.getInstance().getInt("id_rol"));        
        return clientes;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClPasajeros> clientes = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"id_rol\" = 3")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            clientes.add(new ClPasajeros(OracleConection.getInstance().getInt("id_pasajero")
                                    , OracleConection.getInstance().getString("rut")
                                    , OracleConection.getInstance().getString("nombre")
                                    , OracleConection.getInstance().getString("contrasena")
                                    , OracleConection.getInstance().getString("apellido_pa")
                                    , OracleConection.getInstance().getString("apellido_ma")
                                    , OracleConection.getInstance().getString("telefono")
                                    , OracleConection.getInstance().getString("email")
                                    , OracleConection.getInstance().getString("direccion")
                                    , OracleConection.getInstance().getDate("fecha_nac")
                                    , OracleConection.getInstance().getInt("id_rol")
                                ));
            
        }     
        return clientes;
    }
    
    public static ArrayList sqlBuscarByNombre(String rut){
        ArrayList<ClPasajeros> clientes = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"rut\" LIKE '%"+rut+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            clientes.add(new ClPasajeros(OracleConection.getInstance().getInt("id_pasajero")
                                    , OracleConection.getInstance().getString("rut")
                                    , OracleConection.getInstance().getString("nombre")
                                    , OracleConection.getInstance().getString("contrasena")
                                    , OracleConection.getInstance().getString("apellido_pa")
                                    , OracleConection.getInstance().getString("apellido_ma")
                                    , OracleConection.getInstance().getString("telefono")
                                    , OracleConection.getInstance().getString("email")
                                    , OracleConection.getInstance().getString("direccion")
                                    , OracleConection.getInstance().getDate("fecha_nac")
                                    , OracleConection.getInstance().getInt("id_rol")
                                ));
            
        }     
        return clientes;
    } 
    
}
