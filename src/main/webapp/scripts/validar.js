function validar(nomeFormulario){
    const formulario = document.forms[nomeFormulario];
    const inputs = formulario.elements;
    const nome = inputs["nome"].value;
    const telefone = inputs["telefone"].value;
    

    if(isVazio(nome)){
        alert("Preencha o nome");
        formCadastro.nome.focus();
        return false;
    }
    if(isVazio(telefone)){
        alert("Preencha o telefone");
        formCadastro.telefone.focus();
        return false;
    }
    
    let telefoneFormatado = formatarTelefone(telefone)
    if(isTelefone(telefoneFormatado)){
        inputs["telefone"].value = telefoneFormatado;
        formulario.submit();
    }
    else {
        alert("Preencha o telefone corretamente");
        formCadastro.telefone.focus();
        return false;
    }
    
}

function isVazio(campo){
    return campo === ""
}

function temParentesesNoPrefixo(telefone){
    return verificaRegex(telefone, /^[(][1-9]{2}[)]/)
}

function temHifen(telefone){
    return verificaRegex(telefone, /[-].{4}$/);
}

function isTelefone(telefone){
    return (verificaRegex(telefone, /^[0-9]{10}$/) || verificaRegex(telefone, /^[0-9]{11}$/));
}

function verificaRegex(texto, regex){
    if(texto.match(regex)) return true;
    return false;
}

function formatarTelefone(telefone){
    if(temParentesesNoPrefixo(telefone)){
        telefone = tirarParenteses(telefone)
    }
    if(temHifen(telefone)){
        telefone = tirarHifen(telefone)
    }
    return telefone;
}

function tirarParenteses(telefone){
    const prefixo = telefone.slice(1, 3)
    const posfixo = telefone.slice(4)
    return prefixo.concat(posfixo)
}

function tirarHifen(telefone){
    const indiceHifen = telefone.length - 5
    const primeiraParte = telefone.slice(0, indiceHifen)
    const segundaParte = telefone.slice(indiceHifen + 1)
    return primeiraParte.concat(segundaParte)
}

