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
    <title>某公司招聘网站</title>
</head>
<body>
<div style="margin: auto; height: 100%; width: 80%">
欢迎用户${sessionScope.loginUser.user_name}&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="toJsp?jspName=userLogin">【登录】</a>&nbsp&nbsp&nbsp
<a href="toJsp?jspName=userRegister">【注册】</a>&nbsp&nbsp&nbsp<br/><br/><br/>
<div>
    <a href="toJspInterceptor?jspName=resumeCenter">【简历中心】</a>&nbsp&nbsp&nbsp
    <a href="toJspInterceptor?jspName=interviewInvitation">【面试邀请】</a>&nbsp&nbsp&nbsp
    <a href="toJspInterceptor?jspName=interviewResults">【面试结果】</a>
</div><br/><br/><br/>
<div>
    招聘信息<br/>
</div>
</div>
</body>
</html>