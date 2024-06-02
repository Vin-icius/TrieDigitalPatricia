class No {
    public static final int ALFABETO_SIZE = 26;
    private No[] filhos;
    private String palavra;

    public No() {
        filhos = new No[ALFABETO_SIZE];
        palavra = null;
    }

    public No getFilho(int pos) {
        return filhos[pos];
    }

    public void setFilho(int pos,No filho) {
        this.filhos[pos] = filho;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }
}
