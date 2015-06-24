<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%-- <%@ taglib prefix="sj" uri="/struts-jquery-tags"%> --%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Responsive Menu - ProgrammingFree</title>
<!-- Mobile viewport optimized -->
<meta name="viewport" content="width=device-width">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <sj:head jqueryui="false" /> --%>
<sb:head includeScripts="true" includeScriptsValidation="false" />
</head>
<body>
	<br>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">SoftLub</a>
		</div>
		<div>
			<ul class="nav navbar-nav navbar-right" style="margin-right: 25px">
				<li class="active"><a href="#">iOS</a></li>
				<li><a href="#">SVN</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle glyphicon glyphicon-user"
					data-toggle="dropdown"> <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#" class="glyphicon glyphicon-user">  Perfil</a></li>
						<li><a href="#" class="glyphicon glyphicon-cog">  Configuração</a></li>
						<li class="divider"></li>
						<li><a href="#" class="glyphicon glyphicon-off">  Sair</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
</body>
</html>