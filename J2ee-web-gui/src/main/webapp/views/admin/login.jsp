<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/tablib.jsp"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Meta, title, CSS, favicons, etc. -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Admin Management! | </title>

  <!-- Bootstrap -->
  <link href="${pageContext.request.contextPath}/resources/admin/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Font Awesome -->
  <link href="${pageContext.request.contextPath}/resources/admin/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <!-- NProgress -->
  <link href="${pageContext.request.contextPath}/resources/admin/vendors/nprogress/nprogress.css" rel="stylesheet">
  <!-- Animate.css -->
  <link href="${pageContext.request.contextPath}/resources/admin/vendors/animate.css/animate.min.css" rel="stylesheet">

  <!-- Custom Theme Style -->
  <link href="${pageContext.request.contextPath}/resources/admin/build/css/custom.min.css" rel="stylesheet">
</head>

<body class="login">
<div>
  <a class="hiddenanchor" id="signin"></a>

  <div class="login_wrapper">
    <div class="animate form login_form">
      <section class="login_content">
        <form>
          <h1>Login Form</h1>
          <div>
            <input type="text" name="username" class="form-control" placeholder="Username" required="" />
          </div>
          <div>
            <input type="password" name="password" class="form-control" placeholder="Password" required="" />
          </div>
          <div>
            <a class="btn btn-default submit" href="index.html">Log in</a>
            <a class="reset_pass" href="#">Lost your password?</a>
          </div>

          <div class="clearfix"></div>

          <div class="separator">
            <div class="clearfix"></div>
            <br />

            <div>
              <h1><i class="fa fa-paw"></i> My Fashion Shop</h1>
              <p>©2019 All Rights Reserved.</p>
            </div>
          </div>
        </form>
      </section>
    </div>
    </section>
  </div>
</div>
</div>
</body>
</html>

