<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/19
  Time: 21:34
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
    <title>面试结果</title>
</head>
<body>
<div style="margin: auto; height: 100%; width: 80%">
    <div>
        <a href="toJsp?jspName=../../index"><img src="resources/picture/5.png"></a>&nbsp&nbsp&nbsp
        <a href="toJsp?jspName=../../index">【首页】</a>&nbsp&nbsp&nbsp
        <a href="toJsp?jspName=interviewInvitation">【简历中心】</a>&nbsp&nbsp&nbsp
        <a href="toJsp?jspName=interviewResults">【面试邀请】</a>
    </div>

</div>
</body>
</html>