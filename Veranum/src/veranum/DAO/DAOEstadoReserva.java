/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.DAO;

import java.util.ArrayList;
import veranum.entities.ClEstadoReserva;
import veranum.utilidades.OracleConection;

/**
 *
 * @author carlosdlg
 */
public class DAOEstadoReserva {
    public static ArrayList sqlLeerTodos(){
        ArrayList<ClEstadoReserva> estado = new ArrayList<>();        
        if(!OracleConection.getInstance().sqlSelect("SELECT * FROM \"estado_reservas\"")){
            return null;
        }
        while(OracleConection.getInstance().sqlFetch()){
            estado.add(new ClEstadoReserva(OracleConection.getInstance().getInt("id_reserva_estado")
                                    , OracleConection.getInstance().getString("nombre")
                                ));
            
        }     
        return estado;
    }
}
