<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/19
  Time: 11:27
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
    <title>index</title>
</head>
<body>
<div style="height: 100% ;width: 100% ">
    <div style="height: 100px ; width: 1900px;background-color: antiquewhite;color: deepskyblue;font-size: 50px"></div><br/><br/><br/><br/><br/><br/>
    <div style="text-align: center">
        <h1>点击图片进入官网</h1><br/>
        <a href="toUserHomePage"><img src="resources/picture/1.png"></a>
    </div>
</div>
</body>
</html>