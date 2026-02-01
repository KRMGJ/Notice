(function(win, $) {
	"use strict";

	function getUrl(name) {
		return $("#bmRegForm").data(name);
	}

	$(function() {
		$("#btnList").on("click", function() {
			Bm.submit("#bmRegForm", getUrl("list-url"));
		});

		$("#btnSave").on("click", function() {
			if (!Bm.require($("#bbsNm").val(), "게시판명은 필수입니다.", "#bbsNm")) return;
			Bm.submit("#bmRegForm", getUrl("insert-url"));
		});
	});

})(window, jQuery);
