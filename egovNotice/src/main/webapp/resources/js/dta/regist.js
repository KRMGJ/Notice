$(function() {

	$('#btnSave').on('click', function() {
		if ($('input[name=subject]').val().trim() === '') {
			alert('제목을 입력하세요.');
			$('input[name=subject]').focus();
			return;
		}

		if (confirm('등록하시겠습니까?')) {
			$('#dtaRegForm').submit();
		}
	});

	$('#btnList').on('click', function() {
		location.href = '/bbs/dta/list.do';
	});

});
