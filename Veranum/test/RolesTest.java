
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import veranum.DAO.DAORol;
import veranum.entities.ClRol;


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
public class RolesTest {
    public RolesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Roles");
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
   public void Test01CreacionRoles() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Roles");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAORol.sqlInsert(new ClRol("rol prueba", "descrip test")));
            System.out.println("Agregar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test02EditarRoles() {
       System.out.println("------------------------------------");
       System.out.println("Editar de Roles");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAORol.sqlUpdate(new ClRol(4,"rol prueba MOD", "descrip MOD")));
            System.out.println("Editar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test03BorrarRoles() {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Roles");
       System.out.println("------------------------------------");
       if(DAORol.sqlDelete(new ClRol(4))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
