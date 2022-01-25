import Models.Sala;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testSala {
    private Sala sala = new Sala(5, 9);

    @Test
    void testGetButacasLibres(){
       assertEquals(45,sala.getButacasLibres());
    }
    @Test
    void testGetButacasReservadas(){
        assertEquals(0,sala.getButacasReservadas());
    }
    @Test
    void testGetButacasOcupadad(){
        assertEquals(0,sala.getButacasOcupadas());
    }
   @Test
    void testIncreaseRecaudacion(){
        assertEquals(6,sala.increaseRecaudacion());
   }
   @Test
    void testDecreaseRecaudacion(){
        assertEquals(-1,sala.decreaseRecaudacion());
        sala.setRecaudacion(12);
        assertEquals(6,sala.decreaseRecaudacion());
   }
   @Test
   void testItsReserved(){
       Assertions.assertAll(
               ()->assertFalse(sala.itsFree('A',0)),
               ()->assertTrue(sala.itsReserved('A',0))
        );
   }
   @Test
    void testItsFree(){
        Assertions.assertAll(
                ()->assertFalse(sala.itsReserved('A',0)),
                ()->assertTrue(sala.itsFree('A',0))
        );
   }
   @Test
    void testComprarButaca(){
        Assertions.assertAll(
                ()->assertTrue(sala.buyButaca('A',0)),
                ()->assertFalse(sala.buyButaca('A',0))
        );

   }
   @Test
    void testReservaButaca(){
        Assertions.assertAll(
                ()->assertTrue(sala.buyButaca('A',0)),
                ()->assertFalse(sala.buyButaca('A',0))
        );
   }
}
