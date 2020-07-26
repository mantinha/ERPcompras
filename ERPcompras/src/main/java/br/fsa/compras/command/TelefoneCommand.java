package br.fsa.compras.command;

public class TelefoneCommand {
	
	private Long id;
	
	private String numero;
	private String responsavel;

	public TelefoneCommand(String numero, String responsavel) {
		this.numero = numero;
		this.responsavel = responsavel;
	}
	
	public TelefoneCommand() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
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
		TelefoneCommand other = (TelefoneCommand) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TelefoneCommand [id=" + id + ", numero=" + numero + ", responsavel=" + responsavel + "]";
	}	

	
}
