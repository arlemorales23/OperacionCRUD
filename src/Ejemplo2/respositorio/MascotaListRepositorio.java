package Ejemplo2.respositorio;

import Ejemplo2.modelo.Mascota;
import org.cue.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class MascotaListRepositorio implements  CrudRepositorio2{

    private List<Mascota> dataSource;

    public MascotaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }
    @Override
    public List<Mascota> listar() {
        return dataSource;
    }

    @Override
    public Mascota porId(Integer id) {
        Mascota resultado = null;
        for(Mascota mas: dataSource){
            if(mas.getId() != null && mas.getId().equals(id)){
                resultado = mas;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(Mascota mascota) {
        this.dataSource.add(mascota);
    }

    @Override
    public void editar(Mascota mascota) {
        Mascota m = this.porId(mascota.getId());
        m.setNombreMascota(mascota.getNombreMascota());
        m.setRaza(mascota.getRaza());
    }

    @Override
    public void eliminar(Integer id) {
        this.dataSource.remove(this.porId(id));
    }
    @Override
    public int total() {
        return this.dataSource.size();
    }
}
