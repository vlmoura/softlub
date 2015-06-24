package br.com.vlma.softlub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vlma.softlub.model.bean.Titulo;
import br.com.vlma.softlub.model.dao.TituloDAO;

@Service
public class TituloService {
	
	@Autowired
	private TituloDAO tituloDAO;
	
	public void save(Titulo pTitulo){
		tituloDAO.save(pTitulo);
	}
	
	public void deleteById(Long pId){
		tituloDAO.deleteById(pId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Titulo> getAll(){
		return (List<Titulo>) tituloDAO.getAll();
	}

}
