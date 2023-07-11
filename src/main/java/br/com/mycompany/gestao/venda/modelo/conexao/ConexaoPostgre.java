/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mycompany.gestao.venda.modelo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

/**
 *
 * @author leoto
 */
public class ConexaoPostgre implements Conexao {

    private final String USUARIO = "postgres";
    private final String SENHA = "tmazleo";
    private final String URL = "jdbc:postgresql://localhost:5432/gestao_venda";
    private Connection conectar;
    @Override
    public Connection obterConexao() throws SQLException {
        
        if(conectar == null) {
            conectar = DriverManager.getConnection(URL, USUARIO, SENHA);
        }
        return conectar;
    }
    
}
