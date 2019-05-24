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
    <title>口袋商城后台管理| 内容分类</title>
    <jsp:include page="../includs/header.jsp"/>
    <link href="/static/assets/plugins/treeTable/themes/vsStyle/treeTable.css" rel="stylesheet"/>
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
                            <h3 class="box-title">分类列表</h3>

                            <div class="row" style="padding-left: 15px;padding-top: 13px;">
                                <a href="/content/category/form" type="button" class="btn btn-default btn-sm"><i
                                        class="fa fa-plus"></i> 新增</a>&nbsp;&nbsp;&nbsp;
                            </div>

                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover" id="treeTable">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>名称</th>
                                    <th>排序</th>
                                    <th>操作</th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach var="c" items="${tbContentCategories}">
                                    <tr id="${c.id}" pId="${c.parentId}">
                                        <td>${c.id}</td>
                                        <td>${c.name}</td>
                                        <td>${c.sortOrder}</td>
                                        <td>
                                            <a href="#" type="button" class="btn btn-default btn-sm"><i class="fa fa-plus"></i> 新增下级菜单</a>
                                            <a href="#" type="button" class="btn btn-primary btn-sm"><i class="fa fa-search"></i> 编辑</a>
                                            <a href="#" type="button" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i> 删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>

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
<script src="/static/assets/plugins/treeTable/jquery.treeTable.min.js"></script>
<script>
    $(function () {
        $("#treeTable").treeTable({
            expendLevel:2//默认展开层数
        });
    });
</script>
</body>
</html>
