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
<title>Finanpe - Lançamentos</title>
<sj:head jqueryui="true" jquerytheme="flick" locale="pt-BR" />
<%-- <sb:head includeScripts="true" includeScriptsValidation="false" /> --%>


<script type="text/javascript">
	function excluir() {
		var id = getRadioValue('idLancamento');
		var resposta = confirm("Deseja excluir o Lançamento selecionado? \n"
				+ "A operação não poderá ser desfeita. " + id);
		if (resposta == true) {
			//var id = getRadioValue('lancamento_id');
			window.location = "<s:url value='/Lancamento_delete?lancamentoId=' />"
					+ id;
		}

	}
	
	function editar() {
		var id = getRadioValue('idLancamento');
		window.location = "<s:url value='/Lancamento_edit?lancamentoId=' />" + id;
	}
	
	function detalhar() {
		var id = getRadioValue('idLancamento');
		window.location = "<s:url value='/Lancamento_detail?lancamentoId=' />" + id;
	}

	function getRadioValue(name) {
		var id_doc = document.getElementsByName(name);

		for (var i = 0; i < id_doc.length; i++) {
			if (id_doc[i].checked) {
				return id_doc[i].value;
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
						<i class="icon-list"></i> Lista de Lançamento
					</h3>
					</p>
				</blockquote>
				<br>
				<!-- FORMULÁRIO FILTRO -->
				<div class="row">
					<s:form action="Lancamento_list" enctype="multipart/form-data"
						theme="bootstrap" cssClass="form-horizontal" method="post">
						<fieldset>

							<!-- Conta Origem -->
							<div class='col-sm-6'>
								<sj:autocompleter label="Conta de Origem" list="contasOrigem"
									listKey="cod" listValue="cod+' - '+nome" name="filtro.pcOrigem.cod"
									selectBox="true"
									tooltip="Plano de conta de onde foi retirado o recurso.">
								</sj:autocompleter>
							</div>

							<!-- Conta Destino -->
							<div class='col-sm-6'>
								<sj:autocompleter label="Conta de Destino" list="contasDestino"
									listKey="cod" listValue="cod+' - '+nome" name="filtro.pcDestino.cod"
									selectBox="true"
									tooltip="Plano de conta para onde foi destinado o recurso.">
								</sj:autocompleter>
							</div>
							
 							<!-- DATAS DOCUMENTO -->
							<div class="form-group">

								<!-- Data Inicial -->
								<div class='col-sm-4 col-sm-offset-1'>
									<sj:datepicker label="Data Inicial"
										name="filtro.dtDocInicio" parentTheme="bootstrap"
										cssClass="form-control" showOn="focus"
										inputAppendIcon="calendar" displayFormat="dd/mm/yy" />
								</div>

								<!-- Data Final -->
								<div class='col-sm-4'>
									<sj:datepicker label="Data Final" name="filtro.dtDocFim"
										parentTheme="bootstrap" cssClass="form-control" showOn="focus"
										inputAppendIcon="calendar" displayFormat="dd/mm/yy" />
								</div>
							</div>
							
							<!-- DATAS CONTABIL -->
							<div class="form-group">

								<!-- Data Inicial -->
								<div class='col-sm-4 col-sm-offset-1'>
									<sj:datepicker label="Data Inicial"
										name="filtro.dtContabilInicio" parentTheme="bootstrap"
										cssClass="form-control" showOn="focus"
										inputAppendIcon="calendar" displayFormat="dd/mm/yy" />
								</div>

								<!-- Data Final -->
								<div class='col-sm-4'>
									<sj:datepicker label="Data Final" name="filtro.dtContabilFim"
										parentTheme="bootstrap" cssClass="form-control" showOn="focus"
										inputAppendIcon="calendar" displayFormat="dd/mm/yy" />
								</div>
							</div>
							

							<!-- VALORES -->
							<div class="form-group">
								<!-- Valor a partir de -->
								<div class='col-sm-4 col-sm-offset-1'>
									<s:textfield label="Valor Inicial" name="filtro.valorInicial"
										placeholder="Valor" />
								</div>

								<!-- Valor até -->
								<div class='col-sm-4'>
									<s:textfield label="Valor Final" name="filtro.valorFinal"
										placeholder="Valor" />
								</div>
							</div>




							<div class="form-group offset2">
								<div class="col-sm-6">
									<a href="<s:url action="Lancamento_add"/>"
										class="btn btn-success" role="button"
										style="border-radius: 20px;"> <i
										class="glyphicon glyphicon-plus icon-white"></i> Adicionar
									</a>

									<button type="submit" class="btn btn-primary"
										style="border-radius: 20px;">
										<i class="glyphicon glyphicon-search"></i> Pesquisar
									</button>

									<button type="reset" class="btn btn-warning"
										style="border-radius: 20px;">
										<span class="btn-label"><i
											class="glyphicon glyphicon-refresh"></i></span> Limpar
									</button>
								</div>
							</div>

						</fieldset>
					</s:form>

					<!-- FIM DO FORMULAŔIO FILTRO -->

				</div>
				<hr>
				<br>
				<display:table uid="table" id="tbLancamento" name="lancamentos"
					requestURI="" pagesize="15"
					class="table table-striped table-condensed table-hover table-bordered"
					defaultsort="2" defaultorder="descending" export="true">

					<display:column scope="request" style="text-align:center;">
						<input type="radio" name="idLancamento" value="${tbLancamento.id}" />
					</display:column>
					
					<display:column property="dt_documento.time" title="Data Documento"
						sortable="true" headerClass="sortable"
						format="{0,date,dd/MM/yyyy}" />

					<display:column property="valor" title="Valor" sortable="true"
						headerClass="sortable" />

					<display:column property="origem.nome" title="Origem"
						sortable="true" headerClass="sortable">
					</display:column>

					<display:column property="destino.nome" title="Destino"
						sortable="true" headerClass="sortable">
					</display:column>
					
					<display:column property="dt_contabil.time" title="Data Contábil"
						sortable="true" headerClass="sortable"
						format="{0,date,dd/MM/yyyy}" />
					

				</display:table>
				<br>
				
				<!-- BOTOES LANÇAMENTO SELECIONADO -->
				<div class="row">
					<div class="col-md-6">
						<button class="btn btn-info btn-sm" onclick="detalhar()">
							<i class="glyphicon glyphicon-zoom-in icon-white"></i> Detalhar
						</button>
												
						<button class="btn btn-warning btn-sm" onclick="editar()">
							<i class="glyphicon glyphicon-pencil icon-white"></i> Editar
						</button>

						<button class="btn btn-danger btn-sm" onclick="excluir()">
							<i class="glyphicon glyphicon-trash icon-white"></i> Excluir
						</button>
						<br><br>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>