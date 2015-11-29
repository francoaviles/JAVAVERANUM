
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import veranum.DAO.DAORegiones;
import veranum.entities.ClRegion;

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
public class RegionTest {
    public RegionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Región");
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
   public void Test01CreacionRegion() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Región");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAORegiones.sqlInsert(new ClRegion("Región prueba", "XX")));
            System.out.println("Agregar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test02EditarRegion() {
       System.out.println("------------------------------------");
       System.out.println("Editar de Región");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAORegiones.sqlUpdate(new ClRegion(16, "REgión prueba MOD", "XX MOD")));
            System.out.println("Editar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test03BorrarRegion() {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Región");
       System.out.println("------------------------------------");
       if(DAORegiones.sqlDelete(new ClRegion(16))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
