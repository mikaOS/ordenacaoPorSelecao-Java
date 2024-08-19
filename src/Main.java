import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            String input = scanner.nextLine();

            // se o input for "FIM", quebra o loop
            if (input.equals("FIM")) {
                break;
            }

            int[] lista = separaString(input);
            int resultado = contador(lista);
            for (int i = 0; i < lista.length; i++) {
                System.out.print(lista[i] + " ");
            }
            System.out.println();
            System.out.println("Comparacoes realizadas: " + resultado);

        } while (true);
    }

    public static int[] separaString(String input) {
        String[] elementos = input.split(";");
        int[] lista = new int[elementos.length];

        for (int i = 0; i < elementos.length; i++) {
            lista[i] = Integer.parseInt(elementos[i]);
        }
        return lista;
    }

    public static int contador(int[] lista) {
        int contador = 0;
        for (int i = 0; i < lista.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < lista.length; j++) {
                contador++;
                if (lista[j] < lista[menor]) {
                    menor = j;
                }
            }
            int temp = lista[i];
            lista[i] = lista[menor];
            lista[menor] = temp;
        }
        return contador;
    }
}