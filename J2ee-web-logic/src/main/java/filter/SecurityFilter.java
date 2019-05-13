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
            System.out.printf("admin filter");
            chain.doFilter(request, response);
            return;
        }


        // Thông tin người dùng đã được lưu trong Session
        // (Sau khi đăng nhập thành công).
//        UserAccount loginedUser = SessionHelper.getLoginedUserCustomer(request.getSession());
//
//        HttpServletRequest wrapRequest = request;
//
//        if (loginedUser != null) {
//            // User Name
//            String userName = loginedUser.getUserName();
//
//            // Các vai trò (Role).
//            List<String> roles = loginedUser.getRoles();
//
//            // Gói request cũ bởi một Request mới với các thông tin userName và Roles.
//            wrapRequest = new UserRoleRequestWrapper(userName, roles, request);
//        }
//
//        // Các trang bắt buộc phải đăng nhập.
//        if (SecurityUtils.isSecurityPage(request)) {
//
//            // Nếu người dùng chưa đăng nhập,
//            // Redirect (chuyển hướng) tới trang đăng nhập.
//            if (loginedUser == null) {
//
//                String requestUri = request.getRequestURI();
//
//                // Lưu trữ trang hiện tại để redirect đến sau khi đăng nhập thành công.
////                int redirectId = AppUtils.storeRedirectAfterLoginUrl(request.getSession(), requestUri);
//
//                response.sendRedirect(wrapRequest.getContextPath() + "/login");
//                return;
//            }
//
//            // Kiểm tra người dùng có vai trò hợp lệ hay không?
//            boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
//            if (!hasPermission) {
//
//                RequestDispatcher dispatcher //
//                        = request.getServletContext().getRequestDispatcher(UrlConstant.ACCESS_DENIED);
//
//                dispatcher.forward(request, response);
//                return;
//            }
//        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }


}
