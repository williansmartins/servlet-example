package br.com.fiap.framework.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name="boleto")
@Table(name="TBL_BOLETO")
@XmlRootElement(name="boleto")
public class Boleto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="codigo_barra", nullable=false)
	private String codigoBarra;
	
	@Column(name="nome_banco", nullable=false)
	private String nomeBanco;
	
	@Column(name="observacao", nullable=false)
	private String observacao;
	
	@Column(name="data_documento", nullable=false)
	private Calendar dataDocumento;
	
	@Column(name="data_vencimento", nullable=false)
	private Calendar dataVencimento;
	
	@Column(name="valor_documento", nullable=false)
	private BigDecimal valorDocumento;
	
	@Column(name="multa", nullable=false)
	private BigDecimal multa;
	
	@Column(name="valor_cobrado", nullable=false)
	private BigDecimal valorCobrado;
	
	public Boleto(){}
	public Boleto(String codigoBarra){
		this.codigoBarra = codigoBarra;
	}
	public Boleto(String codigoBarra, String nomeBanco, String observacao, Calendar dataDocumento, Calendar dataVencimento, BigDecimal valorDocumento, BigDecimal multa, BigDecimal valorCobrado){
		this.codigoBarra = codigoBarra;
		this.nomeBanco = nomeBanco;
		this.observacao = observacao;
		this.dataDocumento = dataDocumento;
		this.dataVencimento = dataVencimento;
		this.valorDocumento = valorDocumento;
		this.multa = multa;
		this.valorCobrado = valorCobrado;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@XmlElement
	public String getCodigoBarra() {
		return codigoBarra;
	}
	
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	
	@XmlElement
	public String getNomeBanco() {
		return nomeBanco;
	}
	
	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}
	
	@XmlElement
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	@XmlElement
	public Calendar getDataDocumento() {
		return dataDocumento;
	}
	
	public void setDataDocumento(Calendar dataDocumento) {
		this.dataDocumento = dataDocumento;
	}
	
	@XmlElement
	public Calendar getDataVencimento() {
		return dataVencimento;
	}
	
	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	@XmlElement
	public BigDecimal getValorDocumento() {
		return valorDocumento;
	}
	
	public void setValorDocumento(BigDecimal valorDocumento) {
		this.valorDocumento = valorDocumento;
	}
	
	@XmlElement
	public BigDecimal getMulta() {
		return multa;
	}
	
	public void setMulta(BigDecimal multa) {
		this.multa = multa;
	}
	
	@XmlElement
	public BigDecimal getValorCobrado() {
		return valorCobrado;
	}
	
	public void setValorCobrado(BigDecimal valorCobrado) {
		this.valorCobrado = valorCobrado;
	}
	
	@Override
	public String toString() {
		return "Boleto [codigoBarra=" + codigoBarra + ", nomeBanco=" + nomeBanco + ", observacao=" + observacao + ", dataDocumento=" + dataDocumento + ", dataVencimento=" + dataVencimento + ", valorDocumento=" + valorDocumento + ", multa=" + multa + ", valorCobrado=" + valorCobrado + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoBarra == null) ? 0 : codigoBarra.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Boleto other = (Boleto) obj;
		if (codigoBarra == null) {
			if (other.codigoBarra != null)
				return false;
		} else if (!codigoBarra.equals(other.codigoBarra))
			return false;
		return true;
	}

	public Boleto comCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
		return this;
	}

	public Boleto comNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
		return this;
	}

	public Boleto comObservacao(String observacao) {
		this.observacao = observacao;
		return this;
	}

	public Boleto comDataDocumento(Calendar dataDocumento) {
		this.dataDocumento = dataDocumento;
		return this;
	}

	public Boleto comDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
		return this;
	}

	public Boleto comValorDocumento(BigDecimal valorDocumento) {
		this.valorDocumento = valorDocumento;
		return this;
	}

	public Boleto comMulta(BigDecimal multa) {
		this.multa = multa;
		return this;
	}
	
	public Boleto comValorCobrado(BigDecimal valorCobrado) {
		this.valorCobrado = valorCobrado;
		return this;
	}
	
	public BoletoVO create(Boleto boleto){
		BoletoVO vo = new BoletoVO();
		vo.setCodigoBarra(boleto.getCodigoBarra());
		vo.setNomeBanco(boleto.getCodigoBarra());
		vo.setObservacao(boleto.getCodigoBarra());
		vo.setDataDocumento(boleto.getDataDocumento());
		vo.setDataVencimento(boleto.getDataVencimento());
		vo.setValorDocumento(boleto.getValorDocumento());
		vo.setMulta(boleto.getMulta());
		vo.setValorCobrado(boleto.getValorCobrado());
		return vo;
	}
	
	public Boleto create(BoletoVO vo){
		Boleto boleto = new Boleto();
		boleto.setCodigoBarra(vo.getCodigoBarra());
		boleto.setNomeBanco(vo.getCodigoBarra());
		boleto.setObservacao(vo.getCodigoBarra());
		boleto.setDataDocumento(vo.getDataDocumento());
		boleto.setDataVencimento(vo.getDataVencimento());
		boleto.setValorDocumento(vo.getValorDocumento());
		boleto.setMulta(vo.getMulta());
		boleto.setValorCobrado(vo.getValorCobrado());
		return boleto;
	}
}