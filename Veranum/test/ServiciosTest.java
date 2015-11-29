
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import veranum.DAO.DAOServicios;
import veranum.entities.ClServicios;


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
public class ServiciosTest {
    public ServiciosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Servicios");
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
   public void Test01CreacionServicios() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Servicios");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOServicios.sqlInsert(new ClServicios("servicio prueba",99)));
            System.out.println("Agregar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test02EditarServicios() {
       System.out.println("------------------------------------");
       System.out.println("Editar de Servicios");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOServicios.sqlUpdate(new ClServicios(5, "servicio MOD",89)));
            System.out.println("Editar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test03BorrarServicios() {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Servicios");
       System.out.println("------------------------------------");
       if(DAOServicios.sqlDelete(new ClServicios(5))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
