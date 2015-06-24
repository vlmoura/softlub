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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="titulo")
public class Titulo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4519665283148964945L;

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable=false, length=120)
	private String credor;
	
	@Column(nullable=false)
	private String descricao;
	
	@Column(precision=9, scale=2)
	private BigDecimal valor;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar dt_venc;
	
	@Temporal(TemporalType.DATE)
	private Calendar dt_pgto;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="titulo_id")
	private Arquivo titulo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="comp_pag_id")
	private Arquivo comp_pagamento;

	//Getters e Setters - BEGIN
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCredor() {
		return credor;
	}

	public void setCredor(String credor) {
		this.credor = credor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDt_venc() {
		return dt_venc;
	}

	public void setDt_venc(Calendar dt_venc) {
		this.dt_venc = dt_venc;
	}

	public Calendar getDt_pgto() {
		return dt_pgto;
	}

	public void setDt_pgto(Calendar dt_pgto) {
		this.dt_pgto = dt_pgto;
	}

	public Arquivo getTitulo() {
		return titulo;
	}

	public void setTitulo(Arquivo titulo) {
		this.titulo = titulo;
	}

	public Arquivo getComp_pagamento() {
		return comp_pagamento;
	}

	public void setComp_pagamento(Arquivo comp_pagamento) {
		this.comp_pagamento = comp_pagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	//Getters e Setters - END
	

}
