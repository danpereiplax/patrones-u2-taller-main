package cl.patrones.taller.u2.tienda.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.patrones.taller.u2.catalogo.domain.Aviso;
import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.service.AvisoService;
import cl.patrones.taller.u2.catalogo.service.CategoriaService;

@Controller
public class TiendaController {

	private final AvisoService avisoService;
	private final CategoriaService categoriaService;

	public TiendaController(AvisoService avisoService, CategoriaService categoriaService) {
		this.avisoService = avisoService;
		this.categoriaService = categoriaService;
	}

	@GetMapping("/")
	public String inicio(Model model) {
		List<Aviso> avisos = avisoService.getAvisos();
		model.addAttribute("avisos", avisos);
		return "inicio";
	}

	@GetMapping("/categoria/{categoriaId}/{slug}")
	public String categoria(
			@PathVariable(name = "categoriaId") Long categoriaId,
			@PathVariable(name = "slug") String slug,
			Model model) {
		
		List<Aviso> avisos = avisoService.getAvisosPorCategoria(categoriaId);
		Categoria categoria = categoriaService.getCategoriaPorId(categoriaId).orElse(null);
		
		model.addAttribute("avisos", avisos);
		model.addAttribute("categoria", categoria);
		
		return "categoria";
	}

	@GetMapping("/ingresar")
	public String login() {
		return "login";
	}

	@GetMapping("/ubicacion")
	public String ubicacion() {
		return "ubicacion";
	}

	@GetMapping("/contacto")
	public String contacto() {
		return "contacto";
	}
}
