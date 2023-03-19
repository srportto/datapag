package br.com.hmv.dtos.responses.emergencia;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoTraumaticoEmergenciaDefaultResponsetDTO {
    private static final long serialVersionUID = 1L;

    private Long id;

    @JsonProperty("descricao")
    private String descricao;
}
