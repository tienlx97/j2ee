<%@ page import="Constant.UrlConstant" %>
<%@ page import="Constant.VariableConstant" %>
<%@ page import="core.CategoryDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/tablib.jsp"%>
<%@page isELIgnored="false" %>

<%
  List<CategoryDTO> categories = (List<CategoryDTO>) request.getAttribute(VariableConstant.CATEGORIES);
%>

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
  <%--PNotify--%>
  <link href="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.nonblock.css" rel="stylesheet">
</head>
<body class="nav-md">
<div class="container body">
  <div class="main_container">

    <%--<% if(error != null){ %>--%>
      <%--<script>alert("<%=error%>")</script>--%>
    <%--<%}%>--%>

    <jsp:include page="slide-bar.jsp"></jsp:include>

    <div class="right_col" role="main">
      <div class="row">

        <div class="col-md-12">
          <div class="x_panel" style="padding-left: 3px;">
            <div class="x_content">
                <div style="display: flex;">
                  <div style="font-size: 26px;">Search</div>
                  <div class="col-sm-12" style="margin-left: 10px; display: flex; align-items: center; " >
                    <input style="margin-right: 10px;" type="text" class="form-control" name="catSearch" id="catSearch" placeholder="Search category by Id | Name">
                    <button style="margin-bottom: 0px" id="btnAddNew" name="button" class="btn btn-primary btn_role" data-toggle="tooltip" title="" data-original-title="Add new category item">
                      <div>Add New</div>
                    </button>
                    <button style="margin-bottom: 0px" name="button" class="btn btn-primary btn_role" data-toggle="tooltip" title="" data-original-title="View Functions">
                      <div>Import File</div>
                    </button>
                    <button style="margin-bottom: 0px" name="button" class="btn btn-primary btn_role" data-toggle="tooltip" title="" data-original-title="View Functions">
                      <div>Export File</div>
                    </button>
                  </div>
                </div>
                <br/>
                <table class="table" id="tbContent">
                  <thead>
                  <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Function</th>
                  </tr>
                </thead>
                <tbody >
                <%
                  if(categories != null) {
                    for (int i=0; i< categories.size(); i++) {
                      CategoryDTO dto = categories.get(i);
                %>
                <tr id="row_<%=dto.getCatId()%>">
                  <td><%= dto.getCatId() %></td>
                  <td><%= dto.getCatName() %></td>
                  <td><%= dto.getCatDescription() %></td>
                  <td style="display:flex">
                    <button type="button"
                            class="btn btn-primary btn_edit"
                            data-target=".bs-example-modal-lg" data-toggle="tooltip" title="Edit"><i
                            class="fa fa-edit"></i>
                    </button>
                    <button name="button" type="button"
                            class="btn btn-warning btn_disable" data-toggle="tooltip"
                            title="Disable">
                      <i class="fa fa-minus"></i>
                    </button>
                  </td>

                </tr>
                <%} }%>
                </tbody>
                </table>
              </div>
          </div>
          </div>
        </div>

      </div>
    </div>

  <div id="modal_add_new" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">

        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
          </button>
          <h4 class="modal-title" id="myModalLabel">Add new category</h4>
        </div>
        <div class="modal-body">
            <form id="fAddCategory" method="post" action="">

              <div class="col-sm-12">
                Name
                <div class="form-group">
                  <div>
                    <ul id="error-cat-name" style="text-align: left;margin: auto;">
                    </ul>
                    <input name="catName" id="catName" type="text" class="form-control">
                  </div>
                </div>
              </div>

              <div class="col-sm-12">
                Description
                <div class="form-group">
                  <div>
                    <%--<textarea name="catDescription" id="catDescription" class="form-control" rows="5"><%= categoryDTO != null ? categoryDTO.getCatDescription(): "" %></textarea>--%>
                      <textarea name="catDescription" id="catDescription" class="form-control" rows="5"></textarea>
                  </div>
                </div>
              </div>

              <div class="col-sm-12">
                Image
                <div class="form-group">
                  <div>
                    <%--<input type="text" id="catImgUrl" name="catImgUrl" class="form-control" <%= categoryDTO != null ? "value=" + categoryDTO.getCatImgUrl(): "" %>>--%>
                    <input type="text" id="catImgUrl" name="catImgUrl" class="form-control">
                  </div>
                </div>
              </div>

              <div class="form-group">
                <div class="col-sm-12">
                  <button type="submit" class="btn btn-success">Submit</button>
                  <input type="hidden" name="action" id="action" value="ADD_NEW">
                </div>
              </div>

            </form>
        </div>

      </div>
    </div>
  </div>

  <div id="modal_edit" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">

        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
          </button>
          <h4 class="modal-title">Edit category</h4>
        </div>
        <div class="modal-body">

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

