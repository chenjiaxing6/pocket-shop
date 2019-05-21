<%--
  Created by IntelliJ IDEA.
  User: chenjiaxing
  Date: 2019/5/15
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<html>
<head>
    <title>口袋商城后台管理| 内容列表页</title>
    <jsp:include page="../includs/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <!--首部开始-->
    <jsp:include page="../includs/nav.jsp"/>
    <!--首部结束-->

    <!--左侧菜单开始-->
    <jsp:include page="../includs/menu.jsp"/>
    <!--左侧菜单结束-->

    <!--中间内容开始-->
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                内容管理
                <small>content manage</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">内容管理</li>
            </ol>
            <br/>
            <!-- /.row -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="alert alert-${baseResult.status == 200?"success":"danger"} alert-dismissible" ${baseResult.message == null ? "style='display:none;'" : ""}>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        ${baseResult.message}
                    </div>
                </div>
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">内容列表</h3>

                            <div class="row" style="padding-left: 15px;padding-top: 13px;">
                                <a href="/content/form" type="button" class="btn btn-default btn-sm"><i
                                        class="fa fa-plus"></i> 新增</a>&nbsp;&nbsp;&nbsp;
                                <button href="#" type="button" class="btn btn-default btn-sm deleteAll"
                                        onclick="App.deleteMulti('/content/delete')"><i class="fa fa-trash"></i>
                                    批量删除
                                </button>&nbsp;&nbsp;&nbsp;
                                <button onclick="alert('开发中')" type="button" class="btn btn-default btn-sm"><i
                                        class="fa fa-cloud-upload"></i> 导入</button>&nbsp;&nbsp;&nbsp;
                                <button  onclick="alert('开发中')" type="button" class="btn btn-default btn-sm"><i
                                        class="fa fa-cloud-download"></i> 导出</button>&nbsp;&nbsp;&nbsp;
                                <button class="btn btn-primary btn-sm"
                                        onclick="$('.search-panle').css('display')=='none'?$('.search-panle').show():$('.search-panle').hide()">
                                    <i
                                            class="fa fa-search"></i> 搜索
                                </button>
                            </div>

                            <div class="row search-panle" style="padding-left: 5px; padding-top:10px;display: none">
                                    <div class="row form-horizontal">
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label for="title" class="col-sm-3 control-label">标题</label>
                                                <div class="col-sm-8">
                                                    <input name="title" id="title" class="form-control " placeholder="标题"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label for="subTitle" class="col-sm-3 control-label">子标题</label>
                                                <div class="col-sm-8">
                                                    <input id="subTitle" name="subTitle" class="form-control" placeholder="二级标题"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label for="title_Desc" class="col-sm-4 control-label">标题描述</label>
                                                <div class="col-sm-8">
                                                    <input id="title_Desc" name="title_Desc" class="form-control" placeholder="标题描述"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-3">
                                            <button onclick="search()" class="btn btn-info">搜索</button>
                                        </div>
                                    </div>
                            </div>

                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover" id="dataTable">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal icheck_master"/></th>
                                    <th>ID</th>
                                    <th>标题</th>
                                    <th>子标题</th>
                                    <th>标题描述</th>
                                    <th>url</th>
                                    <%--<th>图片1</th>--%>
                                    <%--<th>图片2</th>--%>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>


    </div>

    <!--中间内容结束-->

    <!-- 版权信息开始 -->
    <jsp:include page="../includs/copyright.jsp"/>
    <!-- 版权信息结束 -->
    <jsp:include page="../includs/footer.jsp"/>
</div>
<!--自定义模态框-->
<sys:model></sys:model>
<script>
    var _dataTable;
    $(function () {
        var columns = [
            {
                "data": function (row, type, val, meta) {
                    return '<input type="checkbox" id="'+row.id+'" class="minimal"/>';
                }
            },
            {"data": "id"},
            {"data": "title"},
            {"data": "subTitle"},
            {"data": "titleDesc"},
            {"data": "url"},
            // {"data": "pic"},
            // {"data": "pic2"},
            {"data": function (row, type, val, meta) {
                return DateTime.format(row.updated,"yyyy-MM-dd HH:mm:ss");
                }},
            {
                "data": function (row, type, val, meta) {
                    return '<button  onclick="showDetail('+row.id+')" type="button" class="btn btn-default btn-sm"><i class="fa fa-trash"></i> 查看</button>' +
                        '<a href="/content/form?id='+row.id+'" type="button" class="btn btn-primary btn-sm"><i class="fa fa-search"></i> 编辑</a>' +
                        '<a href="#" type="button" onclick="deleSinle('+row.id+')" class="btn btn-danger btn-sm"><i class="fa fa-edit"></i> 删除</a>';
                }
            }
        ];

        _dataTable = App.initDataTables("/content/page", columns);

    })

    /**
     * 搜索
     * */
    function search() {
        var title = $("#title").val();
        var subTitle = $("#subTitle").val();
        var  titleDesc = $("#titleDesc").val();
        var param = {
            "title": title,
            "subTitle": subTitle,
            "titleDesc":titleDesc,
        };
        _dataTable.settings()[0].ajax.data = param;
        _dataTable.ajax.reload();
    }

    /**
     * 查看内容信息
     */
    function showDetail(id){
        App.showDetail("/content/detail?id="+id);
    }

    function deleSinle(id) {
        App.deleteSingle("/content/delete",id)
    }
</script>
</body>
</html>
