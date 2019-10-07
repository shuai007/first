<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/14
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <table border="1" rules="all">
            <tr align="center" bgcolor="aqua">
                <td>编号</td>
                <td>商品名称</td>
            </tr>
            <c:forEach var="g" items="${list}" varStatus="a">
                <tr align="center" bgcolor="${a.index%2==0?'pink':''}">
                    <td>${g.id}</td>
                    <td>${g.gname}</td>
                </tr>
            </c:forEach>
        </table>

    </center>
</body>
</html>
