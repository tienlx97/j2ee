package filter;

import Constant.CssConstant;
import Constant.ErrorConstant;
import Constant.UrlConstant;
import Constant.VariableConstant;
import core.EmployeeDTO;
import utils.FormUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        EmployeeDTO employeeDTO =  FormUtil.toDTO(EmployeeDTO.class, req);

        if(employeeDTO.getUsername() != null && employeeDTO.getPassword() != null) {

            boolean err = false;
            if(employeeDTO.getUsername().equals("")) {
                req.setAttribute(VariableConstant.BAD_USERNAME_STYLE, CssConstant.BAD);
                req.setAttribute(VariableConstant.ERROR_USERNAME, ErrorConstant.ERROR_ADMIN_USERNAME_EMPTY);
                err = true;
            }

            if(employeeDTO.getPassword().equals("")) {
                req.setAttribute(VariableConstant.BAD_PASSWORD_STYLE, CssConstant.BAD);
                req.setAttribute(VariableConstant.ERROR_PASSWORD,ErrorConstant.ERROR_ADMIN_PASSWORD_EMPTY );
                err = true;
            }

            if(err) {
                req.setAttribute(VariableConstant.LOGIN_DTO, employeeDTO);
                req.getRequestDispatcher(UrlConstant.ADMIN_LOGIN_JSP).forward(req,res);

            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void destroy() {

    }
}
