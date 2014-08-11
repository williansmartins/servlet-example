package br.com.fiap.framework.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NotasFiscaisServico {

	private List<NotaFiscalServico> nfs;
	
	public NotasFiscaisServico(){
		nfs = new ArrayList<NotaFiscalServico>();
	}
	
	public List<NotaFiscalServico> getNotaFiscalServico() {
		if(this.nfs == null){
			this.nfs = new ArrayList<NotaFiscalServico>();
		}
		return nfs;
	}

	public NotasFiscaisServico comNota(List<NotaFiscalServico> nfs) {
		this.nfs = nfs;
		return this;
	}
	
	@XmlElement
	public List<NotaFiscalServico> getNfs() {
		return nfs;
	}

	public void setNfs(List<NotaFiscalServico> nfs) {
		this.nfs = nfs;
	}

	public NotasFiscaisServico notasFiscaisServico(List<NotaFiscalServico> nfs) {
		this.nfs = nfs;
		return this;
	}

	public NotasFiscaisServico addNotaFiscalServico(NotaFiscalServico nfs){
		this.getNotaFiscalServico().add(nfs);
		return this;
	}

	@Override
	public String toString() {
		return "NotasFiscaisServico [nfs=" + nfs + "]";
	}
}