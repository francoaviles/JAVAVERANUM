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
        String sql="INSERT INTO \"pasajeros\" (\"rut\", \"nombre\", \"contrasena\", \"apellido_pa\", \"apellido_ma\", \"telefono\", \"email\", \"id_region\", \"id_provincia\", \"id_comuna\", \"direccion\", \"fecha_nac\", \"id_rol\" ) VALUES ('"+usuarios.getRut()+"','"+usuarios.getNombre()+"','"+usuarios.getContrasena()+"','"+usuarios.getApellido_pa()+"','"+usuarios.getApellido_ma()+"','"+usuarios.getTelefono()+"','"+usuarios.getEmail()+"','"+usuarios.getIdRegion()+"','"+usuarios.getIdProvincia()+"','"+usuarios.getIdComuna()+"','"+usuarios.getDireccion()+"','"+usuarios.getFechaNacimiento()+"','"+usuarios.getIdRol()+"' )";
        bd.sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClPasajeros usuarios){
        String sql="DELETE FROM \"pasajeros\" WHERE \"id_pasajero\" = '"+usuarios.getIdPasajero()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClPasajeros usuarios){
        String sql="UPDATE \"pasajeros\" SET \"rut\" = '"+usuarios.getRut()+"' AND \"nombre\" = '"+usuarios.getNombre()+"' AND \"contrasena\" = '"+usuarios.getContrasena()+"' AND \"apellido_pa\" = '"+usuarios.getApellido_pa()+"' AND \"apellido_ma\" = '"+usuarios.getApellido_ma()+"' AND \"telefono\" = '"+usuarios.getTelefono()+"' AND \"email\" = '"+usuarios.getEmail()+"' AND \"id_region\" = '"+usuarios.getIdRegion()+"' AND \"id_provincia\" = '"+usuarios.getIdProvincia()+"' AND \"id_comuna\" = '"+usuarios.getIdComuna()+"' AND \"direccion\" = '"+usuarios.getDireccion()+"' AND \"fecha_nac\" = '"+usuarios.getFechaNacimiento()+"' WHERE \"rut\" = '"+usuarios.getRut()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public ClPasajeros sqlLeer(int id){     
        ClPasajeros usuarios = new ClPasajeros();        
        if(!bd.sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"id_pasajero\" ='"+id+"'")){
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
        usuarios.setIdRegion(bd.getInt("id_region"));
        usuarios.setIdProvincia(bd.getInt("id_provincia"));
        usuarios.setIdComuna(bd.getInt("id_comuna"));
        usuarios.setDireccion(bd.getString("direccion"));
        usuarios.setFechaNacimiento(bd.getDate("fecha_nac"));
        usuarios.setIdRol(bd.getInt("id_rol"));
        return usuarios;
    }
    
    public ClPasajeros sqlLeer(String name){     
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
        usuarios.setIdRegion(bd.getInt("id_region"));
        usuarios.setIdProvincia(bd.getInt("id_provincia"));
        usuarios.setIdComuna(bd.getInt("id_comuna"));
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
            usuarios.add(new ClPasajeros(bd.getInt("id_pasajero")
                                    , bd.getString("rut")
                                    , bd.getString("nombre")
                                    , bd.getString("contrasena")
                                    , bd.getString("apellido_pa")
                                    , bd.getString("apellido_ma")
                                    , bd.getString("telefono")
                                    , bd.getString("email")
                                    , bd.getInt("id_region")
                                    , bd.getInt("id_provincia")
                                    , bd.getInt("id_comuna")
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
            usuarios.add(new ClPasajeros(bd.getInt("id_pasajero")
                                    , bd.getString("rut")
                                    , bd.getString("nombre")
                                    , bd.getString("contrasena")
                                    , bd.getString("apellido_pa")
                                    , bd.getString("apellido_ma")
                                    , bd.getString("telefono")
                                    , bd.getString("email")
                                    , bd.getInt("id_region")
                                    , bd.getInt("id_provincia")
                                    , bd.getInt("id_comuna")
                                    , bd.getString("direccion")
                                    , bd.getDate("fecha_nac")
                                    , bd.getInt("id_rol")
                                ));
            
        }     
        return usuarios;
    } 
    
}
