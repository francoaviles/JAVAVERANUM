/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zzzz
 */
public class OracleConection {
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void setConexcion(Connection conexion){
        this.conexion = conexion;
    }
    
    public OracleConection Conectar(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            //String BD = "jdbc:oracle:thin:@localhost:1521:xe";
            //conexion = DriverManager.getConnection(BD,"portafolio","asd");
            String BD = "jdbc:oracle:thin:@localhost:1521:xe";
            //String BD = "jdbc:oracle:thin:@10.20.66.125:1521:xe";
            conexion = DriverManager.getConnection(BD,"portafolio","asd");
            st = (Statement) conexion.createStatement();
            if(conexion!=null){
                System.out.println("Conexion exitosa system");
            }else{
                System.out.println("fallo!");
            }
        }
         catch(ClassNotFoundException | SQLException e){
                 System.out.println("Error conexion " + e.getMessage());
        }
        return this;
    }
        
    public boolean sqlEjecutar(String sql){
        try {
            st.execute(sql);
        } catch (Exception ex) {
            System.out.println("Error conexion " + ex.getMessage());
            return false;
        }
        return true;
    }       
    
    public boolean sqlSelect(String sql){
        try {
            rs = st.executeQuery(sql);
            System.out.println(sql);
            return true;
        } catch (Exception ex) {
            System.out.println("Error conexion " + ex.getMessage());
        }
        return false;
    }
    
    public boolean sqlFetch(){
        try {        
            return rs.next();
        } catch (Exception ex) {
            System.out.println("Error conexion " + ex.getMessage());
        }
        return false;
    }
    
    public String getString(String name){
        try {
            return rs.getString(name);
        } catch (Exception ex) {
            System.out.println("Error conexion " + ex.getMessage());
        }
        return null;
    }
    
    public int getInt(String name){
        try {
            return rs.getInt(name);
        } catch (Exception ex) {
            System.out.println("Error conexion " + ex.getMessage());
        }
        return 0;
    }
    
    public Date getDate(String name){
        try {
            return rs.getDate(name);
        } catch (Exception ex) {
            System.out.println("Error conexion " + ex.getMessage());
        }
        return null;
    }
    
    public void close(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(OracleConection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     /*
    public BD(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");}
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Duocadmin2015");
            st = (Statement) conexion.createStatement();
        } catch (Exception ex) {
            System.out.println("Error conexion " + ex.getMessage());
        }
        
    }
    
    public boolean sqlEjecutar(String sql)
    {
        try {
            st.execute(sql);
        } catch (Exception ex) {
            System.out.println("Error conexion " + ex.getMessage());
        }
        return true;
    }
    
//    public ClPais sqlSelect(String sql)
//    {
//        try {
//            ResultSet rs = st.executeQuery(sql);
//            if(!rs.next())
//            {
//                return null;
//            }
//            String codigo = rs.getString("codigo");
//            String nombre = rs.getString("nombre");
//            ClPais pp = new ClPais(codigo, nombre);
//            
//            return pp;
//            
//        } catch (SQLException ex) {
//            System.out.println("Error conexion " + ex.getMessage());
//        }
//        return null;
//    }
    
    ResultSet rs;
    
    public boolean sqlSelect(String sql)
    {
        try {
            rs = st.executeQuery(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Error conexion " + ex.getMessage());
        }
        return false;
    }
    
    public boolean sqlFetch()
    {
        try {        
            return rs.next();
        } catch (SQLException ex) {
            System.out.println("Error conexion " + ex.getMessage());
        }
        return false;
    }
    
    public String getString(String name)
    {
        try {
            return rs.getString(name);
        } catch (SQLException ex) {
            System.out.println("Error conexion " + ex.getMessage());
        }
        return null;
    }
    */
}
