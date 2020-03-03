<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>输入邮箱地址获取验证码</h1>
  <form action="${pageContext.request.contextPath}/textAndImgAndFileEmail" method="post">
    <input type="email" name="userEmail" />
    <input type="submit" value="获取验证码" />
  </form>
  </body>
</html>
