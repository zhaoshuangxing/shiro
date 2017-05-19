<%--
  Created by IntelliJ IDEA.
  User: first
  Date: 2017/05/18
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login success</title>
</head>
<body>
<ul>
    <li><a href="/admin">管理中心</a></li>
    <li><a href="/student">学生管理</a></li>
    <li><a href="/teacher">老师中心</a></li>
</ul>
    欢迎你${username},<a href="${pageContext.request.contextPath}/logout">退出</a>
</body>
</html>
