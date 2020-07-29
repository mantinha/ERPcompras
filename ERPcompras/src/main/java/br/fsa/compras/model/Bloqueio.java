package br.fsa.compras.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bloqueio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String bloqueio;
	private String data;
	private String motivo;

	@OneToOne
	private Fornecedor fornecedor;
	
	public Bloqueio(String bloqueio, String data, String motivo) {
		this.bloqueio = bloqueio;
		this.data = data;
		this.motivo = motivo;
	}
	
	public Bloqueio() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBloqueio() {
		return bloqueio;
	}

	public void setBloqueio(String bloqueio) {
		this.bloqueio = bloqueio;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
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
		Bloqueio other = (Bloqueio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BloqueioCommand [id=" + id + ", bloqueio=" + bloqueio + ", data=" + data + ", motivo=" + motivo + "]";
	}
	
	
	
}
