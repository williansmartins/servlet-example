package br.com.fiap.framework.testes;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import br.com.fiap.framework.controller.XMLBeanConversor;
import br.com.fiap.framework.entidades.Arquivo;
import br.com.fiap.framework.entidades.Boleto;
import br.com.fiap.framework.entidades.Cliente;
import br.com.fiap.framework.entidades.Dados;
import br.com.fiap.framework.entidades.NotaFiscalServico;
import br.com.fiap.framework.entidades.NotasFiscaisServico;
import br.com.fiap.framework.entidades.Relatorio;

public class TesteMarshall {

	@Test
	public void gravar() {
		Calendar data = Calendar.getInstance();
		data.setTime(new Date());
		
		try {
			Cliente c = new Cliente()
						.comNome("SynapSystem Ltda")
						.comEndereco("Av. Lins de Vanconcelos, 5000")
						.comCidade("São Paulo")
						.comEstado("SP")
						.comCnpj("12.000.001/0001-66")
						.comNotaFiscal(new NotaFiscalServico()
								.comDiscriminacaoGeral("Limpeza do ar condicionado.")
								.comData(data)
								.comValor(new BigDecimal("200.00")))
						.comNotaFiscal(new NotaFiscalServico()
								.comDiscriminacaoGeral("Conserto do sistema de iluminação.")
								.comData(data)
								.comValor(new BigDecimal("500.00")))
						.comNotaFiscal(new NotaFiscalServico()
								.comDiscriminacaoGeral("Troca do piso dos andares inferiores.")
								.comData(data)
								.comValor(new BigDecimal("300.00")))
						.comNotaFiscal(new NotaFiscalServico()
								.comDiscriminacaoGeral("Troca do piso dos andares inferiores.")
								.comData(data)
								.comValor(new BigDecimal("300.00")))
						.comBoleto(new Boleto()
								.comCodigoBarra("34191690282945517091900827590001124999")
								.comNomeBanco("Banco FIAP")
								.comObservacao("Após vencimento deverá ser cobrado multa de R$ 1,00 ao dia.")
								.comDataDocumento(data)
								.comValorDocumento(new BigDecimal("1500.00"))
								.comValorCobrado(new BigDecimal("0.00"))
								.comValorCobrado(new BigDecimal("1500.00")));
			
			Relatorio relatorio = new Relatorio()
					.comDados(new Dados()
							.comArquivo(new Arquivo()
									.comCliente(c)
									.comBoleto(c.getBoletos().get(0))
									.comNotasFiscaisServico(new NotasFiscaisServico()
											.comNota(c.getNotas()))));
			
			String xml = (new XMLBeanConversor()).relatorioParaXML(relatorio);
			System.out.println(xml);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void produzirMarshallDoBD() {
		
		TestePersistencia dao = new TestePersistencia();
		Relatorio r = dao.pesquisar();
		String xml = (new XMLBeanConversor()).relatorioParaXML(r);
		System.out.println(xml);
	}	
}