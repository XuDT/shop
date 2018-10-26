<!DOCTYPE html>
<html lang="en">
<head>
    <title>修改订单</title>
</head>
<#include "../common/common.ftl" />
<script src="/js/basis/order.js"></script>
<script src="/layui/lay/modules/laydate.js"></script>
<body>
<form id="form" class="form-horizontal" action="##" method="post" enctype="multipart/form-data">
    <input  type="hidden" name="id" value="${(orderList.id)!}" size=85/>
    <div class="form-group">
        <label class="col-sm-2 control-label">订单号</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="orderId" value="${(orderList.orderId)!}" readonly="readonly">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">商品id</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="commodityId" value="${(orderList.commodityId)!}" readonly="readonly">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">商品名称</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="commodityName" value="${(orderList.commodityName)!}" >
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">商品类型</label>
        <div class="col-sm-4">
            <select id="commodityType" name="commodityType" class="form-control">
                <option value="0">------请选择商品类型------</option>
                <#if typeList?exists>
                    <#if typeList??>
                        <#list typeList as typeList>
                            <#if orderList?exists>
                                <#if orderList.commodityType == typeList.id>
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
        <label class="col-sm-2 control-label">商品价格</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="commodityPrice" value="${(orderList.commodityPrice)!}" >
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">订单状态</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="status" value="${(orderList.status)!}" >
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">下单用户</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="orderUser" value="${(orderList.orderUser)!}" readonly="readonly">
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">下单时间</label>
        <div class="layui-inline" style="margin-left: 15px;">
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="orderTime" name="orderTime" placeholder="yyyy-MM-dd HH:mm:ss" value="${(orderList.orderTime?datetime)!}" readonly="readonly">
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input onclick="submitForm();" class="btn btn-default" value="提交">
        </div>
    </div>

</form>
</body>
<script type="text/javascript">
    //选择时间
/*    layui.use('laydate', function() {
        var laydate = layui.laydate;
        laydate.render({
            elem: '#orderTime',
            type: 'datetime'
        });
    })*/
</script>
</html>