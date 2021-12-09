package com.Grupo1.G1Store.controller;


import com.Grupo1.G1Store.model.Categoria;
import com.Grupo1.G1Store.model.Produto;
import com.Grupo1.G1Store.service.CategoriaService;
import com.Grupo1.G1Store.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("https://g1-store.vercel.app/")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;
    private final CategoriaService categoriaService;

    //constructor
    //
    //
    @Autowired
    public ProdutoController(ProdutoService produtoService, CategoriaService categoriaService) {
        this.produtoService = produtoService;
        this.categoriaService = categoriaService;
    }

    //methods
    //
    //
    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodosProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarDadosDoProduto(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarDadosDoProdutoPorId(id));
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.cadastrarProduto(produto));
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> buscarTodosCategoria(){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.buscarTodos());
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity <Categoria> buscarPorId (@PathVariable Long id ){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.buscarPorId(id));
    }
}
