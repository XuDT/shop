//根据id删除订单
function deleteById() {
    var id = $("input[name='checkId']:checked").val();
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