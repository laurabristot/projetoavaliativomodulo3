package org.example.controllers;

import java.util.List;

import org.example.model.Produto;
import org.example.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(tags = "ProdutosVendidos")
@RestController
@RequestMapping(value = "/vendidos")
public class ProdutosVendidos {
  
  @Autowired
  private ProdutosRepository produtosRepository;

  @GetMapping(value = "/")
  public ResponseEntity<String> valorDasVendas() {
    List<Produto> produtos = produtosRepository.findAll();
    
    double valorTotal = 0;

    for (Produto produto : produtos) {
      if (produto.isComprado() == true){
        valorTotal += produto.getValor();
      }
    }


    return new ResponseEntity<String>("o Valor total das vendas é: R$" + valorTotal, HttpStatus.OK);
  }


}
