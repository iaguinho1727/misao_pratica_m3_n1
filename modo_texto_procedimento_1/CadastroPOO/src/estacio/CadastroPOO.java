package estacio;

import java.util.ArrayList;
import java.util.Scanner;

import estacio.model.PessoaFisica;
import estacio.model.PessoaFisicaRepo;
import estacio.model.PessoaJuridica;
import estacio.model.PessoaJuridicaRepo;

public class CadastroPOO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Repositórios em memória:
        PessoaFisicaRepo pfRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pjRepo = new PessoaJuridicaRepo();
        
        int opcao;
        
        do {
            System.out.println("\n==================================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo Id");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("==================================");
            System.out.print("Escolha sua opção: ");
            
            opcao = sc.nextInt();
            sc.nextLine(); // Consome a quebra de linha
            
            switch (opcao) {
                case 1: {
                    // Incluir pessoa
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipo = sc.nextLine().toUpperCase();
                    
                    System.out.print("Digite o id da pessoa: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // limpar buffer
                    
                    System.out.println("Insira os dados...");
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    
                    if (tipo.equals("F")) {
                        System.out.print("CPF: ");
                        String cpf = sc.nextLine();
                        
                        System.out.print("Idade: ");
                        int idade = sc.nextInt();
                        sc.nextLine();
                        
                        PessoaFisica pf = new PessoaFisica(id, nome, cpf, idade);
                        pfRepo.inserir(pf);
                        System.out.println("Pessoa Física incluída com sucesso!");
                        
                    } else if (tipo.equals("J")) {
                        System.out.print("CNPJ: ");
                        String cnpj = sc.nextLine();
                        
                        PessoaJuridica pj = new PessoaJuridica(id, nome, cnpj);
                        pjRepo.inserir(pj);
                        System.out.println("Pessoa Jurídica incluída com sucesso!");
                    } else {
                        System.out.println("Opção inválida. Tente novamente.");
                    }
                    break;
                }
                
                case 2: {
                    // Alterar pessoa
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipo = sc.nextLine().toUpperCase();
                    
                    System.out.print("Digite o id da pessoa: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    
                    if (tipo.equals("F")) {
                        PessoaFisica pf = pfRepo.obter(id);
                        if (pf == null) {
                            System.out.println("Pessoa Física não encontrada.");
                        } else {
                            System.out.println("Dados atuais:");
                            pf.exibir();
                            
                            // Leitura dos novos dados
                            System.out.println("\nDigite novos valores...");
                            System.out.print("Nome: ");
                            String nomeNovo = sc.nextLine();
                            System.out.print("CPF: ");
                            String cpfNovo = sc.nextLine();
                            System.out.print("Idade: ");
                            int idadeNova = sc.nextInt();
                            sc.nextLine();
                            
                            // Atualiza o objeto e manda alterar
                            pf.setNome(nomeNovo);
                            pf.setCpf(cpfNovo);
                            pf.setIdade(idadeNova);
                            
                            pfRepo.alterar(pf);
                            System.out.println("Pessoa Física alterada com sucesso!");
                        }
                    } else if (tipo.equals("J")) {
                        PessoaJuridica pj = pjRepo.obter(id);
                        if (pj == null) {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        } else {
                            System.out.println("Dados atuais:");
                            pj.exibir();
                            
                            System.out.println("\nDigite novos valores...");
                            System.out.print("Nome: ");
                            String nomeNovo = sc.nextLine();
                            System.out.print("CNPJ: ");
                            String cnpjNovo = sc.nextLine();
                            
                            pj.setNome(nomeNovo);
                            pj.setCnpj(cnpjNovo);
                            
                            pjRepo.alterar(pj);
                            System.out.println("Pessoa Jurídica alterada com sucesso!");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                }
                
                case 3: {
                    // Excluir pessoa
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipo = sc.nextLine().toUpperCase();
                    
                    System.out.print("Digite o id da pessoa: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    
                    if (tipo.equals("F")) {
                        pfRepo.excluir(id);
                        System.out.println("Pessoa Física excluída (se existente).");
                    } else if (tipo.equals("J")) {
                        pjRepo.excluir(id);
                        System.out.println("Pessoa Jurídica excluída (se existente).");
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                }
                
                case 4: {
                    // Buscar pelo id e exibir
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipo = sc.nextLine().toUpperCase();
                    
                    System.out.print("Digite o id da pessoa: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    
                    if (tipo.equals("F")) {
                        PessoaFisica pf = pfRepo.obter(id);
                        if (pf == null) {
                            System.out.println("Pessoa Física não encontrada.");
                        } else {
                            pf.exibir();
                        }
                    } else if (tipo.equals("J")) {
                        PessoaJuridica pj = pjRepo.obter(id);
                        if (pj == null) {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        } else {
                            pj.exibir();
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                }
                
                case 5: {
                    // Exibir todos
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipo = sc.nextLine().toUpperCase();
                    
                    if (tipo.equals("F")) {
                        ArrayList<PessoaFisica> listaPf = pfRepo.obterTodos();
                        if (listaPf.isEmpty()) {
                            System.out.println("Não existem Pessoas Físicas cadastradas.");
                        } else {
                            for (PessoaFisica pf : listaPf) {
                                pf.exibir();
                                System.out.println("--------------------");
                            }
                        }
                    } else if (tipo.equals("J")) {
                        ArrayList<PessoaJuridica> listaPj = pjRepo.obterTodos();
                        if (listaPj.isEmpty()) {
                            System.out.println("Não existem Pessoas Jurídicas cadastradas.");
                        } else {
                            for (PessoaJuridica pj : listaPj) {
                                pj.exibir();
                                System.out.println("--------------------");
                            }
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                }
                
                case 6: {
                    // Persistir (salvar) em arquivo
                    System.out.print("Informe o prefixo para os arquivos: ");
                    String prefixo = sc.nextLine();
                    
                    try {
                        pfRepo.persistir(prefixo + ".fisica.bin");
                        pjRepo.persistir(prefixo + ".juridica.bin");
                        System.out.println("Dados salvos com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao salvar arquivos: " + e.getMessage());
                    }
                    break;
                }
                
                case 7: {
                    // Recuperar do arquivo
                    System.out.print("Informe o prefixo para os arquivos: ");
                    String prefixo = sc.nextLine();
                    
                    try {
                        pfRepo.recuperar(prefixo + ".fisica.bin");
                        pjRepo.recuperar(prefixo + ".juridica.bin");
                        System.out.println("Dados recuperados com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao recuperar arquivos: " + e.getMessage());
                    }
                    break;
                }
                
                case 0:
                    // Finalizar
                    System.out.println("Finalizando o programa...");
                    break;
                    
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            
        } while (opcao != 0);
        
        sc.close();
    }
}
