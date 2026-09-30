# Prova Estrutura de Dados
# Sistema de Gerenciamento de Produtos (CRUD em Java)

Um sistema de linha de comandos (CLI) desenvolvido em **Java** para o gerenciamento de produtos, focado em boas práticas de programação, separação de responsabilidades e eficiência de desempenho através de estruturas de dados avançadas.

---

## 🚀 Tecnologias e Conceitos Utilizados
* **Java** (Estruturas de repetição, tratamento de exceções, orientação a objetos)
* **Estrutura de Dados:** `LinkedHashMap<Integer, product>`
* **Arquitetura em Camadas:** Separação de responsabilidades (`Model`, `Service`, `App`)
* **Robustez de Entrada:** Tratamento de erros (`try-catch`) com limpeza de buffer do `Scanner` para evitar loops infinitos no terminal.

---

## 📂 Estrutura do Projeto

O projeto segue uma arquitetura limpa dividida em três pacotes principais:

1. **`model` (`product.java`):** 
   * Representa a entidade de negócio. Contém os atributos fundamentais do produto (`id`, `name`, `description`), o construtor e os respetivos *getters* e *setters*.
2. **`service` (`productService.java`):** 
   * Concentra toda a regra de negócio e manipulação dos dados. Utiliza um `LinkedHashMap` para garantir alta performance e manter a ordem de cadastro.
3. **`app` (`app.java`):** 
   * Controla a interface de linha de comandos (CLI), exibindo o menu interativo, gerindo a interação com o utilizador e executando o mapeamento das opções do CRUD.

---

## 💡 Por que `LinkedHashMap`?

A escolha do **`LinkedHashMap`** para este projeto baseou-se em dois fatores cruciais de desempenho e usabilidade:
* **Busca Instantânea $O(1)$:** Ao utilizar o ID (`Integer`) como chave do mapa, operações de busca, verificação de existência, atualização e remoção ocorrem de forma imediata, sem necessidade de percorrer listas sequencialmente.
* **Ordem de Inserção:** Diferente de um `HashMap` tradicional (cuja ordem de listagem é imprevisível), o `LinkedHashMap` mantém rigorosamente a ordem em que os produtos foram registados, proporcionando uma listagem organizada.

---

## ✨ Funcionalidades (CRUD)

* **[1] Cadastrar Novo Registo:** Insere um novo produto validando instantaneamente a unicidade do ID para impedir duplicados.
* **[2] Listar Todos:** Percorre o mapa utilizando `entrySet()` e um ciclo *for-each* para exibir todos os produtos ordenados por inserção.
* **[3] Buscar por ID:** Localiza de forma direta o produto associado à chave informada.
* **[4] Atualizar Registo:** Permite alterar o ID, nome e descrição de um produto já existente de forma sincronizada.
* **[5] Remover Registo:** Apaga o item do mapa de forma instantânea através da chave.

---

## 🛠️ Como Executar o Projeto

1. Certifica-te de que tens o **JDK (Java Development Kit)** instalado na sua máquina.
2. Clona este repositório ou descarrega os ficheiros fonte organizados nos respetivos pacotes (`app`, `service`, `model`).
3. Compile os ficheiros a partir da raiz do projeto.
 
