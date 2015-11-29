
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import veranum.DAO.DAOHotelServicio;
import veranum.entities.ClHotelServicios;

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
public class HotelServicioTest {
    public HotelServicioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       System.out.println("Pruebas a Hoteles Servicio");
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
   public void Test01CreacionHotelSer() {
       System.out.println("------------------------------------");
       System.out.println("Creación de Hotel Servicio");
       System.out.println("------------------------------------");
       assertTrue(DAOHotelServicio.sqlInsert(new ClHotelServicios(1, 1)));
       System.out.println("Agregar existoso. ");
   }
   
   @Test
   public void Test03BorrarHotelSer() {
       System.out.println("------------------------------------");
       System.out.println("Eliminación de Hotel Servicio");
       System.out.println("------------------------------------");
       if(DAOHotelServicio.sqlDelete(new ClHotelServicios(25))){
            assertTrue(true);
            System.out.println("borrar existoso. ");
       }
   }
}
