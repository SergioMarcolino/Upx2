
package com.mycompany.upx2;

import java.util.List;


public class App {
     public static void main(String[] args) {
        ProfissionalDAO profissionalDAO = new ProfissionalDAO();

        /*Profissional novoProfissional = new Profissional();
        novoProfissional.setNome("João da Silva");
        novoProfissional.setCpf("123.456.789-00");
        novoProfissional.setRg("MG-12.345.678");
        novoProfissional.setEspecialidade("Cardiologia");
        novoProfissional.setTelefone("(31) 98765-4321");
        novoProfissional.setEmail("joao.silva@example.com");
        novoProfissional.setId_cidade(3); // ID da cidade já existente no banco

        // Salvar no banco de dados
        try {
            profissionalDAO.salvar(novoProfissional);
            System.out.println("Profissional criado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao criar profissional: " + e.getMessage());
        }*/

         /* 
         Profissional profissionalAtualizado = new Profissional();
        profissionalAtualizado.setIdProfissional(1);
        profissionalAtualizado.setNome("Romério da Silva ");
        profissionalAtualizado.setEspecialidade("Enfermeiro");
        profissionalAtualizado.setEmail("silva@outlook.com");
        profissionalAtualizado.setRg("1212121");
        profissionalAtualizado.setCpf("1212121");
        profissionalAtualizado.setTelefone("15-99188 ");
        profissionalAtualizado.setId_cidade(3); 
  
        profissionalDAO.salvar(profissionalAtualizado);*/
    
        // Atualizando o profissional no banco de dados

        /*Profissional profissional = profissionalDAO.buscarPorId(2);

        if (profissional != null) {
            System.out.println("Profissional encontrado:");
            System.out.println("ID: " + profissional.getIdProfissional());
            System.out.println("Nome: " + profissional.getNome());
            System.out.println("CPF: " + profissional.getCpf());
            System.out.println("RG: " + profissional.getRg());
            System.out.println("Especialidade: " + profissional.getEspecialidade());
            System.out.println("Telefone: " + profissional.getTelefone());
            System.out.println("Email: " + profissional.getEmail());
            System.out.println("Id_Cidade: " + profissional.getId_cidade());
        } else {
            System.out.println("Nenhum profissional encontrado com o ID fornecido.");
        }
*/
       /*RiscoDAO riscoDAO = new RiscoDAO();
        Risco novoRisco = new Risco();
        novoRisco.setTipoRisco("Inundação");
    novoRisco.setNivelGravidade("alto");
        novoRisco.setDescricao("Risco de inundações em áreas ribeirinhas.");
        */

        //Salvar uma nova cidade
       /*  CidadeDAO cidadeDAO = new CidadeDAO();
        Cidade novaCidade = new Cidade();
        novaCidade.setNomeCidade("São Paulo");
        novaCidade.setFkIdEstado(1); // Substituir pelo ID do estado correspondente
        cidadeDAO.salvar(novaCidade);*/

       /*  EstadoDAO estadoDAO = new EstadoDAO();
        Estado novoEstado = new Estado();
        novoEstado.setNomeEstado("São Paulo");
        estadoDAO.salvar(novoEstado);*/

                AlocacaoDAO alocacaoDAO = new AlocacaoDAO();

        // Criando uma nova alocação
       /*  Alocacao novaAlocacao = new Alocacao();
        novaAlocacao.setDataAlocacao(LocalDate.now()); // Define a data atual para a alocação
        novaAlocacao.setFkIdRisco(5); // Substituir pelo ID de risco válido no banco de dados
        novaAlocacao.setIdCidade(3);

        // Salvar a nova alocação
        try {
            alocacaoDAO.salvar(novaAlocacao);
            System.out.println("Nova alocação adicionada com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao adicionar a alocação: " + e.getMessage());
        } */
        // Criando um profissional de exemplo
          ProfissionalAlocacaoDAO profissionalAlocacaoDAO = new ProfissionalAlocacaoDAO();

        // Criar objetos para testar a alocação
      /*   Profissional_Alocacao profissionalAlocacao1 = new Profissional_Alocacao();
        profissionalAlocacao1.setFkIdProfissional(1008);  // ID do profissional
        profissionalAlocacao1.setFkIdAlocacao(7);     // ID da alocação
        profissionalAlocacao1.setFkIdCidade(3);       // ID da cidade (exemplo)
        profissionalAlocacao1.setDataInicioAlocacao(LocalDate.of(2024, 12, 10));  // Data de início
        profissionalAlocacao1.setDataTerminoAlocacao(LocalDate.of(2024, 12, 15)); // Data de término
        
        // Testar a disponibilidade do profissional (verificando cidade também)
        boolean isDisponivel = profissionalAlocacaoDAO.verificarDisponibilidade(1008, LocalDate.of(2024, 12, 10), LocalDate.of(2024, 12, 15), 3);
        System.out.println("Profissional disponível para o período solicitado? " + (isDisponivel ? "Sim" : "Não"));
        
        // Caso esteja disponível, salvar a alocação
        if (isDisponivel) {
            profissionalAlocacaoDAO.salvar(profissionalAlocacao1);
            System.out.println("Profissional alocado com sucesso!");
        } else {
            System.out.println("Profissional não pode ser alocado. Verifique os dados.");
        }*/
        int idCidade = 3; // ID da cidade que você deseja consultar
        List<Profissional> profissionais = profissionalDAO.buscarPorCidade(idCidade);

        if (profissionais.isEmpty()) {
            System.out.println("Nenhum profissional encontrado para a cidade com ID: " + idCidade);
        } else {
        System.out.println("Profissionais encontrados:");
            for (Profissional profissional : profissionais) {
        System.out.println("ID: " + profissional.getIdProfissional() + ", Nome: " + profissional.getNome());
             }
        }
    }    
}


