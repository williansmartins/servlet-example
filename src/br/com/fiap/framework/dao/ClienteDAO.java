package br.com.fiap.framework.dao;

import br.com.fiap.framework.entidades.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> {

	private static final long serialVersionUID = 1L;

	public ClienteDAO() {
		super(Cliente.class);
	}
}