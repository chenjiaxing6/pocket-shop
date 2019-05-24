<%--
  Created by IntelliJ IDEA.
  User: chenjiaxing
  Date: 2019/5/15
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<html>
<head>
    <title>口袋商城后台管理| 内容分类表单页</title>
    <jsp:include page="../includs/header.jsp"/>
    <link href="/static/assets/plugins/jquery-ztree/css/zTreeStyle/zTreeStyle.min.css" rel="stylesheet"/>
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
                内容分类管理
                <small>content category manage</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">内容分类管理</li>
            </ol>
            <br/>

            <div class="row">
                <div class="col-md-12">
                    <div class="alert alert-danger alert-dismissible" ${baseResult.message == null ? "style='display:none;'" : ""}>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        ${baseResult.message}
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">${tbUser.id==null?"新增":编辑}内容</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form cssClass="form-horizontal" action="/user/save" method="post"
                                   modelAttribute="tbContentCategory" id="inputForm">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="id" class="col-sm-2 control-label">父分类</label>

                                    <div class="col-sm-10">
                                        <form:hidden path="id" />
                                        <input id="categoryName" class="form-control required" readonly="true"
                                                    data-toggle="modal" data-target="#modal-default"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="name" class="col-sm-2 control-label" >分类名称</label>

                                    <div class="col-sm-10">
                                        <form:input path="name" cssClass="form-control required" placeholder="分类名称"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="sortOrder" class="col-sm-2 control-label" >分类排序</label>

                                    <div class="col-sm-10">
                                        <form:input path="sortOrder" cssClass="form-control required digits" placeholder="分类排序"/>
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                                <button type="submit" class="btn btn-info pull-right">提交</button>
                            </div>
                            <!-- /.box-footer -->
                        </form:form>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <!--中间内容结束-->

    <!-- 版权信息开始 -->
    <jsp:include page="../includs/copyright.jsp"/>
    <!-- 版权信息结束 -->
    <jsp:include page="../includs/footer.jsp"/>
    <!--自定义模态框-->
    <sys:model title="请选择"
               message='<ul id="myTree" class="ztree" style="width:260px; overflow:auto;"></ul>'></sys:model>
</div>
<script src="/static/assets/plugins/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script>
    $(function () {
        App.initZTree("/content/category/treeData",["id"],function (nodes) {
            var category_id = nodes[0].id;

            $("#categoryId").val(category_id);
            $("#categoryName").val(nodes[0].name);
            $("#modal-default").modal("hide");
        });
    })
</script>
</body>
</html>
