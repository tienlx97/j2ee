<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Constant.UrlConstant" %>
<%@ page import="core.EmployeeDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="both.FunctionRole" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/tablib.jsp" %>
<%@page isELIgnored="false" %>
<%@ page import="Constant.VariableConstant" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="images/favicon.ico" type="image/ico"/>

    <title>My Fashion Shop! | </title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/admin/vendors/bootstrap/dist/css/bootstrap.min.css"
          rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/resources/admin/vendors/font-awesome/css/font-awesome.min.css"
          rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath}/resources/admin/build/css/custom.min.css" rel="stylesheet">
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

                <div class="col-md-4">
                    <div class="row">
                        <div class="x_panel" style="padding-left: 3px;">
                            <div class="x_title">
                                <h2>Search Employee </h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <form id="search_form">

                                    <div class="col-sm-12">
                                        Employee id
                                        <div class="form-group">
                                            <div>
                                                <input type="text" class="form-control" id="search_id">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-12">
                                        Employee name
                                        <div class="form-group">
                                            <div>
                                                <input type="text" class="form-control" id="search_name">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-12">
                                        Date create from
                                        <div class="form-group">
                                            <div class="input-group date" id="date-create-from">
                                                <input type="text" class="form-control" id="date_from">
                                                <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                      </span>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-12">
                                        Date create to
                                        <div class="form-group">
                                            <div class="input-group date" id="date-create-to">
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
                                            <button type="submit" class="btn btn-success" id="search_form_submit">
                                                Submit
                                            </button>
                                        </div>
                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Roles Table</h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <ul class="list-unstyled timeline">
                                    <c:forEach items="${listFunction}" var="function">
                                        <li>
                                            <div class="block">
                                                <div class="tags">
                                                    <div class="tag">
                                                        <span>Role ${function.id}</span>
                                                    </div>
                                                </div>

                                                <div class="block_content">
                                                    <h2 class="title">
                                                        <h2>${function.role}</h2>
                                                    </h2>
                                                    <p class="excerpt">${function.description}
                                                    </p>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>

                                </ul>

                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-8">
                    <div class="x_panel" style="padding-left: 3px;">
                        <div class="x_title">
                            <h2>Detail Employee</h2>

                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <table class="table table-bordered" id="table_view">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Id</th>
                                    <th>User Name</th>
                                    <th>Last Name</th>
                                    <th>First Name</th>
                                    <th>Gender</th>
                                    <th>Date created</th>
                                    <th>Date updated</th>
                                    <th>Function</th>
                                </tr>
                                </thead>

                                <tbody>
                                <%
                                    // retrieve your list from the request, with casting
                                    ArrayList<EmployeeDTO> listEmployee = (ArrayList<EmployeeDTO>) request.getAttribute("listEmployee");
                                    ArrayList<FunctionRole> listFunction = (ArrayList<FunctionRole>) request.getAttribute("listFunction");

                                    for (int i = 0; i < listEmployee.size(); i++) {
                                        EmployeeDTO employee = new EmployeeDTO();
                                        employee = listEmployee.get(i);

                                %>
                                <tr style="<%=employee.getStatusColor()%>">
                                    <td></td>
                                    <td><%=employee.getId()%>
                                    </td>
                                    <td><%=employee.getUsername()%>
                                    </td>
                                    <td><%=employee.getLastname()%>
                                    </td>
                                    <td><%=employee.getFirstname()%>
                                    </td>
                                    <td><%=employee.convertGender()%>
                                    </td>
                                    <td><%=employee.getDate_created()%>
                                    </td>
                                    <td><%=employee.getDate_updated()%>
                                    </td>
                                    <td>
                                        <button id="<%=employee.getId()%>" name="button" class="btn btn-info btn_role">
                                            Roles
                                        </button>
                                    </td>
                                </tr>
                                <%
                                    for (int j = 0; j < employee.getRoles().size(); j = j + 2) {

                                %>
                                <tr class="collapseme<%=employee.getId()%> collapse out"
                                    style="<%=employee.getStatusColor()%>">
                                    <td colspan="5" data-toggle="tooltip"
                                        title="<%=listFunction.get(Integer.parseInt(employee.getRoles().get(j))).getDescription()%>"><%=listFunction.get(Integer.parseInt(employee.getRoles().get(j))).getRole()%>
                                    </td>

                                    <%
                                        if ((j + 1) < employee.getRoles().size()) {
                                    %>

                                    <td colspan="4" data-toggle="tooltip"
                                        title="<%=listFunction.get(Integer.parseInt(employee.getRoles().get(j+1))).getDescription()%>"><%=listFunction.get(Integer.parseInt(employee.getRoles().get(j + 1))).getRole()%>
                                    </td>
                                    <% } else {
                                    %>
                                    <td colspan="4"></td>

                                    <% }
                                        ;
                                    %>

                                </tr>
                                <%
                                        }
                                    }
                                    ;
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


