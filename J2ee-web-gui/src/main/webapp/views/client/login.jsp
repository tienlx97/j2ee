<!doctype html>
<html class="no-js" lang="en">


<!-- Mirrored from demo.hasthemes.com/autima-v2/autima/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 06 Apr 2019 13:59:05 GMT -->
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Autima - login</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/client/img/favicon.ico">
    
    <!-- CSS 
    ========================= -->

    <!-- Plugins CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/client/css/plugins.css">
    
    <!-- Main Style CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/client/css/style.css">

</head>

<body>

    <!--header area start-->
    <jsp:include page="Header.jsp"></jsp:include>
    <!--header area end-->

    <!--breadcrumbs area start-->
    <div class="breadcrumbs_area">
        <div class="container">   
            <div class="row">
                <div class="col-12">
                    <div class="breadcrumb_content">
                        <ul>
                            <li><a href="index.html">home</a></li>
                            <li>My account</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>         
    </div>
    <!--breadcrumbs area end-->
    
    
    <!-- customer login start -->
    <div class="customer_login mt-32">
        <div class="container">
            <div class="row">
               <!--login area start-->
                <div class="col-lg-6 col-md-6">
                    <div class="account_form">
                        <h2>login</h2>
                        <form action="login" method="post">
                            <p>   
                                <label>Username or email <span>*</span></label>
                                <input type="text" name="username" id="username">
                             </p>
                             <p>   
                                <label>Passwords <span>*</span></label>
                                <input type="password" name="password" id="password">
                             </p>   
                            <div class="login_submit">
                               <a href="#">Lost your password?</a>
                                <label for="remember">
                                    <input id="remember" type="checkbox">
                                    Remember me
                                </label>
                                <button type="submit">login</button>
                                
                            </div>

                        </form>
                     </div>    
                </div>
                <!--login area start-->

                <!--register area start-->
                <div class="col-lg-6 col-md-6">
                    <div class="account_form register">
                        <h2>Register</h2>
                        <form action="#">
                            <p>   
                                <label>Email address  <span>*</span></label>
                                <input type="text">
                             </p>
                             <p>   
                                <label>Passwords <span>*</span></label>
                                <input type="password">
                             </p>
                            <div class="login_submit">
                                <button type="submit">Register</button>
                            </div>
                        </form>
                    </div>    
                </div>
                <!--register area end-->
            </div>
        </div>    
    </div>
    <!-- customer login end -->

    <!--footer area start-->
    <jsp:include page="Footer.jsp"></jsp:include>
    <!--footer area end-->
<!-- JS
============================================ -->

<!-- Plugins JS -->
<script src="${pageContext.request.contextPath}/resources/assets/js/plugins.js"></script>

<!-- Main JS -->
<script src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>



</body>

</html>