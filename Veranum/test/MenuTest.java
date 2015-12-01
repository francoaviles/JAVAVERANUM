
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import veranum.DAO.DAOMenu;
import veranum.entities.ClMenu;

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
public class MenuTest {
    public MenuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Menu");
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
   public void Test01CreacionMenu() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Menu");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOMenu.sqlInsert(new ClMenu(1,"menu prueba", 99)));
            System.out.println("Agregar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test02EditarMenu() {
       System.out.println("------------------------------------");
       System.out.println("Editar de Menu");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOMenu.sqlUpdate(new ClMenu(6, 1, "menu prueba MOD",89)));
            System.out.println("Editar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test03BorrarMenu() throws SQLException {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Menu");
       System.out.println("------------------------------------");
       if(DAOMenu.sqlDelete(new ClMenu(6))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
