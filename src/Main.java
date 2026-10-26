import java.util.Random;

public class Main {
    public static void main(String[] args) {
        HashEncadeado hash = new HashEncadeado();
        Random random = new Random(1090);

        for (int n = 0; n < 1000; n++) {
            hash.inserir(random.nextInt(100001));
        }

        int vazias = 0, listas = 0, maior = 0, posMaior = 0;
        for (int i = 0; i < 100; i++) {
            int tam = hash.tamanhoLista(i);
            if (tam == 0) vazias++;
            if (tam > 1) listas++;
            if (tam > maior) { maior = tam; posMaior = i; }
        }

        System.out.println("Posições vazias: " + vazias);
        System.out.println("Listas encadeadas: " + listas);

        System.out.println("Maior lista (posição " + posMaior + ", " + maior + " elementos):");
        HashEncadeado.Node p = hash.tabela[posMaior];
        while (p != null) {
            System.out.print(p.chave + " ");
            p = p.proximo;
        }
        System.out.println();

        System.out.println("Últimos 3 inseridos em listas:");
        for (int k = 0; k < 3 && k < hash.qtdUltimos; k++) {
            System.out.println(hash.ultimos[(hash.qtdUltimos + k) % 3]);
        }
    }
}