<%--
  Created by IntelliJ IDEA.
  User: 31543
  Date: 2018/10/19
  Time: 14:30
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
    <title>用户注册</title>
    <script src="resources/js/jquery-3.2.1.js"></script>
    <script>
        $(function () {
            $("input[name='registerName']").blur(function () {
                $.ajax({
                    type:"get",
                    url:"ajaRegisterName",
                    data:{ajaregisterName:$("input[name='registerName']").val()},
                    success:function (obj) {
                        $("#sp").text(obj);
                    }
                })
            })
        })
    </script>
</head>
<body>
<div style="height: 100% ;width: 100%">
    <div style="height: 850px ; width: 500px;float: left">
        <img src="resources/picture/2.png">
    </div>

    <div style="height: 600px;width: 400px;left: 400px;top: 100px ;position: relative ;float: left">
        <h1>欢&nbsp迎&nbsp注&nbsp册&nbsp账&nbsp号</h1><br/>
        <h1>美好生活，前程无忧</h1><br/><br/>
        <form action="insertUser" method="post">
            昵称：<input type="text" name="registerName"/><span id="sp"></span><br/><br/><br/>
            密码：<input type="password" name="registerPass"/><br/><br/><br/>
            &nbsp&nbsp<input style="height: 22px;width: 190px"type="submit" value="立即注册">
        </form>
        <h4 style=" width: 200px;height: 25px;color: red;text-align: center">
            <%
                String str = (String) request.getAttribute("msg");
                if (str!=null){
                    out.print(str);
                }
            %>
        </h4>
        <div style="width: 200px;height: 22px;position: relative;left: 60px">
            <a href="toJsp?jspName=userLogin">已注册，去登陆—></a>
        </div>
    </div>
</div>
</body>
</html>