<%@ page import="Constant.UrlConstant" %>
<%@ page import="Constant.VariableConstant" %>
<%@ page import="java.util.List" %>
<%@ page import="core.ProductDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/tablib.jsp"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<%
List<ProductDTO> products = (List<ProductDTO>) request.getAttribute(VariableConstant.PRODUCTS);
String numberPage = (String) request.getAttribute("NUMBER_PAGE");
%>

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
<%--Pnotify--%>
  <link href="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.nonblock.css" rel="stylesheet">
  <style>
    /*#tb_product tr {*/
      /*background-color: #eee;*/
      /*border-top: 1px solid #fff;*/
    /*}*/
    /*#tb_product tr:hover {*/
      /*background-color: #ccc;*/
    /*}*/
    /*#tb_product th {*/
      /*background-color: #fff;*/
    /*}*/
    /*#tb_product th, #tb_product td {*/
      /*padding: 3px 5px;*/
    /*}*/
    /*#tb_product td:hover {*/
      /*cursor: pointer;*/
    /*}*/
    /*.currRow*/
    /*{*/
      /*background-color:White;*/
      /*cursor:pointer;*/
      /*border-width:thin;*/
      /*border-color:Aqua;*/
      /*color:White;*/
      /*font-style:italic;*/
      /*font-size:medium;*/
    /*}*/
    /*.hideRow*/
    /*{*/
      /*background-color:White;*/
      /*cursor:pointer;*/
      /*border-width:thin;*/
      /*border-color:Blue;*/
      /*width: 100%;*/
      /*color:White;*/
      /*font-style:italic;*/
      /*font-size:medium;*/
    /*}*/
  </style>

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
              <div>

                <div class="col-sm-12">
                  Product id | name
                  <div class="form-group">
                    <div>
                      <input type="text" class="form-control" id="idName" name="idName">
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

                <div class="form-group">
                  <div class="col-sm-12">
                    <button class="btn btn-success" id="fSearch">Submit</button>
                    <input type="hidden" name="action" id="action" value="SEARCH">
                  </div>
                </div>

              </div>
            </div>
          </div>
        </div>

        <div class="col-md-9">
          <div class="x_panel" style="padding-left: 3px;">
            <div class="x_title">
              <h2>Products</h2>
              <div class="nav navbar-right panel_toolbox">
                <div class="btn-group" >
                  <button type="button" id="btn_add" class="btn btn-success">Add New</button>
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
              <table id="tb_product" width="100%">
                <thead>
                <tr>
                  <th width="15%">Product Id</th>
                  <th >Product name</th>
                  <th width="10%">Quality</th>
                  <th width="10%">Sell price</th>
                  <th width="10%">Function</th>
                </tr>
                </thead>
                <tbody>
                <%
                  if(products != null) {
                    for (int i=0; i< products.size(); i++) {
                      ProductDTO dto = products.get(i);
                %><tr id="row_<%=dto.getId()%>">
                  <td class="details-control" height="50"><%= dto.getId() %></td>
                  <td><%= dto.getName() %></td>
                  <td><%= dto.getQuantity() %></td>
                  <td><%= dto.getSelPrice() %></td>
                  <td style="display:flex">
                    <button type="button"
                            class="btn btn-primary btn_edit_product"
                            data-target=".bs-example-modal-lg" data-toggle="tooltip" title="Edit"><i
                            class="fa fa-edit"></i>
                    </button>
                    <button name="button" type="button"
                            class="btn btn-warning btn_view" data-toggle="tooltip"
                            title="View">
                      <i class="fa fa-minus"></i>
                    </button>
                  </td>
                </tr>
                <%} }%>
                </tbody>
              </table>
              <div style="display: inline;">

              <%
                if(numberPage != null){
                for(int i=0;i< Integer.parseInt(numberPage); i++){%>
                  <input type="button" class="btn_page" value="<%=i+1%>" />
              <%}}%>

              </div>
            </div>
          </div>
        </div>

      </div>
    </div>

    <div id="item_modal" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">

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

<script>
    $(document).ready(function (){
        $('.ui-pnotify').remove();
    });
</script>

