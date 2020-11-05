<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: renlo
  Date: 2020/10/28
  Time: 17:10
  To change this template use File | Settings | File Templates.

  所有博客列表展示页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%
    String contextPath = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
%>

<html>
<head>
    <%--设置基础路径为项目根目录--%>
    <base href="<%=basePath%>"/>
    <%--标题图标--%>
    <link rel="icon" href="resources/img/javalogo.jpg" type="image/x-icon" />
    <link rel="shortcut icon" href="resources/img/javalogo.jpg" type="image/x-icon">
    <%--bootstrap 引入--%>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css">
    <script type="text/javascript" rel="script" src="resources/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" rel="script" src="resources/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" rel="script" src="resources/js/bootstrap.min.js"></script>
    <title>博客详情</title>
</head>

<style>
    .titlefont{
        font-size: 30px;
        font-weight: bold;
    }
    .smallfont{
        font-size: 10px;
    }
    .mylink{
        color: darkcyan;
        cursor: pointer;
        font-size: 16px;
    }
    .invalidLink{
        color: gray;
        font-size: 16px;
    }
</style>

<body>

<%@include file="header.jsp" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-9">
            <div class="alert alert-heading border border-0" role="alert">
                <h3 class="alert-heading">
                    ${requestScope.blog.blogTitle}
                </h3>
                <hr>
                <p class="mb-0 smallfont" >
                    发布时间：
                    <fmt:formatDate value="${requestScope.blog.blogEditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    阅读数：${requestScope.blog.blogReadTimes} &nbsp;&nbsp;&nbsp;&nbsp;
                    评论数：${requestScope.blog.blogCommentTimes}
                </p>
                <p class="mb-0 smallfont" >
                    <c:forEach items="${requestScope.labels}" var="label">
                        <span class="badge badge-success">${label.blogLabel.labelName}</span>&nbsp;&nbsp;&nbsp;&nbsp;
                    </c:forEach>
                </p>
            </div>

            <%--内容--%>
            <div class="card content">
                <div class="card-body">
                    <p>
                        ${requestScope.blog.blogContent}
                    </p>
                </div>
            </div>

            <div id="levelOne">
            <%--评论--%>
            <c:forEach items="${requestScope.blogComments}" var="blogComment">

                <div style="height: 10px"></div>

                <div class="card">
                    <div class="card-body">
                        <p class="titleInText" onclick="">
                            <div class="row" style="margin-left: 8px">
                                <img src="user/header/${blogComment.blogCommentUserId}" class="rounded card-img-top" alt="头像不见了"
                                     style="width: 20px;height: 20px">
                                 &nbsp;&nbsp;&nbsp;
                                <a href="#" class="mylink" >${blogComment.blogCommentUserName}</a>
                            </div>
                        </p>
                        <hr/>
                        <p class="contentInText">
                            ${blogComment.blogCommentContents}
                        </p>
                        <p class="statusInText">
                            <span class="badge badge-primary">发表时间：
                                <fmt:formatDate value="${blogComment.blogCommentTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                            </span>
                            <span class="badge badge-success">子评论数：${blogComment.blogCommentSonCount}</span>
                        </p>

                        <div class="sonCommentPanelSon" hidden="hidden">
                            <p class="contentInText">
                                <textarea class="form-control" rows="3"></textarea>
                            </p>
                            <button type="button" class="btn btn-success commentYes">发表评论</button>
                            <button type="button" class="btn btn-success commentNo">取消</button>
                        </div>

                        <div>
                            <c:if test="${blogComment.blogCommentSonCount == 0}">
                                <label class="invalidLink">展开</label>
                            </c:if>
                            <c:if test="${blogComment.blogCommentSonCount != 0}">
                                <label class="mylink" onclick="getTogleDetailComments($(this),${blogComment.blogCommentId})">展开</label>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;
                            <label class="mylink" onclick="toglePanel($(this))">评论</label>
                            <div class="sonCommentPanel" hidden="hidden">
                                <p class="contentInText">
                                    <textarea class="form-control" rows="4" placeholder="开始评论吧"></textarea>
                                </p>
                                <button type="button" class="btn btn-success" onclick="publishComment($(this),${blogComment.blogCommentId},${blogComment.blogCommentId})">发表评论</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
            </div>
            <%--发表评论--%>
            <div style="height: 10px"></div>
            <div class="card">
                <div class="card-body">
                    <p class="titleInText">
                    <div class="row" style="margin-left: 8px">
                        <img src="user/header/${sessionScope.userId}" class="img-fluid" alt="头像不见了"
                             style="width: 20px;height: 20px">
                        &nbsp;&nbsp;&nbsp;
                        <a href="#" class="mylink" >${sessionScope.userName}</a>
                    </div>
                    </p>
                    <hr/>
                    <p class="contentInText">
                        <textarea class="form-control" rows="4" placeholder="开始评论吧" id="userCommentId"></textarea>
                    </p>
                    <button type="button" class="btn btn-success" onclick="publishComment($(this),0,0)">发表评论</button>
                </div>
            </div>
        </div>
        <div class="col-3">
            <div style="padding-left: 1rem">
                <div class="card">
                    <div style="height: 10px"></div>
                    <div class="text-center">
                        <img src="user/header/${requestScope.user.userId}" class="rounded card-img-top" alt="头像不见了" style="width: 50px;height: 50px">
                    </div>
                    <div class="card-body text-center">
                        <h5 class="card-title">${requestScope.user.userName}</h5>
                        <p class="card-text">
                            <span class="badge badge-secondary">
                                <c:if test="${requestScope.user.userGender == '1'}">
                                    男
                                </c:if>
                                <c:if test="${requestScope.user.userGender == '2'}">
                                    女
                                </c:if>
                            </span>
                            <span class="badge badge-secondary">
                                加入时间:
                                <fmt:formatDate value="${requestScope.user.userCreateTime}" pattern="yyyy-MM-dd"/>
                            </span>
                        </p>
                        <p class="card-text">${requestScope.user.userDescription}</p>
                        <a href="#" class="btn btn-primary">加关注</a>
                    </div>
                </div>
                <div style="height: 10px"></div>
                相关文章
                <div style="height: 10px"></div>
                <div class="card">
                    <div class="card-body">
                        This is some text within a card body.
                    </div>
                </div>
                <div style="height: 10px"></div>
                <div class="card">
                    <div class="card-body">
                        This is some text within a card body.
                    </div>
                </div>
                <div style="height: 10px"></div>
                <div class="card">
                    <div class="card-body">
                        This is some text within a card body.
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--
<div aria-live="polite" aria-atomic="true" style="position: relative; min-height: 200px;">
    <div class="toast" style="position: absolute; top: 0; right: 0;">
        <div class="toast-header">
            <img src="..." class="rounded mr-2" alt="...">
            <strong class="mr-auto">Bootstrap</strong>
            <small>11 mins ago</small>
            <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="toast-body">
            Hello, world! This is a toast message.
        </div>
    </div>
