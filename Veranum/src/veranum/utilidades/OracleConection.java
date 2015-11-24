/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veranum.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    
    public static OracleConection db = null;
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
        
    public static OracleConection getInstance() {
        if (db == null) {
            db = new OracleConection().Conectar();
        }
        return db;
    }
     
    public Connection getConexion(){
        return conexion;
    }
    
    public void setConexion(Connection conexion){
        this.conexion = conexion;
    }
    
    public OracleConection Conectar(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            //String BD = "jdbc:oracle:thin:@localhost:1521:xe";
            //conexion = DriverManager.getConnection(BD,"portafolio","asd");
            //String BD = "jdbc:oracle:thin:@10.20.66.49:1521:xe";
            String BD = "jdbc:oracle:thin:@localhost:1521:xe";
            conexion = DriverManager.getConnection(BD,"portafolio","asd");
            st = (Statement) conexion.createStatement();
            if(conexion!=null){
                System.out.println("Conexion exitosa system");
            }else{
                System.out.println("fallo!");
            }
        }
         catch(ClassNotFoundException | SQLException e){
                 System.out.println("Error a conectar " + e.getMessage());
        }
        return this;
    }
    
    public PreparedStatement sqlPreparar(String sql){
        try {
            ps = conexion.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(OracleConection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }
    
    
    public boolean sqlEjecutarPreparacion(){
        try {
            rs = ps.executeQuery();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OracleConection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        
    public boolean sqlEjecutar(String sql){
        try {
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("Error EJECUTAR 1 " + ex.getMessage());
            return false;
        }
        return true;
    }     
    
    public boolean sqlEjecutar(String sql, String pk){
        try {
            System.out.println(sql);
            ps = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error EJECUTAR 2 " + ex.getMessage());
            ex.getStackTrace();
            return false;
        }
        return true;
    } 
    
    public int sqlLastID(String secuencia)
    {
        int id = 0;
        try {
            ResultSet generatedKeys = st.executeQuery("SELECT "+secuencia+".CURRVAL FROM DUAL");
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OracleConection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
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
}
