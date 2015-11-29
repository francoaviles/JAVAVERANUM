
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import veranum.DAO.DAOHotelTipoMenu;
import veranum.entities.ClHotelTipoMenu;

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
public class MenuHotelTest {
    public MenuHotelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Hoteles Menu");
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
   public void Test01CreacionHotelMenu() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Hotel Menu");
       System.out.println("------------------------------------");
       assertTrue(DAOHotelTipoMenu.sqlInsert(new ClHotelTipoMenu(1, 1)));
       System.out.println("Agregar existoso. ");
   }
   
   
   @Test
   public void Test03BorrarHotelMenu() {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Hotel Menu");
       System.out.println("------------------------------------");
       if(DAOHotelTipoMenu.sqlDelete(new ClHotelTipoMenu(26))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
