package br.com.fiap.framework.testes;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import br.com.fiap.framework.controller.ConversorEntidadeXML;
import br.com.fiap.framework.dao.ClienteDAO;
import br.com.fiap.framework.entidades.Arquivo;
import br.com.fiap.framework.entidades.Boleto;
import br.com.fiap.framework.entidades.Cliente;
import br.com.fiap.framework.entidades.Dados;
import br.com.fiap.framework.entidades.NotaFiscalServico;
import br.com.fiap.framework.entidades.NotasFiscaisServico;
import br.com.fiap.framework.entidades.Relatorio;

public class TesteGeral {

	public static void main(String[] args) {
		new TesteGeral().gravar2();
		//(new Testes()).persisteBoleto();
		//(new Testes()).persisteNotaFiscalServico();
	}
	
	@Test
	public void gravar(){
		Calendar data = Calendar.getInstance();
		data.setTime(new Date());
		
		try{
			Cliente c = new Cliente()
			.comCodigo(new Long(1))
			.comNome("Fiap")
			.comEndereco("Av. Lins de Vanconcelos, 5000")
			.comCidade("São Paulo")
			.comEstado("SP")
			.comCnpj("12.000.001/0001-66")
			.comNotaFiscalServico(new NotaFiscalServico()
					.comNumero(new Long(1))
					.comDiscriminacaoGeral("Limpeza do ar condicionado.")
					.comData(data)
					.comValor(new BigDecimal("200.00")))
			.comNotaFiscalServico(new NotaFiscalServico()
					.comNumero(new Long(2))
					.comDiscriminacaoGeral("Conserto do sistema de iluminação.")
					.comData(data)
					.comValor(new BigDecimal("500.00")))
			.comNotaFiscalServico(new NotaFiscalServico()
					.comNumero(new Long(3))
					.comDiscriminacaoGeral("Troca do piso dos andares inferiores.")
					.comData(data)
					.comValor(new BigDecimal("300.00")))
			.comNotaFiscalServico(new NotaFiscalServico()
					.comNumero(new Long(4))
					.comDiscriminacaoGeral("Troca do piso dos andares inferiores.")
					.comData(data)
					.comValor(new BigDecimal("300.00")))
			.comBoleto(new Boleto()
					.comCodigoBarra("34191690282945517091900827590001124999")
					.comNomeBanco("Banco FIAP")
					.comObservacao("Após vencimento deverá ser cobrado multa de R$ 1,00 ao dia.")
					.comDataDocumento(data)
					.comDataVencimento(data)
					.comValorDocumento(new BigDecimal("1500.00"))
					.comMulta(new BigDecimal("0.00"))
					.comValorCobrado(new BigDecimal("1500.00")));
			
			ClienteDAO dao = new ClienteDAO();
			dao.inserir(c);
			
			Relatorio relatorio = new Relatorio()
								.comDados(new Dados()
										.comArquivo(new Arquivo()
												.comCliente(c)
												.comBoleto(c.getBoletos().get(0))
												.comNotasFiscaisServico(new NotasFiscaisServico()
														.comNota(c.getNotas()))));
						
			String xml = (new ConversorEntidadeXML()).gerarXML(relatorio);
			System.out.println(xml);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void gravar2(){
		Calendar data = Calendar.getInstance();
		data.setTime(new Date());
		
		try{
			Cliente c = new Cliente()
			.comCodigo(new Long(1))
			.comNome("Atlantic Solutions")
			.comEndereco("Alphaville - Barueri")
			.comCidade("São Paulo")
			.comEstado("SP")
			.comCnpj("12.3455/0001-66")
			.comNotaFiscalServico(new NotaFiscalServico()
					.comNumero(new Long(1))
					.comDiscriminacaoGeral("Produto1")
					.comData(data)
					.comValor(new BigDecimal("200.00")))
			.comNotaFiscalServico(new NotaFiscalServico()
					.comNumero(new Long(2))
					.comDiscriminacaoGeral("Produto2.")
					.comData(data)
					.comValor(new BigDecimal("500.00")))
			.comNotaFiscalServico(new NotaFiscalServico()
					.comNumero(new Long(3))
					.comDiscriminacaoGeral("Produto3.")
					.comData(data)
					.comValor(new BigDecimal("300.00")))
			.comNotaFiscalServico(new NotaFiscalServico()
					.comNumero(new Long(4))
					.comDiscriminacaoGeral("Produto4.")
					.comData(data)
					.comValor(new BigDecimal("300.00")))
			.comBoleto(new Boleto()
					.comCodigoBarra("34191690282945517091900827590001124999")
					.comNomeBanco("Banco SPPREV")
					.comObservacao("Após vencimento deverá ser cobrado multa de R$ 1,00 ao dia.")
					.comDataDocumento(data)
					.comDataVencimento(data)
					.comValorDocumento(new BigDecimal("2500.00"))
					.comMulta(new BigDecimal("0.00"))
					.comValorCobrado(new BigDecimal("15.00")));
			
			ClienteDAO dao = new ClienteDAO();
			dao.inserir(c);
			
			Relatorio relatorio = new Relatorio()
								.comDados(new Dados()
										.comArquivo(new Arquivo()
												.comCliente(c)
												.comBoleto(c.getBoletos().get(0))
												.comNotasFiscaisServico(new NotasFiscaisServico()
														.comNota(c.getNotas()))));
						
			String xml = (new ConversorEntidadeXML()).gerarXML(relatorio);
			System.out.println(xml);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}