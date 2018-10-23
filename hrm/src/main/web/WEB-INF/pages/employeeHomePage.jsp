<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/22
  Time: 10:52
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
    <title>员工主页</title>
</head>
<body>
<div style="margin: auto; height: 100%; width: 80%">loginEmployee_name
    欢迎员工${sessionScope.loginEmployee.employee_name} &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <a href="exitLoginEmployee">【退出登录】</a>
    <br/><br/><br/>
    <div>
        <a href="">【...】</a>&nbsp&nbsp&nbsp
        <a href="">【...】</a>&nbsp&nbsp&nbsp
        <a href="">【...】</a>
    </div><br/><br/><br/>
    <div>
        信息<br/>
    </div>
</div>
</body>
</html>