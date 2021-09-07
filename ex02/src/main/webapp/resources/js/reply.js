/**
 * 
 */

let replyService = (function() {
	function add(callback, error) {
		$.ajax({
			url: "../replies/",
			data: $('#replyForm').serialize(),
			method: 'post',
			dataType: 'json',
			success: function(data) {
				if (callback) callback(data);
			},
			error: function() {
				if (error) error();
			}
		});
	}

	//목록
	function getList(param, callback, error) {
		$.ajax({
			url: "../replies",
			data: param,
			dataType: "json",
			success: function(data) { if (callback) callback(data); },
			error: function() { if (error) error(); }
		});
	}

	return { add: add, getList: getList }
})();