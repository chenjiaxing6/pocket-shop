<%--
  Created by IntelliJ IDEA.
  User: chenjiaxing
  Date: 2019/5/15
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>口袋商城后台管理| 用户详情</title>
    <jsp:include page="../includs/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <div class="dataTable">
        <table class="table table-hover" id="dataTable">
            <tr>
                <td>邮箱：</td>
                <td>${tbUser.email}</td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td>${tbUser.username}</td>
            </tr>
            <tr>
                <td>电话：</td>
                <td>${tbUser.phone}</td>
            </tr>
            <tr>
                <td>创建时间：</td>
                <td><fmt:formatDate value="${tbUser.created}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
            </tr>
            <tr>
                <td>更新时间：</td>
                <td><fmt:formatDate value="${tbUser.updated}" pattern="yyyy-MM-dd hh:MM:ss"/> </td>
            </tr>
        </table>
    </div>
<jsp:include page="../includs/footer.jsp"/>
</body>
</html>