<!-- PNotify -->
<script src="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.buttons.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.nonblock.js"></script>

<%--custom--%>
<script src="${pageContext.request.contextPath}/resources/admin/js/category.js"></script>

<script>
    $(document).ready(function (){
        $('.ui-pnotify').remove();
    });
</script>
<script>

  function AddNotify(title, msg, type) {
      new PNotify( {
          title:title, type: type, text:msg, nonblock: {
              nonblock: !0
          } , addclass:"dark", styling:"bootstrap3",delay: 2000
            ,hide: true
        }
      );
  }

  $(document).on('click', '.btn_edit', function (event) {
      event.preventDefault();
      itemId = $(this).parent().parent().attr('id').split('_')[1];
      $.ajax({//define object from XML Http Request
          url: '<%= request.getContextPath() + UrlConstant.ADMIN_EDIT_CATEGORY%>', //action : go to Add Comment controller
          type: 'GET',
          data: {catId: itemId},
          // on success do:
          success: function (response) {
              $('#modal_edit .modal-content .modal-body').html(response);
              $('#modal_edit').modal('show');
          }
      });
  });

  $('#catSearch').on('keypress', function (e) {
      if(e.which === 13){ // enter
          searchCategoryUrl = '<%=request.getContextPath() + UrlConstant.URL_ADMIN_CATEGORY%>';
          requestData = $('#catSearch').serialize() + '&action=SEARCH'
          $.ajax({
              url: searchCategoryUrl,
              type: 'post',
              data: requestData,
              dataType: 'json',
              success: function(response) {
                  if(response.type == false) {

                  } else { // show data when success
                      $("#tbContent tbody").empty();

                      response.categories.forEach(function (item, index) {
                          $("#tbContent tbody").append(
                              "<tr id='row_" + item.catId + "'>" +
                                "<td>" + item.catId + "</td>" +
                                "<td>" + item.catName + "</td>" +
                                "<td>" + item.catDescription + "</td>" +
                                "<td style='display:flex'>" +
                                  "<button type='button' class='btn btn-primary btn_edit' data-target='.bs-example-modal-lg' data-toggle='tooltip' title='Edit'>" +
                                    "<i class='fa fa-edit'></i>" +
                                  "</button>" +
                                  "<button name='button' type='button' class='btn btn-warning btn_disable' data-toggle='tooltip' title='Disable'>" +
                                    "<i class='fa fa-minus'></i>" +
                                  "</button>"+
                                "</td>" +
                              "</tr>"
                          );
                      });
                  }

              }
          });
      }
  });

  $(document).on('submit', '#fAddCategory', function (e) {

        e.preventDefault();
        form = $(this);

        addCategoryUrl = '<%=request.getContextPath() + UrlConstant.URL_ADMIN_CATEGORY%>';
        requestMethod = form.attr('method');
        requestData = form.serialize();

        $.ajax({
            url: addCategoryUrl,
            type: requestMethod,
            data: requestData,
            dataType: 'json',
            beforeSend: function(){

            },
            success: function(response) {
              if(response.type == false) {
                  if(response.msg == null) {
                      $("#error-cat-name").addClass(response.cError);
                      $("#error-cat-name").append(response.eCatName);
                  } else { // show data when fail
                      AddNotify("Add Category", response.msg, "error");
                  }
              } else { // show data when success
                  form.find("input[type=text], textarea").val("");
                  AddNotify("Add Category", response.msg, "success");
              }
            }
        });

    });

  $(document).on('submit', '#fEditCategory', function (e) {

      e.preventDefault();
      form = $(this);

      editCategoryUrl = '<%=request.getContextPath() + UrlConstant.ADMIN_EDIT_CATEGORY%>';
      requestMethod = form.attr('method');
      requestData = form.serialize();

      $.ajax({
          url: editCategoryUrl,
          type: requestMethod,
          data: requestData,
          dataType: 'json',
          beforeSend: function(){

          },
          success: function(response) {
              if(response.type == false) {
                  if(response.msg == null) {
                      $("#fAddCategory #error-cat-name").addClass(response.cError);
                      $("#fAddCategory #error-cat-name").append(response.eCatName);
                  } else { // show data when fail
                      AddNotify("Edit Category", response.msg, "error");
                  }
              } else { // show data when success
                  form.find("input[type=text], textarea").val("");
                  AddNotify("Edit Category", response.msg, "success");
              }
          }
      });

  });

</script>

</body>
</html>
