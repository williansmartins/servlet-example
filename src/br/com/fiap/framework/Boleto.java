package br.com.fiap.framework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import br.com.fiap.framework.controller.BoletoController;
import br.com.fiap.framework.controller.ClienteController;
import br.com.fiap.framework.controller.ConversorEntidadeXML;
import br.com.fiap.framework.entidades.Arquivo;
import br.com.fiap.framework.entidades.Cliente;
import br.com.fiap.framework.entidades.Dados;
import br.com.fiap.framework.entidades.NotasFiscaisServico;
import br.com.fiap.framework.entidades.Relatorio;

public class Boleto extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    public Boleto() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String boleto = getBoleto(request, response);
    	
    	if (boleto != null) {
			response.getWriter().write("<html><body><br/>Boleto Gerado com sucesso! <a href='" + boleto + "' target='_blank'>Visualizar.</a></body></html>");
		} else {
			response.getWriter().write("<html><body><br/>Boleto Falhou! <a href='gerarBoletos.jsp'>Tente novamente.</a></body></html>");
		}
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String boleto = getBoleto(request, response);
    	
    	if (boleto != null) {
			response.getWriter().write("<html><body><br/>Boleto Gerado com sucesso! <a href='" + boleto + "' target='_blank'>Visualizar.</a></body></html>");
		} else {
			response.getWriter().write("<html><body><br/>Boleto Falhou! <a href='gerarBoletos.jsp'>Tente novamente.</a></body></html>");
		}
    }
    
	private String getBoleto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCliente = request.getParameter("idCliente");
		
		Cliente c = (new ClienteController()).findById(new Long(idCliente));

		try {
			Relatorio relatorio = new Relatorio();
			Arquivo arquivo = new Arquivo();
			arquivo.comBoleto(c.getBoletos().get(0));
			arquivo.comNotasFiscaisServico(new NotasFiscaisServico().comNota(c.getNotas()));
			c.setBoletos(null);
			c.setNotas(null);
			arquivo.comCliente(c);
			Dados dados = new Dados(arquivo);
			relatorio.comDados(dados);
			
			String xml = (new ConversorEntidadeXML()).gerarXML(relatorio);
			System.out.println(xml);
			
			return (new BoletoController()).gerarRelatorioPDF(("Relatorio_" + c.getNome().trim()), request.getRealPath("/"), xml);
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
}