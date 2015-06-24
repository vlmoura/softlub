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
			<h3>Detalhe Lançamento</h3>
			</p>
		</blockquote>
		<hr>
	</div>

	<div class="row-fluid">
		<div class="col-md-10 col-md-offset-1">
				
					<!-- Plano Conta Origem -->
					<div class="panel panel-default">
					  <div class="panel-body">
					    <strong> Conta de Origem:</strong>  ${lancamento.origem.cod} - ${lancamento.origem.nome}
					  </div>
					</div>

					<!-- Plano Conta Destino -->
					<div class="panel panel-default">
					  <div class="panel-body">
					    <strong> Conta de Destino:</strong>  ${lancamento.destino.cod} - ${lancamento.destino.nome}
					  </div>
					</div>					
					
					<!-- Valor-->
					<div class="panel panel-default">
					  <div class="panel-body">
					    <strong> Valor:</strong> R$ ${lancamento.valor}
					  </div>
					</div>
					
					<!-- Data Documento-->
					<div class="panel panel-default">
					  <div class="panel-body">
					    <strong> Data do Documento:</strong>  <s:date name="lancamento.dt_documento" format="dd/MM/yyyy"/>
					  </div>
					</div>
					
					<!-- Data Referência Contábil-->
					<div class="panel panel-default">
					  <div class="panel-body">
					    <strong> Data de Referência Contábil:</strong>  <s:date name="lancamento.dt_contabil" format="dd/MM/yyyy"/>
					  </div>
					</div>

					<!-- Descrição-->
					<div class="panel panel-default">
					  <div class="panel-body">
					    <strong> Descrição:</strong>  ${lancamento.descricao}
					  </div>
					</div>

					<div class="form-group" align="center">
								<button type="button" class="btn btn-info"
									onclick="history.back(-1)">Voltar</button>
						</div>
					</div>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->

</body>
</html>