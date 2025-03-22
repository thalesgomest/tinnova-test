# Fatorial
Faça um programa que calcule o fatorial de um número qualquer.
Vamos lembrar o que é o fatorial?
Seja n um número natural, tal que n >= 2, chama-se fatorial de n o produto de todos os números naturais

consecutivos de n até 1. Por exemplo,

```
5! = 1 x 2 x 3 x 4 x 5 = 120
```
Veja mais alguns resultados e que você poderá utilizar como testes:

```
0! = 1
1! = 1
2! = 2
3! = 6
4! = 24
5! = 120
6! = 720
````

Atente que O! = 1 porque o produto vazio (produto de nenhum número) é 1.


# ⚙ Como executar?

## Pré-requisitos

Antes de executar o programa, você precisa garantir que tenha o Java Development Kit (JDK) instalado em sua máquina.

1. Instalar o JDK
Baixe e instale o JDK mais recente da [Oracle JDK](https://www.oracle.com/java/technologies/downloads/).

Após a instalação, verifique se o Java foi instalado corretamente, executando o seguinte comando no terminal ou prompt de comando:

```bash
java -version
```

## Compile o Código
Abra o terminal ou prompt de comando e navegue até o diretório onde o arquivo Main.java está localizado (`factorial\src\com\tinnova`). Compile o código com o seguinte comando:

```bash
javac -d ..\..\..\out\production\  Factorial.java
```

## Execute o Código
Navegue para a pasta onde o código compilado foi armazenado (`factorial\out\production`) e então execute o código com o seguinte comando:

```bash
java com.tinnova.Factorial
```