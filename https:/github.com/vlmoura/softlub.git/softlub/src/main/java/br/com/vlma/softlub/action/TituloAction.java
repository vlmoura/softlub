package br.com.vlma.softlub.action;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.vlma.softlub.model.bean.Arquivo;
import br.com.vlma.softlub.model.bean.Titulo;
import br.com.vlma.softlub.service.TituloService;

import com.opensymphony.xwork2.ActionSupport;

public class TituloAction extends ActionSupport{

	private static final long serialVersionUID = 3075056991766334401L;
	
	@Autowired
	private TituloService tituloService;
	
	private Titulo titulo;
	
	private List<Titulo> titulos;
	
	private Long tituloId;
	
	/** Arquivo (bytes) do Titulo */
	private File arqTitulo;
	/** Nome do Arquivo de Titulo */
	private String arqTituloFileName;
	/** Tipo do Arquivo de Titulo */
	private String arqTituloContentType;
	
	/** Arquivo (bytes) do Comprovante de Pagamento */
	private File arqComprovante;
	/** Nome do Comprovante de Pagamento */
	private String arqComprovanteFileName;
	/** Tipo do Comprovante de Pagamento */
	private String arqComprovanteContentType;
	
	
	/* *******************
	 * MÉTODOS DA ACTION *
	 * *******************/
	
	/**
	 * Apenas reencaminha a camada de apresentação
	 * @return
	 */
	public String add(){
		return SUCCESS;
	}
	
	/**
	 * Salva dados do titulo digitados no formulário
	 * @return Tipo de retorno Struts2
	 */
	public String save(){
		if(arqTitulo != null){
			titulo.setTitulo(new Arquivo(arqTitulo,arqTituloFileName, arqTituloContentType));
		}
		tituloService.save(titulo);
		return SUCCESS;
	}
	
	/**
	 * Recupera todos os titulos salvo no BD
	 * @return 
	 */
	public String getAll(){
		setTitulos(tituloService.getAll());
		return SUCCESS;
	}
	
	public String delete(){
		try{
			tituloService.deleteById(tituloId);
		}
		catch(Exception e){
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	
	//Getters e Setters 
	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo pTitulo) {
		this.titulo = pTitulo;
	}
	
	public File getArqTitulo() {
		return arqTitulo;
	}

	public void setArqTitulo(File arquivo) {
		this.arqTitulo = arquivo;
	}

	public String getArqTituloFileName() {
		return arqTituloFileName;
	}

	public void setArqTituloFileName(String arquivoFileName) {
		this.arqTituloFileName = arquivoFileName;
	}

	public String getArqTituloContentType() {
		return arqTituloContentType;
	}

	public void setArqTituloContentType(String arquivoContentType) {
		this.arqTituloContentType = arquivoContentType;
	}


	public List<Titulo> getTitulos() {
		return titulos;
	}

	public void setTitulos(List<Titulo> titulos) {
		this.titulos = titulos;
	}

	public Long getTituloId() {
		return tituloId;
	}

	public void setTituloId(Long tituloId) {
		this.tituloId = tituloId;
	}

}
