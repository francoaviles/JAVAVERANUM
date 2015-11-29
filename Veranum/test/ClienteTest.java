
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import veranum.DAO.DAOCliente;
import veranum.entities.ClPasajeros;

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
public class ClienteTest {
    public ClienteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Clientes");
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
   public void Test01CreacionCliente() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Cliente");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOCliente.sqlInsert(new ClPasajeros("112454683","test","test","test","test","test","test","test",TO_DATE("25/11/1968", dd/MM/yyyy),3)));
            System.out.println("Agregar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test02EditarCliente() {
       System.out.println("------------------------------------");
       System.out.println("Editar de Hotel");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOCliente.sqlUpdate(new ClPasajeros("112454683","test","test","test","test","test","test","test",TO_DATE("25/11/1968", dd/MM/yyyy),3,6)));
            System.out.println("Editar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test03BorrarCliente() {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Cliente");
       System.out.println("------------------------------------");
       if(DAOCliente.sqlDelete(new ClPasajeros(7))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
