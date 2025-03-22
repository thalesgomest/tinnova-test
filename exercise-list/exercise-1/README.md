# Enunciado: Votos em relação ao total de eleitores

## Considerando a tabela abaixo...

| Tipo de Voto       | Quantidade |
|--------------------|------------|
| **Total de eleitores** | 1000      |
| **Votos válidos**   | 800       |
| **Votos brancos**   | 150       |
| **Votos nulos**     | 50        |

## Tarefa  

Faça uma classe com três métodos que calculam:  

1. O percentual dos votos **válidos** em relação ao total de eleitores.  
2. O percentual de **brancos** em relação ao total de eleitores.  
3. O percentual de **nulos** em relação ao total de eleitores.  

### Dica  
*"Em relação ao total"* significa que você deve dividir, por exemplo:  
- **Nulos** pelo total de eleitores.  
- **Válidos** pelo total de eleitores.  
- **Brancos** pelo total de eleitores.  

Utilize **programação orientada a objetos (POO)**.

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
Abra o terminal ou prompt de comando e navegue até o diretório onde o arquivo Main.java está localizado (`votes_and_voters/src/com/tinnova`). Compile o código com o seguinte comando:

```bash
javac -d ..\..\..\out\production\  Main.java Election.java
```

## Execute o Código
Navegue para a pasta onde o código compilado foi armazenado (`votes_and_voters/out/production`) e então execute o código com o seguinte comando:

```bash
java com.tinnova.Main
```

