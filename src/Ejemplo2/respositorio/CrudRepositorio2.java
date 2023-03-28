package Ejemplo2.respositorio;

import Ejemplo2.modelo.Mascota;
import org.cue.poointerfaces.modelo.Cliente;

import java.util.List;

public interface CrudRepositorio2 {
    List<Mascota> listar();
    Mascota porId(Integer id);
    void crear(Mascota mascota);
    void editar(Mascota mascota);
    void eliminar(Integer id);
    public int total();
}
