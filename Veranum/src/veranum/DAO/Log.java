/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import veranum.GUI.MainVeranum;
import veranum.entities.ClLog;
import veranum.utilidades.OracleConection;

/**
 *
 * @author carlosdlg
 */
public class Log {
    public static boolean create(String tipo, String query) throws SQLException{
        if(MainVeranum.p != null){
            String sql = "INSERT INTO \"log\" (\"id_pasajero\", \"fecha_creacion\", \"tipo\", \"consulta\") VALUES (?,?,?,?)";
            PreparedStatement a = OracleConection.getInstance().sqlPreparar(sql);
            a.setInt(1, MainVeranum.p.getIdPasajero());
            a.setDate(2, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            a.setString(3, tipo);
            a.setString(4, query);
            return OracleConection.getInstance().sqlEjecutarPreparacion();
        }
        return false;
    }
    
    public static ArrayList<ClLog> all(){
        ArrayList<ClLog> log = new ArrayList<>();
        String sql = "SELECT \"log\".*,\n" +
                    "\"pasajeros\".\"nombre\",\n" +
                    "\"pasajeros\".\"rut\",\n" +
                    "\"roles\".\"nombre\" AS \"rol\"\n" +
                    "FROM \"log\"\n" +
                    "LEFT JOIN \"pasajeros\" ON  \"pasajeros\".\"id_pasajero\" = \"log\".\"id_pasajero\"\n" +
                    "LEFT JOIN \"roles\" ON  \"roles\".\"id_rol\" = \"pasajeros\".\"id_rol\"";
        
        if(!OracleConection.getInstance().sqlSelect(sql)){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            log.add(new ClLog( OracleConection.getInstance().getInt("id_log")
                                    , OracleConection.getInstance().getInt("id_pasajero")
                                    , OracleConection.getInstance().getDate("fecha_creacion")
                                    , OracleConection.getInstance().getString("tipo")
                                    , OracleConection.getInstance().getString("consulta")
                                    , OracleConection.getInstance().getString("nombre")
                                    , OracleConection.getInstance().getString("rut")
                                    , OracleConection.getInstance().getString("rol")
                                ));
            
        }     
        return log;
    }
}
