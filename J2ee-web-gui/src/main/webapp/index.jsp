<%@ page import="Constant.UrlConstant" %>
<html>
<body></body>
<script>
    window.location.href = "<%= request.getContextPath() + UrlConstant.URL_CLIENT_HOME %>";
    <%--window.location.href = "<%= request.getContextPath() + UrlConstant.URL_ADMIN_LOGIN %>";--%>
</script>
</html>
