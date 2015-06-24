package br.com.vlma.softlub.model.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "lancamento")
public class Lancamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4167164238730267577L;

	/**
	 * NOME DOS CAMPOS
	 */
	public static final String NM_COL_ID = "id";
	public static final String NM_COL_ID_PC_ORIGEM = "origem";
	public static final String NM_COL_ID_PC_DESTINO = "destino";
	public static final String NM_COL_DT_CONTABIL = "dt_contabil";
	public static final String NM_COL_DT_DOCUMENTO = "dt_documento";
	public static final String NM_COL_VALOR = "valor";
	public static final String NM_COL_DESCRICAO = "descricao";
	public static final String NM_COL_DH_ULT_SINC = "dh_ult_sinc";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "origem_id", nullable = false)
	private PlanoContas origem;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "destino_id", nullable = false)
	private PlanoContas destino;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dt_contabil;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dt_documento;

	@Column(nullable = false)
	private BigDecimal valor;

	private String descricao;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dh_ult_sinc;

	/*
	 * MÉTODOS ÚTEIS
	 */
	public static Lancamento fromLancamento(Lancamento pLancamento) {
		Lancamento lancamentoRetorno = new Lancamento();

		if (pLancamento.getDescricao() != null)
			lancamentoRetorno.setDescricao(pLancamento.getDescricao());

		if (pLancamento.getDestino() != null)
			lancamentoRetorno.setDestino(pLancamento.getDestino());

		if (pLancamento.getDh_ult_sinc() != null)
			lancamentoRetorno.setDh_ult_sinc(pLancamento.getDh_ult_sinc());

		if (pLancamento.getDt_contabil() != null)
			lancamentoRetorno.setDt_contabil(pLancamento.getDt_contabil());
		;

		if (pLancamento.getDt_documento() != null)
			lancamentoRetorno.setDt_documento(pLancamento.getDt_documento());

		if (pLancamento.getOrigem() != null)
			lancamentoRetorno.setOrigem(pLancamento.getOrigem());
		;

		if (pLancamento.getValor() != null)
			lancamentoRetorno.setValor(pLancamento.getValor());

		return lancamentoRetorno;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PlanoContas getOrigem() {
		return origem;
	}

	public void setOrigem(PlanoContas origem) {
		this.origem = origem;
	}

	public PlanoContas getDestino() {
		return destino;
	}

	public void setDestino(PlanoContas destino) {
		this.destino = destino;
	}

	public Calendar getDt_contabil() {
		return dt_contabil;
	}

	public void setDt_contabil(Calendar dt_contabil) {
		this.dt_contabil = dt_contabil;
	}

	public Calendar getDt_documento() {
		return dt_documento;
	}

	public void setDt_documento(Calendar dt_documento) {
		this.dt_documento = dt_documento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDh_ult_sinc() {
		return dh_ult_sinc;
	}

	public void setDh_ult_sinc(Calendar dh_ult_sinc) {
		this.dh_ult_sinc = dh_ult_sinc;
	}

}
