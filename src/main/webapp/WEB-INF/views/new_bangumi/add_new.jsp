<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/30 0030
  Time: 10:51:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    if (session.getAttribute("user") == null) {
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
    <title>添加新番</title>
</head>
<body>
<div class="container">
    <table>
        <thead>
        <tr>
            <th>剧集</th>
            <th>视频链接</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${detail.episodeList}">
            <tr>
                <td>${item.episode}</td>
                <td>${item.videoLink}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="container">
    <div class="row">
        <form:form cssClass="col s12" action="${pageContext.request.contextPath}/save_new_bangumi" method="post"
                   modelAttribute="bangumi">
            <div class="row">
                <div class="input-field col s4">
                    <form:input id="first_name" path="name" type="text" cssClass="validate"/>
                    <label for="first_name">番名：</label>
                </div>
                <div class="input-field col s4">
                    <form:input id="aid" path="aid" type="text" cssClass="validate"/>
                    <label for="aid">aid:</label>
                </div>
                <div class="input-field col s4">
                    <form:input path="source_url" id="source_url" type="text" cssClass="validate"/>
                    <label for="source_url">source_url:</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s6">
                    <form:radiobutton path="is_new" id="is_new" value="true" checked="checked"/>
                    <label for="is_new">新番标记</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s6">
                    <form:radiobutton path="weekend" value="1" id="test1"/>
                    <label for="test1">星期一</label>
                    <form:radiobutton path="weekend" value="2" id="test2"/>
                    <label for="test2">星期二</label>
                    <form:radiobutton path="weekend" value="3" id="test3"/>
                    <label for="test3">星期三</label>
                    <form:radiobutton path="weekend" value="4" id="test4"/>
                    <label for="test4">星期四</label>
                    <form:radiobutton path="weekend" value="5" id="test5"/>
                    <label for="test5">星期五</label>
                    <form:radiobutton path="weekend" value="6" id="test6"/>
                    <label for="test6">星期六</label>
                    <form:radiobutton path="weekend" value="7" id="test7"/>
                    <label for="test7">星期日</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <form:textarea id="video_url" path="video_url" class="materialize-textarea"/>
                    <label for="video_url">视频链接的json：</label>
                </div>
            </div>
            <button class="btn waves-effect waves-light right" type="submit">提交
                <i class="material-icons right">send</i>
            </button>
        </form:form>
    </div>
</div>
<div class="container">
    <p id="json_url">${json_url}</p>
    <p>${detail.title}</p>
    <p>${detail.url}</p>
</div>

</body>
<script>
    $(document).ready(function () {
        var json = $("#json_url").html();
        $("#video_url").html(json);
        var title = "${detail.title}";
        $("#first_name").val(title);
        var url = "${detail.url}";
        $("#source_url").val(url);

    });
</script>
</body>
</html>
