package br.com.fiap.framework.entidades;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="report")
public class Relatorio {

	@XmlElement(name="data")
	private Dados dados;
	
	public Relatorio() {}

	public Dados getDados() {
		return dados;
	}

	public Relatorio comDados(Dados dados) {
		this.dados = dados;
		return this;
	}

	@Override
	public String toString() {
		return "Relatorio [dados=" + dados + "]";
	}
}