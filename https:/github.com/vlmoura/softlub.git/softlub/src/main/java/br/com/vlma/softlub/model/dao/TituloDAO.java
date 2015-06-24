package br.com.vlma.softlub.model.dao;

import org.springframework.stereotype.Repository;

import br.com.vlma.softlub.model.bean.Titulo;

@Repository
public class TituloDAO extends GenericDAO{

	public TituloDAO() {
		super(Titulo.class);
		// TODO Auto-generated constructor stub
	}
	

}
