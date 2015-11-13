/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClPasajeros;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Duoc
 */
public class DAOCliente {
    public static boolean sqlInsert(ClPasajeros clientes){
        String sql="INSERT INTO \"pasajeros\" (\"rut\", \"nombre\", \"apellido_pa\", \"apellido_ma\", \"telefono\", \"email\", \"id_region\", \"id_provincia\", \"id_comuna\", \"direccion\", \"fecha_nac\") VALUES ('"+clientes.getRut()+"','"+clientes.getNombre()+"','"+clientes.getApellido_pa()+"','"+clientes.getApellido_ma()+"','"+clientes.getTelefono()+"','"+clientes.getEmail()+"','"+clientes.getIdRegion()+"','"+clientes.getIdProvincia()+"','"+clientes.getIdComuna()+"','"+clientes.getDireccion()+"','"+clientes.getFechaNacimiento()+"')";
        OracleConection.getInstance().sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClPasajeros clientes){
        String sql="DELETE FROM \"pasajeros\" WHERE \"id_pasajero\" = "+clientes.getIdPasajero()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClPasajeros clientes){
        String sql="UPDATE \"pasajeros\" SET \"rut\" = '"+clientes.getRut()+"', \"nombre\" = '"+clientes.getNombre()+"' AND \"apellido_pa\" = '"+clientes.getApellido_pa()+"', \"apellido_ma\" = '"+clientes.getApellido_ma()+"', \"telefono\" = '"+clientes.getTelefono()+"', \"email\" = '"+clientes.getEmail()+"', \"id_region\" = '"+clientes.getIdRegion()+"', \"id_provincia\" = '"+clientes.getIdProvincia()+"', \"id_comuna\" = '"+clientes.getIdComuna()+"', \"direccion\" = '"+clientes.getDireccion()+"', \"fecha_nac\" = '"+clientes.getFechaNacimiento()+"' WHERE \"rut\" = "+clientes.getRut()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
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
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"pasajeros\"")){
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
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClPasajeros> clientes = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"rut\" LIKE '%"+nombre+"%'")){
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
