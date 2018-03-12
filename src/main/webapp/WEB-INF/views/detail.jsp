<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/6 0006
  Time: 14:40:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/materialize.min.js"></script>
    <title>详情页</title>
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
                <c:forEach var="item" items="${detail_info.episodeList}">
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
            <form:form cssClass="col s12" action="${pageContext.request.contextPath}/save_bangumi" method="post" modelAttribute="bangumi">
                <div class="row">
                    <div class="input-field col s4">
                        <form:input  id="first_name" path="name" type="text" cssClass="validate"/>
                        <label for="first_name">番名：</label>
                    </div>
                    <div class="input-field col s4">
                        <form:input  id="aid" path="aid" type="text" cssClass="validate" />
                        <label for="aid">aid:</label>
                    </div>
                    <div class="input-field col s4">
                        <form:input path="source_url" id="source_url" type="text" cssClass="validate"/>
                        <label for="source_url">source_url:</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <form:textarea id="video_url" path="url" class="materialize-textarea"/>
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
        <p>${detail_info.title}</p>
        <p>${detail_info.url}</p>
    </div>

</body>
<script>
    $(document).ready(function () {
            var json = $("#json_url").html();
            $("#video_url").html(json);
            var title = "${detail_info.title}";
            $("#first_name").val(title);
            var url ="${detail_info.url}";
            $("#source_url").val(url);

    });
</script>
</html>
