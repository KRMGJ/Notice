<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="pageTitle" scope="request" class="java.lang.String" />

<%
request.setAttribute("pageTitle", "게시판 마스터 등록");
request.setAttribute("extraHead",
        "<link rel=\"stylesheet\" href=\"" + request.getContextPath()
        + "/resources/css/bbsMaster.css\" /> <script src=\"" + request.getContextPath()
        + "/resources/js/mstr/common.js\"></script> <script src=\""
        + request.getContextPath() + "/resources/js/mstr/regist.js\"></script>");
request.setAttribute("contentPage", "/WEB-INF/jsp/mstr/bbsMasterRegist_body.jsp");
%>

<jsp:include page="/WEB-INF/jsp/layout/layout.jsp" />