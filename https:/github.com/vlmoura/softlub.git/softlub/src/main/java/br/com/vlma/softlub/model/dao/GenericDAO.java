package br.com.vlma.softlub.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public abstract class GenericDAO {

	private Class<?> classe;

	/**
	 * Construtor default que recebe como parametro a classe da entidade que extende
	 * @param pClasse classe de entidade que extende o GenericDAO
	 */
	public GenericDAO(Class<?> pClasse) {
		this.classe = pClasse;
	}

	/**
	 * Fábrica de sessões do Hibernate
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Retorna o objeto com id pesquisado
	 * @param pId Id do objeto
	 * @return objeto único com id passado
	 */
	public Object getById(final Long pId) {
		return this.getCurrentSession().get(this.classe, pId);
	}

	/**
	 * Consulta todos os objetos cadastrados sem ordenação de resultado
	 * @return todos os objetos cadastrados sem ordenação de resultado
	 */
	public List<?> getAll() {
		return this.getCurrentSession().createCriteria(this.classe).list();
	}

	/**
	 * Consulta todos os registros da tabela ordenando-os pelos Orders passados
	 * 
	 * @param pOrder
	 *            array de Orders para ordenação do resultado
	 * @return Lista de elementos recuperados com where passado
	 */
	public List<?> getAllOrderBy(Order[] pOrder) {

		Criteria criteria = getCurrentSession().createCriteria(this.classe);

		for (int i = 0; i < pOrder.length; i++) {
			criteria.addOrder(pOrder[i]);
		}

		return criteria.list();
	}

	/**
	 * Salva o objeto passado
	 * @param object objeto a ser persistido no banco
	 */
	public void save(Object object) {
		this.getCurrentSession().persist(object);
	}

	/**
	 * Atualiza objeto passado
	 * @param object objeto a ser atualizado
	 */
	public void update(Object object) {
		this.getCurrentSession().update(object);
	}

	public void delete(Object object) {
		this.getCurrentSession().delete(object);
	}

	public void deleteById(final Long pId) {
		Object object = this.getById(pId);
		this.getCurrentSession().delete(object);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public final Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

}
