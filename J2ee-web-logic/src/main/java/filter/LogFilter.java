package filter;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
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

import Constant.UrlConstant;
import both.ServerLogDTO;
import core.IEmployeeService;
import core.IServerLogService;
import org.apache.log4j.Logger;

import both.UserAccount;
import utils.SessionHelper;
import logger.Logger_Server;

@WebFilter(filterName = "LogFilter")
public class LogFilter implements Filter {
    @Inject
    private IServerLogService iServerLogServic;

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
        iServerLogServic = new impl.ServerLogImpl();
        String servletPath = request.getServletPath();
        // Moving to next filter ( AdminFilter ) in chain
        if (servletPath.startsWith("/admin") || servletPath.endsWith("/admin")) {
            UserAccount user = SessionHelper.getLoginedUserEmployee(request.getSession(false));
            if (user != null) {

                // User Name
                String userName = user.getUserName();

                // Các vai trò (Role).
                List<String> roles = user.getRoles();

                System.out.println("#INFO " + new java.util.Date() + "- Admin: " + userName + "- Roles: " + roles
                        + " - ServletPath :" + servletPath //
                        + ", URL =" + request.getRequestURL() + ", Path info= " + request.getPathInfo());
                ServerLogDTO serverLogDTO = Logger_Server.saveServerLog(request, userName,"EMPLOYEE");
                if (serverLogDTO != null)
                    iServerLogServic.saveLog(serverLogDTO);

            } else {
                System.out.println("#INFO " + new java.util.Date() + "- Anonymous" + " - ServletPath :" + servletPath //
                        + ", URL =" + request.getRequestURL() + ", Path info= " + request.getPathInfo());

                ServerLogDTO serverLogDTO = Logger_Server.saveServerLog(request, "Anonymous","Anonymous");
                if (serverLogDTO != null)
                    iServerLogServic.saveLog(serverLogDTO);
            }
        } else {
            UserAccount user = SessionHelper.getLoginedUserCustomer(request.getSession(false));
            if (user != null) {
                System.out.println("#INFO " + new java.util.Date() + "- User: " + user.getUserName()
                        + " - ServletPath :" + servletPath //
                        + ", URL =" + request.getRequestURL() + ", Path info= " + request.getPathInfo());
                ServerLogDTO serverLogDTO = Logger_Server.saveServerLog(request, user.getUserName(),"USER");

                if (serverLogDTO != null)
                    iServerLogServic.saveLog(serverLogDTO);
            } else {
                System.out.println("#INFO " + new java.util.Date() + "- Anonymous" + " - ServletPath :" + servletPath //
                        + ", URL =" + request.getRequestURL() + ", Path info= " + request.getPathInfo());
                ServerLogDTO serverLogDTO = Logger_Server.saveServerLog(request, "Anonymous","Anonymous");
                if (serverLogDTO != null)
                    iServerLogServic.saveLog(serverLogDTO);
            }
        }

        // Go to the next element (filter or target) in chain.
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }

}