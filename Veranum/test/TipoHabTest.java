
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import veranum.DAO.DAOTipoHab;
import veranum.entities.ClTipoHabitacion;

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
public class TipoHabTest {
    public TipoHabTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Tipo Habitación");
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
   public void Test01CreacionTipoHab() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Tipo Habitación");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOTipoHab.sqlInsert(new ClTipoHabitacion("TEST")));
            System.out.println("Agregar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test02EditarTipoHab() {
       System.out.println("------------------------------------");
       System.out.println("Editar de Tipo Habitación");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOTipoHab.sqlUpdate(new ClTipoHabitacion(4, "TEST MOD")));
            System.out.println("Editar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test03BorrarTipoHab() {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Tipo Habitación");
       System.out.println("------------------------------------");
       if(DAOTipoHab.sqlDelete(new ClTipoHabitacion(4))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
