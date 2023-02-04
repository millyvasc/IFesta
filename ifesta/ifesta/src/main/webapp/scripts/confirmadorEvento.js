function confirmar(codEvento, tipo){
	let resposta = confirm("Deseja excluir este evento?")
	if(resposta === true){
		window.location.href= "deleteEvento?codEvento=" + codEvento + "&tipo=" + tipo
	}
}