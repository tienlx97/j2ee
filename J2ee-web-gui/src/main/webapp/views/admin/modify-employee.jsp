<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Constant.UrlConstant" %>
<%@ page import="core.EmployeeDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="both.FunctionRole" %>
<%@ page import="Constant.VariableConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/tablib.jsp" %>
<%@page isELIgnored="false" %>
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
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <form>

                                    <div class="col-sm-12">
                                        Employee id
                                        <div class="form-group">
                                            <div>
                                                <input type="text" class="form-control">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-12">
                                        Employee name
                                        <div class="form-group">
                                            <div>
                                                <input type="text" class="form-control">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-12">
                                        Date create from
                                        <div class="form-group">
                                            <div class="input-group date" id="date-create-from">
                                                <input type="text" class="form-control">
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
                                                <input type="text" class="form-control">
                                                <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                      </span>
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

                </div>

                <div class="col-md-9">
                    <div class="x_panel" style="padding-left: 3px;">
                        <div class="x_title">
                            <h2>Detail Employee</h2>

                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <table class="table">
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
                                    <td style="display:flex">

                                        <%
                                            if (employee.getStatus() == 1) {
                                        %>
                                        <button id="btn_role_<%=employee.getId()%>" name="button"
                                                class="btn btn-primary btn_role" data-toggle="tooltip"
                                                title="View Functions">
                                            <i class="fa fa-list-alt"></i>
                                        </button>
                                        <button id="btn_edit_<%=employee.getId()%>" type="button"
                                                class="btn btn-primary btn_edit"
                                                data-target=".bs-example-modal-lg" data-toggle="tooltip" title="Edit"><i
                                                class="fa fa-edit"></i>
                                        </button>
                                        <button name="button" id="btn_reset_<%=employee.getId()%>" type="button"
                                                class="btn btn-secondary btn_reset" data-toggle="tooltip"
                                                title="Reset password">
                                            <i class="fa fa-mail-reply"></i>
                                        </button>
                                        <button name="button" id="btn_disable_<%=employee.getId()%>" type="button"
                                                class="btn btn-warning btn_disable" data-toggle="tooltip"
                                                title="Disable">
                                            <i class="fa fa-minus"></i>
                                        </button>
                                        <% } else {
                                        %>
                                        <button id="btn_role_<%=employee.getId()%>" name="button" disabled
                                                class="btn btn-primary btn_role" data-toggle="tooltip"
                                                title="View Functions">
                                            <i class="fa fa-list-alt"></i>
                                        </button>
                                        <button id="btn_edit_<%=employee.getId()%>" type="button" disabled
                                                class="btn btn-primary btn_edit"
                                                data-target=".bs-example-modal-lg" data-toggle="tooltip" title="Edit"><i
                                                class="fa fa-edit"></i>
                                        </button>
                                        <button name="button" id="btn_active_<%=employee.getId()%>" type="button"
                                                class="btn btn-success btn_active" data-toggle="tooltip" title="Active">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                        <button name="button" id="btn_remove_<%=employee.getId()%>" type="button"
                                                class="btn btn-danger btn_remove" data-toggle="tooltip" title="Remove">
                                            <i class="fa fa-remove"></i>
                                        </button>
                                        <%
                                            }
                                        %>


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
    <div id="modal_password" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">×</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel2">Notification</h4>
                </div>
                <div class="modal-body">
                    <h4>Your new password</h4>
                    <input style="font-size:20px" type="text" id="password_text">
                    </input>
