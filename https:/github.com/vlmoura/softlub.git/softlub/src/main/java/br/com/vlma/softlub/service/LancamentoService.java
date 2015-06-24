package br.com.vlma.softlub.service;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vlma.softlub.filtro.FiltroConsultaLancamento;
import br.com.vlma.softlub.model.bean.Lancamento;
import br.com.vlma.softlub.model.bean.PlanoContas;
import br.com.vlma.softlub.model.dao.LancamentoDAO;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoDAO lancamentoDAO;

	@Autowired
	private PlanoContasService servicePlanoContas;

	/**
	 * Salva o lançamento no BD
	 * 
	 * @param pLancamento
	 *            Lançamento a ser gravado
	 * @param pNParcelas
	 *            Número de parcelas, ou seja, número de vezes que o lançamento
	 *            será replicado
	 * @param pCodPlanoOrigem
	 *            Plano de contas de Origem
	 * @param pCodPlanoDestino
	 *            Plano de contas de Destino
	 */
	public void save(Lancamento pLancamento, Integer pNParcelas,
			Integer pCodPlanoOrigem, Integer pCodPlanoDestino) {
		// Seta origem e destino
		if (pCodPlanoOrigem != null && pCodPlanoDestino != null) {
			pLancamento.setOrigem(servicePlanoContas.getByCod(pCodPlanoOrigem));
			pLancamento.setDestino(servicePlanoContas
					.getByCod(pCodPlanoDestino));
		}
		// Data atual como ultima sincronização
		if (pLancamento.getDh_ult_sinc() == null) {
			pLancamento.setDh_ult_sinc(Calendar.getInstance());
		}

		// Salva quantas parcelas forem...
		for (int i = 0; i < pNParcelas; i++) {
			Lancamento lancamento = Lancamento.fromLancamento(pLancamento);
			Calendar novaDataContabil = pLancamento.getDt_contabil();
			if (i > 0)
				novaDataContabil.add(Calendar.MONTH, 1);
			lancamento.setDt_contabil(novaDataContabil);

			// Adiciona informação na descrição
			if (pNParcelas > 1)
				lancamento.setDescricao(pLancamento.getDescricao()
						+ "\n Parcela " + (i + 1) + " de " + pNParcelas + ".");

			lancamentoDAO.save(lancamento);
		}

	}

	public void deleteById(Long pId) {
		lancamentoDAO.deleteById(pId);
	}

	@SuppressWarnings("unchecked")
	public List<Lancamento> getAll() {
		return (List<Lancamento>) lancamentoDAO.getAll();
	}

	@SuppressWarnings("unchecked")
	public List<Lancamento> getAllOrderByDtDocumento() {
		Order[] orders = { Order.desc(Lancamento.NM_COL_DT_DOCUMENTO),
				Order.desc(Lancamento.NM_COL_DT_CONTABIL),
				Order.asc(Lancamento.NM_COL_ID_PC_DESTINO),
				Order.asc(Lancamento.NM_COL_VALOR)};
		return (List<Lancamento>) lancamentoDAO.getAllOrderBy(orders);
	}

	@SuppressWarnings("unchecked")
	public List<Lancamento> consultaFiltroLancamento(
			FiltroConsultaLancamento pFiltro) {
		if (pFiltro.getPcOrigem().getCod() != null) {
			pFiltro.setPcOrigem(this.getPlanoByCod(pFiltro.getPcOrigem()
					.getCod()));
		}
		if (pFiltro.getPcDestino().getCod() != null) {
			pFiltro.setPcDestino(getPlanoByCod(pFiltro.getPcDestino().getCod()));

		}
		return (List<Lancamento>) lancamentoDAO
				.consultaFiltroLancamento(pFiltro);
	}

	public Lancamento getById(Long pId) {
		return (Lancamento) lancamentoDAO.getById(pId);
	}

	public void update(Lancamento pLancamento) {
		pLancamento.setOrigem(servicePlanoContas.getByCod(pLancamento
				.getOrigem().getCod()));
		pLancamento.setDestino(servicePlanoContas.getByCod(pLancamento
				.getDestino().getCod()));

		pLancamento.setDh_ult_sinc(Calendar.getInstance());
		lancamentoDAO.update(pLancamento);
	}

	/*
	 * MÉTODOS SERVICE PLANO DE CONTAS
	 */

	public List<PlanoContas> getPlanosOrigem() {
		return (List<PlanoContas>) servicePlanoContas.getPlanosOrigem();
	}

	public List<PlanoContas> getPlanosDestino() {
		return (List<PlanoContas>) servicePlanoContas.getPlanosDestino();
	}

	public PlanoContas getPlanoByCod(Integer pCod) {
		return servicePlanoContas.getByCod(pCod);
	}

}
