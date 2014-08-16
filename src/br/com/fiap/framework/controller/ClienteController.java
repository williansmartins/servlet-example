package br.com.fiap.framework.controller;

import java.util.List;

import br.com.fiap.framework.dao.ClienteDAO;
import br.com.fiap.framework.entidades.Cliente;

public class ClienteController {

	public List<Cliente> findClientes(){
		ClienteDAO dao = new ClienteDAO();
		return dao.listar();
	}
	
	public Cliente findById(Long id){
		ClienteDAO dao = new ClienteDAO();
		return dao.findReferenceOnly(id);
	}
	
	public List<Cliente> findByNome(String nome){
		ClienteDAO dao = new ClienteDAO();
		return dao.findByNomeLike(nome);
	}
}