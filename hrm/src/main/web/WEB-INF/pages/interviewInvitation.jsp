<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/19
  Time: 21:28
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
    <title>面试邀请</title>
</head>
<body>
<div style="margin: auto; height: 100%; width: 80%">
    <div>
        <a href="toUserHomePage"><img src="resources/picture/5.png"></a>&nbsp&nbsp&nbsp
        <a href="toUserHomePage">【首页】</a>&nbsp&nbsp&nbsp
        <a href="toResumeCenterJspInterceptor?jspName=resumeCenter">【简历中心】</a>&nbsp&nbsp&nbsp
        <a href="toJspInterceptor">【面试结果】</a>
    </div><br/><br/>
    <div style="margin: auto; width: 90%;background-color: aquamarine">
        <h1>面 试 邀 请</h1>
        <c:if test="${requestScope.interviewList == null}">
            <br/><br/><h3><c:out value="暂无面试通知"></c:out></h3>
        </c:if>
        <c:if test="${requestScope.interviewList != null}">
            <c:forEach items="${requestScope.interviewList}" var="i">
                <form action="confirmInterview">
                    <input type="hidden" name="interview_id" value="${i.interview_id}">
                    <table width="800" border="1" align="center" cellpadding="10" cellspacing="0">
                        <tr>
                            <td>
                                应 聘 部 门 ：${i.interview_recruit_departname}
                            </td>
                            <td>
                                面 试 日 期 ：${i.interview_date}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                应 聘 职 位 ：${i.interview_recruit_positionname}
                            </td>
                            <td>
                                面 试 时 间 ：${i.interview_time}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                地 点 ：${i.interview_place}
                            </td>
                            <td>
                                状 态 ：
                                <c:if test="${i.interview_state == 0}">
                                    <span style="color: red">${"未确认"}</span>
                                </c:if>
                                <c:if test="${i.interview_state == 1}">
                                    <span style="color: dodgerblue">${"已确认"}</span>
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" bgcolor="#9FCDEA" align="center">
                                <input style="height: 32px;width: 190px;background-color: pink" type="submit" value="确认面试">
                            </td>
                        </tr>
                    </table>
                </form><br/><br/>
            </c:forEach>
        </c:if><br/>
    </div>
</div>
</body>
</html>