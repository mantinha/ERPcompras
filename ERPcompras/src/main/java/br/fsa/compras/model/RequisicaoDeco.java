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
	
	private int codigo;
	private int matricula;
	private int matriculaAprovador;
	private int centroDeCusto;
	private int codigoMateriaPrima;
	private int qtdRequisitada;
	private String data;
	private String dataPrevista;
	
	public RequisicaoDeco(int codigo, int matricula, int matriculaAprovador, int centroDeCusto,
			int codigoMateriaPrima, int qtdRequisitada, String data, String dataPrevista) {
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getMatriculaAprovador() {
		return matriculaAprovador;
	}

	public void setMatriculaAprovador(int matriculaAprovador) {
		this.matriculaAprovador = matriculaAprovador;
	}

	public int getCentroDeCusto() {
		return centroDeCusto;
	}

	public void setCentroDeCusto(int centroDeCusto) {
		this.centroDeCusto = centroDeCusto;
	}

	public int getCodigoMateriaPrima() {
		return codigoMateriaPrima;
	}

	public void setCodigoMateriaPrima(int codigoMateriaPrima) {
		this.codigoMateriaPrima = codigoMateriaPrima;
	}

	public int getQtdRequisitada() {
		return qtdRequisitada;
	}

	public void setQtdRequisitada(int qtdRequisitada) {
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
