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
                <td>部门编号</td>
                <td>部门名称</td>
                <td>用户数量</td>
                <td>角色数量</td>
                <td colspan="6">新增部门</td>
            </tr>
            <c:forEach var="d" items="${list}" varStatus="a">
                <tr align="center" bgcolor="${a.index%2==0?'pink':''}">
                    <td>${d.deptid}</td>
                    <td>${d.dname}</td>
                    <td>${d.ubs.size()}</td>
                    <td>${d.rbs.size()}</td>
                    <td>
                        <button>查看用户</button>
                    </td>
                    <td>
                        <button>查看角色</button>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </center>
</body>
</html>
