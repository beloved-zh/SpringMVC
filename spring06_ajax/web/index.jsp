<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>

    <script type="text/javascript">
      function a() {
        $.post(
                "${pageContext.request.contextPath}/a1",
                {"name":$("#userName").val()},
                function (data) {
                  alert(data);
                }
        );
      };
    </script>

  </head>
  <body>

  <%--失去焦点发送一个请求到后台--%>
  <input type="text" id="userName" onblur="a()"/>
  </body>
</html>
