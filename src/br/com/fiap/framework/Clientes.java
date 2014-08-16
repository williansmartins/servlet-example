package br.com.fiap.framework;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.framework.controller.ClienteController;
import br.com.fiap.framework.entidades.Cliente;

public class Clientes extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    public Clientes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeCliente = request.getParameter("nomeCliente");
		
		StringBuilder str = new StringBuilder();
		List<Cliente> clientes = (new ClienteController()).findByNome(nomeCliente);
		for (Cliente cliente : clientes) {
			str.append("<li><a href='boleto?idCliente=" + cliente.getId() + "'>" + cliente.getNome() + "</a></li>");
		}
		
		response.getWriter().write("<ul>" + str.toString() + "</ul>");
	}
}