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
<%-- 注册页面 --%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>" />
<title>注册页面</title>
<link rel="stylesheet" type="text/css" href="source/index/css/index.css" />
<link rel="stylesheet" type="text/css" href="source/conmen/css/style.css" />
</head>
<body>
	<form action="web/userreg" method="post">
		<fieldset class="fieldset_css">
			<legend>会员注册</legend>
			<ul>
				<li>登录账号：<input type="text" name="u_acount"></li>
				<li>登录密码：<input type="text" name="u_pwd"></li>
				<li>会员姓名：<input type="text" name="u_name"></li>
				<li>手机号码：<input type="text" name="u_phone"></li>
				<li>邮箱地址：<input type="text" name="u_email"></li>
				<li>会员性别：
					<input type="radio" value="1" name="u_sex"><label for="">男</label>
					<input type="radio" value="2" name="u_sex"><label for="">女</label>
				</li>
				<li><input type="submit" value="登录"></li>
			</ul>
		</fieldset>
	</form>
</body>
</html>