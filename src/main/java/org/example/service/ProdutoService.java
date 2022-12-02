package org.example.service;

import java.util.List;

import org.example.model.Produto;
import org.example.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
  
  @Autowired
  private ProdutosRepository produtoRepository;
  
  public Produto salvar(Produto produto) {
    return produtoRepository.save(produto);
  }

  public void deletar(Long id_produto) {
    produtoRepository.deleteById(id_produto);
  }

  public Produto getProdutoById(Long id_produto) {
    return produtoRepository.findById(id_produto).get();
  }

  public List<Produto> getProdutos() {
    return produtoRepository.findAll();
  }
  
}
