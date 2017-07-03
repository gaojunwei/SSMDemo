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
<title>SSM首页</title>
<link rel="stylesheet" type="text/css" href="source/index/css/index.css" />
<link rel="stylesheet" type="text/css" href="source/conmen/css/style.css" />
</head>
<body>
	<fieldset class="fieldset_css">
		<legend>功能列表</legend>
		<ul>
			<c:choose>
				<c:when test="${userinfo==null}">
					<li><a href="web/tologin">登录</a></li>
					<li><a href="web/toreg">注册</a></li>
				</c:when>
				<c:otherwise>
					<li>欢迎您：${userinfo.name} - <a href="web/tologout">退出</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		<ul>
			<li>结果：</li>
			<li>${mapBean.success}</li>
			<li>${mapBean.reason}</li>
			<li>${mapBean.data}</li>
		</ul>
	</fieldset>
</body>
</html>