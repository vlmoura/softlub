package br.com.vlma.softlub.filtro;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.vlma.softlub.model.bean.PlanoContas;

/**
 * Classe com campos para consulta de dados dos lancamento
 * @author victor
 *
 */
public class FiltroConsultaLancamento {
	
	private Long id;
	private PlanoContas pcOrigem;
	private PlanoContas pcDestino;
	private Calendar dtDocInicio;
	private Calendar dtDocFim;
	private Calendar dtContabilInicio;
	private Calendar dtContabilFim;
	private BigDecimal valorInicio;
	private BigDecimal valorFim;
	private String descricao;
	
	
	/* ***************** *
	 * GETTERS E SETTERS *
	 * ***************** */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PlanoContas getPcOrigem() {
		return pcOrigem;
	}
	public void setPcOrigem(PlanoContas pcOrigem) {
		this.pcOrigem = pcOrigem;
	}
	public PlanoContas getPcDestino() {
		return pcDestino;
	}
	public void setPcDestino(PlanoContas pcDestino) {
		this.pcDestino = pcDestino;
	}
	public Calendar getDtDocInicio() {
		return dtDocInicio;
	}
	public void setDtDocInicio(Calendar dtDocInicio) {
		this.dtDocInicio = dtDocInicio;
	}
	public Calendar getDtDocFim() {
		return dtDocFim;
	}
	public void setDtDocFim(Calendar dtDocFim) {
		this.dtDocFim = dtDocFim;
	}
	public Calendar getDtContabilInicio() {
		return dtContabilInicio;
	}
	public void setDtContabilInicio(Calendar dtContabilInicio) {
		this.dtContabilInicio = dtContabilInicio;
	}
	public Calendar getDtContabilFim() {
		return dtContabilFim;
	}
	public void setDtContabilFim(Calendar dtContabilFim) {
		this.dtContabilFim = dtContabilFim;
	}
	public BigDecimal getValorInicio() {
		return valorInicio;
	}
	public void setValorInicio(BigDecimal valorInicio) {
		this.valorInicio = valorInicio;
	}
	public BigDecimal getValorFim() {
		return valorFim;
	}
	public void setValorFim(BigDecimal valorFim) {
		this.valorFim = valorFim;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
