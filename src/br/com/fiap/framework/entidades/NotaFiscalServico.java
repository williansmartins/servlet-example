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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@Entity(name="NotaFiscalServico")
@Table(name="TBL_NOTA_FISCAL_SERVICO")
@XmlRootElement(name="notaFiscalServico")
public class NotaFiscalServico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="numero", nullable=false)
	private Long numero;
	
	@Column(name="discriminacao_geral", nullable=false)
	private String discriminacaoGeral;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data", nullable=false)
	private Calendar data;
	
	@Column(name="valor", nullable=false)
	private BigDecimal valor;
	
	public NotaFiscalServico(){}
	public NotaFiscalServico(Long numero){
		this.numero = numero;
	}
	public NotaFiscalServico(Long numero, String discriminacaoGeral, Calendar data, BigDecimal valor){
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
	
	@Override
	public String toString() {
		return "NotaFiscalServico [numero=" + numero + ", discriminacaoGeral=" + discriminacaoGeral + ", data=" + data + ", valor=" + valor + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		NotaFiscalServico other = (NotaFiscalServico) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	
	public NotaFiscalServico create(NotaFiscalServicoVO vo){
		NotaFiscalServico nfs = new NotaFiscalServico();
		nfs.setNumero(vo.getNumero());
		nfs.setDiscriminacaoGeral(vo.getDiscriminacaoGeral());
		nfs.setData(vo.getData());
		nfs.setValor(vo.getValor());
		return nfs;
	}
	
	public NotaFiscalServico createNew(NotaFiscalServico nfs){
		NotaFiscalServico _nfs = new NotaFiscalServico();
		_nfs.setNumero(nfs.getNumero());
		_nfs.setDiscriminacaoGeral(nfs.getDiscriminacaoGeral());
		_nfs.setData(nfs.getData());
		_nfs.setValor(nfs.getValor());
		return _nfs;
	}
	
	public NotaFiscalServicoVO create(NotaFiscalServico nfs){
		NotaFiscalServicoVO vo = new NotaFiscalServicoVO();
		vo.setNumero(nfs.getNumero());
		vo.setDiscriminacaoGeral(nfs.getDiscriminacaoGeral());
		vo.setData(nfs.getData());
		vo.setValor(nfs.getValor());
		return vo;
	}
}