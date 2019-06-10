package utils;

import javax.servlet.http.HttpSession;
import both.UserAccount;

public class SessionHelper {

    // Lưu trữ thông tin người dùng vào Session.
    public static void storeLoginedUserEmployee(HttpSession session, UserAccount loginedUser) {
        session.setAttribute("loginedUserEmployee", loginedUser);
    }

    // Lưu trữ thông tin người dùng vào Session.
    public static void storeLoginedUserCustomer(HttpSession session, UserAccount loginedUser) {
        session.setAttribute("loginedUserCustomer", loginedUser);
    }

    // Lấy thông tin người dùng lưu trữ trong Session.
    public static UserAccount getLoginedUserCustomer(HttpSession session) {
        if (session==null) return null;
        UserAccount loginedUser = (UserAccount) session.getAttribute("loginedUserCustomer");
        return loginedUser;
    }

    public static UserAccount getLoginedUserEmployee(HttpSession session) {
        if (session==null) return null;
        UserAccount loginedUser = (UserAccount) session.getAttribute("loginedUserEmployee");
        return loginedUser;
    }

}
