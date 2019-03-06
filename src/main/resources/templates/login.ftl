<html>
<head>
    <meta charset="utf-8">
    <title>卖家后端管理系统</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/res/css/style.css">



    <link rel="stylesheet" href="/res/css/supersized.css">
    <link rel="stylesheet" href="/res/css/login.css">
    <link href="/res/css/bootstrap.min.css" rel="stylesheet">

</head>


<body>

<div class="page-container">
    <div class="main_box">
        <div class="login_box">
            <div class="login_logo">
                <img src="/res/images/logo.png">
            </div>

            <div class="login_form">
                <form action="/res/login" id="login_form" method="post">
                    <div class="form-group">
                        <label class="t">账 号：</label>
                        <input type="text" name="username" class="form-control x319 in"
                               autocomplete="off">
                    </div>
                    <div class="form-group">
                        <label class="t">密　码：</label>
                        <input type="password" name="password"
                               class="password form-control x319 in">
                    </div>


                    <div class="form-group space">
                        <label class="t"></label>　　　
                        <button type="submit" id="submit_btn"
                                class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp
                        </button>
                        <input type="reset" value="&nbsp;重&nbsp;置&nbsp;" class="btn btn-default btn-lg">
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>

<!-- Javascript -->

<div style="text-align:center;">

</div>
</body>
</html>