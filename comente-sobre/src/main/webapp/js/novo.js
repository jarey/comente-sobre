$(document).ready(function(){

	$("textarea[maxlength]").keypress(function(event){
	    var key = event.which;
	     if(key >= 33 || key == 13) {
	        var maxLength = $(this).attr("maxlength");
	        var length = this.value.length;
	        if(length >= maxLength) {
	            event.preventDefault();
	        }
	    }
	});
	
		
	$("#form").validate({
		errorLabelContainer: $(".error"),		
		errorElement: "em",
		submitHandler: function(form) {
			form.submit();
		},
		rules: {
			"comentario.email": {
				required: true,
				email: true
			},
			"comentario.texto": {
				required: true
			}
		},
		messages: {			
			"comentario.email": {
				required: "Digite um e-mail",
				email: "Digite um e-mail v&aacute;lido"
			},
			"comentario.texto": {
				required: "Digite seu coment&aacute;rio",
			}
		}
	});

	
});