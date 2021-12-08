package com.Grupo1.G1Store.service;

import com.Grupo1.G1Store.model.Categoria;
import com.Grupo1.G1Store.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;
    //constructor
    //
    //
    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    //methods
    //
    //
    public List<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }

    public void cadastrarNovaCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public List<Categoria> buscarPorNome(String nome) {
        return categoriaRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Categoria buscarPorId(Long id){
        return categoriaRepository.findById(id).get();
    }

}
