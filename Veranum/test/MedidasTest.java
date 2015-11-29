
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import veranum.DAO.DAOMedidas;
import veranum.entities.ClMedidas;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zacarias
 */
public class MedidasTest {
    public MedidasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Medidas");
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
   public void Test01CreacionMedidas() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Medidas");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOMedidas.sqlInsert(new ClMedidas("Medida test")));
            System.out.println("Agregar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test02EditarMedidas() {
       System.out.println("------------------------------------");
       System.out.println("Editar de Medidas");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOMedidas.sqlUpdate(new ClMedidas(6,"medida MOD")));
            System.out.println("Editar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test03BorrarMedidas() {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Medidas");
       System.out.println("------------------------------------");
       if(DAOMedidas.sqlDelete(new ClMedidas(6))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