<script src="${pageContext.request.contextPath}/resources/admin/vendors/moment/min/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- PNotify -->
<script src="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.buttons.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.nonblock.js"></script>
<!-- Custom Theme Scripts -->
<script src="${pageContext.request.contextPath}/resources/admin/build/js/custom.min.js"></script>
<script>
    var name_role = [];
    <%
        for(int i=0;i<listFunction.size();i++){
          %>
    name_role.push("<%out.print(listFunction.get(i).getRole());%>");
    <%}%>
    $('#date-create-from').datetimepicker({
        format: 'DD/MM/YYYY'
    });
    $('#date-create-to').datetimepicker({
        format: 'DD/MM/YYYY'
    });

    $('.btn_role').click(function () {
        var id = ".collapseme" + $(this).attr('id');
        console.log(id);
        if ($(id).hasClass("out")) {
            $(id).addClass("in");
            $(id).removeClass("out");
        } else {
            $(id).addClass("out");
            $(id).removeClass("in");
        }
    });

    $('#search_form_submit').click(function (e) {
        e.preventDefault();
        var id = $("#search_id").val();

        var name = $("#search_name").val();
        var dateto = $("#date_to").val();
        var datefrom = $("#date_from").val();
        console.log(datefrom);
        $.ajax({
            url: '<%=VariableConstant.ROOT_PATH%>' + "admin/search/employee",
            type: "POST",
            data: {id: id, name: name, dateto: dateto, datefrom: datefrom},
            dataType: 'json',
            success: function (response) {
                new PNotify( {
                        title:"Notification", type:"success", text:response.length+ " returned results", nonblock: {
                            nonblock: !0
                        } , addclass:"dark", styling:"bootstrap3",delay: 2000
                        ,hide: true
                    }
                );
                console.log(response);
                $("#table_view tbody").empty();
                for (var i = 0; i < response.length; i++) {
                    var gender = 'MALE'
                    if (response[i]['gender'] == '0') {
                        gender = 'FEMALE'
                    }
                    $('#table_view').append('<tr><td></td><td>' + response[i]['id'] + '</td><td>' +
                        response[i]['username'] + '</td><td>' +
                        response[i]['lastname'] + '</td><td>' +
                        response[i]['firstname'] + '</td><td>' +
                        gender + '</td><td>' +
                        response[i]['date_created'] + '</td><td>' +
                        response[i]['date_updated'] + '</td>' +
                        '<td> <button id=\"' + response[i]['id'] +
                        '\" name=\"button\" class=\"btn btn-info btn_role\">Roles</button></td></tr>');
                    var roles_row = '';
                    for (var j = 0; j < response[i]['roles'].length; j = j + 2) {
                        roles_row = roles_row + '<tr class=\"collapseme' + response[i]['id'] + ' collapse in\" >' +
                            '<td colspan=\"5\" data-toggle=\"tooltip\" title=\"' + '\" >' + name_role[parseInt(response[i]['roles'][j])]
                            + '</td>';

                        if ((j + 1) < response[i]['roles'].length)
                            roles_row = roles_row + '<td colspan=\"4\"  >' + name_role[parseInt(response[i]['roles'][j])] + '</td></tr>';
                        else
                            roles_row = roles_row + '<td colspan=\"4\"></td></tr>';
                    }
                    $('#table_view').append(roles_row);
                }
            }
        });
    })
    ;

</script>
</body>
</html>
