package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        itemList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itemsParaRemover = new ArrayList<>();
        for (Item i : itemList) {
            if (i.getNome().equalsIgnoreCase(nome)) {
                itemsParaRemover.add(i);
            }
        }
        itemList.removeAll(itemsParaRemover);
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Item i : itemList) {
            valorTotal += i.getPreco() * i.getQuantidade();
        }
        return valorTotal;
    }

    public void exibirItens() {
        System.out.println(itemList);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        System.out.println("O valor total no carrinho são: " + carrinho.calcularValorTotal());

        carrinho.adicionarItem("Coca Cola", 10.99, 3);
        carrinho.adicionarItem("Ruffles Churrasco", 8.99, 5);
        carrinho.adicionarItem("Pao de queijo 1Kg", 12.99, 2);

        carrinho.exibirItens();
        System.out.println("O valor total no carrinho são: " + carrinho.calcularValorTotal());

        carrinho.removerItem("Pao de queijo 1Kg");

        carrinho.exibirItens();
        System.out.println("O valor total no carrinho são: " + carrinho.calcularValorTotal());
    }

}
