<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 2021/11/23
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/cookie_session/LoginServlet" method="get" name="">
    用户名：<input type="text" name="username" value="${cookie.username.value}"></br>
    密码：<input type="password" name="password" id="passwordid"></br>
    <input type="submit" value="登陆">
</form>
</body>
</html>
