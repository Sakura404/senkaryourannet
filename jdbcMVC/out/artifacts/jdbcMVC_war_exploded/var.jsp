<%--
  Created by IntelliJ IDEA.
  User: demo
  Date: 2021/5/23
  Time: 下午3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%String name = "张三";
      request.setAttribute("name",name);
    %>
    ${name}


    ${10+10}

    ${10/0}

    ${10 eq 9}

</body>
</html>
