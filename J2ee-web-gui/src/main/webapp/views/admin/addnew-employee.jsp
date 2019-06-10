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
    <link href="${pageContext.request.contextPath}/resources/admin/build/css/custom.min.css" rel="stylesheet">
    <!-- PNotify -->
    <link href="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.buttons.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/admin/vendors/pnotify/dist/pnotify.nonblock.css"
          rel="stylesheet">

</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">

        <jsp:include page="slide-bar.jsp"></jsp:include>


        <div class="right_col" role="main">
            <div class=x_panel">
                <div class="x_title">
                    <h2>Add New Employee </h2>
                    <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="row x_content">
                    <form id="submit_form">
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="row" style="padding:10px">
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="emp-id">Employee
                                        ID
                                    </label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <input type="text" id="emp-id" disabled="disabled"
                                               class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                            </div>
                            <div class="row" style="padding:10px">

                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">First
                                        Name
                                    </label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <input type="text" id="first-name"
                                               class="form-control col-md-7 col-xs-12" required="required">
                                    </div>
                                </div>
                            </div>
                            <div class="row" style="padding:10px">

                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Last
                                        Name
                                    </label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <input type="text" id="last-name" name="last-name"
                                               class="form-control col-md-7 col-xs-12" required="required">
                                    </div>
                                </div>
                            </div>
                            <div class="row" style="padding:10px">

                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Gender</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <p>
                                            Male:
                                            <input type="radio" value="M" name="gender" id="gender_male" checked/> Female:
                                            <input type="radio" name="gender" value="F" id="gender_female"/>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="row" style="padding:10px">

                                <div class="form-group">
                                    <label for="user-name" class="control-label col-md-6 col-sm-6 col-xs-12">User
                                        Name</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input id="user-name" class="form-control col-md-7 col-xs-12" type="text"
                                               name="user-name" required="required">
                                    </div>
                                </div>
                            </div>
                            <div class="row" style="padding:10px">

                                <div class="form-group">
                                    <label for="user-name" class="control-label col-md-6 col-sm-6 col-xs-12">Password
                                        </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input id="pass-word" type="password" class="form-control col-md-7 col-xs-12" type="text"
                                               name="user-name" required="required">
                                    </div>
                                </div>
                            </div>
                            <div class="row" style="padding:10px">
                                <div class="form-group">
                                    <label class="control-label col-md-6 col-sm-6 col-xs-12" for="date-updated">Date
                                        Created
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input disabled="disabled" type="text" id="date-updated" name="date-updated"
                                               required="required"
                                               class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                            </div>
                            <div class="row" style="padding:10px">
                                <div class="form-group">
                                    <label class="control-label col-md-6 col-sm-6 col-xs-12">Date of
                                        birth
                                    </label>
                                    <div class="input-group date col-md-6 col-sm-6 col-xs-12" id="date-create-to">
                                        <input type="text" class="form-control" id="date-of-birth" required="required">
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar"></span>
                                          </span>
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
                                            <%
                                                ArrayList<FunctionRole> listFunction = (ArrayList<FunctionRole>) request.getAttribute("listFunction");

                                                for(int i=0;i<listFunction.size();i++) {
                                                    FunctionRole fr =listFunction.get(i);
                                            %>
                                            <option value="<%=i+1 %>"><%=fr.getRole() %></option>
                                            <%} %>
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
                        <div class="form-group">
                            <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3"
                                 style="display:flex;justify-content:flex-end">
                                <button class="btn btn-primary" type="reset">Reset</button>
                                <button type="submit" class="btn btn-success">Submit</button>
                            </div>
                        </div>
                    </form>
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
        $(document).ready(function () {
            $('.ui-pnotify').remove();
        });
    </script>

    <script>
        var name_role = [];
        <%
            for(int i=0;i<listFunction.size();i++){
              %>
        name_role.push("<%out.print(listFunction.get(i).getRole());%>");
        <%}%>
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

        $('#date-create-from').datetimepicker({
            format: 'DD/MM/YYYY'
        });
        $('#date-create-to').datetimepicker({
            format: 'DD/MM/YYYY'
        });
        $("#submit_form").submit(function (e) {
            e.preventDefault();
            var gender=0;
            if ($("#gender_male").prop("checked")) {
                gender=1;
            }
            var roles=[]
            $('#table-role > option').each(function() {
                roles.push($(this).val());
            });
            if(roles.length==0){
                new PNotify( {
                        title:"Notification", type:"info", text:"Your function is empty", nonblock: {
                            nonblock: !0
                        } , addclass:"dark", styling:"bootstrap3",delay: 2000
                        ,hide: true
                    }
                );
                return;
            }
            $.ajax({
                url: '<%=VariableConstant.ROOT_PATH%>' + "/admin/addnew/employee",
                type: "POST",
                data: {password:$('#pass-word').val(),firstname:$('#first-name').val(),lastname:$('#last-name').val(),username:$('#user-name').val(),
                    gender:gender,date_of_birth:$('#date-of-birth').val(), roles:roles.join("-")},
                dataType: 'json',
                beforeSend: function () {
                    new PNotify( {
                            title:"Add Employee", type:"info", text:"Your actions is being executed", nonblock: {
                                nonblock: !0
                            } , addclass:"dark", styling:"bootstrap3",delay: 2000
                            ,hide: true
                        }
                    );

                },
                success: function (response) {
                    console.log(response);
                    if (response!="0") {
                        new PNotify( {
                                title:"Add Employee", type:"error", text:"OK", nonblock: {
                                    nonblock: !0
                                } , addclass:"dark", styling:"bootstrap3",delay: 2000
                                ,hide: true
                            }
                        );
                    } else {
                        new PNotify( {
                                title:"Add Employee", type:"success", text:"Your username is already taken", nonblock: {
                                    nonblock: !0
                                } , addclass:"dark", styling:"bootstrap3",delay: 2000
                                ,hide: true
                            }
                        );
                    }
                }
            });
        });
    </script>
</body>
</html>
