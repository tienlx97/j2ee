package filter;

import Constant.CssConstant;
import Constant.ErrorConstant;
import Constant.UrlConstant;
import Constant.VariableConstant;
import core.CategoryDTO;
import core.ICategoryService;
import utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoryFilter implements Filter {

    @Inject
    ICategoryService iCategoryService;

    @SuppressWarnings("Duplicates")
    void commonData(HttpServletRequest req) {
        List<CategoryDTO> categories = iCategoryService.loadCategories();
        long catId = iCategoryService.generateCategoryId();
        req.setAttribute(VariableConstant.CATEGORIES, categories);
        req.setAttribute(VariableConstant.CATEGORY_ID, catId);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        CategoryDTO dto = FormUtil.toDTO(CategoryDTO.class, req);

        if(dto.getCatParent() != null && dto.getCatId() != null && dto.getCatName() != null ) {

            boolean err = false;

            if(dto.getCatId().equals("")){
                req.setAttribute(VariableConstant.EMPTY_CATEGORY_ID, ErrorConstant.ERROR_CATEGORY_ID_EMPTY);
                err = true;
            }

            if(dto.getCatParent().equals("")) {
                req.setAttribute(VariableConstant.EMPTY_CATEGORY_PARENT, ErrorConstant.ERROR_CATEGORY_PARENT_EMPTY);
                err = true;
            }

            if(dto.getCatName().equals("")) {
                req.setAttribute(VariableConstant.EMPTY_CATEGORY_NAME, ErrorConstant.ERROR_CATEGORY_NAME_EMPTY);
                err = true;
            }

            if(err) {
                commonData(req);
                req.setAttribute(VariableConstant.CATEGORY_DTO, dto);
                req.getRequestDispatcher(UrlConstant.ADMIN_CATEGORY_JSP).forward(req,res);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }

         } else  {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }

}
