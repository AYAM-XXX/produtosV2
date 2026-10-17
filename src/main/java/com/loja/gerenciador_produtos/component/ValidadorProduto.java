package com.loja.gerenciador_produtos.component;

import com.loja.gerenciador_produtos.model.Produto;
import com.loja.gerenciador_produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidadorProduto {
    public Boolean verificarNome(Produto produto){
        if(produto == null){
            return false;
        }
        if(produto.getNome() == null){
                return false;
            }
        if(produto.getNome().isBlank()){
            return false;
                }
        return true;

    }

    public Boolean verificarPreco(Produto produto){
        if (produto == null){
            return false;
        }
        if (produto.getPreco() == null){
            return false;
        }
        if (produto.getPreco().isNaN()){
            return false;
        }
        if (produto.getPreco().isInfinite()){
            return false;
        }
        if (produto.getPreco() <= 0){
            return false;
        }
        return true;
    }
}
