
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import veranum.DAO.DAOProvincia;
import veranum.entities.ClProvincia;

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
public class ProvinciasTest {
    public ProvinciasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Provincias");
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
   public void Test01CreacionProvincias() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Provincias");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOProvincia.sqlInsert(new ClProvincia("Provincia test", 1)));
            System.out.println("Agregar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test02EditarProvincias() {
       System.out.println("------------------------------------");
       System.out.println("Editar de Provincias");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOProvincia.sqlUpdate(new ClProvincia(54,"Direccion MOD",1)));
            System.out.println("Editar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test03BorrarProvincias() throws SQLException {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Provincias");
       System.out.println("------------------------------------");
       if(DAOProvincia.sqlDelete(new ClProvincia(54))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
