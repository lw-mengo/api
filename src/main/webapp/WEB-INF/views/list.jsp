<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/5 0005
  Time: 17:07:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/materialize.min.css">
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
    </div>

</body>
</html>
