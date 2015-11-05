/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

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
    /*
    public static boolean sqlUpdate(ClPasajeros usuarios){
        String sql="UPDATE \"pasajeros\" SET \"usuarios_nombre\" = '"+usuarios.getNombre()+"' AND \"id_provincia\" = '"+usuarios.getIdProvincia()+"'  WHERE \"id_usuarios\" = '"+usuarios.getIdComuna()+"'";
        bd.sqlEjecutar(sql);   
        return true;
    }
    
    public ClPasajeros sqlLeer(int id){     
        ClPasajeros usuarios = new ClPasajeros();        
        if(!bd.sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"id_usuarios\" = "+id+" ")){
            return null;
        }        
        if(!bd.sqlFetch()){
            return null;
        }        
        usuarios.setIdHotel(bd.getInt("id_usuarios"));
        usuarios.setIdCadena(bd.getInt("id_cadena"));
        usuarios.setIdRegion(bd.getInt("id_region"));
        usuarios.setIdProvincia(bd.getInt("id_provincia"));
        usuarios.setIdComuna(bd.getInt("id_comuna"));
        usuarios.setNombre(bd.getString("nombre"));
        usuarios.setDireccion(bd.getString("direccion"));
        return usuarios;
    }
    
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClPasajeros> usuarios = new ArrayList<>();        
        if(!bd.sqlSelect("SELECT * FROM \"pasajeros\"")){
            return null;
        }
        while(bd.sqlFetch()){
            usuarios.add(new ClPasajeros(bd.getInt("id_usuarios")
                                    , bd.getInt("id_cadena")
                                    , bd.getInt("id_region")
                                    , bd.getInt("id_provincia")
                                    , bd.getInt("id_comuna")
                                    , bd.getString("nombre")
                                    , bd.getString("direccion")
                                ));
            
        }     
        return usuarios;
    }  
     */
}
