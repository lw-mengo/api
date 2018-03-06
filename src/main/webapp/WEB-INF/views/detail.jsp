<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/6 0006
  Time: 14:40:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/materialize.min.js"></script>
    <title>详情页</title>
</head>
<body>
    <div class="container">
        <table>
            <thead>
            <tr>
                <th>剧集</th>
                <th>视频链接</th>
                <th rowspan="2" class="center">操作</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${detail_info.episodeList}">
                <tr>
                    <td>${item.episode}</td>
                    <td>${item.videoLink}</td>
                    <td><a class="waves-effect waves-light btn">添加</a></td>
                    <td><a class="waves-effect waves-light btn">刪除</a></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
