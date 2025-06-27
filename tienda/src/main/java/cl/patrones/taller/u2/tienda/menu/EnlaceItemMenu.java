package cl.patrones.taller.u2.tienda.menu;

import java.util.Collections;
import java.util.List;

public class EnlaceItemMenu implements ItemMenu {

    private final String texto;
    private final String enlace;
    private final boolean tieneHijos;
    private final List<? extends ItemMenu> hijos;

    // Constructor para enlaces sin hijos (ej. Inicio, Ubicación, Contacto)
    public EnlaceItemMenu(String texto, String enlace) {
        this.texto = texto;
        this.enlace = enlace;
        this.tieneHijos = false;
        this.hijos = Collections.emptyList();
    }

    // Constructor para enlaces con hijos (ej. Categorías con subcategorías)
    public EnlaceItemMenu(String texto, String enlace, boolean tieneHijos, List<? extends ItemMenu> hijos) {
        this.texto = texto;
        this.enlace = enlace;
        this.tieneHijos = tieneHijos;
        this.hijos = hijos;
    }

    @Override
    public String getTexto() {
        return texto;
    }

    @Override
    public String getSlug() {
        return null; // No aplica para enlaces estáticos
    }

    @Override
    public String getEnlace() {
        return enlace;
    }

    @Override
    public boolean tieneHijos() {
        return tieneHijos;
    }

    @Override
    public List<? extends ItemMenu> getHijos() {
        return hijos;
    }
}
