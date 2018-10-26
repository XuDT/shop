<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>商城首页</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <#include "common/common.ftl" />
    <script src="/js/basis/mallIndex.js"></script>
</head>
<body>
<div class="sidebar-navigation hidde-sm hidden-xs">
    <div class="logo">
        <#if userInfo?exists>
            <#if userInfo??>
            <a class="user-title"><span style="position: relative;top: -15px;">欢迎您，${(userInfo.username)!}</span></a>
            <a class="user-btn" onclick="getUserCar(${(userInfo.id)!})">我的购物车</a>
             <a class="user-btn" onclick="getUserOrder(${(userInfo.id)!})">我的订单</a>
            <a class="user-btn" onclick="getUser(${(userInfo.id)!})">个人资料</a>
            <a class="user-btn" onclick="userLogout()">安全退出</a>
            </#if>
        <#else >
            <a href="/login?role=user" class="user-title">登录</a>
        </#if>

    </div>
    <nav>
        <ul>
            <li>
                <a href="#top">
                    <span class="rect"></span>
                    <span class="circle"></span>
                    首页
                </a>
            </li>
            <li>
                <a href="#featured">
                    <span class="rect"></span>
                    <span class="circle"></span>
                    热门商品
                </a>
            </li>
            <li>
                <a href="#blog">
                    <span class="rect"></span>
                    <span class="circle"></span>
                    商品分类
                </a>
            </li>
        </ul>
    </nav>
</div>
<#--首页轮播图片-->
<div class="slider">
    <div class="Modern-Slider content-section" id="top">
        <div class="item item-1">
            <div class="img-fill">
                <div class="image"></div>
            </div>
        </div>
        <div class="item item-2">
            <div class="img-fill">
                <div class="image"></div>
            </div>
        </div>
    </div>
</div>


<div class="page-content">
<#--热门商品-->
    <section id="featured" class="content-section">
        <div class="section-heading">
            <h1>热门<br><em>商品</em></h1>
        </div>
        <div class="section-content">
            <div class="owl-carousel owl-theme">
                <#list commodityList as item>
                    <div class="item">
                        <div class="image">
                            <img src="${(item.commodityImg)!}" alt="" width="288px" height="432px">
                            <div class="featured-button button">
                                <a href="#projects" onclick="addToCart(${(item.id)!},${(userInfo.id)!})">加入购物车</a>
                            </div>
                        </div>
                        <div class="text-content">
                            <h4>${(item.name)!} ￥${(item.price)!}</h4>
                            <span>规格：${(item.standard)!}</span>
                            <p>描述：${(item.description)!}</p>
                        </div>
                    </div>
                </#list>
            </div>
        </div>
    </section>
<#--商品分类-->
    <section id="blog" class="content-section">
        <div class="section-heading">
            <h1>商品<br><em>分类</em></h1>
        </div>
        <div class="section-content">
            <div class="tabs-content">
                <div class="wrapper">
                    <ul class="tabs clearfix" data-tabgroup="first-tab-group">
                        <#list commodityClassify as parentlist >
                            <li><a href="#${(parentlist.code)!}" <#if parentlist_index==0>class="active"</#if>>${(parentlist.name)!}</a></li>
                        </#list>
                    </ul>
                    <section id="first-tab-group" class="tabgroup">
                    <#list commodityClassify as parentlist >
                        <div id="${(parentlist.code)!}">
                            <ul>
                               <#list parentlist.childCommodity as childlist>
                                   <li>
                                       <div class="item">
                                           <img src="${(childlist.commodityImg)!}" alt="" width="306px" height="230px">
                                           <div class="text-content">
                                               <h4>${(childlist.name)!} ￥${(childlist.price)!}</h4>
                                               <span>规格：${(childlist.standard)!}</span>
                                               <p>描述：${(childlist.description)!}</p>
                                               <div class="accent-button button">
                                                   <a href="#contact" onclick="addToCart(${(childlist.id)!},${(userInfo.id)!})">加入购物车</a>
                                               </div>
                                           </div>
                                       </div>
                                   </li>
                               </#list>
                            </ul>
                        </div>
                    </#list>
                    </section>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>