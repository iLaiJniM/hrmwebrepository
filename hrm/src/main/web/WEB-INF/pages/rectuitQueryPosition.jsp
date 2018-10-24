<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/24
  Time: 9:41
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
    <title>Title</title>
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
            <span style="font-size: 30px">选择职位</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        </div>
        <div>
            <c:if test="${requestScope.positionList == null}">
                <br/><br/><h3><c:out value="尚无任何职位可选"></c:out></h3>
            </c:if>
            <c:if test="${requestScope.positionList != null}">
                <table border="1" cellspacing="0">
                    <tr>
                        <th>职位名称</th>
                        <th>创建时间</th>
                        <th>选择职位</th>
                    </tr>
                    <c:forEach items="${requestScope.positionList}" var="i">
                        <tr>
                            <td>${i.position_name}</td>
                            <td>${i.position_createtime}</td>
                            <td>
                                <form action="rectuitSetSalary">
                                    <input type="hidden" name="recruit_department_id" value=${department_id}>
                                    <input type="hidden" name="recruit_department_name" value=${department_name}>
                                    <input type="hidden" name="recruit_position_id" value=${i.position_id}>
                                    <input type="hidden" name="recruit_position_name" value=${i.position_name}>
                                    <input type="submit" value="选择">
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