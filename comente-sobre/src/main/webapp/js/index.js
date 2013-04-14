$(document).ready(function(){
	$("#enviar").click(function(){
		if ($("#descricao").val() == "") {
			$("#descricao").focus();
			return;
		}		
		$.ajax({
			url: './assunto/' + $("#descricao").val(),
			dataType: 'json',
			processData:false,
			success: function(data, textStatus, jqXHR) {
				if (data) {
					$(window).attr("location","./" + data.nome);
				}
			},
			failure: function(data, textStatus, jqXHR) {
				alert('Ocorreu um erro ao recuperar o assunto do comentário');
			},
			timeout: 10000,
			type: 'GET'
		});

	});		
});