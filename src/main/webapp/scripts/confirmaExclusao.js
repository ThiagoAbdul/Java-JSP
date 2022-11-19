function confirmaExclusao(nome, id){
    
    const confirma = confirm(`Deseja excluir ${nome}?`)

    if(confirma){
        location.replace(`delete?id=${id}`)
    }
}

