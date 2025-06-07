
import java.util.Scanner;
import java.util.ArrayList;

public class Sistema {
    public static void main(String[] args) {
        //Criando a lista onde será armazenado os pilotos
        //E logo em seguida populando ela
        ArrayList<Piloto> pilotos = new ArrayList<>();
        PilotoController.popularLista(pilotos);
        Scanner scanner = new Scanner(System.in);

        boolean run = true;
        while (run) {
            System.out.println("##### Sistema de Gerenciamento ######");
            System.out.println("Selecione uma opção");
            System.out.println("1 - Adicionar Piloto");
            System.out.println("2 - Editar Piloto");
            System.out.println("3 - Listar Pilotos");
            System.out.println("4 - Excluir Piloto");
            System.out.println("0 - Sair");
            System.out.printf("- ");
            String op = scanner.nextLine();
            int opcao = Integer.parseInt(op);
            
            switch (opcao) {
                case 1:
                    PilotoController.cadastrarPiloto(scanner, pilotos);
                    break;

                case 2:
                    break;
                
                case 3:
                    PilotoController.listarPilotos(scanner, pilotos);
                    break;

                 case 4:
                    PilotoController.excluirPiloto(scanner, pilotos);
                    break;   

            }


        }


    }
    
}
