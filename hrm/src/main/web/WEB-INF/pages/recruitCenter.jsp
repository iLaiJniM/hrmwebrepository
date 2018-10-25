<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/23
  Time: 10:08
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
    <title>招聘中心</title>
</head>
<body>
<div style="margin: auto; height: 100%; width: 80%">
    <div>
        <a href="toAdminHomePage"><img src="resources/picture/5.png"></a>&nbsp&nbsp&nbsp
        <a href="toAdminHomePage">【首页】</a>&nbsp&nbsp&nbsp
        <a href="toDepartmentCenterJsp">【部门中心】</a>&nbsp&nbsp&nbsp
        <a href="toTrainCenterJsp">【培训中心】</a>
    </div><br/><br/>
    <div style="margin: auto; height: 100%; width: 80%">
        <div>
            <span style="font-size: 30px">已发布招聘</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            <a href="recruitCreate">创建招聘信息</a>&nbsp&nbsp&nbsp
            <a href="unpublishedRecruit">未发布招聘</a>&nbsp&nbsp&nbsp
            <a href="employ">挑选录用</a>&nbsp&nbsp&nbsp
        </div><br/>
        <div>
            <c:if test="${requestScope.recruitList == null}">
                <br/><br/><h3><c:out value="尚无已发布招聘信息"></c:out></h3>
            </c:if>
            <c:if test="${requestScope.recruitList != null}">
                <table border="1" cellspacing="0">
                    <tr>
                        <th>招聘部门</th>
                        <th>招聘职位</th>
                        <th>招聘薪资</th>
                        <th>创建时间</th>
                        <th>撤回招聘</th>
                        <th>删除招聘</th>
                        <th>查看应聘</th>
                    </tr>
                    <c:forEach items="${requestScope.recruitList}" var="i">
                        <tr>
                            <td>${i.recruit_department_name}</td>
                            <td>${i.recruit_position_name}</td>
                            <td>${i.recruit_salary}</td>
                            <td>${i.recruit_createtime}</td>
                            <td>
                                <form action="updateRecruit">
                                    <input type="hidden" name="recruit_id" value=${i.recruit_id}>
                                    <input type="submit" value="撤回">
                                </form>
                            </td>
                            <td>
                                <form action="deleteRecruit1">
                                    <input type="hidden" name="recruit_id" value=${i.recruit_id}>
                                    <input type="submit" value="删除">
                                </form>
                            </td>
                            <td>
                                <form action="queryDelivery">
                                    <input type="hidden" name="delivery_recruit_id" value=${i.recruit_id}>
                                    <input type="submit" value="查看应聘">
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