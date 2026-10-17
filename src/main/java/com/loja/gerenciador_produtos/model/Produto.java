package com.loja.gerenciador_produtos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Produto {
    @Id
    private String id;
    private String nome;
    private Double preco;

    @PrePersist
    public void gerarID() {
        if (id == null || id.isBlank()) {
            id = UUID.randomUUID().toString();
        }
    }

}
