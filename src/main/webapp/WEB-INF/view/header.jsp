
<%--
  Created by IntelliJ IDEA.
  User: renlo
  Date: 2020/10/28
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(function () {

    });

    /**
     * 执行搜索按钮后跳转到搜索界面。
     * @param obj
     */
    function serachContent(obj) {
        var serachText = obj.siblings(".serachClass").val();
        window.location.href = "serach?serachText="+serachText;
    }
</script>

<nav class="navbar navbar-expand-lg fixed-top navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="index">JKBlog</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="index">主页 <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="blogedit">发博客</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        更多
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">关于博客</a>
                        <a class="dropdown-item" href="#">关注</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">退出登录</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">其他事务</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2 serachClass" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="button" onclick="serachContent($(this))">搜索</button>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <ul class="navbar-nav mr-auto">
                    <c:if test="${sessionScope.userName == null}">
                        <li class="nav-item">
                            <a class="nav-link" href="login">登录</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="register">注册</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.userName != null}">
                        <li class="nav-item">
                            <a class="nav-link" href="homepage?userId=${sessionScope.userId}">${sessionScope.userName}</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="loginOut">退出</a>
                        </li>
                    </c:if>
                </ul>
                <%--<span id="login" >登录</span>&nbsp;&nbsp;
                <span id="register">注册</span>--%>
            </form>
        </div>
    </div>
</nav>

<div style="height: 70px"></div>

