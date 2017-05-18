<%--
  Created by IntelliJ IDEA.
  User: first
  Date: 2017/05/18
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<from action="${pageContext.request.contextPath}/login" method="post">
    username:<input type="text" name="username"><br>
    password:<input type="password" name="password"><br>
    <input type="submit" value="登陆">
</from>
</body>
</html>
