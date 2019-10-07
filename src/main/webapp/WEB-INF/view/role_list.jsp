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
                <td>角色id</td>
                <td>角色名称</td>
                <td>从属部门</td>
                <td>所持权限</td>
                <td colspan="6">新增角色</td>
            </tr>
            <c:forEach var="r" items="${list}" varStatus="a">
                <tr align="center" bgcolor="${a.index%2==0?'pink':''}">
                    <td>${r.rid}</td>
                    <td>${r.rname}</td>
                    <td>${r.db.dname}</td>
                    <td>${r.pbs.size()}</td>
                    <td>
                        <button onclick="roledept(${r.rid})">选择部门</button>
                    </td>
                    <td>
                        <a href="<c:url value='/toRolePower.do?rid=${r.rid}'/>"><button>分配权限</button></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </center>
</body>
<script>
    function roledept(rid) {
        var aa = window.open("<c:url value='/toRoleDept.do?rid='/>"+rid,"","height=300px,width=200px")
        var loop = setInterval(function () {
            if(aa.closed){
                clearInterval(loop);
                location.reload();
            }
        },1);
    }
</script>
</html>
