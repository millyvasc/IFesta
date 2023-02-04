function validarLembrete(){
	let nota = formLembrete.nota.value
	
	if(nota === ""){
		alert('Preencha o campo Nota!')
		return false
	}
	else{
		document.forms["formLembrete"].submit() 
	}
}