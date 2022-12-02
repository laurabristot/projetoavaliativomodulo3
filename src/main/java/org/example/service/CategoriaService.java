package org.example.service;

import java.util.List;

import org.example.model.Categoria;
import org.example.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoriaService {

  @Autowired
  private CategoriasRepository categoriasRepository;

  public Categoria salvar(Categoria categoria) {
    return categoriasRepository.save(categoria);
  }

  public void deletar(Long id_categoria) {
  categoriasRepository.deleteById(id_categoria);
  }

  public Categoria getCategoriaById(Long id_categoria) {
    return categoriasRepository.findById(id_categoria).get();

  }

  public List<Categoria> getCategorias() {
    return categoriasRepository.findAll();
  }

}
