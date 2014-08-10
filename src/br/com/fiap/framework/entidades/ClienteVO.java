package br.com.fiap.framework.entidades;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cliente")
@SuppressWarnings("restriction")
public class ClienteVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String nome;
	private String endereco;
	private String cidade;
	private String estado;
	private String cnpj;
	
	public ClienteVO(){}
	public ClienteVO(String nome, String cnpj){
		this.nome = nome;
		this.cnpj = cnpj;
	}
	public ClienteVO(String nome, String endereco, String cidade, String estado, String cnpj){
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.cnpj = cnpj;
	}
	
	public ClienteVO(Long codigo, String nome, String endereco, String cidade, String estado, String cnpj){
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.cnpj = cnpj;
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
}