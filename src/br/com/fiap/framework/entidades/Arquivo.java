package br.com.fiap.framework.entidades;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Arquivo {

	private Cliente cliente;
	private NotasFiscaisServico nfss;
	private Boleto	boleto;
	
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
	
	public Arquivo comCliente(Cliente cliente) {
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
	
	public Arquivo comNotasFiscaisServico(NotasFiscaisServico notasFiscaisServico) {
		this.nfss = notasFiscaisServico;
		return this;
	}
	
	public Boleto getBoleto() {
		return boleto;
	}
	
	public Arquivo comBoleto(Boleto boleto) {
		this.boleto = boleto;
		return this;
	}

	@Override
	public String toString() {
		return "Arquivo [cliente=" + cliente.toString() + ", nfss=" + nfss.toString() + "]";
	}
}