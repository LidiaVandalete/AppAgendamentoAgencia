function validaLogin(){

    let userTxt = localStorage.getItem('userLogged'); //pega no local storage se o usuario está logado

    if(!userTxt){
        window.location= "index.html"; 
    }

    //trasnformar novamente o userTxt e JSON
    let jsonUser = JSON.parse(userTxt);
    
    //jogar dados no front
    document.getElementById("user").innerHTML = `<br>${jsonUser.nome} (${jsonUser.racf})`; // usar a crase serve para fazer uma string sem preciasr concatenar. utilizar ${variavel}
    document.getElementById("imgUser").innerHTML = `<img src="${jsonUser.linkFoto}">`;

    obterAgencias();
}



function logout(){
    localStorage.removeItem("userLogged");
    window.location = "index.html";
}

function obterAgencias(){
    //este cara vai buscar os dados no banco de dados e trazer


    // usar fetch() para isso
    let res = fetch('http://localhost:8080/agencias')
    .then(res => res.json())
    .then(res => preencheAgencias(res));
    
}

function preencheAgencias(res){
    let agencias;

    for (let index = 0; index < res.length; index++){
        agencias = agencias + `<option value = ${res[index].id}>${res[index].nome_agencia}</option>`;
    }
    document.getElementById("sel_agencias").innerHTML = agencias;
}