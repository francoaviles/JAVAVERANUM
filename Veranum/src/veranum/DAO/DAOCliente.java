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
        String sql="INSERT INTO \"pasajeros\" (\"rut\", \"nombre\", \"contrasena\", \"apellido_pa\", \"apellido_ma\", \"telefono\", \"email\", \"id_region\", \"id_provincia\", \"id_comuna\", \"direccion\", \"fecha_nac\") VALUES ('"+clientes.getRut()+"','"+clientes.getNombre()+"','"+clientes.getContrasena()+"','"+clientes.getApellido_pa()+"','"+clientes.getApellido_ma()+"','"+clientes.getTelefono()+"','"+clientes.getEmail()+"','"+clientes.getIdRegion()+"','"+clientes.getIdProvincia()+"','"+clientes.getIdComuna()+"','"+clientes.getDireccion()+"','"+clientes.getFechaNacimiento()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClPasajeros clientes){
        String sql="DELETE FROM \"pasajeros\" WHERE \"id_pasajero\" = '"+clientes.getIdPasajero()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    /*
    public static boolean sqlUpdate(ClPasajeros clientes){
        String sql="UPDATE \"pasajeros\" SET \"clientes_nombre\" = '"+clientes.getNombre()+"' AND \"id_provincia\" = '"+clientes.getIdProvincia()+"'  WHERE \"id_clientes\" = '"+clientes.getIdComuna()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public ClPasajeros sqlLeer(int id){     
        ClPasajeros clientes = new ClPasajeros();        
        if(!bd.sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"id_clientes\" = "+id+" ")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        clientes.setIdHotel(bd.getInt("id_clientes"));
        clientes.setIdCadena(bd.getInt("id_cadena"));
        clientes.setIdRegion(bd.getInt("id_region"));
        clientes.setIdProvincia(bd.getInt("id_provincia"));
        clientes.setIdComuna(bd.getInt("id_comuna"));
        clientes.setNombre(bd.getString("nombre"));
        clientes.setDireccion(bd.getString("direccion"));
        return clientes;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClPasajeros> clientes = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"pasajeros\"")){
            return null;
        }
        while(bd.sqlFetch()){
            clientes.add(new ClPasajeros(bd.getInt("id_clientes")
                                    , bd.getInt("id_cadena")
                                    , bd.getInt("id_region")
                                    , bd.getInt("id_provincia")
                                    , bd.getInt("id_comuna")
                                    , bd.getString("nombre")
                                    , bd.getString("direccion")
                                ));
            
        }     
        return clientes;
    }  
     */
}
