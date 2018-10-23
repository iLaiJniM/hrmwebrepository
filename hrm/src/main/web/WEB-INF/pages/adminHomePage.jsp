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
    <title>管理员主页</title>
</head>
<body>
<div style="margin: auto; height: 100%; width: 80%">
    欢迎管理员${sessionScope.loginAdmin_name} &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <a href="exitLoginAdmin">【退出登录】</a>
    <br/><br/><br/>
    <div>
        <a href="toDepartmentCenterJsp">【部门中心】</a>&nbsp&nbsp&nbsp
        <a href="toRecruitCenterJsp">【招聘中心】</a>&nbsp&nbsp&nbsp
        <a href="toTrainCenterJsp">【培训中心】</a>
    </div><br/><br/><br/>
    <div>
        信息<br/>
    </div>
</div>
</body>
</html>