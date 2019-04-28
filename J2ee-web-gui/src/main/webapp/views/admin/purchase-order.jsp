<%@ page import="Constant.UrlConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/tablib.jsp"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Meta, title, CSS, favicons, etc. -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" href="images/favicon.ico" type="image/ico" />

  <title>My Fashion Shop! | </title>

  <!-- Bootstrap -->
  <link href="${pageContext.request.contextPath}/resources/admin/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Font Awesome -->
  <link href="${pageContext.request.contextPath}/resources/admin/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <!-- Custom Theme Style -->
  <link href="${pageContext.request.contextPath}/resources/admin/build/css/custom.min.css" rel="stylesheet">
</head>
<body class="nav-md">
<div class="container body">
  <div class="main_container">

    <jsp:include page="slide-bar.jsp"></jsp:include>

    <%-- include dashboard page later--%>
    <div class="right_col" role="main">
      <div>
        purchase order
      </div>
    </div>



  </div>
</div>
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/admin/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/resources/admin/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Custom Theme Scripts -->
<script src="${pageContext.request.contextPath}/resources/admin/build/js/custom.min.js"></script>
</body>
</html>
