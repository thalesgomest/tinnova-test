# 🚙 Client de Cadastro e Gerenciamento de Veículos Tinnova

Este é o cliente de cadastro e gerenciamento de veículos, desenvolvido com **Vite** e a biblioteca **ShadUI**. O cliente permite visualizar, adicionar, excluir e filtrar veículos pela marca, cor e ano.

## ✅ Pré-requisitos

- **Node.js** (Recomendado: versão 16.x ou superior)
- **npm** (Recomendado: versão 7.x ou superior)

## ⚙ Passos para Baixar e Subir o Cliente

### 1. Clonar o Repositório

Para começar, clone o repositório em sua máquina local:

```bash
git clone https://github.com/thalesgomest/tinnova-test.git
cd tinnova-client
```

### 2. Instalar as Dependências

Com o repositório clonado, execute o seguinte comando para instalar as dependências do projeto:

```bash
pnpm install
```
#### Variáveis de Ambiente
É uma boa prática criar como variável de ambiente a URL do servidor, caso seja necessário. No entanto, para este caso a mesma
está hardcoded no código. Portanto é muito importante que o servidor esteja rodando localmente em `http://localhost:8080`.

### 3. Subir o Cliente

Agora que as dependências foram instaladas, execute o seguinte comando para subir o cliente:

```bash
pnpm dev
```
Isso iniciará o servidor de desenvolvimento e você verá uma mensagem como a seguinte no terminal:

```perl
VITE v2.6.10  ready in 300ms

  ➜  Local:   http://localhost:5173/
  ➜  Network: use `--host` to expose
```
O cliente estará disponível no endereço disponível no terminal no seu navegador.

### 4. Funcionalidades

A partir desse ponto, você poderá a partir do Client:

✅ Visualizar a lista de veículos cadastrados.

✅ Filtrar os veículos por marca, cor ou ano.

✅ Adicionar novos veículos ao sistema.

✅ Excluir veículos existentes.

## 🛠 Tecnologias Utilizadas
- Vite: Ferramenta de build para desenvolvimento rápido e eficiente.
- React: Biblioteca para construir interfaces de usuário.
- ShadUI: Biblioteca de componentes de interface do usuário.
- React Toastify: Biblioteca para mostrar notificações de sucesso ou erro.
- Lucide React: Biblioteca de ícones.
- Tailwind CSS: Framework de estilo CSS.

## 📩 Contato
Se você tiver alguma duvida, por favor entre em contato com pelo e-mail `thalestargino@gmail.com`.




