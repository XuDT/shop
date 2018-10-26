<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>商品详情</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/basis/commidity.css">
</head>
    <#include "../common/common.ftl" />
<script src="/js/basis/commodity.js"></script>
<body>
<div>
    <div class="ibox-content" style="margin-top: 10px;width: 94%;margin-left: 3%;">
        <div id="left_dict" style="overflow-y: auto;">
            <table id="example" class="table table-striped table-bordered table-hover dataTables-example dataTable" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th class="tn" style="white-space: nowrap;">商品名称</th>
                    <th class="tn" style="white-space: nowrap;">商品规格</th>
                    <th class="tn" style="white-space: nowrap;">温度</th>
                    <th class="tn" style="white-space: nowrap;">价格</th>
                    <th class="tn" style="white-space: nowrap;">商品类型</th>
                    <th class="tn" style="white-space: nowrap;">商品图片</th>
                    <th class="tn" style="white-space: nowrap;">商品描述</th>
                </tr>
                <tbody>
            <tr>
                <td class="tn" style="white-space: nowrap;">${(commodityList.name)!}</td>
                <td class="tn">${(commodityList.standard)!}</td>
                <td class="tn">${(commodityList.temperature)!}</td>
                <td class="tn">￥${(commodityList.price)!}</td>
                <td class="tn">${(commodityList.typeName)!}</td>
                <td class="tn">
                    <img src="${(commodityList.commodityImg)!}" height="60" width="60">
                </td>
                <td class="tn">${(commodityList.description)!}</td>
            </tr>
                </tbody>
            </table>
        </div>
    </div>
    <a class="btn addbtn click-btn" onclick="add(${(commodityList.id)!},'${(userInfo.username)!}',${(userInfo.id)!})" style="float: right;margin-right: 25px;margin-top: 0px;">
    <i class="fa fa-plus"></i> 确认
    </a>
</div>
</body>
<script>
    function add(id,orderUser,userId) {
        popup.confirm('是否确认加入购物车?', function() {
            $.get("/order/insertOrder", {id: id,orderUser: orderUser,userId: userId}, function(data) {
                if (data.success) {
                    layer.msg("添加成功!", {icon:6,time:1000});
                    parent.window.location.reload();
                } else {
                    popup.alert('添加失败!');
                }
            });
        })
    }
</script>
</html>