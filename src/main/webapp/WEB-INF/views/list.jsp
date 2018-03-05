<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/5 0005
  Time: 17:07:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/materialize.min.js"></script>
    <title>展示数据</title>
</head>
<body>
<div class="container">
    <table class="highlight">
        <thead>
        <tr>
            <th>标题</th>
            <th>地址</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${list_my.infoList}">
            <tr>
                <td>${item.title}</td>
                <td>${item.url}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="container center">
        <ul class="pagination">
            <li class="disabled"><a href=""><i class="material-icons">chevron_left</i></a></li>
            <li class="active"><a href="">1</a></li>
            <li class="waves-effect"><a href="">2</a></li>
            <li class="waves-effect"><a href="">3</a></li>
            <li class="waves-effect"><a href="">4</a></li>
            <li class="waves-effect"><a href="">5</a></li>
            <li class="waves-effect"><a href=""><i class="material-icons">chevron_right</i></a></li>
        </ul>
    </div>
</div>

</body>
</html>
