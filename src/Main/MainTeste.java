package Main;

import java.util.Scanner;

import Entidades.Atividade;
import Entidades.Instrutor;
import Entidades.Membro;
import Entidades.Plano;
import Entidades.Sala;
import Repositorio.AtividadeRepository;
import Repositorio.InstrutorRepository;
import Repositorio.MembroRepository;
import Repositorio.PlanoRepository;
import Repositorio.SalaRepository;
import Serviços.AtividadeService;
import Serviços.InstrutorService;
import Serviços.MembroService;
import Serviços.PlanoService;
import Serviços.SalaService;

public class MainTeste {
    private static Scanner scanner = new Scanner(System.in);

    private static MembroService membroService = new MembroService(new MembroRepository());
    private static PlanoService planoService = new PlanoService(new PlanoRepository());
    static AtividadeService atividadeService = new AtividadeService(new AtividadeRepository());
    static InstrutorService instrutorService = new InstrutorService(new InstrutorRepository());
    static SalaService salaService = new SalaService(new SalaRepository());

    public static void main(String[] args) {
        
        planoService.cadastrarPlano(new Plano("Semanal", "R$ 35,00", 35.00));
        planoService.cadastrarPlano(new Plano("Mensal", "R$ 100,00", 100.00));
        planoService.cadastrarPlano(new Plano("Anual", "R$ 1000,00", 1000.00));

        while (true) {
            System.out.println("Bem vindo ao menu de gerenciamento da academia:");
            System.out.println("1. Gerenciar Membros");
            System.out.println("2. Gerenciar Planos");
            System.out.println("3. Gerenciar Atividades");
            System.out.println("4. Gerenciar Instrutores");
            System.out.println("5. Gerenciar Salas");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    gerenciarMembros();
                    break;
                case 2:
                    gerenciarPlanos();
                    break;
                case 3:
                    gerenciarAtividades();
                    break;
                case 4:
                    gerenciarInstrutores();
                    break;
                case 5:
                    gerenciarSalas();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void gerenciarMembros() {
        System.out.println("Gerenciar Membros:");
        System.out.println("1. Cadastrar Membro");
        System.out.println("2. Buscar Membro");
        System.out.println("3. Atualizar Membro");
        System.out.println("4. Remover Membro");
        System.out.println("5. Listar Membros");

        int opcao = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcao) {
            case 1:
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Nome do Plano: ");
                String planoNome = scanner.nextLine();
                Plano plano = planoService.buscarPlano(planoNome);
                if (plano == null) {
                    System.out.println("Plano não encontrado. Cadastrar plano primeiro.");
                    break;
                }
                Membro novoMembro = new Membro(nome, cpf, nome, plano);
                membroService.cadastrarMembro(novoMembro);
                System.out.println("Membro cadastrado com sucesso!");
                break;
            case 2:
                System.out.print("ID: ");
                int id = scanner.nextInt();
                Membro membro = membroService.buscarMembro(id);
                if (membro != null) {
                    System.out.println("Nome: " + membro.getNome());
                    System.out.println("CPF: " + membro.getCpf());
                    System.out.println("Plano: " + membro.getPlano().getNome());
                } else {
                    System.out.println("Membro não encontrado.");
                }
                break;
            case 3:
                System.out.print("ID: ");
                id = scanner.nextInt();
                scanner.nextLine(); 
                membro = membroService.buscarMembro(id);
                if (membro != null) {
                    System.out.print("Nome: ");
                    nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    cpf = scanner.nextLine();
                    System.out.print("Nome do Plano: ");
                    planoNome = scanner.nextLine();
                    plano = planoService.buscarPlano(planoNome);
                    if (plano == null) {
                        System.out.println("Plano não encontrado. Cadastrar plano primeiro.");
                        break;
                    }
                    membro.setNome(nome);
                    membro.setCpf(cpf);
                    membro.setPlano(plano);
                    membroService.atualizarMembro(membro);
                    System.out.println("Membro atualizado com sucesso!");
                } else {
                    System.out.println("Membro não encontrado.");
                }
                break;
            case 4:
                System.out.print("ID: ");
                id = scanner.nextInt();
                scanner.nextLine(); 
                membroService.removerMembro(id);
                System.out.println("Membro removido com sucesso!");
                break;
            case 5:
                for (Membro m : membroService.listarMembros()) {
                    System.out.println("ID: " + m.getId() + ", Nome: " + m.getNome() + ", CPF: " + m.getCpf()
                            + ", Plano: " + m.getPlano().getNome());
                }
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private static void gerenciarPlanos() {
        System.out.println("Gerenciar Planos:");
        System.out.println("1. Cadastrar Plano");
        System.out.println("2. Buscar Plano");
        System.out.println("3. Atualizar Plano");
        System.out.println("4. Remover Plano");
        System.out.println("5. Listar Planos");

        int opcao = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcao) {
            case 1:
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Descrição: ");
                String descricao = scanner.nextLine();
                System.out.print("Valor: ");
                double valor = scanner.nextDouble();
                scanner.nextLine(); 
                Plano novoPlano = new Plano(nome, descricao, valor);
                planoService.cadastrarPlano(novoPlano);
                System.out.println("Plano cadastrado com sucesso!");
                break;
            case 2:
                System.out.print("Nome: ");
                nome = scanner.nextLine();
                Plano plano = planoService.buscarPlano(nome);
                if (plano != null) {
                    System.out.println("Nome: " + plano.getNome());
                    System.out.println("Descrição: " + plano.getDescricao());
                    System.out.println("Valor: " + plano.getValor());
                } else {
                    System.out.println("Plano não encontrado.");
                }
                break;
            case 3:
                System.out.print("Nome: ");
                nome = scanner.nextLine();
                plano = planoService.buscarPlano(nome);
                if (plano != null) {
                    System.out.print("Nova Descrição: ");
                    String descricao1 = scanner.nextLine();
                    System.out.print("Novo Valor: ");
                    double valor1 = scanner.nextDouble();
                    scanner.nextLine(); 
                    plano.setDescricao(descricao1);
                    plano.setValor(valor1);
                    planoService.atualizarPlano(plano);
                    System.out.println("Plano atualizado com sucesso!");
                } else {
                    System.out.println("Plano não encontrado.");
                }
                break;
            case 4:
                System.out.print("Nome: ");
                nome = scanner.nextLine();
                planoService.removerPlano(nome);
                System.out.println("Plano removido com sucesso!");
                break;
            case 5:
                for (Plano p : planoService.listarPlanos()) {
                    System.out.println(
                            "Nome: " + p.getNome() + ", Descrição: " + p.getDescricao() + ", Valor: " + p.getValor());
                }
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private static void gerenciarAtividades() {
        System.out.println("Gerenciar Atividades:");
        System.out.println("1. Cadastrar Atividade");
        System.out.println("2. Buscar Atividade");
        System.out.println("3. Atualizar Atividade");
        System.out.println("4. Remover Atividade");
        System.out.println("5. Listar Atividades");

        int opcao = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcao) {
            case 1:
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Instrutor: ");
                String instrutor = scanner.nextLine();
                Atividade novaAtividade = new Atividade(nome, instrutor);
                atividadeService.cadastrarAtividade(novaAtividade);
                System.out.println("Atividade cadastrada com sucesso!");
                break;
            case 2:
                System.out.print("Nome: ");
                nome = scanner.nextLine();
                Atividade atividade = atividadeService.buscarAtividade(nome);
                if (atividade != null) {
                    System.out.println("Nome: " + atividade.getNome());
                    System.out.println("Instrutor: " + atividade.getInstrutor());
                } else {
                    System.out.println("Atividade não encontrada.");
                }
                break;
            case 3:
                System.out.print("Nome: ");
                nome = scanner.nextLine();
                atividade = atividadeService.buscarAtividade(nome);
                if (atividade != null) {
                    System.out.print("Nova Descrição: ");
                    String descricao = scanner.nextLine();
                    atividade.setDescricao(descricao);
                    atividadeService.atualizarAtividade(atividade);
                    System.out.println("Atividade atualizada com sucesso!");
                } else {
                    System.out.println("Atividade não encontrada.");
                }
                break;
            case 4:
                System.out.print("Nome: ");
                nome = scanner.nextLine();
                atividadeService.removerAtividade(nome);
                System.out.println("Atividade removida com sucesso!");
                break;
            case 5:
                for (Atividade a : atividadeService.listarAtividades()) {
                    System.out.println("Nome: " + a.getNome() + ", Descrição: " + a.getDescricao());
                }
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private static void gerenciarInstrutores() {
        {
            System.out.println("Gerenciar Instrutores:");
            System.out.println("1. Cadastrar Instrutor");
            System.out.println("2. Buscar Instrutor");
            System.out.println("3. Atualizar Instrutor");
            System.out.println("4. Remover Instrutor");
            System.out.println("5. Listar Instrutores");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Especialidade: ");
                    String especialidade = scanner.nextLine();
                    Instrutor novoInstrutor = new Instrutor(nome, cpf, especialidade);
                    instrutorService.cadastrarInstrutor(novoInstrutor);
                    System.out.println("Instrutor cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.print("CPF: ");
                    cpf = scanner.nextLine();
                    Instrutor instrutor = instrutorService.buscarInstrutor(cpf);
                    if (instrutor != null) {
                        System.out.println("Nome: " + instrutor.getNome());
                        System.out.println("CPF: " + instrutor.getCpf());
                        System.out.println("Especialidade: " + instrutor.getEspecialidade());
                    } else {
                        System.out.println("Instrutor não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("CPF: ");
                    cpf = scanner.nextLine();
                    instrutor = instrutorService.buscarInstrutor(cpf);
                    if (instrutor != null) {
                        System.out.print("Nome: ");
                        nome = scanner.nextLine();
                        System.out.print("Especialidade: ");
                        String especialidade1 = scanner.nextLine();
                        instrutor.setNome(nome);
                        instrutor.setEspecialidade(especialidade1);
                        instrutorService.atualizarInstrutor(instrutor);
                        System.out.println("Instrutor atualizado com sucesso!");
                    } else {
                        System.out.println("Instrutor não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("CPF: ");
                    cpf = scanner.nextLine();
                    instrutorService.removerInstrutor(cpf);
                    System.out.println("Instrutor removido com sucesso!");
                    break;
                case 5:
                    for (Instrutor i : instrutorService.listarInstrutores()) {
                        System.out.println("Nome: " + i.getNome() + ", CPF: " + i.getCpf() + ", Especialidade: "
                                + i.getEspecialidade());
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void gerenciarSalas() {
        System.out.println("Gerenciar Salas:");
        System.out.println("1. Cadastrar Sala");
        System.out.println("2. Buscar Sala");
        System.out.println("3. Atualizar Sala");
        System.out.println("4. Remover Sala");
        System.out.println("5. Listar Salas");

        int opcao = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcao) {
            case 1:
                System.out.print("Número: ");
                int numero = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Capacidade: ");
                int capacidade = scanner.nextInt();
                scanner.nextLine(); 
                Sala novaSala = new Sala(numero, capacidade);
                salaService.cadastrarSala(novaSala);
                System.out.println("Sala cadastrada com sucesso!");
                break;
            case 2:
                System.out.print("Número: ");
                numero = scanner.nextInt();
                scanner.nextLine();
                Sala sala = salaService.buscarSala(numero);
                if (sala != null) {
                    System.out.println("Número: " + sala.getNumero());
                    System.out.println("Capacidade: " + sala.getCapacidade());
                } else {
                    System.out.println("Sala não encontrada.");
                }
                break;
            case 3:
                System.out.print("Número: ");
                numero = scanner.nextInt();
                scanner.nextLine(); 
                sala = salaService.buscarSala(numero);
                if (sala != null) {
                    System.out.print("Nova Capacidade: ");
                    capacidade = scanner.nextInt();
                    scanner.nextLine(); 
                    sala.setCapacidade(capacidade);
                    salaService.atualizarSala(sala);
                    System.out.println("Sala atualizada com sucesso!");
                } else {
                    System.out.println("Sala não encontrada.");
                }
                break;
            case 4:
                System.out.print("Número: ");
                numero = scanner.nextInt();
                scanner.nextLine(); 
                salaService.removerSala(numero);
                System.out.println("Sala removida com sucesso!");
                break;
            case 5:
                for (Sala s : salaService.listarSalas()) {
                    System.out.println("Número: " + s.getNumero() + ", Capacidade: " + s.getCapacidade());
                }
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public static AtividadeService getAtividadeService() {
        return atividadeService;
    }

    public static void setAtividadeService(AtividadeService atividadeService) {
        MainTeste.atividadeService = atividadeService;
    }

    public static InstrutorService getInstrutorService() {
        return instrutorService;
    }

    public static void setInstrutorService(InstrutorService instrutorService) {
        MainTeste.instrutorService = instrutorService;
    }

    public static SalaService getSalaService() {
        return salaService;
    }

    public static void setSalaService(SalaService salaService) {
        MainTeste.salaService = salaService;
    }
}
