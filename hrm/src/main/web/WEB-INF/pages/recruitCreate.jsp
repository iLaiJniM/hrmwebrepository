<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/24
  Time: 9:20
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
    <title>创建招聘信息</title>
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
            <span style="font-size: 30px">选择部门</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        </div>
        <div>
            <c:if test="${requestScope.departmentList == null}">
                <br/><br/><h3><c:out value="尚无任何部门可选"></c:out></h3>
            </c:if>
            <c:if test="${requestScope.departmentList != null}">
                <table border="1" cellspacing="0">
                    <tr>
                        <th>部门名称</th>
                        <th>创建时间</th>
                        <th>选择部门</th>
                    </tr>
                    <c:forEach items="${requestScope.departmentList}" var="i">
                        <tr>
                            <td>${i.department_name}</td>
                            <td>${i.department_createtime}</td>
                            <td>
                                <form action="rectuitQueryPosition">
                                    <input type="hidden" name="department_id" value=${i.department_id}>
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