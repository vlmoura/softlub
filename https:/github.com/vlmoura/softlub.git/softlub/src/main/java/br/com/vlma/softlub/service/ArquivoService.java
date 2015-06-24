package br.com.vlma.softlub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vlma.softlub.model.bean.Arquivo;
import br.com.vlma.softlub.model.dao.ArquivoDAO;

@Service
@Transactional
public class ArquivoService {
	
	@Autowired
	private ArquivoDAO ArquivoDAO;
	
	public Arquivo getById(final Long id) {
		return (Arquivo) ArquivoDAO.getById(id);
	}

	@SuppressWarnings("unchecked")
	public List<Arquivo> getAll() {
		return (List<Arquivo>) ArquivoDAO.getAll();
	}

	public void save(final Arquivo pArquivo) {
		ArquivoDAO.save(pArquivo);
	}

	public void update(final Arquivo pArquivo) {
		ArquivoDAO.update(pArquivo);
	}

	public void delete(final Arquivo pArquivo) {
		ArquivoDAO.delete(pArquivo);
	}

	public void deleteById(final Long id) {
		ArquivoDAO.deleteById(id);
	}

}
