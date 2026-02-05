(function(win, $) {
	"use strict";

	function getUrl(name) {
		return $("#bmListForm").data(name);
	}

	win.fn_bm_page = function(pageNo) {
		Bm.setHidden("#bmListForm", "pageIndex", pageNo);
		Bm.submit("#bmListForm", getUrl("list-url"));
	};

	$(function() {
		$("#btnSearch").on("click", function() {
			win.fn_bm_page(1);
		});

		$("#btnRegistView").on("click", function() {
			Bm.submit("#bmListForm", getUrl("regist-view-url"));
		});

		// 상세 이동
		$(document).on("click", ".bm-link-detail", function(e) {
			e.preventDefault();
			var bbsId = $(this).data("bbs-id");
			Bm.setHidden("#bmListForm", "bbsId", bbsId);
			Bm.submit("#bmListForm", getUrl("detail-url"));
		});
	});

})(window, jQuery);
