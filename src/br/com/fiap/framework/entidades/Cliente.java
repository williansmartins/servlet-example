package br.com.fiap.framework.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cliente")
@Entity(name="Cliente")
@Table(name="TBL_CLIENTE")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="codigo", nullable=false)
	private Long codigo;
	
	@Column(name="nome", nullable=false)
	private String nome;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="cidade")
	private String cidade;
	
	@Column(name="estado")
	private String estado;

	@Column(name="cnpj")
	private String cnpj;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "TBL_CLIENTE_NOTA_FISCAL_SERVICO", joinColumns = @JoinColumn(name = "CLIENTE_ID"), inverseJoinColumns = @JoinColumn(name = "NFS_ID"))
	private List<NotaFiscalServico> notas;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "TBL_CLIENTE_BOLETO", joinColumns = @JoinColumn(name = "CLIENTE_ID"), inverseJoinColumns = @JoinColumn(name = "BOLETO_ID"))
	private List<Boleto> boletos;

	public Cliente(){}
	public Cliente(String nome, String cnpj){
		this.nome = nome;
		this.cnpj = cnpj;
	}
	public Cliente(String nome, String endereco, String cidade, String estado, String cnpj){
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.cnpj = cnpj;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@XmlElement
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@XmlElement
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@XmlElement
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@XmlElement
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	@XmlElement
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@XmlElement
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public List<NotaFiscalServico> getNotas() {
		if (notas == null) {
			notas = new ArrayList<NotaFiscalServico>();
		}
		return notas;
	}
	
	public void setNotas(List<NotaFiscalServico> notas) {
		this.notas = notas;
	}
	
	public List<Boleto> getBoletos() {
		if (boletos == null) {
			boletos = new ArrayList<Boleto>();
		}
		return boletos;
	}
	
	public void setBoletos(List<Boleto> boletos) {
		this.boletos = boletos;
	}
	
	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", cidade=" + cidade + ", estado=" + estado + ", cnpj=" + cnpj + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public Cliente comCodigo(Long codigo) {
		this.codigo = codigo;
		return this;
	}
	
	public Cliente comNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public Cliente comEndereco(String endereco) {
		this.endereco = endereco;
		return this;
	}
	
	public Cliente comCidade(String cidade) {
		this.cidade = cidade;
		return this;
	}
	
	public Cliente comEstado(String estado) {
		this.estado = estado;
		return this;
	}
	
	public Cliente comCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}
	
	public Cliente comNotaFiscalServico(NotaFiscalServico nota){
		getNotas().add(nota);
		return this;
	}

	public Cliente comNotas(List<NotaFiscalServico> notas) {
		this.notas = notas;
		return this;
	}
	
	public Cliente comBoletos(List<Boleto> boletos) {
		this.boletos = boletos;
		return this;
	}
	
	public Cliente comBoleto(Boleto boleto){
		getBoletos().add(boleto);
		return this;
	}
	
	public Cliente create(ClienteVO vo){
		Cliente cliente = new Cliente();
		cliente.setNome(vo.getNome());
		cliente.setEndereco(vo.getEndereco());
		cliente.setCidade(vo.getCidade());
		cliente.setEstado(vo.getEstado());
		cliente.setCnpj(vo.getCnpj());
		return cliente;
	}
	
	public ClienteVO create(Cliente cliente){
		ClienteVO vo = new ClienteVO();
		vo.setNome(cliente.getNome());
		vo.setEndereco(cliente.getEndereco());
		vo.setCidade(cliente.getCidade());
		vo.setEstado(cliente.getEstado());
		vo.setCnpj(cliente.getCnpj());
		return vo;
	}
}