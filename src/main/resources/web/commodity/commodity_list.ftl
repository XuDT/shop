<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>商品列表</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/basis/commidity.css">

</head>
    <#include "../common/common.ftl" />
<script src="/js/basis/commodity.js"></script>
<body>
<div>
    <div class="ibox-content" style="margin-top: 0%;width: 94%;margin-left: 3%;">
        <div class="btn-div">
            <a class="btn addbtn click-btn" onclick="add();"><i class="fa fa-plus"></i> 新增</a>
            <a class="btn updatebtn click-btn" ><i class="fa fa-plus"></i>修改</a>
            <a class="btn deletebtn click-btn" onclick="deleteById();"><i class="fa fa-plus"></i> 删除</a>
        </div>
        <div class="form-horizontal clearfix">
            <div class="form-group">
                <div class="col-lg-3 col-sm-3 input-group">
                    <input type="text" id="keyword" name="keyword" placeholder="请输入商品名称" value="${(keyword)!}"
                           class="input-sm form-control">
                    <span class="input-group-btn">
                                <button type="button" class="btn btn-sm btn-primary" onclick="findByKeyword();"> 搜索</button>
                        </span>
                </div>
            </div>
        </div>
        <div id="left_dict" style="overflow-y: auto;">
            <table id="example" class="table table-striped table-bordered table-hover dataTables-example dataTable" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th class="tn" width="4%">
                        <input class="all" name="" type="checkbox" hidden>
                    </th>
                    <th class="tn" style="white-space: nowrap;">商品名称</th>
                    <th class="tn" style="white-space: nowrap;">商品规格</th>
                    <th class="tn" style="white-space: nowrap;">温度</th>
                    <th class="tn" style="white-space: nowrap;">价格</th>
                    <th class="tn" style="white-space: nowrap;">商品类型</th>
                    <th class="tn" style="white-space: nowrap;">商品图片</th>
                    <th class="tn" style="white-space: nowrap;">商品描述</th>
                </tr>
                <tbody>
            <#list commodityList as item>
            <tr>
                <td class="tn">
                    <input class="checkId" name="" type="checkbox" value="${(item.id)!}">
                </td>
                <td class="tn">${(item.name)!}</td>
                <td class="tn">${(item.standard)!}</td>
                <td class="tn">${(item.temperature)!}</td>
                <td class="tn">${(item.price)!}</td>
                <td class="tn">${(item.typeName)!}</td>
                <td class="tn">
                    <img src="${(item.commodityImg)!}" height="60" width="60">
                </td>
                <td class="tn">${(item.description)!}</td>
            </tr>
            </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>