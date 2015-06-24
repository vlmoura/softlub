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
			<h3>Editar Lançamento</h3>
			</p>
		</blockquote>
		<hr>
	</div>

	<div class="row-fluid">
		<div class="col-md-4 col-md-offset-2">
			<s:form action="Lancamento_update" enctype="multipart/form-data"
				theme="bootstrap" cssClass="form-horizontal" method="post">
				<fieldset>
				
				<s:hidden name="lancamento.id" key="lancamento.id" />
				<s:hidden name="lancamento.origem.cod" key="lancamento.origem.cod" />
				<s:hidden name="lancamento.destino.cod" key="lancamento.destino.cod" />
				
					<!-- Plano Conta Origem -->
					<div class="form-group">
						<s:textfield label="Origem" key="lancamento.origem.cod + ' - ' + lancamento.origem.nome" readonly="true" 
							tooltip="Plano de conta de onde foi retirado o recurso."/>
					</div>
					
					<!-- Plano Conta Destino -->
					<div class="form-group">
						<s:textfield label="Origem" key="lancamento.destino.cod + ' - ' + lancamento.destino.nome" readonly="true" 
							tooltip="Plano de conta para onde foi destinado o recurso."/>
					</div>
					
					<!-- Valor-->
					<div class="form-group">
						<s:textfield label="Valor" name="lancamento.valor" placeholder="Valor" key="lancamento.valor"/>
					</div>
					
					<!-- Data Documento-->
					<div class="form-group">
						<sj:datepicker label="Data do Documento" name="lancamento.dt_documento"
							parentTheme="bootstrap" cssClass="form-control" showOn="focus"
							inputAppendIcon="calendar" displayFormat="dd/mm/yy" tooltip="Data em que o documento foi gerado." 
							value="lancamento.dt_documento.time" />
					</div>
					
					<!-- Data Referência Contábil-->
					<div class="form-group">
						<sj:datepicker label="Data de Referência Contábil" name="lancamento.dt_contabil"
							parentTheme="bootstrap" cssClass="form-control" showOn="focus"
							inputAppendIcon="calendar" displayFormat="dd/mm/yy" tooltip="Data em que o documento deverá ser pago."
							value="lancamento.dt_contabil.time"/>
					</div>

					<!-- Descrição-->
					<div class="form-group">
						<s:textarea label="Descrição" name="lancamento.descricao"
							placeholder="Digite uma breve descrição para o lançamento contábil" 
							name="lancamento.descricao" rows="5" />
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="pull-right">
								<button type="button" class="btn btn-danger" align="left"
									onclick="history.back(-1)">Cancelar</button>
								<s:reset cssClass="btn btn-warning" value="Limpar"
									align="center" />
								<s:submit cssClass="btn btn-primary" value="Salvar"
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