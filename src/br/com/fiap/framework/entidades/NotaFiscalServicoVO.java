package br.com.fiap.framework.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="notaFiscalServico")
public class NotaFiscalServicoVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long numero;
	private String discriminacaoGeral;
	private Calendar data;
	private BigDecimal valor;
	
	public NotaFiscalServicoVO(){}
	public NotaFiscalServicoVO(Long numero){
		this.numero = numero;
	}
	public NotaFiscalServicoVO(Long numero, String discriminacaoGeral, Calendar data, BigDecimal valor){
		this.numero = numero;
		this.discriminacaoGeral = discriminacaoGeral;
		this.data = data;
		this.valor = valor;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@XmlElement
	public Long getNumero() {
		return numero;
	}
	
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	@XmlElement
	public String getDiscriminacaoGeral() {
		return discriminacaoGeral;
	}
	
	public void setDiscriminacaoGeral(String discriminacaoGeral) {
		this.discriminacaoGeral = discriminacaoGeral;
	}
	
	@XmlElement
	public Calendar getData() {
		return data;
	}
	
	public void setData(Calendar data) {
		this.data = data;
	}
	
	@XmlElement
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}