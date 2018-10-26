<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/19
  Time: 21:34
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
    <title>面试结果</title>
</head>
<body>
<div style="margin: auto; height: 100%; width: 50%">
    <div>
        <a href="toUserHomePage"><img src="resources/picture/5.png"></a>&nbsp&nbsp&nbsp
        <a href="toUserHomePage">【首页】</a>&nbsp&nbsp&nbsp
        <a href="toResumeCenterJspInterceptor?jspName=resumeCenter">【简历中心】</a>&nbsp&nbsp&nbsp
        <a href="toInterviewInvitationJspInterceptor">【面试邀请】</a>
    </div><br/><br/><br/><br/>
    <div style="margin: auto; height: 100%; width: 60%">
        <c:if test="${requestScope.offerList == null}">
            ${尚无您的offer}
        </c:if>
        <c:if test="${requestScope.offerList != null}">
            <table border="1" cellspacing="0" style="background-color: deepskyblue">
                <c:forEach items="${requestScope.offerList}" var="i">
                    <tr >
                        <td>
                            <br/>尊敬的${i.offer_resume_name}先生您好：<br/><br/>
                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp恭喜，您已被我公司录取，请您于3天内来我公司${i.offer_depart_name}报道，职位为${i.offer_position_name}。<br/>
                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp公司有您的加入将锦上添花，希望在未来的日子里公司有您展翅高飞！<br/><br/><br/><br/><br/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            发件人：人事李女士<br/><br/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>

</div>
</body>
</html>