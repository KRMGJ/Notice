<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>공지사항</title>

<link rel="stylesheet" href="<c:url value='/resources/css/notice.css'/>" />
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<div class="wrap">
		<h1>공지사항</h1>

		<form id="searchForm" method="get">
			<input type="hidden" name="pageIndex" value="${empty searchVO.pageIndex ? 1 : searchVO.pageIndex}" /> 
			<input type="hidden" name="bbsId" value="${searchVO.bbsId}" />

			<div class="toolbar">
				<div class="search">
					<select name="searchCondition">
						<option value="0"
							<c:if test="${searchVO.searchCondition == '0'}">selected</c:if>>제목</option>
						<option value="1"
							<c:if test="${searchVO.searchCondition == '1'}">selected</c:if>>내용</option>
						<option value="2"
							<c:if test="${searchVO.searchCondition == '2'}">selected</c:if>>작성자</option>
					</select> 
					<input type="text" name="searchKeyword" value="${fn:escapeXml(searchVO.searchKeyword)}" placeholder="검색어 입력" />
					<button type="button" id="btnSearch">검색</button>
				</div>

				<div>
					<button type="button" id="btnReg">등록</button>
				</div>
			</div>
		</form>

		<div class="muted">
			총 <b>
			<c:out value="${empty paginationInfo ? (empty totalCount ? 0 : totalCount) : paginationInfo.totalRecordCount}" />
			</b>
			건
		</div>

		<table>
			<thead>
				<tr>
					<th class="col-no">번호</th>
					<th>제목</th>
					<th class="col-date">등록일</th>
					<th class="col-view">조회</th>
				</tr>
			</thead>

			<tbody>
				<!-- 공지 상단 -->
				<c:if test="${not empty pinnedList}">
					<c:forEach var="n" items="${pinnedList}">
						<tr class="notice">
							<td class="col-no">공지</td>
							<td>
								<a href="<c:url value='/notice/detail.do'><c:param name='nttId' value='${n.nttId}'/></c:url>">
									<c:out value="${n.nttSj}" />
								</a> 
								<c:if test="${not empty n.atchFileId}">
									<span class="muted">[첨부]</span>
								</c:if>
							</td>
							<td class="col-date"><c:out value="${n.frstRegistPnttm}" /></td>
							<td class="col-view"><c:out value="${n.inqireCo}" /></td>
						</tr>
					</c:forEach>
				</c:if>

				<!-- 일반 목록 -->
				<c:choose>
					<c:when test="${not empty resultList}">
						<c:forEach var="n" items="${resultList}">
							<tr>
								<td class="col-no"><c:out value="${n.nttId}" /></td>
								<td>
									<a href="<c:url value='/notice/detail.do'><c:param name='nttId' value='${n.nttId}'/></c:url>">
										<c:out value="${n.nttSj}" />
									</a> 
									<c:if test="${not empty n.atchFileId}">
										<span class="muted">[첨부]</span>
									</c:if>
								</td>
								<td class="col-date"><c:out value="${n.frstRegistPnttm}" /></td>
								<td class="col-view"><c:out value="${n.inqireCo}" /></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="4" style="text-align: center; color: #666;">조회된 데이터가 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>

		<div class="pagination">
			<c:if test="${not empty paginationInfo}">
				<ui:pagination paginationInfo="${paginationInfo}" type="text" jsFunction="fn_egov_link_page" />
			</c:if>
		</div>

	</div>
</body>
<script>
	function fn_egov_link_page(pageNo) {
		$("#searchForm input[name='pageIndex']").val(pageNo);
		$("#searchForm").attr("action", "<c:url value='/notice/list.do'/>").submit();
	}

	$(function() {
		$("#btnSearch").on("click", function() {
					$("#searchForm input[name='pageIndex']").val(1);
					$("#searchForm").attr("action", "<c:url value='/notice/list.do'/>").submit();
				});
		$("#btnReg").on("click", function() {
			location.href = "<c:url value='/notice/form.do'/>";
		});
	});
</script>
</html>
