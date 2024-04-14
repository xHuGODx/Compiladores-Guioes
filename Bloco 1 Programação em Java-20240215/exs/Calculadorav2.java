package exs;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Calculadora_simples {
    private static Scanner scanner;
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();

        System.out.println("Digite a operação no formato <número> <operador> <número>:");

        while(scanner.hasNext()){

        if (scanner.hasNextDouble()){
            double num1 = scanner.nextDouble();
            String operator = scanner.next().trim();
            double num2 = scanner.nextDouble();
            double res = 0;
            switch (operator) {
                case "+":
                    res = num1 + num2;
                    break;
                case "-":
                    res = num1 - num2;
                    break;
                case "=":
                    
                    break;
                case "*":
                    res = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        res = num1 / num2;
                    } else {
                        System.err.println("Erro: Divisão por zero não é permitida.");
                    }
                    break;
                default:
                    System.err.println("Erro: Operador inválido.");
                    break;
            }
            System.out.printf("%f %s %f = %f\n", num1, operator, num2, res);
        }

        
        
        }    
    }
    static {
        scanner = new Scanner(System.in);
     }
}
