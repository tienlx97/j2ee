<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="core.EmployeeDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="both.ServerLogDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/tablib.jsp"%>
<%@ page import="Constant.VariableConstant" %>

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
    <link href="${pageContext.request.contextPath}/resources/admin/build/css/custom.min.css" rel="stylesheet">   <!-- PNotify -->
    <link href="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.nonblock.css" rel="stylesheet">

</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">

        <jsp:include page="slide-bar.jsp"></jsp:include>


        <div class="right_col" role="main">
            <div class="row">

                <div class="col-md-3">
                    <div class="row">
                        <div class="x_panel" style="padding-left: 3px;">
                            <div class="x_title">
                                <h2>Search Employee </h2>
                                <ul class="nav navbar-right panel_toolbox" >
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <form >
                                    <div class="col-sm-12">
                                        Employee name
                                        <div class="form-group">
                                            <div>
                                                <input type="text" class="form-control" id="search_name">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-12">
                                        Date from
                                        <div class="form-group">
                                            <div class="input-group date" id="date-create-from" >
                                                <input type="text" class="form-control" id="date_from">
                                                <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                      </span>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-12">
                                        Date to
                                        <div class="form-group">
                                            <div class="input-group date" id="date-create-to" >
                                                <input type="text" class="form-control" id="date_to">
                                                <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"></span>
                                              </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <button class="btn btn-primary" type="reset">Reset</button>
                                            <button type="submit" class="btn btn-success" id="search_form">Submit</button>
                                        </div>
                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="col-md-9">
                    <div class="x_panel" style="padding-left: 3px;">
                        <div class="x_title">
                            <h2>Detail Employee</h2>

                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <table class="table table-bordered" id="table_employee_tracking" >
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Id</th>
                                    <th>User</th>
                                    <th>Type</th>
                                    <th>Action</th>
                                    <th>Method</th>
                                    <th>Parameter</th>
                                    <th>Time</th>
                                </tr>
                                </thead>

                                <tbody>
                                <%
                                    // retrieve your list from the request, with casting
                                    ArrayList<ServerLogDTO> listEmployee = (ArrayList<ServerLogDTO>) request.getAttribute("listEmployeeTracking");

                                    for(int i = 0; i < listEmployee.size(); i++) {
                                        ServerLogDTO employee = new ServerLogDTO();
                                        employee = listEmployee.get(i);

                                %>
                                <tr>
                                    <td></td>
                                    <td><%=employee.getId()%></td>
                                    <td><%=employee.getUser()%></td>
                                    <td><%=employee.getType()%></td>
                                    <td><%=employee.getAction()%></td>
                                    <td><%=employee.getMethod()%></td>
                                    <td><%=employee.getParameter()%></td>
                                    <td><%=employee.getTime()%></td>

                                <%

                                    };
                                %>

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

<script src="${pageContext.request.contextPath}/resources/admin/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendors/moment/min/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- PNotify -->
<script src="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.buttons.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.nonblock.js"></script>
<!-- Custom Theme Scripts -->
<script src="${pageContext.request.contextPath}/resources/admin/build/js/custom.min.js"></script>
<script>

    $('#date-create-from').datetimepicker({
        format: 'DD/MM/YYYY'
    });
    $('#date-create-to').datetimepicker({
        format: 'DD/MM/YYYY'
    });

    $('#search_form').click(function(e) {
        e.preventDefault();
        var name=$("#search_name").val();
        var dateto=$("#date_to").val();
        var datefrom=$("#date_from").val();
        $.ajax({
            url: '<%=VariableConstant.ROOT_PATH%>' + "admin/search/tracking_employee",
            type: "POST",
            data: {name:name,dateto:dateto,datefrom:datefrom},
            dataType: 'json',
            success: function (response) {
                new PNotify( {
                        title:"Notification", type:"success", text:response.length+ " returned results", nonblock: {
                            nonblock: !0
                        } , addclass:"dark", styling:"bootstrap3",delay: 2000
                        ,hide: true
                    }
                );
                $("#table_employee_tracking tbody").empty();
                for (var i = 0; i < response.length; i++) {
                    $('#table_employee_tracking').append('<tr><td></td><td>' + response[i]['id'] + '</td><td>' +
                        response[i]['user'] + '</td><td>' +
                        response[i]['type'] + '</td><td>' +
                        response[i]['action'] + '</td><td>' +
                        response[i]['method'] + '</td><td>'+
                         response[i]['parameter'] + '</td><td>'+
                         response[i]['time'] + '</td>' + '</tr>');
                }
                $("#table_employee_tracking").dataTable();
            }
        });
    });



</script>
</body>
</html>
