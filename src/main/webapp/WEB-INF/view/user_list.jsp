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
                <td>用户编号</td>
                <td>用户名称</td>
                <td>用户密码</td>
                <td>生日</td>
                <td>地址</td>
                <td>部门</td>
                <td>角色</td>
                <td colspan="6"></td>
            </tr>
            <c:forEach var="u" items="${list}" varStatus="a">
                <tr align="center" bgcolor="${a.index%2==0?'pink':''}">
                    <td>${u.id}</td>
                    <td>${u.uname}</td>
                    <td>${u.pwd}</td>
                    <td><f:formatDate value="${u.birthday}" pattern="yyyy-MM-dd"/>
                            </td>
                    <td>${u.address}</td>
                    <td>${u.db.dname}</td>
                    <td>${u.rb.rname}</td>
                    <td>
                        <a href="<c:url value='/deleteUserById.do?id=${u.id}'/>"><button>删除</button></a>
                    </td>
                    <td>
                        <a href="<c:url value='/toUpdateUser.do?id=${u.id}'/>"><button>修改</button></a>
                    </td>
                    <c:set var="aa" value=""></c:set>
                    <c:set var="bb" value=""></c:set>
                    <c:forEach var="b" items="${blist}">
                        <c:if test="${b.pname eq '用户查看权限'}">
                            <c:set var="aa" value="<button onclick='ckqx(${u.id})'>${b.pname}</button>"></c:set>
                        </c:if>
                        <c:if test="${b.pname eq '去用户选择角色'}">
                            <c:set var="bb" value="<button onclick='xzjs(${u.id})'>用户选择角色</button>"></c:set>
                        </c:if>
                    </c:forEach>

                    <td>
                        ${aa}
                        ${bb}
                    </td>
                </tr>
            </c:forEach>
        </table>

    </center>
</body>
<script>
    function ckqx(id) {
        window.open("<c:url value='/getUserPowerById.do?id='/>"+id,"","height=200px,width=300px")
    }
    function xzjs(id) {
      //location.href="<c:url value='/toUserRole.do?id='/>"+id;
        var aa = window.open("<c:url value='/toUserRole.do?id='/>"+id,"","height=400px,width=600px");
        var loop = setInterval(function () {
            if(aa.closed){
                clearInterval(loop);
                location.reload();
            }
        },1)
    }
</script>
</html>
