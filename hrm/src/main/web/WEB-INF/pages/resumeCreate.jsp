<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/19
  Time: 23:43
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
    <title>创建简历</title>
    <style type="text/css">
        tr{
            height: 75px;
        }
        #tr1{
            height: 150px;
        }
    </style>
</head>
<body>
<div style="margin: auto; width: 60%">
    <div>
        <a href="toUserHomePage"><img src="resources/picture/5.png"></a>&nbsp&nbsp&nbsp
        <a href="toUserHomePage">【首页】</a>&nbsp&nbsp&nbsp
        <a href="toResumeCenterJspInterceptor?jspName=resumeCenter">【简历中心】</a>&nbsp&nbsp&nbsp
    </div><br/><br/>
    <div style="margin: auto; width: 90%;background-color: aquamarine">
        <form action="insertResume" method="post">
            <table width="800" border="1" align="center" cellpadding="10" cellspacing="0">
                <caption><h3>个人简历</h3></caption>
                <tr>
                    <td colspan="3" bgcolor="#9FCDEA" align="center">
                        简 历 名 称 ：<input name="resume_designation">
                    </td>
                </tr>
                <tr>
                    <td>
                        姓 名 ：<input name="resume_name">
                    </td>
                    <td>
                        最 高 学 历 ：<input name="resume_education">
                    </td>
                </tr>
                <tr>
                    <td>
                        年 龄 ：<input name="resume_age">
                    </td>
                    <td>
                        手 机 号 码 ：<input name="resume_phone">
                    </td>
                </tr>
                <tr>
                    <td>
                        性 别 ：<input name="resume_sex">
                    </td>
                    <td>
                        毕 业 院 校 ：<input name="resume_school">
                    </td>
                </tr>
                <tr>
                    <td>
                        专 业 ：<input name="resume_major">
                    </td>
                    <td>
                        工 作 经 验 ：<input name="resume_workyear">
                    </td>
                </tr>
                <tr id="tr1">
                    <td colspan="2">
                        简 介 ：<textarea name="resume_intro" style="height:90%;width: 90%" ></textarea>
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