</div>
--%>

<%@include file="footer.jsp" %>

<script>

/*    function successUpdate(){
        $('.toast').toast(animation);
    }*/



    $(function () {
        ${blogComment.blogCommentSonCount}
    });

    /*点击展开后显示所有博客*/
    function getTogleDetailComments(obj,commentId) {
        var label = obj.parent().siblings(".statusInText");
        //var generated = label.siblings(".generate").val();
        var genst = label.siblings(".generate");
        //alert(generated.val());
       // alert(generated);
        if(label.is(":hidden")){
            /*if(generated == null || generated == "" || generated == undefined){
            }else{
                alert(1);
                genst.hide();
            }*/
            genst.remove();
            label.show();
            obj.text("展开");
        }else{
            /*if(generated == null || generated == "" || generated == undefined){
                alert(2);*/
                $.ajax({
                    type: "GET",
                    url: "comment/get/"+commentId,
                    dataType: "json",
                    success: function (result) {
                        //alert(result);
                        showjson(label,result,commentId);
                        //alert(result);
                    }
                });
                obj.text("收起");
            /*}else{
                alert(3);
                genst.show();
            }*/
        }
    }

    /*显示至页面*/
    function showjson(obj,jsonString,commentId) {

        var html = $("<div class='generate'></div>");
        html.append("<hr/>");

        $.each(jsonString,function (name,value) {

            var commentContent = $("<label class='mylink'>"+value.blogCommentContents+"</label>");
            commentContent.click(function () {

                var panelComment = obj.siblings('.sonCommentPanelSon');
                //alert(panelComment);
                if(panelComment.is(":hidden")){
                    panelComment.removeAttr("hidden");
                    panelComment.show();
                }
                panelComment.children(".commentYes").one("click",function () {
                    var blogCommentContents = panelComment.children(".contentInText").children(".form-control").val();
                    //alert(blogCommentContents);
                    $.ajax({
                        type: "POST",
                        url: "comment/add",
                        data: {
                            "blogCommentContents": blogCommentContents,
                            "blogCommentBlogId": "${requestScope.blog.blogId}",
                            "blogCommentBlogSonId": commentId,
                            "blogCommentFather": value.blogCommentId
                        },
                        success: function (result) {
                            if(result == "success"){
                                panelComment.hide();
                            }else{
                                alert("失败了");
                            }
                        }
                    });
                });
                panelComment.children(".commentNo").click(function () {
                    panelComment.hide();
                });
            });

            var divs = $("<div></div>");
            var content;
            if(commentId == value.blogCommentFather){
                content = "<a href='user/home/"+value.blogCommentUserId+"' >"+value.blogCommentUserName+"</a>: "/*+
                    "<label class='mylink' onclick='commentEvent(obj,)'>"+value.blogCommentContents+"</label>"*/;
            }else{
                var fatherName;
                var fatherId;
                $.each(jsonString,function (name1,value1) {
                    if(value.blogCommentFather == value1.blogCommentId){
                        fatherName = value1.blogCommentUserName;
                        fatherId = value1.blogCommentUserId;
                        return false;
                    }
                });
                content = "<a href='user/home/"+value.blogCommentUserId+"' >"+
                    value.blogCommentUserName+"</a> 回复 <a href='user/home/"+ fatherId +"' > "+fatherName+"</a>:"
                /*"<label class='mylink'>"+value.blogCommentContents+"</label>"*/;
            }
            divs.append(content);
            divs.append(commentContent);
            html.append(divs);
        });

        obj.before(html);
        obj.hide();
    }

    function startCommentSon(){
        var commentPanel = obj.siblings(".sonCommentPanel");
        if(commentPanel.is(":hidden")){
            commentPanel.removeAttr("hidden");
            commentPanel.show();
            obj.text("收起评论");
        }else{
            commentPanel.hide();
            obj.text("评论");
        }
    }

    function publishComment(obj,father,fatherSon) {
        var blogCommentContents = obj.siblings("p").children().val();
        //alert("${requestScope.blog.blogId}"+ father);
        $.ajax({
            type: "POST",
            url: "comment/add",
            data: {
                "blogCommentContents": blogCommentContents,
                "blogCommentBlogId": "${requestScope.blog.blogId}",
                "blogCommentBlogSonId": fatherSon,
                "blogCommentFather": father
            },
            success: function (result) {
                if(result == "success"){
                    //alert(1);
                    if(father==0){

                    }else {

                        toglePanel(obj.parent().siblings(".mylink"));
                    }
                    //successUpdate();
                    //addNewComments();
                }else{
                    alert("失败了");
                }
            }
        });
    }

    function addNewComments(){

    }

    /*打开与关闭评论框*/
    function toglePanel(obj) {
        var commentPanel = obj.siblings(".sonCommentPanel");
        if(commentPanel.is(":hidden")){
            commentPanel.removeAttr("hidden");
            commentPanel.show();
            obj.text("收起评论");
        }else{
            commentPanel.hide();
            obj.text("评论");
        }
    }
</script>
</body>
</html>
