package br.com.fiap.framework.dao;

import java.util.Collection;

import br.com.fiap.framework.entidades.Cliente;
import br.com.fiap.framework.entidades.NotaFiscalServico;

public class NotaFiscalServicoDAO extends GenericDAO<NotaFiscalServico> {

	private static final long serialVersionUID = 1L;

	public NotaFiscalServicoDAO() {
		super(NotaFiscalServico.class);
	}
	
	public void insert(Collection<NotaFiscalServico> nfss){
		for (NotaFiscalServico notaFiscalServico : nfss) {
			(new NotaFiscalServicoDAO()).inserir(notaFiscalServico);
		}
	}
	
	public void insert(Cliente cliente, Collection<NotaFiscalServico> nfss){
		(new ClienteDAO()).inserir(cliente);
		for (NotaFiscalServico notaFiscalServico : nfss) {
			(new NotaFiscalServicoDAO()).inserir(notaFiscalServico);
		}
	}
}