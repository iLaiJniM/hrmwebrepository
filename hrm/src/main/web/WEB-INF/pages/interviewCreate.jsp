<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/25
  Time: 1:11
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
    <title>创建面试邀请</title>
</head>
<script src="resources/js/jquery-3.2.1.js"></script>
<script>
    $(function(){
        var date_now = new Date();       //得到当前时间
        var year = date_now.getFullYear();      //得到当前年份
        //  1：js中获取Date中的month时，会比当前月份少一个月，所以这里需要先加一
        //  2: 判断当前月份是否小于10，如果小于，那么就在月份的前面加一个 '0' ， 如果大于，就显示当前月份
        var month = date_now.getMonth()+1 < 10 ? "0"+(date_now.getMonth()+1) : (date_now.getMonth()+1);   //得到当前月份
        var date = date_now.getDate() < 10 ? "0"+date_now.getDate() : date_now.getDate();  //得到当前日子（多少号）


        var date = date_now.getDate();

        $("#interview").attr("min",year+"-"+month+"-"+date); //设置input标签的max属性
    })
</script>

<body>
<div style="margin: auto; width: 60%">
    <div>
        <a href="toAdminHomePage"><img src="resources/picture/5.png"></a>&nbsp&nbsp&nbsp
        <a href="toAdminHomePage">【首页】</a>&nbsp&nbsp&nbsp
        <a href="toRecruitCenterJsp">【招聘中心】</a>&nbsp&nbsp&nbsp
    </div><br/><br/>
    <div style="margin: auto; width: 90%;background-color: aquamarine">
        <form action="updateResume" method="post">
            <input type="hidden" name="resume_id" value=${requestScope.resume.resume_id}>
            <table width="800" border="1" align="center" cellpadding="10" cellspacing="0">
                <caption><h1>面 试 邀 请</h1></caption>
                <tr>
                    <td colspan="3" bgcolor="#9FCDEA" align="center">编写</td>
                </tr>
                <tr>
                    <td>
                        时 间 ：<input id="interview" type="date" value min="${d}"><input type="time">
                    </td>
                </tr>
                <tr>
                    <td>
                        地 点 ：<input type="text" name="interview_place">
                    </td>
                </tr>
            </table><br/><br/>
            <div style="text-align: center">
                <input style="height: 32px;width: 190px" type="submit" value="保存">
                <h4 style=" width: 200px;height: 25px;color: red;text-align: center">
                    ${requestScope.msg}
                </h4>
            </div><br/>
        </form><td>
    </td>
    </div>
</div>
</body>
</html>