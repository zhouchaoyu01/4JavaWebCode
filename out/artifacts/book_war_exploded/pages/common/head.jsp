<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath =
            request.getScheme()
                    + "://"
                    + request.getServerName()
                    + ":"
                    + request.getServerPort()
                    + request.getContextPath()
                    + "/";

//    pageContext.setAttribute("basePath", basePath);
%>

<%--<%=basePath %>--%>
<%--<br>--%>
<%--<%=request.getContextPath()%>--%>

<base href="<%=basePath%>">
<!-- 工程路径 base改后其他路径要注意-->


<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script type="text/javascript" src="static/scripts/jquery-1.7.2.js"></script>