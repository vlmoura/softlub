package br.com.vlma.softlub.action;

import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.vlma.softlub.model.dao.LancamentoDAO;

import com.opensymphony.xwork2.ActionSupport;

public class JasperTesteAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2135567582558087397L;
	
	@Autowired
	private LancamentoDAO dao;

	private Session currentSession;
	private Map<String, Object> paramets;
	
	@SuppressWarnings("deprecation")
	public String execute(){
		currentSession = dao.getCurrentSession();
		
		paramets = new Hashtable<String, Object>();
		paramets.put("dt_contabil_inicio", new Date(2012-1900,01,01));
		paramets.put("dt_contabil_fim", new Date(2016-1900,01,01));
		paramets.put("origem_cod", new Long(20401));
		paramets.put("destino_cod", new Long(30801));
		
		try{
			JasperCompileManager.compileReportToFile("/home/victor/projetos_maven/softlub/src/main/webapp/reports/saldo_conta.jrxml",
					"/home/victor/projetos_maven/softlub/src/main/webapp/reports/saldo_conta.jasper");
			
		} catch(Exception e){
			e.printStackTrace();
			return ERROR;
			
		}
		
		return SUCCESS;
	}

	public LancamentoDAO getDao() {
		return dao;
		
	}

	public void setDao(LancamentoDAO dao) {
		this.dao = dao;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Map<String, Object> getParamets() {
		return paramets;
	}

	public void setParamets(Map<String,Object> paramets) {
		this.paramets = paramets;
	}
	
	

}
