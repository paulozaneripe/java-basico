import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Programa {
    public static void main(String[] args_) {
        String[] args = {"add","1","2"};

        if(Objects.nonNull(args) && args.length > 0) {
            if("soma".equals(args[0])) {
                somar(args);
            } else if("multiplica".equals(args[0])) {
                multiplicar(args);
            } else if("add".equals(args[0])) {
                adicionarLista(args);
            } else if("explica".equals(args[0])) {
                explicar(args);
            } else {
                System.out.println("A operação chamada '" + args[0] + "' não existe!");
                listar(args);
            }
        } else {
            System.out.println("Vetor vazio!");
        }

    }

    private static void somar(String[] args) {
        Integer soma = 0;

        for(int i = 1; i < args.length; i++) {
            soma = soma + Integer.valueOf(args[i]);
        }

        System.out.println("Resultado da soma: " + soma);
    }

    private static void multiplicar(String[] args) {
        Integer multiplicacao = 1;
        
        for(int i = 1; i < args.length; i++) {
            multiplicacao = multiplicacao * Integer.valueOf(args[i]);
        }

        System.out.println("Resultado da multiplicação: " + multiplicacao);
    }

    private static void adicionarLista(String[] args) {
        List<String> compras = new ArrayList<>();
        Integer i = 1;
        while (i < args.length) {
            compras.add(args[i]);
            ++i;
        }

        System.out.println(Arrays.toString(compras.toArray()));
    }

    private static void explicar(String[] args) {
        Integer i = 0;

        System.out.println("i = 0 ");
        System.out.println("i++ = " + i++);
        System.out.println("i = " + i);

        i = 0;
        System.out.println("\ni = 0 ");
        System.out.println("++i = " + ++i);
        System.out.println("i = " + i);
    }

    private static void listar(String[] args) {
        for (String arg: args) {
            System.out.println(arg);
        }
    }
}