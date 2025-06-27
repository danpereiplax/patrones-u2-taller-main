package cl.patrones.taller.u2.bodegaje.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

import cl.patrones.taller.u2.catalogo.domain.Categoria;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sku;
    private String nombre;
    private String imagen;
    private Long costo;

    @ManyToOne
	@JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Stock> stocks = new ArrayList<>();

    public Producto() {}

    public Producto(String sku, String nombre, Long costo, String imagen) {
        this.sku = sku;
        this.nombre = nombre;
        this.costo = costo;
        this.imagen = imagen;
    }

    // Getters y setters...

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Long getCosto() { return costo; }
    public void setCosto(Long costo) { this.costo = costo; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public List<Stock> getStocks() { return stocks; }
    public void setStocks(List<Stock> stocks) { this.stocks = stocks; }

    public List<Bodega> getBodegas() {
        List<Bodega> bodegas = new ArrayList<>();
        for (Stock stock : stocks) {
            bodegas.add(stock.getBodega());
        }
        return bodegas;
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", costo=" + costo +
                ", stocks=" + stocks.stream().mapToInt(Stock::getCantidad).sum() + "]";
    }
}
