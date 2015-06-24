package br.com.vlma.softlub.service;
/**
 * @author victor
 * Contem regras de negócio de acesso ao BD
 */
import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vlma.softlub.model.bean.PlanoContas;
import br.com.vlma.softlub.model.dao.PlanoContasDAO;

@Service
public class PlanoContasService {
	
	@Autowired
	private PlanoContasDAO planoContasDAO;
	
	public PlanoContas getById(Long pId){
		return (PlanoContas) planoContasDAO.getById(pId);
	}
	
	public PlanoContas getByCod(Integer pCod){
		return (PlanoContas) planoContasDAO.getByCod(pCod);
	}
	
	/**
	 * Insere Plano de Contas passado
	 * @param pPlanoContas
	 */
	public void save(PlanoContas pPlanoContas){
		if(pPlanoContas.getDtInicioVigencia() == null){
			pPlanoContas.setDtInicioVigencia(Calendar.getInstance());
		}
		planoContasDAO.save(pPlanoContas);
	}
	
	/**
	 * Deleta o plano de contas com id passado
	 * @param pId Id do plano de contas a ser excluido
	 */
	public void deleteById(Long pId){
		planoContasDAO.deleteById(pId);
	}
	
	/**
	 * 
	 * @return Retorna lista com todos os Planos de Contas cadastrados
	 */
	@SuppressWarnings("unchecked")
	public List<PlanoContas> getAll(){
		return (List<PlanoContas>) planoContasDAO.getAll();
	}
	
	/**
	 * 
	 * @return Retorna lista com todos os Planos de Contas cadastrados ordenados pelo cod
	 */
	@SuppressWarnings("unchecked")
	public List<PlanoContas> getAllOrderByCod(){
		Order[] orders = {Order.asc(PlanoContas.NM_COL_COD)};
		return (List<PlanoContas>) planoContasDAO.getAllOrderBy(orders);
	}
	
	/**
	 * 
	 * @param pCampo nome da coluna a ser pesquisada
	 * @param pLike pLike String com máscara a ser pesquisada
	 * @return Lista de todos os planos de contas com a mascara consultada
	 */
	@SuppressWarnings("unchecked")
	public List<PlanoContas> getAllLike(String pCampo, String pLike){
		return (List<PlanoContas>) planoContasDAO.getAllLike(pCampo, pLike);
	}
	
	/**
	 * 
	 * @return Lista com todos os plano de contas raiz
	 */
	public List<PlanoContas> getRaizes(){
		return this.getAllLike(PlanoContas.NM_COL_COD, "___00");
	}
	
	
	/**
	 * 
	 * @param pCdPai código do pai a ser consultado
	 * @return código do próximo filho do pai passado, a ser inserido
	 */
	public Integer getCdProxChildrenAdd(Integer pCdPai) {
		
		String pCdPlanoPai = pCdPai.toString();
		
		/* Se contem 4 zeros é raiz, deve-se então pesquisar o maior valor
		 * dentre seus filhos
		 * Seus filhos são os que começam com o 1 digito e terminam com 00 */
		if (pCdPlanoPai.contains("0000")) {
			pCdPlanoPai = pCdPlanoPai.substring(0, 1) + "%00";
			return planoContasDAO.getMaxChildren(pCdPlanoPai)+100;
		} else {
			pCdPlanoPai = pCdPlanoPai.substring(0, 3) + "%";
			return planoContasDAO.getMaxChildren(pCdPlanoPai)+1;
		}

	}
	
	/**
	 * 
	 * @return Plano de contas que podem ser origem, ou seja, receitas e saldo circulante
	 */
	@SuppressWarnings("unchecked")
	public List<PlanoContas> getPlanosOrigem(){
		return (List<PlanoContas>) planoContasDAO.getPlanosOrigem();
	}
	
	/**
	 * 
	 * @return Plano de contas que podem ser destino, ou seja, despesas e saldo circulante
	 */
	@SuppressWarnings("unchecked")
	public List<PlanoContas> getPlanosDestino(){
		return (List<PlanoContas>) planoContasDAO.getPlanosDestino();
	}

}
