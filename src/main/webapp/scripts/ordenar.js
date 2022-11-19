function ordenar(coluna){
    const tbody = document.querySelector("tbody");
    const linhas = tbody.rows;
    const crescente = (a, b) => {
        if(getTextoLinha(a, coluna) < getTextoLinha(b, coluna)){
            return -1;
        }
        else {
            return 1;
        }
    }
    const decrescente = (a, b) => crescente(a, b) * - 1;
    const ordenado = colunasOrdenadas[coluna];
    const linhasOrdenadas = Array.from(linhas).sort(ordenado? decrescente : crescente);

    colunasOrdenadas = colunasOrdenadas.map(c => !c)

    colunasOrdenadas[coluna] = !ordenado;

    clearChilds(tbody);

    linhasOrdenadas.forEach(e => {
        tbody.appendChild(e);
    })
}

function getTextoLinha(linha, coluna){
    const conteudo = linha.cells[coluna].textContent
    return coluna == 0? Number(conteudo) : conteudo;
}

function clearChilds(element){
    element.innerHTML = ""
}

let colunasOrdenadas = [false, false, false, false]
