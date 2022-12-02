package org.example.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.example.dto.ProdutoDTO;
import org.example.input.ProdutoInput;
import org.example.model.Produto;
import org.example.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(tags = "Produtos")
@RestController
@RequestMapping(value = "/produtos")
public class ProdutosController {

  @Autowired
  private ProdutoService produtoService;

  @PostMapping(value = "/", produces = "application/json")
  public ResponseEntity<ProdutoDTO> novoProduto(@RequestBody ProdutoInput produto) {
    Produto produtoSalvo = produtoService.salvar(converteParaDomainObject(produto));
    ProdutoDTO produtoDTO = converteParaDTO(produtoSalvo);
    return new ResponseEntity<ProdutoDTO>(produtoDTO, HttpStatus.CREATED);
  }

  @GetMapping(value = "/{id_produto}")
  public ResponseEntity<ProdutoDTO> listaProdutosById(@PathVariable(value = "id_produto") long id_produto) {
    Produto produtos = produtoService.getProdutoById(id_produto);

    ProdutoDTO produtoDTO = converteParaDTO(produtos);

    return new ResponseEntity<ProdutoDTO>(produtoDTO, HttpStatus.OK);
  }

  @GetMapping(value = "/")
  public ResponseEntity<List<ProdutoDTO>> listaProdutos() {
    List<Produto> produtos = produtoService.getProdutos();

    List<ProdutoDTO> produtoDTO = converteParaCollectionModel(produtos);

    return new ResponseEntity<List<ProdutoDTO>>(produtoDTO, HttpStatus.OK);
  }

  @PutMapping(value = "/", produces = "application/json")
  public ResponseEntity<ProdutoDTO> atualizaProduto(@RequestBody ProdutoInput produto) {
    Produto produtoSalvo = produtoService.salvar(converteParaDomainObject(produto));
    ProdutoDTO produtoDTO = converteParaDTO(produtoSalvo);

    return new ResponseEntity<ProdutoDTO>(produtoDTO, HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/{id_produto}")
  public ResponseEntity<String> deletaProduto(@PathVariable(value = "id_produto") long id_produto) {
    produtoService.deletar(id_produto);
    return new ResponseEntity<String>("Produto deletado com sucesso!", HttpStatus.OK);
  }

 
  private ProdutoDTO converteParaDTO(Produto produto) {
    ProdutoDTO produtoDTO = new ProdutoDTO();
    produtoDTO.setId(produto.getId());
    produtoDTO.setNome(produto.getNome());
    produtoDTO.setValor(produto.getValor());
    produtoDTO.setComprado(produto.isComprado());
    produtoDTO.setCategoria(produto.getCategoria());
    return produtoDTO;
  }

  private List<ProdutoDTO> converteParaCollectionModel(List<Produto> produtos) {
    return produtos.stream()
        .map(produto -> converteParaDTO(produto))
        .collect(Collectors.toList());
  }

  private Produto converteParaDomainObject(ProdutoInput produtoInput) {
    Produto produto = new Produto();
    produto.setId(produtoInput.getId());
    produto.setNome(produtoInput.getNome());
    produto.setValor(produtoInput.getValor());
    produto.setComprado(produtoInput.isComprado());
    produto.setCategoria(produtoInput.getCategoria());
    return produto;
  }

}
