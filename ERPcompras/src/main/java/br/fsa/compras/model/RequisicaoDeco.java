package br.fsa.compras.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RequisicaoDeco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer codigo;
	private Integer matricula;
	private Integer matriculaAprovador;
	private Integer centroDeCusto;
	private Integer codigoMateriaPrima;
	private Integer qtdRequisitada;
	private String data;
	private String dataPrevista;
	
	public RequisicaoDeco(Integer codigo, Integer matricula, Integer matriculaAprovador, Integer centroDeCusto,
			Integer codigoMateriaPrima, Integer qtdRequisitada, String data, String dataPrevista) {
		this.codigo = codigo;
		this.matricula = matricula;
		this.matriculaAprovador = matriculaAprovador;
		this.centroDeCusto = centroDeCusto;
		this.codigoMateriaPrima = codigoMateriaPrima;
		this.qtdRequisitada = qtdRequisitada;
		this.data = data;
		this.dataPrevista = dataPrevista;
	}

	public RequisicaoDeco() {
	
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

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public Integer getMatriculaAprovador() {
		return matriculaAprovador;
	}

	public void setMatriculaAprovador(Integer matriculaAprovador) {
		this.matriculaAprovador = matriculaAprovador;
	}

	public Integer getCentroDeCusto() {
		return centroDeCusto;
	}

	public void setCentroDeCusto(Integer centroDeCusto) {
		this.centroDeCusto = centroDeCusto;
	}

	public Integer getCodigoMateriaPrima() {
		return codigoMateriaPrima;
	}

	public void setCodigoMateriaPrima(Integer codigoMateriaPrima) {
		this.codigoMateriaPrima = codigoMateriaPrima;
	}

	public Integer getQtdRequisitada() {
		return qtdRequisitada;
	}

	public void setQtdRequisitada(Integer qtdRequisitada) {
		this.qtdRequisitada = qtdRequisitada;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDataPrevista() {
		return dataPrevista;
	}

	public void setDataPrevista(String dataPrevista) {
		this.dataPrevista = dataPrevista;
	}
	
	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
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
		RequisicaoDeco other = (RequisicaoDeco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RequisicaoDeCompras [id=" + id + ", codigo=" + codigo + ", matricula=" + matricula
				+ ", matriculaAprovador=" + matriculaAprovador + ", centroDeCusto=" + centroDeCusto
				+ ", codigoMateriaPrima=" + codigoMateriaPrima + ", qtdRequisitada=" + qtdRequisitada + ", data=" + data
				+ ", dataPrevista=" + dataPrevista + "]";
	}
	
}
