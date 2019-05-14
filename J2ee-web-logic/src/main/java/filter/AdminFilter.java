package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import Constant.UrlConstant;
import org.apache.log4j.Logger;

import both.UserAccount;
import utils.SessionHelper;
import utils.UserRoleRequestWrapper;
import Security.SecurityUtils;
@WebFilter(filterName = "AdminFilter")
public class AdminFilter implements Filter {
    public AdminFilter() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        UserAccount user = SessionHelper.getLoginedUserEmployee(request.getSession(false));
        if (user != null) {

            // User Name
            String userName = user.getUserName();

            // Các vai trò (Role).
            List<String> roles = user.getRoles();

            HttpServletRequest wrapRequest = new UserRoleRequestWrapper(userName, roles, request);

            // Kiểm tra người dùng có vai trò hợp lệ hay không?
            boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
            if (!hasPermission) {

                RequestDispatcher dispatcher //
                        = request.getServletContext().getRequestDispatcher(UrlConstant.ACCESS_DENIED);

                dispatcher.forward(request, response);
                return;
            }
            chain.doFilter(wrapRequest,response);
        }
        else{
            String requestUri = request.getRequestURI();
            response.sendRedirect(request.getContextPath() + "/login/admin");
            return;
        }





    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }

}