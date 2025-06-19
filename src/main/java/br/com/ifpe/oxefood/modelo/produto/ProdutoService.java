package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto){
        produto.setHabilitado(Boolean.TRUE);
        return repository.save(produto);
    }

    public List<Produto> listarTodos() {
  
        return repository.findAll();
    }

    public Produto obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
   public void update(Long id, Produto produtoAlterado) {

      Produto produto = repository.findById(id).get();
      produto.setCategoria(produtoAlterado.getCategoria()); //c18  
      produto.setCodigo(produtoAlterado.getCodigo());
      produto.setTitulo(produtoAlterado.getTitulo());
      produto.setDescricao(produtoAlterado.getDescricao());
      produto.setValorUnitario(produtoAlterado.getValorUnitario());
      produto.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());
	    
      repository.save(produto);
  }

      @Transactional
    public void delete(Long id) {

       Produto produto = repository.findById(id).get();
       produto.setHabilitado(Boolean.FALSE);//exclusão lógica - move o objeto para false tirando-o da consulta

       repository.save(produto);// repository.delete faria a remoção fisica
   }


}
