<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width">
<sj:head jqueryui="true" jquerytheme="flick" locale="pt-BR" />
<%-- <sb:head includeScripts="true" includeScriptsValidation="false" /> --%>

</head>
<body>

	<div class="span9 offset2">
		<br>
		<blockquote>
			<p>
			<h3>Adicionar Plano de Contas</h3>
			</p>
		</blockquote>
		<hr>
	</div>

	<div class="row-fluid">
		<div class="col-md-4 col-md-offset-2">
			<s:form action="PlanoContas_save" enctype="multipart/form-data"
				theme="bootstrap" cssClass="form-horizontal" method="post">
				<fieldset>
				
					<!-- Plano Conta Pai -->
					<div class="form-group">
						<sj:autocompleter label="Plano Contas Pai" list="raizes" listKey="cod" 
						listValue="cod+' - '+nome" name="cdPlanoPai"
						selectBox="true"></sj:autocompleter>
					</div>
					
					<!-- Credor-->
					<div class="form-group">
						<s:textfield label="Nome" name="planoContas.nome"
							placeholder="Nome" />
					</div>

					<!-- Descrição-->
					<div class="form-group">
						<s:textarea label="Descrição" name="planoContas.descricao"
							placeholder="Digite uma breve descrição para o plano de contas" />
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="pull-right">
								<button type="button" class="btn btn-danger" align="left"
									onclick="history.back(-1)">Cancelar</button>
								<s:reset cssClass="btn btn-warning" value="Limpar"
									align="center" />
								<s:submit cssClass="btn btn-primary" value="Cadastrar"
									align="rigth" />
							</div>
						</div>
					</div>

				</fieldset>
				<!-- 			</form> -->
			</s:form>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->

</body>
</html>