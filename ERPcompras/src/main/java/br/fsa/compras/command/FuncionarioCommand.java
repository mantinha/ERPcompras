package br.fsa.compras.command;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.fsa.compras.model.Cargo;
import br.fsa.compras.model.Departamento;

public class FuncionarioCommand {
	
	private Long id;
	
	private Integer matricula;	
	private String nome;
	private String email;
	
	@Enumerated(value = EnumType.STRING)
	private Cargo cargo;
	
	@Enumerated(value = EnumType.STRING)
	private Departamento departamento;

	public FuncionarioCommand(Integer matricula, String nome, String email, Cargo cargo, Departamento departamento) {
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.cargo = cargo;
		this.departamento = departamento;
	}

	public FuncionarioCommand() {
		
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
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
		FuncionarioCommand other = (FuncionarioCommand) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", matricula=" + matricula + ", nome=" + nome + ", email=" + email + ", cargo="
				+ cargo + ", departamento=" + departamento + "]";
	}
	
}
