<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/25
  Time: 16:18
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
    <title>录用</title>
</head>
<body>
<div style="margin: auto; width: 60%">
    <div>
        <a href="toAdminHomePage"><img src="resources/picture/5.png"></a>&nbsp&nbsp&nbsp
        <a href="toAdminHomePage">【首页】</a>&nbsp&nbsp&nbsp
        <a href="toRecruitCenterJsp">【招聘中心】</a>&nbsp&nbsp&nbsp
    </div><br/><br/>

    <div style="margin: auto; width: 90%;background-color: aquamarine">
        <h1>选 择 录 用</h1>
        <c:if test="${requestScope.interviewList == null}">
            <br/><br/><h3><c:out value="暂无面试通知"></c:out></h3>
        </c:if>
        <c:if test="${requestScope.interviewList != null}">
            <c:forEach items="${requestScope.interviewList}" var="i">
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
                                姓 名 ：${i.interview_resume_name}
                            </td>
                        </tr>
                        <tr>
                            <td bgcolor="#9FCDEA" align="center">
                                <form action="employUser" method="post">
                                    <input type="hidden" name="interview_id" value="${i.interview_id}">
                                    <input type="hidden" name="offer_resume_name" value="${i.interview_resume_name}">
                                    <input type="hidden" name="offer_depart_name" value="${i.interview_recruit_departname}">
                                    <input type="hidden" name="offer_position_name" value="${i.interview_recruit_positionname}">
                                    <input type="hidden" name="offer_user_id" value="${i.interview_user_id}">
                                    <input type="hidden" name="interview_resume_id" value="${i.interview_resume_id}">
                                    <input type="hidden" name="interview_recruit_id" value="${i.interview_recruit_id}">
                                    <input style="height: 32px;width: 190px;background-color: pink" type="submit" value="录用">
                                </form>
                            </td>
                            <td bgcolor="#9FCDEA" align="center">
                                <form action="deleteInterview" method="post">
                                    <input type="hidden" name="interview_id" value="${i.interview_id}">
                                    <input style="height: 32px;width: 190px;background-color: red" type="submit" value="pass">
                                </form>
                            </td>
                        </tr>
                    </table><br/>
            </c:forEach>
        </c:if><br/>
    </div>
</div>
</body>
</html>