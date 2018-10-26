<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户信息</title>
</head>
<#include "../common/common.ftl" />
<body>
<form id="form" class="form-horizontal" action="javascript:void(0)" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="username" value="${(userInfoList.username)!}" readonly="readonly">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">昵称</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="nickname" value="${(userInfoList.nickname)!}" >
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">电话号码</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="tel" value="${(userInfoList.tel)!}" >
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">地址</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="address" value="${(userInfoList.address)!}" >
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">当前积分</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="points" value="${(userInfoList.points)!}" readonly="readonly">
        </div>
    </div>
</form>
</body>
</html>