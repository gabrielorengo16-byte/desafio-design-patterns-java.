package br.com.desafio.descontos;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final NumberFormat MOEDA =
            NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("==================================");
            System.out.println("   CALCULADORA DE DESCONTOS");
            System.out.println("   Design Pattern: Strategy");
            System.out.println("==================================");

            boolean continuar = true;

            while (continuar) {
                BigDecimal valor = lerValor(scanner);
                DescontoStrategy estrategia = escolherDesconto(scanner);

                CalculadoraDesconto calculadora = new CalculadoraDesconto(estrategia);

                BigDecimal desconto = calculadora.calcularDesconto(valor);
                BigDecimal valorFinal = calculadora.calcularValorFinal(valor);

                System.out.println("\n--------- RESULTADO ---------");
                System.out.println("Valor original: " + MOEDA.format(valor));
                System.out.println("Desconto aplicado: " + estrategia.getNome());
                System.out.println("Valor descontado: " + MOEDA.format(desconto));
                System.out.println("Total a pagar: " + MOEDA.format(valorFinal));
                System.out.println("-----------------------------");

                System.out.print("\nDeseja realizar outro cálculo? (S/N): ");
                continuar = scanner.nextLine().trim().equalsIgnoreCase("S");
                System.out.println();
            }

            System.out.println("Obrigado por utilizar a calculadora!");
        }
    }

    private static BigDecimal lerValor(Scanner scanner) {
        while (true) {
            System.out.print("Informe o valor da compra (ex.: 150,50): ");
            String entrada = scanner.nextLine().trim().replace(",", ".");

            try {
                BigDecimal valor = new BigDecimal(entrada);
                if (valor.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("O valor não pode ser negativo.");
                    continue;
                }
                return valor;
            } catch (NumberFormatException erro) {
                System.out.println("Valor inválido. Digite um número, como 150,50.");
            }
        }
    }

    private static DescontoStrategy escolherDesconto(Scanner scanner) {
        while (true) {
            System.out.println("\nEscolha uma opção de desconto:");
            System.out.println("1 - 5%");
            System.out.println("2 - 10%");
            System.out.println("3 - 15%");
            System.out.print("Opção: ");

            switch (scanner.nextLine().trim()) {
                case "1":
                    return new DescontoCincoPorCento();
                case "2":
                    return new DescontoDezPorCento();
                case "3":
                    return new DescontoQuinzePorCento();
                default:
                    System.out.println("Opção inválida. Escolha 1, 2 ou 3.");
            }
        }
    }
}
