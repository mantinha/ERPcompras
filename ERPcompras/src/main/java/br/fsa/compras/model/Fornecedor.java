package br.fsa.compras.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	private Integer matricula;
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private String data;
	private String status;
	private String site;
	private String telefone;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Bloqueio bloqueio;
	
	public Fornecedor(Integer matricula, String cnpj, String razaoSocial, String nomeFantasia, String data,
			String status, String site, String telefone, Endereco endereco,
			Bloqueio bloqueio) {
		this.matricula = matricula;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.data = data;
		this.status = status;
		this.site = site;
		this.telefone = telefone;
		this.endereco = endereco;
		this.bloqueio = bloqueio;
	}
	
	public Fornecedor() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Bloqueio getBloqueio() {
		return bloqueio;
	}

	public void setBloqueio(Bloqueio bloqueio) {
		this.bloqueio = bloqueio;
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
		Fornecedor other = (Fornecedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FornecedorCommand [id=" + id + ", matricula=" + matricula + ", cnpj=" + cnpj + ", razaoSocial="
				+ razaoSocial + ", nomeFantasia=" + nomeFantasia + ", data=" + data + ", status=" + status + ", site="
				+ site + ", telefone=" + telefone + ", endereco=" + endereco + ", bloqueio=" + bloqueio + "]";
	}
	
	

}
