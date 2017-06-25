<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>" />
<title>结果页面</title>
<link rel="stylesheet" type="text/css" href="source/index/css/index.css" />
<link rel="stylesheet" type="text/css" href="source/conmen/css/style.css" />
</head>
<body>
	<fieldset class="fieldset_css">
		<legend>返回结果</legend>
		<ul>
			<li>${mapBean.success}</li>
			<li>${mapBean.data}</li>
			<li>${mapBean.reason}</li>
		</ul>
	</fieldset>
</body>
</html>