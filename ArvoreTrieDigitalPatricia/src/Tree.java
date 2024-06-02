class Tree {
    private No raiz;

    public void inserir(String palavra) {
        if (raiz == null) {
            raiz = new No();
        }
        No atual = raiz;
        for (int i = 0; i < palavra.length(); i++) {
            char c = palavra.charAt(i);
            int indice = c - 'a';
            if (atual.getFilho(indice) == null) {
                No aux = new No();
                atual.setFilho(indice,aux);
            }
            atual = atual.getFilho(indice);
        }
        atual.setPalavra(palavra);
    }

    public void exibirTodasPalavras() {
        if (raiz != null) {
            Fila fila = new Fila();
            fila.push(raiz); // Inicia a fila com a raiz
            while (!fila.isEmpty()) {
                No atual = (No) fila.pop(); // Conversão para tipo No
                if (atual.getPalavra() != null) {
                    System.out.println(atual.getPalavra());
                }
                for (int i = 0; i < No.ALFABETO_SIZE; i++) {
                    No filho = atual.getFilho(i);
                    if (filho != null) {
                        fila.push(filho);
                    }
                }
            }
        }
    }

    public boolean buscar(String palavra) {
        if (raiz == null) {
            return false;
        }
        No atual = raiz;
        for (int i = 0; i < palavra.length(); i++) {
            char c = palavra.charAt(i);
            int indice = c - 'a';
            if (atual.getFilho(indice) == null) {
                return false; // Palavra não encontrada
            }
            atual = atual.getFilho(indice);
        }
        return atual.getPalavra() != null; // Verifica se a palavra foi encontrada até o final
    }

    public void exibirNiveis() {
        if (raiz != null) {
            Fila fila = new Fila();
            fila.push(raiz); // Inicia a fila com a raiz
            No atual;
            while (!fila.isEmpty()) {
                int tamanhoNivel = fila.getTF();
                for (int i = 0; i < tamanhoNivel; i++) {
                    atual = fila.pop();
                    System.out.print(atual.getPalavra() + " ");
                    for (int j = 0; i < No.ALFABETO_SIZE; i++) {
                        No filho = atual.getFilho(i);
                        if (filho != null) {
                            fila.push(filho);
                        }
                    }
                }
                System.out.println(); // Nova linha para o próximo nível
            }
        }
    }
}