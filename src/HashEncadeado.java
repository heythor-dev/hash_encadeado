public class HashEncadeado {

    static class Node {
        int chave;
        Node proximo;
        Node(int chave) {
            this.chave = chave;
            this.proximo = null;
        }
    }

    Node[] tabela = new Node[100];
    int[] ultimos = new int[3];
    int qtdUltimos = 0;

    int h(int chave) {
        return chave % 100;
    }

    void inserir(int chave) {
        int i = h(chave);
        Node novo = new Node(chave);

        if (tabela[i] == null) {
            tabela[i] = novo;
        } else {
            ultimos[qtdUltimos % 3] = chave;
            qtdUltimos++;

            if (chave < tabela[i].chave) {
                novo.proximo = tabela[i];
                tabela[i] = novo;
            } else {
                Node atual = tabela[i];
                while (atual.proximo != null && atual.proximo.chave < chave) {
                    atual = atual.proximo;
                }
                novo.proximo = atual.proximo;
                atual.proximo = novo;
            }
        }
    }

    int tamanhoLista(int i) {
        int tam = 0;
        Node p = tabela[i];
        while (p != null) {
            tam = tam + 1;
            p = p.proximo;
        }
        return tam;
    }
}