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


    <div class="right_col" role="main">
      <div class="row">

        <div class="col-md-3">
          <div class="x_panel" style="padding-left: 3px;">
            <div class="x_title">
              <h2>Search product</h2>
              <div class="clearfix"></div>
            </div>
            <div>
              <form>



                <div class="col-sm-12">
                  Product id | name
                  <div class="form-group">
                    <div>
                      <input type="text" class="form-control">
                    </div>
                  </div>
                </div>

                <div class="col-sm-12">
                  <div class="col-sm-6" style="padding-left: 0px;">
                    Sel.pri from
                    <div class="form-group">
                      <div>
                        <input type="text" class="form-control">
                      </div>
                    </div>
                  </div>

                  <div class="col-sm-6" style="padding-right: 0px;">
                    Sel.pri to
                    <div class="form-group">
                      <div>
                        <input type="text" class="form-control">
                      </div>
                    </div>
                  </div>
                </div>

                <div class="col-sm-12">
                  <div class="col-sm-6" style="padding-left: 0px;">
                    Pur.pri from
                    <div class="form-group">
                      <div>
                        <input type="text" class="form-control">
                      </div>
                    </div>
                  </div>

                  <div class="col-sm-6" style="padding-right: 0px;">
                    Pur.pri to
                    <div class="form-group">
                      <div>
                        <input type="text" class="form-control">
                      </div>
                    </div>
                  </div>
                </div>

                <div class="col-sm-12">
                  <div class="col-sm-6" style="padding-left: 0px;">
                    Qualities from
                    <div class="form-group">
                      <div>
                        <input type="text" class="form-control">
                      </div>
                    </div>
                  </div>

                  <div class="col-sm-6" style="padding-right: 0px;">
                    Qualities to
                    <div class="form-group">
                      <div>
                        <input type="text" class="form-control">
                      </div>
                    </div>
                  </div>
                </div>

                <div class="col-sm-12">
                  Status
                  <div class="form-group">
                    <select class="form-control">
                      <option>All</option>
                      <option>Stock</option>
                      <option>Deleted</option>
                    </select>
                  </div>
                </div>

                <div class="form-group">
                  <div class="col-sm-12">
                    <button class="btn btn-primary" type="reset">Reset</button>
                    <button type="submit" class="btn btn-success">Submit</button>
                  </div>
                </div>



              </form>
            </div>
          </div>
        </div>

        <div class="col-md-9">
          <div class="x_panel" style="padding-left: 3px;">
            <div class="x_title">
              <h2>Products</h2>
              <div class="nav navbar-right panel_toolbox">
                <div class="btn-group" >
                  <a href="<%=request.getContextPath() + UrlConstant.URL_ADMIN_PRODUCT_NEW%>" type="button" class="btn btn-success">Import</a>
                </div>
                <div class="btn-group ">
                  <button type="button" class="btn btn-success">Export File</button>
                  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <span class="caret"></span>
                  </button>
                  <ul class="dropdown-menu" role="menu">
                    <li><a href="#">Export detail</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Export overview</a>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="clearfix"></div>
            </div>
            <div class="x_content">
              <table class="table">
                <thead>
                <tr>
                  <th>#</th>
                  <th>Image</th>
                  <th>Product Id</th>
                  <th>Product name</th>
                  <th>Sell price</th>
                  <th>Purchase</th>
                  <th>Quality</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
              </table>
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
    $('#date-create-from').datetimepicker({
        format: 'DD/MM/YYYY'
    });
    $('#date-create-to').datetimepicker({
        format: 'DD/MM/YYYY'
    });
</script>
</body>
</html>
