package br.com.fiap.framework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.framework.controller.XmlController;

public class ImportarXML extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImportarXML() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xml = request.getParameter("xml");
		
		if ((new XmlController()).gravarXML(xml)) {
			
		} else {
			
		}
	}
}