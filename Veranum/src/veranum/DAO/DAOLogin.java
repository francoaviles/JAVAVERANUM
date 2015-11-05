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
public class DAOLogin {
    
    private static OracleConection bd = new OracleConection().Conectar();

    public ClPasajeros LoginIn(ClPasajeros usuario)
    {
        ClPasajeros p = null;
        if(!bd.sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"rut\" = '"+usuario.getRut()+"' and \"contrasena\" = '"+usuario.getContrasena()+"'"))
        {
            return p;
        }
        
        if(!bd.sqlFetch())
        {
            return p;
        }        
        
        usuario.setApellido_ma(bd.getString("apellido_ma"));
        usuario.setNombre(bd.getString("nombre"));
        usuario.setIdRol(bd.getInt("id_rol"));
        
        return usuario;
    }
}
