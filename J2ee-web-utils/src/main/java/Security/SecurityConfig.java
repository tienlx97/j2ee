package Security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *  ID_Role, Name_Role, Description
 * '1', 'Khách hàng', 'Là những người được cung cấp các dịch vụ như mua hàng, thanh toán,...'
 * '2', 'Quản lí hàng hóa', 'Có quyền xem, chỉnh sửa, thêm mới, cập nhât và xóa bỏ hàng hóa.'
 * '3', 'Quản lí hóa đơn', 'Có quyền xem và cập nhật hóa đơn.'
 * '4', 'Quản lí nhân viên', 'Có quyền xem, thay đổi, tạo mới và loại bỏ nhân viên hoặc thông tin nhân viên.'
 * '5', 'Quản lí khách hàng', 'Có quyền xem, thay đổi và vô hiệu hóa khách hàng hoặc thông tin khách hàng.'
 * '6', 'Báo cáo doanh thu', 'Được lập báo cáo và doanh thu. ( Yêu cầu phải có quyền (2) (3) hoặc (4) )'

*/

public class SecurityConfig {
//    public static final String FUNC_0 = "FUNC_0";
    public static final String FUNC_1 = "FUNC_1";
    public static final String FUNC_2 = "FUNC_2";
    public static final String FUNC_3 = "FUNC_3";
    public static final String FUNC_4 = "FUNC_4";
    public static final String FUNC_5 = "FUNC_5";

    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

    static {
        init();
    }

    private static void init() {

//        // Cấu hình cho chức năng 1.
//        List<String> urlPatterns1 = new ArrayList<String>();
//
//        urlPatterns1.add("/customer");
//
//        mapConfig.put(FUNC_1, urlPatterns1);

        // Cấu hình cho chức năng 1.
        List<String> urlPatterns1 = new ArrayList<String>();

        urlPatterns1.add("/admin/add-product");
        urlPatterns1.add("/admin/category");
        urlPatterns1.add("/admin/edit-category");
        urlPatterns1.add("/admin/edit-product");
        urlPatterns1.add("/admin/products");

        mapConfig.put(FUNC_1, urlPatterns1);

        // Cấu hình cho chức năng 2.
        List<String> urlPatterns2 = new ArrayList<String>();

        urlPatterns2.add("/admin/manager_order");
        urlPatterns2.add("/admin/dashboard");

        mapConfig.put(FUNC_2, urlPatterns2);

        // Cấu hình cho chức năng 3.
        List<String> urlPatterns3 = new ArrayList<String>();

        urlPatterns3.add("/admin/modify/employee");
        urlPatterns3.add("/admin/views/employee");
        urlPatterns3.add("/admin/custom_action/*");
        urlPatterns3.add("/admin/tracking/employee");
        urlPatterns3.add("/admin/addnew/employee");
        urlPatterns3.add("/admin/search/tracking_employee");
        urlPatterns3.add("/admin/search/employee");

        mapConfig.put(FUNC_3, urlPatterns3);

        // Cấu hình cho chức năng 4.
        List<String> urlPatterns4 = new ArrayList<String>();

        urlPatterns4.add("/admin/manager_customer");

        mapConfig.put(FUNC_4, urlPatterns4);

        // Cấu hình cho chức năng 5.
        List<String> urlPatterns5 = new ArrayList<String>();

        urlPatterns5.add("/admin/report");

        mapConfig.put(FUNC_5, urlPatterns5);


    }
    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }
}
