<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/30 0030
  Time: 15:51:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("/index.jsp");
    }
%>
<html>
<head>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/materialize.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/materialize.min.js"></script>
        <title>番剧列表-当季新番</title>
        <script>
            $(function () {
                $(".waves-effect.waves-light.btn.delete").click(function () {
                    var name = $(this).next(":hidden").val();
                    console.log($(this).attr("href"));
                    console.log($("#_form").attr("method"));
                    var flg = confirm("确定要删除" + name + "?");
                    if (flg) {
                        var url = $(this).attr("href");
                        $("#_form").attr("action", url);
                        $("#_form").submit();
                        Materialize.toast("删除成功！", 1500);

                    }
                    //这个return false 是阻止a标签的默认点击跳转行为
                    Materialize.toast("取消删除！", 1500);
                    return false;
                });
            });
        </script>
    </head>
</head>
<body>
<nav class="top-nav">
    <div class="container">
        <div class="nav-wrapper">
            <a href="#" class="brand-logo">番剧管理</a>
            <ul class="right hide-on-med-and-down">
                <li>欢迎，${sessionScope.user.username}</li>
                <li><a href="${pageContext.request.contextPath}/index.jsp">退出登录</a></li>
                <li><a href="https://www.iikanfan.com" target="_blank">网站首页</a></li>
                <li></li>
            </ul>
        </div>
    </div>
</nav>


<div class="container">
    <!--放一个隐藏的form用来把delete请求发送出去-->
    <form action="" method="post" id="_form">
        <input type="hidden" name="_method" value="DELETE">
    </form>
    <c:if test="${page==null||page.numberOfElements==0}">
        没有数据！${page.numberOfElements}
    </c:if>
    <c:if test="${page!=null&&page.numberOfElements>0}">
        <table class="bordered centered highlight">
            <thead>
            <tr>
                <th>番名</th>
                <th>番号</th>
                <th colspan="2">编辑</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${page.content}">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.aid}</td>
                    <td>
                        <a class="waves-effect waves-light btn delete"
                           href="#">删除</a>
                        <input type="hidden" id="name" value="${item.name}"/>
                    </td>
                    <td><a class="waves-effect waves-light btn" href="${pageContext.request.contextPath}/update_new/${item.aid}">更新</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="8">
                    当前${page.number+1}页,共${page.totalPages}页记录
                    共 ${page.totalElements}条记录
                    <a href="${pageContext.request.contextPath}?pageNo=${page.number+1+1}">下一页</a>
                </td>
            </tr>

            </tbody>
        </table>
    </c:if>
</div>

</body>
</html>