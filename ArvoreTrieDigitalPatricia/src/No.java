public class No {
    public static final int ALFABETO_SIZE = 26;

    private char[] letras;
    private No[] filhos;
    private String palavra;
    private int posicao;

    // Construtor
    public No() {
        this.letras = new char[ALFABETO_SIZE];
        this.filhos = new No[ALFABETO_SIZE];
        this.palavra = null;
        this.posicao = -1;
    }

    // Getters e Setters
    public char[] getLetras() {
        return letras;
    }

    public void setLetras(char[] letras) {
        this.letras = letras;
    }

    public No[] getFilho() {
        return filhos;
    }

    public No getFilho(int pos) {
        return filhos[pos];
    }

    public void setFilho(No[] filhos) {
        this.filhos = filhos;
    }

    public void setFilho(int pos,No filho){
        this.filhos[pos] = filho;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
}