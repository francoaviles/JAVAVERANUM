/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClPasajeros;
import veranum.utilidades.OracleConection;

/**
 *
 * @author Zacarias
 */
public class DAOUsuarios {
   private static final OracleConection bd = new OracleConection().Conectar();
    
    public static boolean sqlInsert(ClPasajeros usuarios){
        String sql="INSERT INTO \"pasajeros\" (\"rut\", \"nombre\", \"contrasena\", \"apellido_pa\", \"apellido_ma\", \"telefono\", \"email\", \"direccion\", \"fecha_nac\", \"id_rol\" ) VALUES ('"+usuarios.getRut()+"','"+usuarios.getNombre()+"','"+usuarios.getContrasena()+"','"+usuarios.getApellido_pa()+"','"+usuarios.getApellido_ma()+"','"+usuarios.getTelefono()+"','"+usuarios.getEmail()+"','"+usuarios.getDireccion()+"','"+usuarios.getFechaNacimiento()+"','"+usuarios.getIdRol()+"')";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClPasajeros usuarios){
        String sql="DELETE FROM \"pasajeros\" WHERE \"id_pasajero\" = "+usuarios.getIdPasajero()+"";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClPasajeros usuarios){
        String sql="UPDATE \"pasajeros\" SET \"rut\" = '"+usuarios.getRut()+"', \"nombre\" = '"+usuarios.getNombre()+"', \"contrasena\" = '"+usuarios.getContrasena()+"', \"apellido_pa\" = '"+usuarios.getApellido_pa()+"', \"apellido_ma\" = '"+usuarios.getApellido_ma()+"', \"telefono\" = '"+usuarios.getTelefono()+"', \"email\" = '"+usuarios.getEmail()+"', \"id_region\" = '"+usuarios.getIdRegion()+"', \"id_provincia\" = '"+usuarios.getIdProvincia()+"', \"id_comuna\" = '"+usuarios.getIdComuna()+"', \"direccion\" = '"+usuarios.getDireccion()+"', \"fecha_nac\" = '"+usuarios.getFechaNacimiento()+"' WHERE \"id_pasajero\" = "+usuarios.getIdPasajero()+"";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static ClPasajeros sqlLeer(int id){     
        ClPasajeros usuarios = new ClPasajeros();        
        if(!bd.sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"id_pasajero\" ="+id+"")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        usuarios.setIdPasajero(bd.getInt("id_pasajero"));
        usuarios.setRut(bd.getString("rut"));
        usuarios.setNombre(bd.getString("nombre"));
        usuarios.setContrasena(bd.getString("contrasena"));
        usuarios.setApellido_pa(bd.getString("apellido_pa"));
        usuarios.setApellido_ma(bd.getString("apellido_ma"));
        usuarios.setTelefono(bd.getString("telefono"));
        usuarios.setEmail(bd.getString("email"));
        usuarios.setDireccion(bd.getString("direccion"));
        usuarios.setFechaNacimiento(bd.getDate("fecha_nac"));
        usuarios.setIdRol(bd.getInt("id_rol"));
        return usuarios;
    }
    
    public static ClPasajeros sqlLeer(String name){     
        ClPasajeros usuarios = new ClPasajeros();        
        if(!bd.sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"rut\" ='"+name+"'")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        usuarios.setIdPasajero(bd.getInt("id_pasajero"));
        usuarios.setRut(bd.getString("rut"));
        usuarios.setNombre(bd.getString("nombre"));
        usuarios.setContrasena(bd.getString("contrasena"));
        usuarios.setApellido_pa(bd.getString("apellido_pa"));
        usuarios.setApellido_ma(bd.getString("apellido_ma"));
        usuarios.setTelefono(bd.getString("telefono"));
        usuarios.setEmail(bd.getString("email"));
        usuarios.setDireccion(bd.getString("direccion"));
        usuarios.setFechaNacimiento(bd.getDate("fecha_nac"));
        usuarios.setIdRol(bd.getInt("id_rol"));
        return usuarios;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClPasajeros> usuarios = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"pasajeros\"")){
            return null;
        }
        while(bd.sqlFetch()){
            usuarios.add(new ClPasajeros( bd.getInt("id_pasajero")
                                    , bd.getString("rut")
                                    , bd.getString("nombre")
                                    , bd.getString("contrasena")
                                    , bd.getString("apellido_pa")
                                    , bd.getString("apellido_ma")
                                    , bd.getString("telefono")
                                    , bd.getString("email")
                                    , bd.getString("direccion")
                                    , bd.getDate("fecha_nac")
                                    , bd.getInt("id_rol")
                                ));
            
        }     
        return usuarios;
    } 
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClPasajeros> usuarios = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"rut\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(bd.sqlFetch()){
            usuarios.add(new ClPasajeros(bd.getString("rut")
                                    , bd.getString("nombre")
                                    , bd.getString("contrasena")
                                    , bd.getString("apellido_pa")
                                    , bd.getString("apellido_ma")
                                    , bd.getString("telefono")
                                    , bd.getString("email")
                                    , bd.getString("direccion")
                                    , bd.getDate("fecha_nac")
                                    , bd.getInt("id_rol")
                                ));
            
        }     
        return usuarios;
    }     
}
