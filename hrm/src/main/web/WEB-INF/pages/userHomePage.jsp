<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/22
  Time: 13:52
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
<div style="margin: auto; height: 100%; width: 50%">
    欢迎用户${sessionScope.loginUser.user_name}&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <a href="toJsp?jspName=userRegister">【用户注册】</a>&nbsp&nbsp&nbsp
    <a href="toJsp?jspName=userLogin">【用户登录】</a>&nbsp&nbsp&nbsp
    <a href="toJsp?jspName=employeeLogin">【员工登录】</a>&nbsp&nbsp&nbsp
    <a href="toJsp?jspName=adminLogin">【管理员登录】</a>&nbsp&nbsp&nbsp
    <a href="exitLoginUser">【退出登录】</a>
    <br/><br/><br/>
    <div>
        <a href="toResumeCenterJspInterceptor?jspName=resumeCenter">【简历中心】</a>&nbsp&nbsp&nbsp
        <a href="toJspInterceptor?jspName=interviewInvitation">【面试邀请】</a>&nbsp&nbsp&nbsp
        <a href="toJspInterceptor?jspName=interviewResults">【面试结果】</a>
    </div><br/><br/><br/>
    <div style="margin: auto; height: 100%; width: 80%">
        <h1>招 聘 信 息</h1>
        <div>
            <c:if test="${sessionScope.recruitList == null}">
                <br/><br/><h3><c:out value="尚无已发布招聘信息"></c:out></h3>
            </c:if>
            <c:if test="${sessionScope.recruitList != null}">
                <table border="1" cellspacing="0">
                    <tr>
                        <th>招聘部门</th>
                        <th>招聘职位</th>
                        <th>招聘薪资</th>
                        <th>创建时间</th>
                        <th>投递简历</th>
                    </tr>
                    <c:forEach items="${sessionScope.recruitList}" var="i">
                        <tr>
                            <td>${i.recruit_department_name}</td>
                            <td>${i.recruit_position_name}</td>
                            <td>${i.recruit_salary}</td>
                            <td>${i.recruit_createtime}</td>
                            <td>
                                <form action="handInResume">
                                    <input type="hidden" name="recruit_id" value=${i.recruit_id}>
                                    <input type="submit" value="投递">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>