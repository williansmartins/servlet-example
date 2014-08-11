package br.com.fiap.framework.testes;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import br.com.fiap.framework.dao.BoletoDAO;
import br.com.fiap.framework.dao.NotaFiscalServicoDAO;
import br.com.fiap.framework.entidades.Boleto;
import br.com.fiap.framework.entidades.NotaFiscalServico;

public class Testes {

	@Test
	public void persisteBoleto(){
		Calendar data = Calendar.getInstance();
		data.setTime(new Date());
		
		Boleto boleto = new Boleto("34191690282945517091900827590001124999");
		boleto.setNomeBanco("Banco FIAP");
		boleto.setObservacao("Após vencimento deverá ser cobrado multa de R$ 1,00 ao dia.");
		boleto.setDataDocumento(data);
		boleto.setDataVencimento(data);
		boleto.setValorDocumento(new BigDecimal("1500.00"));
		boleto.setMulta(new BigDecimal("0.00"));
		boleto.setValorCobrado(new BigDecimal("1500.00"));
		
		BoletoDAO dao = new BoletoDAO();
		dao.inserir(boleto);
		System.out.println(boleto.toString());
	}
	
	@Test
	public void persisteNotaFiscalServico(){
		Calendar data = Calendar.getInstance();
		data.setTime(new Date());
		
		NotaFiscalServico nfs = new NotaFiscalServico(new Long(1));
		nfs.setDiscriminacaoGeral("Troca do piso dos andares inferiores.");
		nfs.setData(data);
		nfs.setValor(new BigDecimal("300.00"));
		
		NotaFiscalServicoDAO dao = new NotaFiscalServicoDAO();
		dao.inserir(nfs);
		System.out.println(nfs.toString());
	}
}