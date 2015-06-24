package br.com.vlma.softlub.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.vlma.softlub.model.bean.PlanoContas;
import br.com.vlma.softlub.service.PlanoContasService;

import com.opensymphony.xwork2.ActionSupport;

public class PlanoContasAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4818216590148421976L;
	
	@Autowired
	private PlanoContasService service;
	private PlanoContas planoContas;
	private List<PlanoContas> planosContas;
	private List<PlanoContas> raizes;
	private Integer cdPlanoPai;
	
	
	/* ************** *
	 * MÉTODOS ACTION *
	 * ************** */
	public String save(){
		try{
			//obtem o maior cd dos filhos e incrementa
			//Integer cod = service.getMaxChildren(cdPlanoPai);
			planoContas.setCod(service.getCdProxChildrenAdd(cdPlanoPai));
			service.save(planoContas);
		}
		catch(Exception e){
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String getAll(){
		planosContas = service.getAllOrderByCod();
		return SUCCESS;
	}
	
	/**
	 * Popula campos utilizados na tela para adicionar planos de contas
	 * @return sucesso
	 */
	public String add(){
		this.raizes = service.getRaizes();
		return SUCCESS;
	}

	
	/* ***************** *
	 * GETTERS E SETTERS *
	 * ***************** */
	public PlanoContasService getPlanoContasService() {
		return service;
	}

	public void setPlanoContasService(PlanoContasService planoContasService) {
		this.service = planoContasService;
	}

	public PlanoContas getPlanoContas() {
		return planoContas;
	}

	public void setPlanoContas(PlanoContas planoContas) {
		this.planoContas = planoContas;
	}

	public List<PlanoContas> getPlanosContas() {
		return planosContas;
	}

	public void setPlanosContas(List<PlanoContas> planosContas) {
		this.planosContas = planosContas;
	}

	public List<PlanoContas> getRaizes() {
		return raizes;
	}

	public void setRaizes(List<PlanoContas> raizes) {
		this.raizes = raizes;
	}

	public Integer getCdPlanoPai() {
		return cdPlanoPai;
	}

	public void setCdPlanoPai(Integer cdPlanoPai) {
		this.cdPlanoPai = cdPlanoPai;
	}
	

}
