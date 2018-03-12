<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/2 0002
  Time: 16:36:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/materialize.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>管理后台</title>
</head>
<body>
<header>
    <nav class="top-nav">
        <div class="container">
            <div class="nav-wrapper">
                <a href="#" class="brand-logo">后台管理</a>
                <ul class="right hide-on-med-and-down">
                    <li>欢迎，${sessionScope.user.username}</li>
                    <li><a href="#">修改密码</a></li>
                    <li><a href="${pageContext.request.contextPath}/index.jsp">退出登录</a></li>
                    <li><a href="http://47.75.55.158/" target="_blank">网站首页</a></li>
                    <li></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container"><a href="#" data-activates="nav-mobile"
                              class="button-collapse top-nav waves-effect waves-light"><i
            class="material-icons">menu</i></a></div>
    <ul id="nav-mobile" class="side-nav fixed">
        <li class="bold"><a class="waves-effect waves-teal" href="${pageContext.request.contextPath}/list" target="_blank">酷播列表</a></li>
        <li class="no-padding">
            <ul class="collapsible">
                <li class="bold"><a class="collapsible-header waves-effect waves-teal"><i class="material-icons">arrow_drop_down</i>番剧管理</a>
                    <div class="collapsible-body">
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/bangumi/list" target="_blank">当季新番</a></li>
                            <li><a href="">国产番剧</a></li>
                            <li><a href="">陈旧番剧</a></li>
                            <li><a href="">动画电影</a></li>
                            <li><a href="">添加番剧</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </li>
        <li><a href="">来源管理</a></li>
    </ul>
</header>
<main>
    <div class="container">

    </div>
</main>
</body>
</html>
