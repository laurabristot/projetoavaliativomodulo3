package org.example.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.example.dto.CategoriaDTO;
import org.example.input.CategoriaInput;
import org.example.model.Categoria;
import org.example.service.CategoriaService;
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

@Api(tags = "Categorias")
@RestController
@RequestMapping(value = "/categorias")
public class CategoriasController {

 
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<CategoriaDTO> novaCategoria (@RequestBody CategoriaInput categoria){
        Categoria categoriaSalva = categoriaService.salvar(converteParaDomainObject(categoria));
        CategoriaDTO categoriaDTO = converteParaDTO(categoriaSalva);

        return new ResponseEntity<CategoriaDTO>(categoriaDTO, HttpStatus.CREATED);  
    }

    @GetMapping (value = "/{id_categoria}")
    public ResponseEntity<CategoriaDTO> listaCategoriasById(@PathVariable(value = "id_categoria") long id_categoria){
        
        Categoria categoria = categoriaService.getCategoriaById(id_categoria);
   
        CategoriaDTO categoriaDTO = converteParaDTO(categoria);
        
        return new ResponseEntity<CategoriaDTO>(categoriaDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<CategoriaDTO>> listaCategorias(){
        
        List<Categoria> categoria = categoriaService.getCategorias();

        List<CategoriaDTO> categorias = converteParaCollectionModel(categoria);

        return new ResponseEntity<List<CategoriaDTO>>(categorias, HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<CategoriaDTO> atualizaCategoria (@RequestBody CategoriaInput categoria){
        Categoria categoriaSalva = categoriaService.salvar(converteParaDomainObject(categoria));
        CategoriaDTO categoriaDTO = converteParaDTO(categoriaSalva);

        return new ResponseEntity<CategoriaDTO>(categoriaDTO, HttpStatus.CREATED);  
    }

    @DeleteMapping(value = "/{id_categoria}")
    public ResponseEntity<String> deletaCategoria(@PathVariable(value = "id_categoria") long id_categoria){
       categoriaService.deletar(id_categoria);
        return new ResponseEntity<String>("Categoria deletada com sucesso!", HttpStatus.OK);
    }

    private CategoriaDTO converteParaDTO(Categoria categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setNome(categoria.getNome());
        categoriaDTO.setDescricao(categoria.getDescricao());

        return categoriaDTO;
    }

    private List<CategoriaDTO> converteParaCollectionModel(List<Categoria> categoriaDTO) {
        return categoriaDTO.stream()
                .map(categoria -> converteParaDTO(categoria))
                .collect(Collectors.toList());
    }


    private Categoria converteParaDomainObject(CategoriaInput categoriaInput) {
        Categoria categoria = new Categoria();
        categoria.setId(categoriaInput.getId());
        categoria.setNome(categoriaInput.getNome());
        categoria.setDescricao(categoriaInput.getDescricao());
        
        return categoria;
    }
}
