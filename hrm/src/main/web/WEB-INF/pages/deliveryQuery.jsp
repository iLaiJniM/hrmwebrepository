<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/24
  Time: 22:20
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
    <title>查看应聘简历</title>
</head>
<body>
<div style="margin: auto; width: 60%">
    <div>
        <a href="toAdminHomePage"><img src="resources/picture/5.png"></a>&nbsp&nbsp&nbsp
        <a href="toAdminHomePage">【首页】</a>&nbsp&nbsp&nbsp
        <a href="toRecruitCenterJsp">【招聘中心】</a>&nbsp&nbsp&nbsp
    </div><br/><br/>

    <div style="margin: auto; height: 100%; width: 80%;background-color: aquamarine">
        <div>
            <span style="font-size: 30px">查看应聘简历</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        </div><br/><br/>
        <div>
            <c:if test="${requestScope.deliveryList == null}">
                <br/><br/><h3><c:out value="尚无任何人应聘此职位"></c:out></h3>
            </c:if>
            <c:if test="${requestScope.deliveryList != null}">
                <table border="1" cellspacing="0">
                    <tr>
                        <th>申请人姓名</th>
                        <th>读取状态</th>
                        <th>查看简历</th>
                        <th>面试邀请</th>
                    </tr>
                    <c:forEach items="${requestScope.deliveryList}" var="i">
                        <tr>
                            <td>${i.delivery_resume_name}</td>
                            <td>
                                <c:if test="${i.delivery_state == 0}">
                                    ${"未读"}
                                </c:if>
                                <c:if test="${i.delivery_state == 1}">
                                    ${"已读"}
                                </c:if>
                            </td>
                            <td>
                                <form action="queryResumeByDelivery_resume_id">
                                    <input type="hidden" name="delivery_id" value="${i.delivery_id}">
                                    <input type="hidden" name="delivery_resume_id" value="${i.delivery_resume_id}">
                                    <input type="hidden" name="delivery_recruit_id" value="${i.delivery_recruit_id}">
                                    <input type="submit" value="查看">
                                </form>
                            </td>
                            <td>
                                <form action="interviewCreate">
                                    <input type="hidden" name="interview_user_id" value="${i.delivery_user_id}">
                                    <input type="submit" value="邀请面试">
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