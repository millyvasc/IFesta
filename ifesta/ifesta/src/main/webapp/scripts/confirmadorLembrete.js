function confirmarLembrete(codLembrete, tipo){
	let resposta = confirm("Deseja excluir este lembrete?")
	if(resposta === true){
		window.location.href= "deleteLembrete?codLembrete=" + codLembrete + "&tipo=" + tipo
	}
}