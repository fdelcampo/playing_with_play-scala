

$(document).ready(function() {
	
	
	
	$("#table-users i").click(function(event) {
		event.preventDefault();
		var user_id = $(this).parent().parent().data("user");
		var role_id = $(this).parent().data("role");
		var icon = $(this).attr("class");
		console.log( user_id + " - " + role_id + " - " + icon );
		
		switch(icon){
		case "icon-ok":
			$(this).removeClass("icon-ok");
			$(this).addClass("icon-remove");
			$("#content").load("/usuarios/"+user_id+"/removerole/"+role_id);
			break;
		case "icon-remove":
			$(this).removeClass("icon-remove");
			$(this).addClass("icon-ok");
			$("#content").load("/usuarios/"+user_id+"/addrole/"+role_id);
			break;
		case "icon-edit":
			$("#modal-label").html("Editar Usuario");
			$("#modal .modal-body").load("/usuarios/"+user_id, function() {
				user_edit();
				$("#modal").modal('show');
			});
			break;
		case "icon-trash":
			$.ajax({
				  type: "DELETE",
				  url: "/usuarios/"+user_id,
				  data: ""
				}).done(function( msg ) {
					$("#content").load("/usuarios");
				});
			break;
		default:
			break;
		}
		
		
	});
	
	$("#btn-adduser").click(function(event) {
		event.preventDefault();
		$.get('/usuarios/crear', function(data) {
			  $("#modal-label").html("Crear Usuario");
			  $("#modal .modal-body").html(data, function(){
				  $("#modal").modal('show');
			  });
			  user_edit();
		});
	});


	
});

function user_edit(){
	

	
	$("#form-user").validate({
		rules: {
			name: "required",
			email: {
			    required: true,
			    email: true
			},
			password: {
				required: true,
				minlength: 6
			}
		},
		messages: {
				name: "Please specify your name",
				email: {
					required: "Please specify your email address",
					email: "Example: name@domain.com"
				},
				password:{
					required: "Please specify your password",
					minlength: "Required having at least 6 characters"
				}
		},
		highlight: function(element) {
		    $(element).closest('.control-group').removeClass('success').addClass('error');
		},
		success: function(element) {
		    element
		    .addClass('valid')
		.closest('.control-group').removeClass('error').addClass('success');
		},
		submitHandler: function(form) {
		  $(form).ajaxSubmit();
		} 
		  
	});
	
	
	$("#btn-form-user").click( function(event) {
		event.preventDefault();
		var form = $(this).parent().parent();
		console.log('email='+$("#email").val()+'&name='+$("#name").val()+'&password='+$("#password").val());
		if( $("#form-user").valid() == true )
			$.ajax({
				  type: form.attr("method"),
				  url: form.attr("action"),
				  data: 'email='+$("#email").val()+'&name='+$("#name").val()+'&password='+$("#password").val()
				}).done(function( msg ) {
					$("#content").load("/usuarios");
					$("#modal").modal('hide');
				});
	});
}