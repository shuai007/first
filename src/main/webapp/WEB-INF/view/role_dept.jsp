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
        <form action="<c:url value='/updateRoleDept.do'/>" method="post">
        <input type="hidden" name="rid" value="${rb.rid}"/>
        <table border="1" rules="all">
            <tr align="center" bgcolor="aqua">
                <td>

                </td>
                <td>部门编号</td>
                <td>部门名称</td>
            </tr>
            <c:forEach var="d" items="${list}" varStatus="a">
                <tr align="center" bgcolor="${a.index%2==0?'pink':''}">
                    <td>
                        <input type="radio" value="${d.deptid}" name="deptid" ${rb.db.deptid==d.deptid?'checked':''}/>
                    </td>
                    <td>${d.deptid}</td>
                    <td>${d.dname}</td>
                </tr>
            </c:forEach>
            <tr align="center">
                <td colspan="111">
                    <input type="button" value="保存" onclick="roledept()"/>
                </td>
            </tr>
        </table>
        </form>
    </center>
</body>
<script>
    function roledept() {
        document.forms[0].submit();
        window.close();
    }
</script>
</html>
