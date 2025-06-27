package cl.patrones.taller.u2.tienda.menu;

import java.util.List;
import java.util.stream.Collectors;

import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.tienda.menu.util.Slugger;

public class CategoriaItemMenu implements ItemMenu {

    private final Categoria categoria;

    public CategoriaItemMenu(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String getTexto() {
        return categoria.getNombre();
    }

    @Override
    public String getSlug() {
        return Slugger.toSlug(categoria.getNombre());
    }

    @Override
    public String getEnlace() {
        return "/categoria/" + categoria.getId() + "/" + getSlug();
    }

    @Override
    public boolean tieneHijos() {
        return categoria.getSubcategorias() != null && !categoria.getSubcategorias().isEmpty();
    }

    @Override
    public List<? extends ItemMenu> getHijos() {
        if (tieneHijos()) {
            return categoria.getSubcategorias().stream()
                    .map(CategoriaItemMenu::new)
                    .collect(Collectors.toList());
        } else {
            return List.of();
        }
    }
}
