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
    public static boolean sqlInsert(ClPasajeros usuarios){
        String sql="INSERT INTO \"pasajeros\" (\"rut\", \"nombre\", \"contrasena\", \"apellido_pa\", \"apellido_ma\", \"telefono\", \"email\", \"direccion\", \"fecha_nac\", \"id_rol\" ) VALUES ('"+usuarios.getRut()+"','"+usuarios.getNombre()+"','"+usuarios.getContrasena()+"','"+usuarios.getApellido_pa()+"','"+usuarios.getApellido_ma()+"','"+usuarios.getTelefono()+"','"+usuarios.getEmail()+"','"+usuarios.getDireccion()+"',TO_DATE('"+usuarios.getStringFechaNac()+"', 'dd/MM/YYYY'),'"+usuarios.getIdRol()+"')";
        OracleConection.getInstance().sqlEjecutar(sql);
        return true;
    }
    
    public static boolean sqlDelete(ClPasajeros usuarios){
        String sql="DELETE FROM \"pasajeros\" WHERE \"id_pasajero\" = "+usuarios.getIdPasajero()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static boolean sqlUpdate(ClPasajeros usuarios){
        System.out.println(usuarios.getFechaNacimiento());
        String sql="UPDATE \"pasajeros\" SET \"rut\" = '"+usuarios.getRut()+"', \"nombre\" = '"+usuarios.getNombre()+"', \"contrasena\" = '"+usuarios.getContrasena()+"', \"apellido_pa\" = '"+usuarios.getApellido_pa()+"', \"apellido_ma\" = '"+usuarios.getApellido_ma()+"', \"telefono\" = '"+usuarios.getTelefono()+"', \"email\" = '"+usuarios.getEmail()+"', \"direccion\" = '"+usuarios.getDireccion()+"', \"fecha_nac\" = TO_DATE('"+usuarios.getStringFechaNac()+"', 'dd/MM/YYYY') WHERE \"id_pasajero\" = "+usuarios.getIdPasajero()+"";
        OracleConection.getInstance().sqlEjecutar(sql);   
        return true;
    }
    
    public static ClPasajeros sqlLeer(int id){     
        ClPasajeros usuarios = new ClPasajeros();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"id_pasajero\" ="+id+"")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        usuarios.setIdPasajero(OracleConection.getInstance().getInt("id_pasajero"));
        usuarios.setRut(OracleConection.getInstance().getString("rut"));
        usuarios.setNombre(OracleConection.getInstance().getString("nombre"));
        usuarios.setContrasena(OracleConection.getInstance().getString("contrasena"));
        usuarios.setApellido_pa(OracleConection.getInstance().getString("apellido_pa"));
        usuarios.setApellido_ma(OracleConection.getInstance().getString("apellido_ma"));
        usuarios.setTelefono(OracleConection.getInstance().getString("telefono"));
        usuarios.setEmail(OracleConection.getInstance().getString("email"));
        usuarios.setDireccion(OracleConection.getInstance().getString("direccion"));
        usuarios.setFechaNacimiento(OracleConection.getInstance().getDate("fecha_nac"));
        usuarios.setIdRol(OracleConection.getInstance().getInt("id_rol"));
        return usuarios;
    }
    
    public static ClPasajeros sqlLeer(String name){     
        ClPasajeros usuarios = new ClPasajeros();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"rut\" ='"+name+"'")){
            return null;
        }        
        if(!OracleConection.getInstance().sqlFetch()){
            return null;
        }        
        usuarios.setIdPasajero(OracleConection.getInstance().getInt("id_pasajero"));
        usuarios.setRut(OracleConection.getInstance().getString("rut"));
        usuarios.setNombre(OracleConection.getInstance().getString("nombre"));
        usuarios.setContrasena(OracleConection.getInstance().getString("contrasena"));
        usuarios.setApellido_pa(OracleConection.getInstance().getString("apellido_pa"));
        usuarios.setApellido_ma(OracleConection.getInstance().getString("apellido_ma"));
        usuarios.setTelefono(OracleConection.getInstance().getString("telefono"));
        usuarios.setEmail(OracleConection.getInstance().getString("email"));
        usuarios.setDireccion(OracleConection.getInstance().getString("direccion"));
        usuarios.setFechaNacimiento(OracleConection.getInstance().getDate("fecha_nac"));
        usuarios.setIdRol(OracleConection.getInstance().getInt("id_rol"));
        return usuarios;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClPasajeros> usuarios = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"pasajeros\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            usuarios.add(new ClPasajeros( OracleConection.getInstance().getInt("id_pasajero")
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
        return usuarios;
    } 
    
    public static ArrayList sqlBuscarByNombre(String nombre){
        ArrayList<ClPasajeros> usuarios = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"rut\" LIKE '%"+nombre+"%'")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            usuarios.add(new ClPasajeros(OracleConection.getInstance().getString("rut")
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
        return usuarios;
    }     
}
