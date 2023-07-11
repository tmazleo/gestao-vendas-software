/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import br.com.mycompany.gestao.venda.modelo.conexao.Conexao;
import br.com.mycompany.gestao.venda.modelo.conexao.ConexaoPostgre;
import br.com.mycompany.gestao.venda.modelo.dominio.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author leoto
 */
public class Main {
    
    public static void main(String[] args) throws SQLException{
        String sql = "select * from categoria";
        Conexao conexao = new ConexaoPostgre();
        
        Categoria categoria = new Categoria(null, "Bebida java0000000", "Insercao no netbeans");
        String inserirSQL = "INSERT INTO categoria(nome, descricao) VALUES(?, ?)";
        PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(inserirSQL);
        

        preparedStatement.setString(1, categoria.getNome());
        preparedStatement.setString(2, categoria.getDescricao());
        
        int resultadoDoCadastro = preparedStatement.executeUpdate();
        System.out.println(resultadoDoCadastro);
        
        ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery(); //sempre que for listar os itens, usar esse bloco
        
        while(result.next()) {
            System.out.println(result.getString("nome"));
        }
    }
}
