
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import veranum.DAO.DAOEstadoHab;
import veranum.entities.ClHabitacionEstados;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zacarias
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EstadoHab {
    public EstadoHab() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Estado Habitaciones");
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
   public void Test01CreacionEstHab() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Estado Habitaciones");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOEstadoHab.sqlInsert(new ClHabitacionEstados("TEST")));
            System.out.println("Agregar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test02EditarEstHab() {
       System.out.println("------------------------------------");
       System.out.println("Editar de Estado Habitaciones");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOEstadoHab.sqlUpdate(new ClHabitacionEstados(4, "estado MOD")));
            System.out.println("Editar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test03BorrarEstHab() {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Estado Habitaciones");
       System.out.println("------------------------------------");
       if(DAOEstadoHab.sqlDelete(new ClHabitacionEstados(4))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
