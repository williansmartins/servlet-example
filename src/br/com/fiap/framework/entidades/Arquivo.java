package br.com.fiap.framework.entidades;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "file", name = "file")
public class Arquivo {

	private Cliente cliente;
	private NotasFiscaisServico notasfiscaisservico;
	private Boleto	boleto;
	
	public Arquivo(){}
	public Arquivo(Cliente cliente){
		this.cliente = cliente;
	}
	public Arquivo(Cliente cliente, NotasFiscaisServico notasfiscaisservico){
		this.cliente = cliente;
		this.notasfiscaisservico = notasfiscaisservico;
	}

	@XmlElement
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@XmlElement
	public NotasFiscaisServico getNotasfiscaisservico() {
		if(notasfiscaisservico == null){
			this.notasfiscaisservico = new NotasFiscaisServico();
		}
		return notasfiscaisservico;
	}

	public void setNotasfiscaisservico(NotasFiscaisServico notasfiscaisservico) {
		this.notasfiscaisservico = notasfiscaisservico;
	}

	public Arquivo cliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}
	
	public Arquivo comCliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}

	public Arquivo addNotaFiscalServico(NotaFiscalServico notasfiscaisservico){
		this.getNotasfiscaisservico().addNotaFiscalServico(notasfiscaisservico);
		return this;
	}
	
	public Arquivo comNotasFiscaisServico(NotasFiscaisServico notasfiscaisservico) {
		this.notasfiscaisservico = notasfiscaisservico;
		return this;
	}
	
	@XmlElement
	public Boleto getBoleto() {
		return boleto;
	}
	
	public Arquivo comBoleto(Boleto boleto) {
		this.boleto = boleto;
		return this;
	}

	@Override
	public String toString() {
		return "Arquivo [cliente=" + cliente.toString() + ", nfss=" + notasfiscaisservico.toString() + "]";
	}
}