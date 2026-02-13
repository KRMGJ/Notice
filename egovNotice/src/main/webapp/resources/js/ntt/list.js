function fn_egov_link_page(pageNo) {
	$("#searchForm input[name='pageIndex']").val(pageNo);
	$("#searchForm").attr("action", "/bbs/notice/list.do").submit();
}

$(function() {
	$("#btnSearch").on("click", function() {
		$("#searchForm input[name='pageIndex']").val(1);
		$("#searchForm").attr("action", "/bbs/notice/list.do").submit();
	});
	$("#btnReg").on("click", function() {
		location.href = "/bbs/notice/form.do";
	});
});

$(document).ready(function() {

	// 전체 선택
	$("#checkAll").on("click", function() {
		$("input[name='nttId']").prop("checked", $(this).is(":checked"));
	});

	// 선택 삭제
	$("#btnDelete").on("click", function() {

		const checked = $("input[name='nttId']:checked");

		if (!confirm("선택한 게시글을 삭제하시겠습니까?")) {
			return;
		}

		let nttIdArr = [];

		checked.each(function() {
			nttIdArr.push($(this).val());
		});

		$.ajax({
			url: "/bbs/notice/deleteList.do",
			type: "POST",
			traditional: true,
			data: { nttIdList: nttIdArr },
			success: function() {
				alert("삭제되었습니다.");
				location.reload();
			},
			error: function() {
				alert("삭제 중 오류가 발생했습니다.");
			}
		});

	});

});

$(function() {

	$(document).on("click", ".parent-title", function(e) {

		if ($(e.target).is("a")) return;

		const rootId = $(this).data("root");

		const children = $(".nt-reply-row[data-root='" + rootId + "']");

		const icon = $(this).find(".toggle-icon");

		if (children.first().is(":visible")) {
			children.hide();
			icon.text("▶");
		} else {
			children.show();
			icon.text("▼");
		}

	});

});



$(function() {

	$(document).on("click", ".btnReply", function(e) {

		e.stopPropagation();

		const parentId = $(this).data("parent");
		const row = $(this).closest("tr");

		let targetRow = row;
		if (row.next().hasClass("nt-content")) {
			targetRow = row.next();
		}

		$("#parntNttId").val(parentId);

		$("#replyRow")
			.insertAfter(targetRow)
			.show();

	});

	$("#btnCancelReply").on("click", function() {
		$("#replyRow").hide();
	});

});


