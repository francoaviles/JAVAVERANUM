
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import veranum.DAO.DAOTipoRep;
import veranum.entities.ClTipoReportes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zacarias
 */
public class TipoRepTest {
    public TipoRepTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Tipo reportes");
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
   public void Test01CreacionTipoRep() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Tipo reportes");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOTipoRep.sqlInsert(new ClTipoReportes("tipo reporte prueba", "descrip test")));
            System.out.println("Agregar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test02EditarTipoRep() {
       System.out.println("------------------------------------");
       System.out.println("Editar de Tipo reportes");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOTipoRep.sqlUpdate(new ClTipoReportes(5,"tipo reporte prueba MOD", "descrip MOD")));
            System.out.println("Editar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test03BorrarTipoRep() throws SQLException {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Tipo reportes");
       System.out.println("------------------------------------");
       if(DAOTipoRep.sqlDelete(new ClTipoReportes(5))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
