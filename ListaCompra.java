import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListaCompra {
    public static void main(String[] args) {
        Integer menu = 0;
        String valor;
        List<String> compras = new ArrayList<>();

        try(Scanner ler = new Scanner(System.in)) {

            menu = 0;

            do {
                System.out.print("\nMenu\n\n1 - Adicionar Produto\n2 - Listar\n3 - Sair\n\nOpção: ");
                valor = ler.next();

                if(valor.matches("^[1-3]")) {

                    menu = Integer.parseInt(valor);

                    if(menu.equals(1)) {
                        System.out.print("\nDigite o nome do produto que deseja adicionar: ");
                        valor = ler.next();
                        compras.add(valor);
                        menu = 0;
                    } else if (menu.equals(2)) {
                        System.out.println("\n" + Arrays.toString(compras.toArray()));
                        menu = 0;
                    }

                } else {
                    menu = 0;
                    System.err.print("\nOpção inválida! Tente novamente\n"); 
                }

            } while(menu != 3);

            System.out.println();

        } catch (Exception e) {
            System.err.println("Valor inválido!");
        }
    }
}
