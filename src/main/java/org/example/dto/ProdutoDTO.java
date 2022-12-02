package org.example.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {
  
  private Long id;
  private String nome;
  private Double valor;
  private Boolean comprado;
  private Long categoria;

}
