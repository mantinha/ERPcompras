package br.fsa.compras.command;

public class BloqueioCommand {

	private Long id;
	
	private Boolean bloqueio;
	private String data;
	private String motivo;
	
	public BloqueioCommand(Boolean bloqueio, String data, String motivo) {
		this.bloqueio = bloqueio;
		this.data = data;
		this.motivo = motivo;
	}
	
	public BloqueioCommand() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getBloqueio() {
		return bloqueio;
	}

	public void setBloqueio(Boolean bloqueio) {
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
		BloqueioCommand other = (BloqueioCommand) obj;
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
