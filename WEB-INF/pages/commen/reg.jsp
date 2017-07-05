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
				<li>登录账号：<input type="text" name="U_ACCOUNT" value="admin"></li>
				<li>登录密码：<input type="text" name="U_PWD" value="qq123456"></li>
				<li>会员姓名：<input type="text" name="U_NAME" value="管理员"></li>
				<li>手机号码：<input type="text" name="U_PHONE" value="13693615037"></li>
				<li>邮箱地址：<input type="text" name="U_EMAIL" value="13693615037@qq.com"></li>
				<li>会员性别：
					<input type="radio" value="1" name="U_SEX" checked="checked"><label for="">男</label>
					<input type="radio" value="2" name="U_SEX"><label for="">女</label>
				</li>
				<li><input type="submit" value="登录"></li>
			</ul>
		</fieldset>
	</form>
</body>
</html>