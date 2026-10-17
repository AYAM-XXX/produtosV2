package com.loja.gerenciador_produtos.controller;

import com.loja.gerenciador_produtos.model.Produto;
import com.loja.gerenciador_produtos.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ControlerProduto {

    private final ProdutoService produtoService;

    public ControlerProduto(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto){
        return produtoService.salvar(produto);
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscaId(@PathVariable String id){
        return produtoService.procurarId(id);
    }

    @DeleteMapping("/{id}")
    public void deltarId(@PathVariable String id){
        produtoService.deletarId(id);
    }
}
