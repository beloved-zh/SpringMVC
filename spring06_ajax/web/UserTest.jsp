<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>

    <script>
        $(function () {

            $("#but").click(function () {
                
                $.post(
                    "${pageContext.request.contextPath}/a2",
                    function (data) {

                        var html = "";

                        for (let i = 0; i < data.length; i++) {
                            html += "<tr>" +
                                "<td>"+data[i].id+"</td>" +
                                "<td>"+data[i].name+"</td>" +
                                "<td>"+data[i].age+"</td>" +
                                "<td>"+data[i].sex+"</td>" +
                                "</tr>";
                        }
                        
                        $("#content").html(html);
                    }
                );
                
            });

        });
    </script>
</head>
<body>
<input type="button" id="but" value="加载数据">
<table border="1" cellspacing="0" cellpadding="0" width="500px">
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
    </tr>
    <tbody id="content">

    </tbody>
</table>

</body>
</html>
