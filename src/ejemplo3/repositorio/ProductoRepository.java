package ejemplo3.repositorio;

import ejemplo3.modelo.Producto;

import java.util.List;

public interface ProductoRepository {
    Producto findById(int id);
    List<Producto> findAll();
    void save(Producto producto);
    void update(Producto producto);
    void delete(Producto producto);
}
