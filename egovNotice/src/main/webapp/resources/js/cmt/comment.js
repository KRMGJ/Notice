$(document).ready(function() {
	const nttId = $("#nttId").val();

	if (!nttId) {
		console.error("nttId가 없습니다.");
		return;
	}

	loadComments();

	$("#btnCommentSave").on("click", function() {

		const commentCn = $("#commentCn").val().trim();

		if (commentCn === "") {
			alert("댓글 내용을 입력하세요.");
			return;
		}

		$.ajax({
			url: "/bbs/cmt/insert.do",
			type: "POST",
			data: {
				nttId: nttId,
				commentCn: commentCn
			},
			success: function() {
				$("#commentCn").val("");
				loadComments();
			},
			error: function() {
				alert("댓글 등록 중 오류가 발생했습니다.");
			}
		});
	});

	function loadComments() {
		$.ajax({
			url: "/bbs/cmt/list.do",
			type: "GET",
			dataType: "json",
			data: { nttId: nttId },
			success: function(list) {
				drawCommentList(list);
			},
			error: function() {
				alert("댓글 목록 조회 실패");
			}
		});
	}

	function drawCommentList(list) {

		let html = "";
		$("#commentCnt").text(list.length);

		if (list.length === 0) {
			html += "<li class='comment-empty'>등록된 댓글이 없습니다.</li>";
			$("#commentList").html(html);
			return;
		}

		$.each(list, function(i, c) {
			html += "<li class='comment-item'>";
			html += "  <div class='comment-info'>";
			html += "    <span class='writer'>" + (c.frstRegisterId || "익명") + "</span>";
			html += "    <span class='date'>" + (c.frstRegistPnttm || "") + "</span>";
			html += "  </div>";
			html += "  <div class='comment-cn'>" + c.commentCn + "</div>";
			html += "</li>";
		});

		$("#commentList").html(html);
	}

});
