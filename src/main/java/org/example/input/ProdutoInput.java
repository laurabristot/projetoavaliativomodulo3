package org.example.input;

import org.example.model.Categoria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoInput {
    private Long id;
    private String nome;
    private double valor;
    private boolean comprado;
    private Categoria categoria;

}
