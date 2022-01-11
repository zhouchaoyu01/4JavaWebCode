<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%--    静态包含base标签 css jquery--%>
    <%@ include file="/pages/common/head.jsp" %>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%@ include file="/pages/common/loginSuccess.jsp" %>

    <script type="text/javascript">
        $(function () {
            $("a.deleteItemClass").click(function () {
                return confirm("确定删除【" + $(this).parent().parent().find("td:first").text() + "】？");
            })
            $("#clear").click(function () {
                return confirm("确定清空购物车吗？")
            })
            //给输入框绑定失去焦点事件 change
            $("input.updateCount").change(function () {

                let bookId = $(this).attr("bookId");

                let name = $(this).parent().parent().find("td:first").text();
                let count = this.value;
                if (confirm("你确定要将【" + name + "】的数量修改为" + count)) {
                    location.href = "cartServlet?action=updateCount&count=" + count + "&id=" + bookId;
                } else {
                    //defaultValue是表单项Dom对象的属性，是默认值
                    this.value = this.defaultValue;
                }
                // return confirm("你确定要将【" + name + "】的数量修改为" + value)
            })
        })
    </script>
</div>

<div id="main">
    <%--    ${empty sessionScope.cart.items}--%>
    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:if test="${ empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a href="index.jsp">当前购物车为空</a></td>
            </tr>
        </c:if>

        <c:if test="${not empty sessionScope.cart.items}">
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td>
                        <input class="updateCount" style="width: 40px" type="text"
                               bookId="${entry.value.id}"
                               value="${entry.value.count}">
                    </td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice }</td>
                    <td><a class="deleteItemClass" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

    <%--    购物车非空--%>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a id="clear" href="cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>

</div>

<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>