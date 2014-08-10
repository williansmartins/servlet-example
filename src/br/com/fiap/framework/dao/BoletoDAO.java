package br.com.fiap.framework.dao;

import br.com.fiap.framework.entidades.Boleto;

public class BoletoDAO extends GenericDAO<Boleto> {

	private static final long serialVersionUID = 1L;

	public BoletoDAO() {
		super(Boleto.class);
	}
}