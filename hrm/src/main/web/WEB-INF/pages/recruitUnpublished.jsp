<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/24
  Time: 11:19
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
    <title>未发布的招聘信息</title>
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
            <span style="font-size: 30px">未发布招聘</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        </div>
        <div>
            <c:if test="${requestScope.recruitList == null}">
                <br/><br/><h3><c:out value="尚无未发布招聘信息"></c:out></h3>
            </c:if>
            <c:if test="${requestScope.recruitList != null}">
                <table border="1" cellspacing="0">
                    <tr>
                        <th>招聘部门</th>
                        <th>招聘职位</th>
                        <th>招聘薪资</th>
                        <th>确认发布</th>
                        <th>修改薪资</th>
                        <th>确认删除</th>
                    </tr>
                    <c:forEach items="${requestScope.recruitList}" var="i">
                        <tr>
                            <td>${i.recruit_department_name}</td>
                            <td>${i.recruit_position_name}</td>
                            <td>${i.recruit_salary}</td>
                            <td>
                                <form action="publishRecruit">
                                    <input type="hidden" name="recruit_id" value=${i.recruit_id}>
                                    <input type="submit" value="发布">
                                </form>
                            </td>
                            <td>
                                <form action="queryRecruit">
                                    <input type="hidden" name="recruit_id" value=${i.recruit_id}>
                                    <input type="submit" value="修改">
                                </form>
                            </td>
                            <td>
                                <form action="deleteRecruit1">
                                    <input type="hidden" name="recruit_id" value=${i.recruit_id}>
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