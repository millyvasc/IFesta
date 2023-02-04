function validar(){
	let matricula = formUsuario.matricula.value
	let nome = formUsuario.nome.value
	let telefone = formUsuario.telefone.value
	let email = formUsuario.email.value
	let senha = formUsuario.senha.value
	if( matricula === "" || nome === "" ||telefone === "" || email === "" || senha === ""){
		alert('Preencha todos os campos!')
		return false
	}
	else{
		document.forms["formUsuario"].submit() 
	}
}