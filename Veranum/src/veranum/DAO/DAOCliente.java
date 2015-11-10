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
    private static final OracleConection bd = new OracleConection().Conectar();
    
    public static boolean sqlInsert(ClPasajeros clientes){
        String sql="INSERT INTO \"pasajeros\" (\"rut\", \"nombre\", \"apellido_pa\", \"apellido_ma\", \"telefono\", \"email\", \"id_region\", \"id_provincia\", \"id_comuna\", \"direccion\", \"fecha_nac\") VALUES ('"+clientes.getRut()+"','"+clientes.getNombre()+"','"+clientes.getApellido_pa()+"','"+clientes.getApellido_ma()+"','"+clientes.getTelefono()+"','"+clientes.getEmail()+"','"+clientes.getIdRegion()+"','"+clientes.getIdProvincia()+"','"+clientes.getIdComuna()+"','"+clientes.getDireccion()+"','"+clientes.getFechaNacimiento()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClPasajeros clientes){
        String sql="DELETE FROM \"pasajeros\" WHERE \"rut\" = '"+clientes.getRut()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClPasajeros clientes){
        String sql="UPDATE \"pasajeros\" SET \"rut\" = '"+clientes.getRut()+"' AND \"nombre\" = '"+clientes.getNombre()+"' AND \"apellido_pa\" = '"+clientes.getApellido_pa()+"' AND \"apellido_ma\" = '"+clientes.getApellido_ma()+"' AND \"telefono\" = '"+clientes.getTelefono()+"' AND \"email\" = '"+clientes.getEmail()+"' AND \"id_region\" = '"+clientes.getIdRegion()+"' AND \"id_provincia\" = '"+clientes.getIdProvincia()+"' AND \"id_comuna\" = '"+clientes.getIdComuna()+"' AND \"direccion\" = '"+clientes.getDireccion()+"' AND \"fecha_nac\" = '"+clientes.getFechaNacimiento()+"' WHERE \"rut\" = '"+clientes.getRut()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static ClPasajeros sqlLeer(int id){     
        ClPasajeros clientes = new ClPasajeros();        
        if(!bd.sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"id_pasajero\" ='"+id+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        clientes.setIdPasajero(bd.getInt("id_pasajero"));
        clientes.setRut(bd.getString("rut"));
        clientes.setNombre(bd.getString("nombre"));
        clientes.setApellido_pa(bd.getString("apellido_pa"));
        clientes.setApellido_ma(bd.getString("apellido_ma"));
        clientes.setTelefono(bd.getString("telefono"));
        clientes.setEmail(bd.getString("email"));
        clientes.setIdRegion(bd.getInt("id_region"));
        clientes.setIdProvincia(bd.getInt("id_provincia"));
        clientes.setIdComuna(bd.getInt("id_comuna"));
        clientes.setDireccion(bd.getString("direccion"));
        clientes.setFechaNacimiento(bd.getDate("fecha_nac"));
        return clientes;
    }
    
    public static ClPasajeros sqlLeer(String name){     
        ClPasajeros clientes = new ClPasajeros();        
        if(!bd.sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"rut\" ='"+name+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        clientes.setIdPasajero(bd.getInt("id_pasajero"));
        clientes.setRut(bd.getString("rut"));
        clientes.setNombre(bd.getString("nombre"));
        clientes.setApellido_pa(bd.getString("apellido_pa"));
        clientes.setApellido_ma(bd.getString("apellido_ma"));
        clientes.setTelefono(bd.getString("telefono"));
        clientes.setEmail(bd.getString("email"));
        clientes.setIdRegion(bd.getInt("id_region"));
        clientes.setIdProvincia(bd.getInt("id_provincia"));
        clientes.setIdComuna(bd.getInt("id_comuna"));
        clientes.setDireccion(bd.getString("direccion"));
        clientes.setFechaNacimiento(bd.getDate("fecha_nac"));
        return clientes;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClPasajeros> clientes = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"pasajeros\"")){
            return null;
        }
        while(bd.sqlFetch()){
            clientes.add(new ClPasajeros(bd.getInt("id_pasajero")
                                    , bd.getString("rut")
                                    , bd.getString("nombre")
                                    , bd.getString("apellido_pa")
                                    , bd.getString("apellido_ma")
                                    , bd.getString("telefono")
                                    , bd.getString("email")
                                    , bd.getInt("id_region")
                                    , bd.getInt("id_provincia")
                                    , bd.getInt("id_comuna")
                                    , bd.getString("direccion")
                                    , bd.getDate("fecha_nac")
                                ));
            
        }     
        return clientes;
    }
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClPasajeros> clientes = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"rut\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(bd.sqlFetch()){
            clientes.add(new ClPasajeros(bd.getInt("id_pasajero")
                                    , bd.getString("rut")
                                    , bd.getString("nombre")
                                    , bd.getString("apellido_pa")
                                    , bd.getString("apellido_ma")
                                    , bd.getString("telefono")
                                    , bd.getString("email")
                                    , bd.getInt("id_region")
                                    , bd.getInt("id_provincia")
                                    , bd.getInt("id_comuna")
                                    , bd.getString("direccion")
                                    , bd.getDate("fecha_nac")
                                ));
            
        }     
        return clientes;
    } 
    
}
