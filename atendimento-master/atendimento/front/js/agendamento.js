
obterAgencias();

function obterAgencias(){
    fetch("http://localhost:8080/agencias")
    .then(res => res.json())
    .then(res => preencheAgencias(res));
}

function preencheAgencias(res) {
    let agencias;

    for (let index = 0; index < res.length; index++) {
        agencias = agencias + `<option value = ${res[index].id} > ${res[index].nome} </option>`;
        
    }

    document.getElementById("sel_agencias").innerHTML = agencias;
    
}