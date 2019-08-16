<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
    <base href="<%=basePath%>">

    <title>第一个JSP网站</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>

    <div align="center">
        <img src="imgs/timg.jpg" width="80%" height="200" />
        <h1>欢迎您的访问</h1>
        <hr width="90%" color="red" size="2">
        贵州纵美路迢迢,<br />
        未付劳心此一遭。<br />
        搜得破书三四本,<br />
        也堪将去教尔曹。<br />
    </div>
</body>

</html>