<%@ page import="Constant.UrlConstant" %>
<html>
<body></body>
<script>
    window.location.href = "<%= request.getContextPath() + UrlConstant.URL_CLIENT_HOME %>";
    <%--window.location.href = "<%= request.getContextPath() + UrlConstant.URL_ADMIN_LOGIN %>";--%>
    <%--window.location.href = "<%= request.getContextPath() + UrlConstant.URL_ADMIN_DASHBOARD %>";--%>
<<<<<<< HEAD
=======
    <%--window.location.href = "<%= request.getContextPath() + UrlConstant.URL_ADMIN_PURCHASE_ORDER %>";--%>
    <%--window.location.href = "<%= request.getContextPath() + UrlConstant.URL_ADMIN_PURCHASE_ORDER_NEW %>";--%>
    window.location.href = "<%= request.getContextPath() + UrlConstant.URL_ADMIN_PRODUCT %>";
>>>>>>> ac5115a88709d05b80a8bb08d62cf5a5b44f666d
</script>
</html>
