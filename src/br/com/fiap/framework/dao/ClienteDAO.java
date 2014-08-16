package br.com.fiap.framework.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.fiap.framework.entidades.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> {

	private static final long serialVersionUID = 1L;

	public ClienteDAO() {
		super(Cliente.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> findByNomeLike(String nome) {
		Query query = getEm().createQuery("Select c from Cliente c where c.nome like :nome");
		query.setParameter("nome", "%"+nome+"%");
		List<Cliente> clientes = (List<Cliente>) query.getResultList();
		return clientes;
	}
}