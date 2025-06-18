import java.util.Scanner;
import ConcreteStrategy.MySQL;
import ConcreteStrategy.SQLServer;
import Strategy.IBancoDados;
import Classes.Curso;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IBancoDados banco = null;
        Curso curso = null;

        while (true) {
            System.out.println("Escolha o banco: ");
            System.out.println("1. MySQL");
            System.out.println("2. SQL Server");
            System.out.print("Opção: ");
            int opcaoBanco = scanner.nextInt();
            scanner.nextLine();

            if (opcaoBanco == 1) {
                banco = new MySQL();
                System.out.println("Você selecionou MySQL.");
            } else if (opcaoBanco == 2) {
                banco = new SQLServer();
                System.out.println("Você selecionou SQLServer.");
            } else {
                System.out.println("Opção inválida.");
                continue;
            }

            banco.Instancia();
            curso = new Curso(banco);

            int opcao;
            do {
                System.out.println("\nAgora informe a operação que deseja executar:");
                System.out.println("1. Inserir curso");
                System.out.println("2. Consultar os cursos cadastrados");
                System.out.println("3. Alternar o banco de dados");
                System.out.println("0. Sair");
                System.out.print("Opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Nome do curso: ");
                        String nome = scanner.nextLine();

                        System.out.print("Carga horária do curso: ");
                        int cargaHoraria = scanner.nextInt();

                        System.out.print("Valor do curso: ");
                        float valor = scanner.nextFloat();
                        scanner.nextLine();

                        System.out.print("Descrição do curso: ");
                        String descricao = scanner.nextLine();

                        System.out.print("Publico alvo do curso: ");
                        String publicoalvo = scanner.nextLine();

                        curso.setNomecurso(nome);
                        curso.setCargahorariacurso(cargaHoraria);
                        curso.setValorcurso(valor);
                        curso.setDescricaocurso(descricao);
                        curso.setPublicoalvo(publicoalvo);

                        curso.InserirCurso();
                        System.out.println("Curso inserido com sucesso.");
                        break;

                    case 2:
                        List<Curso> cursos = curso.ConsultarCursos();
                        System.out.println("Cursos cadastrados:");
                        for (Curso c : cursos) {
                            System.out.println(c.getNomecurso() + " | " +
                                    c.getCargahorariacurso() + "h | R$" +
                                    c.getValorcurso() + " | " +
                                    c.getDescricaocurso()+ " | " +
                                    c.getPublicoalvo()
                            );
                        }
                        break;

                    case 3:
                        System.out.println("Voltando para seleção de banco...");
                        break;

                    case 0:
                        System.out.println("Encerrando...");
                        System.exit(0);

                    default:
                        System.out.println("Opção inválida.");
                }
            } while (opcao != 3);
        }
    }
}