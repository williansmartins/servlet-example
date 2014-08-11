package br.com.fiap.framework.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArquivoVO {

	@XmlElement
	private Cliente cliente;
	@XmlElement
	private List<NotaFiscalServico> nfss;
	
	public ArquivoVO(){}
	public ArquivoVO(Cliente cliente){
		this.cliente = cliente;
	}
	public ArquivoVO(Cliente cliente, List<NotaFiscalServico> nfss){
		this.cliente = cliente;
		this.nfss = nfss;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<NotaFiscalServico> getNfss() {
		if(nfss == null){
			this.nfss = new ArrayList<NotaFiscalServico>();
		}
		return nfss;
	}

	public void setNfss(List<NotaFiscalServico> nfss) {
		this.nfss = nfss;
	}

	public ArquivoVO cliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}
	
	public ArquivoVO nfss(List<NotaFiscalServico> nfss) {
		this.nfss = nfss;
		return this;
	}

	public ArquivoVO addNotaFiscalServico(NotaFiscalServico nfs){
		this.getNfss().add(nfs);
		return this;
	}

	@Override
	public String toString() {
		return "Arquivo [cliente=" + cliente + ", nfss=" + nfss + "]";
	}
}