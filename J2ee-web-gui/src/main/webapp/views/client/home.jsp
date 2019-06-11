<%@ page import="java.util.List" %>
<%@ page import="core.ProductDTO" %>
<%@ page import="Constant.VariableConstant" %>
<%@include file="../../common/tablib.jsp"%>
<%--<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>--%>
<%@page isELIgnored="false" %>
<%--<c:url value="/resources/assets" var="location" />--%>


<!doctype html>
<html class="no-js" lang="en">


<!-- Mirrored from demo.hasthemes.com/autima-v2/autima/index-2.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 06 Apr 2019 13:58:22 GMT -->

<head>
  <meta charset="utf-8">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Autima - Car Accessories Bootstrap HTML Template</title>
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

<%
  List<ProductDTO> dto = (List<ProductDTO>) request.getAttribute(VariableConstant.PRODUCTS);
%>

<!-- Main Wrapper Start -->
<!--header area start-->

<jsp:include page="Header.jsp"></jsp:include>

<!--header area end-->

<!--slider area start-->
<jsp:include page="SliderBar.jsp"></jsp:include>
<!--slider area end-->

<!--product area start-->
<section class="product_area mb-50">
  <div class="container">
    <div class="row">
      <div class="col-12">
        <div class="section_title">
          <h2><span> <strong>Our</strong>Products</span></h2>
        </div>

      </div>
    </div>
    <div class="tab-content">
      <div class="tab-pane fade show active" id="brake" role="tabpanel">
        <div class="product_carousel product_column5 owl-carousel">

          <%
          if(dto != null) {
            for (int i=0; i<dto.size(); ) {
              ProductDTO item1= dto.get(i);
              ProductDTO item2= dto.get(i+1);
              ProductDTO item3= dto.get(i+2);
              i+= 3;

          %>

          <div class="single_product_list">
            <div class="single_product">
              <div class="product_name">
                <h3><a href="product-details.html"><%=item1.getName()%></a></h3>
              </div>
              <div class="product_thumb">
                <a class="primary_img" href="product-details.html"><img style="width:235px; height: 235px;" src="<%=item1.getImageUrl()%>"
                                                                        alt=""></a>
                <div class="action_links" id="prd_<%=item1.getId()%>">
                  <ul>
                    <li class="quick_button"><a  title="quick view"> <span class="lnr lnr-magnifier"></span></a></li>
                    <li class="wishlist"><a href="wishlist.html" title="Add to Wishlist"><span
                            class="lnr lnr-heart"></span></a></li>
                    <li class="compare"><a href="#" title="compare"><span class="lnr lnr-sync"></span></a></li>
                  </ul>
                </div>
              </div>
              <div class="product_content">
                <div class="product_footer d-flex align-items-center">
                  <div class="price_box">
                    <span class="regular_price">$<%=item1.getSelPrice()%></span>
                  </div>
                  <div class="add_to_cart" id="add_<%=item1.getId()%>">
                    <a title="add to cart"><span class="lnr lnr-cart"></span></a>
                  </div>
                </div>
              </div>
            </div>
            <div class="single_product">
              <div class="product_name">
                <h3><a href="product-details.html"><%=item2.getName()%></a></h3>
              </div>
              <div class="product_thumb">
                <a class="primary_img" href="product-details.html"><img style="width:235px; height: 235px;" src="<%=item2.getImageUrl()%>"
                                                                        alt=""></a>
                <div class="action_links" id="prd_<%=item2.getId()%>">
                  <ul>
                    <li class="quick_button"><a
                                                title="quick view"> <span class="lnr lnr-magnifier"></span></a></li>
                    <li class="wishlist"><a href="wishlist.html" title="Add to Wishlist"><span
                            class="lnr lnr-heart"></span></a></li>
                    <li class="compare"><a href="#" title="compare"><span class="lnr lnr-sync"></span></a></li>
                  </ul>
                </div>
              </div>
              <div class="product_content">
                <div class="product_footer d-flex align-items-center">
                  <div class="price_box">
                    <span class="regular_price">$<%=item2.getSelPrice()%></span>
                  </div>
                  <div class="add_to_cart" id="add_<%=item2.getId()%>">
                    <a title="add to cart"><span class="lnr lnr-cart"></span></a>
                  </div>
                </div>
              </div>
            </div>
            <div class="single_product">
              <div class="product_name">
                <h3><a href="product-details.html"><%=item3.getName()%></a></h3>
              </div>
              <div class="product_thumb">
                <a class="primary_img" href="product-details.html"><img  src="<%=item3.getImageUrl()%>" style="width:235px; height: 235px;"
                                                                        alt=""></a>
                <div class="action_links" id="prd_<%=item3.getId()%>">
                  <ul>
                    <li class="quick_button"><a
                                                title="quick view"> <span class="lnr lnr-magnifier"></span></a></li>
                    <li class="wishlist"><a href="wishlist.html" title="Add to Wishlist"><span
                            class="lnr lnr-heart"></span></a></li>
                    <li class="compare"><a href="#" title="compare"><span class="lnr lnr-sync"></span></a></li>
                  </ul>
                </div>
              </div>
              <div class="product_content">
                <div class="product_footer d-flex align-items-center">
                  <div class="price_box">
                    <span class="regular_price">$<%=item3.getSelPrice()%></span>
                  </div>
                  <div class="add_to_cart" id="add_<%=item3.getId()%>">
                    <a title="add to cart"><span class="lnr lnr-cart"></span></a>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <%}}%>
        </div>
      </div>
    </div>
    <div style="display: flex; justify-content: center; margin-top:10px">
      <h4><a>Read more</a></h4>
    </div>
  </div>
