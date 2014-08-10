package br.com.fiap.framework.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="TBL_CLIENTE_NOTA_FISCAL_SERVICO")	
public class ClienteNFS implements Serializable {

	private static final long serialVersionUID = 1L;

	public ClienteNFS(){}
	public static ClienteNFS newInstance(Cliente cliente, NotaFiscalServico nfs){
		ClienteNFS clienteNFS = new ClienteNFS();
		clienteNFS.setCliente(cliente);
		clienteNFS.setNotaFiscalServico(nfs);
		clienteNFS.setId(new PK(cliente.getId(), nfs.getId()));
		return clienteNFS;
	}
	
	@Embeddable
	public static class PK implements Serializable{
		private static final long serialVersionUID = 1L;
		@Column(name="cliente_id", nullable=false, updatable=false)
		private Long clienteId;
		@Column(name="nfs_id", nullable=false, updatable=false)
		private Long nfsId;
		public PK(){}
		public PK(Long clienteId, Long nfsId){
			this.clienteId = clienteId;
			this.nfsId = nfsId;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((clienteId == null) ? 0 : clienteId.hashCode());
			result = prime * result
					+ ((nfsId == null) ? 0 : nfsId.hashCode());
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
			PK other = (PK) obj;
			if (clienteId == null) {
				if (other.clienteId != null)
					return false;
			} else if (!clienteId.equals(other.clienteId))
				return false;
			if (nfsId == null) {
				if (other.nfsId != null)
					return false;
			} else if (!nfsId.equals(other.nfsId))
				return false;
			return true;
		}
	}
	
	@EmbeddedId
	private PK id;
	
	@ManyToOne
	@JoinColumn(name="cliente_id", insertable=false, updatable=false, nullable=false)
	private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name="nfs_id", insertable=false, updatable=false, nullable=false)
	private NotaFiscalServico notaFiscalServico;

	public PK getId() {
		return id;
	}

	public void setId(PK id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public NotaFiscalServico getNotaFiscalServico() {
		return notaFiscalServico;
	}
	
	public void setNotaFiscalServico(NotaFiscalServico notaFiscalServico) {
		this.notaFiscalServico = notaFiscalServico;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ClienteNFS other = (ClienteNFS) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}