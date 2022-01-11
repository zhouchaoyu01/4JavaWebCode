<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 2021/12/8
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>a.jsp</title>
</head>
<body>

<%

    System.out.println("a.jsp执行");
    Object user = session.getAttribute("user");
    if(user == null){
        request.getRequestDispatcher("/login.jsp").forward(request, response);
        return;
    }

%>
a.jsp

</body>
</html>
