package br.com.desafio.descontos;

import java.math.BigDecimal;

public class DescontoCincoPorCento implements DescontoStrategy {
    private static final BigDecimal TAXA = new BigDecimal("0.05");

    @Override
    public BigDecimal calcularDesconto(BigDecimal valor) {
        return valor.multiply(TAXA);
    }

    @Override
    public String getNome() {
        return "5%";
    }
}
