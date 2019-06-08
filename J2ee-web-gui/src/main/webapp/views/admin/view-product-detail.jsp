<%@ page import="Constant.VariableConstant" %>
<%@ page import="core.ProductDTO" %>
<%
ProductDTO dto = (ProductDTO) request.getAttribute(VariableConstant.PRODUCTS_VIEW);
%>

<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">

      <br/>

      <%
        if(dto != null) {
      %>

      <div class="x_content">

        <div class="col-md-7 col-sm-7 col-xs-12">
          <div class="product-image">
            <img height="400" width="400" src="<%=dto.getImageUrl()%>" alt="..." />
          </div>
          <div class="product_gallery">
            <%
              for (int i=0; i< dto.getDetailImageUrl().length; i++) {
            %>
              <img style="margin-right: 10px" height="100" width="100" src="<%=dto.getDetailImageUrl()[i]%>" alt="..." />

            <%}%>
          </div>
        </div>

        <div class="col-md-5 col-sm-5 col-xs-12" style="border:0px solid #e5e5e5;">

          <p><strong>Product Id:</strong></p>
          <p><%=dto.getId()%></p>
          <div style="border-bottom: 1px solid #DFDFDF;"/>
          <br />


          <p><strong>Product Name:</strong></p>
          <p><%=dto.getName()%></p>
          <div style="border-bottom: 1px solid #DFDFDF;"/>
          <br />

          <p><strong>Product quantity:</strong></p>
          <p><%=dto.getQuantity()%></p>
          <div style="border-bottom: 1px solid #DFDFDF;"/>
          <br />

          <p><strong>Product sell price:</strong></p>
          <p><%=dto.getSelPrice()%></p>
          <div style="border-bottom: 1px solid #DFDFDF;"/>
          <br />

          <p><strong>Product category name:</strong></p>
          <button type="button" class="btn btn-default btn-xs"><%=dto.getCategoryName()%></button>
          <div style="border-bottom: 1px solid #DFDFDF;"/>
          <br />

          <p><strong>Product created date:</strong></p>
          <p><%=dto.getDateCraeted()%></p>
          <div style="border-bottom: 1px solid #DFDFDF;"/>
          <br />

        </div>


        <div class="col-md-12">

          <div class="" role="tabpanel" data-example-id="togglable-tabs">
            <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
              <li role="presentation" class="active"><a href="#tab_content1" id="home-tab" role="tab" data-toggle="tab" aria-expanded="true">Description</a>
              </li>
            </ul>
            <div id="myTabContent" class="tab-content">
              <div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="home-tab">
                <p><%=dto.getDescription()%></p>
              </div>
            </div>
          </div>

        </div>
      </div>

      <%}%>
    </div>
  </div>
</div>