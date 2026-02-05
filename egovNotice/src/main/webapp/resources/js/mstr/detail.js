(function(win, $) {
	"use strict";

	function getUrl(name) {
		return $("#bmDetailForm").data(name);
	}

	$(function() {
		$("#btnList").on("click", function() {
			Bm.submit("#bmDetailForm", getUrl("list-url"));
		});

		$("#btnUpdateView").on("click", function() {
			Bm.submit("#bmDetailForm", getUrl("update-view-url"));
		});
	});

})(window, jQuery);
