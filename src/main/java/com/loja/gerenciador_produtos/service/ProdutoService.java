package com.loja.gerenciador_produtos.service;

import com.loja.gerenciador_produtos.model.Produto;
import com.loja.gerenciador_produtos.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.loja.gerenciador_produtos.component.ValidadorProduto;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ValidadorProduto validador;
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ValidadorProduto validador, ProdutoRepository produtoRepository) {
        this.validador = validador;
        this.produtoRepository = produtoRepository;
    }


    public Produto salvar(Produto produto){
        if(!validador.verificarNome(produto)){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Nome do produto inválido"
            );
        }
        if (!validador.verificarPreco(produto)){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Preço invalido"
            );
        }

        return produtoRepository.save(produto);
    }

    public Optional<Produto> procurarId(String id){

        return produtoRepository.findById(id);
    }

    public void deletarId(String id){

        produtoRepository.deleteById(id);
    }

}

