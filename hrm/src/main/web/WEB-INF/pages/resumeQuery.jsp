<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/24
  Time: 22:39
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
    <title>查看应聘者简历</title>
</head>
<body>
<div style="margin: auto; width: 60%">
    <div>
        <a href="toAdminHomePage"><img src="resources/picture/5.png"></a>&nbsp&nbsp&nbsp
        <a href="toAdminHomePage">【首页】</a>&nbsp&nbsp&nbsp
        <a href="toRecruitCenterJsp">【招聘中心】</a>&nbsp&nbsp&nbsp
        <a href="queryDelivery?delivery_recruit_id=${delivery_recruit_id}">【返回上级】</a>&nbsp&nbsp&nbsp
    </div><br/><br/>
    <div style="margin: auto; width: 90%;background-color: aquamarine">
        <form action="updateResume" method="post">
            <input type="hidden" name="resume_id" value=${requestScope.resume.resume_id}>
            <table width="800" border="1" align="center" cellpadding="10" cellspacing="0">
                <caption><h3>应 聘 者 简 历</h3></caption>
                <tr>
                    <td colspan="3" bgcolor="#9FCDEA" align="center">
                        简 历 名 称 ：${requestScope.resume.resume_designation}
                    </td>
                </tr>
                <tr>
                    <td>
                        姓 名 ：${requestScope.resume.resume_name}
                    </td>
                    <td>
                        最 高 学 历 ：${requestScope.resume.resume_education}
                    </td>
                </tr>
                <tr>
                    <td>
                        年 龄 ：${requestScope.resume.resume_age}
                    </td>
                    <td>
                        手 机 号 码 ：${requestScope.resume.resume_phone}
                    </td>
                </tr>
                <tr>
                    <td>
                        性 别 ：${requestScope.resume.resume_sex}
                    </td>
                    <td>
                        毕 业 院 校 ：${requestScope.resume.resume_school}
                    </td>
                </tr>
                <tr>
                    <td>
                        专 业 ：${requestScope.resume.resume_major}
                    </td>
                    <td>
                        工 作 经 验 ：${requestScope.resume.resume_workyear}年
                    </td>
                </tr>
                <tr id="tr1">
                    <td colspan="2">
                        简 介 ：${requestScope.resume.resume_intro}
                    </td>
                </tr>
            </table><br/><br/>
        </form>
    </div>
</div>
</body>
</html>