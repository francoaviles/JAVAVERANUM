
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import veranum.DAO.DAOHotelInsumos;
import veranum.entities.ClHotelInsumos;


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
public class HotelInsumoTest {
    public HotelInsumoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Hoteles Insumos");
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
   public void Test01CreacionHotelInsumo() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Hotel Insumos");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOHotelInsumos.sqlInsert(new ClHotelInsumos(1,1,1,12)));
            System.out.println("Agregar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test02EditarHotelInsumo() {
       System.out.println("------------------------------------");
       System.out.println("Editar de Hotel Insumos");
       System.out.println("------------------------------------");
        try {
            assertTrue(DAOHotelInsumos.sqlUpdate(new ClHotelInsumos(2,2,2,2,24)));
            System.out.println("Editar existoso. ");
        } catch (SQLException ex) {
            assertTrue(false);
        }
   }
   
   @Test
   public void Test03BorrarHotelInsumo() {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Hotel Insumos");
       System.out.println("------------------------------------");
       if(DAOHotelInsumos.sqlDelete(new ClHotelInsumos(2))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
