package FilaVector;

public interface Fila {
    public void enqueue(Object o);
    public Object dequeue() throws FilaVaziaExcecao;
    public Object first() throws FilaVaziaExcecao;
    public int size();
    public boolean isEmpty(); 
}
