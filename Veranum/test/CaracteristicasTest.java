
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import veranum.DAO.DAOCaracteristicas;
import veranum.entities.ClCaracteristicas;

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
public class CaracteristicasTest {
    public CaracteristicasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Características");
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
   public void Test01CreacionCaracteristicas() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Características");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOCaracteristicas.sqlInsert(new ClCaracteristicas(1, 1,"tipo test")));
            System.out.println("Agregar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test02EditarCaracteristicas() {
       System.out.println("------------------------------------");
       System.out.println("Editar de Características");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOCaracteristicas.sqlUpdate(new ClCaracteristicas(6, 1, 1,"tipo MOD")));
            System.out.println("Editar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test03BorrarCaracteristicas() throws SQLException {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Características");
       System.out.println("------------------------------------");
       if(DAOCaracteristicas.sqlDelete(new ClCaracteristicas(6))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
