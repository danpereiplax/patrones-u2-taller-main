package cl.patrones.taller.u2.catalogo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cl.patrones.taller.u2.bodegaje.domain.Producto;
import cl.patrones.taller.u2.bodegaje.domain.Stock;
import cl.patrones.taller.u2.bodegaje.repository.ProductoRepository;
import cl.patrones.taller.u2.catalogo.domain.Aviso;
import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.repository.CategoriaRepository;

@Service
public class AvisoServiceImpl implements AvisoService {

    private final ProductoRepository productoRepository;

    public AvisoServiceImpl(ProductoRepository productoRepository, CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Aviso> getAvisos() {
        List<Aviso> avisos = new ArrayList<>();
        for (Producto producto : productoRepository.findAll()) {
            int stockTotal = producto.getStocks().stream().mapToInt(Stock::getCantidad).sum();
            Categoria categoria = producto.getCategoria();
            avisos.add(Aviso.desdeProducto(producto, stockTotal, categoria));
        }
        return avisos;
    }

    @Override
    public List<Aviso> getAvisosPorCategoria(Long categoriaId) {
        List<Aviso> avisos = new ArrayList<>();
        for (Producto producto : productoRepository.findAll()) {
            Categoria categoria = producto.getCategoria();

            System.out.println("Producto: " + producto.getNombre() + 
                ", Categoria ID: " + (categoria != null ? categoria.getId() : "null"));

            if (categoria != null && categoria.getId().equals(categoriaId)) {
                int stockTotal = producto.getStocks().stream().mapToInt(Stock::getCantidad).sum();
                avisos.add(Aviso.desdeProducto(producto, stockTotal, categoria));
                System.out.println("✓ Agregado: " + producto.getNombre());
            } else {
                System.out.println("✗ Omitido: " + producto.getNombre());
            }
        }
        System.out.println("Total avisos por categoría " + categoriaId + ": " + avisos.size());
        return avisos;
    }
}
