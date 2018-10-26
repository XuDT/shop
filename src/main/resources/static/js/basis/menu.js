$(function () {

    //新增菜单
    $(".addbtn").click(function () {
        var ob = {
            title: "<label>新增菜单</label>",
            width: 800,
            height: 450,
            url: "/menu/editMenu?id=" +  ""
        };
        popup.open(ob);
    });

    //修改菜单
    $(".updatebtn").click(function () {
        var length = $('.cb:checked').length
        if (length < 1) {
            popup.alert('未选中任何项!');
            return false;
        } else if (length > 1) {
            popup.alert("请选择其中一项编辑!");
        } else {
            updataBtn($('.cb:checked').val());
        }
    });

    //选择菜单进行删除
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

//根据id删除菜单
function deleteById(id){
    popup.confirm('是否确认删除?', function() {
        $.get("/menu/deleteById", {id: id}, function(data) {
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

//修改菜单
function updataBtn(id){
    var ob = {
        title: "<label>修改菜单</label>",
        width: 800,
        height: 450,
        url: "/menu/editMenu?id="+id
    };
    popup.open(ob);
}

//根据名称搜索菜单
function searchBtn() {
    location.href="/menu/menuList?keyword="+$("#keyword").val();
}
var check=false;

//检测菜单编码是否存在
$(function () {
    $("#code").change(function () {
        $.ajax({
            url:'/menu/checkCode',
            type:'post',
            datetype:'json',
            data:{"id":$("#id").val(),"code":$("#code").val()},
            success:function (data) {
                if(data.success){
                    check=true;
                    popup.alert("菜单编码已存在,请重新输入!");
                }else{
                    check=false;
                }
            }
        })
    })
});
//保存
function  submintBtn() {
    var name = $("#name").val();
    var code = $("#code").val();
    var level = $("#level").val();
    var pid = $("#pid").val();
    var path = $("#path").val();
    if (name == null || name == "") {
        popup.alert("菜单名称不能为空,请输入菜单名称!");
        return false;
    }
    if (pid !=0 && (code == null || code == "")) {
        popup.alert("菜单编码不能为空,请输入菜单编码!");
        return false;
    }else if(pid == 0 && (code != null && code != "")){
        popup.alert("请选择上级菜单!");
        return false;
    }
    if (pid !=0 && (path == null || path == "")) {
        popup.alert("资源值不能为空,请输入资源值!");
        return false;
    }else if(pid == 0 && (path != null && path != "")){
        popup.alert("请选择上级菜单!");
        return false;
    }
    if (level == null || level == "") {
        popup.alert("排序值不能为空,请输入排序值!");
        return false;
    }
    if(check){
        popup.alert("菜单编码已存在,请重新输入!");
        return false;
    }
    $.ajax({
        url:'/menu/save',
        type:'post',
        dataType:'json',
        data:$("#formId").serialize(),
        success: function (data){
            if(data.success){
                layer.msg("保存成功",{icon:6,time:1000},function () {
                    popup.close();
                    parent.window.location.reload();
                })
            }else{
                popup.msg("保存失败!");
            }
        }
    })
}