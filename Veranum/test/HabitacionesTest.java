
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import veranum.DAO.DAOHabitaciones;
import veranum.entities.ClHabitaciones;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zacarias
 */
public class HabitacionesTest {
    public HabitacionesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Habitaciones");
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
   public void Test01CreacionHab() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Habitaciones");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOHabitaciones.sqlInsert(new ClHabitaciones(1, 1, 1,"1a",10,9999)));
            System.out.println("Agregar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test02EditarHab() {
       System.out.println("------------------------------------");
       System.out.println("Editar de Habitaciones");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOHabitaciones.sqlUpdate(new ClHabitaciones(9,1,1,1,"modificado",10,9999)));
            System.out.println("Editar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test03BorrarHab() throws SQLException {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Habitaciones");
       System.out.println("------------------------------------");
       if(DAOHabitaciones.sqlDelete(new ClHabitaciones(9))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
