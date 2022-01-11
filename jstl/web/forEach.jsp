<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 2021/11/13
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table {
            width: 500px;
            border: 1px solid aquamarine;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid aquamarine;
        }

    </style>
</head>
<body>


<%--1.遍历 1 到 10，
输出 begin 属性设置开始的索引
end 属性设置结束的索引
var 属性表示循环的变量(也是当前正在遍历到的数据)
for (int i = 1; i < 10; i++) --%>

<table border="1">
    <c:forEach begin="1" end="10" var="i">
        <tr>
            <td>第${i}行</td>
        </tr>
    </c:forEach>
</table>
<hr>


<%-- 2.遍历 Object 数组
 for (Object item: arr)
 items 表示遍历的数据源（遍历的集合）
  var 表示当前遍历到的数据 --%>
<% request.setAttribute("arr", new String[]{"18610541354", "18688886666", "18699998888"}); %>
<c:forEach items="${ requestScope.arr }" var="item">
    ${ item } <br>
</c:forEach>
<hr>

<%--    3. 遍历 Map 集合--%>
<%
    Map<String, Object> map = new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");

    //    for(Map.Entry<String, Object> entry:map.entrySet()){
    //
    //    }
    request.setAttribute("map", map);
%>

<c:forEach items="${requestScope.map}" var="entry">
    <%--        <h>${entry.key}</h>--%>
    <%--        <h>${entry.value}</h>--%>
    <h1>${entry.key} = ${entry.value}</h1>

</c:forEach>
<%--4. 遍历 List 集合---list 中存放 Student 类，有属性：编号，用户名，密码，年龄， 电话信息--%>
<%
    List<Student> studentList = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
        studentList.add(new Student("id" + i, "username" + i, "password" + i, "phone" + i, 18 + i));
    }
    request.setAttribute("stus", studentList);
%>

<hr>


<table>
    <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>电话</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>
    <c:forEach begin="1" end="8"  step="2" items="${requestScope.stus}" var="stu">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.username}</td>
            <td>${stu.password}</td>
            <td>${stu.phone}</td>
            <td>${stu.age}</td>
            <td>删除 修改</td>
        </tr>


    </c:forEach>

</table>


</body>
</html>
