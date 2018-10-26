<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div style="margin: auto; height: 100%; width: 50%">
    <div>
        <a href="toUserHomePage"><img src="resources/picture/5.png"></a>&nbsp&nbsp&nbsp
        <a href="toUserHomePage">【首页】</a>&nbsp&nbsp&nbsp
        <a href="toInterviewInvitationJspInterceptor">【面试邀请】</a>&nbsp&nbsp&nbsp
        <a href="toJspInterceptor">【面试结果】</a>
    </div><br/><br/>
    <div style="margin: auto; height: 100%; width: 50%">
        <div>
            <span style="font-size: 30px">简历中心</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            <a href="toJsp?jspName=resumeCreate">创建简历</a>
        </div>
        <div>
            <c:if test="${requestScope.resumeList == null}">
                <br/><br/><h3><c:out value="您尚未添加简历"></c:out></h3>
            </c:if>
            <c:if test="${requestScope.resumeList != null}">
                <table border="1" cellspacing="0">
                    <tr>
                        <th>简历名称</th>
                        <th>编辑简历</th>
                        <th>删除简历</th>
                    </tr>
                    <c:forEach items="${requestScope.resumeList}" var="i">
                        <tr>
                            <td>
                                    ${i.resume_designation}
                            </td>
                            <td>
                                <form action="queryResumeByResume_id">
                                    <input type="hidden" name="resume_id" value=${i.resume_id}>
                                    <input type="submit" value="编辑">
                                </form>
                            </td>
                            <td>
                                <form action="deleteResumeByResume_id">
                                    <input type="hidden" name="resume_id" value=${i.resume_id}>
                                    <input type="submit" value="删除">
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