var didScroll;
var lastScrollTop = 0;
var delta = 5;
var navbarHeight = $('header').outerHeight();

$(window).scroll(function(event){
    didScroll = true;
});

setInterval(function() {
    if (didScroll) {
        hasScrolled();
        didScroll = false;
    }
}, 250);

function hasScrolled() {
    var st = $(this).scrollTop();

    if(Math.abs(lastScrollTop - st) <= delta)
        return;
    if (st > lastScrollTop && st > navbarHeight){
        $('header').removeClass('nav-down').addClass('nav-up');
    } else {
        if(st + $(window).height() < $(document).height()) {
            $('header').removeClass('nav-up').addClass('nav-down');
        }
    }
    lastScrollTop = st;
}

//加入购物车
function addToCart(id,userId) {
    var ob = {
        title: "加入购物车",
        width: "800",
        height: "250",
        url: "commodity/detailById?id="+id
    };
    if(userId == null){
        popup.confirm("请先登录！");
    }else {
        popup.open(ob);
    }

}

//个人资料
function getUser(id) {
    var ob = {
        title: "个人资料",
        width: "400",
        height: "500",
        url: "user/userInfo?id="+id
    };
    popup.open(ob);
}

//退出登录
function userLogout() {
    popup.confirm('是否确认退出登录?', function() {
        $.get("/logout", function(data) {
            if (data.success) {
                layer.msg("退出成功!", {icon:6,time:1000});
                location.href="/mallIndex";
            } else {
                popup.alert('退出失败!');
            }
        });
    })
}

//我的购物车
function getUserCar(userId) {
    var ob = {
        title: "我的购物车",
        width: "800",
        height: "600",
        url: "order/userCarList?userId="+userId
    };
    popup.open(ob);
}

//我的购物车
function getUserOrder(userId) {
    var ob = {
        title: "我的订单",
        width: "800",
        height: "600",
        url: "order/userOrderList?userId="+userId
    };
    popup.open(ob);
}