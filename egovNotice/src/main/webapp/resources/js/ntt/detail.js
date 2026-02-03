$(function() {
	$("#btnList").on("click", function() {
		location.href = "/notice/list.do";
	});

	$("#btnEdit").on("click", function() {
		var id = "${notice.nttId}";
		location.href = "/notice/form.do?nttId=" + encodeURIComponent(id);
	});

	$("#btnDelete").on("click", function() {
		if (!confirm("삭제하시겠습니까?"))
			return;
		var id = "${notice.nttId}";
		location.href = "/notice/delete.do?nttId=" + encodeURIComponent(id);
	});
});