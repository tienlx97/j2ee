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
  <%--bootrap select--%>
  <link href="${pageContext.request.contextPath}/resources/admin/build/css/bootstrap-select.min.css" rel="stylesheet">
</head>
<body class="nav-md">
<div class="container body">
  <div class="main_container">

    <jsp:include page="slide-bar.jsp"></jsp:include>


    <div class="right_col" role="main">
      <div class="row">

        <div class="col-md-5">
          <div class="x_panel" style="padding-left: 3px;">
            <div class="x_title">
              <h2>Add category</h2>
              <div class="clearfix"></div>
            </div>
            <div>
              <form method="post" action="<%=request.getContextPath() + UrlConstant.URL_ADMIN_CATEGORY%>">

                <div class="col-sm-12">
                  Id
                  <div class="form-group">
                    <div>
                      <input name="catId" id="catId" readonly="readonly" type="text" class="form-control">
                    </div>
                  </div>
                </div>

                <div class="col-sm-12">
                  Name
                  <div class="form-group">
                    <div>
                      <input name="catName" id="catName" type="text" class="form-control">
                    </div>
                  </div>
                </div>

                <div class="col-sm-12">
                  Description
                  <div class="form-group">
                    <div>
                      <textarea name="catDescription" id="catDescription" class="form-control" rows="5"></textarea>
                    </div>
                  </div>
                </div>


                <div class="col-sm-12" style="margin-bottom: 10px;">
                  Parent
                  <select multiple data-live-search="true" id="catParent" name="catParent" class="select-cat-parent form-control col-md-7 col-xs-12">
                    <option>cow</option>
                    <option data-subtext="option subtext">bull</option>
                    <option class="get-class" disabled>ox</option>
                  </select>
                </div>

                <div class="col-sm-12">
                  Image
                  <div class="form-group">
                    <div>
                      <input type="text" id="catImgUrl" name="catImgUrl" class="form-control">
                    </div>
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

        <div class="col-md-7">
          <div class="x_panel" style="padding-left: 3px;">
            <div style="display: flex;">
              <div style="font-size: 23px;">List</div>
              <div class="col-sm-12" style="margin-left: 10px; display: flex; align-items: center;" >
                <input type="text" class="form-control" placeholder="Search by name">
                <div>
                  <input type="button" class="form-control" value="Search">
                </div>
                <%--<span class="fa fa-search" style="font-size: x-large; margin-left: 5px;" aria-hidden="true"></span>--%>
                <div class="col-sm-9">
                  <div class="navbar-right">
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
                  <th>Id</th>
                  <th>Name</th>
                  <th>Description</th>
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
<%--bootrap select--%>
<script src="${pageContext.request.contextPath}/resources/admin/js/bootstrap-select.min.js"></script>
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
    $('.select-cat-parent').selectpicker({
        // options here
    });
</script>
</body>
</html>
