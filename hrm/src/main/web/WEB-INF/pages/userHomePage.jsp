<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/19
  Time: 13:45
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
    <title>游客主页</title>
</head>
<body>
${sessionScope.loginUser.user_name}
</body>
</html>