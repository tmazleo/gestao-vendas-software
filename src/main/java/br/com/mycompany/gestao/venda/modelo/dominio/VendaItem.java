/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mycompany.gestao.venda.modelo.dominio;

import java.math.BigDecimal;

/**
 *
 * @author leoto
 */
public class VendaItem {
    
    private Venda venda;
    private Produto produto;
    private Integer quantidade;
    private BigDecimal total;
    private BigDecimal deconto;

    public VendaItem() {
    }

    public VendaItem(Venda venda, Produto produto, Integer quantidade, BigDecimal total, BigDecimal deconto) {
        this.venda = venda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.total = total;
        this.deconto = deconto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getDeconto() {
        return deconto;
    }

    public void setDeconto(BigDecimal deconto) {
        this.deconto = deconto;
    }
    
}
