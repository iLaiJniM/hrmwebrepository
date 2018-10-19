<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/19
  Time: 16:59
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
    <title>简历中心</title>
</head>
<body>
<div style="margin: auto; height: 100%; width: 80%">
    <div>
        <a href="toJsp?jspName=../../index"><img src="resources/picture/5.png"></a>&nbsp&nbsp&nbsp
        <a href="toJsp?jspName=../../index">【首页】</a>&nbsp&nbsp&nbsp
        <a href="toJsp?jspName=interviewInvitation">【面试邀请】</a>&nbsp&nbsp&nbsp
        <a href="toJsp?jspName=interviewResults">【面试结果】</a>
    </div>
    <div style="margin: auto; height: 100%; width: 80%">
        <div>
            <span style="font-size: 30px">简历中心</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            <a href="toJsp?jspName=resumeCreate">创建简历</a>
        </div>
        <div>
            <c:if></c:if>
            <table border="1" cellspacing="0">
                <tr>
                    <th>简历名称</th>
                    <th>编辑简历</th>
                    <th>删除简历</th>
                </tr>

                <tr>
                    <td>我的简历1</td>
                    <td>
                        <form action="getUserDetailById">
                            <input type="hidden" name="id" value="<%=%>">
                            <input type="submit" value="编辑">
                        </form>
                    </td>
                    <td>
                        <form action="deleteUserDetailById">
                            <input type="hidden" name="id" value="<%=%>">
                            <input type="submit" value="删除">
                        </form>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>