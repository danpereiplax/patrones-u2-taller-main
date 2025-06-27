package cl.patrones.taller.u2.catalogo.domain;

import cl.patrones.taller.u2.bodegaje.domain.Producto;

public class Aviso {

	private Long id;
	private String sku;
	private String titulo;
	private String imagen;
	private Long precio;
	private int stock;
	private Categoria categoria;

	public Aviso() {
		super();
	}

	public Aviso(Long id, String sku, String titulo, Long precio, String imagen, int stock, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.sku = sku;
		this.precio = precio;
		this.imagen = imagen;
		this.stock = stock;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	// 🆕 Este método es requerido por AvisoServiceImpl
	public static Aviso desdeProducto(Producto producto, int stock, Categoria categoria) {
		Aviso aviso = new Aviso();
		aviso.setSku(producto.getSku());
		aviso.setTitulo(producto.getNombre());
		aviso.setImagen(producto.getImagen());
		aviso.setPrecio(Math.round(producto.getCosto() * 1.3)); // 30% utilidad
		aviso.setStock(stock);
		aviso.setCategoria(categoria);
		return aviso;
	}
}
