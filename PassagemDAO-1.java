import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassagemDAO {

    public void inserirPassagem(Passagem passagem) throws SQLException {
        String sql = "INSERT INTO passagens (origem, destino, data, preco) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, passagem.getOrigem());
            stmt.setString(2, passagem.getDestino());
            stmt.setString(3, passagem.getData());
            stmt.setDouble(4, passagem.getPreco());
            stmt.executeUpdate();
        }
    }

    public List<Passagem> listarPassagens() throws SQLException {
        String sql = "SELECT * FROM passagens";
        List<Passagem> passagens = new ArrayList<>();
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Passagem passagem = new Passagem(
                        rs.getInt("id"),
                        rs.getString("origem"),
                        rs.getString("destino"),
                        rs.getString("data"),
                        rs.getDouble("preco"));
                passagens.add(passagem);
            }
        }
        return passagens;
    }

    public void atualizarPassagem(Passagem passagem) throws SQLException {
        String sql = "UPDATE passagens SET origem = ?, destino = ?, data = ?, preco = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, passagem.getOrigem());
            stmt.setString(2, passagem.getDestino());
            stmt.setString(3, passagem.getData());
            stmt.setDouble(4, passagem.getPreco());
            stmt.setInt(5, passagem.getId());
            stmt.executeUpdate();
        }
    }

    public void excluirPassagem(int id) throws SQLException {
        String sql = "DELETE FROM passagens WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
