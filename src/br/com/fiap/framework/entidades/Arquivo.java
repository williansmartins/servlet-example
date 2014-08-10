package br.com.fiap.framework.entidades;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@SuppressWarnings("restriction")
public class Arquivo {

	private Cliente cliente;
	private NotasFiscaisServico nfss;
	
	public Arquivo(){}
	public Arquivo(Cliente cliente){
		this.cliente = cliente;
	}
	public Arquivo(Cliente cliente, NotasFiscaisServico nfss){
		this.cliente = cliente;
		this.nfss = nfss;
	}

	@XmlElement
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@XmlElement
	public NotasFiscaisServico getNfss() {
		if(nfss == null){
			this.nfss = new NotasFiscaisServico();
		}
		return nfss;
	}

	public void setNfss(NotasFiscaisServico nfss) {
		this.nfss = nfss;
	}

	public Arquivo cliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}
	
	public Arquivo nfss(NotasFiscaisServico nfss) {
		this.nfss = nfss;
		return this;
	}

	public Arquivo addNotaFiscalServico(NotaFiscalServico nfs){
		this.getNfss().addNotaFiscalServico(nfs);
		return this;
	}

	@Override
	public String toString() {
		return "Arquivo [cliente=" + cliente.toString() + ", nfss=" + nfss.toString() + "]";
	}
}