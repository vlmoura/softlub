package br.com.vlma.softlub.model.bean;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="plano_contas")
public class PlanoContas {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, unique=true)
	private Integer cod;
	
	@Column(nullable=false, length=120)
	private String nome;
	
	@Column(nullable=false)
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	private Calendar dtInicioVigencia;
	
	@Temporal(TemporalType.DATE)
	private Calendar dtFimVigencia;

	//Getters e Setters - BEGIN
	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDtInicioVigencia() {
		return dtInicioVigencia;
	}

	public void setDtInicioVigencia(Calendar dtInicioVigencia) {
		this.dtInicioVigencia = dtInicioVigencia;
	}

	public Calendar getDtFimVigencia() {
		return dtFimVigencia;
	}

	public void setDtFimVigencia(Calendar dtFimVigencia) {
		this.dtFimVigencia = dtFimVigencia;
	}
	
	//Getters e Setters - END
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	//Colunas da tabela
	public static final String NM_COL_COD = "cod";
	public static final String NM_COL_NOME = "nome";
	public static final String NM_COL_DESCRICAO = "descricao";
	public static final String NM_COL_INI_VIGENCIA = "dtInicioVigencia";
	public static final String NM_COL_FIM_VIGENCIA = "dtFimVigencia";
	
	
	
}
