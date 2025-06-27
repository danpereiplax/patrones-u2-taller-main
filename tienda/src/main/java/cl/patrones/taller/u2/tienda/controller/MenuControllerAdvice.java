package cl.patrones.taller.u2.tienda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.service.CategoriaService;
import cl.patrones.taller.u2.tienda.menu.CategoriaItemMenu;
import cl.patrones.taller.u2.tienda.menu.EnlaceItemMenu;
import cl.patrones.taller.u2.tienda.menu.ItemMenu;

@ControllerAdvice
public class MenuControllerAdvice {

    private final CategoriaService categoriaService;

    public MenuControllerAdvice(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @ModelAttribute("menu")
    public List<ItemMenu> menu() {
        List<ItemMenu> items = new ArrayList<>();

        // Enlace fijo: Inicio
        items.add(new EnlaceItemMenu("Inicio", "/"));

        // Enlace con submenú: Categorías
        List<Categoria> categoriasRaiz = categoriaService.obtenerCategoriasRaiz();
        List<ItemMenu> hijosCategorias = new ArrayList<>();
        for (Categoria categoria : categoriasRaiz) {
            hijosCategorias.add(new CategoriaItemMenu(categoria));
        }
        items.add(new EnlaceItemMenu("Categorías", "/categoria", true, hijosCategorias));

        // Enlaces fijos: Ubicación y Contacto
        items.add(new EnlaceItemMenu("Ubicación", "/ubicacion"));
        items.add(new EnlaceItemMenu("Contacto", "/contacto"));

        return items;
    }
}
