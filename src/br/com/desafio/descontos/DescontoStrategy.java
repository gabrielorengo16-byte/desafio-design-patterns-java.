package br.com.desafio.descontos;

import java.math.BigDecimal;

/**
 * Contrato para estratégias de cálculo de desconto.
 */
public interface DescontoStrategy {
    BigDecimal calcularDesconto(BigDecimal valor);
    String getNome();
}
