
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import veranum.DAO.DAOInsumos;
import veranum.entities.ClInsumos;

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
public class InsumosTest {
    public InsumosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Insumos");
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
   public void Test01CreacionInsumos() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Insumos");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOInsumos.sqlInsert(new ClInsumos("Insumo prueba", "descrip")));
            System.out.println("Agregar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test02EditarInsumos() {
       System.out.println("------------------------------------");
       System.out.println("Editar de Insumos");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOInsumos.sqlUpdate(new ClInsumos(31,"Insumo prueba MOD", "descrip MOD")));
            System.out.println("Editar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test03BorrarInsumos() throws SQLException {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Insumos");
       System.out.println("------------------------------------");
       if(DAOInsumos.sqlDelete(new ClInsumos(31))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
