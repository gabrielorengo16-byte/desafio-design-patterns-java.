package br.com.desafio.descontos;

import java.math.BigDecimal;

public class DescontoDezPorCento implements DescontoStrategy {
    private static final BigDecimal TAXA = new BigDecimal("0.10");

    @Override
    public BigDecimal calcularDesconto(BigDecimal valor) {
        return valor.multiply(TAXA);
    }

    @Override
    public String getNome() {
        return "10%";
    }
}
