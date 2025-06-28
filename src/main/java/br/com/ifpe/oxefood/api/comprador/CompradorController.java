package br.com.ifpe.oxefood.api.comprador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.api.comprador.CompradorRequest;
import br.com.ifpe.oxefood.modelo.comprador.Comprador;
import br.com.ifpe.oxefood.modelo.comprador.CompradorService;
import br.com.ifpe.oxefood.modelo.segmento.Segmento;
import br.com.ifpe.oxefood.modelo.segmento.SegmentoService;

@RestController
@RequestMapping("/api/comprador")
@CrossOrigin
public class CompradorController {

    @Autowired
    private CompradorService compradorService;

    @Autowired
    private SegmentoService segmentoService;

    @PostMapping
    public ResponseEntity<Comprador> save(@RequestBody CompradorRequest request) {

        Comprador compradorNovo = request.build();
        Segmento segmentoComprador = segmentoService.obterPorID(request.getIdSegmento());
        compradorNovo.setSegmento(segmentoComprador);
        Comprador comprador = compradorService.save(compradorNovo);

        return new ResponseEntity<Comprador>(comprador, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Comprador> listarTodos() {
        return compradorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Comprador obterPorID(@PathVariable Long id) {
        return compradorService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comprador> update(@PathVariable("id") Long id, @RequestBody CompradorRequest request) {

        Comprador comprador = request.build();
        Segmento segmentoComprador = segmentoService.obterPorID(request.getIdSegmento());

        comprador.setSegmento(segmentoComprador);

        compradorService.update(id, comprador);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        compradorService.delete(id);
        return ResponseEntity.ok().build();
    }
}
