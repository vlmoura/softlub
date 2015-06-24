package br.com.vlma.softlub.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;





import br.com.vlma.softlub.model.bean.Arquivo;
import br.com.vlma.softlub.service.ArquivoService;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadArquivo extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3869164626385605830L;

	private long id;
	
	@Autowired
	private ArquivoService arquivoService;
	private Arquivo arquivo;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
	    downloadArquivo();
	    return "none";
	}
	
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	
	//@SuppressWarnings("unused")
	private void downloadArquivo() throws IOException{
		
		arquivo = arquivoService.getById(id);
		
		HttpServletResponse response = ServletActionContext.getResponse();
        response.reset();
        response.addHeader("Content-Disposition", "attachment; filename=\""+ arquivo.getName()+"\"");
        response.getOutputStream().write(arquivo.getContent());
        response.getOutputStream().flush();
        response.getOutputStream().close();
        
	}

	
}
