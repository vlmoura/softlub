package br.com.vlma.softlub.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.vlma.softlub.model.bean.PlanoContas;
import br.com.vlma.softlub.util.Constantes;

@Repository
public class PlanoContasDAO extends GenericDAO{
	
	public PlanoContasDAO() {
		super(PlanoContas.class);
		// TODO Auto-generated constructor stub
	}
	
	public PlanoContas getByCod(Integer pCod){
		return (PlanoContas) this.getCurrentSession().createCriteria(PlanoContas.class).add(Restrictions.eq(PlanoContas.NM_COL_COD, pCod)).uniqueResult();
	}

	/**
	 * 
	 * @param pCampo nome da coluna a ser pesquisada
	 * @param pLike pLike String com máscara a ser pesquisada
	 * @return Lista de todos os planos de contas com a mascara consultada
	 */
	public List<?> getAllLike(String pCampo, String pLike){
		return this.getCurrentSession().createCriteria(PlanoContas.class).add(
				Restrictions.sqlRestriction(pCampo + "::text like '" + pLike + "' ")).list();
		
	}
	
	/**
	 * 
	 * @param pLikeCdPai Expressão like do cdPai. Ex.: '1%00' quando pai é raiz ou '101%' quando o pai é 101 
	 * @return Plano, dentre os filhos do pai passado, que tem maior cd
	 */
	public Integer getMaxChildren(String pLikeCdPai){
		return (Integer) this.getCurrentSession().createCriteria(PlanoContas.class).setProjection(Projections.max(PlanoContas.NM_COL_COD)).add(
				Restrictions.sqlRestriction(PlanoContas.NM_COL_COD + "::text like '" + pLikeCdPai + "' ")).uniqueResult();
		
	}
	
	/**
	 * 
	 * @return Todos os planos de contas que podem ser de origem de lancamento
	 */
	public List<?> getPlanosOrigem(){
		Criteria criteria = this.getCurrentSession().createCriteria(PlanoContas.class);
		criteria.add(Restrictions.sqlRestriction("("+
				PlanoContas.NM_COL_COD + "::text like '" + Constantes.CD_PLANO_SALDO_CIRCULANTE.substring(0, 1) + "%' "
						+ " OR " +
						PlanoContas.NM_COL_COD + "::text like '" + Constantes.CD_PLANO_RECEITA.substring(0, 1) + "%' )"));
		
		//Não pode terminar em 00 pois, nesse caso será conta pai
		criteria.add(Restrictions.sqlRestriction(
				PlanoContas.NM_COL_COD + "::text not like '%00' "));
		
		return criteria.list();
		
	}
	
	/**
	 * 
	 * @return Todos os planos de contas que podem ser de destino de lancamento
	 */
	public List<?> getPlanosDestino(){
		Criteria criteria = this.getCurrentSession().createCriteria(PlanoContas.class);
		criteria.add(Restrictions.sqlRestriction("("+
				PlanoContas.NM_COL_COD + "::text like '" + Constantes.CD_PLANO_SALDO_CIRCULANTE.substring(0, 1) + "%' "
				+ " OR " + 
				PlanoContas.NM_COL_COD + "::text like '" + Constantes.CD_PLANO_DESPESA.substring(0, 1) + "%' )"));
		
		//Não pode terminar em 00 pois, nesse caso será conta pai
		criteria.add(Restrictions.sqlRestriction(
				PlanoContas.NM_COL_COD + "::text not like '%00' "));
		
		return criteria.list();
		
	}
	

	
	
}
