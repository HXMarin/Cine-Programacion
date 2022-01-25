import Models.Butaca;
import Models.EstadoButacas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testButaca {
    private Butaca butaca = new Butaca();
    @Test
    void testSetEstado(){
        assertEquals(EstadoButacas.LIBRE,butaca.getEstado());
    }
    @Test
    void testGetEstado(){
        butaca.setEstado(EstadoButacas.OCUPADA);
        assertEquals(EstadoButacas.OCUPADA,butaca.getEstado());
    }
}
