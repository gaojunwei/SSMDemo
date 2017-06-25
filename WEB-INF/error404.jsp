<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>404</title>
<link rel="stylesheet" type="text/css" href="web/index/css/index.css" />
<link rel="stylesheet" type="text/css" href="web/conmen/css/style.css" />
</head>
<body>
	<fieldset class="fieldset_css">
		<ul>
			<li><span style="font-size: 40px;">404页面</span></li>
		</ul>
	</fieldset>
</body>
</html>