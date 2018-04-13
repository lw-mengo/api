<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/11 0011
  Time: 10:38:21
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
    <div class="row">
        <form:form cssClass="col s12" action="${pageContext.request.contextPath}/update_new_bangumi" method="post" modelAttribute="bangumi">
            <div class="row">
                <div class="input-field col s4">
                    <form:input disabled="true" id="first_name" path="name" type="text" cssClass="validate"/>
                    <label for="first_name">番名：</label>
                </div>
                <div class="input-field col s4">
                    <form:input disabled="true" id="aid" path="aid" type="text" cssClass="validate"  />
                    <label for="aid">aid:</label>
                </div>
                <div class="input-field col s4">
                    <form:input disabled="true" path="source_url" id="source_url" type="text" cssClass="validate"/>
                    <label for="source_url">source_url:</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <form:textarea id="video_url" path="video_url" class="materialize-textarea"/>
                    <label for="video_url">视频链接的json：</label>
                </div>
            </div>
            <c:if test="${bangumi.aid!=null}">
                <form:hidden path="aid"/>
                <input type="hidden" name="_method" value="PUT" />
            </c:if>
            <button class="btn waves-effect waves-light right" type="submit">提交
                <i class="material-icons right">send</i>
            </button>
        </form:form>
    </div>
</div>
<div class="container">
    <p id="mm">${json_url}</p>
    <p>数据库中的集数：${bangumi.video_url}</p>
    <p>数据源中的集数：${newNum}</p>

</div>

</body>
<script>
    $(document).ready(function () {
        var json = $("#mm").html();
        $("#video_url").html(json);

        $("#first_name").val("${bangumi.name}");
        $("#aid").val("${bangumi.aid}");
        $("#source_url").val("${bangumi.source_url}");

    });
</script>
</html>