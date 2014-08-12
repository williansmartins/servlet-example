package br.com.fiap.framework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.framework.controller.BoletoController;

public class GerarBoleto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GerarBoleto() {
		super();
	}

	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeBoleto = request.getParameter("nomeBoleto");
		
		String boleto = (new BoletoController()).gerarRelatorioPDF(nomeBoleto, request.getRealPath("/"), (new BoletoController()).XML);
		if (boleto != null) {
			response.getWriter().write("<html><body><br/>Boleto Gerado com sucesso! <a href='" + boleto + "' target='_blank'>Visualizar.</a></body></html>");
		} else {
			response.getWriter().write("<html><body><br/>Boleto Falhou! <a href='gerarBoletos.jsp'>Tente novamente.</a></body></html>");
		}
	}
}