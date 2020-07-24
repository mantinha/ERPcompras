package br.fsa.compras.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RequisicaoDeCompras {
	
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
	
	public RequisicaoDeCompras(int codigo, int matricula, int matriculaAprovador, int centroDeCusto,
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

	public RequisicaoDeCompras() {
	
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
	
}
