package cl.patrones.taller.u2.bodegaje.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Bodega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;

    @OneToMany(mappedBy = "bodega", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Stock> inventario;

    public Bodega() {}

    public Bodega(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    // Getters y setters...

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public List<Stock> getInventario() { return inventario; }
    public void setInventario(List<Stock> inventario) { this.inventario = inventario; }

    // Método requerido por AvisoServiceImpl
    public int getStock() {
        if (inventario != null && !inventario.isEmpty()) {
            return inventario.stream().mapToInt(Stock::getCantidad).sum();
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Bodega [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + "]";
    }
}
