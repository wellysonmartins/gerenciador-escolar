/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
/**
 *
 * @author laboratorio
 */
public class ProdutoWS {
    private ProdutoRepository repository;
    
    ProdutoWS(ProdutoRepository produtoRepository) {
        this.repository = produtoRepository;
    }
    
    @RequestMapping(value = "/produto", method = RequestMethod.GET)
    public List<Produto> getTodosOsProdutos() {
        return repository.findAll();
    }
    
    @GetMapping("/produto/{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
}
