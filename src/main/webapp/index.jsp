<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/materialize.min.js"></script>
    <link rel="stylesheet" href="css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <title>Welcome</title>
</head>
<body>

    <nav>
        <div class="container">
            <div class="nav-wrapper">
                <a href="#" class="brand-logo">Logo</a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="#">首页</a></li>
                    <li><a href="#">参考</a></li>
                    <li class="active"><a href="#">帮助</a></li>
                </ul>
            </div>
    </div>
    </nav>

            <div class="container">
                <form class="col s12" action="${pageContext.request.contextPath}/login" method="post">
                    <div class="row">
                        <div class="input-field col s12">
                            <input  class="validate" type="text" name="user_name" id="name">
                            <label for="name" >用户名:</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input  class="validate" type="password" name="user_password" id="pwd">
                            <label for="pwd" >密码:</label>
                        </div>
                    </div>
                    <button class="btn waves-effect waves-light right" type="submit">登录
                        <i class="material-icons right">send</i>
                    </button>
                </form>
            </div>

</body>
</html>
