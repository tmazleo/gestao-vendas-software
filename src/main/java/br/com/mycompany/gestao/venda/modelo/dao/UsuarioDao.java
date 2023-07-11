/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mycompany.gestao.venda.modelo.dao;

import br.com.mycompany.gestao.venda.modelo.conexao.Conexao;
import br.com.mycompany.gestao.venda.modelo.conexao.ConexaoPostgre;
import br.com.mycompany.gestao.venda.modelo.dominio.Usuario;
import static java.lang.String.format;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author leoto
 */
public class UsuarioDao {
    private final Conexao conexao;
    
    public UsuarioDao() {
        this.conexao = new ConexaoPostgre();
    }
    
    public String salvar(Usuario usuario) {
        return usuario.getId() == 0L ? adicionar(usuario) : editar(usuario);
    }

    private String adicionar(Usuario usuario) {
        String sql = "INSERT INTO usuario(nome, usuario, senha, perfil, estado) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedSt = conexao.obterConexao().prepareStatement(sql);
            
            preencherValoresPreparedStatement(preparedSt, usuario);
            int resultado = preparedSt.executeUpdate();
            
            return resultado == 1 ? "Usuario adicionado com sucesso!" : "Não foi possivel adicionar!";
        }catch (SQLException e) {
            return String.format("Error: %5", e.getMessage());
        }
    }

    private String editar(Usuario usuario) {
        String sql = "UPDATE usuario SET nome = ?, usuario = ?, senha = ?, perfil = ?, estado = ?, WHERE id = ?";
        try {
            PreparedStatement preparedSt = conexao.obterConexao().prepareStatement(sql);
            
            preencherValoresPreparedStatement(preparedSt, usuario);
            int resultado = preparedSt.executeUpdate();
            
            return resultado == 1 ? "Usuario editado com sucesso!" : "Não foi possivel editar!";
        }catch (SQLException e) {
            return String.format("Error: %5", e.getMessage());
        }
    }

    private void preencherValoresPreparedStatement(PreparedStatement preparedSt, Usuario usuario) throws SQLException {
        preparedSt.setString(1, usuario.getNome());
        preparedSt.setString(2, usuario.getUsuario());
        preparedSt.setString(3, usuario.getSenha());
        preparedSt.setString(4, usuario.getPerfil().name());
        preparedSt.setBoolean(5, usuario.isEstado());
        
        if (usuario.getId() != 0L) {
            preparedSt.setLong(6, usuario.getId());
        }
    }
}
