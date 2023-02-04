function confirmar(matricula){
	let resposta = confirm("Deseja excluir este usuário ?")
	if(resposta === true){
		window.location.href= "delete?matricula=" + matricula
		session.invalidate();
	}
}