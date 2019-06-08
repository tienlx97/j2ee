<%@ page import="core.CategoryDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="Constant.VariableConstant" %>
<%
  List<CategoryDTO> categories = (List<CategoryDTO>) request.getAttribute(VariableConstant.CATEGORIES);
%>

  <div class="col-md-12">
    <div class="x_panel" style="padding-left: 3px;">
      <div class="x_title">
        <h2>Add product</h2>
        <div class="clearfix"></div>
      </div>
      <div class="x_content">

        <div class="" role="tabpanel" data-example-id="togglable-tabs">
          <%-- Start Nav bar title --%>
          <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
            <li role="presentation" class="active"><a href="#tab_content1" id="home-tab" role="tab" data-toggle="tab" aria-expanded="true">Information</a>
            </li>
            <li role="presentation" class=""><a href="#tab_content2" role="tab" id="profile-tab" data-toggle="tab" aria-expanded="false">Description</a>
            </li>
            <li role="presentation" class=""><a href="#tab_content3" role="tab" id="profile-tab2" data-toggle="tab" aria-expanded="false">Images</a>
            </li>
          </ul>
          <%-- End Nav bar title --%>

          <form class="form-horizontal form-label-left" id="fAdd" method="post" action="">
            <div id="myTabContent" class="tab-content">
              <div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="home-tab">

                <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12">Product name <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text" id="name" name="name" class="form-control col-md-7 col-xs-12">
                  </div>
                </div>

                <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" >Category name <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                    <select title="Please select a category" data-live-search="true" id="categoryId" name="categoryId" class="select-cat-parent form-control col-md-7 col-xs-12">
                      <%
                        if(categories != null) {
                          for (int i=0; i< categories.size(); i++) {
                            CategoryDTO categoryDTO = categories.get(i);
                      %>
                      <option value="cat_<%=categoryDTO.getCatId()%>"><%=categoryDTO.getCatName()%></option>
                      <%
                        }}
                      %>
                    </select>
                  </div>
                </div>

                <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" >Sell price <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text" id="selPrice" name="selPrice" class="form-control col-md-7 col-xs-12">
                  </div>
                </div>

                <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12">Quality <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text" id="quantity" name="quantity" class="form-control col-md-7 col-xs-12">
                  </div>
                </div>

              </div>
              <div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="profile-tab">
                <div class="x_content">
                  <div class="col-sm-12">
                    <div class="form-group">
                      <div>
                        <textarea name="description" id="description" class="form-control" rows="5"></textarea>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div role="tabpanel" class="tab-pane fade" id="tab_content3" aria-labelledby="profile-tab">
                <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="imageUrl">Image main <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text" id="imageUrl" name="imageUrl" class="form-control col-md-7 col-xs-12" >
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12">Image 1 <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text"  name="detailImageUrl" class="form-control col-md-7 col-xs-12" >
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12">Image 2
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text" name="detailImageUrl" class="form-control col-md-7 col-xs-12" >
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12">Image 3
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text" name="detailImageUrl" class="form-control col-md-7 col-xs-12" >
                  </div>
                </div>
              </div>
            </div>
            <div class="ln_solid"></div>
            <div class="form-group">
              <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                <button type="submit" class="btn btn-success">Submit</button>
              </div>
            </div>
          </form>
        </div>

      </div>
    </div>
  </div>

  <script>
      $('.select-cat-parent').selectpicker({
          // options here
      });
  </script>
