package br.com.fiap.framework.entidades;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dados {

	private Arquivo arquivo;
	
	public Dados(){}
	public Dados(Arquivo arquivo){
		this.arquivo = arquivo;
	}

	@XmlElement(name = "file")
	public Arquivo getArquivo() {
		return arquivo;
	}

	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}

	public Dados arquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
		return this;
	}
	
	public Dados comArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
		return this;	
	}

	@Override
	public String toString() {
		return "Dados [arquivo=" + arquivo.toString() + "]";
	}
}