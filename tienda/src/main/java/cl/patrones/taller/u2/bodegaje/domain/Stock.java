package cl.patrones.taller.u2.bodegaje.domain;

import jakarta.persistence.*;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Bodega bodega;

    @ManyToOne
    private Producto producto;

    private int cantidad;

    public Stock(Bodega bodega, Producto producto, int cantidad) {
        this.bodega = bodega;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Stock() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Stock [cantidad=" + cantidad + ", producto=" + producto.getNombre() + ", bodega=" + bodega.getNombre() + "]";
    }
}