<%--                    <input style="font-size:20px" id="password_text" disabled="disabled" type="text"></input>--%>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="copytoclipboard()">Copy password</button>
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
                    <h4 class="modal-title" id="myModalLabel">Edit form</h4>
                </div>
                <div class="modal-body">
                    <div class="x_content">
                        <br/>
                        <div method="post" class="form-horizontal form-label-left input_mask" id="edit_form">

                            <div class="row">
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="emp-id">Employee
                                            ID
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="text" id="emp-id" disabled="disabled"
                                                   class="form-control col-md-7 col-xs-12">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">First
                                            Name
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="text" id="first-name"
                                                   class="form-control col-md-7 col-xs-12">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Last
                                            Name
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="text" id="last-name" name="last-name"
                                                   class="form-control col-md-7 col-xs-12">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Gender</label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <p>
                                                Male:
                                                <input type="radio" value="M" name="gender" id="gender_male"/> Female:
                                                <input type="radio" name="gender" value="F" id="gender_female"/>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <div class="form-group">
                                        <label for="user-name" class="control-label col-md-3 col-sm-3 col-xs-12">User
                                            Name</label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input id="user-name" class="form-control col-md-7 col-xs-12" type="text"
                                                   name="user-name">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="date-created">Date
                                            Created
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input disabled="disabled" type="text" id="date-created" required="required"
                                                   class="form-control col-md-7 col-xs-12" name="date-created">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="date-updated">Date
                                            Updated
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input disabled="disabled" type="text" id="date-updated" name="date-updated"
                                                   required="required"
                                                   class="form-control col-md-7 col-xs-12">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="date-of-birth" class="control-label col-md-3 col-sm-3 col-xs-12">Date
                                            of birth</label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input id="date-of-birth" class="form-control col-md-7 col-xs-12"
                                                   type="text"
                                                   name="date-of-birth">
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="row" style="padding: 1em">
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-2">Functions</label>
                                        <div class="col-md-7 col-sm-7 col-xs-10">
                                            <select class="select2_single form-control" tabindex="-1"
                                                    id="function-list">

                                            </select>
                                        </div>
                                        <button type="button" class="btn btn-success"
                                                class="col-md-2 col-sm-2 col-xs-12" id="add_role"> Add
                                        </button>
                                    </div>
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-2">Table Role</label>
                                        <div class="col-md-7 col-sm-7 col-xs-10">
                                            <select class="select2_multiple form-control" multiple="multiple"
                                                    id="table-role">

                                            </select>
                                        </div>
                                        <button type="button" class="btn btn-danger" class="col-md-2 col-sm-2 col-xs-12"
                                                id="del_role"> Del
                                        </button>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="ln_solid"></div>
                        <div class="form-group">
                            <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3"
                                 style="display:flex;justify-content:flex-end">
                                <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
                                <button class="btn btn-primary" type="reset" id="btn_reset">Reset</button>
                                <button type="submit" class="btn btn-success">Submit</button>
                            </div>
                        </div>


                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <%--                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
                    <%--                    <button class="btn btn-default" type="reset">Reset</button>--%>
                    <%--                    <button type="submit" class="btn btn-primary">Save changes</button>--%>
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
<!-- PNotify -->
<script src="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.buttons.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.nonblock.js"></script>
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
        var id = ".collapseme" + $(this).attr('id').split('_')[2];
        if ($(id).hasClass("out")) {
            $(id).addClass("in");
            $(id).removeClass("out");
        } else {
            $(id).addClass("out");
            $(id).removeClass("in");
        }
    });

    function copytoclipboard() {
        var copyText = document.getElementById("password_text");
        console.log(copyText);
        copyText.select();
        document.execCommand("copy");
        $("#modal_password").modal("hide");
        new PNotify( {
                title:"Password Copied", type:"info", text:"Copied the password: "+copyText.value, nonblock: {
                    nonblock: !0
                } , addclass:"dark", styling:"bootstrap3",delay: 2000
            ,hide: true
            }
        );
    }
    $('.btn_edit').click(function () {
        var id = $(this).attr('id').split('_')[2];

        $.ajax({
            url: '<%=VariableConstant.ROOT_PATH%>' + '/admin/edit_info_employee/' + id,
            success: function (response) {
                $('#emp-id').val(response['id']);
                $('#first-name').val(response['firstname']);
                $('#last-name').val(response['lastname']);
                $('#user-name').val(response['username']);
                if (response['gender'] == 1) {
                    $('#gender_male').prop("checked", true);
                } else {
                    $('#gender_female').prop("checked", true);
                }
                $('#date-created').val(response['date_created']);
                $('#date-updated').val(response['date_updated']);
                $('#date-of-birth').val(response['dob']);
                var roles = response['roles'];
                var temp_role = [0, 0, 0, 0, 0];
                for (var i = 0; i < roles.length; i++) {
                    temp_role[roles[i] - 1] = 1;
                    $('#table-role').append($('<option>', {
                        value: roles[i],
                        text: name_role[roles[i] - 1]
                    }));
                }
                for (var i = 0; i < temp_role.length; i++) {
                    if (temp_role[i] == 0) {
                        $('#function-list').append($('<option>', {
                            value: i + 1,
                            text: name_role[i]
                        }));
                    }
                }
                $('#modal_edit').modal();
            }
        });
    });
    $('#btn_reset').click(function () {
        var id = $('#emp-id').val();
        $.ajax({
            url: '<%=VariableConstant.ROOT_PATH%>' + '/admin/edit_info_employee/' + id,
            success: function (response) {
                $('#first-name').val(response['firstname']);
                $('#last-name').val(response['lastname']);
                $('#user-name').val(response['username']);
                if (response['gender'] == 1) {
                    $('#gender_male').prop("checked", true);
                } else {
                    $('#gender_female').prop("checked", true);
                }
                $('#date-created').val(response['date_created']);
                $('#date-updated').val(response['date_updated']);
                $('#date-of-birth').val(response['dob']);
                var roles = response['roles'];
                for (var i = 0; i < roles.length; i++) {
                    $('#table-role').append($('<option>', {
                        value: roles[i],
                        text: name_role[roles[i]]
                    }));
                }
            }
        });
    });

    $('#add_role').click(function () {
        $('#table-role').append($('<option>', {
            value: $('#function-list ').find(":selected").val(),
            text: $('#function-list ').find(":selected").text()
        }));
        $("#function-list option:selected").remove();
    });
    $('#del_role').click(function () {
        $("#table-role option:selected").remove();
        $('#function-list').empty();

        var roles = [];
        $("#table-role option").each(function () {
            roles.push(parseInt($(this).val()));
        });
        for (var i = 0; i < name_role.length; i++) {
            if (!roles.includes(i + 1)) {
                $('#function-list').append($('<option>', {
                    value: i + 1,
                    text: name_role[i]
                }));
            }
        }
    });

    $('.btn_reset').click(function () {
        var id = $(this).attr('id').split('_')[2];
        $.ajax({
            type: "POST",
            url: '<%=VariableConstant.ROOT_PATH%>' + "admin/custom_action/reset",
            data: {id: id},
            success: function (response) {
                $('#password_text').val(response);
                $('#modal_password').modal();
            }
        });
        location.reload();

    });

    $('.btn_disable').click(function () {
        var id = $(this).attr('id').split('_')[2];
        $.ajax({
            type: "POST",
            url: '<%=VariableConstant.ROOT_PATH%>' + "admin/custom_action/disable",
            data: {id: id},
            success: function (response) {
                console.log(response)
            }
        });
        location.reload();

    });

    $('.btn_active').click(function () {
        var id = $(this).attr('id').split('_')[2];
        $.ajax({
            type: "POST",
            url: ' <%=VariableConstant.ROOT_PATH%>' + "admin/custom_action/active",
            data: {id: id},
            success: function (response) {
                console.log(response)
            }
        });
        location.reload();

    });

    $('.btn_remove').click(function () {
        var id = $(this).attr('id').split('_')[2];
        $.ajax({
            type: "POST",
            url: '<%=VariableConstant.ROOT_PATH%>' + 'admin/custom_action/remove',
            data: {id: id},
            success: function (response) {
                console.log(response)
            }
        });

    });
    $("#edit_form").submit(function (e) {
        e.preventDefault();
        form = $(this);
        requestUrl = "/admin/edit_info_employee/";
        requestMethod = form.attr('method');
        requestData = form.serialize();
        console.log(requestUrl);
        console.log(requestMethod);
        console.log(requestData);
        $.ajax({
            url: requestUrl,
            type: requestMethod,
            data: requestData,
            dataType: 'json',
            beforeSend: function () {
            },
            success: function (response) {
                if (response.errors.length > 0) {
                    console.log("error");
                } else if (response.success !== null) {
                    console.log(response.data);
                } else {
                    console.log(response.data);

                }
            }
        });
    });
</script>
</body>
</html>
