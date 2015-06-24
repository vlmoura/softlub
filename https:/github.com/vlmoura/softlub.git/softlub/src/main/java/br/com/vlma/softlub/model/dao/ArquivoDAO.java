package br.com.vlma.softlub.model.dao;

import org.springframework.stereotype.Repository;

import br.com.vlma.softlub.model.bean.Arquivo;

@Repository
public class ArquivoDAO extends GenericDAO{

	public ArquivoDAO() {
		super(Arquivo.class);
		// TODO Auto-generated constructor stub
	}

}
