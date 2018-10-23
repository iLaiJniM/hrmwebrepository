<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/23
  Time: 9:31
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
    <title>部门中心</title>
</head>
<body>
<div style="margin: auto; height: 100%; width: 80%">
    <div>
        <a href="toAdminHomePage"><img src="resources/picture/5.png"></a>&nbsp&nbsp&nbsp
        <a href="toAdminHomePage">【首页】</a>&nbsp&nbsp&nbsp
        <a href="toRecruitCenterJsp">【招聘中心】</a>&nbsp&nbsp&nbsp
        <a href="toTrainCenterJsp">【培训中心】</a>
    </div>
    <div style="margin: auto; height: 100%; width: 80%">
        <div>
            <span style="font-size: 30px">部门中心</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            <a href="toJsp1?jspName=departmentCreate">创建部门</a>
        </div>
        <div>
            <c:if test="${requestScope.departmentList == null}">
                <br/><br/><h3><c:out value="您尚未添加部门"></c:out></h3>
            </c:if>
            <c:if test="${requestScope.departmentList != null}">
                <table border="1" cellspacing="0">
                    <tr>
                        <th>部门名称</th>
                        <th>创建时间</th>
                        <th>部门更名</th>
                        <th>删除部门</th>
                        <th>查看职位</th>
                        <th>查看员工</th>
                    </tr>
                    <c:forEach items="${requestScope.departmentList}" var="i">
                        <tr>
                            <td>${i.department_name}</td>
                            <td>${i.department_createtime}</td>
                            <td>
                                <form action="queryDepartment">
                                    <input type="hidden" name="department_id" value=${i.department_id}>
                                    <input type="submit" value="更名">
                                </form>
                            </td>
                            <td>
                                <form action="deleteDepartment">
                                    <input type="hidden" name="department_id" value=${i.department_id}>
                                    <input type="submit" value="删除">
                                </form>
                            </td>
                            <td>
                                <form action="queryPosition">
                                    <input type="hidden" name="department_id" value=${i.department_id}>
                                    <input type="submit" value="查看">
                                </form>
                            </td>
                            <td>
                                <form action="queryEmployee">
                                    <input type="hidden" name="department_id" value=${i.department_id}>
                                    <input type="submit" value="查看">
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