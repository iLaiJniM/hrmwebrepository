<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/22
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>管理员登陆</title>
</head>
<body>
<div style="height: 100% ;width: 100% ">
    <div style="height: 100px ; width: 1900px;background-color: antiquewhite;color: deepskyblue;font-size: 50px">
        &nbsp&nbsp&nbsp某公司
    </div>
    <div style="height: 277px ; width: 550px;left: 400px;top: 100px ;position: relative;float: left">
        <img src="resources/picture/1.png">
    </div>

    <div style="height: 410px;width: 387px;left: 500px;top: 100px ;position: relative ;border-style: solid ;border-color: deepskyblue;float: left">
        <h3 style="text-align: center">管理员登陆</h3><br/>
        <form style="text-align: center" action="adminLogin" method="post">
            账号：<input name="loginAdmin_name" type="text"/><br/><br/>
            密码：<input name="loginAdmin_pass" type="password"/><br/><br/><br/>
            <input style="height: 22px;width: 190px" type="submit" value="管理员登录"><br/>
        </form>
        <h4 style="color: red;text-align: center">
            ${requestScope.msg1}<br/>
        </h4>
    </div>
</div>
</body>
</html>