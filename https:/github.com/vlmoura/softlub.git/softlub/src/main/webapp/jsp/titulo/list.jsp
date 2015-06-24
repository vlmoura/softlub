<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Finanpe - Titulos</title>
<%-- <sj:head jqueryui="true" />
<sb:head includeScripts="true" includeScriptsValidation="false"/> --%>


<script type="text/javascript">
	function excluir(){
		var resposta= confirm("Deseja excluir o Título selecionado? \n"
				+ "A operação não poderá ser desfeita.");
		if(resposta == true){
			var id = getRadioValue('titulo_id');
			window.location="<s:url value='/Titulo_delete?tituloId=' />"+id;
		}
		
	}

	function getRadioValue(name) {
		var titulos_id = document.getElementsByName(name);

		for (var i = 0; i < titulos_id.length; i++) {
			if (titulos_id[i].checked) {
				return titulos_id[i].value;
			}

		}

		return null;
	}
</script>


</head>

<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span9 offset2">
				<br>
				<blockquote>
					<p>
					<h3>
						<i class="icon-list"></i> Lista de Títulos
					</h3>
					</p>
				</blockquote>
				<hr>
				<br>
				
				<div class="row">
					<div class="col-md-6">
						<a href="<s:url action="Titulo_add"/>" 
							class="btn btn-primary btn-sm" role="button"> <i
							class="glyphicon glyphicon-plus icon-white"></i> Adicionar
						</a> <a href="<s:url action="Titulo_detail"/>"
							class="btn btn-info btn-sm" role="button"> <i
							class="glyphicon glyphicon-zoom-in icon-white"></i> Detalhar
						</a> 
						
						<a href="<s:url action="Titulo_edit"/>"
							class="btn btn-warning btn-sm" role="button"> <i
							class="glyphicon glyphicon-pencil icon-white"></i> Alterar
						</a> 
						
						<button class="btn btn-danger btn-sm" onclick="excluir()">
							<i class="glyphicon glyphicon-trash icon-white"></i> Excluir
						</button>
						
					</div>
				</div>
				<br>
				<display:table uid="table" id="tbTitulo" name="titulos" requestURI=""
					pagesize="15"
					class="table table-striped table-condensed table-hover table-bordered"
					defaultsort="3" defaultorder="descending" export="true">

					<display:column scope="request" style="text-align:center;">
						<input type="radio" name="titulo_id" value="${tbTitulo.id}"/>
					</display:column>

					<display:column property="credor" title="Credor" sortable="true"
						headerClass="sortable">
					</display:column>

					<display:column property="dt_venc.time" title="Vencimento"
						sortable="true" headerClass="sortable"
						format="{0,date,dd/MM/yyyy}"/>

					<display:column property="valor" title="Valor" sortable="true"
						headerClass="sortable" />

					<display:column title="Título" style="text-align:center;"
						property="titulo.name" href="Download_Arquivo" paramId="id"
						paramProperty="titulo.id" />

					<display:column property="dt_pgto.time" title="Pagamento"
						sortable="true" headerClass="sortable"
						format="{0,date,dd/MM/yyyy}" />

				</display:table>
			</div>
		</div>
	</div>
</body>
</html>