import java.util.Objects;

public class Programa {
    public static void main(String[] args_) {
        String[] args = {"multiplica","1","2","5","8","9"};

        if(Objects.nonNull(args) && args.length > 0) {
            if("soma".equals(args[0]) && args.length > 1) {
                Integer soma = 0;

                for(int i = 1; i < args.length; i++) {
                    soma = soma + Integer.valueOf(args[i]);
                }

                System.out.println("Resultado da soma: " + soma);

            } else if("multiplica".equals(args[0]) && args.length > 1) {
                Integer multiplicacao = 1;
                
                for(int i = 1; i < args.length; i++) {
                    multiplicacao = multiplicacao * Integer.valueOf(args[i]);
                }

                System.out.println("Resultado da multiplicação: " + multiplicacao);
            } else {
                System.out.println("A operação '" + args[0] + "' não existe!");
            }
        } else {
            System.out.println("Vetor vazio!");
        }

    }
}