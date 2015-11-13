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
    public ClPasajeros LoginIn(ClPasajeros usuario)
    {
        ClPasajeros p = null;
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"pasajeros\" WHERE \"rut\" = '"+usuario.getRut()+"' and \"contrasena\" = '"+usuario.getContrasena()+"'"))
        {
            return p;
        }
        
        if(!OracleConection.getInstance().sqlFetch())
        {
            return p;
        }        
        
        usuario.setApellido_ma(OracleConection.getInstance().getString("apellido_ma"));
        usuario.setNombre(OracleConection.getInstance().getString("nombre"));
        usuario.setIdRol(OracleConection.getInstance().getInt("id_rol"));
        
        return usuario;
    }
}
