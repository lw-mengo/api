<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/materialize.min.js"></script>
    <link rel="stylesheet" href="css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <title>登录</title>
</head>
<body>

<nav>
    <div class="container">
        <div class="nav-wrapper">
            <a href="#" class="brand-logo">Logo</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="http://47.75.55.158/" target="_blank">首页</a></li>
                <li><a href="http://bangumi.tv/" target="_blank">Bangumi</a></li>
                <li class="active"><a href="#">后台登录</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <form class="col s6" style="margin-top: 100px" action="${pageContext.request.contextPath}/login" method="post">
        <div class="row">
            <div class="input-field col s6 " style="margin-left: 250px">
                <input class="validate" type="text" name="user_name" id="name">
                <label for="name">用户名:</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s6 " style="margin-left: 250px">
                <input class="validate" type="password" name="user_password" id="pwd">
                <label for="pwd">密码:</label>
            </div>
        </div>
        <button class="btn waves-effect waves-light" style="margin-left: 760px" type="submit">登录
            <i class="material-icons right">send</i>
        </button>
    </form>
</div>

</body>
<script>
    $(document).ready(function () {
        $("button").click(function () {
            var name = $("#name").val();
            var password = $("#pwd").val();
            if (name==null||name==""){
                Materialize.toast('用户名不能为空！',1200);
            }else if(password==null||password==""){
                Materialize.toast('密码不能为空!',1200);
            }else{
                return true;
            }
            return false;
        });
    });
</script>
</html>
