<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/24
  Time: 20:24
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
    <title>简历挑选</title>
</head>
<body>
<div style="margin: auto; height: 100%; width: 80%">
    <div style="margin: auto; height: 100%; width: 80%">
        <div>
            <span style="font-size: 30px">简历挑选</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        </div>
        <div>
            <c:if test="${requestScope.resumeList == null}">
                <br/><br/><h3><c:out value="您尚未添加简历"></c:out></h3>
            </c:if>
            <c:if test="${requestScope.resumeList != null}">
                <table border="1" cellspacing="0">
                    <tr>
                        <th>简历名称</th>
                        <th>选择简历</th>
                    </tr>
                    <c:forEach items="${requestScope.resumeList}" var="i">
                        <tr>
                            <td>
                                    ${i.resume_designation}
                            </td>
                            <td>
                                <form action="insertDelivery">
                                    <input type="hidden" name="delivery_recruit_id" value=${recruit_id}>
                                    <input type="hidden" name="delivery_resume_id" value=${i.resume_id}>
                                    <input type="submit" value="确认">
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