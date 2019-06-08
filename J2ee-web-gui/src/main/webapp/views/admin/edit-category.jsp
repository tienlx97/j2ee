<%@ page import="core.CategoryDTO" %>
<%@ page import="Constant.VariableConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  CategoryDTO dto = (CategoryDTO) request.getAttribute(VariableConstant.CATEGORY_DTO);
%>

<form id="fEditCategory" method="post" action="">

  <div class="col-sm-12">
    Id
    <div class="form-group">
      <div>
        </ul>
        <input type="text"  value="<%=dto.getCatId()%>" class="form-control" readonly="readonly">
      </div>
    </div>
  </div>

  <div class="col-sm-12">
    Name
    <div class="form-group">
      <div>
        <ul id="error-cat-name" style="text-align: left;margin: auto;">
        </ul>
        <input name="catName" id="catName" type="text"  value="<%=dto.getCatName()%>" class="form-control">
      </div>
    </div>
  </div>

  <div class="col-sm-12">
    Description
    <div class="form-group">
      <div>
        <textarea name="catDescription" id="catDescription" class="form-control" rows="5"><%=dto.getCatDescription()%></textarea>
      </div>
    </div>
  </div>

  <div class="col-sm-12">
    Image
    <div class="form-group">
      <div>
        <input type="text" id="catImgUrl" name="catImgUrl" class="form-control">
      </div>
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-12">
      <button type="submit" class="btn btn-success">Submit</button>
      <input type="hidden" name="action" id="action" value="EDIT">
      <input type="hidden" name="catId" value="<%=dto.getCatId()%>" />
    </div>
  </div>
</form>