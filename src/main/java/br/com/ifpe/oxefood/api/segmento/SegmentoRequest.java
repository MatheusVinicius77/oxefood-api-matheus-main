package br.com.ifpe.oxefood.api.segmento;

import br.com.ifpe.oxefood.modelo.segmento.Segmento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class SegmentoRequest {

    private String descricao;

    public Segmento build() {
        return Segmento.builder()
                .descricao(descricao)
                .build();
    }

}
