package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import Constant.UrlConstant;
import both.UserAccount;
import utils.SessionHelper;
import utils.UserRoleRequestWrapper;
import Security.SecurityUtils;

@WebFilter(filterName = "SecurityFilter")
public class SecurityFilter implements Filter {
    public SecurityFilter() {
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String urlRequest = request.getRequestURI();

        Pattern pattern = Pattern.compile("\\/(J2ee_web_gui_war)\\/(login).*");
        Matcher match = pattern.matcher(urlRequest);


        //  Because user go from /login/, therefore we move it to LoginController
        if (match.find()) {
            chain.doFilter(request, response);
            return;
        }


        // Moving to next filter ( AdminFilter ) in chain
        if(request.getServletPath().startsWith("/admin")){
            chain.doFilter(request, response);
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }


}
