package br.com.vlma.softlub.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.vlma.softlub.filtro.FiltroConsultaLancamento;
import br.com.vlma.softlub.model.bean.Lancamento;
import br.com.vlma.softlub.model.bean.PlanoContas;
import br.com.vlma.softlub.service.LancamentoService;

import com.opensymphony.xwork2.ActionSupport;

public class LancamentoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4818216590148421976L;
	
	@Autowired
	private LancamentoService service;
	
	private Lancamento lancamento;
	private List<Lancamento> lancamentos;
	
	private FiltroConsultaLancamento filtro;
	
	private List<PlanoContas> contasOrigem;
	private List<PlanoContas> contasDestino;
	
	private Integer codPlanoOrigem;
	private Integer codPlanoDestino;
	private Long lancamentoId;
	private Integer parcelas;
	
	/* ************** *
	 * MÉTODOS ACTION *
	 * ************** */
	public String save(){
		try{
			if(codPlanoOrigem != null && codPlanoDestino !=null){
				service.save(lancamento, parcelas, codPlanoOrigem, codPlanoDestino);
			}
		}
		catch(Exception e){
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String getAll(){
		contasOrigem = service.getPlanosOrigem();
		contasDestino = service.getPlanosDestino();
		
		//Se o filtro for preenchido...
		if(filtro != null){
			lancamentos = service.consultaFiltroLancamento(filtro);
		}

		//Se não, carrega todos os lançamentos
		else{
			lancamentos = service.getAllOrderByDtDocumento();
		}
		return SUCCESS;
	}
	
	/**
	 *
	 * @return sucesso
	 */
	public String add(){
		contasOrigem = service.getPlanosOrigem();
		contasDestino = service.getPlanosDestino();
		return SUCCESS;
	}
	
	public String delete(){
		if (lancamentoId !=null){
			service.deleteById(lancamentoId);
		}
		return SUCCESS;
	}
	
	public String edit(){
		loadById();
		return SUCCESS;

	}
	
	public String update(){
		service.update(lancamento);
		return SUCCESS;
	}
	
	public String detail(){
		loadById();
		return SUCCESS;
	}
	
	
	/* ************ *
	 * MÉTODOS UTIL *
	 * ************ */
	
	public void loadById(){
		if (lancamentoId !=null){
			lancamento = service.getById(lancamentoId);
		}
		
	}
	

	/* ***************** *
	 * GETTERS E SETTERS *
	 * ***************** */
	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento Lancamento) {
		this.lancamento = Lancamento;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public List<PlanoContas> getContasOrigem() {
		return contasOrigem;
	}

	public void setContasOrigem(List<PlanoContas> contasOrigem) {
		this.contasOrigem = contasOrigem;
	}

	public List<PlanoContas> getContasDestino() {
		return contasDestino;
	}

	public void setContasDestino(List<PlanoContas> contasDestino) {
		this.contasDestino = contasDestino;
	}

	public Integer getCodPlanoOrigem() {
		return codPlanoOrigem;
	}

	public void setCodPlanoOrigem(Integer codPlanoOrigem) {
		this.codPlanoOrigem = codPlanoOrigem;
	}

	public Integer getCodPlanoDestino() {
		return codPlanoDestino;
	}

	public void setCodPlanoDestino(Integer codPlanoDestino) {
		this.codPlanoDestino = codPlanoDestino;
	}

	public Long getLancamentoId() {
		return lancamentoId;
	}

	public void setLancamentoId(Long lancamentoId) {
		this.lancamentoId = lancamentoId;
	}

	public FiltroConsultaLancamento getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroConsultaLancamento filtro) {
		this.filtro = filtro;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}


	

}
