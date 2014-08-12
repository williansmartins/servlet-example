package br.com.fiap.framework.controller;

import java.util.Collection;

import br.com.fiap.framework.dao.NotaFiscalServicoDAO;
import br.com.fiap.framework.entidades.Cliente;
import br.com.fiap.framework.entidades.NotaFiscalServico;
import br.com.fiap.framework.entidades.Report;

public class XmlController {

	public Boolean gravarXML(String xml) {
		try {
			Report report = (new ConversorEntidadeXML()).getRelatorio(xml);
			Cliente cliente = report.getDados().getArquivo().getCliente();
			Collection<NotaFiscalServico> nfss = report.getDados().getArquivo().getNotasFiscaisServico().getNotaFiscalServico();
			(new NotaFiscalServicoDAO()).insert(cliente, nfss);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}