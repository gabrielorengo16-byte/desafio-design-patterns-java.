# Calculadora de Descontos — Design Pattern Strategy

Projeto desenvolvido em **Java puro**, sem frameworks ou bibliotecas externas, para demonstrar a aplicação prática do padrão comportamental **Strategy**.

## Objetivo

Calcular o valor final de uma compra a partir de diferentes estratégias de desconto. O usuário informa o valor da compra e escolhe um desconto de 5%, 10% ou 15%.

## Padrão aplicado: Strategy

O Strategy permite definir uma família de algoritmos, encapsular cada um em uma classe e trocar o algoritmo utilizado sem alterar o código que o utiliza.

Neste projeto:

- `DescontoStrategy`: interface que define o contrato para qualquer estratégia de desconto.
- `DescontoCincoPorCento`, `DescontoDezPorCento` e `DescontoQuinzePorCento`: implementações concretas do cálculo.
- `CalculadoraDesconto`: contexto que utiliza a estratégia escolhida e calcula o resultado.
- `Main`: interação com o usuário pelo terminal.

### Por que usar Strategy?

Sem esse padrão, a lógica de cada desconto poderia ficar concentrada em vários `if/else` dentro da calculadora. Com Strategy, cada regra fica isolada em sua própria classe. Para adicionar outro desconto, basta criar uma nova implementação da interface, sem modificar as estratégias existentes.

## Estrutura do projeto

```text
desafio-design-patterns-java/
├── src/
│   └── br/com/desafio/descontos/
│       ├── Main.java
│       ├── DescontoStrategy.java
│       ├── CalculadoraDesconto.java
│       ├── DescontoCincoPorCento.java
│       ├── DescontoDezPorCento.java
│       └── DescontoQuinzePorCento.java
├── .gitignore
└── README.md
```

## Requisitos

- JDK 17 ou superior.
- Terminal ou IDE Java, como IntelliJ IDEA, Eclipse ou VS Code.

## Como executar

Abra o terminal na pasta do projeto.

### Windows (PowerShell)

```powershell
$arquivos = Get-ChildItem -Recurse src -Filter *.java
javac -d out $arquivos.FullName
java -cp out br.com.desafio.descontos.Main
```

### Linux / macOS

```bash
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out br.com.desafio.descontos.Main
```

## Exemplo de uso

```text
==================================
   CALCULADORA DE DESCONTOS
   Design Pattern: Strategy
==================================
Informe o valor da compra (ex.: 150,50): 200

Escolha uma opção de desconto:
1 - 5%
2 - 10%
3 - 15%
Opção: 2

--------- RESULTADO ---------
Valor original: R$ 200,00
Desconto aplicado: 10%
Valor descontado: R$ 20,00
Total a pagar: R$ 180,00
-----------------------------
```

## Conceitos demonstrados

- Interfaces e implementações.
- Polimorfismo.
- Encapsulamento de comportamentos.
- Separação de responsabilidades.
- Princípio Aberto/Fechado (OCP): novas estratégias podem ser adicionadas sem modificar a calculadora.
- Uso de `BigDecimal` para cálculos monetários.

## Possíveis evoluções

- Adicionar descontos para clientes ou produtos específicos.
- Criar testes automatizados.
- Registrar o histórico dos cálculos.
- Permitir que o usuário informe um percentual personalizado.

---

Projeto acadêmico desenvolvido para praticar Design Patterns com Java.
