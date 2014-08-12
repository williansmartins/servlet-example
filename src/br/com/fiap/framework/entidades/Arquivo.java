package br.com.fiap.framework.entidades;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "file")
public class Arquivo {

	private Cliente cliente;
	private NotasFiscaisServico notasFiscaisServico;
	private Boleto	boleto;
	
	public Arquivo(){}
	public Arquivo(Cliente cliente){
		this.cliente = cliente;
	}
	public Arquivo(Cliente cliente, NotasFiscaisServico notasFiscaisServico){
		this.cliente = cliente;
		this.notasFiscaisServico = notasFiscaisServico;
	}

	@XmlElement
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@XmlElement
	public NotasFiscaisServico getNotasFiscaisServico() {
		if(notasFiscaisServico == null){
			this.notasFiscaisServico = new NotasFiscaisServico();
		}
		return notasFiscaisServico;
	}

	public void setNotasFiscaisServico(NotasFiscaisServico notasFiscaisServico) {
		this.notasFiscaisServico = notasFiscaisServico;
	}

	public Arquivo cliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}
	
	public Arquivo comCliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}

	public Arquivo addNotaFiscalServico(NotaFiscalServico notasFiscaisServico){
		this.getNotasFiscaisServico().addNotaFiscalServico(notasFiscaisServico);
		return this;
	}
	
	public Arquivo comNotasFiscaisServico(NotasFiscaisServico notasFiscaisServico) {
		this.notasFiscaisServico = notasFiscaisServico;
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
		return "Arquivo [cliente=" + cliente.toString() + ", nfss=" + notasFiscaisServico.toString() + "]";
	}
}