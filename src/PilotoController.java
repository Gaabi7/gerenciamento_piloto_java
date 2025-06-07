//Criado um arquivo controlador pra ficar mais facil e de melhor manutenção
// quando necessario criar, editar ou apagar um piloto
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class PilotoController {
    //cria um metodo para cadastar os pilotos
    //a lista é criada dentro de 'Sistema.java' e salva os dados do piloto
    //aqui a função recebe como parametro um scanner, e um Array chamado lista
    public static void cadastrarPiloto(Scanner scanner, ArrayList<Piloto> lista) {
        System.out.printf("Digite o nome do piloto: ");
        String nome = scanner.nextLine().trim();
        if (nome.isEmpty()) {
            limparTela();
            System.out.println("Nome não pode ser vazio!");
            return;
        }
        System.out.printf("Digite a equipe: ");
        String equipe = scanner.nextLine().trim();
        if (equipe.isEmpty()) {
            limparTela();
            System.out.println("Equipe não pode ser vazia!");
            return;
        }

        Piloto novoPiloto = new Piloto(nome, equipe);
        lista.add(novoPiloto);

        try {
            FileWriter escritor = new FileWriter("piloto.txt");
            for (Piloto c : lista) {
                escritor.write(c.toString() + "\n");
            }
            limparTela();
            System.out.println("-------------------");
            System.out.println("Piloto adicionado!");
            System.out.println("-------------------");
            escritor.close();
        } catch (IOException e){
            limparTela();
            System.out.println("Erro ao gravar no arquivo.");
            e.printStackTrace();

        }  
    }  

    //Metodo para listar
    public static void listarPilotos(Scanner scanner, ArrayList<Piloto> lista ) {
        limparTela();
        System.out.println("Lista de pilotos cadastrados");
        try {
            BufferedReader leitor = new BufferedReader(new FileReader("piloto.txt"));
            //pega o conteudo do arquivo e coloca na variavel linha
            String linha;

            //enquanto a linha tiver algum conteudo escrito
            //cria um vetor dados que recebe o conteudo da linha e divide ele onde encontra o ';'
            //Cria uma variavel nome e equipe, separa os dados do vetor pelo seu indice
            int cont =1;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(";");
                String nome = dados[0];
                String equipe = dados[1];
                System.out.println(cont + "- " + nome + " (Equipe: " + equipe + ")");
                cont ++ ;

            }

            System.out.printf("Aperte a tecla ENTER para voltar...");
            scanner.nextLine();
            leitor.close();
            limparTela();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        }
    }
    
    //Metodo para ja popular a lista assim que o programa for iniciado
    public static void popularLista(ArrayList<Piloto> lista) {
        try {
        BufferedReader leitor = new BufferedReader(new FileReader("piloto.txt"));
        String linha;

        while ((linha = leitor.readLine()) != null) {
            String[] dados = linha.split(";");
            String nome = dados[0];
            String equipe = dados[1];

            Piloto c = new Piloto(nome, equipe);
            lista.add(c);
            
        }

        leitor.close();
    } catch (IOException e) {
        System.out.println("Erro ao ler o arquivo.");
        e.printStackTrace();
        }
    }  
    
    //Escolhendo o piloto
    public static void editarPiloto(Scanner scanner, ArrayList<Piloto> lista) {
        if (lista.isEmpty()) {
            limparTela();
            System.out.println("Nenhum piloto cadastrado para editar.");
            return;

        } else {

            limparTela();
            System.out.println("Escolha o piloto para editar: ");

            for (int i = 0; i < lista.size(); i++) {
                Piloto p = lista.get(i);
                System.out.println((i + 1) + " - " + p.getNome() + " (Equipe: " + p.getEquipe() + ")" );
            }
            
            int escolha = scanner.nextInt();
            scanner.nextLine();
            if (escolha < 1 || escolha > lista.size()) {
                limparTela();
                System.out.println("Escolha inválida!");
                return;

            } 

            Piloto pilotoSelecionado = lista.get(escolha - 1);

            System.out.printf("Novo nome(Deixa em branco se não quiser alterar): " );
            String novoNome = scanner.nextLine();
            
            if (!novoNome.isEmpty() ) {
                pilotoSelecionado.setNome(novoNome);
            }

            System.out.printf("Nova Equipe(Deixe em branco se não quiser alterar): ");
            String novaEquipe = scanner.nextLine();

            if (!novaEquipe.isEmpty()) {
                pilotoSelecionado.setEquipe(novaEquipe);
            }

            try {
                FileWriter escritor = new FileWriter("piloto.txt");
            for (Piloto c : lista) {
                escritor.write(c.toString() + "\n");
            }
            limparTela();
            System.out.println("-------------------");
            System.out.println("Piloto Editado!");
            System.out.println("-------------------");
            escritor.close();
            } catch (IOException e){
                limparTela();
                System.out.println("Erro ao gravar no arquivo.");
                e.printStackTrace();

            }  
        }
    }

            // Excluir o piloto
    public static void excluirPiloto(Scanner scanner, ArrayList<Piloto> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum piloto cadastrado para excluir.");
            return;
        } 
        

        System.out.println("Escolha o piloto para excluir: ");
        for (int i = 0; i < lista.size(); i++) {
            Piloto p = lista.get(i);
            System.out.println((i + 1) + " - " + p.getNome() + " (Equipe: " + p.getEquipe() + ")" );
        }

        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha < 1 || escolha > lista.size()) {
            System.out.println("Opção inválida.");
            return;
        }else {
            Piloto pilotoRemovido = lista.remove(escolha - 1);
            try {
                FileWriter escritor = new FileWriter("piloto.txt");
                for (Piloto c : lista) {
                    escritor.write(c.toString() + "\n");
                }
                System.out.println("-------------------");
                System.out.println("Piloto " + pilotoRemovido.getNome() + " excluído com sucesso!");
                System.out.println("-------------------");
                escritor.close();

            } catch (IOException e){
                System.out.println("Erro ao gravar no arquivo.");
                e.printStackTrace();
            }  
        }     
    }
    
    public static void buscarPilotoPorID(Scanner scanner, ArrayList<Piloto> lista) {
        if (lista.isEmpty()) {
            limparTela();
            System.out.println("Nenhum piloto cadastrado.");
            return;
        }
        limparTela();
        System.out.printf("Digite o número do piloto (ID) ou '0' para voltar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (id == 0) {
            limparTela();
            return;

        } else if (id < 1 || id > lista.size()) {
            limparTela();
            System.out.println("ID inválido!");
            return;
        }
        
        Piloto p = lista.get(id - 1);
        System.out.println("Nome: " + p.getNome());
        System.out.println("Equipe: " + p.getEquipe());
    }
    
    public static void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
        System.out.println("Não foi possível limpar a tela.");
        
        }
    }
}