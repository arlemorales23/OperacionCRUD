package ejemplo3.repositorio;

import ejemplo3.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryImpl  implements  ProductoRepository{
    private List<Producto> productos;

    public ProductoRepositoryImpl() {
        productos = new ArrayList<>();
    }

    @Override
    public Producto findById(int id) {
        return productos.stream()
                .filter(producto -> producto.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Producto> findAll() {
        return productos;
    }

    @Override
    public void save(Producto producto) {
        productos.add(producto);
    }

    @Override
    public void update(Producto producto) {
        Producto oldProducto = findById(producto.getId());
        if (oldProducto != null) {
            productos.remove(oldProducto);
            productos.add(producto);
        }
    }

    @Override
    public void delete(Producto producto) {
        productos.remove(producto);
    }
}

