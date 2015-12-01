/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import veranum.GUI.MainVeranum;
import veranum.utilidades.OracleConection;

/**
 *
 * @author carlosdlg
 */
public class Log {
    public static boolean create(String query) throws SQLException{
        if(MainVeranum.p != null){
            String sql = "INSERT INTO \"log\" (\"id_pasajero\", \"fecha_creacion\", \"consulta\") VALUES (?,?,?)";
            PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
            a.setInt(1, MainVeranum.p.getIdPasajero());
            a.setDate(2, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            a.setString(3, query);
            return OracleConection.getInstance().sqlEjecutarPreparacion();
        }
        return false;
    }
}
