<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/23
  Time: 10:43
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
    <title>部门创建</title>
</head>
<body>
<div style="margin: auto; width: 60%">
    <div>
        <a href="toAdminHomePage"><img src="resources/picture/5.png"></a>&nbsp&nbsp&nbsp
        <a href="toAdminHomePage">【首页】</a>&nbsp&nbsp&nbsp
        <a href="toDepartmentCenterJsp">【部门中心】</a>&nbsp&nbsp&nbsp
    </div><br/><br/>
    <div style="margin: auto; width: 90%;background-color: aquamarine">
        <form action="insertDepartment" method="post">
            <table width="800" border="1" align="center" cellpadding="10" cellspacing="0">
                <caption><h1>部 门 添 加</h1></caption>
                <tr>
                    <td colspan="3" bgcolor="#9FCDEA" align="center">
                        部 门 名 称 ：<input name="department_name">
                    </td>
                </tr>
            </table><br/><br/>
            <div style="text-align: center">
                <input style="height: 32px;width: 190px" type="submit" value="保存">
                <h4 style=" width: 200px;height: 25px;color: red;text-align: center">
                    ${requestScope.msg}
                </h4>
            </div><br/>
        </form>
    </div>
</div>
</body>
</html>