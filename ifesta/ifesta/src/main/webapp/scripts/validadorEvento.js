function validar(){
	let nome = formEvento.nome.value
	let descricao = formEvento.descricao.value
	let data = formEvento.data.value
	let horario = formEvento.horario.value
	let lugar = formEvento.lugar.value
	var tipo = document.getElementById("tipo").value;
	let outroAtributo = formEvento.outroAtributo.value
	if(nome === "" ||descricao === "" || data === "" || horario === "" || lugar === "" || tipo === "" || outroAtributo === ""){
		alert('Preencha todos os campos!')
		return false
	}
	else{
		document.forms["formEvento"].submit()
	}
}


function validarEdicao(){
	let nome = formEvento.nome.value
	let descricao = formEvento.descricao.value
	let data = formEvento.data.value
	let horario = formEvento.horario.value
	let lugar = formEvento.lugar.value
	let outroAtributo = formEvento.outroAtributo.value
	var situacao = document.getElementById("situacao").value;
	
	if(nome === "" ||descricao === "" || data === "" || horario === "" || lugar === "" || outroAtributo === "" || situacao === ""){
		alert('Preencha todos os campos!')
		return false
	}
	else{
		document.forms["formEvento"].submit()
	}
}


function updateField() {
	
	let escolha = document.getElementById("escolha");
	escolha.style.display = "block";
	let selecionado = document.getElementById('tipo').value;
	if(selecionado === "Evento Social"){
		document.getElementById('valor').innerHTML = "Comemoração";	
	}else if( selecionado == "Evento Acadêmico"){
		document.getElementById('valor').innerHTML = "Carga Horária";
	}else if(selecionado == 'Evento Cultural'){
		document.getElementById('valor').innerHTML = "Apresentação";	
	}
	else{
		escolha.style.display = "none";
	}
}