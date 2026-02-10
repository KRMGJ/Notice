<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setAttribute("pageTitle", "자료실 등록");
request.setAttribute("extraHead",
		"<link rel=\"stylesheet\" href=\"" + request.getContextPath() + "/resources/css/data.css\" />"
		+ "<script src=\"" + request.getContextPath() + "/resources/js/dta/regist.js\"></script>");
request.setAttribute("contentPage", "/WEB-INF/jsp/dta/dataRegist_body.jsp");
%>

<jsp:include page="/WEB-INF/jsp/layout/layout.jsp" />
