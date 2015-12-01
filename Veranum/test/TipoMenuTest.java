
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import veranum.DAO.DAOTipoMenu;
import veranum.entities.ClTipoMenu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zacarias
 */
public class TipoMenuTest {
    public TipoMenuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Tipo menú");
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
   public void Test01CreacionTipoMenu() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Tipo menú");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOTipoMenu.sqlInsert(new ClTipoMenu("Tipo menú prueba")));
            System.out.println("Agregar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test02EditarTipoMenu() {
       System.out.println("------------------------------------");
       System.out.println("Editar de Tipo menú");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOTipoMenu.sqlUpdate(new ClTipoMenu(5,"menú MOD")));
            System.out.println("Editar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test03BorrarTipoMenu() throws SQLException {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Tipo menú");
       System.out.println("------------------------------------");
       if(DAOTipoMenu.sqlDelete(new ClTipoMenu(5))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
