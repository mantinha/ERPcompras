package br.fsa.compras.command;

import br.fsa.compras.model.UnidadeDeMedida;

public class MateriaPrimaCommand {

	private Long id;
	
	private Integer codigo;
	private Integer quantidade;
	private String descricao;
	private UnidadeDeMedida unidadeDeMedida;	
	
	public MateriaPrimaCommand(Integer codigo, Integer quantidade, String descricao, UnidadeDeMedida unidadeDeMedida) {
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.unidadeDeMedida = unidadeDeMedida;
	}

	public MateriaPrimaCommand() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public UnidadeDeMedida getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	public void setUnidadeDeMedida(UnidadeDeMedida unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
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
		MateriaPrimaCommand other = (MateriaPrimaCommand) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MateriaPrima [id=" + id + ", codigo=" + codigo + ", quantidade=" + quantidade + ", descricao="
				+ descricao + ", unidadeDeMedida=" + unidadeDeMedida + "]";
	}
	
}
