package Models;

public class Butaca {
private EstadoButacas estado = EstadoButacas.LIBRE;

    public Butaca() {
        setEstado(EstadoButacas.LIBRE);
    }

    public EstadoButacas getEstado() {
        return estado;
    }

    public void setEstado(EstadoButacas estado) {
        this.estado = estado;
    }
}
