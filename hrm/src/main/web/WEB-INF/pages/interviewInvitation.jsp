<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/19
  Time: 21:28
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
    <title>面试邀请</title>
</head>
<body>
<div style="margin: auto; height: 100%; width: 80%">
    <div>
        <a href="toUserHomePage"><img src="resources/picture/5.png"></a>&nbsp&nbsp&nbsp
        <a href="toUserHomePage">【首页】</a>&nbsp&nbsp&nbsp
        <a href="toResumeCenterJspInterceptor?jspName=resumeCenter">【简历中心】</a>&nbsp&nbsp&nbsp
        <a href="toJsp?jspName=interviewResults">【面试结果】</a>
    </div>

</div>
</body>
</html>