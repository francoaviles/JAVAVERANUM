
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import veranum.DAO.DAOComuna;
import veranum.entities.ClComuna;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zacarias
 */
public class ComunaTest {
    public ComunaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Comuna");
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
   public void Test01CreacionComuna() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Comuna");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOComuna.sqlInsert(new ClComuna("comuna test",1)));
            System.out.println("Agregar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test02EditarComuna() {
       System.out.println("------------------------------------");
       System.out.println("Editar de Comuna");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOComuna.sqlUpdate(new ClComuna(346,"comuna MOD",1)));
            System.out.println("Editar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test03BorrarComuna() throws SQLException {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Comuna");
       System.out.println("------------------------------------");
       if(DAOComuna.sqlDelete(new ClComuna(346))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
