package Models;

public class Butaca {
private EstadoButacas estado = EstadoButacas.LIBRE;

    public Butaca(EstadoButacas estado) {
        getEstado();
        setEstado(estado);
    }

    public Butaca() {
    }

    public EstadoButacas getEstado() {
        return estado;
    }

    public void setEstado(EstadoButacas estado) {
        this.estado = estado;
    }
}
