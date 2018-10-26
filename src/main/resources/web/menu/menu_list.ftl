<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>菜单管理</title>
</head>
<#include "../common/common.ftl" />
<link rel="stylesheet" href="/css/basis/menu.css">
<script src="/js/basis/menu.js"></script>
<body>
<div class="divone">
    <div class="btn-div">
        <a class="btn addbtn click-btn"><i class="fa fa-plus"></i> 新增</a>
        <a class="btn updatebtn click-btn"><i class="fa fa-pencil"></i> 编辑</a>
        <a class="btn deletebtn click-btn" ><i class="fa fa-trash-o"></i> 删除</a>
    </div>
    <div class="ibox-content" style="margin-top: 0%;width: 94%;margin-left: 3%;">
        <form method="get" action="">
            <div class="form-horizontal clearfix">
                <div class="col-lg-5 col-sm-5">
                </div>
                <div class="col-lg-4 col-sm-4">
                </div>
                <div class="col-lg-3 col-sm-3">
                    <div class="form-group">
                        <!--  -->
                        <div class="col-lg-12 col-sm-12 input-group">
                            <input type="text" id="keyword" name="keyword" placeholder="请输入菜单名称" value="${(keyword)!}"
                                   class="input-sm form-control">
                            <span class="input-group-btn">
                                    <button type="button" class="btn btn-sm btn-primary" onclick="searchBtn();"> 搜索</button> </span>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!-- search end -->
        <div id="left_dict" style="overflow-y: auto;">
            <table id="example" class="table table-striped table-bordered table-hover dataTables-example dataTable"
                   cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th class="tn" width="4%"><input class="all" name="" type="checkbox" hidden></th>
                    <th class="tn">菜单名称</th>
                    <th class="tn">资源值</th>
                    <th class="tn">上级菜单</th>
                    <th class="tn">排序值</th>
                </tr>
                </thead>
                <tbody>
                <#list menulist as menulist>
                <tr>
                    <td class="tn"><input class="checkId" name="" type="checkbox" value="${(menulist.id)!}"></td>
                    <td class="tn">${(menulist.name)!}</td>
                    <td class="tn">${(menulist.path)!}</td>
                    <#if menulist.pid!=0>
                        <td class="tn">${(menulist.parentName)!}</td>
                    <#else>
                        <td class="tn"></td>
                    </#if>
                    <td class="tn">${(menulist.level)!}</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>