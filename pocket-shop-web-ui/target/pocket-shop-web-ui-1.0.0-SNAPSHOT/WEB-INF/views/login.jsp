<%--
  Created by IntelliJ IDEA.
  User: chenjiaxing
  Date: 2019/6/1
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>口袋商城——登录</title>
    <link rel="stylesheet" type="text/css" href="/static/css/index.css">
    <link rel="stylesheet" type="text/css" href="/static/css/ziy.css">
    <script type="text/javascript" src="/static/js/jquery-1.4.4.min.js"></script>
</head>
<body>
<!--dengl-->
<div class="beij_center">
    <div class="dengl_logo">
        <img src="/static/images/logo.png">
    </div>
</div>

<div class="dengl_beij">

    <div class="banner_xin">
        <img src="/static/images/ss.jpg">
    </div>
    <div class="beij_center dengl_jvz">
        <div class="login_form">
            <div class="login_tab">
                <h2>欢迎登录</h2>
                <div class="dengl_erwm">
                    <a href="#"><img src="/static/images/er_wm.png"></a>
                    <div class="tanc_erwm_kuang">
                        <img src="/static/images/mb_wangid.png">
                        <div class="qrcode_panel">
                            <ul>
                                <li class="fore1">
                                    <span>打开</span>
                                    <a href="#" target="_blank"> <span class="red">手机MyShop</span></a>
                                </li>
                                <li>扫描二维码</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <form action="/login" method="post">
            <div class="kengl_kuang">
                <c:if test="${BaseResult.status == 500}"></c:if>
                <div class="red">${BaseResult.message}</div>
                <div class="txt_kuang">
                    <input type="text" class="itxt" name="email" placeholder="邮箱">
                    <input type="password" class="itxt" name="password" placeholder="密码">
                    <div>
                        <input type="text" class="itxt" name="verification" placeholder="验证码" style="width: 109px;height: 45px">
                        <img src="/verification"  id="verification" style="float: right;padding-right: 31px;cursor: pointer;" title="看不清？换一张">
                    </div>
                </div>
                <div class="remember">
                    <div class="fl">
                        <input type="checkbox" >
                        <label>自动登录</label>
                    </div>
                    <div class="fr">
                        <a href="#" class="fl" target="_blank" title="忘记密码">忘记密码?</a>
                    </div>
                </div>
                <input type="submit" tabindex="5" value="登 录" class="btnnuw">
            </div>
            </form>
            <div class="corp_login">
                <div class="mingb_shoq"><a href="#">名榜授权登录！</a></div>
                <div class="regist_link"><a href="zhuc.html" target="_blank"><b></b>立即注册</a></div>
            </div>
        </div>
    </div>
</div>

<div class="jianj_dib">
    <div class="beia_hao">
        <p>京ICP备：123456789号  </p>
        <p class="gonga_bei">京公网安备：123456789号</p>
    </div>
</div>
<script>
    $(function () {
        // 刷新验证码
        $("#verification").bind("click", function () {
            $(this).hide().attr('src', '/verification?random=' + Math.random()).fadeIn();
        });
    });
</script>
</body>
</html>
