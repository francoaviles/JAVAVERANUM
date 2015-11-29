
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import veranum.DAO.DAOHotelCaract;
import veranum.entities.ClHotelCaract;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zacarias
 */
public class HotelCarctTest {
    public HotelCarctTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Hotel Características");
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
   public void Test01CreacionHotelCaract() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Hotel Características");
       System.out.println("------------------------------------");
       assertTrue(DAOHotelCaract.sqlInsert(new ClHotelCaract(1, 1)));
       System.out.println("Agregar existoso. ");
   }
   
   
   @Test
   public void Test03BorrarHotelCaract() {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Hotel Características");
       System.out.println("------------------------------------");
       if(DAOHotelCaract.sqlDelete(new ClHotelCaract(29))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
