<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" href="<c:url value='/resources/css/bbsMaster.css'/>" />

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="<c:url value='/resources/js/mstr/bbsMaster.common.js'/>"></script>
<script src="<c:url value='/resources/js/mstr/bbsMaster.detail.js'/>"></script>

<div class="bm-wrap">
	<h2 class="bm-title">게시판 마스터 상세</h2>

	<form id="bmDetailForm" method="post"
		data-list-url="<c:url value='/admin/bbsMaster/selectBbsMasterList.do'/>"
		data-update-view-url="<c:url value='/admin/bbsMaster/updateBbsMasterView.do'/>">
		<input type="hidden" name="bbsId" value="${bbsMasterVO.bbsId}" />

		<table class="bm-form">
			<tbody>
				<tr>
					<th>게시판ID</th>
					<td><c:out value="${bbsMasterVO.bbsId}" /></td>
				</tr>
				<tr>
					<th>게시판명</th>
					<td><c:out value="${bbsMasterVO.bbsNm}" /></td>
				</tr>
				<tr>
					<th>게시판 소개</th>
					<td style="white-space: pre-wrap;">
						<c:out value="${bbsMasterVO.bbsIntrcn}" />
					</td>
				</tr>
				<tr>
					<th>게시판 유형 코드</th>
					<td><c:out value="${bbsMasterVO.bbsTyCode}" /></td>
				</tr>
				<tr>
					<th>파일첨부 가능</th>
					<td><c:out value="${bbsMasterVO.fileAtchPosblAt}" /></td>
				</tr>
				<tr>
					<th>첨부 가능 파일 개수</th>
					<td><c:out value="${bbsMasterVO.atchPosblFileNumber}" /></td>
				</tr>
				<tr>
					<th>첨부 가능 파일 크기(MB)</th>
					<td><c:out value="${bbsMasterVO.atchPosblFileSize}" /></td>
				</tr>
				<tr>
					<th>사용 여부</th>
					<td><c:out value="${bbsMasterVO.useAt}" /></td>
				</tr>
				<tr>
					<th>최초 등록</th>
					<td><c:out value="${bbsMasterVO.frstRegisterId}" /> / <c:out
							value="${bbsMasterVO.frstRegistPnttm}" /></td>
				</tr>
				<tr>
					<th>최종 수정</th>
					<td><c:out value="${bbsMasterVO.lastUpdusrId}" /> / <c:out
							value="${bbsMasterVO.lastUpdtPnttm}" /></td>
				</tr>
			</tbody>
		</table>

		<div class="bm-actions">
			<button type="button" class="bm-btn primary" id="btnUpdateView">수정</button>
			<button type="button" class="bm-btn" id="btnList">목록</button>
		</div>
	</form>
</div>
