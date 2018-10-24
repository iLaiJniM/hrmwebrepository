<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/23
  Time: 19:38
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
    <title>查看职位</title>
</head>
<body>
<div style="margin: auto; height: 100%; width: 80%">
    <div>
        <a href="toAdminHomePage"><img src="resources/picture/5.png"></a>&nbsp&nbsp&nbsp
        <a href="toAdminHomePage">【首页】</a>&nbsp&nbsp&nbsp
        <a href="toDepartmentCenterJsp">【部门中心】</a>&nbsp&nbsp&nbsp
        <a href="toRecruitCenterJsp">【招聘中心】</a>&nbsp&nbsp&nbsp
        <a href="toTrainCenterJsp">【培训中心】</a>
    </div>
    <div style="margin: auto; height: 100%; width: 80%">
        <div>
            <span style="font-size: 30px">职位查看</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            <a href="positionCreate?department_id=${department_id}">创建职位</a>
        </div>
        <div>
            <c:if test="${requestScope.positionList == null}">
                <br/><br/><h3><c:out value="该部门尚未添加职位"></c:out></h3>
            </c:if>
            <c:if test="${requestScope.positionList != null}">
                <table border="1" cellspacing="0">
                    <tr>
                        <th>职位名称</th>
                        <th>创建时间</th>
                        <th>职位更名</th>
                        <th>删除职位</th>
                        <th>查看员工</th>
                    </tr>
                    <c:forEach items="${requestScope.positionList}" var="i">
                        <tr>
                            <td>${i.position_name}</td>
                            <td>${i.position_createtime}</td>
                            <td>
                                <form action="toUpdatePosition">
                                    <input type="hidden" name="position_id" value=${i.position_id}>
                                    <input type="hidden" name="department_id" value=${department_id}>
                                    <input type="submit" value="更名">
                                </form>
                            </td>
                            <td>
                                <form action="deletePosition">
                                    <input type="hidden" name="position_id" value=${i.position_id}>
                                    <input type="hidden" name="department_id" value=${department_id}>
                                    <input type="submit" value="删除">
                                </form>
                            </td>
                            <td>
                                <form action="queryEmployee1">
                                    <input type="hidden" name="position_id" value=${i.position_id}>
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