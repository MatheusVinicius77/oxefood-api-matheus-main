package br.com.ifpe.oxefood.modelo.comprador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CompradorService {

    @Autowired
    CompradorRepository repository;

    @Transactional
    public Comprador save(Comprador comprador) {
        comprador.setHabilitado(Boolean.TRUE);
        return repository.save(comprador);
    }

    public List<Comprador> listarTodos() {

        return repository.findAll();
    }

    public Comprador obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Comprador compradorAlterado) {

        Comprador comprador = repository.findById(id).get();

        if (compradorAlterado.getNome() != null)
            comprador.setNome(compradorAlterado.getNome());

        if (compradorAlterado.getComissao() != null)
            comprador.setComissao(compradorAlterado.getComissao()); // c18
        if (compradorAlterado.getContratadoEm() != null)
            comprador.setContratadoEm(compradorAlterado.getContratadoEm());
        if (compradorAlterado.getEnderecoComercial() != null)
            comprador.setEnderecoComercial(compradorAlterado.getEnderecoComercial());
        if (compradorAlterado.getEnderecoComercial() != null)
            comprador.setEnderecoResidencial(compradorAlterado.getEnderecoComercial());
        if (compradorAlterado.getContratadoEm() != null)
            comprador.setContratadoEm(compradorAlterado.getContratadoEm());

        if (compradorAlterado.getQtdComprasMediasMes() != null)
            comprador.setQtdComprasMediasMes((compradorAlterado.getQtdComprasMediasMes()));

        if (compradorAlterado.getNome() != null)
            comprador.setSegmento(compradorAlterado.getSegmento());
        repository.save(comprador);
    }

    @Transactional
    public void delete(Long id) {

        Comprador comprador = repository.findById(id).get();
        comprador.setHabilitado(Boolean.FALSE);// exclusão lógica - move o objeto para false tirando-o da consulta

        repository.save(comprador);// repository.delete faria a remoção fisica
    }
}
