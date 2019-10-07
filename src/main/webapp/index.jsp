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
    ${msg}
    <form action="<c:url value='/getLogin.do'/>" method="post">
        用户名:<input type="text" name="uname"/>
        密码:<input type="password" name="pwd"/>
        <input type="submit" value="登录"/>
    </form>
</center>
</body>

</html>
