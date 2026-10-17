package com.loja.gerenciador_produtos.repository;

import com.loja.gerenciador_produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
