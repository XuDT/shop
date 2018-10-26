<!DOCTYPE html>
<html lang="en">
<head>
    <title>管理员登录</title>
</head>
<#include "common/common.ftl" />
<script src="/js/basis/login.js"></script>
<link rel="stylesheet" href="/css/basis/login.css">
<body style="background:#fff url(../img/login.jpg) 50% 0 no-repeat;">
<h1>管理员登录</h1>
<div class="login" style="margin-top:50px;">
    <div class="header">
        <div class="switch" id="switch">
            <a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">快速登录</a>
            <div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
        </div>
    </div>
    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">
        <div class="web_login" id="web_login">
            <div class="login-box">
                <div class="login_form">
                    <form action="javascript:void(0)" name="loginform" accept-charset="utf-8" id="form" class="loginForm" method="post">
                        <input name="did" value="0" type="hidden">
                        <input name="to" value="log" type="hidden">
                        <div class="uinArea" id="uinArea">
                            <label class="input-tips" for="u">帐号：</label>
                            <div class="inputOuter" id="uArea">
                                <input id="u" name="username" class="inputstyle username" type="text">
                            </div>
                        </div>
                        <div class="pwdArea" id="pwdArea">
                            <label class="input-tips" for="p">密码：</label>
                            <div class="inputOuter" id="pArea">
                                <input id="p" name="password" class="inputstyle password" type="password">
                            </div>
                        </div>
                        <div style="padding-left:50px;margin-top:20px;"><input value="登 录" type="submit" style="width:150px;" class="button_blue" onclick="adminLogin();"></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>