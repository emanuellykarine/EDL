package PilhaArrayAdicionaPilha;

public class PilhaArray implements Pilha{
    private int capacidade;    
    private Object[] array;
    private int t;
    private int FC;

    public PilhaArray(int capacidade, int crescimento) {
        this.capacidade = capacidade;
        t = -1;
        FC = crescimento;
        if (crescimento <= 0) {
            FC = 0;
        }

        array = new Object[capacidade];
    }

    public void push(Object o){
        if (t >= capacidade - 1){
            if (FC == 0) {
                capacidade = capacidade * 2;
            } else {
                capacidade = capacidade + FC;
            }

            Object novoArray[] = new Object[capacidade];
            for (int i = 0; i < array.length; i++){
                novoArray[i] = array[i];
            }

            array = novoArray;
        }

        array[++t] = o;
    }

    public Object pop() throws PilhaVaziaExcecao{
        if (isEmpty()){
            throw new PilhaVaziaExcecao("Pilha vazia");
        }

        Object remover = array[t--];
        return remover;
    }

    public Object top() throws PilhaVaziaExcecao{
        if (isEmpty()){
            throw new PilhaVaziaExcecao("Pilha vazia");
        }

        return array[t];
    }

    public boolean isEmpty(){
        return t == -1;
    }

    public int size(){
        return t+1;
    }

    public void adicionaPilha(Pilha p){
        int tamanhoP = p.size();
        PilhaArray pilhaAuxiliar = new PilhaArray(tamanhoP, 0);

        while (!p.isEmpty()){
            pilhaAuxiliar.push(p.pop()); //pilha p invertida
        }

        for (int i = 1; i <= tamanhoP; i++){
            Object objetoP = pilhaAuxiliar.pop(); //guarda o elemento 
            this.push(objetoP); //atribui pra pilha inicial
            p.push(objetoP); //atribui pra pilha 2
        }

    }
}
