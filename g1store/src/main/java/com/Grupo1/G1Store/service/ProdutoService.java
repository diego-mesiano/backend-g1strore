package com.Grupo1.G1Store.service;

import com.Grupo1.G1Store.model.Produto;
import com.Grupo1.G1Store.repository.ProdutoRepository;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    //constructor
    //
    //
    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    //methods
    //
    //
    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }

    public Produto buscarDadosDoProdutoPorId(Long id){
        //precisa desse .get() n sei exatamente pq
        return produtoRepository.findById(id).get();
    }

    public Produto cadastrarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

}