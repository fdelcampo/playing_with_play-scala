



$(document).ready(function() {
  
	$(".topbar ul a").click(function(event) {
		event.preventDefault();
		
		$(".topbar li").removeClass("active");
		
		$(this).parent().addClass("active");
		
		console.log($(this).attr('href'));
		$("#content").load($(this).attr('href'));
	});
	
	
	$("#modal").modal({
		  keyboard: false,
		  show: false
	});
	
	

	
});

