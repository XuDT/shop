$(function () {
    //选择订单进行修改
    $(".updatebtn").click(function () {
        var length = $('.checkId:checked').length;
        if (length < 1) {
            popup.alert('未选中任何项!');
            return false;
        } else if (length > 1) {
            popup.alert("请选择其中一项编辑!");
        } else {
            edit($('.checkId:checked').val());
        }
    });

    //选择订单进行删除
    $(".deletebtn").click(function () {
        var length = $('.checkId:checked').length;
        if (length < 1) {
            popup.alert('未选中任何项!');
            return false;
        } else if (length > 1) {
            popup.alert("请选择其中一项编辑!");
        } else {
            deleteById($('.checkId:checked').val());
        }
    });
});

//修改订单
function edit(id) {
    var ob = {
        title: "修改订单",
        width: "800",
        height: "550",
        url: "findById?id="+id
    };
    popup.open(ob);
}

//根据id删除订单
function deleteById(id) {
    popup.confirm('是否确认删除?', function() {
        $.get("/order/deleteById", {id: id}, function(data) {
            if (data.success) {
                layer.msg("删除成功!",
                    {icon:6,time:1000},
                    function(){
                        window.location.reload();
                    })
            } else {
                popup.alert('删除失败!');
            }
        });
    })
}

//根据订单号搜索订单
function searchBtn() {
    location.href="/order/searchOrder?keyword="+$("#keyword").val();
}

//提交修改
function submitForm() {
    $.ajax({
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/order/editOrder",//url
        data: $('#form').serialize(),
        success: function (data) {
            if (data.success) {
                layer.msg("提交成功!",
                    {icon:6,time:1000},
                    function(){
                        parent.window.location.reload();
                    })
            }
        },
        error: function () {
            popup.alert("提交失败！");
        }
    });
}