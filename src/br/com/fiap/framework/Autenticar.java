package br.com.fiap.framework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Autenticar extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		if(login.equals("admin") && senha.equals("admin")){
			String userCaptchaResponse = request.getParameter("jcaptcha");
			boolean captchaPassed = LoginCaptcha.validateResponse(request, userCaptchaResponse);
			
			if(captchaPassed){
				response.getWriter().write("<html><body><br/><a href='index.html'>Precisa direcionar para pagina de geração de relatorio</a></body></html>");
			}else{
				response.getWriter().write("<html><body><br/>Captcha Falhou! <a href='captcha.jsp'>Tente novamente.</a></body></html>");
			}
		}else{
			response.getWriter().write("<html><body><br/>Captcha Falhou! <a href='captcha.jsp'>Tente novamente.</a></body></html>");
		}
	}
}