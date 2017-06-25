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
<title>登录页面</title>
<link rel="stylesheet" type="text/css" href="source/index/css/index.css" />
<link rel="stylesheet" type="text/css" href="source/conmen/css/style.css" />
</head>
<body>
	<form action="web/login" method="post">
		<fieldset class="fieldset_css">
			<legend>登录</legend>
			<ul>
				<li>登录账号：<input type="text" name="userName"></li>
				<li>登录密码：<input type="text" name="userPwd"></li>
				<li><input type="submit" value="登录"></li>
			</ul>
		</fieldset>
	</form>
</body>
</html>