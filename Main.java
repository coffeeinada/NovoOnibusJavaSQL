public class Main {
    public static void main(String[] args) {
        PassagemDAO passagemDAO = new PassagemDAO();
        
        try {
            // Criando uma nova passagem
            Passagem novaPassagem = new Passagem(0, "São Paulo", "Rio de Janeiro", "2024-12-01", 150.00);
            passagemDAO.inserirPassagem(novaPassagem);
            
            // Listando todas as passagens
            System.out.println("Lista de Passagens:");
            for (Passagem p : passagemDAO.listarPassagens()) {
                System.out.println(p.getId() + " | " + p.getOrigem() + " -> " + p.getDestino() + " | " + p.getData() + " | " + p.getPreco());
            }

            // Atualizando uma passagem
            novaPassagem.setPreco(160.00);
            passagemDAO.atualizarPassagem(novaPassagem);
            
            // Excluindo uma passagem
            passagemDAO.excluirPassagem(novaPassagem.getId());
            
        
           
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
