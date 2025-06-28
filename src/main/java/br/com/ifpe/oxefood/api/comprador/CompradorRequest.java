package br.com.ifpe.oxefood.api.comprador;

import java.time.LocalDate;

import br.com.ifpe.oxefood.modelo.comprador.Comprador;
import br.com.ifpe.oxefood.modelo.segmento.Segmento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompradorRequest {

    private Long IdSegmento;

    private String nome;

    private String enderecoComercial;

    private String enderecoResidencial;

    private Double comissao;

    private Integer qtdComprasMediasMes;

    private LocalDate contratadoEm;

    public Comprador build() {
        return Comprador.builder()
                .nome(nome)
                .comissao(comissao)
                .contratadoEm(contratadoEm)
                .enderecoComercial(enderecoComercial)
                .enderecoResidencial(enderecoResidencial)
                .qtdComprasMediasMes(qtdComprasMediasMes)
                .build();
    }
}
