package br.fsa.compras.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "departamento_cargo",
		joinColumns = @JoinColumn(name = "departamento_id"),
			inverseJoinColumns = @JoinColumn(name = "cargo_id"))
	private Set<Cargo> cargo = new HashSet<>();
	
	@OneToOne(cascade = CascadeType.ALL)	
	private Funcionario funcionario;

	public Departamento(String nome, Set<Cargo> cargo, Funcionario funcionario) {
		this.nome = nome;
		this.cargo = cargo;
		this.funcionario = funcionario;
	}

	public Departamento(String nome) {
		this.nome = nome;
	}

	public Departamento() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Cargo> getCargo() {
		return cargo;
	}

	public void setCargo(Set<Cargo> cargo) {
		this.cargo = cargo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
		Departamento other = (Departamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nome=" + nome + "]";
	}

}
