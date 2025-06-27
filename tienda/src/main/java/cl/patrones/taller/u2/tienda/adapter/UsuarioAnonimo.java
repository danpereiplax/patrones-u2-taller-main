package cl.patrones.taller.u2.tienda.adapter;

import cl.patrones.taller.u2.clientes.Cliente;

public class UsuarioAnonimo extends Usuario {

	public UsuarioAnonimo() {
		super(clienteAnonimo());
	}

	private static Cliente clienteAnonimo() {
		Cliente anon = new Cliente();
		anon.setNombre("Anónimo");
		anon.setEmail("");
		anon.setContrasena("");
		anon.setDireccion("");
		anon.setComuna("");
		return anon;
	}
}
