package br.com.desafio.descontos;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Contexto do Strategy: delega o cálculo para a estratégia escolhida.
 */
public class CalculadoraDesconto {
    private DescontoStrategy estrategia;

    public CalculadoraDesconto(DescontoStrategy estrategia) {
        definirEstrategia(estrategia);
    }

    public void definirEstrategia(DescontoStrategy estrategia) {
        if (estrategia == null) {
            throw new IllegalArgumentException("A estratégia de desconto não pode ser nula.");
        }
        this.estrategia = estrategia;
    }

    public BigDecimal calcularValorFinal(BigDecimal valorOriginal) {
        if (valorOriginal == null || valorOriginal.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O valor deve ser maior ou igual a zero.");
        }

        BigDecimal desconto = estrategia.calcularDesconto(valorOriginal);
        return valorOriginal.subtract(desconto).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calcularDesconto(BigDecimal valorOriginal) {
        return estrategia.calcularDesconto(valorOriginal).setScale(2, RoundingMode.HALF_UP);
    }

    public String getNomeEstrategia() {
        return estrategia.getNome();
    }
}
