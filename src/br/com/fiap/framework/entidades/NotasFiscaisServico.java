package br.com.fiap.framework.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NotasFiscaisServico {

	private List<NotaFiscalServico> nota;
	
	public NotasFiscaisServico(){
		nota = new ArrayList<NotaFiscalServico>();
	}
	
	public List<NotaFiscalServico> getNotaFiscalServico() {
		if(this.nota == null){
			this.nota = new ArrayList<NotaFiscalServico>();
		}
		return nota;
	}

	public NotasFiscaisServico comNota(List<NotaFiscalServico> nota) {
		this.nota = nota;
		return this;
	}
	
	@XmlElement
	public List<NotaFiscalServico> getNota() {
		return nota;
	}

	public void setNota(List<NotaFiscalServico> nota) {
		this.nota = nota;
	}

	public NotasFiscaisServico notasFiscaisServico(List<NotaFiscalServico> nota) {
		this.nota = nota;
		return this;
	}

	public NotasFiscaisServico addNotaFiscalServico(NotaFiscalServico nota){
		this.getNotaFiscalServico().add(nota);
		return this;
	}

	@Override
	public String toString() {
		return "NotasFiscaisServico [nota=" + nota + "]";
	}
}