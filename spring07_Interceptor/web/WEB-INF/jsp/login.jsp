<%--
  Created by IntelliJ IDEA.
  User: Beloved
  Date: 2020/3/3
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>用户登录</h1>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    <p>
        用户名<input type="text" name="username"/>
    </p>
    <p>
        密码<input type="text" name="pwd" />
    </p>
    <p>
        <input type="submit" value="登录" />
    </p>
</form>
</body>
</html>
