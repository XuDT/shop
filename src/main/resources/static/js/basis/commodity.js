$(function () {
    //选择商品进行修改
    $(".updatebtn").click(function () {
        //获取选中的复选框
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

    //选择商品进行删除
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

//修改商品
function edit(id) {
    var ob = {
        title: "修改商品",
        width: "800",
        height: "550",
        url: "editCommodityView?id="+ id
    };
    popup.open(ob);
}

//新增商品
function add() {
    var ob = {
        title: "新增商品",
        width: "800",
        height: "550",
        url: "editCommodityView?id="+ ""
    };
    popup.open(ob);
}

//根据id删除商品
function deleteById(id) {
    popup.confirm('是否确认删除?', function() {
        $.get("/commodity/deleteById", {id: id}, function(data) {
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

//根据商品名称搜索商品
function findByKeyword() {
    location.href="/commodity/findByKeyword?keyword="+$("#keyword").val();
}

//提交修改
function submitForm() {
    $.ajax({
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/commodity/editCommodity",//url
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

//上传图片
layui.use('upload', function () {
    var upload = layui.upload;
    var uploadInst = upload.render({
        elem: '#uploadBtn', //绑定元素
        url: '/upload/setFileUpload', //上传接口
        multiple: false,
        before: function (obj) {
            //回显
            obj.preview(function(index, file, result){
                $('#previewPicture').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img" height="80" width="80">');
                $('#previewPicture').append('<input name="commodityImg" value="'+ result +'" hidden>');
            });
        }
        , done: function (res) {
            //上传完毕回调
            if (res.code != 200) {
                return layer.msg('上传失败',{time:1000});
            } else {
                return layer.msg('上传成功',{time:1000});
            }
        }
        , error: function () {
            //请求异常回调
        }
    });
});