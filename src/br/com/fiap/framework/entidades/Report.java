package br.com.fiap.framework.entidades;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@SuppressWarnings("restriction")
public class Report {

	private Dados dados;
	
	public Report(){}
	public Report(Dados dados){
		this.dados = dados;
	}
	
	@XmlElement
	public Dados getDados() {
		return dados;
	}

	public void setDados(Dados dados) {
		this.dados = dados;
	}

	public Report dados(Dados dados) {
		this.dados = dados;
		return this;
	}

	@Override
	public String toString() {
		return "Report [data=" + dados.toString() + "]";
	}
}