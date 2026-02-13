<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<div class="nt-wrap">
	<form id="searchForm" method="get">
		<input type="hidden" name="pageIndex" value="${empty searchVO.pageIndex ? 1 : searchVO.pageIndex}" /> 
		<input type="hidden" name="bbsId" value="${searchVO.bbsId}" />

		<div class="nt-toolbar">
			<div class="nt-search">
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

	<div class="nt-muted">
		총 <b>
		<c:out value="${empty paginationInfo ? (empty totalCount ? 0 : totalCount) : paginationInfo.totalRecordCount}" />
		</b>
		건
	</div>

	<table>
		<thead>
			<tr>
				<th style="width: 40px;"><input type="checkbox" id="checkAll"/></th>
				<th class="nt-col-no">번호</th>
				<th>제목</th>
				<th class="nt-col-date">등록일</th>
				<th class="nt-col-view">조회</th>
			</tr>
		</thead>

		<tbody>
			<!-- 공지 상단 -->
			<c:if test="${not empty pinnedList}">
				<c:forEach var="n" items="${pinnedList}">
					<tr class="nt-notice">
						<td style="display: flex; justify-content: center; align-items: center;">
							<input type="checkbox" name="nttId" value="${n.nttId}" />
						</td>
						<td class="nt-col-no">공지</td>
						<td>
							<a href="<c:url value='/bbs/notice/selectNoticeDetail.do'><c:param name='nttId' value='${n.nttId}'/></c:url>">
								<c:out value="${n.subject}" />
							</a> 
							<c:if test="${not empty n.atchFileId}">
								<span class="nt-muted">[첨부]</span>
							</c:if>
						</td>
						<td class="nt-col-date"><c:out value="${n.frstRegistPnttm}" /></td>
						<td class="nt-col-view"><c:out value="${n.viewCnt}" /></td>
					</tr>
				</c:forEach>
			</c:if>

			<!-- 일반 목록 -->
			<c:choose>
				<c:when test="${not empty noticeList}">
					<c:forEach var="n" items="${noticeList}">
					    <c:if test="${n.nttLevel == 1}">
					        <tr class="nt-row" data-root="${n.rootId}" data-id="${n.nttId}">
					            <td>
					                <input type="checkbox" name="nttId" value="${n.nttId}" />
					            </td>
					            <td>${n.nttId}</td>
					            <td>
									<c:choose>
						                <c:when test="${n.delAt == 'Y'}">
						                    <span class="deleted-text">
						                        삭제된 게시글입니다.
						                    </span>
						                </c:when>
						                <c:otherwise>
								            <span class="parent-title" data-root="${n.rootId}" style="cursor:pointer;">
								                <c:if test="${n.hasChild == 'Y'}">
								                    <span class="toggle-icon">▶</span>
								                </c:if>
								                <a href="<c:url value='/bbs/notice/selectNoticeDetail.do'>
								                         <c:param name='nttId' value='${n.nttId}'/>
								                         </c:url>">
								                    ${n.subject}
								                </a>
								            </span>
						                    <button type="button" class="btnReply" data-parent="${n.nttId}">
						                        답글
						                    </button>
						                </c:otherwise>
						            </c:choose>
					            </td>
								<td class="nt-col-date"><c:out value="${n.frstRegistPnttm}" /></td>
								<td class="nt-col-view"><c:out value="${n.viewCnt}" /></td>
					        </tr>
					    </c:if>
					    <c:if test="${n.nttLevel > 1}">
					        <tr class="nt-reply-row" data-root="${n.rootId}" data-id="${n.nttId}" style="display:none;">
					            <td></td>
					            <td></td>
					            <td colspan="3">
					                <div class="reply-box" style="margin-left:${(n.nttLevel - 1) * 25}px;">
					                    <span class="reply-arrow">▶</span>
					                     <c:choose>
						                    <c:when test="${n.rootDelAt  == 'Y'}">
						                        <span class="deleted-parent-msg">
						                            삭제된 게시물의 답글입니다.
						                        </span>
						                    </c:when>
						                    <c:otherwise>
						                        <span class="reply-content">
						                            ${n.content}
						                        </span>
          					                    <span class="reply-date">(${n.frstRegistPnttm})</span>
					                    		<button type="button" class="btnReply" data-parent="${n.nttId}">
					                        		답글
					                    		</button>
						                    </c:otherwise>
						                </c:choose>

					                </div>
					            </td>
					        </tr>
					    </c:if>
					</c:forEach>

 					<tr id="replyRow" style="display:none;">
            			<td colspan="5">
                			<form id="replyForm" method="post" action="<c:url value='/bbs/notice/reply.do'/>">

			                    <input type="hidden" name="parntNttId" id="parntNttId"/>
			                    <input type="hidden" name="bbsId" value="${searchVO.bbsId}"/>
			
			                    <input type="text" name="subject" placeholder="제목"/>
			                    <textarea name="content" placeholder="내용"></textarea>
			                    <button type="submit">등록</button>
								<button type="button" id="btnCancelReply">취소</button>
			                </form>
			            </td>
			        </tr>

				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4" style="text-align: center; color: #666;">조회된 데이터가 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	
    <div class="btn-area">
        <button type="button" id="btnDelete">선택삭제</button>
    </div>

	<div class="pagination">
		<c:if test="${not empty paginationInfo}">
			<ui:pagination paginationInfo="${paginationInfo}" type="text" jsFunction="fn_egov_link_page" />
		</c:if>
	</div>
</div>
