<%@ page import="Constant.UrlConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/tablib.jsp"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<%--http://jqueryui.com/autocomplete/#remote-jsonp--%>
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

    <div class="right_col" role="main">
      <div class="row">

        <div class="col-md-8">
          <div class="x_panel" style="padding-left: 3px;">
            <div class="x_content">
              <div style="display: flex;">
                <div style="font-size: 26px;">Import</div>
                <div class="col-sm-12" style="margin-left: 10px; display: flex; align-items: center;" >
                  <input type="text" class="form-control" placeholder="Search product by Id | Name">
                  <span class="fa fa-align-justify" style="font-size: x-large; margin-left: 5px;" aria-hidden="true"></span>
                  <span class="fa fa-filter" style="font-size: x-large; margin-left: 10px;" aria-hidden="true"></span>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" placeholder="Quality">
                  </div>
                </div>
              </div>
              <br/>
              <table class="table">
                <thead>
                <tr>
                  <th>#</th>
                  <th>Product Id</th>
                  <th>Product name</th>
                  <th>Sku</th>
                  <th>Quantity</th>
                  <th>Price</th>
                  <th>Total price</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
              </table>
            </div>
          </div>
        </div>

        <div class="col-md-4">
          <div class="x_panel" style="padding-left: 3px;">
            <div>
              <form>
                <div class="col-sm-12">
                  Date create purchase
                  <div class="form-group">
                    <div class="input-group date" id="current-date">
                      <input type="text" class="form-control" readonly="readonly">
                      <span class="input-group-addon">
                               <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                    </div>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>

      </div>
    </div>



  </div>
</div>
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/admin/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/resources/admin/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- bootstrap-daterangepicker -->
<script src="${pageContext.request.contextPath}/resources/admin/vendors/moment/min/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- bootstrap-datetimepicker -->
<script src="${pageContext.request.contextPath}/resources/admin/vendors/bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
<!-- Custom Theme Scripts -->
<script src="${pageContext.request.contextPath}/resources/admin/build/js/custom.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/admin/vendors/moment/min/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

<script>
    $('#current-date').datetimepicker({
        // format: 'DD/MM/YYYY'
        defaultDate: new Date()
    });
</script>
</body>
</html>
