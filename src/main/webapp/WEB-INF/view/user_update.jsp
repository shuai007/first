<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/14
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <script type="text/javascript" src="<c:url value='/js/jquery-1.8.2.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/calendarTime.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery.validate.js'/>"></script>
</head>
<body>
    <center>
        <form id="updateuser" action="<c:url value='/updateUser.do'/>" method="post">
            <input type="hidden" name="id" value="${ub.id}"/>
            用户名:<input type="text" id="uname" name="uname" value="${ub.uname}"/><br>
            密码：<input name="pwd" id="pwd" type="text" value="${ub.pwd}"/><br>
            确认密码:<input type="text" id="pwd2" name="pwd2" value="${ub.pwd}"/><br>
            生日:<input type="text" name="birthday" value="<f:formatDate value='${ub.birthday}' pattern='yyyy-MM-dd'/>" readonly onclick="setDay(this)"/><br>
            地址：<input type="text" name="address" value="${ub.address}"/><br>
            <input type="submit" value="修改"/>
        </form>
    </center>
</body>
<script>
    $().ready(function(){
        $("#updateuser").validate({
            rules: {
                uname: {
                    required: true,
                    minlength:2,
                    maxlength:12
                },
                pwd: {
                    required: true,
                    minlength:3,
                    maxlength:16
                },
                pwd2: {
                    equalTo: "#pwd"
                }
            },
            messages: {
                uname: {
                    required: "用户名必须输入",
                    minlength: "用户名称最少2位",
                    maxlength:"用户名最多12位"
                },
                pwd: {
                    required: "密码必须输入",
                    minlength: "密码最少3位",
                    maxlength:"密码最多16位"
                },
                pwd2: {
                    equalTo: "两次密码不一致"
                }
            }
        });

    });
</script>
</html>
