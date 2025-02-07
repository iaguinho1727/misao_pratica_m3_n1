/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estacio;


import estacio.model.PessoaFisica;
import estacio.model.PessoaJuridica;
import estacio.model.PessoaFisicaRepo;
import estacio.model.PessoaJuridicaRepo;
import java.io.IOException;

/**
 *
 * @author iago
 */
public class CadastroPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            String arquivo_pessoa_fisica="pessoas_fisicas.dat";

            repo1.inserir(new PessoaFisica(1, "Ana",    "11111111111", 25));
            repo1.inserir(new PessoaFisica(2, "Carlos", "22222222222", 52));

            repo1.persistir(arquivo_pessoa_fisica);
            System.out.println("Dados de Pessoa Fisica Armazenados.");
            

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar(arquivo_pessoa_fisica);
            System.out.println("Dados de Pessoa Fisica Recuperados.");
            

            for (PessoaFisica pf : repo2.obterTodos()) {
                pf.exibir();
            }
            

            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

            repo3.inserir(new PessoaJuridica(3, "XPTO Sales",      "333333333333"));
            repo3.inserir(new PessoaJuridica(4, "XPTO Solutions",  "444444444444"));
            String arquivo_pessoa_juridica="pessoas_juridicas.dat";
            repo3.persistir(arquivo_pessoa_juridica);
            System.out.println("\nDados de Pessoa Juridica Armazenados.");
            
            // 4. Novo repositório (repo4) para recuperar os dados
            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar(arquivo_pessoa_juridica);
            System.out.println("Dados de Pessoa Juridica Recuperados.");
            
            // Exibir dados recuperados
            for (PessoaJuridica pj : repo4.obterTodos()) {
                pj.exibir();
            }
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
    
}
