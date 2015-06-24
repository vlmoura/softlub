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
			<h3>Adicionar Título</h3>
			</p>
		</blockquote>
		<hr>
	</div>

	<div class="row-fluid">
		<div class="col-md-4 col-md-offset-2">
			<s:form action="Titulo_save" enctype="multipart/form-data"
				theme="bootstrap" cssClass="form-horizontal" method="post">
				<fieldset>
					<!-- Credor-->
					<div class="form-group">
						<s:textfield label="Credor" name="titulo.credor"
							placeholder="Credor" />
					</div>

					<!-- Descrição-->
					<div class="form-group">
						<s:textarea label="Descrição" name="titulo.descricao"
							placeholder="Digite uma breve descrição para o título" />
					</div>

					<!-- Valor-->
					<div class="form-group">
						<s:textarea label="Valor" name="titulo.valor" placeholder="Valor" />
					</div>

					<!-- Data Vencimento-->
					<div class="form-group">
						<sj:datepicker label="Data de Vencimento" name="titulo.dt_venc"
							parentTheme="bootstrap" cssClass="form-control" showOn="focus"
							inputAppendIcon="calendar" displayFormat="dd/mm/yy" />
					</div>

					<!-- Arquivo Título-->
					<div class="form-group">
						<s:file name="arqTitulo" label=" Selecionar Título"></s:file>
					</div>

					<!-- Data Pagamento-->
					<div class="form-group">
						<sj:datepicker label="Data de Pagamento" name="titulo.dt_pgto"
							parentTheme="bootstrap" cssClass="form-control" showOn="focus"
							inputAppendIcon="calendar" displayFormat="dd/mm/yy" />
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