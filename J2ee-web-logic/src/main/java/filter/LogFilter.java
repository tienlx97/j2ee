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
import org.apache.log4j.Logger;

import both.UserAccount;
import utils.SessionHelper;
import utils.UserRoleRequestWrapper;
import Security.SecurityUtils;
@WebFilter(filterName = "LogFilter")
public class LogFilter implements Filter {
    private static final Logger LOG = Logger.getLogger(LogFilter.class.getName());
    public LogFilter() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String servletPath = request.getServletPath();

        System.out.println("#INFO " +new java.util.Date() + " - ServletPath :" + servletPath //
                + ", URL =" + request.getRequestURL());

        // Go to the next element (filter or target) in chain.
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }

}