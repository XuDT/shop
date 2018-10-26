<!DOCTYPE html>
<html lang="en">
<head>
    <title>修改商品</title>
</head>
<#include "../common/common.ftl" />
<script src="/js/basis/commodity.js"></script>
<body>
<form id="form" class="form-horizontal" action="##" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${(commodityList.id)!}" size=85 />
    <div class="form-group">
        <label class="col-sm-2 control-label">商品名称</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="name" value="${(commodityList.name)!}" >
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">商品规格</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="standard" value="${(commodityList.standard)!}" >
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">温度</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="temperature" value="${(commodityList.temperature)!}" >
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">价格</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="price" value="${(commodityList.price)!}" >
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">商品图片</label>
        <div class="form-group">
        <div class="col-sm-2">
            <#if (commodityList.commodityImg)?? >
                <img src="${(commodityList.commodityImg)!}" style="width:80px;height:80px;margin-bottom: 5px">
            <#else >
            <button type="button" class="btn btn-default" id="uploadBtn">
                <i class="fa fa-plus"></i>上传图片
            </button>
            </#if>
        </div>
            <div id="previewPicture" />
        </div>

    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">商品描述</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="description" value="${(commodityList.description)!}" >
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">商品类型</label>
        <div class="col-sm-4">
            <select id="type" name="type" class="form-control">
                <option value="0">------请选择商品类型------</option>
                <#if typeList?exists>
                    <#if typeList??>
                    <#list typeList as typeList>
                    <#if commodityList?exists>
                        <#if commodityList.type == typeList.id>
                        <option value="${(typeList.id)!}" selected>${(typeList.name)!}</option>
                        <#else >
                        <option value="${(typeList.id)!}">${(typeList.name)!}</option>
                        </#if>
                    <#else >
                    <option value="${(typeList.id)!}">${(typeList.name)!}</option>
                    </#if>
                    </#list>
                    </#if>
                </#if>
            </select>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input onclick="submitForm();" class="btn btn-default" value="提交">
        </div>
    </div>
</form>
</body>
</html>