</section>
<!--product area end-->

<!--footer area start-->
<jsp:include page="Footer.jsp"></jsp:include>
<!--footer area end-->


<!-- modal area start-->
<div class="modal fade" id="modal_box" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
      <div class="modal_body">
      </div>
    </div>
  </div>
</div>
<!-- modal area end-->


<!-- JS
============================================ -->

<!-- Plugins JS -->
<script src="${pageContext.request.contextPath}/resources/client/js/plugins.js"></script>

<!-- Main JS -->
<script src="${pageContext.request.contextPath}/resources/client/js/main.js"></script>

<script>
    $('.quick_button').click(function () {
        var id = $(this).parent().parent().attr('id').split('_')[1];
        console.log(id);
        $.ajax({
            type: "POST",
            url: '<%=request.getContextPath()%>' + "/home",
            data: {id: id},
            success: function (response) {
                $('#modal_box .modal-content ').html(response);
                $('#modal_box').modal('show');
            }
        });

    });

    $('.add_to_cart').click(function () {
        var id = $(this).attr('id').split('_')[1];
        $.ajax({
            type: "POST",
            url: '<%=request.getContextPath()%>' + "/api/add2cart",
            data: {id: id, qual: 1, cv: localStorage.getItem('cv')},
            success: function (data) {
                // data = JSON.parse(data);
                if(data.type == false) {
                    console.log(data.carts);
                  // Code for localStorage/sessionStorage.
                  localStorage.setItem('cv',JSON.stringify(data.carts));

                } else {

                }
            }
        });
    })

    $('.btn_add_2cart').click(function () {
        var id = $(this).parent().attr('id').split('_')[1];
        var qua = $("#qual_i").val();
        $.ajax({
            type: "POST",
            url: '<%=request.getContextPath()%>' + "/api/add2cart",
            data: {id: id, qual: qua, cv: localStorage.getItem('cv')},
            success: function (data) {
                // data = JSON.parse(data);
                if(data.type == false) {
                    console.log(data.carts);
                    // Code for localStorage/sessionStorage.
                    localStorage.setItem('cv',JSON.stringify(data.carts));
                } else {

                }
            }
        });
    })

</script>

</body>


<!-- Mirrored from demo.hasthemes.com/autima-v2/autima/index-2.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 06 Apr 2019 13:58:25 GMT -->

</html>