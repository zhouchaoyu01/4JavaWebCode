<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑图书</title>
    <%--    静态包含base标签 css jquery--%>
    <%@ include file="/pages/common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<%--是否是添加操作 无id为add  有为update--%>
<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">编辑图书</span>

    <%@ include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <form action="manager/bookServlet" method="post">
        <%--            在同一页面动态修改隐藏域 value="${param.method}"--%>
        <%--        方案二 value="${empty param.id? "add":"update"}"--%>
        <%--        方案三 value="${empty requstScope.book? "add":"update"}"--%>
        <input type="hidden" name="action" value="${empty param.id? "add":"update"}">
        <input type="hidden" name="id" value="${requestScope.book.id}">
        <input type="hidden" name="pageNo" value="${param.pageNo}">

        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <%--name 要和Javabean 属性名一致--%>
                <td><input name="name" type="text" value="${requestScope.book.name}"/></td>
                <td><input name="price" type="text" value="${requestScope.book.price}"/></td>
                <td><input name="author" type="text" value="${requestScope.book.author}"/></td>
                <td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
                <td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>


</div>

<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>