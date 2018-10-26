<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>订单列表</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
    <#include "../common/common.ftl" />
<link rel="stylesheet" href="/css/basis/commidity.css">
<script src="/js/basis/order.js"></script>
<body>
<div>
    <div class="ibox-content" style="margin-top: 0%;width: 94%;margin-left: 3%;">
        <div class="btn-div">
            <a class="btn updatebtn click-btn" ><i class="fa fa-plus"></i>修改</a>
            <a class="btn deletebtn click-btn" ><i class="fa fa-plus"></i> 删除</a>
        </div>
        <div class="form-horizontal clearfix">
            <div class="form-group">
                <div class="col-lg-3 col-sm-3 input-group">
                    <input type="text" id="keyword" name="keyword" placeholder="请输入订单号" value="${(keyword)!}"
                           class="input-sm form-control">
                    <span class="input-group-btn">
                                <button type="button" class="btn btn-sm btn-primary" onclick="searchBtn();"> 搜索</button>
                        </span>
                </div>
            </div>
        </div>
        <div id="left_dict" style="overflow-y: auto;">
            <table id="example" class="table table-striped table-bordered table-hover dataTables-example dataTable" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th class="tn" width="4%"><input class="all" name="" type="checkbox" hidden></th>
                    <th class="tn">订单号</th>
                    <th class="tn">商品id</th>
                    <th class="tn">商品名称</th>
                    <th class="tn">商品类型</th>
                    <th class="tn">商品价格</th>
                    <th class="tn">订单状态</th>
                    <th class="tn">下单用户</th>
                    <th class="tn">下单时间</th>
                </tr>
                <tbody>
            <#list orderList as item>
            <tr>
                <td class="tn"><input class="checkId" name="checkId" type="checkbox" value="${(item.id)!}"></td>
                <td class="tn">${(item.orderId)!}</td>
                <td class="tn">${(item.commodityId)!}</td>
                <td class="tn">${(item.commodityName)!}</td>
                <td class="tn">${(item.name)!}</td>
                <td class="tn">${(item.commodityPrice)!}</td>
                <td class="tn">
                <#if item?exists>
                    <#if item.status==0>已新建</#if>
                    <#if item.status==1>已付款</#if>
                </#if>
                </td>
                <td class="tn">${(item.orderUser)!}</td>
                <td class="tn">${(item.orderTime?datetime)!} </td>
            </tr>
            </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>