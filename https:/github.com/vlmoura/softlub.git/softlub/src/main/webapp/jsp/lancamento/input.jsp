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
			<h3>Adicionar Lançamento</h3>
			</p>
		</blockquote>
		<hr>
	</div>

	<div class="row-fluid">
		<div class="col-md-4 col-md-offset-2">
			<s:form action="Lancamento_save" enctype="multipart/form-data"
				theme="bootstrap" cssClass="form-horizontal" method="post">
				<fieldset>
				
					<!-- Plano Conta Origem -->
					<div class="form-group">
						<sj:autocompleter label="Origem" list="contasOrigem" listKey="cod" 
						listValue="cod+' - '+nome" name="codPlanoOrigem"
						selectBox="true" tooltip="Plano de conta de onde foi retirado o recurso."></sj:autocompleter>
					</div>
					
					<!-- Plano Conta Destino -->
					<div class="form-group">
						<sj:autocompleter label="Destino" list="contasDestino" listKey="cod" 
						listValue="cod+' - '+nome" name="codPlanoDestino"
						selectBox="true" tooltip="Plano de conta para o qual foi destinado o recurso."></sj:autocompleter>
					</div>
					
					<!-- Número de Parcelas -->
					
					<div class="form-group">
						<s:select name="parcelas" label="Número de Parcelas"
						list="#{'1':'1x','2':'2x','3':'3x','4':'4x','5':'5x','6':'6x','7':'7x','8':'8x','9':'9x','10':'10x'}" />
					</div>
					
					
					
					<!-- Valor-->
					<div class="form-group">
						<s:textfield label="Valor" name="lancamento.valor" placeholder="Valor" />
					</div>
					
					<!-- Data Documento-->
					<div class="form-group">
						<sj:datepicker label="Data do Documento" name="lancamento.dt_documento"
							parentTheme="bootstrap" cssClass="form-control" showOn="focus"
							inputAppendIcon="calendar" displayFormat="dd/mm/yy" tooltip="Data em que o documento foi gerado." />
					</div>
					
					<!-- Data Referência Contábil-->
					<div class="form-group">
						<sj:datepicker label="Data de Referência Contábil" name="lancamento.dt_contabil"
							parentTheme="bootstrap" cssClass="form-control" showOn="focus"
							inputAppendIcon="calendar" displayFormat="dd/mm/yy" tooltip="Data em que o documento deverá ser pago."/>
					</div>

					<!-- Descrição-->
					<div class="form-group">
						<s:textarea label="Descrição" name="lancamento.descricao"
							placeholder="Digite uma breve descrição para o lançamento contábil" />
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