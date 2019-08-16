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
        <marquee scrollamount="10">欢迎2016级软件工程同学来到JSP课程!</marquee>
        <hr width="80%" color="red" size="3" />
        <h2>注册页面</h2>
        <form method="post" action="/test0630_web/servlet/ZCServlet">
            用户名：<input type="text" name="t1" id="t1" />
            <br /><br />

            密码：<input type="password" name="t2" id="t2" />
            <br /><br />

            确认密码：<input type="password" name="t3" id="t3" />
            <br /><br />

            性别：男 <input type="radio" value="男" name="sex" id="t4" />
            女 <input type="radio" value="女" name="sex" id="t5" />
            未知 <input type="radio" value="未知" name="sex" id="t6" />

            <br /><br />
            兴趣爱好：打篮球<input type="checkbox" value="打篮球" name="interest" id="t7" />
            看小说<input type="checkbox" value="看小说" name="interest" id="t8" />
            打LOL<input type="checkbox" value="打LOL" name="interest" id="t9" />

            <br /><br />
            <select name="age">
                <option>------请选择年龄----------</option>
                <option value="00后">00后</option>
                <option value="90后">90后</option>
                <option value="80后">80后</option>
                <option value="70后">70后</option>
            </select>

            <br /><br />
            <input type="date" name="t10" id="t10" />

            <br /><br />
            <input type="color" name="t11" id="t11" />

            <br /><br />

            <input type="submit" name="t12" id="t12" />
            <input type="reset" name="t13" id="t12" />
        </form>
        <hr width="80%" color="red" size="3" />
        网站所有权归：杨秀璋及16级软件工程学生所有
    </div>
</body>

</html>