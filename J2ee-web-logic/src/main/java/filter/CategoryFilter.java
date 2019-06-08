package filter;

import Constant.MsgConstant;
import Constant.VariableConstant;
import GsonObject.GCategory;
import core.CategoryDTO;
import core.ICategoryService;
import utils.Ajax;
import utils.FormUtil;
import GsonObject.GCategory.GCategoryBuilder;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CategoryFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        CategoryDTO dto = FormUtil.toDTO(CategoryDTO.class, req);

        if(dto.getCatName() != null) {
            if(dto.getCatName().equals("")){
                GCategory gAddCategory = new GCategoryBuilder()
                                        .setType(false)
                                        .setECatName(MsgConstant.ERROR_CATEGORY_NAME_EMPTY)
                                        .setcError("parsley-errors-list filled")
                                        .build();
                Ajax.sendData(res,gAddCategory);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

}
