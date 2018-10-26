<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>我的购物车</title>
    </head>
<#include "../common/common.ftl" />
<body>
<div>
    <div class="ibox-content" style="margin-top: 10px;width: 94%;margin-left: 3%;">
        <div id="left_dict" style="overflow-y: auto;">
<table id="example" class="table table-striped table-bordered table-hover dataTables-example dataTable" cellspacing="0" width="100%">
    <tr>
        <th class="tn" width="4%"><input class="all" name="" type="checkbox" hidden></th>
        <th class="tn">商品名称</th>
        <th class="tn">商品价格</th>
        <th class="tn">下单时间</th>
    </tr>
    <tbody>
            <#list userCarList as userCarList>
            <tr>
                <td class="tn"><input class="checkId" name="checkId" type="checkbox" value="${(userCarList.id)!}"></td>
                <td class="tn">${(userCarList.commodityName)!}</td>
                <td class="tn">￥${(userCarList.commodityPrice)!}</td>
                <td class="tn">${(userCarList.orderTime)!}</td>
            </tr>
            </#list>
            <tr>
                <button type="button" class="btn btn-sm btn-warning oneupdate-btn paybtn" style="margin-left: 5px;margin-bottom: 5px;margin-top: 5px;" >付款</button>
                <button type="button" class="btn btn-sm btn-danger del-btn deletebtn" style="margin-bottom: 5px;margin-top: 5px;margin-left: 5px;">删除</button>
            </tr>
    </tbody>
</table>
        </div>
    </div>
</div>
</body>
<script>
    //付款
    function pay(id) {
        popup.confirm('是否确认付款?', function() {
            $.get("/order/pay", {id: id}, function(data) {
                if (data.success) {
                    layer.msg("付款成功!", {icon:6,time:1000});
                    window.location.reload();
                } else {
                    popup.alert('付款失败!');
                }
            });
        })
    }

    //根据id删除订单
    function deleteById(id) {
        popup.confirm('是否确认删除?', function() {
            $.get("/order/deleteById", {id: id}, function(data) {
                if (data.success) {
                    layer.msg("删除成功!", {icon:6,time:1000});
                    window.location.reload();
                } else {
                    popup.alert('删除失败!');
                }
            });
        })
    }

    $(function () {
        //选择商品进行付款
        $(".paybtn").click(function () {
            var length = $('.checkId:checked').length;
            if (length < 1) {
                popup.alert('未选中任何项!');
                return false;
            } else if (length > 1) {
                popup.alert("请选择其中一项编辑!");
            } else {
                pay($('.checkId:checked').val());
            }
        });

        //选择商品进行删除
        $(".deletebtn").click(function () {
            var length = $('.checkId:checked').length;
            if (length < 1) {
                popup.alert('未选中任何项!');
                return false;
            } else if (length > 1) {
                popup.alert("请选择其中一项付款!");
            } else {
                deleteById($('.checkId:checked').val());
            }
        });
    });
</script>
</html>