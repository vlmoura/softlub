package br.com.vlma.softlub.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.vlma.softlub.filtro.FiltroConsultaLancamento;
import br.com.vlma.softlub.model.bean.Lancamento;

@Repository
public class LancamentoDAO extends GenericDAO{

	public LancamentoDAO() {
		super(Lancamento.class);
	}
	
	/**
	 * Consulta os lancamento com base nos valores do filtro
	 * @param pFiltro
	 * @return List de lancamento encontrados
	 */
	public List<?> consultaFiltroLancamento(FiltroConsultaLancamento pFiltro){
		Criteria criteria = this.getCurrentSession().createCriteria(Lancamento.class);
		
		if(pFiltro.getId() != null){
			criteria.add(Restrictions.eq(Lancamento.NM_COL_ID, pFiltro.getId()));
		}
		
		/*
		 * PLANOS DE CONTA
		 */
		if(pFiltro.getPcOrigem().getCod() != null){
			criteria.add(Restrictions.eq("origem", pFiltro.getPcOrigem()));
		}
		
		
		if(pFiltro.getPcDestino().getCod() != null){
			criteria.add(Restrictions.eq("destino", pFiltro.getPcDestino()));
		}
		
		
		/*
		 * DATAS
		 */
		if(pFiltro.getDtDocInicio() != null){
			criteria.add(Restrictions.ge(Lancamento.NM_COL_DT_DOCUMENTO, pFiltro.getDtDocInicio()));
		}
		
		if(pFiltro.getDtDocFim() != null){
			criteria.add(Restrictions.le(Lancamento.NM_COL_DT_DOCUMENTO, pFiltro.getDtDocFim()));
		}
		
		if(pFiltro.getDtContabilInicio() != null){
			criteria.add(Restrictions.ge(Lancamento.NM_COL_DT_CONTABIL, pFiltro.getDtContabilInicio()));
		}
		
		if(pFiltro.getDtContabilFim() != null){
			criteria.add(Restrictions.le(Lancamento.NM_COL_DT_CONTABIL, pFiltro.getDtContabilFim()));
		}
		
		/*
		 * VALOR
		 */
		
		if(pFiltro.getValorInicio() != null){
			criteria.add(Restrictions.ge(Lancamento.NM_COL_VALOR, pFiltro.getValorInicio()));
		}
		
		if(pFiltro.getValorFim() != null){
			criteria.add(Restrictions.le(Lancamento.NM_COL_VALOR, pFiltro.getValorFim()));
		}
		
		/*
		 * DESCRIÇÃO
		 */
		if(pFiltro.getDescricao() != null){
			criteria.add(Restrictions.ilike(Lancamento.NM_COL_DESCRICAO, pFiltro.getDescricao(), MatchMode.ANYWHERE));
		}
		
		criteria.addOrder(Order.desc(Lancamento.NM_COL_DT_DOCUMENTO));
		
		return criteria.list();
	}

}
