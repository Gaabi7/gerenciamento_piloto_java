# Software para criação de pilotos de F1 🏎️

## Funcionalidades atuais ✅

*O software já irá iniciar lendo o arquivo .txt para criar a lista de pilotos (se o arquivo estiver alguma informação)*

*Cadastrar piloto*
  - O usuário pode digitar o nome do piloto e o nome da equipe, porém o programa não  aceitará dados nulos.
  - O piloto é salvo no arquivo piloto.txt.
  - O novo piloto também é adicionado a uma lista em memória.

*Listar pilotos*
  - O sistema lê o arquivo piloto.txt e imprime os pilotos cadastrados no formato:
    
    - Nome (Equipe: NomeDaEquipe)
    

📂 *Popular a lista com base no arquivo*
  - Lê o conteúdo do arquivo piloto.txt.
  - Cria objetos Piloto e os adiciona à lista recebida como parâmetro.

✏️ *Editar piloto*
  - Lista os pilotos existentes e dá ao usuário a opção de alterar o nome e equipe  individualmente ou ambos. Se por exemplo o usuário desejar não alterar o nome basta deixar em branco.

🗑️ *Excluir piloto*
 - É possível também a exclusão de um piloto existente no arquivo


## 🗂️ Estrutura do Projeto
bash
📁 A3 MONTANHA/
├── 📁 src
│   ├── Piloto.java
│   ├── PilotoController.java
│   └── Sistema.java
├── piloto.txt
└── README.md


## Arquivos:

Piloto.java: Classe com os atributos do piloto e seus getters/setters.

PilotoController.java: Contém todas as funções utilizadas no funcionamento do software.

Sistema.java: Classe principal que executa o programa e faz o controle do menu e fluxos.

piloto.txt: Armazena os dados dos pilotos.

README.md: Explicações e instruções sobre o projeto.  

### 🚀 Como rodar o projeto

1. Clone o repositório:
```bash
git clone https://github.com/seuusuario/seuprojeto.git
```

2. Navegue até a pasta:
```bash
cd A3\ MONTANHA/src7
```

3. Compile os arquivos:
```bash
javac Sistema.java
```

4. Execute:
```bash
java Sistema
```


#### 👨‍💻 Alunos envolvidos
- Gabriela Rodrigues
- João Vitor da Silva
- Matheus Euriques
