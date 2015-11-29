
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import veranum.DAO.DAOTipoCaract;
import veranum.entities.ClTipoCaracteristicas;

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
public class TipoCaractTest {
    public TipoCaractTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Tipo Características");
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
   public void Test01CreacionTipoCaract() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Tipo Características");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOTipoCaract.sqlInsert(new ClTipoCaracteristicas("tipo caract prueba", "descrip prueba")));
            System.out.println("Agregar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test02EditarTipoCaract() {
       System.out.println("------------------------------------");
       System.out.println("Editar de Tipo Características");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOTipoCaract.sqlUpdate(new ClTipoCaracteristicas(5, "tipo caract MOD", "descrip MOD")));
            System.out.println("Editar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test03BorrarTipoCaract() {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Tipo Características");
       System.out.println("------------------------------------");
       if(DAOTipoCaract.sqlDelete(new ClTipoCaracteristicas(5))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