<script>

    $('#date-create-from').datetimepicker({
        format: 'DD/MM/YYYY'
    });
    $('#date-create-to').datetimepicker({
        format: 'DD/MM/YYYY'
    });

    $(document).on('click', '.btn_page', function (event) {
        event.preventDefault();
        $.ajax({
            url: '<%= request.getContextPath() + UrlConstant.URL_ADMIN_PRODUCT%>',
            type: 'POST',
            data: {page: $(this).val(), action: "LOAD"},
            // on success do:
            success: function (response) {

                // console.log(response.type);
               // response = JSON.parse(response);
                if(response.type == true){
                    $("#tb_product tbody").empty();

                    response.products.forEach(function (item, index) {
                        $("#tb_product tbody").append(
                            "<tr id='row_" + item.id + "'>" +
                            "<td>" + item.id + "</td>" +
                            "<td>" + item.name + "</td>" +
                            "<td>" + item.quantity + "</td>" +
                            "<td>" + item.selPrice + "</td>" +
                            "<td style='display:flex'>" +
                            "<button type='button' class='btn btn-primary btn_edit_product' data-target='.bs-example-modal-lg' data-toggle='tooltip' title='Edit'>" +
                            "<i class='fa fa-edit'></i>" +
                            "</button>" +
                            "<button name='button' type='button' class='btn btn-warning btn_view' data-toggle='tooltip' title='View'>" +
                            "<i class='fa fa-minus'></i>" +
                            "</button>"+
                            "</td>" +
                            "</tr>"
                        );
                    });
                }


            }
        });
    });

    $(document).on('click', '#btn_add', function (event) {
        event.preventDefault();
        $.ajax({
            url: '<%= request.getContextPath() + UrlConstant.URL_ADMIN_ADD_PRODUCT%>',
            type: 'GET',
            // on success do:
            success: function (response) {
                // $('#item_modal .modal-header h4').text('Add Product');
                $('#item_modal .modal-content ').html(response);
                $('#item_modal').modal('show');
            }
        });
    });

    $(document).on('click', '.btn_view', function (event) {
        event.preventDefault();
        itemId = $(this).parent().parent().attr('id').split('_')[1];
        $.ajax({//define object from XML Http Request
            url: '<%= request.getContextPath() + UrlConstant.URL_ADMIN_PRODUCT%>', //action : go to Add Comment controller
            type: 'POST',
            data: {id: itemId},
            // on success do:
            success: function (response) {
                $('#item_modal .modal-content ').html(response);
                $('#item_modal').modal('show');
            }
        });
    });

    $(document).on('click', '.btn_edit_product', function (event) {
        event.preventDefault();
        itemId = $(this).parent().parent().attr('id').split('_')[1];
        $.ajax({//define object from XML Http Request
            url: '<%= request.getContextPath() + UrlConstant.URL_ADMIN_EDIT_PRODUCT%>', //action : go to Add Comment controller
            type: 'GET',
            data: {id: itemId},
            // on success do:
            success: function (response) {
                $('#item_modal .modal-content ').html(response);
                $('#item_modal').modal('show');
            }
        });
    });

    function AddNotify(title, msg, type) {
        new PNotify( {
                title:title, type: type, text:msg, nonblock: {
                    nonblock: !0
                } , addclass:"dark", styling:"bootstrap3",delay: 2000
                ,hide: true
            }
        );
    }

    $(document).on('click', '#fSearch', function (e) {

        e.preventDefault();
        form = $(this);

        searchProductUrl = '<%=request.getContextPath() + UrlConstant.URL_ADMIN_PRODUCT%>';
        requestMethod = form.attr('method');
        requestData = $('#idName').serialize() + '&action=SEARCH';

        $.ajax({
            url: searchProductUrl,
            type: "POST",
            data: requestData,
            dataType: 'json',
            beforeSend: function(){

            },
            success: function(response) {
                if(response.type == false) {

                } else { // show data when success
                    $("#tb_product tbody").empty();

                    response.products.forEach(function (item, index) {
                        $("#tb_product tbody").append(
                            "<tr id='row_" + item.id + "'>" +
                            "<td>" + item.id + "</td>" +
                            "<td>" + item.name + "</td>" +
                            "<td>" + item.quantity + "</td>" +
                            "<td>" + item.selPrice + "</td>" +
                            "<td style='display:flex'>" +
                              "<button type='button' class='btn btn-primary btn_edit_product' data-target='.bs-example-modal-lg' data-toggle='tooltip' title='Edit'>" +
                              "<i class='fa fa-edit'></i>" +
                              "</button>" +
                              "<button name='button' type='button' class='btn btn-warning btn_view' data-toggle='tooltip' title='View'>" +
                              "<i class='fa fa-minus'></i>" +
                              "</button>"+
                            "</td>" +
                            "</tr>"
                        );
                    });
                }
            }
        });

    });


    $(document).on('submit', '#fEdit', function (e) {

        e.preventDefault();
        form = $(this);

        addCategoryUrl = '<%=request.getContextPath() + UrlConstant.URL_ADMIN_EDIT_PRODUCT%>';
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
                        // $("#error-cat-name").addClass(response.cError);
                        // $("#error-cat-name").append(response.eCatName);
                    } else { // show data when fail
                        AddNotify("error", response.msg, "error");
                    }
                } else { // show data when success
                    form.find("input[type=text], textarea").val("");
                    $('#item_modal').modal('hide');
                    AddNotify("Edit Product", response.msg, "success");
                }
            }
        });

    });

    $(document).on('submit', '#fAdd', function (e) {

        e.preventDefault();
        form = $(this);

        addCategoryUrl = '<%=request.getContextPath() + UrlConstant.URL_ADMIN_ADD_PRODUCT%>';
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
                      // $("#error-cat-name").addClass(response.cError);
                      // $("#error-cat-name").append(response.eCatName);
                  } else { // show data when fail
                      AddNotify("error", response.msg, "error");
                  }
              } else { // show data when success
                  form.find("input[type=text], textarea").val("");
                  $('#item_modal').modal('hide');
                  AddNotify("Add Product", response.msg, "success");
              }
            }
        });

    });


    <%--var trindex = 0;--%>
    <%--$('#tb_product tr').click(function() {--%>
      <%--if ($(this).find("td:first").length > 0) {--%>
        <%--productId = $(this).find("tr").context.id.split('_')[1];--%>

        <%--$.ajax({--%>
            <%--url: '<%= request.getContextPath() + UrlConstant.URL_ADMIN_PRODUCT%>',--%>
            <%--type: 'POST',--%>
            <%--data: {id: productId},--%>
            <%--// on success do:--%>
            <%--success: function (response) {--%>

                <%--console.log(response);--%>


            <%--}--%>
        <%--});--%>


          <%--trindex++; //row index icreament to assign new row id everytime--%>
          <%--//create a row with td colspan 3 to show product description--%>
          <%--var row =--%>
              <%--'><td class="currRow" colspan="3" >' +--%>
              <%--'<div id="did">' +--%>
              <%--'<img id="imagepath" src="" style="height: 81px; width: 104px" />  ' +--%>
              <%--'Description :<span id="des">sd</span><p>Cost :<span id="cost">sd</span></p>' +--%>
              <%--'</div>' +--%>
              <%--'</td></tr>';--%>

          <%--//adding anitmation to row--%>
          <%--var newRow = $("<tr width ='100%' id=tr" + trindex + row).animate({--%>
              <%--height: "140px",--%>
              <%--opacity: 1,--%>
          <%--}, 500);--%>

          <%--//adding row to existing table--%>
          <%--$(this).after(newRow);--%>

          <%--//getting previous created row--%>
          <%--var rowName = "tr" + parseInt(trindex - 1);--%>

          <%--//reomving previous created row from table with animation--%>
          <%--$("#" + rowName).find('td').removeClass('currRow').addClass('hideRow');--%>
          <%--$("#" + rowName).animate({--%>
              <%--height: "0px",--%>
              <%--opacity: 1,--%>
          <%--}, 500, function () {--%>
              <%--$("#" + rowName).remove();--%>
          <%--});--%>


      <%--}--%>
    <%--});--%>


</script>
</body>
</html>
