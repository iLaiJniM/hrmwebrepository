<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/24
  Time: 10:01
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
    <title>设置薪水</title>
</head>
<body>
<div style="margin: auto; width: 60%">
    <div>
        <a href="toAdminHomePage"><img src="resources/picture/5.png"></a>&nbsp&nbsp&nbsp
        <a href="toAdminHomePage">【首页】</a>&nbsp&nbsp&nbsp
        <a href="toRecruitCenterJsp">【招聘中心】</a>&nbsp&nbsp&nbsp
    </div><br/><br/>

    <div style="margin: auto; height: 100%; width: 80%;background-color: aquamarine">
        <div style="margin: auto; width: 95%;background-color: aquamarine">
            <form action="insertRecruit" method="post">
                <input type="hidden" name="recruit_department_id" value=${recruit_department_id}>
                <input type="hidden" name="recruit_department_name" value=${recruit_department_name}>
                <input type="hidden" name="recruit_position_id" value=${recruit_position_id}>
                <input type="hidden" name="recruit_position_name" value=${recruit_position_name}>
                <table width="800" border="1" align="center" cellpadding="10" cellspacing="0">
                    <caption><h1>薪 水 设 置</h1></caption>
                    <tr>
                        <td colspan="3" bgcolor="#9FCDEA" align="center">
                            薪 资 ：<input name="recruit_salary">
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
</div>
</body>
</html>