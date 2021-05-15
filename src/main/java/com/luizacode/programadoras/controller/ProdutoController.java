package com.luizacode.programadoras.controller;
import com.luizacode.programadoras.repository.ProdutoRepository;
import  com.luizacode.programadoras.model.Produto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    //Metodo GET
    @GetMapping
    public List<Produto> listar(){
        return produtoRepository.findAll();
    };

    // Meotodo  lista um unico produto
    @GetMapping("/produtos/{id}")
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id){
        return produtoRepository.findByIdProduto(id);
    };

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // ao inves de retornar 200 vai retornar create quando inserir um cliente
    public Produto adicionar(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
    
}
