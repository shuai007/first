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
    <script type="text/javascript" src="<c:url value='/js/jquery-1.8.2.js'/>"></script>
</head>
<body>
    <center>
            <form action="<c:url value='/updateUserRole.do'/>" method="post">
            <input type="hidden" name="id" value="${ub.id}"/>
            <select name="deptid" onchange="changedept(this)" style="height: 50px;width: 150px;font-size: 20px;color: #0000FF">
                <option value="-1">--请选择部门--</option>
                <c:forEach var="d" items="${list}">
                    <option value="${d.deptid}" ${d.deptid==ub.db.deptid?'selected':''}>${d.dname}</option>
                </c:forEach>
            </select><br><br><br>

            <select name="rid" style="height: 50px;width: 150px;font-size: 20px;color:orangered">
                <option value="-1">--请选择角色--</option>
                <c:forEach var="r" items="${rlist}">
                    <option value="${r.rid}" ${ub.rb.rid==r.rid?'selected':''}>${r.rname}</option>
                </c:forEach>
            </select><br><br><br>
                <input type="button" value="保存" onclick="saveuserrole()"/>
            </form>
    </center>
</body>
<script>
    function changedept(obj) {
        $.post(
            "<c:url value='/getRoleListByDeptid.do?m='/>"+Math.random(),
            {deptid:obj.value},
            function (data) {
                var arr = eval(data);
                document.getElementsByName("rid")[0].length=1;
                var r =$("[name=rid]");
                for (var i = 0; i <arr.length ; i++) {
                    r.append("<option value='"+arr[i].rid+"'>"+arr[i].rname+"</option>")
                }
            }
        );
    }
    function saveuserrole() {
        document.forms[0].submit();
        window.close();
    }
</script>
</html>
