package br.com.fiap.framework.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cliente")
@Entity(name="Cliente")
@Table(name="TBL_CLIENTE")
@SuppressWarnings("restriction")
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