<%@include file="../../common/tablib.jsp"%>
<%@page isELIgnored="false" %>
<!doctype html>
<html class="no-js" lang="en">


<!-- Mirrored from demo.hasthemes.com/autima-v2/autima/cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 06 Apr 2019 13:58:21 GMT -->
<head>
  <meta charset="utf-8">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Autima - cart page</title>
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

<jsp:include page="Header.jsp"></jsp:include>



<!--shopping cart area start -->
<div class="shopping_cart_area mt-32">
  <div class="container">
    <div>
      <div class="row">
        <div class="col-12">
          <div class="table_desc">
            <div class="cart_page table-responsive">
              <table id="tb_product">
                <thead>
                <tr>
                  <th class="product_remove">Delete</th>
                  <th class="product_remove">Update</th>
                  <th class="product_name">Product</th>
                  <th class="product-price">Price</th>
                  <th class="product_quantity">Quantity</th>
                  <th class="product_total">Total</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
      <!--coupon code area start-->
      <div class="coupon_area">
        <div class="row">
          <div class="col-lg-12 col-md-12">
            <div class="coupon_code right">
              <div class="checkout_btn">
                <a>Proceed to Checkout</a>
              </div>
              </div>
            </div>
          </div>
      </div>
      <!--coupon code area end-->
    </div>
  </div>
</div>
<!--shopping cart area end -->

<!--call to action start-->
<section class="call_to_action">
  <div class="container">
    <div class="row">
      <div class="col-12">
        <div class="call_action_inner">
          <div class="call_text">
            <h3>We Have <span>Recommendations</span>  for You</h3>
            <p>Take 30% off when you spend $150 or more with code Autima11</p>
          </div>
          <div class="discover_now">
            <a href="#">discover now</a>
          </div>
          <div class="link_follow">
            <ul>
              <li><a href="#"><i class="ion-social-facebook"></i></a></li>
              <li><a href="#"><i class="ion-social-twitter"></i></a></li>
              <li><a href="#"><i class="ion-social-googleplus"></i></a></li>
              <li><a href="#"><i class="ion-social-youtube"></i></a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!--call to action end-->

<!--footer area start-->
<jsp:include page="Footer.jsp"></jsp:include>
<!--footer area end-->


<!-- JS
============================================ -->

<!-- Plugins JS -->
<script src="${pageContext.request.contextPath}/resources/client/js/plugins.js"></script>

<!-- Main JS -->
<script src="${pageContext.request.contextPath}/resources/client/js/main.js"></script>

<script>

    $(".checkout_btn").click(function (e) {
        $.ajax({
            type: "POST",
            url: '<%=request.getContextPath()%>' + "/cart",
            data: {type: "cal"},
            success: function (data) {
                data = JSON.parse(data);
                // cartDetail
                console.log(data);

                if(data.type == true) { // load from server
                    alert("check out success");
                } else {
                    alert("Login to check out");
                }
            }
        });
    })



    $.ajax({
        type: "POST",
        url: '<%=request.getContextPath()%>' + "/cart",
        data: {type: "load", cv: localStorage.getItem('cv')},
        success: function (data) {
            data = JSON.parse(data);
            // cartDetail
            console.log(data);

            if(data.type == true) { // load from server
                $("#tb_product tbody").empty();
                data.cartDetail.forEach(function (item, index) {
                    $("#tb_product tbody").append(
                        "<tr id='row_" + item.prdId +"'>" +
                            "<td><button id='button_remove' class=' fa fa-trash-o'/></td>"+
                            "<td><button id='button_update' class=' fa fa-pencil'/></td>"+
                            "<td class='product_name'><a>" + item.prdName + "</a></td>"+
                            "<td class='product-price'>$ " + item.prdPrice + "</td>"+
                            "<td class='product_quantity'><label>Quantity</label> <input min='1' max='100' value='" + item.qua + "' type='number'></td>" +
                            "<td class='product_total'>$ "  + item.total + "</td>" +
                        "</tr>"
                    );
                });
            }
        }
    });

    $(document).on("click", "#button_remove", function () {
        console.log(1);
        $.ajax({
            type: "POST",
            url: '<%=request.getContextPath()%>' + "/cart",
            data: {type: "del", id: $(this).parent().parent().attr("id").split("_")[1], cv: localStorage.getItem('cv')},
            success: function (data) {
                data = JSON.parse(data);
                // cartDetail
                console.log(data);

                $("#tb_product tbody").empty();
                data.cartDetail.forEach(function (item, index) {
                    $("#tb_product tbody").append(
                        "<tr id='row_" + item.prdId +"'>" +
                        "<td><button id='button_remove' class='fa fa-trash-o'/></td>"+
                        "<td><button id='button_update' class=' fa fa-pencil'/></td>"+
                        "<td class='product_name'><a>" + item.prdName + "</a></td>"+
                        "<td class='product-price'>$ " + item.prdPrice + "</td>"+
                        "<td class='product_quantity'><label>Quantity</label> <input min='1' max='100' value='" + item.qua + "' type='number'></td>" +
                        "<td class='product_total'>$ "  + item.total + "</td>" +
                        "</tr>"
                    );
                });

                if(data.type == true) { // load from server
                    localStorage.setItem('cv',JSON.stringify(data.carts));
                }
            }
        });
    })

    $(document).on("click", "#button_update", function () {

        $.ajax({
            type: "POST",
            url: '<%=request.getContextPath()%>' + "/cart",
            data: {type: "update", id: $(this).parent().parent().attr("id").split("_")[1],qua: $(this).parent().parent().find("td input").val(), cv: localStorage.getItem('cv')},
            success: function (data) {
                data = JSON.parse(data);
                // cartDetail
                console.log(data);

                $("#tb_product tbody").empty();
                data.cartDetail.forEach(function (item, index) {
                    $("#tb_product tbody").append(
                        "<tr id='row_" + item.prdId +"'>" +
                        "<td><button id='button_remove' class='fa fa-trash-o'/></td>"+
                        "<td><button id='button_update' class=' fa fa-pencil'/></td>"+
                        "<td class='product_name'><a>" + item.prdName + "</a></td>"+
                        "<td class='product-price'>$ " + item.prdPrice + "</td>"+
                        "<td class='product_quantity'><label>Quantity</label> <input min='1' max='100' value='" + item.qua + "' type='number'></td>" +
                        "<td class='product_total'>$ "  + item.total + "</td>" +
                        "</tr>"
                    );
                });

                if(data.type == true) { // load from server
                    localStorage.setItem('cv',JSON.stringify(data.carts));
                }
            }
        });
    })


</script>


</body>


<!-- Mirrored from demo.hasthemes.com/autima-v2/autima/cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 06 Apr 2019 13:58:22 GMT -->
</html>