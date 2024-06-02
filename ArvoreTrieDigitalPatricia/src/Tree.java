public class Tree {
    private No raiz;

    // Construtor
    public Tree() {
        this.raiz = new No();
    }

    // Método para inserir uma palavra na árvore
    public void inserir(String palavra) {
        if (raiz == null) {
            raiz = new No();
            raiz.setPalavra(palavra);
            return;
        }

        No atual = raiz;
        int indice = 0;

        // Encontra o nó onde a palavra diverge
        while (indice < palavra.length() && atual.getPalavra().charAt(indice) == palavra.charAt(indice)) {
            atual = atual.getFilho(palavra.charAt(indice) - 'a');
            indice++;
        }

        // Cria um novo nó para representar a divergência
        No novoNo = new No();
        novoNo.setPalavra(palavra.substring(indice));

        // Atualiza os filhos do novo nó
        No[] filhosNovoNo = new No[No.ALFABETO_SIZE];
        filhosNovoNo[palavra.charAt(indice) - 'a'] = atual.getFilho(palavra.charAt(indice) - 'a');
        novoNo.setFilho(filhosNovoNo);
        atual.setFilho(palavra.charAt(indice) - 'a', novoNo);

        // Atualiza a palavra do nó atual
        atual.setPalavra(atual.getPalavra().substring(0, indice));

        // Atualiza a posição do nó atual
        atual.setPosicao(indice);
    }

    // Método auxiliar para encontrar o índice onde há divergência entre duas palavras
    private int encontrarIndiceDivergencia(String palavra1, String palavra2, int pos) {
        if (palavra2 != null) {
            int tamMin = Math.min(palavra1.length(), palavra2.length());
            for (int i = pos; i < tamMin; i++) {
                if (palavra1.charAt(i) != palavra2.charAt(i)) {
                    return i;
                }
            }
            return tamMin;
        }
        return 0;
    }


    // Método para buscar uma palavra na árvore
    public boolean buscar(String palavra) {
        // Implementação da busca aqui
        return false;
    }

    // Método para exibir todas as palavras da árvore
    public void exibirTodasPalavras() {
        exibirTodasPalavrasRecursivo(raiz, "");
    }

    // Método recursivo para exibir todas as palavras da árvore a partir de um nó
    private void exibirTodasPalavrasRecursivo(No no, String prefixo) {
        if (no == null) {
            return;
        }

        // Concatena o prefixo atual com a palavra do nó
        String palavraCompleta = prefixo + no.getPalavra();

        // Se a palavra completa for uma palavra válida, imprime
        if (palavraCompleta.length() > 0) {
            System.out.println(palavraCompleta);
        }

        // Chama recursivamente para os filhos do nó
        for (No filho : no.getFilho()) {
            exibirTodasPalavrasRecursivo(filho, palavraCompleta);
        }
    }

    // Método para exibir todos os nós da árvore nível a nível
    public void exibirNosNivelANivel() {
        // Implementação para exibir nós nível a nível aqui
    }
}