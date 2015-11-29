/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import veranum.DAO.DAOHoteles;
import veranum.entities.ClHoteles;
/**
 *
 * @author carlosdlg
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HotelesTest {
    
    public HotelesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Hoteles");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   @Test
   public void Test01CreacionHotel() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Hotel");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOHoteles.sqlInsert(new ClHoteles(1, 1, 1, 1, "Hotel prueba", "Direccion")));
            System.out.println("Agregar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test02EditarHotel() {
       System.out.println("------------------------------------");
       System.out.println("Editar de Hotel");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOHoteles.sqlUpdate(new ClHoteles(7, 1, 1, 1, 1, "Hotel prueba MOD", "Direccion MOD")));
            System.out.println("Editar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test03BorrarHotel() {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Hotel");
       System.out.println("------------------------------------");
       if(DAOHoteles.sqlDelete(new ClHoteles(7))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
