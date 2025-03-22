# Algoritmo de ordenação Bubble Sort
Imagine o seguinte vetor

```
v = {5, 3, 2, 4, 7, 1, 0, 6}
```

Faça um algoritmo que ordene o vetor acima utilizando o **Bubble Sort**.

O Bubble Sort ordena de par em par. Ele pega os dois primeiros elementos e pergunta se o primeiro é maior que o segundo. 
Se sim, os elementos são trocados (swap), se não, são mantidos. Vai repetindo o processo até o final do vetor.
Obviamente que ele não consegue ordenar todo o vetor em uma única rodada, ele terá que passar pelo vetor um certo número de vezes.
De maneira mais formal podemos destacar:
1.Percorra o vetor inteiro comparando elementos adjacentes (dois a dois)
2.Troque as posições dos elementos se eles estiverem fora de ordem
3.Repita os dois passos acima (n - 1) vezes, onde n é igual ao tamanho do vetor
OK, vamos fazer um exemplo para facilitar o entendimento. Voltemos ao nosso vetor.
```
5, 3, 2, 4, 7, 1, 0, 6
```

Sabemos que iremos repetir o vetor *n -1* vezes. O tamanho do vetor é 8, logo iremos repetir 7 vezes o vetor (8-1).

Vamos chamar cada repetição de iteração. Então, na **primeira iteração**, pegamos os dois primeiros valores e trocamos se estiverem fora de ordem.

| Estado do Vetor      | Ação                              |
|----------------------|----------------------------------|
| (5 3) 2 4 7 1 0 6   | Pegamos o primeiro par          |
| 3--5 2 4 7 1 0 6    | Trocamos                         |
| 3 (5 2) 4 7 1 0 6   | Pegamos o próximo par           |
| 3 2--5 4 7 1 0 6    | Trocamos                         |
| 3 2 (5 4) 7 1 0 6   | Pegamos o próximo par           |
| 3 2 4--5 7 1 0 6    | Trocamos                         |
| 3 2 4 (5 7) 1 0 6   | Pegamos o próximo par           |
| 3 2 4 5--7 1 0 6    | Mantemos <----                   |
| 3 2 4 5 (7 1) 0 6   | Pegamos o próximo par           |
| 3 2 4 5 1--7 0 6    | Trocamos                         |
| 3 2 4 5 1 (7 0) 6   | Pegamos o próximo par           |
| 3 2 4 5 1 0--7 6    | Trocamos                         |
| 3 2 4 5 1 0 (7 6)   | Pegamos último par              |
| 3 2 4 5 1 0 6--7    | Trocamos                         |

Chegamos ao fim da primeira iteração e, como dito, não foi suficiente para ordenar o vetor.
Teremos que reiniciar, só que agora sabemos que, pelo menos, o último valor (7) já está em seu devido lugar
Então iremos marcá-lo e não precisaremos percorrer todo o vetor na segunda iteração. 
```
3 2 4 5 1 0	6 [7]
```

Esse detalhe é importante é fará toda a diferença no entendimento do algoritmo.
Todo esse processo se repetirá até que todos os itens estejam devidamente ordenados.

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
Abra o terminal ou prompt de comando e navegue até o diretório onde o arquivo Main.java está localizado (`bubble_sort\src\com\tinnova`). Compile o código com o seguinte comando:

```bash
javac -d ..\..\..\out\production\  BubbleSort.java
```

## Execute o Código
Navegue para a pasta onde o código compilado foi armazenado (`bubble_sort\out\production`) e então execute o código com o seguinte comando:

```bash
java com.tinnova.BubbleSort
```