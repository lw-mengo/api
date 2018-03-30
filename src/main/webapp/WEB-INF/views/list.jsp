<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/5 0005
  Time: 17:07:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    if (session.getAttribute("user")==null){
        response.sendRedirect("/index.jsp");
    }
%>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/materialize.min.js"></script>
    <title>展示数据</title>
</head>
<nav class="top-nav">
    <div class="container">
        <div class="nav-wrapper">
            <a href="#" class="brand-logo">数据采集</a>
        </div>
    </div>
</nav>
<body>
<div class="container">
    <table class="highlight">
        <thead>
        <tr>
            <th>标题</th>
            <th>地址</th>
            <th colspan="2" class="center">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${list_my.infoList}">
            <tr>
                <td>${item.title}</td>
                <td>${item.url}</td>
                <td><a class="waves-effect waves-light btn" href="/detail?s=${item.url}">添加旧番</a></td>
                <td><a class="waves-effect waves-light btn" href="/add_new?s=${item.url}">添加新番</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="container center">
        <ul class="pagination">
            <li class="disabled"><a href="/list?pageNo=${x-1}"><i class="material-icons">chevron_left</i></a></li>
            <li class="active"><a href="/list?pageNo=1">1</a></li>
            <c:forEach var="x" begin="2" end="9" step="1">
                <li class="waves-effect"><a href="/list?pageNo=${x}">${x}</a></li>
            </c:forEach>
            <li class="waves-effect"><a href="/list?pageNo=${x+1}"><i class="material-icons">chevron_right</i></a></li>
        </ul>
    </div>
</div>

</body>
</html>
