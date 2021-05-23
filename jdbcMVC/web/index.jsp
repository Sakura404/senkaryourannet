<%--
  Created by IntelliJ IDEA.
  User: demo
  Date: 2021/5/23
  Time: 下午2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <table border="1px">
        <tr>
            <a href="#">新增</a>
        </tr>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>address</td>
            <td>phone</td>
            <td>age</td>
            <td>createdate</td>
            <td>modifydate</td>
            <td>createby</td>
            <td>操作</td>
        </tr>

        <c:forEach var="users" items="${userList}" varStatus="varStatus">
           <c:if test="${varStatus.index %2!=0}">
            <tr style="background-color: #ccc">
           </c:if>
            <td>${users.id}</td>
            <td>${users.name}</td>
            <td><c:out value="${users.address}"></c:out></td>
            <td>${users.phone}</td>
            <td>${users.age}</td>
            <td>
                <fmt:formatDate value="${users.createdate}"
                    pattern="yyyy-MM-dd HH:mm:ss"
                    ></fmt:formatDate>
            </td>
            <td>

                <fmt:formatDate value="${users.modifydate}"
                                pattern="yyyy-MM-dd HH:mm:ss"
                ></fmt:formatDate>
                   </td>
            <td>${users.createby}</td>
            <td><a href="#">修改</a></td>
            <td><a href="delUser?id=${users.id}">删除</a></td>
        </tr>
        </c:forEach>
    </table>


  </body>
</html>
