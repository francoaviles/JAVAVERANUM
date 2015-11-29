
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import veranum.DAO.DAOHabCaract;
import veranum.entities.ClHabitacionCaract;

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
public class HabCaract {
     public HabCaract() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Habitaciones Características");
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
   public void Test01CreacionHabCaract() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Habitaciones Características");
       System.out.println("------------------------------------");
       assertTrue(DAOHabCaract.sqlInsert(new ClHabitacionCaract(1,1)));
       System.out.println("Agregar existoso. ");
   }
  

   
   @Test
   public void Test03BorrarHabCaract() {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Habitaciones Características");
       System.out.println("------------------------------------");
       if(DAOHabCaract.sqlDelete(new ClHabitacionCaract(7))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
