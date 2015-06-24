<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<title>.:: SoftLub - <tiles:getAsString name="title" /> ::.
</title>
<sj:head jqueryui="false" />
<sb:head includeScripts="true" includeScriptsValidation="false" />
</head>
<body>

	<tiles:insertAttribute name="menu_top" />

	<div class="container-fluid">

		<div class="row">
			<div class="col-md-2"><br>
				<tiles:insertAttribute name="menu_left" />
			</div>

			<div class="col-md-10"><br><br>
				<tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>
</body>
</html>