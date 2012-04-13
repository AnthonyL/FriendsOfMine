if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}


function show_div(div_name) {
	document.getElementsByName(div_name)[0].style.display = "block";
}

function hidden_div(div_name) {
	document.getElementsByName(div_name)[0].style.display = "none";
}