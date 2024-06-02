public class Fila {
    private No[] elementos;
    private int TF;
    private int inicio;
    private int fim;
    private int tamanho;

    public Fila() {
        this.TF = 0;
        this.elementos = new No[0];
        this.inicio = 0;
        this.fim = 0;
        this.tamanho = 0;
    }

    public Fila(int capacidade) {
        this.TF = capacidade;
        this.elementos = new No[capacidade];
        this.inicio = 0;
        this.fim = 0;
        this.tamanho = 0;
    }

    public void push(No elemento) {
        if (tamanho == TF) {
            System.out.println("Fila cheia. Não é possível adicionar mais elementos.");
            return;
        }

        elementos[fim] = elemento;
        fim = (fim + 1) % TF; // Avança o ponteiro de fim circularmente
        tamanho++;
    }

    public No pop() {
        if (tamanho == 0) {
            System.out.println("Fila vazia. Não é possível remover elementos.");
            return null; // Retorna um valor inválido para indicar fila vazia
        }

        No elemento = elementos[inicio];
        inicio = (inicio + 1) % TF; // Avança o ponteiro de início circularmente
        tamanho--;
        return elemento;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == TF;
    }

    public int getTF() {
        return TF;
    }

    public void setTF(int TF) {
        this.TF = TF;
    }
}