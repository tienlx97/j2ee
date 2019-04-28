<%@ page import="Constant.UrlConstant" %>
<%@ page import="admin.EmployeeDTO" %>
<%@ page import="Constant.VariableConstant" %>
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

<%
//  EmployeeDTO employeeDTO = (EmployeeDTO) request.getAttribute("data");
    String eUsername = (String) request.getAttribute(VariableConstant.ERROR_USERNAME);
    String ePassword = (String) request.getAttribute(VariableConstant.ERROR_PASSWORD);
    String cUsername = (String) request.getAttribute(VariableConstant.BAD_USERNAME_STYLE);
    String cPassword = (String) request.getAttribute(VariableConstant.BAD_PASSWORD_STYLE);

    EmployeeDTO employeeDTO = (EmployeeDTO) request.getAttribute(VariableConstant.LOGIN_DTO);
%>

<body class="login">
<div>
  <a class="hiddenanchor" id="signup"></a>
  <a class="hiddenanchor" id="signin"></a>

  <div class="login_wrapper">
    <div class="animate form login_form">
      <section class="login_content">
        <form action="<%= request.getContextPath() + UrlConstant.URL_ADMIN_LOGIN%>" method="post">
          <h1>Login Form</h1>
          <div>
            <%if(eUsername != null){%>
              <ul class="parsley-errors-list filled" id="parsley-id-5" style="text-align: left;margin: auto;">
                <li class="parsley-required"><%=eUsername%></li>
              </ul>
            <%}%>
            <input  type="text" name="username" id="username" class="form-control <%= cUsername %> " placeholder="Username" <%= employeeDTO != null ? "value=" + employeeDTO.getUsername(): "" %>>
          </div>
          <br/>
          <div>
            <%if(ePassword != null){%>
              <ul class="parsley-errors-list filled" id="parsley-id-6" style="text-align: left;margin: auto;">
                <li class="parsley-required"><%=ePassword%></li>
              </ul>
            <%}%>
            <input type="password" id="password" name="password" class="form-control <%= cPassword%>" placeholder="Password" <%= employeeDTO != null ? "value=" + employeeDTO.getPassword(): "" %>>
          </div>
          <br/>
          <div>
            <input type="submit" class="btn btn-default submit" value="Log in" />
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

