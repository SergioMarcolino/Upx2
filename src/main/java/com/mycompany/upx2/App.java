
package com.mycompany.upx2;
public class App {
    public static void main(String[] args) {
        ProfissionalDAO profissionalDAO = new ProfissionalDAO();

         
        Profissional profissionalAtualizado = new Profissional();
        profissionalAtualizado.setIdProfissional(2);// O ID do profissional a ser atualizado
        profissionalAtualizado.setNome("Romério da Silva ");
        profissionalAtualizado.setEspecialidade("Enfermeiro");
        profissionalAtualizado.setEmail("silva@outlook.com");
        profissionalAtualizado.setRg("1212121");
        profissionalAtualizado.setCpf("1212121");
        profissionalAtualizado.setTelefone("15-99188 ");
        profissionalAtualizado.setId_cidade(2);;
  
  
    
        // Atualizando o profissional no banco de dados

        Profissional profissional = profissionalDAO.buscarPorId(2);

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
    
    }

}