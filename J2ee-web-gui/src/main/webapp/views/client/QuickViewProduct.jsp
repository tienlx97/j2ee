<%@ page import="core.ProductDTO" %>
<%@ page import="Constant.VariableConstant" %>
<%
  ProductDTO dto = (ProductDTO) request.getAttribute(VariableConstant.PRODUCTS);
%>

<div class="container">
  <div class="row">
    <div class="col-lg-5 col-md-5 col-sm-12">
      <div class="tab-content product-details-large">
        <br/>
        <div class="tab-pane fade show active" id="tab1" role="tabpanel">
          <div class="modal_tab_img">
            <a href="#"><img style="width:300px; height:300px" src="<%=dto.getImageUrl()%>" alt=""></a>
          </div>
        </div>
      </div>
      <div >
        <ul class="nav product_navactive">
          <%for (int i=0;i<dto.getDetailImageUrl().length;i++){%>
          <li>
            <a class="nav-link active" data-toggle="tab" href="#tab1" role="tab" aria-controls="tab1"
               aria-selected="false"><img style="width: 100px;height: 100px" src="<%=dto.getDetailImageUrl()[i]%>" alt=""></a>
          </li>
          <%}%>
        </ul>
      </div>
    </div>
    <div class="col-lg-7 col-md-7 col-sm-12">
      <div class="modal_right">
        <div class="modal_title mb-10">
          <br/>
          <h2><%=dto.getName()%></h2>
        </div>
        <div class="modal_price mb-10">
          <span class="new_price"><%=dto.getSelPrice()%></span>
        </div>
        <div class="modal_description mb-15">
          <p><%=dto.getDescription()%> </p>
        </div>
        <div class="variants_selects">
          <div class="modal_add_to_cart">
            <form action="#">
              <input min="0" max="100" step="2" value="1" type="number">
              <button type="submit">add to cart</button>
            </form>
          </div>
        </div>
        <div class="modal_social">
          <h2>Share this product</h2>
          <ul>
            <li class="facebook"><a href="#"><i class="fa fa-facebook"></i></a></li>
            <li class="twitter"><a href="#"><i class="fa fa-twitter"></i></a></li>
            <li class="pinterest"><a href="#"><i class="fa fa-pinterest"></i></a></li>
            <li class="google-plus"><a href="#"><i class="fa fa-google-plus"></i></a></li>
            <li class="linkedin"><a href="#"><i class="fa fa-linkedin"></i></a></li>
          </ul>
          <br/>          <br/>          <br/>          <br/>          <br/>
        </div>
      </div>
    </div>
  </div>
</div>
