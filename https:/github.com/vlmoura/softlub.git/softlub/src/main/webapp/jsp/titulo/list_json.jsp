<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<html>
<head>
<sj:head jqueryui="true" jquerytheme="flick" />
<style type="text/css">
.ui-jqgrid .ui-jqgrid-view {
	font-size: 14px;
}

.ui-jqgrid .ui-jqgrid-titlebar {
	font-size: 14px;
}
</style>
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
				<%-- 				<br> <a href="<s:url action="Titulo_add"/>"
					class="btn btn-primary" role="button"> <i
					class="glyphicon glyphicon-plus icon-white"></i> Adicionar Título
				</a> <br> --%>
				<hr>
			</div>
		</div>

		<div class="row-fluid" align="center">
			<div align="left">
				<br> <a href="<s:url action="Titulo_add"/>" align="left"
					class="btn btn-primary" role="button"> <i
					class="glyphicon glyphicon-plus icon-white"></i> Adicionar Título
				</a> <br>
				<br>
			</div>

			<s:url var="remoteurl" action="Titulo_dataTable" />
			<sjg:grid id="gridtable" caption="Títulos" dataType="json"
				href="%{remoteurl}" pager="true" gridModel="gridModel"
				rowList="10,15,20" rowNum="15" rownumbers="true">
				<sjg:gridColumn name="credor" index="credor" title="Credor"
					sortable="true" />
				<sjg:gridColumn name="descricao" index="descricao" title="Descrição"
					sortable="true" />
				<sjg:gridColumn name="dt_venc" index="dt_venc" title="Vencimento"
					formatter="date"
					formatoptions="{newformat : 'd.m.Y', srcformat : 'Y-m-d H:i:s'}"
					sortable="true" />
				<sjg:gridColumn name="titulo.name" index="titulo.name"
					title="Titulo PDF" sortable="true" />
				<sjg:gridColumn name="dt_pgto" index="dt_pgto" title="Pagamento"
					formatter="date"
					formatoptions="{newformat : 'd.m.Y', srcformat : 'Y-m-d H:i:s'}"
					sortable="true" />
				<sjg:gridColumn name="comp_pagamento.name"
					index="comp_pagamento.name" title="Comp. Pagamento" sortable="true" />
			</sjg:grid>
		</div>
	</div>

</body>
</html>